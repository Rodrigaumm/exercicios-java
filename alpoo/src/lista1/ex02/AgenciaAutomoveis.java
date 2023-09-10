package lista1.ex02;

public class AgenciaAutomoveis {

	public static void main(String[] args) {
		Automoveis fusca = new Automoveis();
		Automoveis gol = new Automoveis();
		Automoveis monza = new Automoveis();
		Automoveis montana = new Automoveis();

		fusca.modelo = " Fusca ";
		fusca.cor = " Preto ";
		fusca.ano = 1977;
		fusca.tipo = " Luxo ";
		fusca.categoria = "Passeio";
		fusca.capacidadeCargaTon = 0.2;
		fusca.portas = 2;
		fusca.lotacao = 5;

		gol.modelo = " Gol ";
		gol.cor = " Prata ";
		gol.ano = 2001;
		gol.tipo = " Simples ";
		gol.categoria = "Passeio";
		gol.capacidadeCargaTon = 0.3;
		gol.portas = 4;
		gol.lotacao = 5;

		monza.modelo = " Monza ";
		monza.cor = " Vermelho ";
		monza.ano = 1994;
		monza.tipo = " Simples ";
		monza.categoria = "Passeio";
		monza.capacidadeCargaTon = 0.5;
		monza.portas = 4;
		monza.lotacao = 5;

		montana.modelo = " Montana ";
		montana.cor = " Azul ";
		montana.ano = 2004;
		montana.tipo = " Luxo ";
		montana.categoria = "Passeio";
		montana.capacidadeCargaTon = 0.2;
		montana.portas = 2;
		montana.lotacao = 2;

		fusca.ligaMotor();
		gol.ligaMotor();
		monza.ligaMotor();
		montana.ligaMotor();

		fusca.informaDados();
		gol.informaDados();
		monza.informaDados();
		montana.informaDados();
		
		fusca.desligaMotor();
		monza.desligaMotor();

	}

}
