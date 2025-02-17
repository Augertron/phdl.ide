package edu.byu.ee.phdl.ui.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;

import com.google.inject.Inject;

public class FilterSubdesignsContribution extends AbstractFilterOutlineContribution {

	public static final String PREFERENCE_KEY = "ui.outline.filterSubdesigns";

	@Inject
	private PluginImageHelper imageHelper;

	@Override
	protected boolean apply(IOutlineNode node) {
		return !(node.getText().toString().equals("SubDesigns"));
	}

	@Override
	protected void configureAction(Action action) {
		action.setText("Filter subdesign declarations");
		action.setDescription("Filter subdesign declarations");
		action.setToolTipText("Filter subdesign declarations");
		action.setImageDescriptor(ImageDescriptor.createFromImage(imageHelper.getImage("SubDesign.gif")));
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

}
