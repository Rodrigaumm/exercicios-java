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
import javax.swing.JPanel;

public class SomaNumeroModificado extends JFrame {
	private JTextField campoNum1;
	private JTextField campoNum2;
	private JTextField campoResultado;
	public SomaNumeroModificado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 300));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Soma número");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(168, 11, 97, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblNum1 = new JLabel("Num 1");
		lblNum1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum1.setBounds(152, 55, 46, 14);
		getContentPane().add(lblNum1);
		
		campoNum1 = new JTextField();
		campoNum1.setBounds(208, 52, 66, 20);
		getContentPane().add(campoNum1);
		campoNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Num 2");
		lblNum2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum2.setBounds(152, 90, 39, 14);
		getContentPane().add(lblNum2);
		
		campoNum2 = new JTextField();
		campoNum2.setColumns(10);
		campoNum2.setBounds(208, 87, 66, 20);
		getContentPane().add(campoNum2);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResultado.setBounds(152, 141, 52, 14);
		getContentPane().add(lblResultado);
		
		campoResultado = new JTextField();
		campoResultado.setEditable(false);
		campoResultado.setBounds(208, 138, 66, 20);
		getContentPane().add(campoResultado);
		campoResultado.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 215, 434, 46);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(116, 11, 87, 23);
		panel.add(btnLimpar);
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
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(223, 11, 104, 23);
		panel.add(btnCalcular);
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
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SomaNumeroModificado();
	}
}
