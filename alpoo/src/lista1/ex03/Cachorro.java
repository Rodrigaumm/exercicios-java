package lista1.ex03;

public class Cachorro {
	String raca, cor, nome;
	double tamanhoCm;
	
	public void latir() {
		System.out.println(nome + " diz: \"Au! Au! Au!\"");
	}
	
	public void informaDados() {
		System.out.println("Raça=" + raca + ", Cor=" + cor + ", Nome=" + nome + ", Tamanho em cm=" + tamanhoCm);;
	}
}
