// $ANTLR 3.3 Nov 30, 2010 12:50:56 /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g 2012-01-30 10:48:49

/*
    Copyright (C) 2011  BYU Configurable Computing Lab

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

	package phdl.grammar;
	import java.util.Set;
	import java.util.HashSet;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PhdlLexer extends Lexer {
    public static final int EOF=-1;
    public static final int SEMICOLON=4;
    public static final int COLON=5;
    public static final int COMMA=6;
    public static final int PERIOD=7;
    public static final int EQUALS=8;
    public static final int LPAREN=9;
    public static final int RPAREN=10;
    public static final int LBRACKET=11;
    public static final int RBRACKET=12;
    public static final int LBRACE=13;
    public static final int RBRACE=14;
    public static final int LANGLE=15;
    public static final int RANGLE=16;
    public static final int AMPERSAND=17;
    public static final int DBLQUOTE=18;
    public static final int DESIGN=19;
    public static final int DEVICE=20;
    public static final int SUBDESIGN=21;
    public static final int INST=22;
    public static final int SUBINST=23;
    public static final int GROUP=24;
    public static final int THIS=25;
    public static final int OF=26;
    public static final int NET=27;
    public static final int ATTR=28;
    public static final int NEWATTR=29;
    public static final int BEGIN=30;
    public static final int END=31;
    public static final int COMBINE=32;
    public static final int INCLUDE=33;
    public static final int INFO=34;
    public static final int PORT=35;
    public static final int OPEN=36;
    public static final int PIN=37;
    public static final int INPIN=38;
    public static final int OUTPIN=39;
    public static final int IOPIN=40;
    public static final int PWRPIN=41;
    public static final int SUPPIN=42;
    public static final int DEVICE_DECL=43;
    public static final int DESIGN_DECL=44;
    public static final int SUBDESIGN_DECL=45;
    public static final int ATTR_DECL=46;
    public static final int PIN_DECL=47;
    public static final int PORT_DECL=48;
    public static final int NET_DECL=49;
    public static final int INST_DECL=50;
    public static final int SUBINST_DECL=51;
    public static final int GROUP_DECL=52;
    public static final int INFO_DECL=53;
    public static final int ATTR_ASSIGN=54;
    public static final int SUBATTR_ASSIGN=55;
    public static final int PIN_ASSIGN=56;
    public static final int PORT_ASSIGN=57;
    public static final int CONNECT_ASSIGN=58;
    public static final int CONCAT_LIST=59;
    public static final int CONCAT_REPL=60;
    public static final int CONCAT_OPEN=61;
    public static final int WIDTH=62;
    public static final int PIN_LIST=63;
    public static final int PIN_TYPE=64;
    public static final int BOUNDS=65;
    public static final int INDICES=66;
    public static final int OPERAND=67;
    public static final int NAME=68;
    public static final int IDENT=69;
    public static final int STRING=70;
    public static final int INT=71;
    public static final int PINNUM=72;
    public static final int D=73;
    public static final int E=74;
    public static final int S=75;
    public static final int I=76;
    public static final int G=77;
    public static final int N=78;
    public static final int V=79;
    public static final int C=80;
    public static final int U=81;
    public static final int B=82;
    public static final int T=83;
    public static final int R=84;
    public static final int O=85;
    public static final int P=86;
    public static final int H=87;
    public static final int F=88;
    public static final int A=89;
    public static final int W=90;
    public static final int M=91;
    public static final int L=92;
    public static final int J=93;
    public static final int K=94;
    public static final int Q=95;
    public static final int X=96;
    public static final int Y=97;
    public static final int Z=98;
    public static final int CHAR=99;
    public static final int DIGIT=100;
    public static final int ESC=101;
    public static final int WHITESPACE=102;
    public static final int LINE_COMMENT=103;
    public static final int MULTILINE_COMMENT=104;
    public static final int INCLUDE_DECL=105;


    	/**
    	 * Class to enable pushing a character stream onto a stack
    	 */
    	class SaveStruct {
    		public CharStream input;
    		public int marker;
    		
    		SaveStruct(CharStream input) {
    			this.input = input;
    			this.marker = input.mark();
    		}
    	}
    	
    	/** The stack of saved character streams */
    	private Stack<SaveStruct> includes = new Stack<SaveStruct>();
    	
    	/** The set of included file names to check for duplicate include statements */
    	private Set<String> includeNames = new HashSet<String>();
    	
    	/** getter and setter for above includeNames field */
    	public Set<String> getIncludeNames() {
    		return includeNames;
    	}
    	public void setIncludeNames(Set<String> includeNames) {
    		this.includeNames = includeNames;
    	}
    	
    	/**
    	 * Overridden nextToken method to accomodate the saved character stream states, and how to handle the tokens
    	 * entering and leaving an included file.
    	 */
    	@Override
    	public Token nextToken() {
    		Token token = super.nextToken();		
    		
    		if (token.getType() == Token.EOF && !includes.empty()) {
    			// EOF and a non-empty stack.  Pop a stream, set to it, 
    			// and rewind to its saved marker
    			SaveStruct ss = includes.pop();
    			setCharStream(ss.input);
    			input.rewind(ss.marker);
    			
    			// used to handle exits from nested includes.
    			// it only matters when the 'include' token is the last in the previous stream.
    			// using super, lexer crashes, returning EOF token.
    			token = this.nextToken();
    		}
    		
    		// skip the first token after switching on another input.
    		if (((CommonToken) token).getStartIndex() < 0)
    			token = this.nextToken();
    			
    		return token;
    	}


    // delegates
    // delegators

    public PhdlLexer() {;} 
    public PhdlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PhdlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g"; }

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:87:11: ( ';' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:87:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:88:7: ( ':' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:88:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:89:7: ( ',' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:89:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:90:8: ( '.' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:90:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:91:8: ( '=' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:91:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:92:8: ( '(' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:92:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:93:8: ( ')' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:93:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:94:10: ( '[' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:94:12: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:95:10: ( ']' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:95:12: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:96:8: ( '{' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:96:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:97:8: ( '}' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:97:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "LANGLE"
    public final void mLANGLE() throws RecognitionException {
        try {
            int _type = LANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:98:8: ( '<' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:98:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LANGLE"

    // $ANTLR start "RANGLE"
    public final void mRANGLE() throws RecognitionException {
        try {
            int _type = RANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:99:8: ( '>' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:99:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGLE"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:100:11: ( '&' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:100:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "DBLQUOTE"
    public final void mDBLQUOTE() throws RecognitionException {
        try {
            int _type = DBLQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:101:10: ( '\"' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:101:12: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DBLQUOTE"

    // $ANTLR start "DESIGN"
    public final void mDESIGN() throws RecognitionException {
        try {
            int _type = DESIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:509:7: ( D E S I G N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:509:9: D E S I G N
            {
            mD(); 
            mE(); 
            mS(); 
            mI(); 
            mG(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESIGN"

    // $ANTLR start "DEVICE"
    public final void mDEVICE() throws RecognitionException {
        try {
            int _type = DEVICE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:7: ( D E V I C E )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:510:9: D E V I C E
            {
            mD(); 
            mE(); 
            mV(); 
            mI(); 
            mC(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEVICE"

    // $ANTLR start "SUBDESIGN"
    public final void mSUBDESIGN() throws RecognitionException {
        try {
            int _type = SUBDESIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:511:10: ( S U B D E S I G N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:511:12: S U B D E S I G N
            {
            mS(); 
            mU(); 
            mB(); 
            mD(); 
            mE(); 
            mS(); 
            mI(); 
            mG(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBDESIGN"

    // $ANTLR start "INST"
    public final void mINST() throws RecognitionException {
        try {
            int _type = INST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:512:5: ( I N S T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:512:7: I N S T
            {
            mI(); 
            mN(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INST"

    // $ANTLR start "SUBINST"
    public final void mSUBINST() throws RecognitionException {
        try {
            int _type = SUBINST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:513:8: ( S U B I N S T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:513:10: S U B I N S T
            {
            mS(); 
            mU(); 
            mB(); 
            mI(); 
            mN(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBINST"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:514:6: ( G R O U P )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:514:8: G R O U P
            {
            mG(); 
            mR(); 
            mO(); 
            mU(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "THIS"
    public final void mTHIS() throws RecognitionException {
        try {
            int _type = THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:515:5: ( T H I S )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:515:7: T H I S
            {
            mT(); 
            mH(); 
            mI(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THIS"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:516:3: ( O F )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:516:5: O F
            {
            mO(); 
            mF(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "NET"
    public final void mNET() throws RecognitionException {
        try {
            int _type = NET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:517:4: ( N E T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:517:6: N E T
            {
            mN(); 
            mE(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NET"

    // $ANTLR start "ATTR"
    public final void mATTR() throws RecognitionException {
        try {
            int _type = ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:518:5: ( A T T R )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:518:7: A T T R
            {
            mA(); 
            mT(); 
            mT(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTR"

    // $ANTLR start "NEWATTR"
    public final void mNEWATTR() throws RecognitionException {
        try {
            int _type = NEWATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:519:8: ( N E W A T T R )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:519:10: N E W A T T R
            {
            mN(); 
            mE(); 
            mW(); 
            mA(); 
            mT(); 
            mT(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWATTR"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:520:6: ( B E G I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:520:8: B E G I N
            {
            mB(); 
            mE(); 
            mG(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:521:4: ( E N D )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:521:6: E N D
            {
            mE(); 
            mN(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "COMBINE"
    public final void mCOMBINE() throws RecognitionException {
        try {
            int _type = COMBINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:522:8: ( C O M B I N E )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:522:10: C O M B I N E
            {
            mC(); 
            mO(); 
            mM(); 
            mB(); 
            mI(); 
            mN(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMBINE"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:523:8: ( I N C L U D E )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:523:10: I N C L U D E
            {
            mI(); 
            mN(); 
            mC(); 
            mL(); 
            mU(); 
            mD(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "INFO"
    public final void mINFO() throws RecognitionException {
        try {
            int _type = INFO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:524:5: ( I N F O )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:524:7: I N F O
            {
            mI(); 
            mN(); 
            mF(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INFO"

    // $ANTLR start "OPEN"
    public final void mOPEN() throws RecognitionException {
        try {
            int _type = OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:525:5: ( O P E N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:525:7: O P E N
            {
            mO(); 
            mP(); 
            mE(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN"

    // $ANTLR start "PORT"
    public final void mPORT() throws RecognitionException {
        try {
            int _type = PORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:526:5: ( P O R T )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:526:7: P O R T
            {
            mP(); 
            mO(); 
            mR(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORT"

    // $ANTLR start "PIN"
    public final void mPIN() throws RecognitionException {
        try {
            int _type = PIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:529:4: ( P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:529:6: P I N
            {
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIN"

    // $ANTLR start "INPIN"
    public final void mINPIN() throws RecognitionException {
        try {
            int _type = INPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:530:6: ( I N P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:530:8: I N P I N
            {
            mI(); 
            mN(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INPIN"

    // $ANTLR start "OUTPIN"
    public final void mOUTPIN() throws RecognitionException {
        try {
            int _type = OUTPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:531:7: ( O U T P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:531:9: O U T P I N
            {
            mO(); 
            mU(); 
            mT(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPIN"

    // $ANTLR start "IOPIN"
    public final void mIOPIN() throws RecognitionException {
        try {
            int _type = IOPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:532:6: ( I O P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:532:8: I O P I N
            {
            mI(); 
            mO(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IOPIN"

    // $ANTLR start "PWRPIN"
    public final void mPWRPIN() throws RecognitionException {
        try {
            int _type = PWRPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:533:7: ( P W R P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:533:9: P W R P I N
            {
            mP(); 
            mW(); 
            mR(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PWRPIN"

    // $ANTLR start "SUPPIN"
    public final void mSUPPIN() throws RecognitionException {
        try {
            int _type = SUPPIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:534:7: ( S U P P I N )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:534:9: S U P P I N
            {
            mS(); 
            mU(); 
            mP(); 
            mP(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPPIN"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:537:11: ( ( 'a' | 'A' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:537:12: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:538:11: ( ( 'b' | 'B' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:538:12: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:539:11: ( ( 'c' | 'C' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:539:12: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:540:11: ( ( 'd' | 'D' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:540:12: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:541:11: ( ( 'e' | 'E' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:541:12: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "E"

    // $ANTLR start "F"
    public final void mF() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:542:11: ( ( 'f' | 'F' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:542:12: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "F"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:543:11: ( ( 'g' | 'G' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:543:12: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "G"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:544:11: ( ( 'h' | 'H' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:544:12: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "H"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:545:11: ( ( 'i' | 'I' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:545:12: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:546:11: ( ( 'j' | 'J' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:546:12: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "J"

    // $ANTLR start "K"
    public final void mK() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:547:11: ( ( 'k' | 'K' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:547:12: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "K"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:548:11: ( ( 'l' | 'L' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:548:12: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "M"
    public final void mM() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:549:11: ( ( 'm' | 'M' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:549:12: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "M"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:550:11: ( ( 'n' | 'N' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:550:12: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "N"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:551:11: ( ( 'o' | 'O' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:551:12: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "O"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:552:11: ( ( 'p' | 'P' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:552:12: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "P"

    // $ANTLR start "Q"
    public final void mQ() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:553:11: ( ( 'q' | 'Q' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:553:12: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Q"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:554:11: ( ( 'r' | 'R' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:554:12: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "R"

    // $ANTLR start "S"
    public final void mS() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:555:11: ( ( 's' | 'S' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:555:12: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "S"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:556:11: ( ( 't' | 'T' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:556:12: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "T"

    // $ANTLR start "U"
    public final void mU() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:557:11: ( ( 'u' | 'U' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:557:12: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "U"

    // $ANTLR start "V"
    public final void mV() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:558:11: ( ( 'v' | 'V' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:558:12: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "V"

    // $ANTLR start "W"
    public final void mW() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:559:11: ( ( 'w' | 'W' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:559:12: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "W"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:560:11: ( ( 'x' | 'X' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:560:12: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "X"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:561:11: ( ( 'y' | 'Y' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:561:12: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:562:11: ( ( 'z' | 'Z' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:562:12: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Z"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '+' | '-' | '$' | '/' )
            int alt1=7;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt1=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt1=2;
                }
                break;
            case '_':
                {
                alt1=3;
                }
                break;
            case '+':
                {
                alt1=4;
                }
                break;
            case '-':
                {
                alt1=5;
                }
                break;
            case '$':
                {
                alt1=6;
                }
                break;
            case '/':
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:17: ( 'a' .. 'z' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:17: ( 'a' .. 'z' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:30: ( 'A' .. 'Z' )
                    {
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:30: ( 'A' .. 'Z' )
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:31: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:43: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:49: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:55: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 6 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:61: '$'
                    {
                    match('$'); 

                    }
                    break;
                case 7 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:564:67: '/'
                    {
                    match('/'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:565:16: ( ( '0' .. '9' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:565:18: ( '0' .. '9' )
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:565:18: ( '0' .. '9' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:565:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:567:4: ( ( DIGIT )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:567:6: ( DIGIT )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:567:6: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:567:6: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:568:6: ( CHAR ( CHAR | DIGIT )* )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:568:8: CHAR ( CHAR | DIGIT )*
            {
            mCHAR(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:568:13: ( CHAR | DIGIT )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='$'||LA3_0=='+'||LA3_0=='-'||LA3_0=='/'||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:568:14: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:568:21: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "PINNUM"
    public final void mPINNUM() throws RecognitionException {
        try {
            int _type = PINNUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:569:7: ( DIGIT ( CHAR )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:569:9: DIGIT ( CHAR )+
            {
            mDIGIT(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:569:15: ( CHAR )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='$'||LA4_0=='+'||LA4_0=='-'||LA4_0=='/'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:569:15: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PINNUM"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken escaped=null;
            int normal;

            StringBuilder lBuf = new StringBuilder();
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:573:5: ( DBLQUOTE (escaped= ESC | normal=~ ( DBLQUOTE | '\\\\' ) )* DBLQUOTE )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:573:9: DBLQUOTE (escaped= ESC | normal=~ ( DBLQUOTE | '\\\\' ) )* DBLQUOTE
            {
            mDBLQUOTE(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:574:3: (escaped= ESC | normal=~ ( DBLQUOTE | '\\\\' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:574:5: escaped= ESC
            	    {
            	    int escapedStart960 = getCharIndex();
            	    int escapedStartLine960 = getLine();
            	    int escapedStartCharPos960 = getCharPositionInLine();
            	    mESC(); 
            	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart960, getCharIndex()-1);
            	    escaped.setLine(escapedStartLine960);
            	    escaped.setCharPositionInLine(escapedStartCharPos960);
            	    lBuf.append(escaped.getText());

            	    }
            	    break;
            	case 2 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:575:5: normal=~ ( DBLQUOTE | '\\\\' )
            	    {
            	    normal= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    lBuf.appendCodePoint(normal);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            mDBLQUOTE(); 
            setText(lBuf.toString());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:586:2: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+ )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:586:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:586:4: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' | '\\u001D' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0=='\u001D'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)=='\u001D'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:594:2: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:594:4: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:594:9: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:594:9: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:602:2: ( '/*' ( . )* '*/' )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:602:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:602:9: ( . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:602:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    // $ANTLR start "INCLUDE_DECL"
    public final void mINCLUDE_DECL() throws RecognitionException {
        try {
            int _type = INCLUDE_DECL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken fileName=null;

            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:612:2: ( INCLUDE ( WHITESPACE )? fileName= STRING )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:612:5: INCLUDE ( WHITESPACE )? fileName= STRING
            {
            mINCLUDE(); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:612:13: ( WHITESPACE )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='\t' && LA9_0<='\n')||(LA9_0>='\f' && LA9_0<='\r')||LA9_0=='\u001D'||LA9_0==' ') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:612:13: WHITESPACE
                    {
                    mWHITESPACE(); 

                    }
                    break;

            }

            int fileNameStart1117 = getCharIndex();
            int fileNameStartLine1117 = getLine();
            int fileNameStartCharPos1117 = getCharPositionInLine();
            mSTRING(); 
            fileName = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileNameStart1117, getCharIndex()-1);
            fileName.setLine(fileNameStartLine1117);
            fileName.setCharPositionInLine(fileNameStartCharPos1117);
            	String name = fileName.getText();
            			name = name.substring(1,name.length()-1);
            			System.out.println("  -- Including: " + name);
            			// check for duplicate include files
            			if (!includeNames.add(name)) {
            				System.out.println("ERROR: " + fileName.getInputStream().getSourceName() + " line " + 
            						fileName.getLine() + ":" + fileName.getCharPositionInLine() + 
            						" duplicate included file.");
                        	System.exit(1);
            			}
            			try {
            				// save the character stream by pushing it onto the stack
            				SaveStruct ss = new SaveStruct(input);
            				includes.push(ss);

            				// make a new ANTLRFileStream and switch to it
            				setCharStream(new ANTLRFileStream(name));
            				reset();

            			} catch (Exception fnf) { 
            				// exit if the file cannot be found
            				System.out.println(input.getSourceName() + " " + fileName.getLine() 
            					+ ":" + fileName.getCharPositionInLine() + " " + 
            					"Include file not found: " + fileName.getText()); 
            				System.exit(1);
            			}
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE_DECL"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:643:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' ) )
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:643:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            {
            match('\\'); 
            // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:644:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            int alt10=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt10=1;
                }
                break;
            case 'r':
                {
                alt10=2;
                }
                break;
            case 't':
                {
                alt10=3;
                }
                break;
            case 'b':
                {
                alt10=4;
                }
                break;
            case 'f':
                {
                alt10=5;
                }
                break;
            case '\"':
                {
                alt10=6;
                }
                break;
            case '\'':
                {
                alt10=7;
                }
                break;
            case '/':
                {
                alt10=8;
                }
                break;
            case '\\':
                {
                alt10=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:644:5: 'n'
                    {
                    match('n'); 
                    setText("\n");

                    }
                    break;
                case 2 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:645:5: 'r'
                    {
                    match('r'); 
                    setText("\r");

                    }
                    break;
                case 3 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:646:5: 't'
                    {
                    match('t'); 
                    setText("\t");

                    }
                    break;
                case 4 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:647:5: 'b'
                    {
                    match('b'); 
                    setText("\b");

                    }
                    break;
                case 5 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:648:5: 'f'
                    {
                    match('f'); 
                    setText("\f");

                    }
                    break;
                case 6 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:649:5: '\"'
                    {
                    match('\"'); 
                    setText("\"");

                    }
                    break;
                case 7 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:650:5: '\\''
                    {
                    match('\''); 
                    setText("\'");

                    }
                    break;
                case 8 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:651:5: '/'
                    {
                    match('/'); 
                    setText("/");

                    }
                    break;
                case 9 :
                    // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:652:5: '\\\\'
                    {
                    match('\\'); 
                    setText("\\");

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "ESC"

    public void mTokens() throws RecognitionException {
        // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:8: ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | BEGIN | END | COMBINE | INCLUDE | INFO | OPEN | PORT | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | PINNUM | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL )
        int alt11=47;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:10: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 2 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:20: COLON
                {
                mCOLON(); 

                }
                break;
            case 3 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:26: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 4 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:32: PERIOD
                {
                mPERIOD(); 

                }
                break;
            case 5 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:39: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 6 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:46: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 7 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:53: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 8 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:60: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 9 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:69: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 10 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:78: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 11 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:85: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 12 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:92: LANGLE
                {
                mLANGLE(); 

                }
                break;
            case 13 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:99: RANGLE
                {
                mRANGLE(); 

                }
                break;
            case 14 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:106: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 15 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:116: DBLQUOTE
                {
                mDBLQUOTE(); 

                }
                break;
            case 16 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:125: DESIGN
                {
                mDESIGN(); 

                }
                break;
            case 17 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:132: DEVICE
                {
                mDEVICE(); 

                }
                break;
            case 18 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:139: SUBDESIGN
                {
                mSUBDESIGN(); 

                }
                break;
            case 19 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:149: INST
                {
                mINST(); 

                }
                break;
            case 20 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:154: SUBINST
                {
                mSUBINST(); 

                }
                break;
            case 21 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:162: GROUP
                {
                mGROUP(); 

                }
                break;
            case 22 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:168: THIS
                {
                mTHIS(); 

                }
                break;
            case 23 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:173: OF
                {
                mOF(); 

                }
                break;
            case 24 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:176: NET
                {
                mNET(); 

                }
                break;
            case 25 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:180: ATTR
                {
                mATTR(); 

                }
                break;
            case 26 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:185: NEWATTR
                {
                mNEWATTR(); 

                }
                break;
            case 27 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:193: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 28 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:199: END
                {
                mEND(); 

                }
                break;
            case 29 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:203: COMBINE
                {
                mCOMBINE(); 

                }
                break;
            case 30 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:211: INCLUDE
                {
                mINCLUDE(); 

                }
                break;
            case 31 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:219: INFO
                {
                mINFO(); 

                }
                break;
            case 32 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:224: OPEN
                {
                mOPEN(); 

                }
                break;
            case 33 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:229: PORT
                {
                mPORT(); 

                }
                break;
            case 34 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:234: PIN
                {
                mPIN(); 

                }
                break;
            case 35 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:238: INPIN
                {
                mINPIN(); 

                }
                break;
            case 36 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:244: OUTPIN
                {
                mOUTPIN(); 

                }
                break;
            case 37 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:251: IOPIN
                {
                mIOPIN(); 

                }
                break;
            case 38 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:257: PWRPIN
                {
                mPWRPIN(); 

                }
                break;
            case 39 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:264: SUPPIN
                {
                mSUPPIN(); 

                }
                break;
            case 40 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:271: INT
                {
                mINT(); 

                }
                break;
            case 41 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:275: IDENT
                {
                mIDENT(); 

                }
                break;
            case 42 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:281: PINNUM
                {
                mPINNUM(); 

                }
                break;
            case 43 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:288: STRING
                {
                mSTRING(); 

                }
                break;
            case 44 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:295: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 45 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:306: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 46 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:319: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 47 :
                // /fpga/fpga1/users/rablack/workspace/PHDL/src/phdl/grammar/Phdl.g:1:337: INCLUDE_DECL
                {
                mINCLUDE_DECL(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\17\uffff\1\54\14\51\1\120\14\51\1\uffff\1\51\3\uffff\14\51\1\152"+
        "\2\51\1\152\22\51\2\uffff\1\51\1\uffff\26\51\1\uffff\4\51\1\u00a6"+
        "\1\51\1\u00a6\5\51\2\u00ad\4\51\2\u00b2\12\51\1\uffff\12\51\2\u00bf"+
        "\2\51\2\u00c2\6\51\2\u00c9\2\u00ca\2\51\1\uffff\2\51\2\u00cf\2\51"+
        "\1\uffff\2\51\2\u00d4\1\uffff\14\51\1\uffff\2\51\1\uffff\2\u00e3"+
        "\2\u00e4\2\u00e5\2\uffff\4\51\1\uffff\2\u00ea\2\51\1\uffff\2\51"+
        "\2\u00ef\2\u00f0\4\51\2\u00f5\2\51\3\uffff\2\u00f8\2\51\1\uffff"+
        "\2\51\2\u00fd\2\uffff\2\51\2\u0100\1\uffff\2\u0101\1\uffff\2\u0103"+
        "\2\u0104\1\uffff\2\51\5\uffff\2\u0107\1\uffff";
    static final String DFA11_eofS =
        "\u0108\uffff";
    static final String DFA11_minS =
        "\1\11\16\uffff\1\0\1\105\1\125\1\116\1\122\1\110\1\106\1\105\1\124"+
        "\1\105\1\116\1\117\1\111\1\44\1\105\1\125\1\116\1\122\1\110\1\106"+
        "\1\105\1\124\1\105\1\116\1\117\1\111\1\uffff\1\52\3\uffff\2\123"+
        "\2\102\1\103\1\120\1\103\1\120\2\117\2\111\1\44\1\105\1\124\1\44"+
        "\1\105\5\124\2\107\2\104\2\115\1\122\1\116\2\122\1\116\1\122\2\uffff"+
        "\1\0\1\uffff\4\111\1\104\1\120\1\104\1\120\1\124\1\114\1\117\1\111"+
        "\1\124\1\114\1\117\3\111\2\125\2\123\1\uffff\2\116\2\120\1\44\1"+
        "\101\1\44\1\101\2\122\2\111\2\44\2\102\2\124\2\44\2\120\10\0\1\uffff"+
        "\2\107\2\103\1\105\1\116\1\105\1\116\2\111\2\44\2\125\2\44\4\116"+
        "\2\120\4\44\2\111\1\uffff\2\124\2\44\2\116\1\uffff\2\111\2\44\1"+
        "\uffff\2\111\2\116\2\105\4\123\2\116\1\uffff\2\104\1\uffff\6\44"+
        "\2\uffff\2\116\2\124\1\uffff\2\44\2\116\1\uffff\2\116\4\44\2\111"+
        "\2\124\2\44\2\105\3\uffff\2\44\2\122\1\uffff\2\105\2\44\2\uffff"+
        "\2\107\2\44\1\uffff\2\11\1\uffff\4\44\1\uffff\2\116\5\uffff\2\44"+
        "\1\uffff";
    static final String DFA11_maxS =
        "\1\175\16\uffff\1\uffff\1\145\1\165\1\157\1\162\1\150\1\165\1\145"+
        "\1\164\1\145\1\156\1\157\1\167\1\172\1\145\1\165\1\157\1\162\1\150"+
        "\1\165\1\145\1\164\1\145\1\156\1\157\1\167\1\uffff\1\57\3\uffff"+
        "\2\166\2\160\1\163\1\160\1\163\1\160\2\157\2\151\1\172\1\145\1\164"+
        "\1\172\1\145\1\164\2\167\2\164\2\147\2\144\2\155\1\162\1\156\2\162"+
        "\1\156\1\162\2\uffff\1\uffff\1\uffff\5\151\1\160\1\151\1\160\1\164"+
        "\1\154\1\157\1\151\1\164\1\154\1\157\3\151\2\165\2\163\1\uffff\2"+
        "\156\2\160\1\172\1\141\1\172\1\141\2\162\2\151\2\172\2\142\2\164"+
        "\2\172\2\160\10\uffff\1\uffff\2\147\2\143\1\145\1\156\1\145\1\156"+
        "\2\151\2\172\2\165\2\172\4\156\2\160\4\172\2\151\1\uffff\2\164\2"+
        "\172\2\156\1\uffff\2\151\2\172\1\uffff\2\151\2\156\2\145\4\163\2"+
        "\156\1\uffff\2\144\1\uffff\6\172\2\uffff\2\156\2\164\1\uffff\2\172"+
        "\2\156\1\uffff\2\156\4\172\2\151\2\164\2\172\2\145\3\uffff\2\172"+
        "\2\162\1\uffff\2\145\2\172\2\uffff\2\147\2\172\1\uffff\2\172\1\uffff"+
        "\4\172\1\uffff\2\156\5\uffff\2\172\1\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\32\uffff\1\51\1\uffff\1\54\1\17\1\53\42\uffff\1\50\1\52"+
        "\1\uffff\1\56\26\uffff\1\27\36\uffff\1\55\34\uffff\1\30\6\uffff"+
        "\1\34\4\uffff\1\42\14\uffff\1\23\2\uffff\1\37\6\uffff\1\26\1\40"+
        "\4\uffff\1\31\4\uffff\1\41\16\uffff\1\43\1\45\1\25\4\uffff\1\33"+
        "\4\uffff\1\20\1\21\4\uffff\1\47\2\uffff\1\44\4\uffff\1\46\2\uffff"+
        "\1\24\1\36\1\57\1\32\1\35\2\uffff\1\22";
    static final String DFA11_specialS =
        "\17\uffff\1\6\102\uffff\1\10\56\uffff\1\0\1\1\1\3\1\2\1\5\1\4\1"+
        "\7\1\11\177\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\53\1\uffff\2\53\17\uffff\1\53\2\uffff\1\53\1\uffff\1\17\1"+
            "\uffff\1\51\1\uffff\1\16\1\uffff\1\6\1\7\1\uffff\1\51\1\3\1"+
            "\51\1\4\1\52\12\34\1\2\1\1\1\14\1\5\1\15\2\uffff\1\44\1\45\1"+
            "\47\1\35\1\46\1\51\1\40\1\51\1\37\4\51\1\43\1\42\1\50\2\51\1"+
            "\36\1\41\6\51\1\10\1\uffff\1\11\1\uffff\1\51\1\uffff\1\27\1"+
            "\30\1\32\1\20\1\31\1\51\1\23\1\51\1\22\4\51\1\26\1\25\1\33\2"+
            "\51\1\21\1\24\6\51\1\12\1\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\55",
            "\1\57\37\uffff\1\56",
            "\1\61\37\uffff\1\60",
            "\1\64\1\65\36\uffff\1\62\1\63",
            "\1\67\37\uffff\1\66",
            "\1\71\37\uffff\1\70",
            "\1\75\11\uffff\1\76\4\uffff\1\77\20\uffff\1\72\11\uffff\1\73"+
            "\4\uffff\1\74",
            "\1\101\37\uffff\1\100",
            "\1\103\37\uffff\1\102",
            "\1\105\37\uffff\1\104",
            "\1\107\37\uffff\1\106",
            "\1\111\37\uffff\1\110",
            "\1\116\5\uffff\1\115\7\uffff\1\117\21\uffff\1\113\5\uffff\1"+
            "\112\7\uffff\1\114",
            "\1\121\6\uffff\1\121\1\uffff\1\121\1\uffff\1\121\21\uffff\32"+
            "\121\4\uffff\1\121\1\uffff\32\121",
            "\1\57\37\uffff\1\56",
            "\1\61\37\uffff\1\60",
            "\1\64\1\65\36\uffff\1\62\1\63",
            "\1\67\37\uffff\1\66",
            "\1\71\37\uffff\1\70",
            "\1\75\11\uffff\1\76\4\uffff\1\77\20\uffff\1\72\11\uffff\1\73"+
            "\4\uffff\1\74",
            "\1\101\37\uffff\1\100",
            "\1\103\37\uffff\1\102",
            "\1\105\37\uffff\1\104",
            "\1\107\37\uffff\1\106",
            "\1\111\37\uffff\1\110",
            "\1\116\5\uffff\1\115\7\uffff\1\117\21\uffff\1\113\5\uffff\1"+
            "\112\7\uffff\1\114",
            "",
            "\1\123\4\uffff\1\122",
            "",
            "",
            "",
            "\1\126\2\uffff\1\127\34\uffff\1\124\2\uffff\1\125",
            "\1\126\2\uffff\1\127\34\uffff\1\124\2\uffff\1\125",
            "\1\132\15\uffff\1\133\21\uffff\1\130\15\uffff\1\131",
            "\1\132\15\uffff\1\133\21\uffff\1\130\15\uffff\1\131",
            "\1\141\2\uffff\1\142\11\uffff\1\143\2\uffff\1\140\17\uffff"+
            "\1\135\2\uffff\1\136\11\uffff\1\137\2\uffff\1\134",
            "\1\145\37\uffff\1\144",
            "\1\141\2\uffff\1\142\11\uffff\1\143\2\uffff\1\140\17\uffff"+
            "\1\135\2\uffff\1\136\11\uffff\1\137\2\uffff\1\134",
            "\1\145\37\uffff\1\144",
            "\1\147\37\uffff\1\146",
            "\1\147\37\uffff\1\146",
            "\1\151\37\uffff\1\150",
            "\1\151\37\uffff\1\150",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\154\37\uffff\1\153",
            "\1\156\37\uffff\1\155",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\154\37\uffff\1\153",
            "\1\156\37\uffff\1\155",
            "\1\161\2\uffff\1\162\34\uffff\1\157\2\uffff\1\160",
            "\1\161\2\uffff\1\162\34\uffff\1\157\2\uffff\1\160",
            "\1\164\37\uffff\1\163",
            "\1\164\37\uffff\1\163",
            "\1\166\37\uffff\1\165",
            "\1\166\37\uffff\1\165",
            "\1\170\37\uffff\1\167",
            "\1\170\37\uffff\1\167",
            "\1\172\37\uffff\1\171",
            "\1\172\37\uffff\1\171",
            "\1\174\37\uffff\1\173",
            "\1\176\37\uffff\1\175",
            "\1\u0080\37\uffff\1\177",
            "\1\174\37\uffff\1\173",
            "\1\176\37\uffff\1\175",
            "\1\u0080\37\uffff\1\177",
            "",
            "",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "",
            "\1\u008b\37\uffff\1\u008a",
            "\1\u008d\37\uffff\1\u008c",
            "\1\u008b\37\uffff\1\u008a",
            "\1\u008d\37\uffff\1\u008c",
            "\1\u0090\4\uffff\1\u0091\32\uffff\1\u008e\4\uffff\1\u008f",
            "\1\u0093\37\uffff\1\u0092",
            "\1\u0090\4\uffff\1\u0091\32\uffff\1\u008e\4\uffff\1\u008f",
            "\1\u0093\37\uffff\1\u0092",
            "\1\u0095\37\uffff\1\u0094",
            "\1\u0097\37\uffff\1\u0096",
            "\1\u0099\37\uffff\1\u0098",
            "\1\u009b\37\uffff\1\u009a",
            "\1\u0095\37\uffff\1\u0094",
            "\1\u0097\37\uffff\1\u0096",
            "\1\u0099\37\uffff\1\u0098",
            "\1\u009b\37\uffff\1\u009a",
            "\1\u009d\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009c",
            "\1\u009f\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009e",
            "\1\u00a1\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a0",
            "",
            "\1\u00a3\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a2",
            "\1\u00a5\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a4",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a8\37\uffff\1\u00a7",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a8\37\uffff\1\u00a7",
            "\1\u00aa\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00a9",
            "\1\u00ac\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ab",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00af\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00ae",
            "\1\u00b1\37\uffff\1\u00b0",
            "\1\u00b1\37\uffff\1\u00b0",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b4\37\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b3",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "\12\u0089\1\uffff\2\u0089\1\uffff\26\u0089\1\u0086\6\u0089"+
            "\1\u0084\1\u0089\1\u0085\1\u0089\1\u0087\12\u0088\7\u0089\32"+
            "\u0082\4\u0089\1\u0083\1\u0089\32\u0081\uff85\u0089",
            "",
            "\1\u00b6\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b5",
            "\1\u00b8\37\uffff\1\u00b7",
            "\1\u00b8\37\uffff\1\u00b7",
            "\1\u00ba\37\uffff\1\u00b9",
            "\1\u00bc\37\uffff\1\u00bb",
            "\1\u00ba\37\uffff\1\u00b9",
            "\1\u00bc\37\uffff\1\u00bb",
            "\1\u00be\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00bd",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00c1\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c0",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00c4\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c3",
            "\1\u00c6\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c5",
            "\1\u00c8\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c7",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00cc\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cb",
            "",
            "\1\u00ce\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00cd",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00d1\37\uffff\1\u00d0",
            "\1\u00d1\37\uffff\1\u00d0",
            "",
            "\1\u00d3\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d2",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00d6\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d5",
            "\1\u00d8\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d7",
            "\1\u00da\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00d9",
            "\1\u00dc\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00db",
            "\1\u00de\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00dd",
            "\1\u00e0\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00df",
            "",
            "\1\u00e2\37\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e1",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u00e7\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e6",
            "\1\u00e9\37\uffff\1\u00e8",
            "\1\u00e9\37\uffff\1\u00e8",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00ec\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00eb",
            "",
            "\1\u00ee\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00ed",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00f2\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f1",
            "\1\u00f4\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f3",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00f7\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f6",
            "",
            "",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u00fa\37\uffff\1\u00f9",
            "\1\u00fa\37\uffff\1\u00f9",
            "",
            "\1\u00fc\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fb",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u00ff\37\uffff\1\u00fe",
            "\1\u00ff\37\uffff\1\u00fe",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\2\u0102\1\uffff\2\u0102\17\uffff\1\u0102\2\uffff\1\u0102\1"+
            "\uffff\1\u0102\1\uffff\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff"+
            "\13\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\2\u0102\1\uffff\2\u0102\17\uffff\1\u0102\2\uffff\1\u0102\1"+
            "\uffff\1\u0102\1\uffff\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff"+
            "\13\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u0106\37\uffff\1\u0105",
            "\1\u0106\37\uffff\1\u0105",
            "",
            "",
            "",
            "",
            "",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\6\uffff\1\51\1\uffff\1\51\1\uffff\13\51\7\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SEMICOLON | COLON | COMMA | PERIOD | EQUALS | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | LANGLE | RANGLE | AMPERSAND | DBLQUOTE | DESIGN | DEVICE | SUBDESIGN | INST | SUBINST | GROUP | THIS | OF | NET | ATTR | NEWATTR | BEGIN | END | COMBINE | INCLUDE | INFO | OPEN | PORT | PIN | INPIN | OUTPIN | IOPIN | PWRPIN | SUPPIN | INT | IDENT | PINNUM | STRING | WHITESPACE | LINE_COMMENT | MULTILINE_COMMENT | INCLUDE_DECL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_129 = input.LA(1);

                        s = -1;
                        if ( ((LA11_129>='a' && LA11_129<='z')) ) {s = 129;}

                        else if ( ((LA11_129>='A' && LA11_129<='Z')) ) {s = 130;}

                        else if ( (LA11_129=='_') ) {s = 131;}

                        else if ( (LA11_129=='+') ) {s = 132;}

                        else if ( (LA11_129=='-') ) {s = 133;}

                        else if ( (LA11_129=='$') ) {s = 134;}

                        else if ( (LA11_129=='/') ) {s = 135;}

                        else if ( ((LA11_129>='0' && LA11_129<='9')) ) {s = 136;}

                        else if ( ((LA11_129>='\u0000' && LA11_129<='\t')||(LA11_129>='\u000B' && LA11_129<='\f')||(LA11_129>='\u000E' && LA11_129<='#')||(LA11_129>='%' && LA11_129<='*')||LA11_129==','||LA11_129=='.'||(LA11_129>=':' && LA11_129<='@')||(LA11_129>='[' && LA11_129<='^')||LA11_129=='`'||(LA11_129>='{' && LA11_129<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_130 = input.LA(1);

                        s = -1;
                        if ( ((LA11_130>='a' && LA11_130<='z')) ) {s = 129;}

                        else if ( ((LA11_130>='A' && LA11_130<='Z')) ) {s = 130;}

                        else if ( (LA11_130=='_') ) {s = 131;}

                        else if ( (LA11_130=='+') ) {s = 132;}

                        else if ( (LA11_130=='-') ) {s = 133;}

                        else if ( (LA11_130=='$') ) {s = 134;}

                        else if ( (LA11_130=='/') ) {s = 135;}

                        else if ( ((LA11_130>='0' && LA11_130<='9')) ) {s = 136;}

                        else if ( ((LA11_130>='\u0000' && LA11_130<='\t')||(LA11_130>='\u000B' && LA11_130<='\f')||(LA11_130>='\u000E' && LA11_130<='#')||(LA11_130>='%' && LA11_130<='*')||LA11_130==','||LA11_130=='.'||(LA11_130>=':' && LA11_130<='@')||(LA11_130>='[' && LA11_130<='^')||LA11_130=='`'||(LA11_130>='{' && LA11_130<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_132 = input.LA(1);

                        s = -1;
                        if ( ((LA11_132>='a' && LA11_132<='z')) ) {s = 129;}

                        else if ( ((LA11_132>='A' && LA11_132<='Z')) ) {s = 130;}

                        else if ( (LA11_132=='_') ) {s = 131;}

                        else if ( (LA11_132=='+') ) {s = 132;}

                        else if ( (LA11_132=='-') ) {s = 133;}

                        else if ( (LA11_132=='$') ) {s = 134;}

                        else if ( (LA11_132=='/') ) {s = 135;}

                        else if ( ((LA11_132>='0' && LA11_132<='9')) ) {s = 136;}

                        else if ( ((LA11_132>='\u0000' && LA11_132<='\t')||(LA11_132>='\u000B' && LA11_132<='\f')||(LA11_132>='\u000E' && LA11_132<='#')||(LA11_132>='%' && LA11_132<='*')||LA11_132==','||LA11_132=='.'||(LA11_132>=':' && LA11_132<='@')||(LA11_132>='[' && LA11_132<='^')||LA11_132=='`'||(LA11_132>='{' && LA11_132<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_131 = input.LA(1);

                        s = -1;
                        if ( ((LA11_131>='a' && LA11_131<='z')) ) {s = 129;}

                        else if ( ((LA11_131>='A' && LA11_131<='Z')) ) {s = 130;}

                        else if ( (LA11_131=='_') ) {s = 131;}

                        else if ( (LA11_131=='+') ) {s = 132;}

                        else if ( (LA11_131=='-') ) {s = 133;}

                        else if ( (LA11_131=='$') ) {s = 134;}

                        else if ( (LA11_131=='/') ) {s = 135;}

                        else if ( ((LA11_131>='0' && LA11_131<='9')) ) {s = 136;}

                        else if ( ((LA11_131>='\u0000' && LA11_131<='\t')||(LA11_131>='\u000B' && LA11_131<='\f')||(LA11_131>='\u000E' && LA11_131<='#')||(LA11_131>='%' && LA11_131<='*')||LA11_131==','||LA11_131=='.'||(LA11_131>=':' && LA11_131<='@')||(LA11_131>='[' && LA11_131<='^')||LA11_131=='`'||(LA11_131>='{' && LA11_131<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_134 = input.LA(1);

                        s = -1;
                        if ( ((LA11_134>='a' && LA11_134<='z')) ) {s = 129;}

                        else if ( ((LA11_134>='A' && LA11_134<='Z')) ) {s = 130;}

                        else if ( (LA11_134=='_') ) {s = 131;}

                        else if ( (LA11_134=='+') ) {s = 132;}

                        else if ( (LA11_134=='-') ) {s = 133;}

                        else if ( (LA11_134=='$') ) {s = 134;}

                        else if ( (LA11_134=='/') ) {s = 135;}

                        else if ( ((LA11_134>='0' && LA11_134<='9')) ) {s = 136;}

                        else if ( ((LA11_134>='\u0000' && LA11_134<='\t')||(LA11_134>='\u000B' && LA11_134<='\f')||(LA11_134>='\u000E' && LA11_134<='#')||(LA11_134>='%' && LA11_134<='*')||LA11_134==','||LA11_134=='.'||(LA11_134>=':' && LA11_134<='@')||(LA11_134>='[' && LA11_134<='^')||LA11_134=='`'||(LA11_134>='{' && LA11_134<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_133 = input.LA(1);

                        s = -1;
                        if ( ((LA11_133>='a' && LA11_133<='z')) ) {s = 129;}

                        else if ( ((LA11_133>='A' && LA11_133<='Z')) ) {s = 130;}

                        else if ( (LA11_133=='_') ) {s = 131;}

                        else if ( (LA11_133=='+') ) {s = 132;}

                        else if ( (LA11_133=='-') ) {s = 133;}

                        else if ( (LA11_133=='$') ) {s = 134;}

                        else if ( (LA11_133=='/') ) {s = 135;}

                        else if ( ((LA11_133>='0' && LA11_133<='9')) ) {s = 136;}

                        else if ( ((LA11_133>='\u0000' && LA11_133<='\t')||(LA11_133>='\u000B' && LA11_133<='\f')||(LA11_133>='\u000E' && LA11_133<='#')||(LA11_133>='%' && LA11_133<='*')||LA11_133==','||LA11_133=='.'||(LA11_133>=':' && LA11_133<='@')||(LA11_133>='[' && LA11_133<='^')||LA11_133=='`'||(LA11_133>='{' && LA11_133<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_15 = input.LA(1);

                        s = -1;
                        if ( ((LA11_15>='\u0000' && LA11_15<='\uFFFF')) ) {s = 45;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA11_135 = input.LA(1);

                        s = -1;
                        if ( ((LA11_135>='a' && LA11_135<='z')) ) {s = 129;}

                        else if ( ((LA11_135>='A' && LA11_135<='Z')) ) {s = 130;}

                        else if ( (LA11_135=='_') ) {s = 131;}

                        else if ( (LA11_135=='+') ) {s = 132;}

                        else if ( (LA11_135=='-') ) {s = 133;}

                        else if ( (LA11_135=='$') ) {s = 134;}

                        else if ( (LA11_135=='/') ) {s = 135;}

                        else if ( ((LA11_135>='0' && LA11_135<='9')) ) {s = 136;}

                        else if ( ((LA11_135>='\u0000' && LA11_135<='\t')||(LA11_135>='\u000B' && LA11_135<='\f')||(LA11_135>='\u000E' && LA11_135<='#')||(LA11_135>='%' && LA11_135<='*')||LA11_135==','||LA11_135=='.'||(LA11_135>=':' && LA11_135<='@')||(LA11_135>='[' && LA11_135<='^')||LA11_135=='`'||(LA11_135>='{' && LA11_135<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA11_82 = input.LA(1);

                        s = -1;
                        if ( ((LA11_82>='a' && LA11_82<='z')) ) {s = 129;}

                        else if ( ((LA11_82>='A' && LA11_82<='Z')) ) {s = 130;}

                        else if ( (LA11_82=='_') ) {s = 131;}

                        else if ( (LA11_82=='+') ) {s = 132;}

                        else if ( (LA11_82=='-') ) {s = 133;}

                        else if ( (LA11_82=='$') ) {s = 134;}

                        else if ( (LA11_82=='/') ) {s = 135;}

                        else if ( ((LA11_82>='0' && LA11_82<='9')) ) {s = 136;}

                        else if ( ((LA11_82>='\u0000' && LA11_82<='\t')||(LA11_82>='\u000B' && LA11_82<='\f')||(LA11_82>='\u000E' && LA11_82<='#')||(LA11_82>='%' && LA11_82<='*')||LA11_82==','||LA11_82=='.'||(LA11_82>=':' && LA11_82<='@')||(LA11_82>='[' && LA11_82<='^')||LA11_82=='`'||(LA11_82>='{' && LA11_82<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA11_136 = input.LA(1);

                        s = -1;
                        if ( ((LA11_136>='a' && LA11_136<='z')) ) {s = 129;}

                        else if ( ((LA11_136>='A' && LA11_136<='Z')) ) {s = 130;}

                        else if ( (LA11_136=='_') ) {s = 131;}

                        else if ( (LA11_136=='+') ) {s = 132;}

                        else if ( (LA11_136=='-') ) {s = 133;}

                        else if ( (LA11_136=='$') ) {s = 134;}

                        else if ( (LA11_136=='/') ) {s = 135;}

                        else if ( ((LA11_136>='0' && LA11_136<='9')) ) {s = 136;}

                        else if ( ((LA11_136>='\u0000' && LA11_136<='\t')||(LA11_136>='\u000B' && LA11_136<='\f')||(LA11_136>='\u000E' && LA11_136<='#')||(LA11_136>='%' && LA11_136<='*')||LA11_136==','||LA11_136=='.'||(LA11_136>=':' && LA11_136<='@')||(LA11_136>='[' && LA11_136<='^')||LA11_136=='`'||(LA11_136>='{' && LA11_136<='\uFFFF')) ) {s = 137;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}