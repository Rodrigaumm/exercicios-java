package lista4.ex06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversaoCelsiusFahrenheit extends JFrame {
	private JTextField campoCelsius;
	private JTextField campoFahrenheit;
	private int lastFocus = 0;
	
	public ConversaoCelsiusFahrenheit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 302));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Conversão Celsius-Fahrenheit");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(114, 11, 205, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblCelsius = new JLabel("Celsius:");
		lblCelsius.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCelsius.setBounds(133, 59, 37, 14);
		getContentPane().add(lblCelsius);
		
		campoCelsius = new JTextField();
		campoCelsius.setBounds(215, 52, 87, 29);
		campoCelsius.setColumns(10);
		campoCelsius.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				lastFocus = 0;
			}
		});
		getContentPane().add(campoCelsius);
		
		JLabel lblFahrenheit = new JLabel("Fahrenheit:");
		lblFahrenheit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFahrenheit.setBounds(133, 118, 56, 14);
		getContentPane().add(lblFahrenheit);
		
		campoFahrenheit = new JTextField();
		campoFahrenheit.setColumns(10);
		campoFahrenheit.setBounds(215, 111, 87, 29);
		campoFahrenheit.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				lastFocus = 1;
			}
		});
		getContentPane().add(campoFahrenheit);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(219, 186, 104, 23);
		getContentPane().add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double celsius, fahrenheit = -1337.;
				if (lastFocus == 0) {
					try {
						celsius = Double.valueOf(campoCelsius.getText().replace(",", "."));
					} catch (NumberFormatException err) {
						campoCelsius.setText("");
						return;
					}
					
					campoFahrenheit.setText(String.format("%.2f", (9/5. * celsius) + 32));
				} else if (lastFocus == 1){
					try {
						fahrenheit = Double.valueOf(campoFahrenheit.getText().replace(",", "."));
					} catch (NumberFormatException err) {
						campoFahrenheit.setText("");
						return;
					}
					
					campoCelsius.setText(String.format("%.2f", 5/9. * (fahrenheit - 32)));
				}
			}
		});
		btnCalcular.setFocusable(false);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(103, 186, 87, 23);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoCelsius.setText("");
				campoFahrenheit.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ConversaoCelsiusFahrenheit();
	}
}
