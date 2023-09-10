package lista1.ex04;

public class PortaAvioes {
	
	public static void main(String[] args) {
		Aviao cargaSolida = new Aviao("Carga soida", "amarelo", "carga solida", 50, 1200);
		Aviao abastecedor = new Aviao("Abastecimento Combustivel", "azul", "abastecimento de combustivel", 15, 5000);
		Aviao heli = new Aviao("Helicropito", "vermelho", "helicoptero", 12, 400);
		Aviao caca = new Aviao("Caca", "branco", "caca", 1, 900);
		Aviao recon = new Aviao("Recon", "cinza", "reconhecimento", 5, 3000);
		
		caca.decolar();
		recon.decolar();
		abastecedor.decolar();
	}
}
