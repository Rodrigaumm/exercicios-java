package lista4.ex15;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class NumerosPrimos extends JFrame {
	private boolean mostrado = false;
	private DefaultListModel<String> modelPrimos = new DefaultListModel<>();
	
	public NumerosPrimos() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 452));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Números primos de 1 a 100");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(121, 11, 191, 14);
		getContentPane().add(lblTitulo);
		
		JButton btnVer = new JButton("Ver Primos de 1 até 100");
		btnVer.setFocusable(false);
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mostrado) {
					mostrado = false;
					modelPrimos.clear();
					btnVer.setText("Ver Primos de 1 até 100");
					return;
				};
				
				for (int i = 2; i < 100; i++) {
					boolean prime = true;
					for (int j = 2; j < Math.sqrt(i); j++)
						if (i % j == 0) prime = false; 
					
					if (prime)
						modelPrimos.addElement(String.format("%03d", i));
				}
				
				mostrado = true;
				btnVer.setText("Desver Primos de 1 até 100");
			}
		});
		btnVer.setBounds(116, 36, 202, 39);
		getContentPane().add(btnVer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 97, 217, 246);
		getContentPane().add(scrollPane);
		
		JList<String> list = new JList<>();
		list.setModel(modelPrimos);
		scrollPane.setViewportView(list);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NumerosPrimos();
	}
}
