package edu.byu.ee.phdl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.byu.ee.phdl.services.PhdlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPhdlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_PINNUM", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'package'", "'{'", "'}'", "'import'", "';'", "'device'", "'attr'", "'='", "','", "'info'", "'design'", "'subdesign'", "'net'", "'port'", "'inst'", "'of'", "'subinst'", "'combine'", "'('", "')'", "'.'", "'&'", "'<'", "'>'", "'*'", "'open'", "':'", "'['", "']'", "'this'", "'pin'", "'inpin'", "'outpin'", "'iopin'", "'pwrpin'", "'suppin'", "'ocpin'", "'oepin'", "'tripin'", "'passpin'", "'ncpin'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_PINNUM=7;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalPhdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPhdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPhdlParser.tokenNames; }
    public String getGrammarFileName() { return "../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g"; }



     	private PhdlGrammarAccess grammarAccess;
     	
        public InternalPhdlParser(TokenStream input, PhdlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PhdlModel";	
       	}
       	
       	@Override
       	protected PhdlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePhdlModel"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:68:1: entryRulePhdlModel returns [EObject current=null] : iv_rulePhdlModel= rulePhdlModel EOF ;
    public final EObject entryRulePhdlModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhdlModel = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:69:2: (iv_rulePhdlModel= rulePhdlModel EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:70:2: iv_rulePhdlModel= rulePhdlModel EOF
            {
             newCompositeNode(grammarAccess.getPhdlModelRule()); 
            pushFollow(FOLLOW_rulePhdlModel_in_entryRulePhdlModel75);
            iv_rulePhdlModel=rulePhdlModel();

            state._fsp--;

             current =iv_rulePhdlModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhdlModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhdlModel"


    // $ANTLR start "rulePhdlModel"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:77:1: rulePhdlModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* ) ;
    public final EObject rulePhdlModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_packages_1_0 = null;

        EObject lv_devices_2_0 = null;

        EObject lv_designs_3_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:80:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )* )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:2: ( (lv_imports_0_0= ruleImport ) )* ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )*
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:81:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:82:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:82:1: (lv_imports_0_0= ruleImport )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:83:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_rulePhdlModel131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:99:3: ( ( (lv_packages_1_0= rulePackage ) ) | ( (lv_devices_2_0= ruleDevice ) ) | ( (lv_designs_3_0= ruleDesign ) ) )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 11:
                    {
                    alt2=1;
                    }
                    break;
                case 16:
                    {
                    alt2=2;
                    }
                    break;
                case 21:
                case 22:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:99:4: ( (lv_packages_1_0= rulePackage ) )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:99:4: ( (lv_packages_1_0= rulePackage ) )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:100:1: (lv_packages_1_0= rulePackage )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:100:1: (lv_packages_1_0= rulePackage )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:101:3: lv_packages_1_0= rulePackage
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getPackagesPackageParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePackage_in_rulePhdlModel154);
            	    lv_packages_1_0=rulePackage();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"packages",
            	            		lv_packages_1_0, 
            	            		"Package");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:118:6: ( (lv_devices_2_0= ruleDevice ) )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:118:6: ( (lv_devices_2_0= ruleDevice ) )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:119:1: (lv_devices_2_0= ruleDevice )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:119:1: (lv_devices_2_0= ruleDevice )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:120:3: lv_devices_2_0= ruleDevice
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getDevicesDeviceParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDevice_in_rulePhdlModel181);
            	    lv_devices_2_0=ruleDevice();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"devices",
            	            		lv_devices_2_0, 
            	            		"Device");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:137:6: ( (lv_designs_3_0= ruleDesign ) )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:137:6: ( (lv_designs_3_0= ruleDesign ) )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:138:1: (lv_designs_3_0= ruleDesign )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:138:1: (lv_designs_3_0= ruleDesign )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:139:3: lv_designs_3_0= ruleDesign
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhdlModelAccess().getDesignsDesignParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDesign_in_rulePhdlModel208);
            	    lv_designs_3_0=ruleDesign();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhdlModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"designs",
            	            		lv_designs_3_0, 
            	            		"Design");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhdlModel"


    // $ANTLR start "entryRulePackage"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:163:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:164:2: (iv_rulePackage= rulePackage EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:165:2: iv_rulePackage= rulePackage EOF
            {
             newCompositeNode(grammarAccess.getPackageRule()); 
            pushFollow(FOLLOW_rulePackage_in_entryRulePackage246);
            iv_rulePackage=rulePackage();

            state._fsp--;

             current =iv_rulePackage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackage256); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage"


    // $ANTLR start "rulePackage"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:172:1: rulePackage returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' ) ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_imports_3_0 = null;

        EObject lv_devices_4_0 = null;

        EObject lv_designs_5_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:175:28: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:176:1: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:176:1: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:176:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_rulePackage293); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageAccess().getPackageKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:180:1: ( (lv_name_1_0= RULE_ID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:181:1: (lv_name_1_0= RULE_ID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:181:1: (lv_name_1_0= RULE_ID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:182:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePackage310); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPackageAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPackageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_rulePackage327); 

                	newLeafNode(otherlv_2, grammarAccess.getPackageAccess().getLeftCurlyBracketKeyword_2());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:202:1: ( (lv_imports_3_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:203:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:203:1: (lv_imports_3_0= ruleImport )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:204:3: lv_imports_3_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageAccess().getImportsImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_rulePackage348);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_3_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:220:3: ( ( (lv_devices_4_0= ruleDevice ) ) | ( (lv_designs_5_0= ruleDesign ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>=21 && LA4_0<=22)) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:220:4: ( (lv_devices_4_0= ruleDevice ) )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:220:4: ( (lv_devices_4_0= ruleDevice ) )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:221:1: (lv_devices_4_0= ruleDevice )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:221:1: (lv_devices_4_0= ruleDevice )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:222:3: lv_devices_4_0= ruleDevice
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageAccess().getDevicesDeviceParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDevice_in_rulePackage371);
            	    lv_devices_4_0=ruleDevice();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"devices",
            	            		lv_devices_4_0, 
            	            		"Device");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:239:6: ( (lv_designs_5_0= ruleDesign ) )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:239:6: ( (lv_designs_5_0= ruleDesign ) )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:240:1: (lv_designs_5_0= ruleDesign )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:240:1: (lv_designs_5_0= ruleDesign )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:241:3: lv_designs_5_0= ruleDesign
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageAccess().getDesignsDesignParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDesign_in_rulePackage398);
            	    lv_designs_5_0=ruleDesign();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"designs",
            	            		lv_designs_5_0, 
            	            		"Design");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_rulePackage412); 

                	newLeafNode(otherlv_6, grammarAccess.getPackageAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage"


    // $ANTLR start "entryRuleImport"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:269:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:270:2: (iv_ruleImport= ruleImport EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:271:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport448);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport458); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:278:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:281:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:282:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:282:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleImport495); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:286:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:287:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:288:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport516);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedNameWithWildCard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleImport528); 

                	newLeafNode(otherlv_2, grammarAccess.getImportAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDevice"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:316:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:317:2: (iv_ruleDevice= ruleDevice EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:318:2: iv_ruleDevice= ruleDevice EOF
            {
             newCompositeNode(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_ruleDevice_in_entryRuleDevice564);
            iv_ruleDevice=ruleDevice();

            state._fsp--;

             current =iv_ruleDevice; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDevice574); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:325:1: ruleDevice returns [EObject current=null] : (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:328:28: ( (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:329:1: (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:329:1: (otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:329:3: otherlv_0= 'device' ( (lv_name_1_0= rulePhdlID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleDeviceElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleDevice611); 

                	newLeafNode(otherlv_0, grammarAccess.getDeviceAccess().getDeviceKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:333:1: ( (lv_name_1_0= rulePhdlID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:334:1: (lv_name_1_0= rulePhdlID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:334:1: (lv_name_1_0= rulePhdlID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:335:3: lv_name_1_0= rulePhdlID
            {
             
            	        newCompositeNode(grammarAccess.getDeviceAccess().getNamePhdlIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleDevice632);
            lv_name_1_0=rulePhdlID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDeviceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"PhdlID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleDevice644); 

                	newLeafNode(otherlv_2, grammarAccess.getDeviceAccess().getLeftCurlyBracketKeyword_2());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:355:1: ( (lv_elements_3_0= ruleDeviceElement ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20||(LA5_0>=41 && LA5_0<=51)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:356:1: (lv_elements_3_0= ruleDeviceElement )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:356:1: (lv_elements_3_0= ruleDeviceElement )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:357:3: lv_elements_3_0= ruleDeviceElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDeviceAccess().getElementsDeviceElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDeviceElement_in_ruleDevice665);
            	    lv_elements_3_0=ruleDeviceElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDeviceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_3_0, 
            	            		"DeviceElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleDevice678); 

                	newLeafNode(otherlv_4, grammarAccess.getDeviceAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleDeviceElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:385:1: entryRuleDeviceElement returns [EObject current=null] : iv_ruleDeviceElement= ruleDeviceElement EOF ;
    public final EObject entryRuleDeviceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceElement = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:386:2: (iv_ruleDeviceElement= ruleDeviceElement EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:387:2: iv_ruleDeviceElement= ruleDeviceElement EOF
            {
             newCompositeNode(grammarAccess.getDeviceElementRule()); 
            pushFollow(FOLLOW_ruleDeviceElement_in_entryRuleDeviceElement714);
            iv_ruleDeviceElement=ruleDeviceElement();

            state._fsp--;

             current =iv_ruleDeviceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeviceElement724); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeviceElement"


    // $ANTLR start "ruleDeviceElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:394:1: ruleDeviceElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo ) ;
    public final EObject ruleDeviceElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_Pin_1 = null;

        EObject this_Info_2 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:397:28: ( (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:398:1: (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:398:1: (this_Attr_0= ruleAttr | this_Pin_1= rulePin | this_Info_2= ruleInfo )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt6=1;
                }
                break;
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:399:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getDeviceElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleDeviceElement771);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:409:5: this_Pin_1= rulePin
                    {
                     
                            newCompositeNode(grammarAccess.getDeviceElementAccess().getPinParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePin_in_ruleDeviceElement798);
                    this_Pin_1=rulePin();

                    state._fsp--;

                     
                            current = this_Pin_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:419:5: this_Info_2= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getDeviceElementAccess().getInfoParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleDeviceElement825);
                    this_Info_2=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeviceElement"


    // $ANTLR start "entryRuleAttr"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:435:1: entryRuleAttr returns [EObject current=null] : iv_ruleAttr= ruleAttr EOF ;
    public final EObject entryRuleAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttr = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:436:2: (iv_ruleAttr= ruleAttr EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:437:2: iv_ruleAttr= ruleAttr EOF
            {
             newCompositeNode(grammarAccess.getAttrRule()); 
            pushFollow(FOLLOW_ruleAttr_in_entryRuleAttr860);
            iv_ruleAttr=ruleAttr();

            state._fsp--;

             current =iv_ruleAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttr870); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttr"


    // $ANTLR start "ruleAttr"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:444:1: ruleAttr returns [EObject current=null] : (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:447:28: ( (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:448:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:448:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:448:3: otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleAttr907); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrAccess().getAttrKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:452:1: ( (lv_name_1_0= RULE_ID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:453:1: (lv_name_1_0= RULE_ID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:453:1: (lv_name_1_0= RULE_ID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:454:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttr924); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttrAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleAttr941); 

                	newLeafNode(otherlv_2, grammarAccess.getAttrAccess().getEqualsSignKeyword_2());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:474:1: ( (lv_value_3_0= RULE_STRING ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:475:1: (lv_value_3_0= RULE_STRING )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:475:1: (lv_value_3_0= RULE_STRING )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:476:3: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttr958); 

            			newLeafNode(lv_value_3_0, grammarAccess.getAttrAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleAttr975); 

                	newLeafNode(otherlv_4, grammarAccess.getAttrAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttr"


    // $ANTLR start "entryRulePin"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:504:1: entryRulePin returns [EObject current=null] : iv_rulePin= rulePin EOF ;
    public final EObject entryRulePin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePin = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:505:2: (iv_rulePin= rulePin EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:506:2: iv_rulePin= rulePin EOF
            {
             newCompositeNode(grammarAccess.getPinRule()); 
            pushFollow(FOLLOW_rulePin_in_entryRulePin1011);
            iv_rulePin=rulePin();

            state._fsp--;

             current =iv_rulePin; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePin1021); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePin"


    // $ANTLR start "rulePin"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:513:1: rulePin returns [EObject current=null] : ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' ) ;
    public final EObject rulePin() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_vector_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_pinNames_5_0 = null;

        AntlrDatatypeRuleToken lv_pinNames_7_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:516:28: ( ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:1: ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:1: ( ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:2: ( (lv_type_0_0= rulePinType ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_name_2_0= rulePhdlID ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )? otherlv_8= '}' otherlv_9= ';'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:517:2: ( (lv_type_0_0= rulePinType ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:518:1: (lv_type_0_0= rulePinType )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:518:1: (lv_type_0_0= rulePinType )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:519:3: lv_type_0_0= rulePinType
            {
             
            	        newCompositeNode(grammarAccess.getPinAccess().getTypePinTypeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePinType_in_rulePin1067);
            lv_type_0_0=rulePinType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"PinType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:535:2: ( (lv_vector_1_0= ruleVector ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:536:1: (lv_vector_1_0= ruleVector )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:536:1: (lv_vector_1_0= ruleVector )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:537:3: lv_vector_1_0= ruleVector
            {
             
            	        newCompositeNode(grammarAccess.getPinAccess().getVectorVectorParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVector_in_rulePin1088);
            lv_vector_1_0=ruleVector();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinRule());
            	        }
                   		set(
                   			current, 
                   			"vector",
                    		lv_vector_1_0, 
                    		"Vector");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:553:2: ( (lv_name_2_0= rulePhdlID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:554:1: (lv_name_2_0= rulePhdlID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:554:1: (lv_name_2_0= rulePhdlID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:555:3: lv_name_2_0= rulePhdlID
            {
             
            	        newCompositeNode(grammarAccess.getPinAccess().getNamePhdlIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_rulePin1109);
            lv_name_2_0=rulePhdlID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"PhdlID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_rulePin1121); 

                	newLeafNode(otherlv_3, grammarAccess.getPinAccess().getEqualsSignKeyword_3());
                
            otherlv_4=(Token)match(input,12,FOLLOW_12_in_rulePin1133); 

                	newLeafNode(otherlv_4, grammarAccess.getPinAccess().getLeftCurlyBracketKeyword_4());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:579:1: ( ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=RULE_INT && LA8_0<=RULE_PINNUM)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:579:2: ( (lv_pinNames_5_0= rulePhdlID ) ) (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )*
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:579:2: ( (lv_pinNames_5_0= rulePhdlID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:580:1: (lv_pinNames_5_0= rulePhdlID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:580:1: (lv_pinNames_5_0= rulePhdlID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:581:3: lv_pinNames_5_0= rulePhdlID
                    {
                     
                    	        newCompositeNode(grammarAccess.getPinAccess().getPinNamesPhdlIDParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePin1155);
                    lv_pinNames_5_0=rulePhdlID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPinRule());
                    	        }
                           		add(
                           			current, 
                           			"pinNames",
                            		lv_pinNames_5_0, 
                            		"PhdlID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:597:2: (otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:597:4: otherlv_6= ',' ( (lv_pinNames_7_0= rulePhdlID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,19,FOLLOW_19_in_rulePin1168); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getPinAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:601:1: ( (lv_pinNames_7_0= rulePhdlID ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:602:1: (lv_pinNames_7_0= rulePhdlID )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:602:1: (lv_pinNames_7_0= rulePhdlID )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:603:3: lv_pinNames_7_0= rulePhdlID
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPinAccess().getPinNamesPhdlIDParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePhdlID_in_rulePin1189);
                    	    lv_pinNames_7_0=rulePhdlID();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPinRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"pinNames",
                    	            		lv_pinNames_7_0, 
                    	            		"PhdlID");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_13_in_rulePin1205); 

                	newLeafNode(otherlv_8, grammarAccess.getPinAccess().getRightCurlyBracketKeyword_6());
                
            otherlv_9=(Token)match(input,15,FOLLOW_15_in_rulePin1217); 

                	newLeafNode(otherlv_9, grammarAccess.getPinAccess().getSemicolonKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePin"


    // $ANTLR start "entryRuleInfo"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:635:1: entryRuleInfo returns [EObject current=null] : iv_ruleInfo= ruleInfo EOF ;
    public final EObject entryRuleInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfo = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:636:2: (iv_ruleInfo= ruleInfo EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:637:2: iv_ruleInfo= ruleInfo EOF
            {
             newCompositeNode(grammarAccess.getInfoRule()); 
            pushFollow(FOLLOW_ruleInfo_in_entryRuleInfo1253);
            iv_ruleInfo=ruleInfo();

            state._fsp--;

             current =iv_ruleInfo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInfo1263); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfo"


    // $ANTLR start "ruleInfo"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:644:1: ruleInfo returns [EObject current=null] : (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' ) ;
    public final EObject ruleInfo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_info_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:647:28: ( (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:648:1: (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:648:1: (otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:648:3: otherlv_0= 'info' otherlv_1= '{' ( (lv_info_2_0= RULE_STRING ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleInfo1300); 

                	newLeafNode(otherlv_0, grammarAccess.getInfoAccess().getInfoKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleInfo1312); 

                	newLeafNode(otherlv_1, grammarAccess.getInfoAccess().getLeftCurlyBracketKeyword_1());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:656:1: ( (lv_info_2_0= RULE_STRING ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:657:1: (lv_info_2_0= RULE_STRING )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:657:1: (lv_info_2_0= RULE_STRING )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:658:3: lv_info_2_0= RULE_STRING
            {
            lv_info_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInfo1329); 

            			newLeafNode(lv_info_2_0, grammarAccess.getInfoAccess().getInfoSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInfoRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"info",
                    		lv_info_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleInfo1346); 

                	newLeafNode(otherlv_3, grammarAccess.getInfoAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfo"


    // $ANTLR start "entryRuleDesign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:686:1: entryRuleDesign returns [EObject current=null] : iv_ruleDesign= ruleDesign EOF ;
    public final EObject entryRuleDesign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesign = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:687:2: (iv_ruleDesign= ruleDesign EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:688:2: iv_ruleDesign= ruleDesign EOF
            {
             newCompositeNode(grammarAccess.getDesignRule()); 
            pushFollow(FOLLOW_ruleDesign_in_entryRuleDesign1382);
            iv_ruleDesign=ruleDesign();

            state._fsp--;

             current =iv_ruleDesign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDesign1392); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDesign"


    // $ANTLR start "ruleDesign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:695:1: ruleDesign returns [EObject current=null] : ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' ) ;
    public final EObject ruleDesign() throws RecognitionException {
        EObject current = null;

        Token lv_design_0_0=null;
        Token lv_subdesign_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:698:28: ( ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:1: ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:1: ( ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:2: ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_elements_4_0= ruleDesignElement ) )* otherlv_5= '}'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:2: ( ( (lv_design_0_0= 'design' ) ) | ( (lv_subdesign_1_0= 'subdesign' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:3: ( (lv_design_0_0= 'design' ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:699:3: ( (lv_design_0_0= 'design' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:700:1: (lv_design_0_0= 'design' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:700:1: (lv_design_0_0= 'design' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:701:3: lv_design_0_0= 'design'
                    {
                    lv_design_0_0=(Token)match(input,21,FOLLOW_21_in_ruleDesign1436); 

                            newLeafNode(lv_design_0_0, grammarAccess.getDesignAccess().getDesignDesignKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDesignRule());
                    	        }
                           		setWithLastConsumed(current, "design", true, "design");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:715:6: ( (lv_subdesign_1_0= 'subdesign' ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:715:6: ( (lv_subdesign_1_0= 'subdesign' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:716:1: (lv_subdesign_1_0= 'subdesign' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:716:1: (lv_subdesign_1_0= 'subdesign' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:717:3: lv_subdesign_1_0= 'subdesign'
                    {
                    lv_subdesign_1_0=(Token)match(input,22,FOLLOW_22_in_ruleDesign1473); 

                            newLeafNode(lv_subdesign_1_0, grammarAccess.getDesignAccess().getSubdesignSubdesignKeyword_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDesignRule());
                    	        }
                           		setWithLastConsumed(current, "subdesign", true, "subdesign");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:730:3: ( (lv_name_2_0= RULE_ID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:731:1: (lv_name_2_0= RULE_ID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:731:1: (lv_name_2_0= RULE_ID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:732:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDesign1504); 

            			newLeafNode(lv_name_2_0, grammarAccess.getDesignAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDesignRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleDesign1521); 

                	newLeafNode(otherlv_3, grammarAccess.getDesignAccess().getLeftCurlyBracketKeyword_2());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:752:1: ( (lv_elements_4_0= ruleDesignElement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||(LA10_0>=RULE_INT && LA10_0<=RULE_PINNUM)||LA10_0==20||(LA10_0>=23 && LA10_0<=25)||LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:753:1: (lv_elements_4_0= ruleDesignElement )
            	    {
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:753:1: (lv_elements_4_0= ruleDesignElement )
            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:754:3: lv_elements_4_0= ruleDesignElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDesignAccess().getElementsDesignElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDesignElement_in_ruleDesign1542);
            	    lv_elements_4_0=ruleDesignElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDesignRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_4_0, 
            	            		"DesignElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleDesign1555); 

                	newLeafNode(otherlv_5, grammarAccess.getDesignAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDesign"


    // $ANTLR start "entryRuleDesignElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:782:1: entryRuleDesignElement returns [EObject current=null] : iv_ruleDesignElement= ruleDesignElement EOF ;
    public final EObject entryRuleDesignElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDesignElement = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:783:2: (iv_ruleDesignElement= ruleDesignElement EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:784:2: iv_ruleDesignElement= ruleDesignElement EOF
            {
             newCompositeNode(grammarAccess.getDesignElementRule()); 
            pushFollow(FOLLOW_ruleDesignElement_in_entryRuleDesignElement1591);
            iv_ruleDesignElement=ruleDesignElement();

            state._fsp--;

             current =iv_ruleDesignElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDesignElement1601); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDesignElement"


    // $ANTLR start "ruleDesignElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:791:1: ruleDesignElement returns [EObject current=null] : (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo ) ;
    public final EObject ruleDesignElement() throws RecognitionException {
        EObject current = null;

        EObject this_Connection_0 = null;

        EObject this_Instance_1 = null;

        EObject this_ConnectionAssign_2 = null;

        EObject this_Info_3 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:794:28: ( (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:795:1: (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:795:1: (this_Connection_0= ruleConnection | this_Instance_1= ruleInstance | this_ConnectionAssign_2= ruleConnectionAssign | this_Info_3= ruleInfo )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 23:
            case 24:
                {
                alt11=1;
                }
                break;
            case 25:
            case 27:
                {
                alt11=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_PINNUM:
                {
                alt11=3;
                }
                break;
            case 20:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:796:5: this_Connection_0= ruleConnection
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getConnectionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleConnection_in_ruleDesignElement1648);
                    this_Connection_0=ruleConnection();

                    state._fsp--;

                     
                            current = this_Connection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:806:5: this_Instance_1= ruleInstance
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getInstanceParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInstance_in_ruleDesignElement1675);
                    this_Instance_1=ruleInstance();

                    state._fsp--;

                     
                            current = this_Instance_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:816:5: this_ConnectionAssign_2= ruleConnectionAssign
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getConnectionAssignParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleConnectionAssign_in_ruleDesignElement1702);
                    this_ConnectionAssign_2=ruleConnectionAssign();

                    state._fsp--;

                     
                            current = this_ConnectionAssign_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:826:5: this_Info_3= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getDesignElementAccess().getInfoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleDesignElement1729);
                    this_Info_3=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDesignElement"


    // $ANTLR start "entryRuleConnection"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:842:1: entryRuleConnection returns [EObject current=null] : iv_ruleConnection= ruleConnection EOF ;
    public final EObject entryRuleConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnection = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:843:2: (iv_ruleConnection= ruleConnection EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:844:2: iv_ruleConnection= ruleConnection EOF
            {
             newCompositeNode(grammarAccess.getConnectionRule()); 
            pushFollow(FOLLOW_ruleConnection_in_entryRuleConnection1764);
            iv_ruleConnection=ruleConnection();

            state._fsp--;

             current =iv_ruleConnection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnection1774); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnection"


    // $ANTLR start "ruleConnection"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:851:1: ruleConnection returns [EObject current=null] : ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) ) ;
    public final EObject ruleConnection() throws RecognitionException {
        EObject current = null;

        Token lv_net_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_port_9_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_vector_1_0 = null;

        EObject lv_names_2_0 = null;

        EObject lv_names_4_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_vector_10_0 = null;

        EObject lv_names_11_0 = null;

        EObject lv_names_13_0 = null;

        EObject lv_elements_15_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:854:28: ( ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:1: ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:1: ( ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) ) | ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            else if ( (LA18_0==24) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:2: ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:2: ( ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:3: ( (lv_net_0_0= 'net' ) ) ( (lv_vector_1_0= ruleVector ) ) ( (lv_names_2_0= ruleConnectionName ) ) (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )* ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:855:3: ( (lv_net_0_0= 'net' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:856:1: (lv_net_0_0= 'net' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:856:1: (lv_net_0_0= 'net' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:857:3: lv_net_0_0= 'net'
                    {
                    lv_net_0_0=(Token)match(input,23,FOLLOW_23_in_ruleConnection1818); 

                            newLeafNode(lv_net_0_0, grammarAccess.getConnectionAccess().getNetNetKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionRule());
                    	        }
                           		setWithLastConsumed(current, "net", true, "net");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:870:2: ( (lv_vector_1_0= ruleVector ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:871:1: (lv_vector_1_0= ruleVector )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:871:1: (lv_vector_1_0= ruleVector )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:872:3: lv_vector_1_0= ruleVector
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getVectorVectorParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleConnection1852);
                    lv_vector_1_0=ruleVector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		set(
                           			current, 
                           			"vector",
                            		lv_vector_1_0, 
                            		"Vector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:888:2: ( (lv_names_2_0= ruleConnectionName ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:889:1: (lv_names_2_0= ruleConnectionName )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:889:1: (lv_names_2_0= ruleConnectionName )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:890:3: lv_names_2_0= ruleConnectionName
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection1873);
                    lv_names_2_0=ruleConnectionName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		add(
                           			current, 
                           			"names",
                            		lv_names_2_0, 
                            		"ConnectionName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:906:2: (otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==19) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:906:4: otherlv_3= ',' ( (lv_names_4_0= ruleConnectionName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleConnection1886); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getConnectionAccess().getCommaKeyword_0_3_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:910:1: ( (lv_names_4_0= ruleConnectionName ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:911:1: (lv_names_4_0= ruleConnectionName )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:911:1: (lv_names_4_0= ruleConnectionName )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:912:3: lv_names_4_0= ruleConnectionName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_0_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection1907);
                    	    lv_names_4_0=ruleConnectionName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"names",
                    	            		lv_names_4_0, 
                    	            		"ConnectionName");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:4: ( (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' ) | otherlv_8= ';' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==12) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==15) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:5: (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:5: (otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}' )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:928:7: otherlv_5= '{' ( (lv_elements_6_0= ruleNetElement ) )* otherlv_7= '}'
                            {
                            otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleConnection1923); 

                                	newLeafNode(otherlv_5, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_0_4_0_0());
                                
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:932:1: ( (lv_elements_6_0= ruleNetElement ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==17||LA13_0==20) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:933:1: (lv_elements_6_0= ruleNetElement )
                            	    {
                            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:933:1: (lv_elements_6_0= ruleNetElement )
                            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:934:3: lv_elements_6_0= ruleNetElement
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getConnectionAccess().getElementsNetElementParserRuleCall_0_4_0_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleNetElement_in_ruleConnection1944);
                            	    lv_elements_6_0=ruleNetElement();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"elements",
                            	            		lv_elements_6_0, 
                            	            		"NetElement");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleConnection1957); 

                                	newLeafNode(otherlv_7, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_0_4_0_2());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:955:7: otherlv_8= ';'
                            {
                            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleConnection1976); 

                                	newLeafNode(otherlv_8, grammarAccess.getConnectionAccess().getSemicolonKeyword_0_4_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:6: ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:6: ( ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:7: ( (lv_port_9_0= 'port' ) ) ( (lv_vector_10_0= ruleVector ) ) ( (lv_names_11_0= ruleConnectionName ) ) (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )* ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:960:7: ( (lv_port_9_0= 'port' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:961:1: (lv_port_9_0= 'port' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:961:1: (lv_port_9_0= 'port' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:962:3: lv_port_9_0= 'port'
                    {
                    lv_port_9_0=(Token)match(input,24,FOLLOW_24_in_ruleConnection2003); 

                            newLeafNode(lv_port_9_0, grammarAccess.getConnectionAccess().getPortPortKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionRule());
                    	        }
                           		setWithLastConsumed(current, "port", true, "port");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:975:2: ( (lv_vector_10_0= ruleVector ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:976:1: (lv_vector_10_0= ruleVector )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:976:1: (lv_vector_10_0= ruleVector )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:977:3: lv_vector_10_0= ruleVector
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getVectorVectorParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVector_in_ruleConnection2037);
                    lv_vector_10_0=ruleVector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		set(
                           			current, 
                           			"vector",
                            		lv_vector_10_0, 
                            		"Vector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:993:2: ( (lv_names_11_0= ruleConnectionName ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:994:1: (lv_names_11_0= ruleConnectionName )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:994:1: (lv_names_11_0= ruleConnectionName )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:995:3: lv_names_11_0= ruleConnectionName
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection2058);
                    lv_names_11_0=ruleConnectionName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	        }
                           		add(
                           			current, 
                           			"names",
                            		lv_names_11_0, 
                            		"ConnectionName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1011:2: (otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==19) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1011:4: otherlv_12= ',' ( (lv_names_13_0= ruleConnectionName ) )
                    	    {
                    	    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleConnection2071); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionAccess().getCommaKeyword_1_3_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1015:1: ( (lv_names_13_0= ruleConnectionName ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1016:1: (lv_names_13_0= ruleConnectionName )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1016:1: (lv_names_13_0= ruleConnectionName )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1017:3: lv_names_13_0= ruleConnectionName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionAccess().getNamesConnectionNameParserRuleCall_1_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionName_in_ruleConnection2092);
                    	    lv_names_13_0=ruleConnectionName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"names",
                    	            		lv_names_13_0, 
                    	            		"ConnectionName");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:4: ( (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' ) | otherlv_17= ';' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==12) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==15) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:5: (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:5: (otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}' )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1033:7: otherlv_14= '{' ( (lv_elements_15_0= rulePortElement ) )* otherlv_16= '}'
                            {
                            otherlv_14=(Token)match(input,12,FOLLOW_12_in_ruleConnection2108); 

                                	newLeafNode(otherlv_14, grammarAccess.getConnectionAccess().getLeftCurlyBracketKeyword_1_4_0_0());
                                
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1037:1: ( (lv_elements_15_0= rulePortElement ) )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==20) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1038:1: (lv_elements_15_0= rulePortElement )
                            	    {
                            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1038:1: (lv_elements_15_0= rulePortElement )
                            	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1039:3: lv_elements_15_0= rulePortElement
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getConnectionAccess().getElementsPortElementParserRuleCall_1_4_0_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_rulePortElement_in_ruleConnection2129);
                            	    lv_elements_15_0=rulePortElement();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getConnectionRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"elements",
                            	            		lv_elements_15_0, 
                            	            		"PortElement");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);

                            otherlv_16=(Token)match(input,13,FOLLOW_13_in_ruleConnection2142); 

                                	newLeafNode(otherlv_16, grammarAccess.getConnectionAccess().getRightCurlyBracketKeyword_1_4_0_2());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1060:7: otherlv_17= ';'
                            {
                            otherlv_17=(Token)match(input,15,FOLLOW_15_in_ruleConnection2161); 

                                	newLeafNode(otherlv_17, grammarAccess.getConnectionAccess().getSemicolonKeyword_1_4_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnection"


    // $ANTLR start "entryRuleNetElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1072:1: entryRuleNetElement returns [EObject current=null] : iv_ruleNetElement= ruleNetElement EOF ;
    public final EObject entryRuleNetElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNetElement = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1073:2: (iv_ruleNetElement= ruleNetElement EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1074:2: iv_ruleNetElement= ruleNetElement EOF
            {
             newCompositeNode(grammarAccess.getNetElementRule()); 
            pushFollow(FOLLOW_ruleNetElement_in_entryRuleNetElement2199);
            iv_ruleNetElement=ruleNetElement();

            state._fsp--;

             current =iv_ruleNetElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNetElement2209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNetElement"


    // $ANTLR start "ruleNetElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1081:1: ruleNetElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_Info_1= ruleInfo ) ;
    public final EObject ruleNetElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_Info_1 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1084:28: ( (this_Attr_0= ruleAttr | this_Info_1= ruleInfo ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1085:1: (this_Attr_0= ruleAttr | this_Info_1= ruleInfo )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1085:1: (this_Attr_0= ruleAttr | this_Info_1= ruleInfo )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            else if ( (LA19_0==20) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1086:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getNetElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleNetElement2256);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1096:5: this_Info_1= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getNetElementAccess().getInfoParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleNetElement2283);
                    this_Info_1=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNetElement"


    // $ANTLR start "entryRulePortElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1112:1: entryRulePortElement returns [EObject current=null] : iv_rulePortElement= rulePortElement EOF ;
    public final EObject entryRulePortElement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortElement = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1113:2: (iv_rulePortElement= rulePortElement EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1114:2: iv_rulePortElement= rulePortElement EOF
            {
             newCompositeNode(grammarAccess.getPortElementRule()); 
            pushFollow(FOLLOW_rulePortElement_in_entryRulePortElement2318);
            iv_rulePortElement=rulePortElement();

            state._fsp--;

             current =iv_rulePortElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortElement2328); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortElement"


    // $ANTLR start "rulePortElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1121:1: rulePortElement returns [EObject current=null] : this_Info_0= ruleInfo ;
    public final EObject rulePortElement() throws RecognitionException {
        EObject current = null;

        EObject this_Info_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1124:28: (this_Info_0= ruleInfo )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1126:5: this_Info_0= ruleInfo
            {
             
                    newCompositeNode(grammarAccess.getPortElementAccess().getInfoParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleInfo_in_rulePortElement2374);
            this_Info_0=ruleInfo();

            state._fsp--;

             
                    current = this_Info_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortElement"


    // $ANTLR start "entryRuleInstance"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1142:1: entryRuleInstance returns [EObject current=null] : iv_ruleInstance= ruleInstance EOF ;
    public final EObject entryRuleInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstance = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1143:2: (iv_ruleInstance= ruleInstance EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1144:2: iv_ruleInstance= ruleInstance EOF
            {
             newCompositeNode(grammarAccess.getInstanceRule()); 
            pushFollow(FOLLOW_ruleInstance_in_entryRuleInstance2408);
            iv_ruleInstance=ruleInstance();

            state._fsp--;

             current =iv_ruleInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstance2418); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstance"


    // $ANTLR start "ruleInstance"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1151:1: ruleInstance returns [EObject current=null] : ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) ) ;
    public final EObject ruleInstance() throws RecognitionException {
        EObject current = null;

        Token lv_inst_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_subInst_8_0=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token lv_prefix_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_array_1_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_array_9_0 = null;

        EObject lv_elements_15_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1154:28: ( ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:1: ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:1: ( ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' ) | ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            else if ( (LA23_0==27) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:2: ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:2: ( ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:3: ( (lv_inst_0_0= 'inst' ) ) ( (lv_array_1_0= ruleArray ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( ( ruleQualifiedName ) ) otherlv_5= '{' ( (lv_elements_6_0= ruleInstanceElement ) )* otherlv_7= '}'
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1155:3: ( (lv_inst_0_0= 'inst' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1156:1: (lv_inst_0_0= 'inst' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1156:1: (lv_inst_0_0= 'inst' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1157:3: lv_inst_0_0= 'inst'
                    {
                    lv_inst_0_0=(Token)match(input,25,FOLLOW_25_in_ruleInstance2462); 

                            newLeafNode(lv_inst_0_0, grammarAccess.getInstanceAccess().getInstInstKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "inst", true, "inst");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1170:2: ( (lv_array_1_0= ruleArray ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1171:1: (lv_array_1_0= ruleArray )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1171:1: (lv_array_1_0= ruleArray )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1172:3: lv_array_1_0= ruleArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getArrayArrayParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArray_in_ruleInstance2496);
                    lv_array_1_0=ruleArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"array",
                            		lv_array_1_0, 
                            		"Array");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1188:2: ( (lv_name_2_0= RULE_ID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1189:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1189:1: (lv_name_2_0= RULE_ID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1190:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstance2513); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getInstanceAccess().getNameIDTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleInstance2530); 

                        	newLeafNode(otherlv_3, grammarAccess.getInstanceAccess().getOfKeyword_0_3());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1210:1: ( ( ruleQualifiedName ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1211:1: ( ruleQualifiedName )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1211:1: ( ruleQualifiedName )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1212:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getDeviceDeviceCrossReference_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstance2553);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleInstance2565); 

                        	newLeafNode(otherlv_5, grammarAccess.getInstanceAccess().getLeftCurlyBracketKeyword_0_5());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1229:1: ( (lv_elements_6_0= ruleInstanceElement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID||(LA20_0>=RULE_INT && LA20_0<=RULE_PINNUM)||LA20_0==17||LA20_0==20||LA20_0==28||LA20_0==40) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1230:1: (lv_elements_6_0= ruleInstanceElement )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1230:1: (lv_elements_6_0= ruleInstanceElement )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1231:3: lv_elements_6_0= ruleInstanceElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstanceAccess().getElementsInstanceElementParserRuleCall_0_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInstanceElement_in_ruleInstance2586);
                    	    lv_elements_6_0=ruleInstanceElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_6_0, 
                    	            		"InstanceElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleInstance2599); 

                        	newLeafNode(otherlv_7, grammarAccess.getInstanceAccess().getRightCurlyBracketKeyword_0_7());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:6: ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:6: ( ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:7: ( (lv_subInst_8_0= 'subinst' ) ) ( (lv_array_9_0= ruleArray ) ) ( (lv_name_10_0= RULE_ID ) ) otherlv_11= 'of' ( ( ruleQualifiedName ) ) ( (lv_prefix_13_0= RULE_STRING ) )? otherlv_14= '{' ( (lv_elements_15_0= ruleSubInstanceElement ) )* otherlv_16= '}'
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1252:7: ( (lv_subInst_8_0= 'subinst' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1253:1: (lv_subInst_8_0= 'subinst' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1253:1: (lv_subInst_8_0= 'subinst' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1254:3: lv_subInst_8_0= 'subinst'
                    {
                    lv_subInst_8_0=(Token)match(input,27,FOLLOW_27_in_ruleInstance2625); 

                            newLeafNode(lv_subInst_8_0, grammarAccess.getInstanceAccess().getSubInstSubinstKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "subInst", true, "subinst");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1267:2: ( (lv_array_9_0= ruleArray ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1268:1: (lv_array_9_0= ruleArray )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1268:1: (lv_array_9_0= ruleArray )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1269:3: lv_array_9_0= ruleArray
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getArrayArrayParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArray_in_ruleInstance2659);
                    lv_array_9_0=ruleArray();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"array",
                            		lv_array_9_0, 
                            		"Array");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1285:2: ( (lv_name_10_0= RULE_ID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1286:1: (lv_name_10_0= RULE_ID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1286:1: (lv_name_10_0= RULE_ID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1287:3: lv_name_10_0= RULE_ID
                    {
                    lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstance2676); 

                    			newLeafNode(lv_name_10_0, grammarAccess.getInstanceAccess().getNameIDTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_10_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,26,FOLLOW_26_in_ruleInstance2693); 

                        	newLeafNode(otherlv_11, grammarAccess.getInstanceAccess().getOfKeyword_1_3());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1307:1: ( ( ruleQualifiedName ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1308:1: ( ruleQualifiedName )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1308:1: ( ruleQualifiedName )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1309:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getInstanceAccess().getSubDesignDesignCrossReference_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstance2716);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1322:2: ( (lv_prefix_13_0= RULE_STRING ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_STRING) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1323:1: (lv_prefix_13_0= RULE_STRING )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1323:1: (lv_prefix_13_0= RULE_STRING )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1324:3: lv_prefix_13_0= RULE_STRING
                            {
                            lv_prefix_13_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstance2733); 

                            			newLeafNode(lv_prefix_13_0, grammarAccess.getInstanceAccess().getPrefixSTRINGTerminalRuleCall_1_5_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getInstanceRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"prefix",
                                    		lv_prefix_13_0, 
                                    		"STRING");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,12,FOLLOW_12_in_ruleInstance2751); 

                        	newLeafNode(otherlv_14, grammarAccess.getInstanceAccess().getLeftCurlyBracketKeyword_1_6());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1344:1: ( (lv_elements_15_0= ruleSubInstanceElement ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID||(LA22_0>=RULE_INT && LA22_0<=RULE_PINNUM)||LA22_0==17||LA22_0==20||LA22_0==28||LA22_0==40) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1345:1: (lv_elements_15_0= ruleSubInstanceElement )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1345:1: (lv_elements_15_0= ruleSubInstanceElement )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1346:3: lv_elements_15_0= ruleSubInstanceElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getInstanceAccess().getElementsSubInstanceElementParserRuleCall_1_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSubInstanceElement_in_ruleInstance2772);
                    	    lv_elements_15_0=ruleSubInstanceElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_15_0, 
                    	            		"SubInstanceElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,13,FOLLOW_13_in_ruleInstance2785); 

                        	newLeafNode(otherlv_16, grammarAccess.getInstanceAccess().getRightCurlyBracketKeyword_1_8());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstance"


    // $ANTLR start "entryRuleInstanceElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1374:1: entryRuleInstanceElement returns [EObject current=null] : iv_ruleInstanceElement= ruleInstanceElement EOF ;
    public final EObject entryRuleInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceElement = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1375:2: (iv_ruleInstanceElement= ruleInstanceElement EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1376:2: iv_ruleInstanceElement= ruleInstanceElement EOF
            {
             newCompositeNode(grammarAccess.getInstanceElementRule()); 
            pushFollow(FOLLOW_ruleInstanceElement_in_entryRuleInstanceElement2822);
            iv_ruleInstanceElement=ruleInstanceElement();

            state._fsp--;

             current =iv_ruleInstanceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceElement2832); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceElement"


    // $ANTLR start "ruleInstanceElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1383:1: ruleInstanceElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo ) ;
    public final EObject ruleInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_RefAttr_1 = null;

        EObject this_PinAssign_2 = null;

        EObject this_Info_3 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1386:28: ( (this_Attr_0= ruleAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1387:1: (this_Attr_0= ruleAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1387:1: (this_Attr_0= ruleAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo )
            int alt24=4;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1388:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleInstanceElement2879);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1398:5: this_RefAttr_1= ruleRefAttr
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getRefAttrParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRefAttr_in_ruleInstanceElement2906);
                    this_RefAttr_1=ruleRefAttr();

                    state._fsp--;

                     
                            current = this_RefAttr_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1408:5: this_PinAssign_2= rulePinAssign
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getPinAssignParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePinAssign_in_ruleInstanceElement2933);
                    this_PinAssign_2=rulePinAssign();

                    state._fsp--;

                     
                            current = this_PinAssign_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1418:5: this_Info_3= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getInstanceElementAccess().getInfoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleInstanceElement2960);
                    this_Info_3=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceElement"


    // $ANTLR start "entryRuleSubInstanceElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1434:1: entryRuleSubInstanceElement returns [EObject current=null] : iv_ruleSubInstanceElement= ruleSubInstanceElement EOF ;
    public final EObject entryRuleSubInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubInstanceElement = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1435:2: (iv_ruleSubInstanceElement= ruleSubInstanceElement EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1436:2: iv_ruleSubInstanceElement= ruleSubInstanceElement EOF
            {
             newCompositeNode(grammarAccess.getSubInstanceElementRule()); 
            pushFollow(FOLLOW_ruleSubInstanceElement_in_entryRuleSubInstanceElement2995);
            iv_ruleSubInstanceElement=ruleSubInstanceElement();

            state._fsp--;

             current =iv_ruleSubInstanceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubInstanceElement3005); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubInstanceElement"


    // $ANTLR start "ruleSubInstanceElement"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1443:1: ruleSubInstanceElement returns [EObject current=null] : (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo ) ;
    public final EObject ruleSubInstanceElement() throws RecognitionException {
        EObject current = null;

        EObject this_Attr_0 = null;

        EObject this_SubAttr_1 = null;

        EObject this_PortAssign_2 = null;

        EObject this_Info_3 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1446:28: ( (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1447:1: (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1447:1: (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo )
            int alt25=4;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1448:5: this_Attr_0= ruleAttr
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getAttrParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAttr_in_ruleSubInstanceElement3052);
                    this_Attr_0=ruleAttr();

                    state._fsp--;

                     
                            current = this_Attr_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1458:5: this_SubAttr_1= ruleSubAttr
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getSubAttrParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSubAttr_in_ruleSubInstanceElement3079);
                    this_SubAttr_1=ruleSubAttr();

                    state._fsp--;

                     
                            current = this_SubAttr_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1468:5: this_PortAssign_2= rulePortAssign
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getPortAssignParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePortAssign_in_ruleSubInstanceElement3106);
                    this_PortAssign_2=rulePortAssign();

                    state._fsp--;

                     
                            current = this_PortAssign_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1478:5: this_Info_3= ruleInfo
                    {
                     
                            newCompositeNode(grammarAccess.getSubInstanceElementAccess().getInfoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleInfo_in_ruleSubInstanceElement3133);
                    this_Info_3=ruleInfo();

                    state._fsp--;

                     
                            current = this_Info_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubInstanceElement"


    // $ANTLR start "entryRuleRefAttr"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1494:1: entryRuleRefAttr returns [EObject current=null] : iv_ruleRefAttr= ruleRefAttr EOF ;
    public final EObject entryRuleRefAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefAttr = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1495:2: (iv_ruleRefAttr= ruleRefAttr EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1496:2: iv_ruleRefAttr= ruleRefAttr EOF
            {
             newCompositeNode(grammarAccess.getRefAttrRule()); 
            pushFollow(FOLLOW_ruleRefAttr_in_entryRuleRefAttr3168);
            iv_ruleRefAttr=ruleRefAttr();

            state._fsp--;

             current =iv_ruleRefAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefAttr3178); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefAttr"


    // $ANTLR start "ruleRefAttr"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1503:1: ruleRefAttr returns [EObject current=null] : ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleRefAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;
        EObject lv_qualifier_0_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1506:28: ( ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:2: ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) otherlv_4= ';'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1507:2: ( (lv_qualifier_0_0= ruleQualifier ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1508:1: (lv_qualifier_0_0= ruleQualifier )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1508:1: (lv_qualifier_0_0= ruleQualifier )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1509:3: lv_qualifier_0_0= ruleQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefAttrAccess().getQualifierQualifierParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifier_in_ruleRefAttr3224);
                    lv_qualifier_0_0=ruleQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"qualifier",
                            		lv_qualifier_0_0, 
                            		"Qualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1525:3: ( (otherlv_1= RULE_ID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1526:1: (otherlv_1= RULE_ID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1526:1: (otherlv_1= RULE_ID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1527:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefAttrRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefAttr3245); 

            		newLeafNode(otherlv_1, grammarAccess.getRefAttrAccess().getRefAttrCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleRefAttr3257); 

                	newLeafNode(otherlv_2, grammarAccess.getRefAttrAccess().getEqualsSignKeyword_2());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1542:1: ( (lv_value_3_0= RULE_STRING ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1543:1: (lv_value_3_0= RULE_STRING )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1543:1: (lv_value_3_0= RULE_STRING )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1544:3: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRefAttr3274); 

            			newLeafNode(lv_value_3_0, grammarAccess.getRefAttrAccess().getValueSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRefAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleRefAttr3291); 

                	newLeafNode(otherlv_4, grammarAccess.getRefAttrAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefAttr"


    // $ANTLR start "entryRulePinAssign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1572:1: entryRulePinAssign returns [EObject current=null] : iv_rulePinAssign= rulePinAssign EOF ;
    public final EObject entryRulePinAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePinAssign = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1573:2: (iv_rulePinAssign= rulePinAssign EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1574:2: iv_rulePinAssign= rulePinAssign EOF
            {
             newCompositeNode(grammarAccess.getPinAssignRule()); 
            pushFollow(FOLLOW_rulePinAssign_in_entryRulePinAssign3327);
            iv_rulePinAssign=rulePinAssign();

            state._fsp--;

             current =iv_rulePinAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePinAssign3337); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePinAssign"


    // $ANTLR start "rulePinAssign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1581:1: rulePinAssign returns [EObject current=null] : ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) ;
    public final EObject rulePinAssign() throws RecognitionException {
        EObject current = null;

        Token lv_combined_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_qualifier_2_0 = null;

        EObject lv_slices_4_0 = null;

        EObject lv_qualifier_6_0 = null;

        EObject lv_slices_8_0 = null;

        EObject lv_concatenation_10_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1584:28: ( ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==28) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_ID||(LA31_0>=RULE_INT && LA31_0<=RULE_PINNUM)||LA31_0==40) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:4: ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')'
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1585:4: ( (lv_combined_0_0= 'combine' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1586:1: (lv_combined_0_0= 'combine' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1586:1: (lv_combined_0_0= 'combine' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1587:3: lv_combined_0_0= 'combine'
                    {
                    lv_combined_0_0=(Token)match(input,28,FOLLOW_28_in_rulePinAssign3382); 

                            newLeafNode(lv_combined_0_0, grammarAccess.getPinAssignAccess().getCombinedCombineKeyword_0_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPinAssignRule());
                    	        }
                           		setWithLastConsumed(current, "combined", true, "combine");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_rulePinAssign3407); 

                        	newLeafNode(otherlv_1, grammarAccess.getPinAssignAccess().getLeftParenthesisKeyword_0_0_1());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1604:1: ( (lv_qualifier_2_0= ruleQualifier ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==40) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1605:1: (lv_qualifier_2_0= ruleQualifier )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1605:1: (lv_qualifier_2_0= ruleQualifier )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1606:3: lv_qualifier_2_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getQualifierQualifierParserRuleCall_0_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePinAssign3428);
                            lv_qualifier_2_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_2_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1622:3: ( ( rulePhdlID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1623:1: ( rulePhdlID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1623:1: ( rulePhdlID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1624:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPinAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPinAssignAccess().getRefPinCrossReference_0_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePinAssign3452);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1637:2: ( (lv_slices_4_0= ruleSlices ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==38) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1638:1: (lv_slices_4_0= ruleSlices )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1638:1: (lv_slices_4_0= ruleSlices )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1639:3: lv_slices_4_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getSlicesSlicesParserRuleCall_0_0_4_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePinAssign3473);
                            lv_slices_4_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_4_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_rulePinAssign3486); 

                        	newLeafNode(otherlv_5, grammarAccess.getPinAssignAccess().getRightParenthesisKeyword_0_0_5());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1660:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1660:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1660:7: ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )?
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1660:7: ( (lv_qualifier_6_0= ruleQualifier ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==40) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1661:1: (lv_qualifier_6_0= ruleQualifier )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1661:1: (lv_qualifier_6_0= ruleQualifier )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1662:3: lv_qualifier_6_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getQualifierQualifierParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePinAssign3515);
                            lv_qualifier_6_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_6_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1678:3: ( ( rulePhdlID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1679:1: ( rulePhdlID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1679:1: ( rulePhdlID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1680:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPinAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPinAssignAccess().getRefPinCrossReference_0_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePinAssign3539);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1693:2: ( (lv_slices_8_0= ruleSlices ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==38) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1694:1: (lv_slices_8_0= ruleSlices )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1694:1: (lv_slices_8_0= ruleSlices )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1695:3: lv_slices_8_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPinAssignAccess().getSlicesSlicesParserRuleCall_0_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePinAssign3560);
                            lv_slices_8_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_8_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_rulePinAssign3575); 

                	newLeafNode(otherlv_9, grammarAccess.getPinAssignAccess().getEqualsSignKeyword_1());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1715:1: ( (lv_concatenation_10_0= ruleConcatenation ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1716:1: (lv_concatenation_10_0= ruleConcatenation )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1716:1: (lv_concatenation_10_0= ruleConcatenation )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1717:3: lv_concatenation_10_0= ruleConcatenation
            {
             
            	        newCompositeNode(grammarAccess.getPinAssignAccess().getConcatenationConcatenationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleConcatenation_in_rulePinAssign3596);
            lv_concatenation_10_0=ruleConcatenation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPinAssignRule());
            	        }
                   		set(
                   			current, 
                   			"concatenation",
                    		lv_concatenation_10_0, 
                    		"Concatenation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_rulePinAssign3608); 

                	newLeafNode(otherlv_11, grammarAccess.getPinAssignAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePinAssign"


    // $ANTLR start "entryRuleSubAttr"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1745:1: entryRuleSubAttr returns [EObject current=null] : iv_ruleSubAttr= ruleSubAttr EOF ;
    public final EObject entryRuleSubAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubAttr = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1746:2: (iv_ruleSubAttr= ruleSubAttr EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1747:2: iv_ruleSubAttr= ruleSubAttr EOF
            {
             newCompositeNode(grammarAccess.getSubAttrRule()); 
            pushFollow(FOLLOW_ruleSubAttr_in_entryRuleSubAttr3644);
            iv_ruleSubAttr=ruleSubAttr();

            state._fsp--;

             current =iv_ruleSubAttr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubAttr3654); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubAttr"


    // $ANTLR start "ruleSubAttr"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1754:1: ruleSubAttr returns [EObject current=null] : ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' ) ;
    public final EObject ruleSubAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        EObject lv_qualifier_0_0 = null;

        EObject lv_refIndices_2_0 = null;

        EObject lv_tail_3_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1757:28: ( ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1758:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1758:1: ( ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1758:2: ( (lv_qualifier_0_0= ruleQualifier ) )? ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STRING ) ) otherlv_6= ';'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1758:2: ( (lv_qualifier_0_0= ruleQualifier ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1759:1: (lv_qualifier_0_0= ruleQualifier )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1759:1: (lv_qualifier_0_0= ruleQualifier )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1760:3: lv_qualifier_0_0= ruleQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubAttrAccess().getQualifierQualifierParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifier_in_ruleSubAttr3700);
                    lv_qualifier_0_0=ruleQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"qualifier",
                            		lv_qualifier_0_0, 
                            		"Qualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1776:3: ( (otherlv_1= RULE_ID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1777:1: (otherlv_1= RULE_ID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1777:1: (otherlv_1= RULE_ID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1778:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubAttrRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubAttr3721); 

            		newLeafNode(otherlv_1, grammarAccess.getSubAttrAccess().getRefReferenceableCrossReference_1_0()); 
            	

            }


            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1789:2: ( (lv_refIndices_2_0= ruleIndices ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1790:1: (lv_refIndices_2_0= ruleIndices )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1790:1: (lv_refIndices_2_0= ruleIndices )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1791:3: lv_refIndices_2_0= ruleIndices
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubAttrAccess().getRefIndicesIndicesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndices_in_ruleSubAttr3742);
                    lv_refIndices_2_0=ruleIndices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubAttrRule());
                    	        }
                           		set(
                           			current, 
                           			"refIndices",
                            		lv_refIndices_2_0, 
                            		"Indices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1807:3: ( (lv_tail_3_0= ruleRefTail ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1808:1: (lv_tail_3_0= ruleRefTail )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1808:1: (lv_tail_3_0= ruleRefTail )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1809:3: lv_tail_3_0= ruleRefTail
            {
             
            	        newCompositeNode(grammarAccess.getSubAttrAccess().getTailRefTailParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleRefTail_in_ruleSubAttr3764);
            lv_tail_3_0=ruleRefTail();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubAttrRule());
            	        }
                   		set(
                   			current, 
                   			"tail",
                    		lv_tail_3_0, 
                    		"RefTail");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleSubAttr3776); 

                	newLeafNode(otherlv_4, grammarAccess.getSubAttrAccess().getEqualsSignKeyword_4());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1829:1: ( (lv_value_5_0= RULE_STRING ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1830:1: (lv_value_5_0= RULE_STRING )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1830:1: (lv_value_5_0= RULE_STRING )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1831:3: lv_value_5_0= RULE_STRING
            {
            lv_value_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSubAttr3793); 

            			newLeafNode(lv_value_5_0, grammarAccess.getSubAttrAccess().getValueSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSubAttrRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleSubAttr3810); 

                	newLeafNode(otherlv_6, grammarAccess.getSubAttrAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubAttr"


    // $ANTLR start "entryRuleRefTail"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1859:1: entryRuleRefTail returns [EObject current=null] : iv_ruleRefTail= ruleRefTail EOF ;
    public final EObject entryRuleRefTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefTail = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1860:2: (iv_ruleRefTail= ruleRefTail EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1861:2: iv_ruleRefTail= ruleRefTail EOF
            {
             newCompositeNode(grammarAccess.getRefTailRule()); 
            pushFollow(FOLLOW_ruleRefTail_in_entryRuleRefTail3846);
            iv_ruleRefTail=ruleRefTail();

            state._fsp--;

             current =iv_ruleRefTail; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRefTail3856); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefTail"


    // $ANTLR start "ruleRefTail"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1868:1: ruleRefTail returns [EObject current=null] : (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? ) ;
    public final EObject ruleRefTail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_refIndices_2_0 = null;

        EObject lv_tail_3_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1871:28: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1872:1: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1872:1: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )? )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1872:3: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) ( (lv_refIndices_2_0= ruleIndices ) )? ( (lv_tail_3_0= ruleRefTail ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleRefTail3893); 

                	newLeafNode(otherlv_0, grammarAccess.getRefTailAccess().getFullStopKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1876:1: ( (otherlv_1= RULE_ID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1877:1: (otherlv_1= RULE_ID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1877:1: (otherlv_1= RULE_ID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1878:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRefTailRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRefTail3913); 

            		newLeafNode(otherlv_1, grammarAccess.getRefTailAccess().getRefReferenceableCrossReference_1_0()); 
            	

            }


            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1889:2: ( (lv_refIndices_2_0= ruleIndices ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1890:1: (lv_refIndices_2_0= ruleIndices )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1890:1: (lv_refIndices_2_0= ruleIndices )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1891:3: lv_refIndices_2_0= ruleIndices
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefTailAccess().getRefIndicesIndicesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndices_in_ruleRefTail3934);
                    lv_refIndices_2_0=ruleIndices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefTailRule());
                    	        }
                           		set(
                           			current, 
                           			"refIndices",
                            		lv_refIndices_2_0, 
                            		"Indices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1907:3: ( (lv_tail_3_0= ruleRefTail ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==31) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1908:1: (lv_tail_3_0= ruleRefTail )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1908:1: (lv_tail_3_0= ruleRefTail )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1909:3: lv_tail_3_0= ruleRefTail
                    {
                     
                    	        newCompositeNode(grammarAccess.getRefTailAccess().getTailRefTailParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRefTail_in_ruleRefTail3956);
                    lv_tail_3_0=ruleRefTail();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRefTailRule());
                    	        }
                           		set(
                           			current, 
                           			"tail",
                            		lv_tail_3_0, 
                            		"RefTail");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefTail"


    // $ANTLR start "entryRulePortAssign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1933:1: entryRulePortAssign returns [EObject current=null] : iv_rulePortAssign= rulePortAssign EOF ;
    public final EObject entryRulePortAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortAssign = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1934:2: (iv_rulePortAssign= rulePortAssign EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1935:2: iv_rulePortAssign= rulePortAssign EOF
            {
             newCompositeNode(grammarAccess.getPortAssignRule()); 
            pushFollow(FOLLOW_rulePortAssign_in_entryRulePortAssign3993);
            iv_rulePortAssign=rulePortAssign();

            state._fsp--;

             current =iv_rulePortAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortAssign4003); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortAssign"


    // $ANTLR start "rulePortAssign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1942:1: rulePortAssign returns [EObject current=null] : ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) ;
    public final EObject rulePortAssign() throws RecognitionException {
        EObject current = null;

        Token lv_combined_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_qualifier_2_0 = null;

        EObject lv_slices_4_0 = null;

        EObject lv_qualifier_6_0 = null;

        EObject lv_slices_8_0 = null;

        EObject lv_concatenation_10_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1945:28: ( ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:1: ( ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) ) otherlv_9= '=' ( (lv_concatenation_10_0= ruleConcatenation ) ) otherlv_11= ';'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:2: ( ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' ) | ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID||(LA40_0>=RULE_INT && LA40_0<=RULE_PINNUM)||LA40_0==40) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:3: ( ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:4: ( (lv_combined_0_0= 'combine' ) ) otherlv_1= '(' ( (lv_qualifier_2_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_4_0= ruleSlices ) )? otherlv_5= ')'
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1946:4: ( (lv_combined_0_0= 'combine' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1947:1: (lv_combined_0_0= 'combine' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1947:1: (lv_combined_0_0= 'combine' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1948:3: lv_combined_0_0= 'combine'
                    {
                    lv_combined_0_0=(Token)match(input,28,FOLLOW_28_in_rulePortAssign4048); 

                            newLeafNode(lv_combined_0_0, grammarAccess.getPortAssignAccess().getCombinedCombineKeyword_0_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortAssignRule());
                    	        }
                           		setWithLastConsumed(current, "combined", true, "combine");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_rulePortAssign4073); 

                        	newLeafNode(otherlv_1, grammarAccess.getPortAssignAccess().getLeftParenthesisKeyword_0_0_1());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1965:1: ( (lv_qualifier_2_0= ruleQualifier ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==40) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1966:1: (lv_qualifier_2_0= ruleQualifier )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1966:1: (lv_qualifier_2_0= ruleQualifier )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1967:3: lv_qualifier_2_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getQualifierQualifierParserRuleCall_0_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePortAssign4094);
                            lv_qualifier_2_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_2_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1983:3: ( ( rulePhdlID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1984:1: ( rulePhdlID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1984:1: ( rulePhdlID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1985:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPortAssignAccess().getRefConnectionNameCrossReference_0_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePortAssign4118);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1998:2: ( (lv_slices_4_0= ruleSlices ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==38) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1999:1: (lv_slices_4_0= ruleSlices )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:1999:1: (lv_slices_4_0= ruleSlices )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2000:3: lv_slices_4_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getSlicesSlicesParserRuleCall_0_0_4_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePortAssign4139);
                            lv_slices_4_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_4_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_rulePortAssign4152); 

                        	newLeafNode(otherlv_5, grammarAccess.getPortAssignAccess().getRightParenthesisKeyword_0_0_5());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2021:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2021:6: ( ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )? )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2021:7: ( (lv_qualifier_6_0= ruleQualifier ) )? ( ( rulePhdlID ) ) ( (lv_slices_8_0= ruleSlices ) )?
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2021:7: ( (lv_qualifier_6_0= ruleQualifier ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==40) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2022:1: (lv_qualifier_6_0= ruleQualifier )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2022:1: (lv_qualifier_6_0= ruleQualifier )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2023:3: lv_qualifier_6_0= ruleQualifier
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getQualifierQualifierParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifier_in_rulePortAssign4181);
                            lv_qualifier_6_0=ruleQualifier();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"qualifier",
                                    		lv_qualifier_6_0, 
                                    		"Qualifier");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2039:3: ( ( rulePhdlID ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2040:1: ( rulePhdlID )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2040:1: ( rulePhdlID )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2041:3: rulePhdlID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortAssignRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPortAssignAccess().getRefConnectionNameCrossReference_0_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePhdlID_in_rulePortAssign4205);
                    rulePhdlID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2054:2: ( (lv_slices_8_0= ruleSlices ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==38) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2055:1: (lv_slices_8_0= ruleSlices )
                            {
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2055:1: (lv_slices_8_0= ruleSlices )
                            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2056:3: lv_slices_8_0= ruleSlices
                            {
                             
                            	        newCompositeNode(grammarAccess.getPortAssignAccess().getSlicesSlicesParserRuleCall_0_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSlices_in_rulePortAssign4226);
                            lv_slices_8_0=ruleSlices();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"slices",
                                    		lv_slices_8_0, 
                                    		"Slices");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_rulePortAssign4241); 

                	newLeafNode(otherlv_9, grammarAccess.getPortAssignAccess().getEqualsSignKeyword_1());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2076:1: ( (lv_concatenation_10_0= ruleConcatenation ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2077:1: (lv_concatenation_10_0= ruleConcatenation )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2077:1: (lv_concatenation_10_0= ruleConcatenation )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2078:3: lv_concatenation_10_0= ruleConcatenation
            {
             
            	        newCompositeNode(grammarAccess.getPortAssignAccess().getConcatenationConcatenationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleConcatenation_in_rulePortAssign4262);
            lv_concatenation_10_0=ruleConcatenation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortAssignRule());
            	        }
                   		set(
                   			current, 
                   			"concatenation",
                    		lv_concatenation_10_0, 
                    		"Concatenation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_rulePortAssign4274); 

                	newLeafNode(otherlv_11, grammarAccess.getPortAssignAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortAssign"


    // $ANTLR start "entryRuleConnectionAssign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2106:1: entryRuleConnectionAssign returns [EObject current=null] : iv_ruleConnectionAssign= ruleConnectionAssign EOF ;
    public final EObject entryRuleConnectionAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionAssign = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2107:2: (iv_ruleConnectionAssign= ruleConnectionAssign EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2108:2: iv_ruleConnectionAssign= ruleConnectionAssign EOF
            {
             newCompositeNode(grammarAccess.getConnectionAssignRule()); 
            pushFollow(FOLLOW_ruleConnectionAssign_in_entryRuleConnectionAssign4310);
            iv_ruleConnectionAssign=ruleConnectionAssign();

            state._fsp--;

             current =iv_ruleConnectionAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionAssign4320); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionAssign"


    // $ANTLR start "ruleConnectionAssign"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2115:1: ruleConnectionAssign returns [EObject current=null] : ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' ) ;
    public final EObject ruleConnectionAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_slices_1_0 = null;

        EObject lv_concatenation_3_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2118:28: ( ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2119:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2119:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2119:2: ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? otherlv_2= '=' ( (lv_concatenation_3_0= ruleConcatenation ) ) otherlv_4= ';'
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2119:2: ( ( rulePhdlID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2120:1: ( rulePhdlID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2120:1: ( rulePhdlID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2121:3: rulePhdlID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionAssignRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionAssignAccess().getRefConnectionNameCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleConnectionAssign4368);
            rulePhdlID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2134:2: ( (lv_slices_1_0= ruleSlices ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==38) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2135:1: (lv_slices_1_0= ruleSlices )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2135:1: (lv_slices_1_0= ruleSlices )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2136:3: lv_slices_1_0= ruleSlices
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionAssignAccess().getSlicesSlicesParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSlices_in_ruleConnectionAssign4389);
                    lv_slices_1_0=ruleSlices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionAssignRule());
                    	        }
                           		set(
                           			current, 
                           			"slices",
                            		lv_slices_1_0, 
                            		"Slices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleConnectionAssign4402); 

                	newLeafNode(otherlv_2, grammarAccess.getConnectionAssignAccess().getEqualsSignKeyword_2());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2156:1: ( (lv_concatenation_3_0= ruleConcatenation ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2157:1: (lv_concatenation_3_0= ruleConcatenation )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2157:1: (lv_concatenation_3_0= ruleConcatenation )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2158:3: lv_concatenation_3_0= ruleConcatenation
            {
             
            	        newCompositeNode(grammarAccess.getConnectionAssignAccess().getConcatenationConcatenationParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleConcatenation_in_ruleConnectionAssign4423);
            lv_concatenation_3_0=ruleConcatenation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionAssignRule());
            	        }
                   		set(
                   			current, 
                   			"concatenation",
                    		lv_concatenation_3_0, 
                    		"Concatenation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConnectionAssign4435); 

                	newLeafNode(otherlv_4, grammarAccess.getConnectionAssignAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionAssign"


    // $ANTLR start "entryRuleConcatenation"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2186:1: entryRuleConcatenation returns [EObject current=null] : iv_ruleConcatenation= ruleConcatenation EOF ;
    public final EObject entryRuleConcatenation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenation = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2187:2: (iv_ruleConcatenation= ruleConcatenation EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2188:2: iv_ruleConcatenation= ruleConcatenation EOF
            {
             newCompositeNode(grammarAccess.getConcatenationRule()); 
            pushFollow(FOLLOW_ruleConcatenation_in_entryRuleConcatenation4471);
            iv_ruleConcatenation=ruleConcatenation();

            state._fsp--;

             current =iv_ruleConcatenation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcatenation4481); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatenation"


    // $ANTLR start "ruleConcatenation"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2195:1: ruleConcatenation returns [EObject current=null] : ( (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' ) | ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' ) | ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) ) | ( (lv_open_13_0= 'open' ) ) ) ;
    public final EObject ruleConcatenation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_replicated_8_0=null;
        Token otherlv_10=null;
        Token lv_replicated_12_0=null;
        Token lv_open_13_0=null;
        EObject lv_connections_1_0 = null;

        EObject lv_connections_3_0 = null;

        EObject lv_connections_5_0 = null;

        EObject lv_connections_7_0 = null;

        EObject lv_replicate_9_0 = null;

        EObject lv_replicate_11_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2198:28: ( ( (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' ) | ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' ) | ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) ) | ( (lv_open_13_0= 'open' ) ) ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2199:1: ( (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' ) | ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' ) | ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) ) | ( (lv_open_13_0= 'open' ) ) )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2199:1: ( (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' ) | ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' ) | ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) ) | ( (lv_open_13_0= 'open' ) ) )
            int alt44=5;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2199:2: (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2199:2: (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2199:4: otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleConcatenation4519); 

                        	newLeafNode(otherlv_0, grammarAccess.getConcatenationAccess().getLeftCurlyBracketKeyword_0_0());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2203:1: ( (lv_connections_1_0= ruleConnectionRef ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2204:1: (lv_connections_1_0= ruleConnectionRef )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2204:1: (lv_connections_1_0= ruleConnectionRef )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2205:3: lv_connections_1_0= ruleConnectionRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConcatenationAccess().getConnectionsConnectionRefParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4540);
                    lv_connections_1_0=ruleConnectionRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	        }
                           		add(
                           			current, 
                           			"connections",
                            		lv_connections_1_0, 
                            		"ConnectionRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2221:2: (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==19) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2221:4: otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) )
                    	    {
                    	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleConcatenation4553); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getConcatenationAccess().getCommaKeyword_0_2_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2225:1: ( (lv_connections_3_0= ruleConnectionRef ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2226:1: (lv_connections_3_0= ruleConnectionRef )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2226:1: (lv_connections_3_0= ruleConnectionRef )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2227:3: lv_connections_3_0= ruleConnectionRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConcatenationAccess().getConnectionsConnectionRefParserRuleCall_0_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4574);
                    	    lv_connections_3_0=ruleConnectionRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_3_0, 
                    	            		"ConnectionRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleConcatenation4588); 

                        	newLeafNode(otherlv_4, grammarAccess.getConcatenationAccess().getRightCurlyBracketKeyword_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2248:6: ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2248:6: ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2248:7: ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )*
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2248:7: ( (lv_connections_5_0= ruleConnectionRef ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2249:1: (lv_connections_5_0= ruleConnectionRef )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2249:1: (lv_connections_5_0= ruleConnectionRef )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2250:3: lv_connections_5_0= ruleConnectionRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConcatenationAccess().getConnectionsConnectionRefParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4617);
                    lv_connections_5_0=ruleConnectionRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	        }
                           		add(
                           			current, 
                           			"connections",
                            		lv_connections_5_0, 
                            		"ConnectionRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2266:2: (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==32) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2266:4: otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleConcatenation4630); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getConcatenationAccess().getAmpersandKeyword_1_1_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2270:1: ( (lv_connections_7_0= ruleConnectionRef ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2271:1: (lv_connections_7_0= ruleConnectionRef )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2271:1: (lv_connections_7_0= ruleConnectionRef )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2272:3: lv_connections_7_0= ruleConnectionRef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConcatenationAccess().getConnectionsConnectionRefParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4651);
                    	    lv_connections_7_0=ruleConnectionRef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connections",
                    	            		lv_connections_7_0, 
                    	            		"ConnectionRef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2289:6: ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2289:6: ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2289:7: ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>'
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2289:7: ( (lv_replicated_8_0= '<' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2290:1: (lv_replicated_8_0= '<' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2290:1: (lv_replicated_8_0= '<' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2291:3: lv_replicated_8_0= '<'
                    {
                    lv_replicated_8_0=(Token)match(input,33,FOLLOW_33_in_ruleConcatenation4679); 

                            newLeafNode(lv_replicated_8_0, grammarAccess.getConcatenationAccess().getReplicatedLessThanSignKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConcatenationRule());
                    	        }
                           		setWithLastConsumed(current, "replicated", true, "<");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2304:2: ( (lv_replicate_9_0= ruleConnectionRef ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2305:1: (lv_replicate_9_0= ruleConnectionRef )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2305:1: (lv_replicate_9_0= ruleConnectionRef )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2306:3: lv_replicate_9_0= ruleConnectionRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConcatenationAccess().getReplicateConnectionRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4713);
                    lv_replicate_9_0=ruleConnectionRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	        }
                           		set(
                           			current, 
                           			"replicate",
                            		lv_replicate_9_0, 
                            		"ConnectionRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleConcatenation4725); 

                        	newLeafNode(otherlv_10, grammarAccess.getConcatenationAccess().getGreaterThanSignKeyword_2_2());
                        

                    }


                    }
                    break;
                case 4 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:6: ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:6: ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:7: ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2327:7: ( (lv_replicate_11_0= ruleConnectionRef ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2328:1: (lv_replicate_11_0= ruleConnectionRef )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2328:1: (lv_replicate_11_0= ruleConnectionRef )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2329:3: lv_replicate_11_0= ruleConnectionRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConcatenationAccess().getReplicateConnectionRefParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConnectionRef_in_ruleConcatenation4754);
                    lv_replicate_11_0=ruleConnectionRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConcatenationRule());
                    	        }
                           		set(
                           			current, 
                           			"replicate",
                            		lv_replicate_11_0, 
                            		"ConnectionRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2345:2: ( (lv_replicated_12_0= '*' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2346:1: (lv_replicated_12_0= '*' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2346:1: (lv_replicated_12_0= '*' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2347:3: lv_replicated_12_0= '*'
                    {
                    lv_replicated_12_0=(Token)match(input,35,FOLLOW_35_in_ruleConcatenation4772); 

                            newLeafNode(lv_replicated_12_0, grammarAccess.getConcatenationAccess().getReplicatedAsteriskKeyword_3_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConcatenationRule());
                    	        }
                           		setWithLastConsumed(current, "replicated", true, "*");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2361:6: ( (lv_open_13_0= 'open' ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2361:6: ( (lv_open_13_0= 'open' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2362:1: (lv_open_13_0= 'open' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2362:1: (lv_open_13_0= 'open' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2363:3: lv_open_13_0= 'open'
                    {
                    lv_open_13_0=(Token)match(input,36,FOLLOW_36_in_ruleConcatenation4810); 

                            newLeafNode(lv_open_13_0, grammarAccess.getConcatenationAccess().getOpenOpenKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConcatenationRule());
                    	        }
                           		setWithLastConsumed(current, "open", true, "open");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatenation"


    // $ANTLR start "entryRuleConnectionRef"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2384:1: entryRuleConnectionRef returns [EObject current=null] : iv_ruleConnectionRef= ruleConnectionRef EOF ;
    public final EObject entryRuleConnectionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionRef = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2385:2: (iv_ruleConnectionRef= ruleConnectionRef EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2386:2: iv_ruleConnectionRef= ruleConnectionRef EOF
            {
             newCompositeNode(grammarAccess.getConnectionRefRule()); 
            pushFollow(FOLLOW_ruleConnectionRef_in_entryRuleConnectionRef4859);
            iv_ruleConnectionRef=ruleConnectionRef();

            state._fsp--;

             current =iv_ruleConnectionRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionRef4869); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionRef"


    // $ANTLR start "ruleConnectionRef"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2393:1: ruleConnectionRef returns [EObject current=null] : ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? ) ;
    public final EObject ruleConnectionRef() throws RecognitionException {
        EObject current = null;

        EObject lv_slices_1_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2396:28: ( ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2397:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2397:1: ( ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )? )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2397:2: ( ( rulePhdlID ) ) ( (lv_slices_1_0= ruleSlices ) )?
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2397:2: ( ( rulePhdlID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2398:1: ( rulePhdlID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2398:1: ( rulePhdlID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2399:3: rulePhdlID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionRefAccess().getRefConnectionNameCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleConnectionRef4917);
            rulePhdlID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2412:2: ( (lv_slices_1_0= ruleSlices ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2413:1: (lv_slices_1_0= ruleSlices )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2413:1: (lv_slices_1_0= ruleSlices )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2414:3: lv_slices_1_0= ruleSlices
                    {
                     
                    	        newCompositeNode(grammarAccess.getConnectionRefAccess().getSlicesSlicesParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSlices_in_ruleConnectionRef4938);
                    lv_slices_1_0=ruleSlices();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConnectionRefRule());
                    	        }
                           		set(
                           			current, 
                           			"slices",
                            		lv_slices_1_0, 
                            		"Slices");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionRef"


    // $ANTLR start "entryRuleConnectionName"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2438:1: entryRuleConnectionName returns [EObject current=null] : iv_ruleConnectionName= ruleConnectionName EOF ;
    public final EObject entryRuleConnectionName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionName = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2439:2: (iv_ruleConnectionName= ruleConnectionName EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2440:2: iv_ruleConnectionName= ruleConnectionName EOF
            {
             newCompositeNode(grammarAccess.getConnectionNameRule()); 
            pushFollow(FOLLOW_ruleConnectionName_in_entryRuleConnectionName4975);
            iv_ruleConnectionName=ruleConnectionName();

            state._fsp--;

             current =iv_ruleConnectionName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionName4985); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionName"


    // $ANTLR start "ruleConnectionName"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2447:1: ruleConnectionName returns [EObject current=null] : ( (lv_name_0_0= rulePhdlID ) ) ;
    public final EObject ruleConnectionName() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2450:28: ( ( (lv_name_0_0= rulePhdlID ) ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2451:1: ( (lv_name_0_0= rulePhdlID ) )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2451:1: ( (lv_name_0_0= rulePhdlID ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2452:1: (lv_name_0_0= rulePhdlID )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2452:1: (lv_name_0_0= rulePhdlID )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2453:3: lv_name_0_0= rulePhdlID
            {
             
            	        newCompositeNode(grammarAccess.getConnectionNameAccess().getNamePhdlIDParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_rulePhdlID_in_ruleConnectionName5030);
            lv_name_0_0=rulePhdlID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionNameRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"PhdlID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionName"


    // $ANTLR start "entryRuleIndices"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2477:1: entryRuleIndices returns [EObject current=null] : iv_ruleIndices= ruleIndices EOF ;
    public final EObject entryRuleIndices() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndices = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2478:2: (iv_ruleIndices= ruleIndices EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2479:2: iv_ruleIndices= ruleIndices EOF
            {
             newCompositeNode(grammarAccess.getIndicesRule()); 
            pushFollow(FOLLOW_ruleIndices_in_entryRuleIndices5065);
            iv_ruleIndices=ruleIndices();

            state._fsp--;

             current =iv_ruleIndices; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndices5075); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndices"


    // $ANTLR start "ruleIndices"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2486:1: ruleIndices returns [EObject current=null] : (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' ) ;
    public final EObject ruleIndices() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_msb_1_0=null;
        Token lv_array_2_0=null;
        Token lv_lsb_3_0=null;
        Token lv_indices_4_0=null;
        Token otherlv_5=null;
        Token lv_indices_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2489:28: ( (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2490:1: (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2490:1: (otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2490:3: otherlv_0= '(' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleIndices5112); 

                	newLeafNode(otherlv_0, grammarAccess.getIndicesAccess().getLeftParenthesisKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:1: ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_INT) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==19||LA47_1==30) ) {
                    alt47=2;
                }
                else if ( (LA47_1==37) ) {
                    alt47=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:3: ( (lv_msb_1_0= RULE_INT ) ) ( (lv_array_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2494:3: ( (lv_msb_1_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2495:1: (lv_msb_1_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2495:1: (lv_msb_1_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2496:3: lv_msb_1_0= RULE_INT
                    {
                    lv_msb_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5131); 

                    			newLeafNode(lv_msb_1_0, grammarAccess.getIndicesAccess().getMsbINTTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_1_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2512:2: ( (lv_array_2_0= ':' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2513:1: (lv_array_2_0= ':' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2513:1: (lv_array_2_0= ':' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2514:3: lv_array_2_0= ':'
                    {
                    lv_array_2_0=(Token)match(input,37,FOLLOW_37_in_ruleIndices5154); 

                            newLeafNode(lv_array_2_0, grammarAccess.getIndicesAccess().getArrayColonKeyword_1_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		setWithLastConsumed(current, "array", true, ":");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2527:2: ( (lv_lsb_3_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2528:1: (lv_lsb_3_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2528:1: (lv_lsb_3_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2529:3: lv_lsb_3_0= RULE_INT
                    {
                    lv_lsb_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5184); 

                    			newLeafNode(lv_lsb_3_0, grammarAccess.getIndicesAccess().getLsbINTTerminalRuleCall_1_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_3_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2546:6: ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2546:6: ( ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )* )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2546:7: ( (lv_indices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )*
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2546:7: ( (lv_indices_4_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2547:1: (lv_indices_4_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2547:1: (lv_indices_4_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2548:3: lv_indices_4_0= RULE_INT
                    {
                    lv_indices_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5214); 

                    			newLeafNode(lv_indices_4_0, grammarAccess.getIndicesAccess().getIndicesINTTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"indices",
                            		lv_indices_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2564:2: (otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==19) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2564:4: otherlv_5= ',' ( (lv_indices_6_0= RULE_INT ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleIndices5232); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getIndicesAccess().getCommaKeyword_1_1_1_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2568:1: ( (lv_indices_6_0= RULE_INT ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2569:1: (lv_indices_6_0= RULE_INT )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2569:1: (lv_indices_6_0= RULE_INT )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2570:3: lv_indices_6_0= RULE_INT
                    	    {
                    	    lv_indices_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndices5249); 

                    	    			newLeafNode(lv_indices_6_0, grammarAccess.getIndicesAccess().getIndicesINTTerminalRuleCall_1_1_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getIndicesRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"indices",
                    	            		lv_indices_6_0, 
                    	            		"INT");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleIndices5270); 

                	newLeafNode(otherlv_7, grammarAccess.getIndicesAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndices"


    // $ANTLR start "entryRuleSlices"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2598:1: entryRuleSlices returns [EObject current=null] : iv_ruleSlices= ruleSlices EOF ;
    public final EObject entryRuleSlices() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSlices = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2599:2: (iv_ruleSlices= ruleSlices EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2600:2: iv_ruleSlices= ruleSlices EOF
            {
             newCompositeNode(grammarAccess.getSlicesRule()); 
            pushFollow(FOLLOW_ruleSlices_in_entryRuleSlices5306);
            iv_ruleSlices=ruleSlices();

            state._fsp--;

             current =iv_ruleSlices; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSlices5316); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSlices"


    // $ANTLR start "ruleSlices"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2607:1: ruleSlices returns [EObject current=null] : (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' ) ;
    public final EObject ruleSlices() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_msb_1_0=null;
        Token lv_vector_2_0=null;
        Token lv_lsb_3_0=null;
        Token lv_slices_4_0=null;
        Token otherlv_5=null;
        Token lv_slices_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2610:28: ( (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2611:1: (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2611:1: (otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2611:3: otherlv_0= '[' ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleSlices5353); 

                	newLeafNode(otherlv_0, grammarAccess.getSlicesAccess().getLeftSquareBracketKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:1: ( ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) ) | ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_INT) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==37) ) {
                    alt49=1;
                }
                else if ( (LA49_1==19||LA49_1==39) ) {
                    alt49=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:2: ( ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:3: ( (lv_msb_1_0= RULE_INT ) ) ( (lv_vector_2_0= ':' ) ) ( (lv_lsb_3_0= RULE_INT ) )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2615:3: ( (lv_msb_1_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2616:1: (lv_msb_1_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2616:1: (lv_msb_1_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2617:3: lv_msb_1_0= RULE_INT
                    {
                    lv_msb_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5372); 

                    			newLeafNode(lv_msb_1_0, grammarAccess.getSlicesAccess().getMsbINTTerminalRuleCall_1_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_1_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2633:2: ( (lv_vector_2_0= ':' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2634:1: (lv_vector_2_0= ':' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2634:1: (lv_vector_2_0= ':' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2635:3: lv_vector_2_0= ':'
                    {
                    lv_vector_2_0=(Token)match(input,37,FOLLOW_37_in_ruleSlices5395); 

                            newLeafNode(lv_vector_2_0, grammarAccess.getSlicesAccess().getVectorColonKeyword_1_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		setWithLastConsumed(current, "vector", true, ":");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2648:2: ( (lv_lsb_3_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2649:1: (lv_lsb_3_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2649:1: (lv_lsb_3_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2650:3: lv_lsb_3_0= RULE_INT
                    {
                    lv_lsb_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5425); 

                    			newLeafNode(lv_lsb_3_0, grammarAccess.getSlicesAccess().getLsbINTTerminalRuleCall_1_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_3_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2667:6: ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2667:6: ( ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )* )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2667:7: ( (lv_slices_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )*
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2667:7: ( (lv_slices_4_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2668:1: (lv_slices_4_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2668:1: (lv_slices_4_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2669:3: lv_slices_4_0= RULE_INT
                    {
                    lv_slices_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5455); 

                    			newLeafNode(lv_slices_4_0, grammarAccess.getSlicesAccess().getSlicesINTTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"slices",
                            		lv_slices_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2685:2: (otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==19) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2685:4: otherlv_5= ',' ( (lv_slices_6_0= RULE_INT ) )
                    	    {
                    	    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleSlices5473); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getSlicesAccess().getCommaKeyword_1_1_1_0());
                    	        
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2689:1: ( (lv_slices_6_0= RULE_INT ) )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2690:1: (lv_slices_6_0= RULE_INT )
                    	    {
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2690:1: (lv_slices_6_0= RULE_INT )
                    	    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2691:3: lv_slices_6_0= RULE_INT
                    	    {
                    	    lv_slices_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSlices5490); 

                    	    			newLeafNode(lv_slices_6_0, grammarAccess.getSlicesAccess().getSlicesINTTerminalRuleCall_1_1_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSlicesRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"slices",
                    	            		lv_slices_6_0, 
                    	            		"INT");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleSlices5511); 

                	newLeafNode(otherlv_7, grammarAccess.getSlicesAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSlices"


    // $ANTLR start "entryRuleVector"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2719:1: entryRuleVector returns [EObject current=null] : iv_ruleVector= ruleVector EOF ;
    public final EObject entryRuleVector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVector = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2720:2: (iv_ruleVector= ruleVector EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2721:2: iv_ruleVector= ruleVector EOF
            {
             newCompositeNode(grammarAccess.getVectorRule()); 
            pushFollow(FOLLOW_ruleVector_in_entryRuleVector5547);
            iv_ruleVector=ruleVector();

            state._fsp--;

             current =iv_ruleVector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVector5557); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2728:1: ruleVector returns [EObject current=null] : ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? ) ;
    public final EObject ruleVector() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_msb_2_0=null;
        Token lv_vector_3_0=null;
        Token lv_lsb_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2731:28: ( ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2732:1: ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2732:1: ( () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )? )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2732:2: () (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )?
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2732:2: ()
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2733:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVectorAccess().getVectorAction_0(),
                        current);
                

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2738:2: (otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==38) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2738:4: otherlv_1= '[' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_vector_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleVector5604); 

                        	newLeafNode(otherlv_1, grammarAccess.getVectorAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2742:1: ( (lv_msb_2_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2743:1: (lv_msb_2_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2743:1: (lv_msb_2_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2744:3: lv_msb_2_0= RULE_INT
                    {
                    lv_msb_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector5621); 

                    			newLeafNode(lv_msb_2_0, grammarAccess.getVectorAccess().getMsbINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVectorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_2_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2760:2: ( (lv_vector_3_0= ':' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2761:1: (lv_vector_3_0= ':' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2761:1: (lv_vector_3_0= ':' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2762:3: lv_vector_3_0= ':'
                    {
                    lv_vector_3_0=(Token)match(input,37,FOLLOW_37_in_ruleVector5644); 

                            newLeafNode(lv_vector_3_0, grammarAccess.getVectorAccess().getVectorColonKeyword_1_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVectorRule());
                    	        }
                           		setWithLastConsumed(current, "vector", true, ":");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2775:2: ( (lv_lsb_4_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2776:1: (lv_lsb_4_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2776:1: (lv_lsb_4_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2777:3: lv_lsb_4_0= RULE_INT
                    {
                    lv_lsb_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVector5674); 

                    			newLeafNode(lv_lsb_4_0, grammarAccess.getVectorAccess().getLsbINTTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVectorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,39,FOLLOW_39_in_ruleVector5691); 

                        	newLeafNode(otherlv_5, grammarAccess.getVectorAccess().getRightSquareBracketKeyword_1_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVector"


    // $ANTLR start "entryRuleArray"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2805:1: entryRuleArray returns [EObject current=null] : iv_ruleArray= ruleArray EOF ;
    public final EObject entryRuleArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArray = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2806:2: (iv_ruleArray= ruleArray EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2807:2: iv_ruleArray= ruleArray EOF
            {
             newCompositeNode(grammarAccess.getArrayRule()); 
            pushFollow(FOLLOW_ruleArray_in_entryRuleArray5729);
            iv_ruleArray=ruleArray();

            state._fsp--;

             current =iv_ruleArray; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArray5739); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArray"


    // $ANTLR start "ruleArray"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2814:1: ruleArray returns [EObject current=null] : ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_msb_2_0=null;
        Token lv_array_3_0=null;
        Token lv_lsb_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2817:28: ( ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2818:1: ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2818:1: ( () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )? )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2818:2: () (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )?
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2818:2: ()
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2819:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayAccess().getArrayAction_0(),
                        current);
                

            }

            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2824:2: (otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==29) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2824:4: otherlv_1= '(' ( (lv_msb_2_0= RULE_INT ) ) ( (lv_array_3_0= ':' ) ) ( (lv_lsb_4_0= RULE_INT ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleArray5786); 

                        	newLeafNode(otherlv_1, grammarAccess.getArrayAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2828:1: ( (lv_msb_2_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2829:1: (lv_msb_2_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2829:1: (lv_msb_2_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2830:3: lv_msb_2_0= RULE_INT
                    {
                    lv_msb_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleArray5803); 

                    			newLeafNode(lv_msb_2_0, grammarAccess.getArrayAccess().getMsbINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArrayRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"msb",
                            		lv_msb_2_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2846:2: ( (lv_array_3_0= ':' ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2847:1: (lv_array_3_0= ':' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2847:1: (lv_array_3_0= ':' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2848:3: lv_array_3_0= ':'
                    {
                    lv_array_3_0=(Token)match(input,37,FOLLOW_37_in_ruleArray5826); 

                            newLeafNode(lv_array_3_0, grammarAccess.getArrayAccess().getArrayColonKeyword_1_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArrayRule());
                    	        }
                           		setWithLastConsumed(current, "array", true, ":");
                    	    

                    }


                    }

                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2861:2: ( (lv_lsb_4_0= RULE_INT ) )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2862:1: (lv_lsb_4_0= RULE_INT )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2862:1: (lv_lsb_4_0= RULE_INT )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2863:3: lv_lsb_4_0= RULE_INT
                    {
                    lv_lsb_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleArray5856); 

                    			newLeafNode(lv_lsb_4_0, grammarAccess.getArrayAccess().getLsbINTTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArrayRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"lsb",
                            		lv_lsb_4_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleArray5873); 

                        	newLeafNode(otherlv_5, grammarAccess.getArrayAccess().getRightParenthesisKeyword_1_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArray"


    // $ANTLR start "entryRuleQualifier"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2891:1: entryRuleQualifier returns [EObject current=null] : iv_ruleQualifier= ruleQualifier EOF ;
    public final EObject entryRuleQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifier = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2892:2: (iv_ruleQualifier= ruleQualifier EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2893:2: iv_ruleQualifier= ruleQualifier EOF
            {
             newCompositeNode(grammarAccess.getQualifierRule()); 
            pushFollow(FOLLOW_ruleQualifier_in_entryRuleQualifier5911);
            iv_ruleQualifier=ruleQualifier();

            state._fsp--;

             current =iv_ruleQualifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifier5921); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifier"


    // $ANTLR start "ruleQualifier"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2900:1: ruleQualifier returns [EObject current=null] : (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' ) ;
    public final EObject ruleQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_indices_1_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2903:28: ( (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2904:1: (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2904:1: (otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.' )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2904:3: otherlv_0= 'this' ( (lv_indices_1_0= ruleIndices ) ) otherlv_2= '.'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleQualifier5958); 

                	newLeafNode(otherlv_0, grammarAccess.getQualifierAccess().getThisKeyword_0());
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2908:1: ( (lv_indices_1_0= ruleIndices ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2909:1: (lv_indices_1_0= ruleIndices )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2909:1: (lv_indices_1_0= ruleIndices )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2910:3: lv_indices_1_0= ruleIndices
            {
             
            	        newCompositeNode(grammarAccess.getQualifierAccess().getIndicesIndicesParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleIndices_in_ruleQualifier5979);
            lv_indices_1_0=ruleIndices();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"indices",
                    		lv_indices_1_0, 
                    		"Indices");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleQualifier5991); 

                	newLeafNode(otherlv_2, grammarAccess.getQualifierAccess().getFullStopKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifier"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2942:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2943:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2944:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard6032);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard6043); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2951:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2954:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2955:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2955:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2956:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard6090);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2966:1: (kw= '.' kw= '*' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==31) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2967:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleQualifiedNameWithWildCard6109); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0()); 
                        
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleQualifiedNameWithWildCard6122); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2986:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2987:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2988:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6165);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2995:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_PhdlID_0 = null;

        AntlrDatatypeRuleToken this_PhdlID_2 = null;


         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2998:28: ( (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2999:1: (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:2999:1: (this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )? )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3000:5: this_PhdlID_0= rulePhdlID (kw= '.' this_PhdlID_2= rulePhdlID )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameAccess().getPhdlIDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePhdlID_in_ruleQualifiedName6223);
            this_PhdlID_0=rulePhdlID();

            state._fsp--;


            		current.merge(this_PhdlID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3010:1: (kw= '.' this_PhdlID_2= rulePhdlID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==31) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==RULE_ID||(LA53_1>=RULE_INT && LA53_1<=RULE_PINNUM)) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3011:2: kw= '.' this_PhdlID_2= rulePhdlID
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleQualifiedName6242); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getQualifiedNameAccess().getPhdlIDParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_rulePhdlID_in_ruleQualifiedName6264);
                    this_PhdlID_2=rulePhdlID();

                    state._fsp--;


                    		current.merge(this_PhdlID_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRulePhdlID"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3035:1: entryRulePhdlID returns [String current=null] : iv_rulePhdlID= rulePhdlID EOF ;
    public final String entryRulePhdlID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePhdlID = null;


        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3036:2: (iv_rulePhdlID= rulePhdlID EOF )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3037:2: iv_rulePhdlID= rulePhdlID EOF
            {
             newCompositeNode(grammarAccess.getPhdlIDRule()); 
            pushFollow(FOLLOW_rulePhdlID_in_entryRulePhdlID6312);
            iv_rulePhdlID=rulePhdlID();

            state._fsp--;

             current =iv_rulePhdlID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhdlID6323); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhdlID"


    // $ANTLR start "rulePhdlID"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3044:1: rulePhdlID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM ) ;
    public final AntlrDatatypeRuleToken rulePhdlID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_ID_1=null;
        Token this_PINNUM_2=null;

         enterRule(); 
            
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3047:28: ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3048:1: (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3048:1: (this_INT_0= RULE_INT | this_ID_1= RULE_ID | this_PINNUM_2= RULE_PINNUM )
            int alt54=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt54=1;
                }
                break;
            case RULE_ID:
                {
                alt54=2;
                }
                break;
            case RULE_PINNUM:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3048:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePhdlID6363); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getPhdlIDAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3056:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhdlID6389); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getPhdlIDAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3064:10: this_PINNUM_2= RULE_PINNUM
                    {
                    this_PINNUM_2=(Token)match(input,RULE_PINNUM,FOLLOW_RULE_PINNUM_in_rulePhdlID6415); 

                    		current.merge(this_PINNUM_2);
                        
                     
                        newLeafNode(this_PINNUM_2, grammarAccess.getPhdlIDAccess().getPINNUMTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhdlID"


    // $ANTLR start "rulePinType"
    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3079:1: rulePinType returns [Enumerator current=null] : ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) ) ;
    public final Enumerator rulePinType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3081:28: ( ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) ) )
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3082:1: ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) )
            {
            // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3082:1: ( (enumLiteral_0= 'pin' ) | (enumLiteral_1= 'inpin' ) | (enumLiteral_2= 'outpin' ) | (enumLiteral_3= 'iopin' ) | (enumLiteral_4= 'pwrpin' ) | (enumLiteral_5= 'suppin' ) | (enumLiteral_6= 'ocpin' ) | (enumLiteral_7= 'oepin' ) | (enumLiteral_8= 'tripin' ) | (enumLiteral_9= 'passpin' ) | (enumLiteral_10= 'ncpin' ) )
            int alt55=11;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt55=1;
                }
                break;
            case 42:
                {
                alt55=2;
                }
                break;
            case 43:
                {
                alt55=3;
                }
                break;
            case 44:
                {
                alt55=4;
                }
                break;
            case 45:
                {
                alt55=5;
                }
                break;
            case 46:
                {
                alt55=6;
                }
                break;
            case 47:
                {
                alt55=7;
                }
                break;
            case 48:
                {
                alt55=8;
                }
                break;
            case 49:
                {
                alt55=9;
                }
                break;
            case 50:
                {
                alt55=10;
                }
                break;
            case 51:
                {
                alt55=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3082:2: (enumLiteral_0= 'pin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3082:2: (enumLiteral_0= 'pin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3082:4: enumLiteral_0= 'pin'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_41_in_rulePinType6474); 

                            current = grammarAccess.getPinTypeAccess().getPinEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPinTypeAccess().getPinEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3088:6: (enumLiteral_1= 'inpin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3088:6: (enumLiteral_1= 'inpin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3088:8: enumLiteral_1= 'inpin'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_42_in_rulePinType6491); 

                            current = grammarAccess.getPinTypeAccess().getInputEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPinTypeAccess().getInputEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3094:6: (enumLiteral_2= 'outpin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3094:6: (enumLiteral_2= 'outpin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3094:8: enumLiteral_2= 'outpin'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_43_in_rulePinType6508); 

                            current = grammarAccess.getPinTypeAccess().getOutputEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getPinTypeAccess().getOutputEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3100:6: (enumLiteral_3= 'iopin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3100:6: (enumLiteral_3= 'iopin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3100:8: enumLiteral_3= 'iopin'
                    {
                    enumLiteral_3=(Token)match(input,44,FOLLOW_44_in_rulePinType6525); 

                            current = grammarAccess.getPinTypeAccess().getInOutEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getPinTypeAccess().getInOutEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3106:6: (enumLiteral_4= 'pwrpin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3106:6: (enumLiteral_4= 'pwrpin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3106:8: enumLiteral_4= 'pwrpin'
                    {
                    enumLiteral_4=(Token)match(input,45,FOLLOW_45_in_rulePinType6542); 

                            current = grammarAccess.getPinTypeAccess().getPowerEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getPinTypeAccess().getPowerEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3112:6: (enumLiteral_5= 'suppin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3112:6: (enumLiteral_5= 'suppin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3112:8: enumLiteral_5= 'suppin'
                    {
                    enumLiteral_5=(Token)match(input,46,FOLLOW_46_in_rulePinType6559); 

                            current = grammarAccess.getPinTypeAccess().getSupplyEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getPinTypeAccess().getSupplyEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3118:6: (enumLiteral_6= 'ocpin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3118:6: (enumLiteral_6= 'ocpin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3118:8: enumLiteral_6= 'ocpin'
                    {
                    enumLiteral_6=(Token)match(input,47,FOLLOW_47_in_rulePinType6576); 

                            current = grammarAccess.getPinTypeAccess().getOpenCollectorEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getPinTypeAccess().getOpenCollectorEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3124:6: (enumLiteral_7= 'oepin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3124:6: (enumLiteral_7= 'oepin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3124:8: enumLiteral_7= 'oepin'
                    {
                    enumLiteral_7=(Token)match(input,48,FOLLOW_48_in_rulePinType6593); 

                            current = grammarAccess.getPinTypeAccess().getOpenEmitterEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getPinTypeAccess().getOpenEmitterEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3130:6: (enumLiteral_8= 'tripin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3130:6: (enumLiteral_8= 'tripin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3130:8: enumLiteral_8= 'tripin'
                    {
                    enumLiteral_8=(Token)match(input,49,FOLLOW_49_in_rulePinType6610); 

                            current = grammarAccess.getPinTypeAccess().getTristateEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getPinTypeAccess().getTristateEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3136:6: (enumLiteral_9= 'passpin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3136:6: (enumLiteral_9= 'passpin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3136:8: enumLiteral_9= 'passpin'
                    {
                    enumLiteral_9=(Token)match(input,50,FOLLOW_50_in_rulePinType6627); 

                            current = grammarAccess.getPinTypeAccess().getPassiveEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getPinTypeAccess().getPassiveEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3142:6: (enumLiteral_10= 'ncpin' )
                    {
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3142:6: (enumLiteral_10= 'ncpin' )
                    // ../phdl.xtext/src-gen/edu/byu/ee/phdl/parser/antlr/internal/InternalPhdl.g:3142:8: enumLiteral_10= 'ncpin'
                    {
                    enumLiteral_10=(Token)match(input,51,FOLLOW_51_in_rulePinType6644); 

                            current = grammarAccess.getPinTypeAccess().getNoConnectEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getPinTypeAccess().getNoConnectEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePinType"

    // Delegated rules


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA24_eotS =
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\4\1\uffff\1\35\1\22\2\uffff\1\6\1\4\1\23\1\uffff\1\6\1\37\1\6"+
        "\1\23\1\4\1\36";
    static final String DFA24_maxS =
        "\1\50\1\uffff\1\35\1\46\2\uffff\1\6\1\44\1\45\1\uffff\1\6\1\37\1"+
        "\6\1\36\1\7\1\36";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\2\uffff\1\3\1\4\3\uffff\1\2\6\uffff";
    static final String DFA24_specialS =
        "\20\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\3\1\uffff\2\4\11\uffff\1\1\2\uffff\1\5\7\uffff\1\4\13\uffff"+
            "\1\2",
            "",
            "\1\6",
            "\1\7\23\uffff\1\4",
            "",
            "",
            "\1\10",
            "\1\4\1\11\2\4\4\uffff\1\4\24\uffff\1\4\2\uffff\1\4",
            "\1\12\12\uffff\1\13\6\uffff\1\14",
            "",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\12\12\uffff\1\13",
            "\1\3\1\uffff\2\4",
            "\1\13"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "1387:1: (this_Attr_0= ruleAttr | this_RefAttr_1= ruleRefAttr | this_PinAssign_2= rulePinAssign | this_Info_3= ruleInfo )";
        }
    }
    static final String DFA25_eotS =
        "\17\uffff";
    static final String DFA25_eofS =
        "\17\uffff";
    static final String DFA25_minS =
        "\1\4\1\uffff\1\35\1\22\2\uffff\1\6\1\uffff\1\23\1\6\1\37\1\6\1\23"+
        "\1\4\1\36";
    static final String DFA25_maxS =
        "\1\50\1\uffff\1\35\1\46\2\uffff\1\6\1\uffff\1\45\1\6\1\37\1\6\1"+
        "\36\1\7\1\36";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\2\uffff\1\3\1\4\1\uffff\1\2\7\uffff";
    static final String DFA25_specialS =
        "\17\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\3\1\uffff\2\4\11\uffff\1\1\2\uffff\1\5\7\uffff\1\4\13\uffff"+
            "\1\2",
            "",
            "\1\6",
            "\1\4\12\uffff\1\7\1\uffff\1\7\6\uffff\1\4",
            "",
            "",
            "\1\10",
            "",
            "\1\11\12\uffff\1\12\6\uffff\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\11\12\uffff\1\12",
            "\1\3\1\uffff\2\4",
            "\1\12"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1447:1: (this_Attr_0= ruleAttr | this_SubAttr_1= ruleSubAttr | this_PortAssign_2= rulePortAssign | this_Info_3= ruleInfo )";
        }
    }
    static final String DFA44_eotS =
        "\20\uffff";
    static final String DFA44_eofS =
        "\2\uffff\3\10\10\uffff\1\10\2\uffff";
    static final String DFA44_minS =
        "\1\4\1\uffff\3\17\2\uffff\1\6\2\uffff\1\23\2\6\1\17\1\47\1\23";
    static final String DFA44_maxS =
        "\1\44\1\uffff\3\46\2\uffff\1\6\2\uffff\1\47\2\6\1\43\2\47";
    static final String DFA44_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\5\1\uffff\1\2\1\4\6\uffff";
    static final String DFA44_specialS =
        "\20\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\3\1\uffff\1\2\1\4\4\uffff\1\1\24\uffff\1\5\2\uffff\1\6",
            "",
            "\1\10\20\uffff\1\10\2\uffff\1\11\2\uffff\1\7",
            "\1\10\20\uffff\1\10\2\uffff\1\11\2\uffff\1\7",
            "\1\10\20\uffff\1\10\2\uffff\1\11\2\uffff\1\7",
            "",
            "",
            "\1\12",
            "",
            "",
            "\1\14\21\uffff\1\13\1\uffff\1\15",
            "\1\16",
            "\1\17",
            "\1\10\20\uffff\1\10\2\uffff\1\11",
            "\1\15",
            "\1\14\23\uffff\1\15"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "2199:1: ( (otherlv_0= '{' ( (lv_connections_1_0= ruleConnectionRef ) ) (otherlv_2= ',' ( (lv_connections_3_0= ruleConnectionRef ) ) )* otherlv_4= '}' ) | ( ( (lv_connections_5_0= ruleConnectionRef ) ) (otherlv_6= '&' ( (lv_connections_7_0= ruleConnectionRef ) ) )* ) | ( ( (lv_replicated_8_0= '<' ) ) ( (lv_replicate_9_0= ruleConnectionRef ) ) otherlv_10= '>' ) | ( ( (lv_replicate_11_0= ruleConnectionRef ) ) ( (lv_replicated_12_0= '*' ) ) ) | ( (lv_open_13_0= 'open' ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_rulePhdlModel_in_entryRulePhdlModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhdlModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rulePhdlModel131 = new BitSet(new long[]{0x0000000000614802L});
    public static final BitSet FOLLOW_rulePackage_in_rulePhdlModel154 = new BitSet(new long[]{0x0000000000610802L});
    public static final BitSet FOLLOW_ruleDevice_in_rulePhdlModel181 = new BitSet(new long[]{0x0000000000610802L});
    public static final BitSet FOLLOW_ruleDesign_in_rulePhdlModel208 = new BitSet(new long[]{0x0000000000610802L});
    public static final BitSet FOLLOW_rulePackage_in_entryRulePackage246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackage256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rulePackage293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePackage310 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePackage327 = new BitSet(new long[]{0x0000000000616800L});
    public static final BitSet FOLLOW_ruleImport_in_rulePackage348 = new BitSet(new long[]{0x0000000000616800L});
    public static final BitSet FOLLOW_ruleDevice_in_rulePackage371 = new BitSet(new long[]{0x0000000000612800L});
    public static final BitSet FOLLOW_ruleDesign_in_rulePackage398 = new BitSet(new long[]{0x0000000000612800L});
    public static final BitSet FOLLOW_13_in_rulePackage412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleImport495 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport516 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleImport528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDevice_in_entryRuleDevice564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDevice574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDevice611 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleDevice632 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDevice644 = new BitSet(new long[]{0x000FFE0000122000L});
    public static final BitSet FOLLOW_ruleDeviceElement_in_ruleDevice665 = new BitSet(new long[]{0x000FFE0000122000L});
    public static final BitSet FOLLOW_13_in_ruleDevice678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeviceElement_in_entryRuleDeviceElement714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeviceElement724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleDeviceElement771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePin_in_ruleDeviceElement798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleDeviceElement825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_entryRuleAttr860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttr870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleAttr907 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttr924 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAttr941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttr958 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttr975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePin_in_entryRulePin1011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePin1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePinType_in_rulePin1067 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleVector_in_rulePin1088 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePin1109 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePin1121 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePin1133 = new BitSet(new long[]{0x00000000000020D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePin1155 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_19_in_rulePin1168 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePin1189 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_13_in_rulePin1205 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePin1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_entryRuleInfo1253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInfo1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleInfo1300 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInfo1312 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInfo1329 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInfo1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDesign_in_entryRuleDesign1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDesign1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleDesign1436 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22_in_ruleDesign1473 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDesign1504 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDesign1521 = new BitSet(new long[]{0x000FFE000B9220D0L});
    public static final BitSet FOLLOW_ruleDesignElement_in_ruleDesign1542 = new BitSet(new long[]{0x000FFE000B9220D0L});
    public static final BitSet FOLLOW_13_in_ruleDesign1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDesignElement_in_entryRuleDesignElement1591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDesignElement1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnection_in_ruleDesignElement1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstance_in_ruleDesignElement1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionAssign_in_ruleDesignElement1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleDesignElement1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnection_in_entryRuleConnection1764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnection1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleConnection1818 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleVector_in_ruleConnection1852 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection1873 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_19_in_ruleConnection1886 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection1907 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_12_in_ruleConnection1923 = new BitSet(new long[]{0x000FFE0000122000L});
    public static final BitSet FOLLOW_ruleNetElement_in_ruleConnection1944 = new BitSet(new long[]{0x000FFE0000122000L});
    public static final BitSet FOLLOW_13_in_ruleConnection1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleConnection1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleConnection2003 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleVector_in_ruleConnection2037 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection2058 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_19_in_ruleConnection2071 = new BitSet(new long[]{0x00000040000000D0L});
    public static final BitSet FOLLOW_ruleConnectionName_in_ruleConnection2092 = new BitSet(new long[]{0x0000000000089000L});
    public static final BitSet FOLLOW_12_in_ruleConnection2108 = new BitSet(new long[]{0x000FFE0000122000L});
    public static final BitSet FOLLOW_rulePortElement_in_ruleConnection2129 = new BitSet(new long[]{0x000FFE0000122000L});
    public static final BitSet FOLLOW_13_in_ruleConnection2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleConnection2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNetElement_in_entryRuleNetElement2199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNetElement2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleNetElement2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleNetElement2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortElement_in_entryRulePortElement2318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortElement2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_rulePortElement2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstance_in_entryRuleInstance2408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstance2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleInstance2462 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_ruleArray_in_ruleInstance2496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstance2513 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstance2530 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstance2553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInstance2565 = new BitSet(new long[]{0x000FFF00101220D0L});
    public static final BitSet FOLLOW_ruleInstanceElement_in_ruleInstance2586 = new BitSet(new long[]{0x000FFF00101220D0L});
    public static final BitSet FOLLOW_13_in_ruleInstance2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleInstance2625 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_ruleArray_in_ruleInstance2659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstance2676 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInstance2693 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstance2716 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstance2733 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleInstance2751 = new BitSet(new long[]{0x000FFF00101220D0L});
    public static final BitSet FOLLOW_ruleSubInstanceElement_in_ruleInstance2772 = new BitSet(new long[]{0x000FFF00101220D0L});
    public static final BitSet FOLLOW_13_in_ruleInstance2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceElement_in_entryRuleInstanceElement2822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceElement2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleInstanceElement2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefAttr_in_ruleInstanceElement2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePinAssign_in_ruleInstanceElement2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleInstanceElement2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubInstanceElement_in_entryRuleSubInstanceElement2995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubInstanceElement3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleSubInstanceElement3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubAttr_in_ruleSubInstanceElement3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortAssign_in_ruleSubInstanceElement3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInfo_in_ruleSubInstanceElement3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefAttr_in_entryRuleRefAttr3168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefAttr3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifier_in_ruleRefAttr3224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefAttr3245 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRefAttr3257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRefAttr3274 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRefAttr3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePinAssign_in_entryRulePinAssign3327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePinAssign3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePinAssign3382 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePinAssign3407 = new BitSet(new long[]{0x00000100000000D0L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePinAssign3428 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePinAssign3452 = new BitSet(new long[]{0x0000004040000000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePinAssign3473 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePinAssign3486 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePinAssign3515 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePinAssign3539 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePinAssign3560 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePinAssign3575 = new BitSet(new long[]{0x00000012000010D0L});
    public static final BitSet FOLLOW_ruleConcatenation_in_rulePinAssign3596 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePinAssign3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubAttr_in_entryRuleSubAttr3644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubAttr3654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifier_in_ruleSubAttr3700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubAttr3721 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_ruleIndices_in_ruleSubAttr3742 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_ruleRefTail_in_ruleSubAttr3764 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSubAttr3776 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSubAttr3793 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSubAttr3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRefTail_in_entryRuleRefTail3846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRefTail3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleRefTail3893 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRefTail3913 = new BitSet(new long[]{0x00000000A0000002L});
    public static final BitSet FOLLOW_ruleIndices_in_ruleRefTail3934 = new BitSet(new long[]{0x00000000A0000002L});
    public static final BitSet FOLLOW_ruleRefTail_in_ruleRefTail3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortAssign_in_entryRulePortAssign3993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortAssign4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePortAssign4048 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePortAssign4073 = new BitSet(new long[]{0x00000100000000D0L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePortAssign4094 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePortAssign4118 = new BitSet(new long[]{0x0000004040000000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePortAssign4139 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePortAssign4152 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleQualifier_in_rulePortAssign4181 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_rulePortAssign4205 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_ruleSlices_in_rulePortAssign4226 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePortAssign4241 = new BitSet(new long[]{0x00000012000010D0L});
    public static final BitSet FOLLOW_ruleConcatenation_in_rulePortAssign4262 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePortAssign4274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionAssign_in_entryRuleConnectionAssign4310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionAssign4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleConnectionAssign4368 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_ruleSlices_in_ruleConnectionAssign4389 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleConnectionAssign4402 = new BitSet(new long[]{0x00000012000010D0L});
    public static final BitSet FOLLOW_ruleConcatenation_in_ruleConnectionAssign4423 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionAssign4435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatenation_in_entryRuleConcatenation4471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcatenation4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConcatenation4519 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4540 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_19_in_ruleConcatenation4553 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4574 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_13_in_ruleConcatenation4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4617 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleConcatenation4630 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4651 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_33_in_ruleConcatenation4679 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4713 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleConcatenation4725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_ruleConcatenation4754 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleConcatenation4772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleConcatenation4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionRef_in_entryRuleConnectionRef4859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionRef4869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleConnectionRef4917 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleSlices_in_ruleConnectionRef4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionName_in_entryRuleConnectionName4975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionName4985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleConnectionName5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndices_in_entryRuleIndices5065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndices5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleIndices5112 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5131 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleIndices5154 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5184 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5214 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_19_in_ruleIndices5232 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndices5249 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_30_in_ruleIndices5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSlices_in_entryRuleSlices5306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSlices5316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSlices5353 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5372 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSlices5395 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5425 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5455 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_19_in_ruleSlices5473 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSlices5490 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_39_in_ruleSlices5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVector_in_entryRuleVector5547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVector5557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVector5604 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector5621 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleVector5644 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVector5674 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleVector5691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArray_in_entryRuleArray5729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArray5739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleArray5786 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleArray5803 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleArray5826 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleArray5856 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleArray5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifier_in_entryRuleQualifier5911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifier5921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleQualifier5958 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ruleIndices_in_ruleQualifier5979 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleQualifier5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard6032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard6043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard6090 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleQualifiedNameWithWildCard6109 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleQualifiedNameWithWildCard6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleQualifiedName6223 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleQualifiedName6242 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rulePhdlID_in_ruleQualifiedName6264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhdlID_in_entryRulePhdlID6312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhdlID6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePhdlID6363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhdlID6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PINNUM_in_rulePhdlID6415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rulePinType6474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rulePinType6491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rulePinType6508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rulePinType6525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rulePinType6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulePinType6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rulePinType6576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rulePinType6593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rulePinType6610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rulePinType6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rulePinType6644 = new BitSet(new long[]{0x0000000000000002L});

}