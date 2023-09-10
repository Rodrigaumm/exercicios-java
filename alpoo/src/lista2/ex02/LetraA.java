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

public class LetraA extends Frame {

	public LetraA() {
		setSize(450, 260);
		setLocationRelativeTo(null);
		setTitle("FlowLayout");
		setBackground(new Color(0xcccccc));
		setLayout(new FlowLayout(1, 16, 16));

		Label l1 = new Label("FlowLayout no meio, 16px de espacamento");

		TextField tf1 = new TextField(" ");
		tf1.setColumns(50);

		Button b1 = new Button("Sair");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		Button b2 = new Button("Limpar");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
			}
		});

		Button b3 = new Button("Default");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf1.setText("Default");
			}
		});

		add(l1);
		add(tf1);
		add(b1);
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
		new LetraA().setVisible(true);
	}

}
