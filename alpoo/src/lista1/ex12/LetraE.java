package lista1.ex12;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LetraE extends Frame {

	private Panel painelConteudo;

	public static void main(String[] args) {
		LetraE frame = new LetraE();
		frame.setVisible(true);
	}

	public LetraE() {
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

		Label titulo = new Label("Despesas Mensais");
		titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		titulo.setBounds(142, 20, 175, 22);
		painelConteudo.add(titulo);

		Label campoLabel1 = new Label("Ganhos:");
		campoLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel1.setBounds(131, 63, 101, 22);
		painelConteudo.add(campoLabel1);

		TextField campo1 = new TextField();
		campo1.setFont(new Font("Arial", Font.PLAIN, 14));
		campo1.setText("0.00");
		campo1.setBounds(133, 87, 194, 22);
		painelConteudo.add(campo1);

		Label campoLabel2 = new Label("Gastos");
		campoLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
		campoLabel2.setBounds(131, 113, 101, 22);
		painelConteudo.add(campoLabel2);

		TextField campo2 = new TextField();
		campo2.setText("0.00");
		campo2.setFont(new Font("Arial", Font.PLAIN, 14));
		campo2.setBounds(133, 137, 194, 22);
		painelConteudo.add(campo2);

		Label labelTotal = new Label("");
		labelTotal.setAlignment(Label.CENTER);
		labelTotal.setFont(new Font("Arial", Font.PLAIN, 16));
		labelTotal.setBounds(131, 250, 196, 22);
		painelConteudo.add(labelTotal);

		Button button = new Button("Calcular");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFocusable(false);
		button.setBackground(new Color(47, 79, 79));
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBounds(131, 175, 196, 34);
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Double gastos = Double.parseDouble(campo2.getText());
					Double ganhos = Double.parseDouble(campo1.getText());

					if (ganhos == 0.) {
						throw new Exception();
					}

					Double percento = gastos / ganhos;
					labelTotal.setText(String.format("Gastou %.2f%% dos ganhos.", percento * 100));
				} catch (Exception ex) {
					labelTotal.setText("");
				}
			}
		});
		painelConteudo.add(button);
	}
}
