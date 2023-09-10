package lista3.ex02;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Borda2 extends JFrame {

	public Borda2() {
		super();
		setLocationRelativeTo(null);
		setSize(400, 300);

		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.RED));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Borda2();
	}
}
