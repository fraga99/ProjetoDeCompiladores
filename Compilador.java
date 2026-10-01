class Compilador{

	public static void main(String[]args)
	{
		ArvoreSintatica arv=null;

		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);

			arv = as.parseProg();

			// Exercício 3: o back-end agora é um interpretador, que devolve
			// diretamente o resultado da computação da expressão de entrada,
			// em vez de gerar uma String de código para a máquina de pilha.
			Interpretador backend = new Interpretador();
			int resultado = backend.interpreta(arv);
			System.out.println(resultado);

		}catch(Exception e)
		{
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}