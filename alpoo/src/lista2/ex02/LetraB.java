package lista2.ex02;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LetraB extends Frame {

	public LetraB() {
		setSize(450, 260);
		setLocationRelativeTo(null);
		setTitle("FlowLayout");
		setBackground(new Color(0xcccccc));
		setLayout(new FlowLayout(2, 16, 16));

		Label l1 = new Label("FlowLayout na direita, 16px de espacamento");
		Label l2 = new Label("AAAAAAAA Aaa AAA aa a AAAA.");
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");

		add(l1);
		add(b1);
		add(l2);
		add(b2);
		add(b3);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String arg[]) {
		new LetraB().setVisible(true);
	}

}
