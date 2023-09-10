package lista1.ex12;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LetraD extends Frame {

	private Panel painelConteudo;

	public static void main(String[] args) {
		LetraF frame = new LetraF();
		frame.setVisible(true);
	}

	public LetraD() {
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
		setBounds(100, 100, 476, 351);
		painelConteudo = new Panel();

		add(painelConteudo);
		painelConteudo.setLayout(null);

		Label titulo = new Label("Carro");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(202, 20, 55, 22);
		painelConteudo.add(titulo);

		Label campoLabel1 = new Label("Marca");
		campoLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel1.setBounds(131, 63, 101, 22);
		painelConteudo.add(campoLabel1);

		TextField campo1 = new TextField();
		campo1.setFont(new Font("Arial", Font.PLAIN, 14));
		campo1.setText("Fiat");
		campo1.setBounds(133, 87, 194, 22);
		painelConteudo.add(campo1);

		Label campoLabel2 = new Label("Modelo");
		campoLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel2.setBounds(131, 113, 101, 22);
		painelConteudo.add(campoLabel2);

		TextField campo2 = new TextField();
		campo2.setText("Uno Mille Way Economy");
		campo2.setFont(new Font("Arial", Font.PLAIN, 14));
		campo2.setBounds(133, 137, 194, 22);
		painelConteudo.add(campo2);

		Label campoLabel3 = new Label("Ano");
		campoLabel3.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel3.setBounds(131, 165, 101, 22);
		painelConteudo.add(campoLabel3);

		TextField campo3 = new TextField();
		campo3.setText("2010");
		campo3.setFont(new Font("Arial", Font.PLAIN, 14));
		campo3.setBounds(133, 189, 72, 22);
		painelConteudo.add(campo3);

		Label campoLabel4 = new Label("Cor");
		campoLabel4.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel4.setBounds(131, 217, 101, 22);
		painelConteudo.add(campoLabel4);

		TextField campo4 = new TextField();
		campo4.setText("Prata");
		campo4.setFont(new Font("Arial", Font.PLAIN, 14));
		campo4.setBounds(133, 241, 72, 22);
		painelConteudo.add(campo4);
	}
}
