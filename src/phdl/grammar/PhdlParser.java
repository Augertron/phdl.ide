// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g 2011-07-07 16:46:11

	package phdl.grammar;
	import java.util.TreeSet;
	import java.util.Set;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

/**
 * A grammar to lex and parse a PHDL source file.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public class PhdlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "SEMICOLON", "EQUALS", "STRING_LITERAL", "COLON", "PERIOD", "AMPERSAND", "LANGLE", "RANGLE", "LBRACE", "PIN", "INTEGER", "COMMA", "RBRACE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "CHAR", "DIGIT", "WHITESPACE", "LINE_COMMENT", "MULTILINE_COMMENT", "'design'", "'is'", "'begin'", "'end'", "'device'", "'attr'", "'pin'", "'net'", "'inst'", "'newattr'", "'open'"
    };
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int IDENT=4;
    public static final int SEMICOLON=5;
    public static final int EQUALS=6;
    public static final int STRING_LITERAL=7;
    public static final int COLON=8;
    public static final int PERIOD=9;
    public static final int AMPERSAND=10;
    public static final int LANGLE=11;
    public static final int RANGLE=12;
    public static final int LBRACE=13;
    public static final int PIN=14;
    public static final int INTEGER=15;
    public static final int COMMA=16;
    public static final int RBRACE=17;
    public static final int LBRACKET=18;
    public static final int RBRACKET=19;
    public static final int LPAREN=20;
    public static final int RPAREN=21;
    public static final int CHAR=22;
    public static final int DIGIT=23;
    public static final int WHITESPACE=24;
    public static final int LINE_COMMENT=25;
    public static final int MULTILINE_COMMENT=26;

    // delegates
    // delegators


        public PhdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PhdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PhdlParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g"; }



    	private Set<String> errors = new TreeSet<String>();

    	@Override
    	public void displayRecognitionError(String[] tokenNames,
    			RecognitionException e) {
    		String hdr = getErrorHeader(e);
    		String msg = getErrorMessage(e, tokenNames);
    		errors.add(hdr + " " + msg);
    	}

    	public Set<String> getErrors() {
    		return errors;
    	}


    public static class sourceText_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceText"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:65:1: sourceText : ( designDecl )* EOF ;
    public final PhdlParser.sourceText_return sourceText() throws RecognitionException {
        PhdlParser.sourceText_return retval = new PhdlParser.sourceText_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        PhdlParser.designDecl_return designDecl1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:2: ( ( designDecl )* EOF )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: ( designDecl )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: ( designDecl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:69:4: designDecl
            	    {
            	    pushFollow(FOLLOW_designDecl_in_sourceText68);
            	    designDecl1=designDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, designDecl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_sourceText71); 
            EOF2_tree = (CommonTree)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sourceText"

    public static class designDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:72:1: designDecl : 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON ;
    public final PhdlParser.designDecl_return designDecl() throws RecognitionException {
        PhdlParser.designDecl_return retval = new PhdlParser.designDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token string_literal5=null;
        Token string_literal8=null;
        Token string_literal11=null;
        Token SEMICOLON12=null;
        PhdlParser.deviceDecl_return deviceDecl6 = null;

        PhdlParser.netDecl_return netDecl7 = null;

        PhdlParser.deviceInstance_return deviceInstance9 = null;

        PhdlParser.netAssignment_return netAssignment10 = null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal8_tree=null;
        CommonTree string_literal11_tree=null;
        CommonTree SEMICOLON12_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:79:2: ( 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:79:4: 'design' IDENT 'is' ( deviceDecl | netDecl )* 'begin' ( deviceInstance | netAssignment )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,27,FOLLOW_27_in_designDecl84); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_designDecl87); 
            IDENT4_tree = (CommonTree)adaptor.create(IDENT4);
            adaptor.addChild(root_0, IDENT4_tree);

            string_literal5=(Token)match(input,28,FOLLOW_28_in_designDecl89); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:80:3: ( deviceDecl | netDecl )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==31) ) {
                    alt2=1;
                }
                else if ( (LA2_0==34) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:80:4: deviceDecl
            	    {
            	    pushFollow(FOLLOW_deviceDecl_in_designDecl96);
            	    deviceDecl6=deviceDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceDecl6.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:80:17: netDecl
            	    {
            	    pushFollow(FOLLOW_netDecl_in_designDecl100);
            	    netDecl7=netDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netDecl7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            string_literal8=(Token)match(input,29,FOLLOW_29_in_designDecl106); 
            string_literal8_tree = (CommonTree)adaptor.create(string_literal8);
            adaptor.addChild(root_0, string_literal8_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:82:3: ( deviceInstance | netAssignment )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35) ) {
                    alt3=1;
                }
                else if ( (LA3_0==IDENT) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:82:4: deviceInstance
            	    {
            	    pushFollow(FOLLOW_deviceInstance_in_designDecl111);
            	    deviceInstance9=deviceInstance();

            	    state._fsp--;

            	    adaptor.addChild(root_0, deviceInstance9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:82:21: netAssignment
            	    {
            	    pushFollow(FOLLOW_netAssignment_in_designDecl115);
            	    netAssignment10=netAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, netAssignment10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal11=(Token)match(input,30,FOLLOW_30_in_designDecl121); 
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_designDecl124); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "designDecl"

    public static class deviceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:86:1: deviceDecl : 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON ;
    public final PhdlParser.deviceDecl_return deviceDecl() throws RecognitionException {
        PhdlParser.deviceDecl_return retval = new PhdlParser.deviceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal13=null;
        Token IDENT14=null;
        Token string_literal15=null;
        Token string_literal18=null;
        Token SEMICOLON19=null;
        PhdlParser.attributeDecl_return attributeDecl16 = null;

        PhdlParser.pinDecl_return pinDecl17 = null;


        CommonTree string_literal13_tree=null;
        CommonTree IDENT14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree SEMICOLON19_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:92:2: ( 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:92:4: 'device' IDENT 'is' ( attributeDecl | pinDecl )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal13=(Token)match(input,31,FOLLOW_31_in_deviceDecl139); 
            string_literal13_tree = (CommonTree)adaptor.create(string_literal13);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_0);

            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceDecl142); 
            IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
            adaptor.addChild(root_0, IDENT14_tree);

            string_literal15=(Token)match(input,28,FOLLOW_28_in_deviceDecl144); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:93:3: ( attributeDecl | pinDecl )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==32) ) {
                    alt4=1;
                }
                else if ( (LA4_0==33) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:93:5: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_deviceDecl151);
            	    attributeDecl16=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl16.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:93:21: pinDecl
            	    {
            	    pushFollow(FOLLOW_pinDecl_in_deviceDecl155);
            	    pinDecl17=pinDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinDecl17.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            string_literal18=(Token)match(input,30,FOLLOW_30_in_deviceDecl162); 
            SEMICOLON19=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceDecl165); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "deviceDecl"

    public static class attributeDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:97:1: attributeDecl : 'attr' IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeDecl_return attributeDecl() throws RecognitionException {
        PhdlParser.attributeDecl_return retval = new PhdlParser.attributeDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal20=null;
        Token IDENT21=null;
        Token EQUALS22=null;
        Token STRING_LITERAL23=null;
        Token SEMICOLON24=null;

        CommonTree string_literal20_tree=null;
        CommonTree IDENT21_tree=null;
        CommonTree EQUALS22_tree=null;
        CommonTree STRING_LITERAL23_tree=null;
        CommonTree SEMICOLON24_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:102:2: ( 'attr' IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:102:4: 'attr' IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal20=(Token)match(input,32,FOLLOW_32_in_attributeDecl180); 
            string_literal20_tree = (CommonTree)adaptor.create(string_literal20);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal20_tree, root_0);

            IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeDecl183); 
            IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
            adaptor.addChild(root_0, IDENT21_tree);

            EQUALS22=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeDecl185); 
            STRING_LITERAL23=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeDecl188); 
            STRING_LITERAL23_tree = (CommonTree)adaptor.create(STRING_LITERAL23);
            adaptor.addChild(root_0, STRING_LITERAL23_tree);

            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeDecl190); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attributeDecl"

    public static class pinDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:105:1: pinDecl : type IDENT ( sliceDecl )? EQUALS pinList SEMICOLON ;
    public final PhdlParser.pinDecl_return pinDecl() throws RecognitionException {
        PhdlParser.pinDecl_return retval = new PhdlParser.pinDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT26=null;
        Token EQUALS28=null;
        Token SEMICOLON30=null;
        PhdlParser.type_return type25 = null;

        PhdlParser.sliceDecl_return sliceDecl27 = null;

        PhdlParser.pinList_return pinList29 = null;


        CommonTree IDENT26_tree=null;
        CommonTree EQUALS28_tree=null;
        CommonTree SEMICOLON30_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:111:2: ( type IDENT ( sliceDecl )? EQUALS pinList SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:111:4: type IDENT ( sliceDecl )? EQUALS pinList SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_pinDecl204);
            type25=type();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(type25.getTree(), root_0);
            IDENT26=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinDecl207); 
            IDENT26_tree = (CommonTree)adaptor.create(IDENT26);
            adaptor.addChild(root_0, IDENT26_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:111:16: ( sliceDecl )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LBRACKET) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:111:16: sliceDecl
                    {
                    pushFollow(FOLLOW_sliceDecl_in_pinDecl209);
                    sliceDecl27=sliceDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceDecl27.getTree());

                    }
                    break;

            }

            EQUALS28=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinDecl212); 
            pushFollow(FOLLOW_pinList_in_pinDecl215);
            pinList29=pinList();

            state._fsp--;

            adaptor.addChild(root_0, pinList29.getTree());
            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinDecl217); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinDecl"

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:114:1: type : 'pin' ;
    public final PhdlParser.type_return type() throws RecognitionException {
        PhdlParser.type_return retval = new PhdlParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal31=null;

        CommonTree string_literal31_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:118:2: ( 'pin' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:118:4: 'pin'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal31=(Token)match(input,33,FOLLOW_33_in_type232); 
            string_literal31_tree = (CommonTree)adaptor.create(string_literal31);
            adaptor.addChild(root_0, string_literal31_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class netDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:121:1: netDecl : 'net' ( sliceList )? IDENT ( netAttributes )? SEMICOLON ;
    public final PhdlParser.netDecl_return netDecl() throws RecognitionException {
        PhdlParser.netDecl_return retval = new PhdlParser.netDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal32=null;
        Token IDENT34=null;
        Token SEMICOLON36=null;
        PhdlParser.sliceList_return sliceList33 = null;

        PhdlParser.netAttributes_return netAttributes35 = null;


        CommonTree string_literal32_tree=null;
        CommonTree IDENT34_tree=null;
        CommonTree SEMICOLON36_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:126:2: ( 'net' ( sliceList )? IDENT ( netAttributes )? SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:126:4: 'net' ( sliceList )? IDENT ( netAttributes )? SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal32=(Token)match(input,34,FOLLOW_34_in_netDecl246); 
            string_literal32_tree = (CommonTree)adaptor.create(string_literal32);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal32_tree, root_0);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:126:11: ( sliceList )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBRACKET) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:126:11: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netDecl249);
                    sliceList33=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList33.getTree());

                    }
                    break;

            }

            IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_netDecl252); 
            IDENT34_tree = (CommonTree)adaptor.create(IDENT34);
            adaptor.addChild(root_0, IDENT34_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:126:28: ( netAttributes )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:126:28: netAttributes
                    {
                    pushFollow(FOLLOW_netAttributes_in_netDecl254);
                    netAttributes35=netAttributes();

                    state._fsp--;

                    adaptor.addChild(root_0, netAttributes35.getTree());

                    }
                    break;

            }

            SEMICOLON36=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netDecl257); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "netDecl"

    public static class netAttributes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAttributes"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:129:1: netAttributes : 'is' ( attributeDecl )* 'end' ;
    public final PhdlParser.netAttributes_return netAttributes() throws RecognitionException {
        PhdlParser.netAttributes_return retval = new PhdlParser.netAttributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal37=null;
        Token string_literal39=null;
        PhdlParser.attributeDecl_return attributeDecl38 = null;


        CommonTree string_literal37_tree=null;
        CommonTree string_literal39_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:134:2: ( 'is' ( attributeDecl )* 'end' )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:134:4: 'is' ( attributeDecl )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal37=(Token)match(input,28,FOLLOW_28_in_netAttributes273); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:134:10: ( attributeDecl )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:134:10: attributeDecl
            	    {
            	    pushFollow(FOLLOW_attributeDecl_in_netAttributes276);
            	    attributeDecl38=attributeDecl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeDecl38.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            string_literal39=(Token)match(input,30,FOLLOW_30_in_netAttributes279); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "netAttributes"

    public static class deviceInstance_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deviceInstance"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:137:1: deviceInstance : 'inst' IDENT COLON IDENT ( arrayList )? 'is' ( attributeAssignment | pinAssignment )* 'end' SEMICOLON ;
    public final PhdlParser.deviceInstance_return deviceInstance() throws RecognitionException {
        PhdlParser.deviceInstance_return retval = new PhdlParser.deviceInstance_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal40=null;
        Token IDENT41=null;
        Token COLON42=null;
        Token IDENT43=null;
        Token string_literal45=null;
        Token string_literal48=null;
        Token SEMICOLON49=null;
        PhdlParser.arrayList_return arrayList44 = null;

        PhdlParser.attributeAssignment_return attributeAssignment46 = null;

        PhdlParser.pinAssignment_return pinAssignment47 = null;


        CommonTree string_literal40_tree=null;
        CommonTree IDENT41_tree=null;
        CommonTree COLON42_tree=null;
        CommonTree IDENT43_tree=null;
        CommonTree string_literal45_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree SEMICOLON49_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:143:2: ( 'inst' IDENT COLON IDENT ( arrayList )? 'is' ( attributeAssignment | pinAssignment )* 'end' SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:143:4: 'inst' IDENT COLON IDENT ( arrayList )? 'is' ( attributeAssignment | pinAssignment )* 'end' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal40=(Token)match(input,35,FOLLOW_35_in_deviceInstance293); 
            string_literal40_tree = (CommonTree)adaptor.create(string_literal40);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal40_tree, root_0);

            IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance296); 
            IDENT41_tree = (CommonTree)adaptor.create(IDENT41);
            adaptor.addChild(root_0, IDENT41_tree);

            COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_deviceInstance298); 
            IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_deviceInstance301); 
            IDENT43_tree = (CommonTree)adaptor.create(IDENT43);
            adaptor.addChild(root_0, IDENT43_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:143:31: ( arrayList )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LPAREN) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:143:31: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_deviceInstance303);
                    arrayList44=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList44.getTree());

                    }
                    break;

            }

            string_literal45=(Token)match(input,28,FOLLOW_28_in_deviceInstance306); 
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:3: ( attributeAssignment | pinAssignment )*
            loop10:
            do {
                int alt10=3;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:4: attributeAssignment
            	    {
            	    pushFollow(FOLLOW_attributeAssignment_in_deviceInstance312);
            	    attributeAssignment46=attributeAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attributeAssignment46.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:144:26: pinAssignment
            	    {
            	    pushFollow(FOLLOW_pinAssignment_in_deviceInstance316);
            	    pinAssignment47=pinAssignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pinAssignment47.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            string_literal48=(Token)match(input,30,FOLLOW_30_in_deviceInstance322); 
            SEMICOLON49=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_deviceInstance325); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "deviceInstance"

    public static class attributeAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributeAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:148:1: attributeAssignment : ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING_LITERAL SEMICOLON ;
    public final PhdlParser.attributeAssignment_return attributeAssignment() throws RecognitionException {
        PhdlParser.attributeAssignment_return retval = new PhdlParser.attributeAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal50=null;
        Token IDENT52=null;
        Token EQUALS53=null;
        Token STRING_LITERAL54=null;
        Token SEMICOLON55=null;
        PhdlParser.instanceQualifier_return instanceQualifier51 = null;


        CommonTree string_literal50_tree=null;
        CommonTree IDENT52_tree=null;
        CommonTree EQUALS53_tree=null;
        CommonTree STRING_LITERAL54_tree=null;
        CommonTree SEMICOLON55_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:2: ( ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING_LITERAL SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:5: ( 'newattr' )? ( instanceQualifier )? IDENT EQUALS STRING_LITERAL SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:5: ( 'newattr' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==36) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:6: 'newattr'
                    {
                    string_literal50=(Token)match(input,36,FOLLOW_36_in_attributeAssignment341); 
                    string_literal50_tree = (CommonTree)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);


                    }
                    break;

            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:18: ( instanceQualifier )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENT) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==PERIOD||LA12_1==LPAREN) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:154:18: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_attributeAssignment345);
                    instanceQualifier51=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier51.getTree());

                    }
                    break;

            }

            IDENT52=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAssignment348); 
            IDENT52_tree = (CommonTree)adaptor.create(IDENT52);
            adaptor.addChild(root_0, IDENT52_tree);

            EQUALS53=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_attributeAssignment350); 
            EQUALS53_tree = (CommonTree)adaptor.create(EQUALS53);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS53_tree, root_0);

            STRING_LITERAL54=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attributeAssignment353); 
            STRING_LITERAL54_tree = (CommonTree)adaptor.create(STRING_LITERAL54);
            adaptor.addChild(root_0, STRING_LITERAL54_tree);

            SEMICOLON55=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributeAssignment355); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attributeAssignment"

    public static class instanceQualifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceQualifier"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:157:1: instanceQualifier : IDENT ( arrayList )? PERIOD ;
    public final PhdlParser.instanceQualifier_return instanceQualifier() throws RecognitionException {
        PhdlParser.instanceQualifier_return retval = new PhdlParser.instanceQualifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT56=null;
        Token PERIOD58=null;
        PhdlParser.arrayList_return arrayList57 = null;


        CommonTree IDENT56_tree=null;
        CommonTree PERIOD58_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:2: ( IDENT ( arrayList )? PERIOD )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:4: IDENT ( arrayList )? PERIOD
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_instanceQualifier370); 
            IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
            adaptor.addChild(root_0, IDENT56_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:10: ( arrayList )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:162:10: arrayList
                    {
                    pushFollow(FOLLOW_arrayList_in_instanceQualifier372);
                    arrayList57=arrayList();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayList57.getTree());

                    }
                    break;

            }

            PERIOD58=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_instanceQualifier375); 
            PERIOD58_tree = (CommonTree)adaptor.create(PERIOD58);
            root_0 = (CommonTree)adaptor.becomeRoot(PERIOD58_tree, root_0);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instanceQualifier"

    public static class pinAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:165:1: pinAssignment : ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.pinAssignment_return pinAssignment() throws RecognitionException {
        PhdlParser.pinAssignment_return retval = new PhdlParser.pinAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT60=null;
        Token EQUALS62=null;
        Token SEMICOLON64=null;
        PhdlParser.instanceQualifier_return instanceQualifier59 = null;

        PhdlParser.sliceList_return sliceList61 = null;

        PhdlParser.concatenation_return concatenation63 = null;


        CommonTree IDENT60_tree=null;
        CommonTree EQUALS62_tree=null;
        CommonTree SEMICOLON64_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:2: ( ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:4: ( instanceQualifier )? IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:4: ( instanceQualifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENT) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==PERIOD||LA14_1==LPAREN) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:4: instanceQualifier
                    {
                    pushFollow(FOLLOW_instanceQualifier_in_pinAssignment391);
                    instanceQualifier59=instanceQualifier();

                    state._fsp--;

                    adaptor.addChild(root_0, instanceQualifier59.getTree());

                    }
                    break;

            }

            IDENT60=(Token)match(input,IDENT,FOLLOW_IDENT_in_pinAssignment394); 
            IDENT60_tree = (CommonTree)adaptor.create(IDENT60);
            adaptor.addChild(root_0, IDENT60_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:29: ( sliceList )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LBRACKET) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:170:29: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_pinAssignment396);
                    sliceList61=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList61.getTree());

                    }
                    break;

            }

            EQUALS62=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_pinAssignment399); 
            EQUALS62_tree = (CommonTree)adaptor.create(EQUALS62);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS62_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_pinAssignment402);
            concatenation63=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation63.getTree());
            SEMICOLON64=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_pinAssignment404); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinAssignment"

    public static class netAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "netAssignment"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:173:1: netAssignment : IDENT ( sliceList )? EQUALS concatenation SEMICOLON ;
    public final PhdlParser.netAssignment_return netAssignment() throws RecognitionException {
        PhdlParser.netAssignment_return retval = new PhdlParser.netAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT65=null;
        Token EQUALS67=null;
        Token SEMICOLON69=null;
        PhdlParser.sliceList_return sliceList66 = null;

        PhdlParser.concatenation_return concatenation68 = null;


        CommonTree IDENT65_tree=null;
        CommonTree EQUALS67_tree=null;
        CommonTree SEMICOLON69_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:2: ( IDENT ( sliceList )? EQUALS concatenation SEMICOLON )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:4: IDENT ( sliceList )? EQUALS concatenation SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT65=(Token)match(input,IDENT,FOLLOW_IDENT_in_netAssignment418); 
            IDENT65_tree = (CommonTree)adaptor.create(IDENT65);
            adaptor.addChild(root_0, IDENT65_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:10: ( sliceList )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LBRACKET) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:177:10: sliceList
                    {
                    pushFollow(FOLLOW_sliceList_in_netAssignment420);
                    sliceList66=sliceList();

                    state._fsp--;

                    adaptor.addChild(root_0, sliceList66.getTree());

                    }
                    break;

            }

            EQUALS67=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_netAssignment423); 
            EQUALS67_tree = (CommonTree)adaptor.create(EQUALS67);
            root_0 = (CommonTree)adaptor.becomeRoot(EQUALS67_tree, root_0);

            pushFollow(FOLLOW_concatenation_in_netAssignment426);
            concatenation68=concatenation();

            state._fsp--;

            adaptor.addChild(root_0, concatenation68.getTree());
            SEMICOLON69=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_netAssignment428); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "netAssignment"

    public static class concatenation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatenation"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:180:1: concatenation : ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LANGLE IDENT RANGLE | 'open' );
    public final PhdlParser.concatenation_return concatenation() throws RecognitionException {
        PhdlParser.concatenation_return retval = new PhdlParser.concatenation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT70=null;
        Token AMPERSAND72=null;
        Token IDENT73=null;
        Token LANGLE75=null;
        Token IDENT76=null;
        Token RANGLE77=null;
        Token string_literal78=null;
        PhdlParser.sliceList_return sliceList71 = null;

        PhdlParser.sliceList_return sliceList74 = null;


        CommonTree IDENT70_tree=null;
        CommonTree AMPERSAND72_tree=null;
        CommonTree IDENT73_tree=null;
        CommonTree LANGLE75_tree=null;
        CommonTree IDENT76_tree=null;
        CommonTree RANGLE77_tree=null;
        CommonTree string_literal78_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:2: ( ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* ) | LANGLE IDENT RANGLE | 'open' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt20=1;
                }
                break;
            case LANGLE:
                {
                alt20=2;
                }
                break;
            case 37:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:4: ( ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )* )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:5: ( IDENT ( sliceList )? ) ( AMPERSAND IDENT ( sliceList )? )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:5: ( IDENT ( sliceList )? )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:6: IDENT ( sliceList )?
                    {
                    IDENT70=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation444); 
                    IDENT70_tree = (CommonTree)adaptor.create(IDENT70);
                    adaptor.addChild(root_0, IDENT70_tree);

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:12: ( sliceList )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==LBRACKET) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:12: sliceList
                            {
                            pushFollow(FOLLOW_sliceList_in_concatenation446);
                            sliceList71=sliceList();

                            state._fsp--;

                            adaptor.addChild(root_0, sliceList71.getTree());

                            }
                            break;

                    }


                    }

                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:24: ( AMPERSAND IDENT ( sliceList )? )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==AMPERSAND) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:25: AMPERSAND IDENT ( sliceList )?
                    	    {
                    	    AMPERSAND72=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_concatenation451); 
                    	    IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation454); 
                    	    IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
                    	    adaptor.addChild(root_0, IDENT73_tree);

                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:42: ( sliceList )?
                    	    int alt18=2;
                    	    int LA18_0 = input.LA(1);

                    	    if ( (LA18_0==LBRACKET) ) {
                    	        alt18=1;
                    	    }
                    	    switch (alt18) {
                    	        case 1 :
                    	            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:186:42: sliceList
                    	            {
                    	            pushFollow(FOLLOW_sliceList_in_concatenation456);
                    	            sliceList74=sliceList();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, sliceList74.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:187:4: LANGLE IDENT RANGLE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LANGLE75=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_concatenation467); 
                    LANGLE75_tree = (CommonTree)adaptor.create(LANGLE75);
                    adaptor.addChild(root_0, LANGLE75_tree);

                    IDENT76=(Token)match(input,IDENT,FOLLOW_IDENT_in_concatenation469); 
                    IDENT76_tree = (CommonTree)adaptor.create(IDENT76);
                    adaptor.addChild(root_0, IDENT76_tree);

                    RANGLE77=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_concatenation471); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:188:5: 'open'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    string_literal78=(Token)match(input,37,FOLLOW_37_in_concatenation478); 
                    string_literal78_tree = (CommonTree)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "concatenation"

    public static class pinList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pinList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:191:1: pinList : LBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RBRACE ;
    public final PhdlParser.pinList_return pinList() throws RecognitionException {
        PhdlParser.pinList_return retval = new PhdlParser.pinList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE79=null;
        Token set80=null;
        Token COMMA81=null;
        Token set82=null;
        Token RBRACE83=null;

        CommonTree LBRACE79_tree=null;
        CommonTree set80_tree=null;
        CommonTree COMMA81_tree=null;
        CommonTree set82_tree=null;
        CommonTree RBRACE83_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:2: ( LBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RBRACE )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:5: LBRACE ( IDENT | PIN | INTEGER ) ( COMMA ( IDENT | PIN | INTEGER ) )* RBRACE
            {
            root_0 = (CommonTree)adaptor.nil();

            LBRACE79=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_pinList493); 
            set80=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set80));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:37: ( COMMA ( IDENT | PIN | INTEGER ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:196:38: COMMA ( IDENT | PIN | INTEGER )
            	    {
            	    COMMA81=(Token)match(input,COMMA,FOLLOW_COMMA_in_pinList509); 
            	    set82=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||(input.LA(1)>=PIN && input.LA(1)<=INTEGER) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set82));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            RBRACE83=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_pinList526); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pinList"

    public static class sliceList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sliceList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:199:1: sliceList : LBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )* ) RBRACKET ;
    public final PhdlParser.sliceList_return sliceList() throws RecognitionException {
        PhdlParser.sliceList_return retval = new PhdlParser.sliceList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET84=null;
        Token INTEGER85=null;
        Token COLON86=null;
        Token INTEGER87=null;
        Token COMMA88=null;
        Token INTEGER89=null;
        Token RBRACKET90=null;

        CommonTree LBRACKET84_tree=null;
        CommonTree INTEGER85_tree=null;
        CommonTree COLON86_tree=null;
        CommonTree INTEGER87_tree=null;
        CommonTree COMMA88_tree=null;
        CommonTree INTEGER89_tree=null;
        CommonTree RBRACKET90_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:2: ( LBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )* ) RBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:5: LBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )* ) RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LBRACKET84=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceList542); 
            LBRACKET84_tree = (CommonTree)adaptor.create(LBRACKET84);
            adaptor.addChild(root_0, LBRACKET84_tree);

            INTEGER85=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList544); 
            INTEGER85_tree = (CommonTree)adaptor.create(INTEGER85);
            adaptor.addChild(root_0, INTEGER85_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:22: ( ( COLON INTEGER ) | ( COMMA INTEGER )* )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==COLON) ) {
                alt23=1;
            }
            else if ( (LA23_0==COMMA||LA23_0==RBRACKET) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:23: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:23: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:24: COLON INTEGER
                    {
                    COLON86=(Token)match(input,COLON,FOLLOW_COLON_in_sliceList548); 
                    COLON86_tree = (CommonTree)adaptor.create(COLON86);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON86_tree, root_0);

                    INTEGER87=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList551); 
                    INTEGER87_tree = (CommonTree)adaptor.create(INTEGER87);
                    adaptor.addChild(root_0, INTEGER87_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:42: ( COMMA INTEGER )*
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:42: ( COMMA INTEGER )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==COMMA) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:204:43: COMMA INTEGER
                    	    {
                    	    COMMA88=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceList557); 
                    	    COMMA88_tree = (CommonTree)adaptor.create(COMMA88);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA88_tree, root_0);

                    	    INTEGER89=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceList560); 
                    	    INTEGER89_tree = (CommonTree)adaptor.create(INTEGER89);
                    	    adaptor.addChild(root_0, INTEGER89_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACKET90=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_sliceList565); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sliceList"

    public static class arrayList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayList"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:207:1: arrayList : LPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RPAREN ;
    public final PhdlParser.arrayList_return arrayList() throws RecognitionException {
        PhdlParser.arrayList_return retval = new PhdlParser.arrayList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN91=null;
        Token INTEGER92=null;
        Token COLON93=null;
        Token INTEGER94=null;
        Token COMMA95=null;
        Token INTEGER96=null;
        Token COMMA97=null;
        Token INTEGER98=null;
        Token RPAREN99=null;

        CommonTree LPAREN91_tree=null;
        CommonTree INTEGER92_tree=null;
        CommonTree COLON93_tree=null;
        CommonTree INTEGER94_tree=null;
        CommonTree COMMA95_tree=null;
        CommonTree INTEGER96_tree=null;
        CommonTree COMMA97_tree=null;
        CommonTree INTEGER98_tree=null;
        CommonTree RPAREN99_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:2: ( LPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RPAREN )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:5: LPAREN INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? ) RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAREN91=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_arrayList581); 
            LPAREN91_tree = (CommonTree)adaptor.create(LPAREN91);
            adaptor.addChild(root_0, LPAREN91_tree);

            INTEGER92=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList583); 
            INTEGER92_tree = (CommonTree)adaptor.create(INTEGER92);
            adaptor.addChild(root_0, INTEGER92_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:20: ( ( COLON INTEGER ) | ( COMMA INTEGER ( COMMA INTEGER )* )? )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==COLON) ) {
                alt26=1;
            }
            else if ( (LA26_0==COMMA||LA26_0==RPAREN) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:21: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:21: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:22: COLON INTEGER
                    {
                    COLON93=(Token)match(input,COLON,FOLLOW_COLON_in_arrayList587); 
                    COLON93_tree = (CommonTree)adaptor.create(COLON93);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON93_tree, root_0);

                    INTEGER94=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList590); 
                    INTEGER94_tree = (CommonTree)adaptor.create(INTEGER94);
                    adaptor.addChild(root_0, INTEGER94_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:40: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:40: ( COMMA INTEGER ( COMMA INTEGER )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==COMMA) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:41: COMMA INTEGER ( COMMA INTEGER )*
                            {
                            COMMA95=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList596); 
                            COMMA95_tree = (CommonTree)adaptor.create(COMMA95);
                            root_0 = (CommonTree)adaptor.becomeRoot(COMMA95_tree, root_0);

                            INTEGER96=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList599); 
                            INTEGER96_tree = (CommonTree)adaptor.create(INTEGER96);
                            adaptor.addChild(root_0, INTEGER96_tree);

                            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:56: ( COMMA INTEGER )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==COMMA) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:212:57: COMMA INTEGER
                            	    {
                            	    COMMA97=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayList602); 
                            	    INTEGER98=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arrayList605); 
                            	    INTEGER98_tree = (CommonTree)adaptor.create(INTEGER98);
                            	    adaptor.addChild(root_0, INTEGER98_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RPAREN99=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_arrayList612); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayList"

    public static class sliceDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sliceDecl"
    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:215:1: sliceDecl : LBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RBRACKET ;
    public final PhdlParser.sliceDecl_return sliceDecl() throws RecognitionException {
        PhdlParser.sliceDecl_return retval = new PhdlParser.sliceDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET100=null;
        Token INTEGER101=null;
        Token COLON102=null;
        Token INTEGER103=null;
        Token COMMA104=null;
        Token INTEGER105=null;
        Token RBRACKET106=null;

        CommonTree LBRACKET100_tree=null;
        CommonTree INTEGER101_tree=null;
        CommonTree COLON102_tree=null;
        CommonTree INTEGER103_tree=null;
        CommonTree COMMA104_tree=null;
        CommonTree INTEGER105_tree=null;
        CommonTree RBRACKET106_tree=null;

        try {
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:2: ( LBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RBRACKET )
            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:4: LBRACKET INTEGER ( ( COLON INTEGER ) | ( COMMA INTEGER )+ ) RBRACKET
            {
            root_0 = (CommonTree)adaptor.nil();

            LBRACKET100=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_sliceDecl625); 
            LBRACKET100_tree = (CommonTree)adaptor.create(LBRACKET100);
            adaptor.addChild(root_0, LBRACKET100_tree);

            INTEGER101=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl627); 
            INTEGER101_tree = (CommonTree)adaptor.create(INTEGER101);
            adaptor.addChild(root_0, INTEGER101_tree);

            // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:21: ( ( COLON INTEGER ) | ( COMMA INTEGER )+ )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==COLON) ) {
                alt28=1;
            }
            else if ( (LA28_0==COMMA) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:22: ( COLON INTEGER )
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:22: ( COLON INTEGER )
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:23: COLON INTEGER
                    {
                    COLON102=(Token)match(input,COLON,FOLLOW_COLON_in_sliceDecl631); 
                    COLON102_tree = (CommonTree)adaptor.create(COLON102);
                    root_0 = (CommonTree)adaptor.becomeRoot(COLON102_tree, root_0);

                    INTEGER103=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl634); 
                    INTEGER103_tree = (CommonTree)adaptor.create(INTEGER103);
                    adaptor.addChild(root_0, INTEGER103_tree);


                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:41: ( COMMA INTEGER )+
                    {
                    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:41: ( COMMA INTEGER )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==COMMA) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // C:\\Users\\brad\\eclipse\\phdl\\src\\phdl\\grammar\\Phdl.g:216:42: COMMA INTEGER
                    	    {
                    	    COMMA104=(Token)match(input,COMMA,FOLLOW_COMMA_in_sliceDecl640); 
                    	    COMMA104_tree = (CommonTree)adaptor.create(COMMA104);
                    	    root_0 = (CommonTree)adaptor.becomeRoot(COMMA104_tree, root_0);

                    	    INTEGER105=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sliceDecl643); 
                    	    INTEGER105_tree = (CommonTree)adaptor.create(INTEGER105);
                    	    adaptor.addChild(root_0, INTEGER105_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    }
                    break;

            }

            RBRACKET106=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_sliceDecl648); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sliceDecl"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\21\uffff";
    static final String DFA10_eofS =
        "\21\uffff";
    static final String DFA10_minS =
        "\1\4\2\uffff\1\6\1\4\1\17\1\4\1\uffff\1\10\1\6\2\17\1\11\1\25\1"+
        "\20\1\17\1\20";
    static final String DFA10_maxS =
        "\1\44\2\uffff\1\24\1\45\1\17\1\4\1\uffff\1\25\1\22\2\17\1\11\2"+
        "\25\1\17\1\25";
    static final String DFA10_acceptS =
        "\1\uffff\1\3\1\1\4\uffff\1\2\11\uffff";
    static final String DFA10_specialS =
        "\21\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\31\uffff\1\1\5\uffff\1\2",
            "",
            "",
            "\1\4\2\uffff\1\6\10\uffff\1\7\1\uffff\1\5",
            "\1\7\2\uffff\1\2\3\uffff\1\7\31\uffff\1\7",
            "\1\10",
            "\1\11",
            "",
            "\1\12\7\uffff\1\13\4\uffff\1\14",
            "\1\4\13\uffff\1\7",
            "\1\15",
            "\1\16",
            "\1\6",
            "\1\14",
            "\1\17\4\uffff\1\14",
            "\1\20",
            "\1\17\4\uffff\1\14"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 144:3: ( attributeAssignment | pinAssignment )*";
        }
    }
 

    public static final BitSet FOLLOW_designDecl_in_sourceText68 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EOF_in_sourceText71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_designDecl84 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_designDecl87 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_designDecl89 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_deviceDecl_in_designDecl96 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_netDecl_in_designDecl100 = new BitSet(new long[]{0x00000004A0000000L});
    public static final BitSet FOLLOW_29_in_designDecl106 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_deviceInstance_in_designDecl111 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_netAssignment_in_designDecl115 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_30_in_designDecl121 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_designDecl124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_deviceDecl139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceDecl142 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceDecl144 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_attributeDecl_in_deviceDecl151 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_pinDecl_in_deviceDecl155 = new BitSet(new long[]{0x0000000340000000L});
    public static final BitSet FOLLOW_30_in_deviceDecl162 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceDecl165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_attributeDecl180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeDecl183 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeDecl185 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeDecl188 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeDecl190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_pinDecl204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinDecl207 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_sliceDecl_in_pinDecl209 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinDecl212 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pinList_in_pinDecl215 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinDecl217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_netDecl246 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_sliceList_in_netDecl249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_netDecl252 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_netAttributes_in_netDecl254 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netDecl257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_netAttributes273 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_attributeDecl_in_netAttributes276 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_netAttributes279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_deviceInstance293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance296 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_deviceInstance298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_deviceInstance301 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_arrayList_in_deviceInstance303 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_deviceInstance306 = new BitSet(new long[]{0x0000001040000010L});
    public static final BitSet FOLLOW_attributeAssignment_in_deviceInstance312 = new BitSet(new long[]{0x0000001040000010L});
    public static final BitSet FOLLOW_pinAssignment_in_deviceInstance316 = new BitSet(new long[]{0x0000001040000010L});
    public static final BitSet FOLLOW_30_in_deviceInstance322 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_deviceInstance325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attributeAssignment341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceQualifier_in_attributeAssignment345 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_attributeAssignment348 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_attributeAssignment350 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attributeAssignment353 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_attributeAssignment355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_instanceQualifier370 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_arrayList_in_instanceQualifier372 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PERIOD_in_instanceQualifier375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceQualifier_in_pinAssignment391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pinAssignment394 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_sliceList_in_pinAssignment396 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_pinAssignment399 = new BitSet(new long[]{0x0000002000000810L});
    public static final BitSet FOLLOW_concatenation_in_pinAssignment402 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_pinAssignment404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_netAssignment418 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_sliceList_in_netAssignment420 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUALS_in_netAssignment423 = new BitSet(new long[]{0x0000002000000810L});
    public static final BitSet FOLLOW_concatenation_in_netAssignment426 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMICOLON_in_netAssignment428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_concatenation444 = new BitSet(new long[]{0x0000000000040402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation446 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AMPERSAND_in_concatenation451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation454 = new BitSet(new long[]{0x0000000000040402L});
    public static final BitSet FOLLOW_sliceList_in_concatenation456 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LANGLE_in_concatenation467 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_concatenation469 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RANGLE_in_concatenation471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_concatenation478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_pinList493 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_set_in_pinList496 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_COMMA_in_pinList509 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_set_in_pinList512 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_RBRACE_in_pinList526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceList542 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList544 = new BitSet(new long[]{0x0000000000090100L});
    public static final BitSet FOLLOW_COLON_in_sliceList548 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList551 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceList557 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceList560 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_RBRACKET_in_sliceList565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arrayList581 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList583 = new BitSet(new long[]{0x0000000000210100L});
    public static final BitSet FOLLOW_COLON_in_arrayList587 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList590 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList596 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList599 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_COMMA_in_arrayList602 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_arrayList605 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_RPAREN_in_arrayList612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_sliceDecl625 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl627 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_COLON_in_sliceDecl631 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl634 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_sliceDecl640 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_sliceDecl643 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_RBRACKET_in_sliceDecl648 = new BitSet(new long[]{0x0000000000000002L});

}