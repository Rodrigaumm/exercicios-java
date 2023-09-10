package lista3.ex05;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LetraC extends JFrame {
	private boolean exameLiberado = false;
	private JTextField campoNP1;
	private JTextField campoPII;
	private JTextField campoNP2;
	private JTextField campoExame;

	public LetraC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 450);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Notas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(199, 11, 35, 14);
		getContentPane().add(lblTitulo);

		JLabel lblNP1 = new JLabel("NP1:");
		lblNP1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNP1.setBounds(140, 54, 24, 14);
		getContentPane().add(lblNP1);

		campoNP1 = new JTextField();
		campoNP1.setBounds(174, 47, 86, 28);
		getContentPane().add(campoNP1);
		campoNP1.setColumns(10);

		JLabel lblPII = new JLabel("PII:");
		lblPII.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPII.setBounds(140, 93, 24, 14);
		getContentPane().add(lblPII);

		campoPII = new JTextField();
		campoPII.setColumns(10);
		campoPII.setBounds(174, 86, 86, 28);
		getContentPane().add(campoPII);

		JLabel lblNP2 = new JLabel("NP2:");
		lblNP2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNP2.setBounds(140, 132, 24, 14);
		getContentPane().add(lblNP2);

		campoNP2 = new JTextField();
		campoNP2.setColumns(10);
		campoNP2.setBounds(174, 125, 86, 28);
		getContentPane().add(campoNP2);

		JLabel lblExame = new JLabel("Exame");
		lblExame.setEnabled(false);
		lblExame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExame.setBounds(194, 188, 46, 14);
		getContentPane().add(lblExame);

		JLabel lblNotaExame = new JLabel("Nota:");
		lblNotaExame.setEnabled(false);
		lblNotaExame.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNotaExame.setBounds(140, 220, 27, 14);
		getContentPane().add(lblNotaExame);

		campoExame = new JTextField();
		campoExame.setEditable(false);
		campoExame.setColumns(10);
		campoExame.setBounds(174, 213, 86, 28);
		getContentPane().add(campoExame);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(159, 296, 115, 36);
		btnCalcular.setBackground(new Color(114, 149, 175));
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Double np1 = 0.;
				Double np2 = 0.;
				Double pii = 0.;
				try {
					np1 = Double.parseDouble(campoNP1.getText());
				} catch (NumberFormatException err) {
					campoNP1.setText("");
					return;
				}

				try {
					np2 = Double.parseDouble(campoNP2.getText());
				} catch (NumberFormatException err) {
					campoNP1.setText("");
					return;
				}

				try {
					pii = Double.parseDouble(campoPII.getText());
				} catch (NumberFormatException err) {
					campoPII.setText("");
					return;
				}

				Double parcial = ((np1 * 3) + (pii * 4) + (np2 * 3)) / 10.;
				if (!exameLiberado) {
					if (parcial < 7.) {
						JOptionPane.showMessageDialog(null,
								"Reprovado com média parcial menor que 7.0! Insira a nota do exame.");
						lblExame.setEnabled(true);
						lblNotaExame.setEnabled(true);
						campoExame.setEditable(true);

						exameLiberado = true;
					} else {
						JOptionPane.showMessageDialog(null, "Aprovado com média maior ou igual a 7.0! Boas férias.");
						limpaCampos();
						lblExame.setEnabled(false);
						lblNotaExame.setEnabled(false);
						campoExame.setEditable(false);
					}
				} else {
					Double exame = 0.;
					try {
						exame = Double.parseDouble(campoExame.getText());
					} catch (NumberFormatException err) {
						campoExame.setText("");
					}

					if (((parcial + exame) / 2) < 5.) {
						JOptionPane.showMessageDialog(null,
								"Reprovado com média final menor que 5.0! Será necessário fazer a disciplina em dependência");
					} else {
						JOptionPane.showMessageDialog(null,
								"Aprovado com média final maior ou igual a 5.0! Boas férias.");
					}

					limpaCampos();
					lblExame.setEnabled(false);
					lblNotaExame.setEnabled(false);
					campoExame.setEditable(false);
					exameLiberado = false;
				}
			}
		});
		getContentPane().add(btnCalcular);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void limpaCampos() {
		campoNP1.setText("");
		campoNP2.setText("");
		campoPII.setText("");
		campoExame.setText("");
	}

	public static void main(String[] args) {
		new LetraC();
	}

}
