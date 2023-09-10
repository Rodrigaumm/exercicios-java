package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleInformationDialog extends JFrame {

	public DecoratedStyleInformationDialog() {
		super("Decorated Style: Information Dialog");
		setSize(300, 200);
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleInformationDialog();
	}

}
