package lista2.ex03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame {

	public Ex03() {
		setSize(450, 260);
		setLocationRelativeTo(null);
		setTitle("BorderLayout");
		setBackground(new Color(0xcccccc));
		setLayout(new BorderLayout(16, 16));
		setBackground(new Color(0xcccccc));
		
		Panel asfalto = new Panel();
		asfalto.setPreferredSize(new Dimension(50, 50));
		
		Panel containerBlocosABC = new Panel();
		Panel blocosABC = new Panel();
		blocosABC.setBackground(Color.black);		
		Label labelABC = new Label("Blocos A, B, C");
		labelABC.setForeground(Color.white);
		
		blocosABC.add(labelABC);
		blocosABC.setPreferredSize(new Dimension(150, 50));
		containerBlocosABC.setLayout(new BorderLayout(0, 0));
		containerBlocosABC.add(blocosABC, BorderLayout.NORTH);
		
		Panel containerBlocosDE1 = new Panel();
		Panel blocosDE = new Panel();
		blocosDE.setBackground(Color.yellow);
		Label labelDE = new Label ("Blocos D, E");
		labelDE.setForeground(Color.black);
		
		blocosDE.add(labelDE);
		containerBlocosDE1.setLayout(new BorderLayout(0, 0));
		containerBlocosDE1.add(blocosDE, BorderLayout.SOUTH);

		add(containerBlocosABC, BorderLayout.EAST);
		add(asfalto, BorderLayout.CENTER);
		add(containerBlocosDE1, BorderLayout.WEST);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String arg[]) {
		new Ex03().setVisible(true);
	}

}
