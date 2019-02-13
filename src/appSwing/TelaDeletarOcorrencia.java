
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

import fachada.Fachada;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class TelaDeletarOcorrencia extends JFrame {
	private JLabel lblNome;
	private JButton btnCadastrar;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeletarOcorrencia window = new TelaDeletarOcorrencia();
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
	public TelaDeletarOcorrencia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Excluir Ocorr\u00EAncia");
		this.setBounds(100, 100, 485, 299);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.lblNome = new JLabel("ID da Ocorr\u00EAncia");
		this.lblNome.setBounds(21, 61, 167, 23);
		this.getContentPane().add(this.lblNome);
		this.btnCadastrar = new JButton("Deletar");
		
		spinner = new JSpinner();
		spinner.setBounds(209, 56, 175, 32);
		getContentPane().add(spinner);
		
		this.btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Integer id = (Integer) spinner.getValue();
					Fachada.apagarOcorrencia(id);
					JOptionPane.showMessageDialog(null,"ocorrencia id= "+id+" foi excuído");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		this.btnCadastrar.setBounds(302, 184, 136, 23);
		this.getContentPane().add(this.btnCadastrar);
	}
}
