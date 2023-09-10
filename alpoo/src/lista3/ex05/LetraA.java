package lista3.ex05;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LetraA extends JFrame {
	final private Double PRECO_EURO = 6.74;
	final private String MOEDA_STRING_FORMAT = "%.2f";
	
	private JTextField campoEuros;
	private JTextField campoReais;
	private Integer lastFocus = 0;

	public LetraA() {
		setSize(600, 400);
		setFont(new Font("Lucida Console", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(235, 235, 235));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Euro");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		lblTitulo.setBounds(262, 11, 59, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblEuro = new JLabel("Euros:");
		lblEuro.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblEuro.setBounds(232, 61, 48, 14);
		getContentPane().add(lblEuro);
		
		campoEuros = new JTextField();
		campoEuros.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		campoEuros.setBounds(232, 84, 119, 29);
		campoEuros.setColumns(10);
		campoEuros.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				lastFocus = 0;
			}
		});
		getContentPane().add(campoEuros);
		
		JLabel lblReais = new JLabel("Reais:");
		lblReais.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblReais.setBounds(232, 134, 48, 14);
		getContentPane().add(lblReais);
		
		campoReais = new JTextField();
		campoReais.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		campoReais.setColumns(10);
		campoReais.setBounds(232, 159, 119, 29);
		campoReais.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				lastFocus = 1;
			}
		});
		getContentPane().add(campoReais);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setFocusable(false);
		btnCalcular.setBounds(232, 247, 119, 36);
		getContentPane().add(btnCalcular);
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setBackground(new Color(114, 149, 175));
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (lastFocus == 0) {
						String euroInput = campoEuros.getText().replace(",", ".");
						String result = String.format(MOEDA_STRING_FORMAT, Double.parseDouble(euroInput) * PRECO_EURO);
						campoReais.setText(result);
					} else if (lastFocus == 1) {
						String realInput = campoReais.getText().replace(",", ".");
						String result = String.format(MOEDA_STRING_FORMAT, Double.parseDouble(realInput) / PRECO_EURO);
						campoEuros.setText(result);
					}
				} catch (NumberFormatException err) {
					if (lastFocus == 0) {
						campoEuros.setText("");
					} else if (lastFocus == 1) {
						campoReais.setText("");
					}
				}
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LetraA();
	}
}
