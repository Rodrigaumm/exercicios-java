package lista1.ex05;

public class Flor {
	String especie, cor;

	public Flor(String especie, String cor) {
		this.especie = especie;
		this.cor = cor;
	}
	
	public void identificar() {
		System.out.println(especie + " - " + cor);
	}
}
