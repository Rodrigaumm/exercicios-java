package lista4.ex03;

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

public class Combustivel extends JFrame {
	private JTextField campoKMInicial;
	private JTextField campoKMFinal;
	private JTextField campoLitros;
	private JTextField campoTotal;
	public Combustivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 327));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Combustível");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(172, 11, 90, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblKMInicial = new JLabel("KM Inicial:");
		lblKMInicial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKMInicial.setBounds(127, 55, 48, 14);
		getContentPane().add(lblKMInicial);
		
		campoKMInicial = new JTextField();
		campoKMInicial.setBounds(236, 52, 66, 20);
		getContentPane().add(campoKMInicial);
		campoKMInicial.setColumns(10);
		
		JLabel lblKMFinal = new JLabel("KM Final:");
		lblKMFinal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKMFinal.setBounds(127, 86, 43, 14);
		getContentPane().add(lblKMFinal);
		
		campoKMFinal = new JTextField();
		campoKMFinal.setColumns(10);
		campoKMFinal.setBounds(236, 83, 66, 20);
		getContentPane().add(campoKMFinal);
		
		JLabel lblLitros = new JLabel("Litros consumidos:");
		lblLitros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLitros.setBounds(127, 117, 90, 14);
		getContentPane().add(lblLitros);
		
		campoLitros = new JTextField();
		campoLitros.setBounds(236, 114, 66, 20);
		getContentPane().add(campoLitros);
		campoLitros.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotal.setBounds(127, 172, 28, 14);
		getContentPane().add(lblTotal);
		
		campoTotal = new JTextField();
		campoTotal.setEditable(false);
		campoTotal.setColumns(10);
		campoTotal.setBounds(236, 169, 66, 20);
		getContentPane().add(campoTotal);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(222, 239, 104, 23);
		getContentPane().add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double kmInicial, kmFinal, litrosConsumidos  = -1337.;
				try {
					kmInicial = Double.valueOf(campoKMInicial.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoKMInicial.setText("");
					return;
				}
				
				try {
					kmFinal = Double.valueOf(campoKMFinal.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoKMFinal.setText("");
					return;
				}
				
				try {
					litrosConsumidos = Double.valueOf(campoLitros.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoLitros.setText("");
					return;
				}
				
				if (kmInicial > kmFinal) {
					campoKMInicial.setText("");
					campoKMFinal.setText("");
					return;
				}
				
				if (litrosConsumidos < 0) {
					campoLitros.setText("");
					return;
				}
				
				campoTotal.setText(String.format("%.2f", (kmFinal - kmInicial) / litrosConsumidos));
			}
		});
		btnCalcular.setFocusable(false);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(106, 239, 87, 23);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoKMInicial.setText("");
				campoKMFinal.setText("");
				campoLitros.setText("");
				campoTotal.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		
		JLabel lblMedida = new JLabel("KM / L");
		lblMedida.setBounds(304, 172, 46, 14);
		getContentPane().add(lblMedida);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Combustivel();
	}
}
