package lista1.ex06;

public class Casa {
	String endereco, tipo;
	int quartos;
	
	public Casa(String endereco, String tipo, int quartos) {
		this.endereco = endereco;
		this.tipo = tipo;
		this.quartos = quartos;
	}

	public void identificar() {
		System.out.println(endereco + ", " + tipo + ", " + quartos + " quartos.");
	}
}
