package lista4.ex09;

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

public class GuardaVetor extends JFrame {
	class Pessoa {
		private String nome;
		private Integer idade;
		
		public Pessoa(String nome, Integer idade2) {
			this.nome = nome;
			this.idade = idade2;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}
	}
	
	private JTextField campoNome;
	private JTextField campoIdade;
	private DefaultListModel<String> modelNomes = new DefaultListModel<>();
	private DefaultListModel<Integer> modelIdades = new DefaultListModel<>();
	private ArrayList<Pessoa> pessoas = new ArrayList<>();

	public GuardaVetor() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 535));
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Grava Vetor");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(175, 11, 83, 14);
		getContentPane().add(lblTitulo);
		
		JPanel panelEntrada = new JPanel();
		panelEntrada.setForeground(new Color(0, 0, 0));
		panelEntrada.setBackground(new Color(192, 192, 192));
		panelEntrada.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Entrada de dados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelEntrada.setBounds(10, 36, 414, 144);
		getContentPane().add(panelEntrada);
		panelEntrada.setLayout(null);
		
		
		JPanel panelResultados = new JPanel();
		panelResultados.setLayout(null);
		panelResultados.setForeground(Color.BLACK);
		panelResultados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultados", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelResultados.setBackground(Color.LIGHT_GRAY);
		panelResultados.setBounds(10, 232, 414, 253);
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
		
		JLabel lblIdadesArmazenadas = new JLabel("Idades Armazenadas");
		lblIdadesArmazenadas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdadesArmazenadas.setBounds(285, 25, 106, 14);
		panelResultados.add(lblIdadesArmazenadas);
		
		JScrollPane scrollPaneIdades = new JScrollPane();
		scrollPaneIdades.setBounds(285, 41, 119, 201);
		panelResultados.add(scrollPaneIdades);
		
		JList<Integer> listIdades = new JList<>();
		listIdades.setModel(modelIdades);
		scrollPaneIdades.setViewportView(listIdades);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(35, 25, 27, 14);
		panelEntrada.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		campoNome = new JTextField();
		campoNome.setBounds(35, 42, 138, 26);
		panelEntrada.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(35, 79, 28, 14);
		panelEntrada.add(lblIdade);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		campoIdade = new JTextField();
		campoIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idade = -1337;
				String nome = campoNome.getText();
				if (nome.equals("")) {
					campoNome.setText("");
					return;
				}
				
				try {
					idade = Integer.valueOf(campoIdade.getText());
				} catch (NumberFormatException err) {
					campoIdade.setText("");
					return;
				}
				
				pessoas.add(new Pessoa(nome, idade));
				
				int index = listNomes.getModel().getSize();
				
				modelNomes.addElement(pessoas.get(index).getNome());
				modelIdades.addElement(pessoas.get(index).getIdade());
			
				campoNome.setText("");
				campoIdade.setText("");
				
				campoNome.requestFocus();
			}
		});
		campoIdade.setBounds(35, 96, 138, 26);
		panelEntrada.add(campoIdade);
		campoIdade.setColumns(10);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GuardaVetor();
	}
}
