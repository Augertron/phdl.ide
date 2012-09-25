/*
* generated by Xtext
*/
package edu.byu.ee.phdl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import edu.byu.ee.phdl.services.PhdlGrammarAccess;

public class PhdlParser extends AbstractContentAssistParser {
	
	@Inject
	private PhdlGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected edu.byu.ee.phdl.ui.contentassist.antlr.internal.InternalPhdlParser createParser() {
		edu.byu.ee.phdl.ui.contentassist.antlr.internal.InternalPhdlParser result = new edu.byu.ee.phdl.ui.contentassist.antlr.internal.InternalPhdlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getPhdlModelAccess().getAlternatives_1(), "rule__PhdlModel__Alternatives_1");
					put(grammarAccess.getPackageAccess().getAlternatives_4(), "rule__Package__Alternatives_4");
					put(grammarAccess.getDeviceElementAccess().getAlternatives(), "rule__DeviceElement__Alternatives");
					put(grammarAccess.getDesignAccess().getAlternatives_0(), "rule__Design__Alternatives_0");
					put(grammarAccess.getDesignElementAccess().getAlternatives(), "rule__DesignElement__Alternatives");
					put(grammarAccess.getConnectionAccess().getAlternatives(), "rule__Connection__Alternatives");
					put(grammarAccess.getConnectionAccess().getAlternatives_0_4(), "rule__Connection__Alternatives_0_4");
					put(grammarAccess.getConnectionAccess().getAlternatives_1_4(), "rule__Connection__Alternatives_1_4");
					put(grammarAccess.getNetElementAccess().getAlternatives(), "rule__NetElement__Alternatives");
					put(grammarAccess.getInstanceAccess().getAlternatives(), "rule__Instance__Alternatives");
					put(grammarAccess.getInstanceElementAccess().getAlternatives(), "rule__InstanceElement__Alternatives");
					put(grammarAccess.getSubInstanceElementAccess().getAlternatives(), "rule__SubInstanceElement__Alternatives");
					put(grammarAccess.getPinAssignAccess().getAlternatives_0(), "rule__PinAssign__Alternatives_0");
					put(grammarAccess.getPortAssignAccess().getAlternatives_0(), "rule__PortAssign__Alternatives_0");
					put(grammarAccess.getConcatenationAccess().getAlternatives(), "rule__Concatenation__Alternatives");
					put(grammarAccess.getIndicesAccess().getAlternatives_1(), "rule__Indices__Alternatives_1");
					put(grammarAccess.getSlicesAccess().getAlternatives_1(), "rule__Slices__Alternatives_1");
					put(grammarAccess.getReferenceableAccess().getAlternatives(), "rule__Referenceable__Alternatives");
					put(grammarAccess.getAssignableAccess().getAlternatives(), "rule__Assignable__Alternatives");
					put(grammarAccess.getPhdlIDAccess().getAlternatives(), "rule__PhdlID__Alternatives");
					put(grammarAccess.getPinTypeAccess().getAlternatives(), "rule__PinType__Alternatives");
					put(grammarAccess.getPhdlModelAccess().getGroup(), "rule__PhdlModel__Group__0");
					put(grammarAccess.getPackageAccess().getGroup(), "rule__Package__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getDeviceAccess().getGroup(), "rule__Device__Group__0");
					put(grammarAccess.getAttrAccess().getGroup(), "rule__Attr__Group__0");
					put(grammarAccess.getPinAccess().getGroup(), "rule__Pin__Group__0");
					put(grammarAccess.getPinAccess().getGroup_5(), "rule__Pin__Group_5__0");
					put(grammarAccess.getPinAccess().getGroup_5_1(), "rule__Pin__Group_5_1__0");
					put(grammarAccess.getInfoAccess().getGroup(), "rule__Info__Group__0");
					put(grammarAccess.getDesignAccess().getGroup(), "rule__Design__Group__0");
					put(grammarAccess.getConnectionAccess().getGroup_0(), "rule__Connection__Group_0__0");
					put(grammarAccess.getConnectionAccess().getGroup_0_3(), "rule__Connection__Group_0_3__0");
					put(grammarAccess.getConnectionAccess().getGroup_0_4_0(), "rule__Connection__Group_0_4_0__0");
					put(grammarAccess.getConnectionAccess().getGroup_1(), "rule__Connection__Group_1__0");
					put(grammarAccess.getConnectionAccess().getGroup_1_3(), "rule__Connection__Group_1_3__0");
					put(grammarAccess.getConnectionAccess().getGroup_1_4_0(), "rule__Connection__Group_1_4_0__0");
					put(grammarAccess.getInstanceAccess().getGroup_0(), "rule__Instance__Group_0__0");
					put(grammarAccess.getInstanceAccess().getGroup_1(), "rule__Instance__Group_1__0");
					put(grammarAccess.getRefAttrAccess().getGroup(), "rule__RefAttr__Group__0");
					put(grammarAccess.getPinAssignAccess().getGroup(), "rule__PinAssign__Group__0");
					put(grammarAccess.getPinAssignAccess().getGroup_0_0(), "rule__PinAssign__Group_0_0__0");
					put(grammarAccess.getPinAssignAccess().getGroup_0_1(), "rule__PinAssign__Group_0_1__0");
					put(grammarAccess.getSubAttrAccess().getGroup(), "rule__SubAttr__Group__0");
					put(grammarAccess.getRefTailAccess().getGroup(), "rule__RefTail__Group__0");
					put(grammarAccess.getPortAssignAccess().getGroup(), "rule__PortAssign__Group__0");
					put(grammarAccess.getPortAssignAccess().getGroup_0_0(), "rule__PortAssign__Group_0_0__0");
					put(grammarAccess.getPortAssignAccess().getGroup_0_1(), "rule__PortAssign__Group_0_1__0");
					put(grammarAccess.getConnectionAssignAccess().getGroup(), "rule__ConnectionAssign__Group__0");
					put(grammarAccess.getConcatenationAccess().getGroup_0(), "rule__Concatenation__Group_0__0");
					put(grammarAccess.getConcatenationAccess().getGroup_0_2(), "rule__Concatenation__Group_0_2__0");
					put(grammarAccess.getConcatenationAccess().getGroup_1(), "rule__Concatenation__Group_1__0");
					put(grammarAccess.getConcatenationAccess().getGroup_1_1(), "rule__Concatenation__Group_1_1__0");
					put(grammarAccess.getConcatenationAccess().getGroup_2(), "rule__Concatenation__Group_2__0");
					put(grammarAccess.getConcatenationAccess().getGroup_3(), "rule__Concatenation__Group_3__0");
					put(grammarAccess.getConnectionRefAccess().getGroup(), "rule__ConnectionRef__Group__0");
					put(grammarAccess.getIndicesAccess().getGroup(), "rule__Indices__Group__0");
					put(grammarAccess.getIndicesAccess().getGroup_1_0(), "rule__Indices__Group_1_0__0");
					put(grammarAccess.getIndicesAccess().getGroup_1_1(), "rule__Indices__Group_1_1__0");
					put(grammarAccess.getIndicesAccess().getGroup_1_1_1(), "rule__Indices__Group_1_1_1__0");
					put(grammarAccess.getSlicesAccess().getGroup(), "rule__Slices__Group__0");
					put(grammarAccess.getSlicesAccess().getGroup_1_0(), "rule__Slices__Group_1_0__0");
					put(grammarAccess.getSlicesAccess().getGroup_1_1(), "rule__Slices__Group_1_1__0");
					put(grammarAccess.getSlicesAccess().getGroup_1_1_1(), "rule__Slices__Group_1_1_1__0");
					put(grammarAccess.getVectorAccess().getGroup(), "rule__Vector__Group__0");
					put(grammarAccess.getVectorAccess().getGroup_1(), "rule__Vector__Group_1__0");
					put(grammarAccess.getArrayAccess().getGroup(), "rule__Array__Group__0");
					put(grammarAccess.getArrayAccess().getGroup_1(), "rule__Array__Group_1__0");
					put(grammarAccess.getQualifierAccess().getGroup(), "rule__Qualifier__Group__0");
					put(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup(), "rule__QualifiedNameWithWildCard__Group__0");
					put(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup_1(), "rule__QualifiedNameWithWildCard__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getPhdlModelAccess().getImportsAssignment_0(), "rule__PhdlModel__ImportsAssignment_0");
					put(grammarAccess.getPhdlModelAccess().getPackagesAssignment_1_0(), "rule__PhdlModel__PackagesAssignment_1_0");
					put(grammarAccess.getPhdlModelAccess().getDevicesAssignment_1_1(), "rule__PhdlModel__DevicesAssignment_1_1");
					put(grammarAccess.getPhdlModelAccess().getDesignsAssignment_1_2(), "rule__PhdlModel__DesignsAssignment_1_2");
					put(grammarAccess.getPackageAccess().getNameAssignment_1(), "rule__Package__NameAssignment_1");
					put(grammarAccess.getPackageAccess().getImportsAssignment_3(), "rule__Package__ImportsAssignment_3");
					put(grammarAccess.getPackageAccess().getDevicesAssignment_4_0(), "rule__Package__DevicesAssignment_4_0");
					put(grammarAccess.getPackageAccess().getDesignsAssignment_4_1(), "rule__Package__DesignsAssignment_4_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
					put(grammarAccess.getDeviceAccess().getNameAssignment_1(), "rule__Device__NameAssignment_1");
					put(grammarAccess.getDeviceAccess().getElementsAssignment_3(), "rule__Device__ElementsAssignment_3");
					put(grammarAccess.getAttrAccess().getNameAssignment_1(), "rule__Attr__NameAssignment_1");
					put(grammarAccess.getAttrAccess().getValueAssignment_3(), "rule__Attr__ValueAssignment_3");
					put(grammarAccess.getPinAccess().getTypeAssignment_0(), "rule__Pin__TypeAssignment_0");
					put(grammarAccess.getPinAccess().getVectorAssignment_1(), "rule__Pin__VectorAssignment_1");
					put(grammarAccess.getPinAccess().getNameAssignment_2(), "rule__Pin__NameAssignment_2");
					put(grammarAccess.getPinAccess().getPinNamesAssignment_5_0(), "rule__Pin__PinNamesAssignment_5_0");
					put(grammarAccess.getPinAccess().getPinNamesAssignment_5_1_1(), "rule__Pin__PinNamesAssignment_5_1_1");
					put(grammarAccess.getInfoAccess().getInfoAssignment_2(), "rule__Info__InfoAssignment_2");
					put(grammarAccess.getDesignAccess().getDesignAssignment_0_0(), "rule__Design__DesignAssignment_0_0");
					put(grammarAccess.getDesignAccess().getSubdesignAssignment_0_1(), "rule__Design__SubdesignAssignment_0_1");
					put(grammarAccess.getDesignAccess().getNameAssignment_1(), "rule__Design__NameAssignment_1");
					put(grammarAccess.getDesignAccess().getElementsAssignment_3(), "rule__Design__ElementsAssignment_3");
					put(grammarAccess.getConnectionAccess().getNetAssignment_0_0(), "rule__Connection__NetAssignment_0_0");
					put(grammarAccess.getConnectionAccess().getVectorAssignment_0_1(), "rule__Connection__VectorAssignment_0_1");
					put(grammarAccess.getConnectionAccess().getNamesAssignment_0_2(), "rule__Connection__NamesAssignment_0_2");
					put(grammarAccess.getConnectionAccess().getNamesAssignment_0_3_1(), "rule__Connection__NamesAssignment_0_3_1");
					put(grammarAccess.getConnectionAccess().getElementsAssignment_0_4_0_1(), "rule__Connection__ElementsAssignment_0_4_0_1");
					put(grammarAccess.getConnectionAccess().getPortAssignment_1_0(), "rule__Connection__PortAssignment_1_0");
					put(grammarAccess.getConnectionAccess().getVectorAssignment_1_1(), "rule__Connection__VectorAssignment_1_1");
					put(grammarAccess.getConnectionAccess().getNamesAssignment_1_2(), "rule__Connection__NamesAssignment_1_2");
					put(grammarAccess.getConnectionAccess().getNamesAssignment_1_3_1(), "rule__Connection__NamesAssignment_1_3_1");
					put(grammarAccess.getConnectionAccess().getElementsAssignment_1_4_0_1(), "rule__Connection__ElementsAssignment_1_4_0_1");
					put(grammarAccess.getInstanceAccess().getInstAssignment_0_0(), "rule__Instance__InstAssignment_0_0");
					put(grammarAccess.getInstanceAccess().getArrayAssignment_0_1(), "rule__Instance__ArrayAssignment_0_1");
					put(grammarAccess.getInstanceAccess().getNameAssignment_0_2(), "rule__Instance__NameAssignment_0_2");
					put(grammarAccess.getInstanceAccess().getDeviceAssignment_0_4(), "rule__Instance__DeviceAssignment_0_4");
					put(grammarAccess.getInstanceAccess().getElementsAssignment_0_6(), "rule__Instance__ElementsAssignment_0_6");
					put(grammarAccess.getInstanceAccess().getSubInstAssignment_1_0(), "rule__Instance__SubInstAssignment_1_0");
					put(grammarAccess.getInstanceAccess().getArrayAssignment_1_1(), "rule__Instance__ArrayAssignment_1_1");
					put(grammarAccess.getInstanceAccess().getNameAssignment_1_2(), "rule__Instance__NameAssignment_1_2");
					put(grammarAccess.getInstanceAccess().getSubDesignAssignment_1_4(), "rule__Instance__SubDesignAssignment_1_4");
					put(grammarAccess.getInstanceAccess().getPrefixAssignment_1_5(), "rule__Instance__PrefixAssignment_1_5");
					put(grammarAccess.getInstanceAccess().getElementsAssignment_1_7(), "rule__Instance__ElementsAssignment_1_7");
					put(grammarAccess.getRefAttrAccess().getQualifierAssignment_0(), "rule__RefAttr__QualifierAssignment_0");
					put(grammarAccess.getRefAttrAccess().getRefAssignment_1(), "rule__RefAttr__RefAssignment_1");
					put(grammarAccess.getRefAttrAccess().getValueAssignment_3(), "rule__RefAttr__ValueAssignment_3");
					put(grammarAccess.getPinAssignAccess().getCombinedAssignment_0_0_0(), "rule__PinAssign__CombinedAssignment_0_0_0");
					put(grammarAccess.getPinAssignAccess().getQualifierAssignment_0_0_2(), "rule__PinAssign__QualifierAssignment_0_0_2");
					put(grammarAccess.getPinAssignAccess().getRefAssignment_0_0_3(), "rule__PinAssign__RefAssignment_0_0_3");
					put(grammarAccess.getPinAssignAccess().getSlicesAssignment_0_0_4(), "rule__PinAssign__SlicesAssignment_0_0_4");
					put(grammarAccess.getPinAssignAccess().getQualifierAssignment_0_1_0(), "rule__PinAssign__QualifierAssignment_0_1_0");
					put(grammarAccess.getPinAssignAccess().getRefAssignment_0_1_1(), "rule__PinAssign__RefAssignment_0_1_1");
					put(grammarAccess.getPinAssignAccess().getSlicesAssignment_0_1_2(), "rule__PinAssign__SlicesAssignment_0_1_2");
					put(grammarAccess.getPinAssignAccess().getConcatenationAssignment_2(), "rule__PinAssign__ConcatenationAssignment_2");
					put(grammarAccess.getSubAttrAccess().getQualifierAssignment_0(), "rule__SubAttr__QualifierAssignment_0");
					put(grammarAccess.getSubAttrAccess().getRefAssignment_1(), "rule__SubAttr__RefAssignment_1");
					put(grammarAccess.getSubAttrAccess().getRefIndicesAssignment_2(), "rule__SubAttr__RefIndicesAssignment_2");
					put(grammarAccess.getSubAttrAccess().getTailAssignment_3(), "rule__SubAttr__TailAssignment_3");
					put(grammarAccess.getSubAttrAccess().getValueAssignment_5(), "rule__SubAttr__ValueAssignment_5");
					put(grammarAccess.getRefTailAccess().getRefAssignment_1(), "rule__RefTail__RefAssignment_1");
					put(grammarAccess.getRefTailAccess().getRefIndicesAssignment_2(), "rule__RefTail__RefIndicesAssignment_2");
					put(grammarAccess.getRefTailAccess().getTailAssignment_3(), "rule__RefTail__TailAssignment_3");
					put(grammarAccess.getPortAssignAccess().getCombinedAssignment_0_0_0(), "rule__PortAssign__CombinedAssignment_0_0_0");
					put(grammarAccess.getPortAssignAccess().getQualifierAssignment_0_0_2(), "rule__PortAssign__QualifierAssignment_0_0_2");
					put(grammarAccess.getPortAssignAccess().getRefAssignment_0_0_3(), "rule__PortAssign__RefAssignment_0_0_3");
					put(grammarAccess.getPortAssignAccess().getSlicesAssignment_0_0_4(), "rule__PortAssign__SlicesAssignment_0_0_4");
					put(grammarAccess.getPortAssignAccess().getQualifierAssignment_0_1_0(), "rule__PortAssign__QualifierAssignment_0_1_0");
					put(grammarAccess.getPortAssignAccess().getRefAssignment_0_1_1(), "rule__PortAssign__RefAssignment_0_1_1");
					put(grammarAccess.getPortAssignAccess().getSlicesAssignment_0_1_2(), "rule__PortAssign__SlicesAssignment_0_1_2");
					put(grammarAccess.getPortAssignAccess().getConcatenationAssignment_2(), "rule__PortAssign__ConcatenationAssignment_2");
					put(grammarAccess.getConnectionAssignAccess().getRefAssignment_0(), "rule__ConnectionAssign__RefAssignment_0");
					put(grammarAccess.getConnectionAssignAccess().getSlicesAssignment_1(), "rule__ConnectionAssign__SlicesAssignment_1");
					put(grammarAccess.getConnectionAssignAccess().getConcatenationAssignment_3(), "rule__ConnectionAssign__ConcatenationAssignment_3");
					put(grammarAccess.getConcatenationAccess().getConnectionsAssignment_0_1(), "rule__Concatenation__ConnectionsAssignment_0_1");
					put(grammarAccess.getConcatenationAccess().getConnectionsAssignment_0_2_1(), "rule__Concatenation__ConnectionsAssignment_0_2_1");
					put(grammarAccess.getConcatenationAccess().getConnectionsAssignment_1_0(), "rule__Concatenation__ConnectionsAssignment_1_0");
					put(grammarAccess.getConcatenationAccess().getConnectionsAssignment_1_1_1(), "rule__Concatenation__ConnectionsAssignment_1_1_1");
					put(grammarAccess.getConcatenationAccess().getReplicatedAssignment_2_0(), "rule__Concatenation__ReplicatedAssignment_2_0");
					put(grammarAccess.getConcatenationAccess().getReplicateAssignment_2_1(), "rule__Concatenation__ReplicateAssignment_2_1");
					put(grammarAccess.getConcatenationAccess().getReplicateAssignment_3_0(), "rule__Concatenation__ReplicateAssignment_3_0");
					put(grammarAccess.getConcatenationAccess().getReplicatedAssignment_3_1(), "rule__Concatenation__ReplicatedAssignment_3_1");
					put(grammarAccess.getConcatenationAccess().getOpenAssignment_4(), "rule__Concatenation__OpenAssignment_4");
					put(grammarAccess.getConnectionRefAccess().getRefAssignment_0(), "rule__ConnectionRef__RefAssignment_0");
					put(grammarAccess.getConnectionRefAccess().getSlicesAssignment_1(), "rule__ConnectionRef__SlicesAssignment_1");
					put(grammarAccess.getConnectionNameAccess().getNameAssignment(), "rule__ConnectionName__NameAssignment");
					put(grammarAccess.getIndicesAccess().getMsbAssignment_1_0_0(), "rule__Indices__MsbAssignment_1_0_0");
					put(grammarAccess.getIndicesAccess().getArrayAssignment_1_0_1(), "rule__Indices__ArrayAssignment_1_0_1");
					put(grammarAccess.getIndicesAccess().getLsbAssignment_1_0_2(), "rule__Indices__LsbAssignment_1_0_2");
					put(grammarAccess.getIndicesAccess().getIndicesAssignment_1_1_0(), "rule__Indices__IndicesAssignment_1_1_0");
					put(grammarAccess.getIndicesAccess().getIndicesAssignment_1_1_1_1(), "rule__Indices__IndicesAssignment_1_1_1_1");
					put(grammarAccess.getSlicesAccess().getMsbAssignment_1_0_0(), "rule__Slices__MsbAssignment_1_0_0");
					put(grammarAccess.getSlicesAccess().getVectorAssignment_1_0_1(), "rule__Slices__VectorAssignment_1_0_1");
					put(grammarAccess.getSlicesAccess().getLsbAssignment_1_0_2(), "rule__Slices__LsbAssignment_1_0_2");
					put(grammarAccess.getSlicesAccess().getSlicesAssignment_1_1_0(), "rule__Slices__SlicesAssignment_1_1_0");
					put(grammarAccess.getSlicesAccess().getSlicesAssignment_1_1_1_1(), "rule__Slices__SlicesAssignment_1_1_1_1");
					put(grammarAccess.getVectorAccess().getMsbAssignment_1_1(), "rule__Vector__MsbAssignment_1_1");
					put(grammarAccess.getVectorAccess().getVectorAssignment_1_2(), "rule__Vector__VectorAssignment_1_2");
					put(grammarAccess.getVectorAccess().getLsbAssignment_1_3(), "rule__Vector__LsbAssignment_1_3");
					put(grammarAccess.getArrayAccess().getMsbAssignment_1_1(), "rule__Array__MsbAssignment_1_1");
					put(grammarAccess.getArrayAccess().getArrayAssignment_1_2(), "rule__Array__ArrayAssignment_1_2");
					put(grammarAccess.getArrayAccess().getLsbAssignment_1_3(), "rule__Array__LsbAssignment_1_3");
					put(grammarAccess.getQualifierAccess().getIndicesAssignment_1(), "rule__Qualifier__IndicesAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			edu.byu.ee.phdl.ui.contentassist.antlr.internal.InternalPhdlParser typedParser = (edu.byu.ee.phdl.ui.contentassist.antlr.internal.InternalPhdlParser) parser;
			typedParser.entryRulePhdlModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS" };
	}
	
	public PhdlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(PhdlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
