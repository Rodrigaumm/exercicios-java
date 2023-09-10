package lista4.ex04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TresNumerosOrdenados extends JFrame {
	private JTextField campoNum1;
	private JTextField campoNum2;
	private JTextField campoNum3;
	private JTextField campoResultado1;
	private JTextField campoResultado2;
	private JTextField campoResultado3;
	private ArrayList<Double> numeros = new ArrayList<Double>();
	
	public TresNumerosOrdenados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 381));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ordena três números");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(142, 11, 149, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblNum1 = new JLabel("Num 1:");
		lblNum1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum1.setBounds(127, 55, 48, 14);
		getContentPane().add(lblNum1);
		
		campoNum1 = new JTextField();
		campoNum1.setBounds(236, 52, 66, 20);
		getContentPane().add(campoNum1);
		campoNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Num 2:");
		lblNum2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum2.setBounds(127, 86, 43, 14);
		getContentPane().add(lblNum2);
		
		campoNum2 = new JTextField();
		campoNum2.setColumns(10);
		campoNum2.setBounds(236, 83, 66, 20);
		getContentPane().add(campoNum2);
		
		JLabel lblNum3 = new JLabel("Num 3:");
		lblNum3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum3.setBounds(127, 117, 90, 14);
		getContentPane().add(lblNum3);
		
		campoNum3 = new JTextField();
		campoNum3.setBounds(236, 114, 66, 20);
		getContentPane().add(campoNum3);
		campoNum3.setColumns(10);
		
		JLabel lblResultado = new JLabel("Ordem crescente:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResultado.setBounds(127, 172, 90, 14);
		getContentPane().add(lblResultado);
		
		campoResultado1 = new JTextField();
		campoResultado1.setEditable(false);
		campoResultado1.setColumns(10);
		campoResultado1.setBounds(236, 169, 66, 20);
		getContentPane().add(campoResultado1);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(222, 297, 104, 23);
		getContentPane().add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					numeros.add(Double.valueOf(campoNum1.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum1.setText("");
					numeros.clear();
					return;
				}
				
				try {
					numeros.add(Double.valueOf(campoNum2.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum2.setText("");
					numeros.clear();
					return;
				}
				
				try {
					numeros.add(Double.valueOf(campoNum3.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum3.setText("");
					numeros.clear();
					return;
				}
				

				for (int i = 0; i < numeros.size(); i++) {
					Double actualValue = numeros.get(i);
					int j = i;
					
					while (j > 0 && numeros.get(j - 1) > actualValue) {
						numeros.set(j, numeros.get(j - 1));
						j--;
					}
					
					numeros.set(j, actualValue);
				}
				
				campoResultado1.setText(String.valueOf(numeros.get(0)));
				campoResultado2.setText(String.valueOf(numeros.get(1)));
				campoResultado3.setText(String.valueOf(numeros.get(2)));
				
				numeros.clear();
			}
		});
		btnCalcular.setFocusable(false);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(106, 297, 87, 23);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNum1.setText("");
				campoNum2.setText("");
				campoNum3.setText("");
				campoResultado1.setText("");
				campoResultado2.setText("");
				campoResultado3.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		
		campoResultado2 = new JTextField();
		campoResultado2.setEditable(false);
		campoResultado2.setColumns(10);
		campoResultado2.setBounds(236, 200, 66, 20);
		getContentPane().add(campoResultado2);
		
		campoResultado3 = new JTextField();
		campoResultado3.setEditable(false);
		campoResultado3.setColumns(10);
		campoResultado3.setBounds(236, 231, 66, 20);
		getContentPane().add(campoResultado3);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TresNumerosOrdenados();
	}
}
