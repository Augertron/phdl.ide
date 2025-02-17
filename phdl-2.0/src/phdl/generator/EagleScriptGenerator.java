/*
 * Copyright (C) 2011 Brigham Young University This program is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 3. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package phdl.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import phdl.graph.Attribute;
import phdl.graph.Connection;
import phdl.graph.Design;
import phdl.graph.Instance;
import phdl.graph.Net;
import phdl.graph.Node;
import phdl.graph.Pin;

public class EagleScriptGenerator {
	private final Design design;
	private String contents;
	private final TreeMap<String, ArrayList<Instance>> groupMap;
	private final StringBuilder sb;
	private final List<Node> signals;

	// board grid constraints
	private final double xSpacing = 0.25;
	private final double ySpacing = 0.5;
	private final int xMax = 30;
	private final int yMax = 30;

	/**
	 * Default constructor.
	 * 
	 * Takes a design and a map of the reference designators and generates the Eagle script.
	 * 
	 * @param design
	 *            the DesignNode where all the net information is stored.
	 * @param refMap
	 *            the map of Reference Designators needed to generated the Eagle script.
	 * 
	 * @see Design
	 * @see RefDesGenerator
	 */
	public EagleScriptGenerator(Design design) {
		this.design = design;
		this.groupMap = new TreeMap<String, ArrayList<Instance>>();
		this.sb = new StringBuilder();
		this.signals = new ArrayList<Node>();
		generate();
	}

	private void addInstance(Instance i, double x, double y) {
		// find the instance's library attribute
		String lib = "";
		if (i.getAttribute("LIBNAME") != null) {
			lib = i.getAttribute("LIBNAME").getValue();
			sb.append("ADD " + i.getPackage() + "@" + lib + " '" + i.getRefDes() + "' (" + x + " " + y + ");\n");
		} else
			System.err.println("ERROR: libName attribute undeclared: " + i.getName());

	}

	private void attribute(Attribute a) {
		String refDes = ((Instance) a.getParent()).getRefDes();
		sb.append("ATTRIBUTE " + refDes + " " + a.getName() + " '" + a.getValue() + "';\n");
	}

	private void delete(Instance i) {
		sb.append("DELETE " + i.getRefDes() + ";\n");
	}

	private void generate() {

		sb.append("# Auto-generated EAGLE PCB script from: " + design.getFileName() + "\n");
		sb.append("SET UNDO_LOG OFF;\n");
		sb.append("GRID INCH;\n");
		sb.append("CHANGE DISPLAY OFF;\n");
		sb.append("CHANGE SIZE 0.25;\n");

		sb.append("# Initial Build.\n\n");
		// sort the instances into their groups
		for (Instance i : design.getInstances()) {
			if (i.getGroupName() != null) {
				if (groupMap.containsKey(i.getGroupName())) {
					groupMap.get(i.getGroupName()).add(i);
				} else {
					ArrayList<Instance> l = new ArrayList<Instance>();
					l.add(i);
					groupMap.put(i.getGroupName(), l);
				}
			} else {
				if (groupMap.containsKey("")) {
					groupMap.get("").add(i);
				} else {
					ArrayList<Instance> l = new ArrayList<Instance>();
					l.add(i);
					groupMap.put("", l);
				}
			}
		}

		// grid placement coordinates
		double x = 0;
		double y = 2;

		// place each group on its own line, each line at one inch
		// increments
		sb.append("# Added parts #\n\n");
		sb.append("CHANGE LAYER 20; #the layer that group text will appear\n");
		for (String g : groupMap.keySet()) {
			// generate a label for the group and place it 4 inches to the
			// left of each group
			sb.append("TEXT '" + g + "' (" + -4 + " " + y + ");\n");

			ArrayList<Instance> group = groupMap.get(g);
			for (Instance i : group) {

				addInstance(i, x, y);
				setValue(i);
				x += xSpacing;

				// set the special instance name and device name attributes
				sb.append("ATTRIBUTE " + i.getRefDes() + " INST_NAME '" + i.getName() + "';\n");
				sb.append("ATTRIBUTE " + i.getRefDes() + " DEV_NAME '" + i.getDevice().getName() + "';\n");

				// add all the attributes except "values"
				for (Attribute a : i.getAttributes()) {
					if (!a.getName().equals("VALUE"))
						attribute(a);
				}

				// increment y and reset x if too close to edge board space
				if (x > xMax) {
					x = 0;
					y += ySpacing;
				}
			}
			// reset x for every group
			x = 0;

			// reset y if too close to edge of board space, otherwise
			// increment for every group
			if (y > yMax)
				y = 0;
			else
				y += ySpacing;
		}

		sb.append("\n# SIGNALS #\n\n");

		// assign all the nets
		for (Net n : design.getNets()) {

			// ignore the open net
			if (n.getName().equals("OPEN"))
				continue;

			signal(n);

		}
		sb.append("SET UNDO_LOG ON;\n");
		sb.append("RATSNEST;\n\n");
		sb.append("# End Script #\n");
		contents = sb.toString();
	}

	/**
	 * Returns the eagleScript string.
	 * 
	 * @return a string representation of the eagleScript
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * Generates an .asc file representation of the eagleScript.
	 * 
	 * @param fileName
	 *            the name of the file to write to
	 */
	public void outputToFile(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(contents);
			out.close();
		} catch (IOException e) {
			System.err.println("File Reading Error - filename may be corrupt");
			System.exit(1);
		}
		System.out.println("  -- Generated: " + DirectoryCodes.SEPARATOR + fileName);
	}

	private void replacePackage(Attribute a) {
		String refDes = ((Instance) a.getParent()).getRefDes();
		String lib = ((Instance) a.getParent()).getAttribute("LIBNAME").getValue();
		sb.append("REPLACE " + refDes + " '" + a.getValue() + "@" + lib + "';\n");
	}

	private void setValue(Instance i) {
		Attribute a = i.getAttribute("VALUE");
		if (a != null) {
			sb.append("VALUE " + i.getRefDes() + " " + a.getValue() + ";\n");
		}
	}

	private void signal(Connection connection) {
		sb.append("SIGNAL " + connection.getName().toUpperCase());
		for (Pin p : connection.getPins()) {
			String refDes = ((Instance) p.getParent()).getRefDes();
			sb.append(" " + refDes + " " + p.getName());
		}
		sb.append(";\n");
	}
}
