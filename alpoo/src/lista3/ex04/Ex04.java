package lista3.ex04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ex04 extends JFrame {

	public Ex04() {
		setSize(new Dimension(546, 507));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Consolas", Font.PLAIN, 12));
		setTitle("Ex04");
		getContentPane().setBackground(new Color(235, 235, 235));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 43, 530, 425);
		panel.setLayout(null);
		getContentPane().add(panel);

		JLabel tituloLabel = new JLabel("Exercicio 03: Todos componentes");
		tituloLabel.setBounds(74, 11, 381, 22);
		tituloLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(tituloLabel);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNome.setBounds(173, 30, 42, 14);
		panel.add(lblNome);

		JTextField campoNome = new JTextField();
		campoNome.setFont(new Font("Consolas", Font.PLAIN, 12));
		campoNome.setBounds(174, 45, 182, 31);
		panel.add(campoNome);
		campoNome.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblDataDeNascimento.setBounds(173, 87, 149, 14);
		panel.add(lblDataDeNascimento);

		JTextField campoDataDeNascimento = new JTextField();
		campoDataDeNascimento.setFont(new Font("Consolas", Font.PLAIN, 12));
		campoDataDeNascimento.setBounds(174, 102, 182, 31);
		panel.add(campoDataDeNascimento);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblCPF.setBounds(173, 144, 42, 14);
		panel.add(lblCPF);

		JTextField campoCPF = new JTextField();
		campoCPF.setFont(new Font("Consolas", Font.PLAIN, 12));
		campoCPF.setBounds(174, 159, 182, 31);
		panel.add(campoCPF);

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblRg.setBounds(174, 201, 27, 14);
		panel.add(lblRg);

		JTextField campoRG = new JTextField();
		campoRG.setFont(new Font("Consolas", Font.PLAIN, 12));
		campoRG.setBounds(174, 216, 182, 31);
		panel.add(campoRG);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblLogradouro.setBounds(174, 258, 80, 14);
		panel.add(lblLogradouro);

		JTextField campoLogradouro = new JTextField();
		campoLogradouro.setFont(new Font("Consolas", Font.PLAIN, 12));
		campoLogradouro.setBounds(174, 273, 101, 31);
		panel.add(campoLogradouro);

		JLabel lblNumero = new JLabel("n°");
		lblNumero.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNumero.setBounds(297, 258, 16, 14);
		panel.add(lblNumero);

		JTextField campoNumero = new JTextField();
		campoNumero.setFont(new Font("Consolas", Font.PLAIN, 12));
		campoNumero.setBounds(297, 273, 59, 31);
		panel.add(campoNumero);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(114, 149, 175));
		btnEntrar.setBounds(174, 352, 182, 36);
		btnEntrar.setFocusable(false);
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Nome: " + campoNome.getText() + "\n" + "Data de Nascimento: " + campoDataDeNascimento.getText()
								+ "\n" + "CPF: " + campoCPF.getText() + "\n" + "RG: " + campoRG.getText() + "\n"
								+ "Logradouro: " + campoLogradouro.getText() + "\n" + "N°: " + campoNumero.getText());
			}
		});
		panel.add(btnEntrar);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04();
	}
}
