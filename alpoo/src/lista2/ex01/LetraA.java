package lista2.ex01;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LetraA extends Frame {
	public Label L1 ;
	public Button B1, B2, B3;
	public TextField Tx ;
	public Dimension dim;

	public LetraA()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();	
		setSize(dim);
		setLocation(0,0);
		setTitle("A interface \"ActionListener\"");
		setBackground(new Color(170,170,170));
		setLayout(null);	
						
		L1 = new Label("Aperte o botão :");
		L1.setLocation(50,50);
		L1.setBackground(new Color(170,170,170));
		L1.setSize(150,20);
			
		B1 = new Button("Sair");
		B1.setSize(60,20);
		B1.setLocation(50,150);
		B1.setBackground(new Color(170,170,170));
		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		B2 = new Button ("Azul");
		B2.setSize(60,20);
		B2.setLocation(200,150);
		B2.setBackground(new Color(170,170,170));
		B2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.blue) ;
				L1.setForeground(Color.white);
				L1.setBackground(Color.blue);
			}
		});
		
		B3 = new Button("Voltar");
		B3.setSize(60,20);
		B3.setLocation(200,200);
		B3.setBackground(new Color(170,170,170));
		B3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(new Color(170,170,170)) ;
				L1.setForeground(null);
				L1.setBackground(new Color(170,170,170));
			}
		});
		
		add(L1);
		add(B1);
		add(B2);
		add(B3);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

	public static void main(String arg[])
	{
		new LetraA().setVisible(true);
	}

}
