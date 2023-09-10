package lista4.ex05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class CincoNumerosOrdenados extends JFrame {
	private JTextField campoNum1;
	private JTextField campoNum2;
	private JTextField campoNum3;
	private JTextField campoNum4;
	private JTextField campoNum5;
	private ArrayList<Double> numeros = new ArrayList<Double>();
	private DefaultListModel<String> dlm = new DefaultListModel<>();
	
	public String formatDouble(Double d) {
		return String.format("%.2f", d);
	}
	
	public void preencherListModel() {
		for (Double n : numeros) {
			dlm.addElement(formatDouble(n));
		}
	}
	
	public CincoNumerosOrdenados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 526));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ordena cinco números");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(139, 11, 155, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblNum1 = new JLabel("Num 1:");
		lblNum1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum1.setBounds(134, 55, 48, 14);
		getContentPane().add(lblNum1);
		
		campoNum1 = new JTextField();
		campoNum1.setBounds(234, 49, 66, 20);
		getContentPane().add(campoNum1);
		campoNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Num 2:");
		lblNum2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum2.setBounds(134, 86, 43, 14);
		getContentPane().add(lblNum2);
		
		campoNum2 = new JTextField();
		campoNum2.setColumns(10);
		campoNum2.setBounds(234, 80, 66, 20);
		getContentPane().add(campoNum2);
		
		JLabel lblNum3 = new JLabel("Num 3:");
		lblNum3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum3.setBounds(134, 117, 43, 14);
		getContentPane().add(lblNum3);
		
		campoNum3 = new JTextField();
		campoNum3.setBounds(234, 111, 66, 20);
		getContentPane().add(campoNum3);
		campoNum3.setColumns(10);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(222, 399, 104, 23);
		getContentPane().add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeros.clear();
				dlm.clear();
				
				try {
					numeros.add(Double.valueOf(campoNum1.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum1.setText("");
				}
				
				try {
					numeros.add(Double.valueOf(campoNum2.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum2.setText("");
				}
				
				try {
					numeros.add(Double.valueOf(campoNum3.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum3.setText("");
				}
				
				try {
					numeros.add(Double.valueOf(campoNum4.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum4.setText("");
				}
				try {
					numeros.add(Double.valueOf(campoNum5.getText().replace(",", ".")));
				} catch (NumberFormatException err) {
					campoNum5.setText("");
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
				
				preencherListModel();
				
				numeros.clear();
			}
		});
		btnCalcular.setFocusable(false);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(106, 399, 87, 23);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNum1.setText("");
				campoNum2.setText("");
				campoNum3.setText("");
				campoNum4.setText("");
				campoNum5.setText("");
				numeros.clear();
				dlm.clear();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		
		JLabel lblNum4 = new JLabel("Num 4:");
		lblNum4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum4.setBounds(134, 145, 43, 14);
		getContentPane().add(lblNum4);
		
		campoNum4 = new JTextField();
		campoNum4.setColumns(10);
		campoNum4.setBounds(234, 139, 66, 20);
		getContentPane().add(campoNum4);
		
		JLabel lblNum5 = new JLabel("Num 5:");
		lblNum5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum5.setBounds(134, 176, 43, 14);
		getContentPane().add(lblNum5);
		
		campoNum5 = new JTextField();
		campoNum5.setColumns(10);
		campoNum5.setBounds(234, 170, 66, 20);
		getContentPane().add(campoNum5);
		
		JList<String> list = new JList<>();
		list.setModel(dlm);
		list.setBounds(134, 209, 166, 122);
		getContentPane().add(list);
		
		JButton btnPreencher = new JButton("PREENCHER");
		btnPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLimpar.doClick();
				
				Random rand = new Random();
				
				for (int i = 0; i < 5; i++) {
					numeros.add(Math.round((rand.nextDouble() * 50) * 100) / 100.);
				}
				
				campoNum1.setText(formatDouble(numeros.get(0)));
				campoNum2.setText(formatDouble(numeros.get(1)));
				campoNum3.setText(formatDouble(numeros.get(2)));
				campoNum4.setText(formatDouble(numeros.get(3)));
				campoNum5.setText(formatDouble(numeros.get(4)));
				
				numeros.clear();
				
				btnCalcular.doClick();
			}
		});
		btnPreencher.setFocusable(false);
		btnPreencher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPreencher.setBounds(320, 9, 104, 23);
		getContentPane().add(btnPreencher);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CincoNumerosOrdenados();
	}
}
