
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package appSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;

import javax.swing.JSpinner;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaAtualizarOcorrencia extends JFrame {

	private JLabel lblId;
	private JLabel lblNome;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarOcorrencia window = new TelaAtualizarOcorrencia();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAtualizarOcorrencia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Atualizar Ocorr\u00EAncia");
		this.setBounds(100, 100, 557, 457);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.lblId = new JLabel("Descri\u00E7\u00E3o");
		this.lblId.setBounds(19, 56, 117, 26);
		this.getContentPane().add(this.lblId);
		this.lblNome = new JLabel("ID da Ocorr\u00EAncia");
		this.lblNome.setBounds(19, 28, 168, 26);
		this.getContentPane().add(this.lblNome);
		this.btnCadastrar = new JButton("atualizar");
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(219, 25, 34, 32);
		getContentPane().add(spinner);
		
		JTextField descricao = new JTextField();
		descricao.setHorizontalAlignment(SwingConstants.LEFT);
		descricao.setBounds(19, 93, 491, 228);
		getContentPane().add(descricao);
		descricao.setColumns(10);
			
		this.btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Integer id = (Integer) spinner.getValue();
					String des = descricao.getText();
					Fachada.atualizaOcorrencia(id.toString(), des);
					JOptionPane.showMessageDialog(null,"ocorrencia id= "+id+" atualizada");					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		this.btnCadastrar.setBounds(219, 342, 136, 23);
		this.getContentPane().add(this.btnCadastrar);
		this.btnLimpar = new JButton("Limpar");
		this.btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				descricao.setText("");
				descricao.requestFocus();
			}
		});
		this.btnLimpar.setBounds(369, 342, 141, 23);
		this.getContentPane().add(this.btnLimpar);
		
		

	}
}
