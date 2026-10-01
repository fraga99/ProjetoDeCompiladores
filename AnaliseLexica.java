import java.io.*;

enum TokenType{ NUM, SOMA, MULT, SUB, DIV, APar, FPar, EOF}

class Token{
  String lexema;
  TokenType token;

  Token (String l, TokenType t)
  	{ lexema=l; token = t;}

}

class AnaliseLexica {

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception
	{

	 	this.arquivo = new PushbackReader(new BufferedReader(new FileReader(a)));

	}

	Token getNextToken() throws Exception
	{
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar1 != eof && (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r'));

			if(currchar1 != eof)
			{

				// Exercício 1: aceitar números naturais com mais de um dígito.
				// Continua lendo enquanto vierem dígitos, acumulando-os em uma String,
				// e devolve (unread) o primeiro caractere que não for dígito.
				if (currchar >= '0' && currchar <= '9')
				{
					StringBuilder numero = new StringBuilder();
					while (currchar1 != eof && currchar >= '0' && currchar <= '9')
					{
						numero.append(currchar);
						currchar1 = arquivo.read();
						currchar = (char) currchar1;
					}
					if (currchar1 != eof)
						arquivo.unread(currchar1);

					return (new Token (numero.toString(), TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token ("(",TokenType.APar));
						case ')':
							return (new Token (")",TokenType.FPar));
						case '+':
							return (new Token ("+",TokenType.SOMA));
						case '*':
							return (new Token ("*",TokenType.MULT));
						case '-':
							return (new Token ("-",TokenType.SUB));
						case '/':
							return (new Token ("/",TokenType.DIV));

						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();

		return (new Token("",TokenType.EOF));

	}
}