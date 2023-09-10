package lista1.ex03;

public class Canil {

	public static void main(String[] args) {
		Cachorro cao1 = new Cachorro();
		cao1.raca = "Shih Tzu";
		cao1.nome = "Xbox360";
		cao1.tamanhoCm = 0.8;
		cao1.cor = "Verde e Cinza";
		
		Cachorro cao2 = new Cachorro();
		cao2.raca = "Chow Chow";
		cao2.nome = "Xbox One";
		cao2.tamanhoCm = 1.2;
		cao2.cor = "Preto";
		
		Cachorro cao3 = new Cachorro();
		cao3.raca = "Bulldog";
		cao3.nome = "Xbox Classico";
		cao3.tamanhoCm = 0.3;
		cao3.cor = "Preto e Verde";
		
		Cachorro cao4 = new Cachorro();
		cao4.raca = "Pinscher";
		cao4.nome = "Xbox Series S";
		cao4.tamanhoCm = 0.7;
		cao4.cor = "Branco e Preto";
		
		Cachorro cao5 = new Cachorro();
		cao5.raca = "Yorkshire";
		cao5.nome = "Xbox Series X";
		cao5.tamanhoCm = 2.0;
		cao5.cor = "Preto";
		
		cao1.latir();
		cao5.latir();
		cao3.latir();
	}

}
