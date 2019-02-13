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
import modelo.Responsavel;

@SuppressWarnings("serial")
public class TelaCadastroResponsavel extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JLabel lblPreco;
	private JButton btnCriar;
	private JLabel lblNome;
	private JTextField medidor;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroResponsavel frame = new TelaCadastroResponsavel();
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
	public TelaCadastroResponsavel() {
		setTitle("Cadastrar Responsável");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPreco = new JLabel("Telefone");
		lblPreco.setBounds(10, 91, 122, 23);
		contentPane.add(lblPreco);

		nome = new JTextField();
		nome.setBounds(128, 34, 116, 23);
		contentPane.add(nome);
		nome.setColumns(10);
		
		medidor = new JTextField();
		medidor.setColumns(10);
		medidor.setBounds(128, 148, 116, 23);
		contentPane.add(medidor);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Responsavel r = Fachada.cadastrarResponsavel(nome.getText(), telefone.getText(), medidor.getText());
					JOptionPane.showMessageDialog(null,"cadastrado id= "+r.getId());					
					nome.setText("");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(323, 137, 173, 47);
		contentPane.add(btnCriar);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 34, 122, 23);
		contentPane.add(lblNome);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(10, 148, 122, 23);
		contentPane.add(lblLocal);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(128, 91, 116, 23);
		contentPane.add(telefone);
		
		
	}
}
