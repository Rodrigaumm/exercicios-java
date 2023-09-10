package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleWarningDialog extends JFrame {

	public DecoratedStyleWarningDialog() {
		super("Decorated Style: Warning Dialog");
		setSize(400, 200);
		getContentPane().setBackground(new Color(230, 200, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleWarningDialog();
	}

}
