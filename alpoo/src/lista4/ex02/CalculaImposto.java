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

public class CalculaImposto extends JFrame {
	private JTextField campoValor;
	private JTextField campoQuantidade;
	private JTextField campoICMS;
	private JTextField campoIPI;
	private JTextField campoTransporte;
	private JTextField campoTotal;
	public CalculaImposto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 400));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Valor do produto com impostos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(107, 11, 219, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblValor = new JLabel("Valor do Produto");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValor.setBounds(127, 55, 80, 14);
		getContentPane().add(lblValor);
		
		campoValor = new JTextField();
		campoValor.setBounds(236, 52, 66, 20);
		getContentPane().add(campoValor);
		campoValor.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(127, 86, 66, 14);
		getContentPane().add(lblQuantidade);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setColumns(10);
		campoQuantidade.setBounds(236, 83, 66, 20);
		getContentPane().add(campoQuantidade);
		
		JLabel lblICMS = new JLabel("ICMS:");
		lblICMS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblICMS.setBounds(127, 117, 29, 14);
		getContentPane().add(lblICMS);
		
		campoICMS = new JTextField();
		campoICMS.setBounds(236, 114, 66, 20);
		getContentPane().add(campoICMS);
		campoICMS.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 313, 434, 48);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(212, 11, 104, 23);
		panel.add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor, quantidade, icms, ipi, transporte = -1337.;
				try {
					valor = Double.valueOf(campoValor.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoValor.setText("");
					return;
				}
				
				try {
					quantidade = Double.valueOf(campoQuantidade.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoQuantidade.setText("");
					return;
				}
				
				try {
					icms = Double.valueOf(campoICMS.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoICMS.setText("");
					return;
				}
				
				try {
					ipi = Double.valueOf(campoIPI.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoIPI.setText("");
					return;
				}
				
				try {
					transporte = Double.valueOf(campoTransporte.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoTransporte.setText("");
					return;
				}
				
				campoTotal.setText(String.format("%.2f", (valor + (valor*icms/100) + (valor* ipi/100) + (valor * transporte/100))*quantidade));
			}
		});
		btnCalcular.setFocusable(false);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(105, 11, 87, 23);
		panel.add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoValor.setText("");
				campoQuantidade.setText("");
				campoICMS.setText("");
				campoIPI.setText("");
				campoTransporte.setText("");
				campoTotal.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		
		JLabel lblIPI = new JLabel("IPI:");
		lblIPI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIPI.setBounds(127, 148, 18, 14);
		getContentPane().add(lblIPI);
		
		campoIPI = new JTextField();
		campoIPI.setColumns(10);
		campoIPI.setBounds(236, 145, 66, 20);
		getContentPane().add(campoIPI);
		
		JLabel lblTransporte = new JLabel("Transporte:");
		lblTransporte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTransporte.setBounds(127, 179, 57, 14);
		getContentPane().add(lblTransporte);
		
		campoTransporte = new JTextField();
		campoTransporte.setColumns(10);
		campoTransporte.setBounds(236, 176, 66, 20);
		getContentPane().add(campoTransporte);
		
		JLabel lblTotal = new JLabel("Total com imposto:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotal.setBounds(127, 232, 90, 14);
		getContentPane().add(lblTotal);
		
		campoTotal = new JTextField();
		campoTotal.setEditable(false);
		campoTotal.setColumns(10);
		campoTotal.setBounds(236, 229, 66, 20);
		getContentPane().add(campoTotal);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalculaImposto();
	}
}
