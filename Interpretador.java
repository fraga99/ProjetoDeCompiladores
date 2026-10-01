// Exercício 3: back-end interpretador.
// Em vez de gerar uma String com código para a máquina de pilha, este back-end
// percorre a árvore sintática e já devolve o resultado (int) da computação.
class Interpretador{

	int interpreta (ArvoreSintatica arv)
	{
		if (arv instanceof Mult)
			return interpreta(((Mult) arv).arg1) * interpreta(((Mult) arv).arg2);

		if (arv instanceof Soma)
			return interpreta(((Soma) arv).arg1) + interpreta(((Soma) arv).arg2);

		if (arv instanceof Sub)
			return interpreta(((Sub) arv).arg1) - interpreta(((Sub) arv).arg2);

		if (arv instanceof Div)
			return interpreta(((Div) arv).arg1) / interpreta(((Div) arv).arg2);

		if (arv instanceof Num)
			return ((Num) arv).num;

		throw new RuntimeException("Nó de árvore sintática desconhecido");
	}
}