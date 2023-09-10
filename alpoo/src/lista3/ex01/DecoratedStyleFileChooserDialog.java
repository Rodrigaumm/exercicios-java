package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleFileChooserDialog extends JFrame {

	public DecoratedStyleFileChooserDialog() {
		super("Decorated Style: File Chooser Dialog");
		setSize(400, 200);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleFileChooserDialog();
	}

}
