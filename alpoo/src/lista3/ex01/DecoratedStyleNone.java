package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleNone extends JFrame {

	public DecoratedStyleNone() {
		super("Decorated Style: None");
		setSize(350, 200);
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleNone();
	}

}
