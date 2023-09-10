package lista1.ex07;

public class Curso {
	String nome, area, horario;
	int vagas, periodos;
	boolean posGrad;
	
	public Curso(String nome, String area, String horario, int vagas, int periodos) {
		this.nome = nome;
		this.area = area;
		this.horario = horario;
		this.vagas = vagas;
		this.periodos = periodos;
	}

	public void liberarPosGrad() {
		System.out.println("Liberada pos-graduacao para " + nome + " - " + horario);
		posGrad = true;
	}
}
