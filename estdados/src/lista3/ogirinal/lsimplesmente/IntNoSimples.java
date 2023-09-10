package lista3.ogirinal.lsimplesmente;

class IntNoSimples {
	int valor;
	IntNoSimples prox;/*
						 * variável com mesmo nome da classe, onde prox faz referência ao próx elemento
						 * da lista. Java não aceita ponteiros
						 */

	IntNoSimples(int valorNo) {
		valor = valorNo;
		prox = null;
	}
}
