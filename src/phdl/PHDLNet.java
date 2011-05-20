package phdl;

import java.util.HashSet;

public class PHDLNet {
	private String name;
	private PHDLPinType type;
	private HashSet<PHDLPin> pins;

	public PHDLNet(String name) {
		this.name = name;
	}

	public PHDLNet(String name, PHDLPinType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PHDLPinType getType() {
		return type;
	}

	public void setType(PHDLPinType type) {
		this.type = type;
	}

	public HashSet<PHDLPin> getPins() {
		return pins;
	}

	public void addPin(PHDLPin p) {
		pins.add(p);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
