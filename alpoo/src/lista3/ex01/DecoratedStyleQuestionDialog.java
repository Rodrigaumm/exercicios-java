package lista3.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class DecoratedStyleQuestionDialog extends JFrame {

	public DecoratedStyleQuestionDialog() {
		super("Decorated Style: Question Dialog");
		setSize(400, 200);
		getContentPane().setBackground(Color.MAGENTA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);

		setVisible(true);
	}

	public static void main(String[] args) {
		new DecoratedStyleQuestionDialog();
	}

}
