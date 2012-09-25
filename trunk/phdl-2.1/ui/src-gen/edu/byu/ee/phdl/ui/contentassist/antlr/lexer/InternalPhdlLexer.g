
/*
* generated by Xtext
*/
lexer grammar InternalPhdlLexer;


@header {
package edu.byu.ee.phdl.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




KEYWORD_41 : 'subdesign';

KEYWORD_37 : 'combine';

KEYWORD_38 : 'package';

KEYWORD_39 : 'passpin';

KEYWORD_40 : 'subinst';

KEYWORD_30 : 'design';

KEYWORD_31 : 'device';

KEYWORD_32 : 'import';

KEYWORD_33 : 'outpin';

KEYWORD_34 : 'pwrpin';

KEYWORD_35 : 'suppin';

KEYWORD_36 : 'tripin';

KEYWORD_25 : 'inpin';

KEYWORD_26 : 'iopin';

KEYWORD_27 : 'ncpin';

KEYWORD_28 : 'ocpin';

KEYWORD_29 : 'oepin';

KEYWORD_19 : 'attr';

KEYWORD_20 : 'info';

KEYWORD_21 : 'inst';

KEYWORD_22 : 'open';

KEYWORD_23 : 'port';

KEYWORD_24 : 'this';

KEYWORD_17 : 'net';

KEYWORD_18 : 'pin';

KEYWORD_16 : 'of';

KEYWORD_1 : '&';

KEYWORD_2 : '(';

KEYWORD_3 : ')';

KEYWORD_4 : '*';

KEYWORD_5 : ',';

KEYWORD_6 : '.';

KEYWORD_7 : ':';

KEYWORD_8 : ';';

KEYWORD_9 : '<';

KEYWORD_10 : '=';

KEYWORD_11 : '>';

KEYWORD_12 : '[';

KEYWORD_13 : ']';

KEYWORD_14 : '{';

KEYWORD_15 : '}';



RULE_ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9'|'1'..'9' ('0'..'9')+);

RULE_PINNUM : ('0'..'9'|'a'..'z'|'A'..'Z'|'_'|'+'|'-'|'$'|'/'|'@'|'!')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;



