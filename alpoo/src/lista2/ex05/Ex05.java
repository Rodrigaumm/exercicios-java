package lista2.ex05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex05 extends Frame {
	public Panel Max, P1, P2, P3, P4, P5, P6, Pbot;
	public Button B1, B2, B3, B4, B5, B6;
	public Label L1, L2, L3, L4, L5, L6;

	public Ex05() {
		setTitle("O Gerenciador CardLayout");
		setSize(300, 200);
		setLocation(250, 200);
		setBackground(Color.black);
		setLayout(new BorderLayout());

		B1 = new Button("verde");
		B2 = new Button("laranja");
		B3 = new Button("amarelo");
		B4 = new Button("dark-gray");
		B5 = new Button("magenta");
		B6 = new Button("ciano");

		L1 = new Label("A cor é verde");
		L2 = new Label("A cor é laranja");
		L3 = new Label("A cor é amarelo");
		L4 = new Label("A cor é dark-gray");
		L5 = new Label("A cor é magenta");
		L6 = new Label("A cor é ciano");

		Max = new Panel();
		Max.setSize(200, 200);
		Max.setLayout(new CardLayout());

		Pbot = new Panel();
		Pbot.setSize(100, 200);
		Pbot.setLayout(new GridLayout(3, 1));
		Pbot.add(B1);
		Pbot.add(B2);
		Pbot.add(B3);
		Pbot.add(B4);
		Pbot.add(B5);
		Pbot.add(B6);

		P1 = new Panel();
		P1.setBackground(Color.green);
		P1.setLayout(new FlowLayout());
		P1.add(L1);

		P2 = new Panel();
		P2.setBackground(Color.orange);
		P2.setLayout(new FlowLayout());
		P2.add(L2);

		P3 = new Panel();
		P3.setBackground(Color.yellow);
		P3.setLayout(new FlowLayout());
		P3.add(L3);

		P4 = new Panel();
		P4.setBackground(Color.darkGray);
		P4.setLayout(new FlowLayout());
		L4.setForeground(Color.white);
		P4.add(L4);

		P5 = new Panel();
		P5.setBackground(Color.magenta);
		P5.setLayout(new FlowLayout());
		L5.setForeground(Color.white);
		P5.add(L5);

		P6 = new Panel();
		P6.setBackground(Color.cyan);
		P6.setLayout(new FlowLayout());
		P6.add(L6);

		Max.add(P1, "P1");
		Max.add(P2, "P2");
		Max.add(P3, "P3");
		Max.add(P4, "P4");
		Max.add(P5, "P5");
		Max.add(P6, "P6");

		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) Max.getLayout()).show(Max, "P1");
			}
		});
		B2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) Max.getLayout()).show(Max, "P2");
			}
		});
		B3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) Max.getLayout()).show(Max, "P3");
			}
		});
		B4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) Max.getLayout()).show(Max, "P4");
			}
		});
		B5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) Max.getLayout()).show(Max, "P5");
			}
		});
		B6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) Max.getLayout()).show(Max, "P6");
			}
		});

		add(Max, BorderLayout.CENTER);
		add(Pbot, BorderLayout.WEST);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String arg[]) {
		Ex05 f = new Ex05();
		f.show();
	}

}
