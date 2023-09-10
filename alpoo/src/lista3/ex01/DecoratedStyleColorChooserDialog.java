package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleColorChooserDialog extends JFrame {

	public DecoratedStyleColorChooserDialog() {
		super("Decorated Style: Color Chooser Dialog");
		setSize(400, 200);
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleColorChooserDialog();
	}

}
