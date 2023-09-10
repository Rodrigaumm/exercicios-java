package lista3.ex02;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Borda1 extends JFrame {

	public Borda1() {
		super();
		setLocationRelativeTo(null);
		setSize(400, 300);

		Border blacklineBorder = BorderFactory.createLineBorder(Color.GRAY, 5);
		getRootPane().setBorder(BorderFactory.createTitledBorder(blacklineBorder, "Titulo"));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new Borda1();
	}
}
