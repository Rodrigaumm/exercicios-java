package lista1.ex09;

public class Pessoa {
	String nome, sexo;
	int idade;
	double altura;
	
	public Pessoa(String nome, String sexo, int idade, double altura) {
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.altura = altura;
	}

	public void dizerOi() {
		System.out.println(nome + " diz: \"Oi!\"");
	}
}
