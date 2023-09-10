package lista1.ex06;

public class Moradia {

	public static void main(String[] args) {
		Casa c1 = new Casa("Rua Smdwd, Goiânia", "Sobrado", 5);
		Casa c2 = new Casa("Rua ASDqw, Goiânia", "Palafita", 78);
		Casa c3 = new Casa("Rua ASDq, Goiânia", "Oca", 15);
		Casa c4 = new Casa("Rua asdwq, Goiânia", "Barracão", 25);
		Casa c5 = new Casa("Rua Sdq2, Goiânia", "Quitinete", 2);
		Casa c6 = new Casa("Rua aSDaxc, Goiânia", "Apartamento", 4);
		
		c3.identificar();
		c4.identificar();
		c6.identificar();
	}
}
