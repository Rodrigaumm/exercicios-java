package lista3.ex05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LetraB extends JFrame {
	private final String STRING_FORMAT = "%.2f";
	
	public LetraB() {
		setSize(new Dimension(450, 540));
		getContentPane().setBackground(new Color(235, 235, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTriangulo = new JLabel("Triângulo");
		lblTriangulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTriangulo.setBounds(194, 17, 46, 14);
		getContentPane().add(lblTriangulo);
		
		JLabel lblTrianguloBase = new JLabel("Base:");
		lblTrianguloBase.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTrianguloBase.setBounds(132, 49, 32, 14);
		getContentPane().add(lblTrianguloBase);
		
		JTextField campoTrianguloBase = new JTextField();
		campoTrianguloBase.setBounds(174, 42, 86, 28);
		campoTrianguloBase.setColumns(10);
		getContentPane().add(campoTrianguloBase);
		
		JLabel lblTrianguloAltura = new JLabel("Altura:");
		lblTrianguloAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTrianguloAltura.setBounds(132, 88, 33, 14);
		getContentPane().add(lblTrianguloAltura);
		
		JTextField campoTrianguloAltura = new JTextField();
		campoTrianguloAltura.setColumns(10);
		campoTrianguloAltura.setBounds(174, 81, 86, 28);
		getContentPane().add(campoTrianguloAltura);
		
		JTextField campoTrianguloResultado = new JTextField();
		campoTrianguloResultado.setEditable(false);
		campoTrianguloResultado.setBounds(174, 120, 86, 20);
		campoTrianguloResultado.setColumns(10);
		getContentPane().add(campoTrianguloResultado);
		
		JButton btnTriangulo = new JButton("CALCULAR");
		btnTriangulo.setBounds(270, 119, 98, 23);
		btnTriangulo.setBackground(new Color(114, 149, 175));
		btnTriangulo.setForeground(Color.WHITE);
		btnTriangulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Double trianguloBase = 0.;
				Double trianguloAltura = 0.;
				try {
					trianguloBase = Double.parseDouble(campoTrianguloBase.getText());
				} catch (NumberFormatException err) {
					campoTrianguloBase.setText("");
				}
				
				try {
					trianguloAltura = Double.parseDouble(campoTrianguloAltura.getText());
				} catch (NumberFormatException err) {
					campoTrianguloAltura.setText("");
				}
				
				campoTrianguloResultado.setText(String.format(STRING_FORMAT, trianguloBase * trianguloAltura / 2));
			}
		});
		getContentPane().add(btnTriangulo);
		
		JLabel lblQuadrado = new JLabel("Quadrado");
		lblQuadrado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuadrado.setBounds(194, 170, 52, 14);
		getContentPane().add(lblQuadrado);
		
		JLabel lblQuadradoLado = new JLabel("Lado:");
		lblQuadradoLado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuadradoLado.setBounds(132, 202, 32, 14);
		getContentPane().add(lblQuadradoLado);
		
		JTextField campoQuadradoLado = new JTextField();
		campoQuadradoLado.setColumns(10);
		campoQuadradoLado.setBounds(174, 195, 86, 28);
		getContentPane().add(campoQuadradoLado);
		
		JTextField campoQuadradoResultado = new JTextField();
		campoQuadradoResultado.setEditable(false);
		campoQuadradoResultado.setColumns(10);
		campoQuadradoResultado.setBounds(174, 234, 86, 20);
		getContentPane().add(campoQuadradoResultado);
		
		JButton btnQuadrado = new JButton("CALCULAR");
		btnQuadrado.setBounds(270, 233, 98, 23);
		btnQuadrado.setBackground(new Color(114, 149, 175));
		btnQuadrado.setForeground(Color.WHITE);
		btnQuadrado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Double quadradoLado = 0.;
				try {
					quadradoLado = Double.parseDouble(campoQuadradoLado.getText());
				} catch (NumberFormatException err) {
					campoQuadradoLado.setText("");
				}
				
				campoQuadradoResultado.setText(String.format(STRING_FORMAT, quadradoLado * quadradoLado));
			}
		});
		getContentPane().add(btnQuadrado);
		
		JLabel lblRetangulo = new JLabel("Retângulo");
		lblRetangulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRetangulo.setBounds(194, 287, 52, 14);
		getContentPane().add(lblRetangulo);
		
		JLabel lblRetanguloBase = new JLabel("Base:");
		lblRetanguloBase.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRetanguloBase.setBounds(132, 319, 32, 14);
		getContentPane().add(lblRetanguloBase);
		
		JTextField campoRetanguloBase = new JTextField();
		campoRetanguloBase.setColumns(10);
		campoRetanguloBase.setBounds(174, 312, 86, 28);
		getContentPane().add(campoRetanguloBase);
		
		JLabel lblRetanguloAltura = new JLabel("Altura:");
		lblRetanguloAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRetanguloAltura.setBounds(132, 358, 33, 14);
		getContentPane().add(lblRetanguloAltura);
		
		JTextField campoRetanguloAltura = new JTextField();
		campoRetanguloAltura.setColumns(10);
		campoRetanguloAltura.setBounds(174, 351, 86, 28);
		getContentPane().add(campoRetanguloAltura);
		
		JTextField campoRetanguloResultado = new JTextField();
		campoRetanguloResultado.setEditable(false);
		campoRetanguloResultado.setColumns(10);
		campoRetanguloResultado.setBounds(174, 390, 86, 20);
		getContentPane().add(campoRetanguloResultado);
		
		JButton btnRetangulo = new JButton("CALCULAR");
		btnRetangulo.setBounds(270, 389, 98, 23);
		btnRetangulo.setBackground(new Color(114, 149, 175));
		btnRetangulo.setForeground(Color.WHITE);
		btnRetangulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Double retanguloBase = 0.;
				Double retanguloAltura = 0.;
				try {
					retanguloBase = Double.parseDouble(campoRetanguloBase.getText());
				} catch (NumberFormatException err) {
					campoRetanguloBase.setText("");
				}
				
				try {
					retanguloAltura = Double.parseDouble(campoRetanguloAltura.getText());
				} catch (NumberFormatException err) {
					campoRetanguloAltura.setText("");
				}
				
				campoRetanguloResultado.setText(String.format(STRING_FORMAT, retanguloBase * retanguloAltura));
			}
		});
		getContentPane().add(btnRetangulo);
		

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LetraB();
	}

}
