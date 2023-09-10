package lista4.ex08;

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

public class DividendoDivisor extends JFrame {
	private JTextField campoUltimoDivisor;
	private JTextField campoPrimeiroDivisor;
	private JTextField campoPrimeiroDividendo;
	private JTextField campoUltimoDividendo;
	private JTextField campoResultado;

	public DividendoDivisor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 322));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Dividendo-Divisor 2.0");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(144, 11, 146, 14);
		getContentPane().add(lblTitulo);

		JLabel lblPrimeiroDivisor = new JLabel("Primeiro divisor:");
		lblPrimeiroDivisor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrimeiroDivisor.setBounds(114, 119, 76, 14);
		getContentPane().add(lblPrimeiroDivisor);

		campoPrimeiroDivisor = new JTextField();
		campoPrimeiroDivisor.setColumns(10);
		campoPrimeiroDivisor.setBounds(115, 134, 87, 29);
		getContentPane().add(campoPrimeiroDivisor);

		JLabel lblUltimoDivisor = new JLabel("Último divisor:");
		lblUltimoDivisor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUltimoDivisor.setBounds(227, 119, 67, 14);
		getContentPane().add(lblUltimoDivisor);

		campoUltimoDivisor = new JTextField();
		campoUltimoDivisor.setBounds(227, 134, 87, 29);
		campoUltimoDivisor.setColumns(10);
		getContentPane().add(campoUltimoDivisor);

		JLabel lblPrimeiroDividendo = new JLabel("Primeiro dividendo:");
		lblPrimeiroDividendo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrimeiroDividendo.setBounds(114, 55, 91, 14);
		getContentPane().add(lblPrimeiroDividendo);

		campoPrimeiroDividendo = new JTextField();
		campoPrimeiroDividendo.setColumns(10);
		campoPrimeiroDividendo.setBounds(115, 69, 87, 29);
		getContentPane().add(campoPrimeiroDividendo);

		JLabel lbllUtimoDividendo = new JLabel("Último dividendo:");
		lbllUtimoDividendo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbllUtimoDividendo.setBounds(227, 55, 82, 14);
		getContentPane().add(lbllUtimoDividendo);

		campoUltimoDividendo = new JTextField();
		campoUltimoDividendo.setColumns(10);
		campoUltimoDividendo.setBounds(227, 69, 87, 29);
		getContentPane().add(campoUltimoDividendo);

		campoResultado = new JTextField();
		campoResultado.setEditable(false);
		campoResultado.setColumns(10);
		campoResultado.setBounds(157, 191, 120, 29);
		getContentPane().add(campoResultado);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(220, 235, 104, 23);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer primeiroDividendo, ultimoDividendo, primeiroDivisor, ultimoDivisor = null;

				try {
					primeiroDividendo = Integer.valueOf(campoPrimeiroDividendo.getText());
				} catch (NumberFormatException err) {
					campoPrimeiroDividendo.setText("");
					return;
				}

				try {
					ultimoDividendo = Integer.valueOf(campoUltimoDividendo.getText());
				} catch (NumberFormatException err) {
					campoUltimoDividendo.setText("");
					return;
				}

				try {
					primeiroDivisor = Integer.valueOf(campoPrimeiroDivisor.getText());
					if (primeiroDivisor == 0)
						throw new ArithmeticException();
				} catch (NumberFormatException | ArithmeticException err) {
					campoPrimeiroDivisor.setText("");
					return;
				}

				try {
					ultimoDivisor = Integer.valueOf(campoUltimoDivisor.getText());
					if (ultimoDivisor == 0)
						throw new ArithmeticException();
				} catch (NumberFormatException | ArithmeticException err) {
					campoUltimoDivisor.setText("");
					return;
				}

				Double resultado = 0.;
				if (primeiroDividendo < ultimoDividendo && primeiroDivisor < ultimoDivisor) {
					for (int i = primeiroDividendo, j = primeiroDivisor; i <= ultimoDividendo
							&& j <= ultimoDivisor; i++, j++) {
						if (j == 0)
							continue;

						if (i % 2 == 0)
							resultado -= i / (Double.valueOf(j) * j);
						else
							resultado += i / (Double.valueOf(j) * j);

					}
				} else if (primeiroDividendo < ultimoDividendo && primeiroDivisor > ultimoDivisor) {
					for (int i = primeiroDividendo, j = primeiroDivisor; i < ultimoDividendo
							&& j > ultimoDivisor; i++, j--) {
						if (j == 0)
							continue;

						if (i % 2 == 0)
							resultado -= i / (Double.valueOf(j) * j);
						else
							resultado += i / (Double.valueOf(j) * j);
					}
				} else if (primeiroDividendo > ultimoDividendo && primeiroDivisor < ultimoDivisor) {
					for (int i = primeiroDividendo, j = primeiroDivisor; i > ultimoDividendo
							&& j < ultimoDivisor; i--, j++) {
						if (j == 0)
							continue;

						if (i % 2 == 0)
							resultado -= i / (Double.valueOf(j) * j);
						else
							resultado += i / (Double.valueOf(j) * j);
					}
				} else {
					for (int i = primeiroDividendo, j = primeiroDivisor; i > ultimoDividendo
							&& j > ultimoDivisor; i--, j--) {
						if (j == 0)
							continue;

						if (i % 2 == 0)
							resultado -= i / (Double.valueOf(j) * j);
						else
							resultado += i / (Double.valueOf(j) * j);
					}
				}

				campoResultado.setText(String.format("%.9f", resultado));
			}
		});
		btnCalcular.setFocusable(false);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(104, 235, 87, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoPrimeiroDividendo.setText("");
				campoUltimoDividendo.setText("");
				campoPrimeiroDivisor.setText("");
				campoUltimoDivisor.setText("");
				campoResultado.setText("");
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(255, 128, 128));
		btnLimpar.setFocusable(false);
		getContentPane().add(btnLimpar);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DividendoDivisor();
	}
}
