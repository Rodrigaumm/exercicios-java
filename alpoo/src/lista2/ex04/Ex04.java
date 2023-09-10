package lista2.ex04;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex04 extends Frame {
	public Ex04() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("A classe GridLayout");
		setBackground(Color.black);
		setLayout(new GridLayout(0, 6, 3, 3));

		for (Character letra = 'A'; letra <= 'Z'; letra++) {
			add(new Button(letra.toString()));
		}

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Ex04().setVisible(true);
	}

}
