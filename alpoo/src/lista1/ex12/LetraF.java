package lista1.ex12;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LetraF extends Frame {

	private Panel painelConteudo;

	public static void main(String[] args) {
		LetraF frame = new LetraF();
		frame.setVisible(true);
	}

	public LetraF() {
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

		Label titulo = new Label("Estágio");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(194, 20, 71, 22);
		painelConteudo.add(titulo);

		Label frontendLabel = new Label("• Frontend");
		frontendLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		frontendLabel.setBounds(154, 75, 79, 22);
		painelConteudo.add(frontendLabel);

		Label habilidade1 = new Label("• HTML, CSS, JS");
		habilidade1.setFont(new Font("Arial", Font.PLAIN, 14));
		habilidade1.setBounds(198, 103, 117, 22);
		painelConteudo.add(habilidade1);

		Label habilidade2 = new Label("• React");
		habilidade2.setFont(new Font("Arial", Font.PLAIN, 14));
		habilidade2.setBounds(198, 131, 60, 22);
		painelConteudo.add(habilidade2);

		Label backendLabel = new Label("• Backend");
		backendLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		backendLabel.setBounds(154, 159, 79, 22);
		painelConteudo.add(backendLabel);

		Label habilidade3 = new Label("• Java 8+");
		habilidade3.setFont(new Font("Arial", Font.PLAIN, 14));
		habilidade3.setBounds(198, 187, 71, 22);
		painelConteudo.add(habilidade3);

		Label habilidade4 = new Label("• Spring Boot");
		habilidade4.setFont(new Font("Arial", Font.PLAIN, 14));
		habilidade4.setBounds(198, 215, 95, 22);
		painelConteudo.add(habilidade4);
	}
}
