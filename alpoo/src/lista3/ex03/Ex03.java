package lista3.ex03;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ex03 extends JFrame {

	public Ex03() {
		setSize(new Dimension(600, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Consolas", Font.PLAIN, 12));
		setTitle("Ex03");
		getContentPane().setBackground(new Color(235, 235, 235));
		getContentPane().setLayout(null);

		JLabel tituloLabel = new JLabel("Exercicio 03: Todos componentes");
		tituloLabel.setBounds(101, 11, 381, 22);
		tituloLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(tituloLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 43, 584, 239);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNome.setBounds(201, 17, 42, 14);
		panel.add(lblNome);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblSenha.setBounds(201, 90, 42, 14);
		panel.add(lblSenha);

		JTextField campoNome = new JTextField();
		campoNome.setBounds(201, 32, 182, 31);
		panel.add(campoNome);
		campoNome.setColumns(10);

		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(201, 105, 182, 31);
		panel.add(campoSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(114, 149, 175));
		btnEntrar.setBounds(201, 180, 182, 36);
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Nome: " + campoNome.getText() + "\n" + "Senha: " + campoSenha.getText());
			}
		});
		panel.add(btnEntrar);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex03();
	}
}
