package lista4.ex13;

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

public class SorteioCarro extends JFrame {
	class Cadastro {
		private String nome;
		private Integer cupom;
		
		public Cadastro(String nome, Integer cupom) {
			super();
			this.nome = nome;
			this.cupom = cupom;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getCupom() {
			return cupom;
		}

		public void setCupom(Integer cupom) {
			this.cupom = cupom;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(cupom);
			builder.append(" - ");
			builder.append(nome);
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
			
			ActionEvent event = new ActionEvent(campoNome, srand.nextInt(), "");
			for (ActionListener al : campoNome.getActionListeners()) {
				al.actionPerformed(event);
			}
		}
	}
	
	
	private JTextField campoNome;
	private JTextField campoNomeGanhador;
	private JTextField campoCupom;
	private boolean sorteado = false;
	private ArrayList<Cadastro> cadastros = new ArrayList<>();
	private DefaultListModel<String> modelCadastros = new DefaultListModel<>();
	private SecureRandom srand = new SecureRandom();
	
	public SorteioCarro() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 452));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Sorteio");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(192, 11, 50, 14);
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

		JLabel lblGanhador = new JLabel("Ganhador");
		lblGanhador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGanhador.setBounds(248, 25, 95, 14);
		panelResultados.add(lblGanhador);

		JLabel lblCadastros = new JLabel("Pessoas Cadastradas");
		lblCadastros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastros.setBounds(24, 25, 103, 14);
		panelResultados.add(lblCadastros);

		JScrollPane scrollPaneCadastros = new JScrollPane();
		scrollPaneCadastros.setBounds(24, 40, 129, 202);
		panelResultados.add(scrollPaneCadastros);

		JList<String> listCadastros = new JList<>();
		listCadastros.setModel(modelCadastros);
		scrollPaneCadastros.setViewportView(listCadastros);
		
		campoNomeGanhador = new JTextField();
		campoNomeGanhador.setEditable(false);
		campoNomeGanhador.setBounds(248, 81, 117, 30);
		panelResultados.add(campoNomeGanhador);
		campoNomeGanhador.setColumns(10);
		
		campoCupom = new JTextField();
		campoCupom.setEditable(false);
		campoCupom.setColumns(10);
		campoCupom.setBounds(248, 40, 41, 30);
		panelResultados.add(campoCupom);
		


		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 25, 27, 14);
		panelEntrada.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		campoNome = new JTextField();
		campoNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sorteado) {
					cadastros.clear();
					modelCadastros.clear();
					campoCupom.setText("");
					campoNomeGanhador.setText("");
					sorteado = false;
				}
				
				if (cadastros.size() == 100) {
					JOptionPane.showMessageDialog(null, "Sorteio cheio!");
					return;
				}
				
				String nome = campoNome.getText();
				
				if (nome.equals("") || cadastros.stream().map(cad -> cad.getNome()).anyMatch(nom -> nom.equals(nome))) {
					campoNome.setText("");
					return;
				};
				List<Integer> cupons = cadastros.stream().map(cad -> cad.getCupom()).collect(Collectors.toList());
				int cupom = srand.nextInt(100) + 1;
				while (cupons.contains(cupom)) {
					cupom = srand.nextInt(100) + 1;
				}
				
				cadastros.add(new Cadastro(nome, cupom));
				
				int index = modelCadastros.getSize();
				
				modelCadastros.addElement(cadastros.get(index).toString());
				
				campoNome.setText("");
			}
		});
		campoNome.setBounds(25, 42, 288, 26);
		panelEntrada.add(campoNome);
		campoNome.setColumns(10);

		JButton btnSortear = new JButton("Sortear");
		btnSortear.setFocusable(false);
		btnSortear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sorteado == false) {
					int indexSorteado = srand.nextInt(cadastros.size());
					campoNomeGanhador.setText(cadastros.get(indexSorteado).getNome());
					campoCupom.setText(cadastros.get(indexSorteado).getCupom().toString());
					sorteado = true;
				}
			}
		});
		btnSortear.setBounds(163, 219, 89, 23);
		panelResultados.add(btnSortear);
		
		JButton btnAleatorio = new JButton("Aleatório");
		btnAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 100; i++) {
					SwingUtilities.invokeLater(new TriggerCampoNomeActionListener());
				}
				
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						btnSortear.doClick();
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
		new SorteioCarro();
	}
}
