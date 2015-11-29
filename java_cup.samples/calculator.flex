
%%
   
%package calculator
%class Lexer
%line
%column
%cup

%%
[ \t\f]					{ }
\r\n|\r|\n				{ return getSymbolFactory().newSymbol ("EOLN", Sym.EOLN); }
"="						{ return getSymbolFactory().newSymbol ("EQUAL", Sym.EQUAL); }
"+"						{ return getSymbolFactory().newSymbol ("PLUS", Sym.PLUS); }
"-"						{ return getSymbolFactory().newSymbol ("MINUS", Sym.MINUS); }
"*"						{ return getSymbolFactory().newSymbol ("TIMES", Sym.TIMES); }
"/"						{ return getSymbolFactory().newSymbol ("DIVIDE", Sym.DIVIDE); }
"("						{ return getSymbolFactory().newSymbol ("LPAREN", Sym.LPAREN); }
")"						{ return getSymbolFactory().newSymbol ("RPAREN", Sym.RPAREN); }

"create"				{ return getSymbolFactory().newSymbol ("CREATE", Sym.CREATE); }
"class"					{ return getSymbolFactory().newSymbol ("CLASS", Sym.CLASS); }

"set"					{ return getSymbolFactory().newSymbol ("SET", Sym.SET); }
"public"				{ return getSymbolFactory().newSymbol ("PUBLIC", Sym.PUBLIC); }
"protected"				{ return getSymbolFactory().newSymbol ("PROTECTED", Sym.PROTECTED); }
"private"				{ return getSymbolFactory().newSymbol ("PRIVATE", Sym.PRIVATE); }

"draw"					{ return getSymbolFactory().newSymbol ("DRAW", Sym.DRAW); }
   
[0-9]+      			{ return getSymbolFactory().newSymbol ("NUMBER", Sym.NUMBER, new Integer(yytext())); }
[A-Za-z_][A-Za-z_0-9]*	{ return getSymbolFactory().newSymbol ("ID", Sym.ID, new String(yytext())); }
   
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }