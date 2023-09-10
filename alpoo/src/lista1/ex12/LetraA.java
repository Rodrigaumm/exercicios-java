package lista1.ex12;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LetraA extends Frame {

	private Panel painelConteudo;

	public static void main(String[] args) {
		LetraA frame = new LetraA();
		frame.setVisible(true);
	}

	public LetraA() {
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
		setBounds(100, 100, 450, 300);
		painelConteudo = new Panel();

		add(painelConteudo);
		painelConteudo.setLayout(null);

		Label titulo = new Label("Dados Cadastrais");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(138, 20, 163, 22);
		painelConteudo.add(titulo);

		Label campoLabel1 = new Label("Nome:");
		campoLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel1.setBounds(85, 64, 53, 22);
		painelConteudo.add(campoLabel1);

		TextField campo1 = new TextField();
		campo1.setFont(new Font("Arial", Font.PLAIN, 14));
		campo1.setText("Abraham Lincoln");
		campo1.setBounds(138, 64, 194, 22);
		painelConteudo.add(campo1);

		Label campoLabel2 = new Label("Idade:");
		campoLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel2.setBounds(86, 92, 53, 22);
		painelConteudo.add(campoLabel2);

		TextField campo2 = new TextField();
		campo2.setText("56");
		campo2.setFont(new Font("Arial", Font.PLAIN, 14));
		campo2.setBounds(139, 92, 40, 22);
		painelConteudo.add(campo2);

		Label campoLabel3 = new Label("CPF:");
		campoLabel3.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel3.setBounds(85, 120, 53, 22);
		painelConteudo.add(campoLabel3);

		TextField campo3 = new TextField();
		campo3.setText("123.123.123-01");
		campo3.setFont(new Font("Arial", Font.PLAIN, 14));
		campo3.setBounds(138, 120, 117, 22);
		painelConteudo.add(campo3);

		Label campoLabel4 = new Label("Curso:");
		campoLabel4.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel4.setBounds(85, 148, 53, 22);
		painelConteudo.add(campoLabel4);

		TextField campo4 = new TextField();
		campo4.setText("Ciência da Computação");
		campo4.setFont(new Font("Arial", Font.PLAIN, 14));
		campo4.setBounds(138, 148, 242, 22);
		painelConteudo.add(campo4);
	}
}
