package lista1.ex08;

public class Moradia {
	public static void main(String[] args) {
		ResidenciaUrbana ap1 = new ResidenciaUrbana("apartamento", 2);
		ResidenciaUrbana ap2 = new ResidenciaUrbana("apartamento", 3);
		ResidenciaUrbana c1 = new ResidenciaUrbana("casa", 2);
		ResidenciaUrbana c2 = new ResidenciaUrbana("casa", 3);
		ResidenciaUrbana c3 = new ResidenciaUrbana("casa", 4);
		
		ap2.colocarEmConstrucao();
		c3.colocarEmConstrucao();
	}
}
