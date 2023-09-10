package lista4.ex11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Bike extends JFrame {
	class Pessoa {
		private String nome;
		private Integer numeroCadastro;

		public Pessoa(String nome, Integer numeroCadastro) {
			this.nome = nome;
			this.numeroCadastro = numeroCadastro;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getNumeroCadastro() {
			return numeroCadastro;
		}

		public void setNumeroCadastro(Integer numeroCadastro) {
			this.numeroCadastro = numeroCadastro;
		}
	}

	private JTextField campoNome;
	private DefaultListModel<String> modelNomes = new DefaultListModel<>();
	private DefaultListModel<Integer> modelCadastros = new DefaultListModel<>();
	private ArrayList<Pessoa> pessoas = new ArrayList<>();

	private Integer cadastroContador = 550;

	public Bike() {
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

		JLabel lblNomesArmazenados = new JLabel("Nomes Armazenados");
		lblNomesArmazenados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomesArmazenados.setBounds(20, 25, 100, 14);
		panelResultados.add(lblNomesArmazenados);

		JScrollPane scrollPaneNomes = new JScrollPane();
		scrollPaneNomes.setBounds(20, 41, 255, 201);
		panelResultados.add(scrollPaneNomes);

		JList<String> listNomes = new JList<>();
		listNomes.setModel(modelNomes);
		scrollPaneNomes.setViewportView(listNomes);

		JLabel lblCadastrosArmazenados = new JLabel("Cadastros Armazenados");
		lblCadastrosArmazenados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastrosArmazenados.setBounds(285, 25, 119, 14);
		panelResultados.add(lblCadastrosArmazenados);

		JScrollPane scrollPaneCadastros = new JScrollPane();
		scrollPaneCadastros.setBounds(285, 41, 119, 201);
		panelResultados.add(scrollPaneCadastros);

		JList<Integer> listCadastros = new JList<>();
		listCadastros.setModel(modelCadastros);
		scrollPaneCadastros.setViewportView(listCadastros);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(35, 25, 27, 14);
		panelEntrada.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		campoNome = new JTextField();
		campoNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				if (nome.equals("") || pessoas.stream().map((p) -> p.getNome()).anyMatch(n -> n.equals(nome))) {
					campoNome.setText("");
					return;
				}

				int index = listNomes.getModel().getSize();
				pessoas.add(new Pessoa(nome, cadastroContador++));

				modelNomes.addElement(pessoas.get(index).getNome());
				modelCadastros.addElement(pessoas.get(index).getNumeroCadastro());

				campoNome.setText("");
				campoNome.requestFocus();
			}
		});
		campoNome.setBounds(35, 42, 138, 26);
		panelEntrada.add(campoNome);
		campoNome.setColumns(10);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Bike();
	}
}
