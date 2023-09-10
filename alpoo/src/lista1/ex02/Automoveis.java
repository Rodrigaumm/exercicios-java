package lista1.ex02;

public class Automoveis {

	// Atributos
	String modelo, cor, tipo, categoria;
	int ano, passageiros, portas, lotacao;
	double capacidadeCargaTon;
	boolean estadoMotor = false;

	public void ligaMotor() // Método
	{
		estadoMotor = true;
	}
	
	public void desligaMotor() {
		estadoMotor = false;
	}
	
	public void informaDados() // Método
	{
		String motorString;
		if (estadoMotor) {
			motorString = " ligado";
		} else {
			motorString = " desligado";
		}
		System.out.println("Automovel: " + modelo + " " + ano + " " + cor + tipo + motorString);
		estadoMotor = false;
	}

}
