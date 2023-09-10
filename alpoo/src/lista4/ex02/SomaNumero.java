package lista4.ex02;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SomaNumero extends JFrame {
	private JTextField campoNum1;
	private JTextField campoNum2;
	private JTextField campoResultado;
	public SomaNumero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Soma número");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(168, 11, 97, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblNum1 = new JLabel("Num 1");
		lblNum1.setBounds(136, 55, 46, 14);
		getContentPane().add(lblNum1);
		
		campoNum1 = new JTextField();
		campoNum1.setBounds(223, 52, 86, 20);
		getContentPane().add(campoNum1);
		campoNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Num 2");
		lblNum2.setBounds(136, 90, 46, 14);
		getContentPane().add(lblNum2);
		
		campoNum2 = new JTextField();
		campoNum2.setColumns(10);
		campoNum2.setBounds(223, 87, 86, 20);
		getContentPane().add(campoNum2);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer num1, num2, resultado = -1337;
				try {
					num1 = Integer.valueOf(campoNum1.getText());
				} catch (NumberFormatException err) {
					campoNum1.setText("");
					return;
				}
				
				try {
					num2 = Integer.valueOf(campoNum2.getText());
				} catch (NumberFormatException err) {
					campoNum2.setText("");
					return;
				}
				
				try {
					resultado = num1 + num2;
				} catch (Exception err) {
					campoResultado.setText("");
				}
				
				campoResultado.setText(String.valueOf(resultado));
			}
		});
		btnCalcular.setFocusable(false);
		btnCalcular.setBounds(228, 131, 97, 23);
		getContentPane().add(btnCalcular);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNum1.setText("");
				campoNum2.setText("");
				campoResultado.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		btnLimpar.setBounds(121, 131, 97, 23);
		getContentPane().add(btnLimpar);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(136, 199, 74, 14);
		getContentPane().add(lblResultado);
		
		campoResultado = new JTextField();
		campoResultado.setEditable(false);
		campoResultado.setBounds(223, 196, 86, 20);
		getContentPane().add(campoResultado);
		campoResultado.setColumns(10);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SomaNumero();
	}
}
