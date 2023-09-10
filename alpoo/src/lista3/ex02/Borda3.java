package lista3.ex02;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Borda3 extends JFrame {

	public Borda3() {
		super();
		setLocationRelativeTo(null);
		setSize(400, 300);

		getRootPane().setBorder(BorderFactory.createLoweredBevelBorder());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Borda3();
	}
}
