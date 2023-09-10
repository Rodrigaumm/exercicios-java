package lista1.ex10;

import java.awt.*;
import java.awt.event.*;

public class Frame2 extends Frame {

	public Frame2() {
		setTitle("Segunda tela");
		setResizable(true);
		setSize(640, 480);
		setLocation(0, 0);
		setBackground(Color.blue);
		addWindowListener(new Ouvidoria());
	}

	public static void main(String[] args) {
		new Frame2().setVisible(true);

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
