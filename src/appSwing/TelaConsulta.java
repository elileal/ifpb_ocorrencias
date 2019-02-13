package appSwing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

@SuppressWarnings("serial")
public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnCriar;
	private JButton btnConsulta;
	private JButton btnConsulta_1;
	private JButton btnConsulta_2;
	private JButton btnConsulta_3;
	private JButton btnConsulta_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsulta() {
		setTitle("Consultar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCriar = new JButton("Total de Cidades");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					textArea.setText(Fachada.totalCidades().toString());
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(414, 25, 303, 23);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(21, 11, 372, 435);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		JButton btnCaonsulta = new JButton("Total de Sites");
		btnCaonsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(Fachada.totalSites().toString());
			}
		});
		btnCaonsulta.setBounds(414, 73, 303, 23);
		contentPane.add(btnCaonsulta);

		btnConsulta = new JButton("Total de Tecnicos");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Fachada.totalTecnicos().toString());
			}
		});
		btnConsulta.setBounds(414, 121, 303, 23);
		contentPane.add(btnConsulta);

		btnConsulta_1 = new JButton("Total de Ocorrencias");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Fachada.totalOcorrencias().toString());
			}
		});
		btnConsulta_1.setBounds(414, 169, 303, 23);
		contentPane.add(btnConsulta_1);

		btnConsulta_2 = new JButton("Locais");
		btnConsulta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("nome da cidade");
				textArea.setText(Fachada.locaisDaCidade(nome).toString());
			}
		});
		btnConsulta_2.setBounds(414, 217, 303, 23);
		contentPane.add(btnConsulta_2);
		
		btnConsulta_3 = new JButton("Sites sem Ocorrencias");
		btnConsulta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Fachada.siteSemOcorrencia().toString());
			}
		});
		btnConsulta_3.setBounds(414, 265, 303, 23);
		contentPane.add(btnConsulta_3);
		
		btnConsulta_4 = new JButton("Tecnicos sem Ocorrencias");
		btnConsulta_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Fachada.tecnicosSemOcorrencias().toString());
			}
		});
		btnConsulta_4.setBounds(414, 313, 303, 23);
		contentPane.add(btnConsulta_4);
		
		JButton btnCidadesSemLocais = new JButton("Cidades sem Locais");
		btnCidadesSemLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Fachada.cidadeSemLocal().toString());
			}
		});
		btnCidadesSemLocais.setBounds(414, 361, 303, 23);
		contentPane.add(btnCidadesSemLocais);
		
		JButton btnPercentualDeOcorrencias = new JButton("Percentual de Ocorrencias");
		btnPercentualDeOcorrencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("alias do site");
				textArea.setText(Fachada.mediaDeOcorrencias(nome).toString());
			}
		});
		btnPercentualDeOcorrencias.setBounds(414, 409, 303, 23);
		contentPane.add(btnPercentualDeOcorrencias);
	}
}
