package lista4.ex12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class OrdenaOitoNumeros extends JFrame {
	private JTextField campoNumeros;
	private DefaultListModel<Integer> modelNumeros = new DefaultListModel<>();
	private DefaultListModel<Integer> modelCrescente = new DefaultListModel<>();
	private DefaultListModel<Integer> modelDecrescente = new DefaultListModel<>();

	class InputActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modelNumeros.clear();
			modelCrescente.clear();
			modelDecrescente.clear();
			
			String[] numerosString = campoNumeros.getText().split(",");
			Integer[] numeros = new Integer[numerosString.length];
			for (int i = 0; i < numerosString.length; i++) {
				numeros[i] = Integer.valueOf(numerosString[i]);
			}
			for (int i = 0; i < numeros.length; i++) {
				modelNumeros.addElement(numeros[i]);
			}

			for (int i = 0; i < numeros.length; i++) {
				Integer actualValue = numeros[i];
				int j = i;

				while (j > 0 && numeros[j - 1] > actualValue) {
					numeros[j] = numeros[j - 1];
					j--;
				}

				numeros[j] = actualValue;
			}

			for (int i = 0; i < numeros.length; i++) {
				modelCrescente.addElement(numeros[i]);
			}

			for (int i = 0, j = numeros.length - 1; i < numeros.length / 2; i++, j--) {
				Integer temp = numeros[i];
				numeros[i] = numeros[j];
				numeros[j] = temp;
			}

			for (int i = 0; i < numeros.length; i++) {
				modelDecrescente.addElement(numeros[i]);
			}
		}
	}

	public OrdenaOitoNumeros() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 452));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Bike");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(202, 11, 29, 14);
		getContentPane().add(lblTitulo);

		JPanel panelEntrada = new JPanel();
		panelEntrada.setForeground(new Color(0, 0, 0));
		panelEntrada.setBackground(new Color(192, 192, 192));
		panelEntrada.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Entrada de dados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelEntrada.setBounds(10, 36, 414, 82);
		getContentPane().add(panelEntrada);
		panelEntrada.setLayout(null);

		JPanel panelResultados = new JPanel();
		panelResultados.setLayout(null);
		panelResultados.setForeground(Color.BLACK);
		panelResultados.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Resultados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelResultados.setBackground(Color.LIGHT_GRAY);
		panelResultados.setBounds(11, 141, 414, 253);
		getContentPane().add(panelResultados);

		JLabel lblOrdemCrescente = new JLabel("Ordem Crescente");
		lblOrdemCrescente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrdemCrescente.setBounds(162, 25, 84, 14);
		panelResultados.add(lblOrdemCrescente);

		JScrollPane scrollPaneCrescente = new JScrollPane();
		scrollPaneCrescente.setBounds(162, 41, 84, 201);
		panelResultados.add(scrollPaneCrescente);

		JList<Integer> listCrescente = new JList<>();
		listCrescente.setModel(modelCrescente);
		scrollPaneCrescente.setViewportView(listCrescente);

		JLabel lblOrdemDecrescente = new JLabel("Ordem Decrescente");
		lblOrdemDecrescente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrdemDecrescente.setBounds(272, 25, 95, 14);
		panelResultados.add(lblOrdemDecrescente);

		JScrollPane scrollPaneDecrescente = new JScrollPane();
		scrollPaneDecrescente.setBounds(272, 41, 84, 201);
		panelResultados.add(scrollPaneDecrescente);

		JList<Integer> listDecrescente = new JList<>();
		listDecrescente.setModel(modelDecrescente);
		scrollPaneDecrescente.setViewportView(listDecrescente);

		JLabel lblNumeros = new JLabel("Numeros");
		lblNumeros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumeros.setBounds(53, 25, 42, 14);
		panelResultados.add(lblNumeros);

		JScrollPane scrollPaneNumeros = new JScrollPane();
		scrollPaneNumeros.setBounds(53, 41, 84, 201);
		panelResultados.add(scrollPaneNumeros);

		JList<Integer> listNumeros = new JList<Integer>();
		listNumeros.setModel(modelNumeros);
		scrollPaneNumeros.setViewportView(listNumeros);

		JLabel lblNumerosInput = new JLabel("Digite 8 números separados por vírgula (Ex.: 1,2,3,4,5,6,7,8)");
		lblNumerosInput.setBounds(25, 25, 322, 14);
		panelEntrada.add(lblNumerosInput);
		lblNumerosInput.setFont(new Font("Tahoma", Font.PLAIN, 11));

		campoNumeros = new JTextField();
		campoNumeros.addActionListener(new InputActionHandler());
		campoNumeros.setBounds(25, 42, 288, 26);
		panelEntrada.add(campoNumeros);
		campoNumeros.setColumns(10);

		JButton btnAleatorio = new JButton("Aleatório");
		btnAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String randomInput = "";
				SecureRandom rand = new SecureRandom();
				for (int i = 0; i < 8; i++) {
					randomInput += rand.nextInt(100);
					if (i != 7)
						randomInput += ",";
				}
				campoNumeros.setText(randomInput);
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						ActionEvent event = new ActionEvent(campoNumeros, 1337, "");
						for (ActionListener al : campoNumeros.getActionListeners()) {
							al.actionPerformed(event);
						}
					}
				});
			}
		});
		btnAleatorio.setFocusable(false);
		btnAleatorio.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAleatorio.setBounds(323, 44, 81, 23);
		panelEntrada.add(btnAleatorio);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OrdenaOitoNumeros();
	}
}
