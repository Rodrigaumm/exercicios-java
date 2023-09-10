package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleFrame extends JFrame {

	public DecoratedStyleFrame() {
		super("Decorated Style: Frame");
		setSize(400, 200);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleFrame();
	}

}
