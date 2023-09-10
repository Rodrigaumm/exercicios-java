package lista1.ex05;

public class Floricultura {

	public static void main(String[] args) {
		Flor flor1 = new Flor("Dianthus caryophyllus", "rosa");
		Flor flor2 = new Flor("Helianthus annuus", "amarelo");
		Flor flor3 = new Flor("Leucanthemum vulgare", "branca");
		Flor flor4 = new Flor("Phalaenopsis alba", "rosa");
		Flor flor5 = new Flor("Phalaenopsis alba", "laranja");
		Flor flor6 = new Flor("Hibiscus rosa-sinensis", "rosa-claro");
		
		flor3.identificar();
		flor6.identificar();
		flor1.identificar();
	}
}
