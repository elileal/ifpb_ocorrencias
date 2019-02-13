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
import modelo.Local;

@SuppressWarnings("serial")
public class TelaCadastroLocal extends JFrame {

	private JPanel contentPane;
	private JTextField cidade;
	private JLabel lblPreco;
	private JButton btnCriar;
	private JLabel label;
	private JTextField medidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLocal frame = new TelaCadastroLocal();
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
	public TelaCadastroLocal() {
		setTitle("Cadastrar Local");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPreco = new JLabel("Medidor");
		lblPreco.setBounds(10, 76, 122, 23);
		contentPane.add(lblPreco);

		cidade = new JTextField();
		cidade.setBounds(128, 32, 116, 23);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		medidor = new JTextField();
		medidor.setColumns(10);
		medidor.setBounds(128, 71, 116, 23);
		contentPane.add(medidor);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Local l = Fachada.cadastrarLocal(cidade.getText(), medidor.getText());
					JOptionPane.showMessageDialog(null,"cadastrado id= "+l.getId());					
					cidade.setText("");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(323, 137, 173, 47);
		contentPane.add(btnCriar);
		
		label = new JLabel("Cidade");
		label.setBounds(10, 32, 122, 23);
		contentPane.add(label);
		
		
	}
}
