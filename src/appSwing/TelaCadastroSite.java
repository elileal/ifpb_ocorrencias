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
import modelo.Site;

@SuppressWarnings("serial")
public class TelaCadastroSite extends JFrame {

	private JPanel contentPane;
	private JTextField alias;
	private JLabel lblPreco;
	private JButton btnCriar;
	private JLabel lblAlias;
	private JTextField latlog;
	private JTextField altura;
	private JTextField medidor;
	private JLabel lblAltura;
	private JLabel lblMedidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroSite frame = new TelaCadastroSite();
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
	public TelaCadastroSite() {
		setTitle("Cadastrar Site");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPreco = new JLabel("LatLog");
		lblPreco.setBounds(10, 67, 122, 23);
		contentPane.add(lblPreco);

		alias = new JTextField();
		alias.setBounds(128, 22, 116, 23);
		contentPane.add(alias);
		alias.setColumns(10);
		
		latlog = new JTextField();
		latlog.setColumns(10);
		latlog.setBounds(128, 67, 116, 23);
		contentPane.add(latlog);
		
		altura = new JTextField();
		altura.setColumns(10);
		altura.setBounds(128, 112, 116, 23);
		contentPane.add(altura);
		
		medidor = new JTextField();
		medidor.setColumns(10);
		medidor.setBounds(128, 157, 116, 23);
		contentPane.add(medidor);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Float a = Float.parseFloat(altura.getText());
					Site s = Fachada.cadastrarSite(alias.getText(), latlog.getText(), a, medidor.getText());
					JOptionPane.showMessageDialog(null,"cadastrado id= "+s.getId());					
					alias.setText("");
					latlog.setText("");
					altura.setText("");
					medidor.setText("");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(323, 137, 173, 47);
		contentPane.add(btnCriar);
		
		lblAlias = new JLabel("Alias");
		lblAlias.setBounds(10, 22, 122, 23);
		contentPane.add(lblAlias);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 112, 122, 23);
		contentPane.add(lblAltura);
		
		lblMedidor = new JLabel("Medidor");
		lblMedidor.setBounds(10, 157, 122, 23);
		contentPane.add(lblMedidor);
	}
}
