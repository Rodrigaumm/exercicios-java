package lista1.ex08;

public class ResidenciaUrbana {
	String tipo;
	int quartos;
	boolean emConstrucao;
	
	public ResidenciaUrbana(String tipo, int quartos) {
		this.tipo = tipo;
		this.quartos = quartos;
	}
	
	public void colocarEmConstrucao() {
		System.out.println(tipo + " " + quartos + " quartos" + " em construcao...");
		emConstrucao = true;
	}
}
