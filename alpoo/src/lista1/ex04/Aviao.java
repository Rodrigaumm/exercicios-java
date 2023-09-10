package lista1.ex04;

public class Aviao {

	String nome, cor, tipo;
	int lotacao;
	double combustivelLitros;
	
	public Aviao(String nome, String cor, String tipo, int lotacao, double combustivelLitros) {
		this.nome = nome;
		this.cor = cor;
		this.tipo = tipo;
		this.lotacao = lotacao;
		this.combustivelLitros = combustivelLitros;
	}

	public void decolar() {
		System.out.println(nome + " decolando: \"Vruuuuum!\"");
		combustivelLitros -= 0.5;
	}
}
