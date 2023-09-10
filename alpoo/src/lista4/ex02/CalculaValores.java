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

public class CalculaValores extends JFrame {
	private JTextField campoNum1;
	private JTextField campoNum2;
	private JTextField campoAdicao;
	private JTextField campoSubtracao;
	private JTextField campoMultiplicacao;
	private JTextField campoDivisao;
	public CalculaValores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 400));
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Calcular valores");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(169, 11, 113, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblNum1 = new JLabel("Num 1");
		lblNum1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum1.setBounds(152, 55, 46, 14);
		getContentPane().add(lblNum1);
		
		campoNum1 = new JTextField();
		campoNum1.setBounds(227, 52, 66, 20);
		getContentPane().add(campoNum1);
		campoNum1.setColumns(10);
		
		JLabel lblNum2 = new JLabel("Num 2");
		lblNum2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNum2.setBounds(152, 86, 39, 14);
		getContentPane().add(lblNum2);
		
		campoNum2 = new JTextField();
		campoNum2.setColumns(10);
		campoNum2.setBounds(227, 83, 66, 20);
		getContentPane().add(campoNum2);
		
		JLabel lblAdicao = new JLabel("Adição:");
		lblAdicao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdicao.setBounds(152, 141, 39, 14);
		getContentPane().add(lblAdicao);
		
		campoAdicao = new JTextField();
		campoAdicao.setEditable(false);
		campoAdicao.setBounds(227, 138, 66, 20);
		getContentPane().add(campoAdicao);
		campoAdicao.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 313, 434, 48);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(228, 11, 104, 23);
		panel.add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer num1, num2 = -1337;
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
				
				
				campoAdicao.setText(String.valueOf(num1 + num2));
				campoSubtracao.setText(String.valueOf(num1 - num2));
				campoMultiplicacao.setText(String.valueOf(num1 * num2));
				
				try {
					campoDivisao.setText(String.valueOf(num1 / num2));
				} catch (ArithmeticException err) {
					campoDivisao.setText("ERROR");
				}
			}
		});
		btnCalcular.setFocusable(false);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(121, 11, 87, 23);
		panel.add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNum1.setText("");
				campoNum2.setText("");
				campoAdicao.setText("");
				campoSubtracao.setText("");
				campoMultiplicacao.setText("");
				campoDivisao.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		
		JLabel lblSubtracao = new JLabel("Subtração:");
		lblSubtracao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSubtracao.setBounds(152, 172, 53, 14);
		getContentPane().add(lblSubtracao);
		
		campoSubtracao = new JTextField();
		campoSubtracao.setEditable(false);
		campoSubtracao.setColumns(10);
		campoSubtracao.setBounds(227, 169, 66, 20);
		getContentPane().add(campoSubtracao);
		
		JLabel lblMultiplicacao = new JLabel("Multiplicação:");
		lblMultiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMultiplicacao.setBounds(152, 203, 65, 14);
		getContentPane().add(lblMultiplicacao);
		
		campoMultiplicacao = new JTextField();
		campoMultiplicacao.setEditable(false);
		campoMultiplicacao.setColumns(10);
		campoMultiplicacao.setBounds(227, 200, 66, 20);
		getContentPane().add(campoMultiplicacao);
		
		JLabel lblDivisao = new JLabel("Divisão:");
		lblDivisao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDivisao.setBounds(152, 234, 39, 14);
		getContentPane().add(lblDivisao);
		
		campoDivisao = new JTextField();
		campoDivisao.setEditable(false);
		campoDivisao.setColumns(10);
		campoDivisao.setBounds(227, 231, 66, 20);
		getContentPane().add(campoDivisao);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalculaValores();
	}
}
