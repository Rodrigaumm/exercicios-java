package lista4.ex10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GuardaProdutos extends JFrame {
	class Produto {
		private String nome;
		private Double valor, quantidade;

		public Produto(String nome, Double valor, Double quantidade) {
			this.nome = nome;
			this.valor = valor;
			this.quantidade = quantidade;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public Double getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Double quantidade) {
			this.quantidade = quantidade;
		}
	}

	private JTextField campoNome;
	private JTextField campoValor;
	private JTextField campoQuantidade;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private DefaultListModel<String> modelNomes = new DefaultListModel<>();
	private DefaultListModel<Double> modelValores = new DefaultListModel<>();
	private DefaultListModel<Double> modelQuantidades = new DefaultListModel<>();

	public GuardaProdutos() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 535));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Grava Produto");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(166, 11, 101, 14);
		getContentPane().add(lblTitulo);

		JPanel panelEntrada = new JPanel();
		panelEntrada.setForeground(new Color(0, 0, 0));
		panelEntrada.setBackground(new Color(192, 192, 192));
		panelEntrada.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Entrada de dados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelEntrada.setBounds(10, 36, 414, 185);
		getContentPane().add(panelEntrada);
		panelEntrada.setLayout(null);

		JPanel panelResultados = new JPanel();
		panelResultados.setLayout(null);
		panelResultados.setForeground(Color.BLACK);
		panelResultados.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Resultados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelResultados.setBackground(Color.LIGHT_GRAY);
		panelResultados.setBounds(10, 232, 414, 253);
		getContentPane().add(panelResultados);

		JLabel lblNomesArmazenados = new JLabel("Nomes Armazenados");
		lblNomesArmazenados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomesArmazenados.setBounds(20, 25, 100, 14);
		panelResultados.add(lblNomesArmazenados);

		JScrollPane scrollPaneNomes = new JScrollPane();
		scrollPaneNomes.setBounds(20, 41, 119, 201);
		panelResultados.add(scrollPaneNomes);

		JList<String> listNomes = new JList<>();
		listNomes.setModel(modelNomes);
		scrollPaneNomes.setViewportView(listNomes);

		JLabel lblValoresArmazenados = new JLabel("Valores Armazenados");
		lblValoresArmazenados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValoresArmazenados.setBounds(149, 25, 106, 14);
		panelResultados.add(lblValoresArmazenados);

		JScrollPane scrollPaneValores = new JScrollPane();
		scrollPaneValores.setBounds(149, 41, 119, 201);
		panelResultados.add(scrollPaneValores);

		JList<Double> listValores = new JList<>();
		listValores.setModel(modelValores);
		scrollPaneValores.setViewportView(listValores);

		JLabel lblQuantidadesArmazenadas = new JLabel("Quantidades Armazenadas");
		lblQuantidadesArmazenadas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadesArmazenadas.setBounds(278, 25, 136, 14);
		panelResultados.add(lblQuantidadesArmazenadas);

		JScrollPane scrollPaneQuantidades = new JScrollPane();
		scrollPaneQuantidades.setBounds(278, 41, 119, 201);
		panelResultados.add(scrollPaneQuantidades);

		JList<Double> listQuantidades = new JList<>();
		listQuantidades.setModel(modelQuantidades);
		scrollPaneQuantidades.setViewportView(listQuantidades);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(35, 25, 27, 14);
		panelEntrada.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		campoNome = new JTextField();
		campoNome.setBounds(35, 42, 138, 26);
		panelEntrada.add(campoNome);
		campoNome.setColumns(10);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(35, 79, 28, 14);
		panelEntrada.add(lblValor);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 11));

		campoValor = new JTextField();
		campoValor.setBounds(35, 96, 138, 26);
		panelEntrada.add(campoValor);
		campoValor.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(35, 133, 56, 14);
		panelEntrada.add(lblQuantidade);

		campoQuantidade = new JTextField();
		campoQuantidade.setColumns(10);
		campoQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor, quantidade = -1337.;
				String nome = campoNome.getText();
				if (nome.equals("")) {
					campoNome.setText("");
					return;
				}

				try {
					valor = Double.valueOf(campoValor.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoValor.setText("");
					return;
				}

				try {
					quantidade = Double.valueOf(campoQuantidade.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoQuantidade.setText("");
					return;
				}

				produtos.add(new Produto(nome, valor, quantidade));

				int index = listNomes.getModel().getSize();

				modelNomes.addElement(produtos.get(index).getNome());
				modelValores.addElement(produtos.get(index).getValor());
				modelQuantidades.addElement(produtos.get(index).getQuantidade());

				campoNome.setText("");
				campoValor.setText("");
				campoQuantidade.setText("");

				campoNome.requestFocus();
			}
		});
		campoQuantidade.setBounds(35, 150, 138, 26);
		panelEntrada.add(campoQuantidade);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GuardaProdutos();
	}
}
