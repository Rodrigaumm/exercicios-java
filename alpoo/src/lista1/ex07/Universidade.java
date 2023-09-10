package lista1.ex07;

public class Universidade {

	public static void main(String[] args) {
		Curso ccm = new Curso("Ciencia da Computacao", "exatas", "matutino", 100, 10);
		Curso ccn = new Curso("Ciencia da Computacao", "exatas", "noturno", 200, 10);
		
		ccm.liberarPosGrad();
		ccn.liberarPosGrad();
	}
}
