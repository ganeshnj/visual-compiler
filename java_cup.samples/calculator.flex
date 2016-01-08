
%%
   
%package calculator
%class Lexer
%line
%column
%cup

%%
[ \t\n\r]				{ }
";"						{ return getSymbolFactory().newSymbol ("TERM", Sym.TERM); }
"="						{ return getSymbolFactory().newSymbol ("EQUAL", Sym.EQUAL); }
"+"						{ return getSymbolFactory().newSymbol ("PLUS", Sym.PLUS); }
"-"						{ return getSymbolFactory().newSymbol ("MINUS", Sym.MINUS); }
"*"						{ return getSymbolFactory().newSymbol ("TIMES", Sym.TIMES); }
"/"						{ return getSymbolFactory().newSymbol ("DIVIDE", Sym.DIVIDE); }
"("						{ return getSymbolFactory().newSymbol ("LPAREN", Sym.LPAREN); }
")"						{ return getSymbolFactory().newSymbol ("RPAREN", Sym.RPAREN); }

"create"				{ return getSymbolFactory().newSymbol ("CREATE", Sym.CREATE); }
"class"					{ return getSymbolFactory().newSymbol ("CLASS", Sym.CLASS); }
"method"				{ return getSymbolFactory().newSymbol ("METHOD", Sym.METHOD); }
"data"					{ return getSymbolFactory().newSymbol ("DATA", Sym.DATA); }
"type"					{ return getSymbolFactory().newSymbol ("TYPE", Sym.TYPE); }

"set"					{ return getSymbolFactory().newSymbol ("SET", Sym.SET); }
"position"				{ return getSymbolFactory().newSymbol ("POSITION", Sym.POSITION); }
"ret"				{ return getSymbolFactory().newSymbol ("RET", Sym.RET); }
"arg"				{ return getSymbolFactory().newSymbol ("ARG", Sym.ARG); }
"acc"				{ return getSymbolFactory().newSymbol ("ACC", Sym.ACC); }

"public"				{ return getSymbolFactory().newSymbol ("PUBLIC", Sym.PUBLIC); }
"protected"				{ return getSymbolFactory().newSymbol ("PROTECTED", Sym.PROTECTED); }
"private"				{ return getSymbolFactory().newSymbol ("PRIVATE", Sym.PRIVATE); }



"add"					{ return getSymbolFactory().newSymbol ("ADD", Sym.ADD); }
"to"					{ return getSymbolFactory().newSymbol ("TO", Sym.TO); }

"draw"					{ return getSymbolFactory().newSymbol ("DRAW", Sym.DRAW); }
   
[0-9]+      			{ return getSymbolFactory().newSymbol ("NUMBER", Sym.NUMBER, new Integer(yytext())); }
[A-Za-z_][A-Za-z_0-9]*	{ return getSymbolFactory().newSymbol ("ID", Sym.ID, new String(yytext())); }
   
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
