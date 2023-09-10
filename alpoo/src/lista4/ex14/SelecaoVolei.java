package lista4.ex14;

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

public class SelecaoVolei extends JFrame {
	class Pessoa {
		private String nome;
		private Double altura;
		
		public Pessoa(String nome, Double altura) {
			super();
			this.nome = nome;
			this.altura = altura;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getAltura() {
			return altura;
		}

		public void setAltura(Double altura) {
			this.altura = altura;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(nome);
			builder.append(" - ");
			builder.append(altura);
			return builder.toString();
		}
	}
	
	class TriggerCampoNomeActionListener implements Runnable {
		@Override
		public void run() {
			String randomInput = "";
			SecureRandom rand = new SecureRandom();
			for (int j = 0; j < 8; j++) {
				randomInput += Character.forDigit(rand.nextInt(Character.MAX_RADIX), Character.MAX_RADIX);
			}
			campoNome.setText(randomInput);
			campoAltura.setText(String.format("%.2f", rand.nextDouble() + 1.2));
			
			ActionEvent event = new ActionEvent(campoNome, srand.nextInt(), "");
			for (ActionListener al : campoAltura.getActionListeners()) {
				al.actionPerformed(event);
			}
		}
	}
	
	
	private JTextField campoNome;
	private JTextField campoAltura;
	private boolean selecionado = false;
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private DefaultListModel<String> modelPessoas = new DefaultListModel<>();
	private DefaultListModel<String> modelSelecao = new DefaultListModel<>();
	private SecureRandom srand = new SecureRandom();
	
	public SelecaoVolei() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 452));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Seleção Vôlei");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(172, 11, 89, 14);
		getContentPane().add(lblTitulo);

		JPanel panelEntrada = new JPanel();
		panelEntrada.setForeground(new Color(0, 0, 0));
		panelEntrada.setBackground(new Color(192, 192, 192));
		panelEntrada.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Entrada de dados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelEntrada.setBounds(10, 36, 414, 137);
		getContentPane().add(panelEntrada);
		panelEntrada.setLayout(null);

		JPanel panelResultados = new JPanel();
		panelResultados.setLayout(null);
		panelResultados.setForeground(Color.BLACK);
		panelResultados.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Resultados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelResultados.setBackground(Color.LIGHT_GRAY);
		panelResultados.setBounds(11, 184, 414, 229);
		getContentPane().add(panelResultados);

		JLabel lblSelecionadas = new JLabel("Selecionadas por altura");
		lblSelecionadas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelecionadas.setBounds(275, 26, 117, 14);
		panelResultados.add(lblSelecionadas);

		JLabel lblCadastros = new JLabel("Pessoas Cadastradas");
		lblCadastros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastros.setBounds(10, 26, 103, 14);
		panelResultados.add(lblCadastros);

		JScrollPane scrollPaneCadastros = new JScrollPane();
		scrollPaneCadastros.setBounds(10, 42, 129, 168);
		panelResultados.add(scrollPaneCadastros);

		JList<String> listCadastros = new JList<>();
		listCadastros.setModel(modelPessoas);
		scrollPaneCadastros.setViewportView(listCadastros);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 25, 27, 14);
		panelEntrada.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		campoNome = new JTextField();
		campoNome.setBounds(25, 42, 197, 26);
		panelEntrada.add(campoNome);
		campoNome.setColumns(10);

		JButton btnSelecionar = new JButton("SELECIONAR");
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSelecionar.setFocusable(false);
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoas.stream().filter(pe -> pe.getAltura() > 1.82).sorted((pe1, pe2) -> Double.compare(pe1.getAltura(), pe2.getAltura())).forEach(pe -> modelSelecao.addElement(pe.toString()));
				if (modelSelecao.getSize() > 0) {
					selecionado = true;
				}
			}
		});
		btnSelecionar.setBounds(145, 40, 97, 23);
		panelResultados.add(btnSelecionar);
		
		JScrollPane scrollPaneSelecao = new JScrollPane();
		scrollPaneSelecao.setBounds(275, 42, 129, 168);
		panelResultados.add(scrollPaneSelecao);
		
		JList<String> listSelecao = new JList<String>();
		listSelecao.setModel(modelSelecao);
		scrollPaneSelecao.setViewportView(listSelecao);
		
		JButton btnAleatorio = new JButton("Aleatório");
		btnAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 100; i++) {
					SwingUtilities.invokeLater(new TriggerCampoNomeActionListener());
				}
				
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						btnSelecionar.doClick();
					}
				});
			}
		});
		btnAleatorio.setFocusable(false);
		btnAleatorio.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAleatorio.setBounds(323, 44, 81, 23);
		panelEntrada.add(btnAleatorio);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(25, 79, 36, 14);
		panelEntrada.add(lblAltura);
		
		campoAltura = new JTextField();
		campoAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selecionado) {
					modelPessoas.clear();
					modelSelecao.clear();
					pessoas.clear();
					selecionado = false;
				}
				
				String nome = campoNome.getText();
				Double altura = -1337.;
				
				if (nome.equals("") || pessoas.stream().map(pe -> pe.getNome()).anyMatch(nom -> nom.equals(nome))) {
					campoNome.setText("");
					return;
				};
				
				try {
					altura = Double.parseDouble(campoAltura.getText().replace(",", "."));
				} catch (NumberFormatException err) {
					campoAltura.setText("");
					return;
				}
				
				pessoas.add(new Pessoa(nome, altura));
				
				int index = modelPessoas.getSize();
				
				modelPessoas.addElement(pessoas.get(index).toString());
				
				campoNome.setText("");
				campoAltura.setText("");
				
				campoNome.requestFocus();
			}
		});
		campoAltura.setColumns(10);
		campoAltura.setBounds(25, 96, 60, 26);
		panelEntrada.add(campoAltura);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SelecaoVolei();
	}
}
