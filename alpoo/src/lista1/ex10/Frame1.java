package lista1.ex10;

import java.awt.*;
import java.awt.event.*;

public class Frame1 extends Frame {

	public Frame1() {
		setTitle("Primeira tela");
		setResizable(true);
		setSize(1366, 768);
		setLocation(500, 0);
		setBackground(Color.blue);
		addWindowListener(new Ouvidoria());
	}

	public static void main(String[] args) {
		new Frame1().setVisible(true);

	}

	class Ouvidoria implements WindowListener {
		public void windowOpened(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowActivated(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}
	}
}
