package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleErrorDialog extends JFrame {

	public DecoratedStyleErrorDialog() {
		super("Decorated Style: Error Dialog");
		setSize(400, 200);
		getContentPane().setBackground(new Color(200, 100, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleErrorDialog();
	}

}
