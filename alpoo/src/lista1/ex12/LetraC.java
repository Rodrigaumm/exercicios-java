package lista1.ex12;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LetraC extends Frame {

	private Panel painelConteudo;

	public static void main(String[] args) {
		LetraC frame = new LetraC();
		frame.setVisible(true);
	}

	public LetraC() {
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setBounds(100, 100, 476, 322);
		painelConteudo = new Panel();

		add(painelConteudo);
		painelConteudo.setLayout(null);

		Label titulo = new Label("Pai, Mãe, Filhos");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(148, 20, 163, 22);
		painelConteudo.add(titulo);

		Label campoLabel1 = new Label("Nome do Pai:");
		campoLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel1.setBounds(131, 63, 101, 22);
		painelConteudo.add(campoLabel1);

		TextField campo1 = new TextField();
		campo1.setFont(new Font("Arial", Font.PLAIN, 14));
		campo1.setText("Robert O'Neill");
		campo1.setBounds(133, 87, 194, 22);
		painelConteudo.add(campo1);

		Label campoLabel2 = new Label("Nome da Mãe:");
		campoLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel2.setBounds(131, 122, 101, 22);
		painelConteudo.add(campoLabel2);

		TextField campo2 = new TextField();
		campo2.setText("Jessica Halpin");
		campo2.setFont(new Font("Arial", Font.PLAIN, 14));
		campo2.setBounds(133, 146, 194, 22);
		painelConteudo.add(campo2);

		Label campoLabel3 = new Label("Filhos:");
		campoLabel3.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel3.setBounds(131, 187, 101, 22);
		painelConteudo.add(campoLabel3);

		TextField campo3_1 = new TextField();
		campo3_1.setText("Tom O'Neill");
		campo3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		campo3_1.setBounds(133, 211, 194, 22);
		painelConteudo.add(campo3_1);

		TextField campo3_2 = new TextField();
		campo3_2.setText("Diane Johnson");
		campo3_2.setFont(new Font("Arial", Font.PLAIN, 14));
		campo3_2.setBounds(133, 239, 194, 22);
		painelConteudo.add(campo3_2);
	}
}
