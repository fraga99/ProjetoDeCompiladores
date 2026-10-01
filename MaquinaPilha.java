import java.io.*;
import java.util.*;

// Exercício 4: máquina de pilha que executa as instruções geradas pelo
// compilador didático (PUSH n, SUM, MULT, SUB, DIV, PRINT).
// Uso: java MaquinaPilha arquivoDeEntrada
class MaquinaPilha{

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Uso: java MaquinaPilha <arquivoDeEntrada>");
			return;
		}

		Deque<Integer> pilha = new ArrayDeque<Integer>();

		try (BufferedReader arquivo = new BufferedReader(new FileReader(args[0])))
		{
			String linha;
			while ((linha = arquivo.readLine()) != null)
			{
				linha = linha.trim();
				if (linha.isEmpty())
					continue;

				String[] partes = linha.split("\\s+");
				String instrucao = partes[0];

				switch (instrucao)
				{
					case "PUSH":
						pilha.push(Integer.parseInt(partes[1]));
						break;

					case "SUM":
					{
						int arg2 = pilha.pop();
						int arg1 = pilha.pop();
						pilha.push(arg1 + arg2);
						break;
					}

					case "MULT":
					{
						int arg2 = pilha.pop();
						int arg1 = pilha.pop();
						pilha.push(arg1 * arg2);
						break;
					}

					case "SUB":
					{
						int arg2 = pilha.pop();
						int arg1 = pilha.pop();
						pilha.push(arg1 - arg2);
						break;
					}

					case "DIV":
					{
						int arg2 = pilha.pop();
						int arg1 = pilha.pop();
						pilha.push(arg1 / arg2);
						break;
					}

					case "PRINT":
						System.out.println(pilha.peek());
						break;

					default:
						throw new Exception("Instrução inválida: " + instrucao);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro de execução:\n" + e);
		}
	}
}