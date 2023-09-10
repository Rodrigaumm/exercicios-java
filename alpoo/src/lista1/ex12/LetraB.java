package lista1.ex12;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LetraB extends Frame {

	private Panel painelConteudo;

	public static void main(String[] args) {
		LetraB frame = new LetraB();
		frame.setVisible(true);
	}

	public LetraB() {
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

		Label titulo = new Label("Login");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(190, 25, 53, 22);
		painelConteudo.add(titulo);

		Label campoLabel1 = new Label("Usuario:");
		campoLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
		campoLabel1.setBounds(118, 70, 77, 22);
		painelConteudo.add(campoLabel1);

		TextField campo1 = new TextField();
		campo1.setFont(new Font("Arial", Font.PLAIN, 12));
		campo1.setBounds(120, 92, 194, 22);
		painelConteudo.add(campo1);

		Label campoLabel2 = new Label("Senha:");
		campoLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
		campoLabel2.setBounds(118, 126, 77, 22);
		painelConteudo.add(campoLabel2);

		TextField campo2 = new TextField();
		campo2.setFont(new Font("Arial", Font.PLAIN, 12));
		campo2.setBounds(120, 148, 194, 22);
		painelConteudo.add(campo2);

		Button button = new Button("ENTRAR");
		button.setFocusable(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 0));
		button.setFont(new Font("Arial", Font.PLAIN, 16));
		button.setBounds(119, 195, 195, 38);
		painelConteudo.add(button);
	}
}
