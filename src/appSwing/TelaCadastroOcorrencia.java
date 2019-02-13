package appSwing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Ocorrencia;

@SuppressWarnings("serial")
public class TelaCadastroOcorrencia extends JFrame {

	private JPanel contentPane;
	private JTextField zona;
	private JLabel lblPreco;
	private JButton btnCriar;
	private JLabel lblZona;
	private JTextField alias;
	private JLabel lblTcnico;
	private JTextField tecnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroOcorrencia frame = new TelaCadastroOcorrencia();
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
	public TelaCadastroOcorrencia() {
		setTitle("Cadastrar Ocorrências");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPreco = new JLabel("Alias");
		lblPreco.setBounds(10, 91, 122, 23);
		contentPane.add(lblPreco);

		zona = new JTextField();
		zona.setBounds(128, 34, 116, 23);
		contentPane.add(zona);
		zona.setColumns(10);
		
		alias = new JTextField();
		alias.setColumns(10);
		alias.setBounds(128, 91, 116, 23);
		contentPane.add(alias);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Ocorrencia o = Fachada.cadastrarOcorrencia(zona.getText(), alias.getText(), tecnico.getText());
					JOptionPane.showMessageDialog(null,"cadastrado id= "+o.getId());					
					zona.setText("");
					alias.setText("");
					tecnico.setText("");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(323, 137, 173, 47);
		contentPane.add(btnCriar);
		
		lblZona = new JLabel("Zona");
		lblZona.setBounds(10, 34, 122, 23);
		contentPane.add(lblZona);
		
		lblTcnico = new JLabel("Técnico");
		lblTcnico.setBounds(10, 148, 122, 23);
		contentPane.add(lblTcnico);
		
		tecnico = new JTextField();
		tecnico.setColumns(10);
		tecnico.setBounds(128, 148, 116, 23);
		contentPane.add(tecnico);
		
		
	}
}
