package appSwing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class TelaPrincipal {

	private JFrame frmPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		try {
			frmPrincipal.setContentPane(new Fundo("imagem1.jpg"));
		} catch (IOException e1) {
		}	

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fachada.inicializar();
				JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}
			@Override
			public void windowActivated(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");

			}
		});
		frmPrincipal.setTitle("Relação de Ocorrências");
		frmPrincipal.setBounds(100, 100, 723, 518);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		JMenu mnResponsavel = new JMenu("Cadastrar");
		menuBar.add(mnResponsavel);
		
		JMenuItem mntmLocal = new JMenuItem("Local");
		mntmLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLocal j = new TelaCadastroLocal();
				j.setVisible(true);
			}
		});
		mnResponsavel.add(mntmLocal);
		
		JMenuItem mntmSite = new JMenuItem("Site");
		mntmSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroSite j = new TelaCadastroSite();
				j.setVisible(true);
			}
		});
		mnResponsavel.add(mntmSite);
		
		JMenuItem mntmResponsavel = new JMenuItem("Responsavel");
		mntmResponsavel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroResponsavel j = new TelaCadastroResponsavel();
				j.setVisible(true);
			}
		});
		mnResponsavel.add(mntmResponsavel);
		
		JMenuItem mntmOcorrencias = new JMenuItem("Ocorrencia");
		mntmOcorrencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroOcorrencia j = new TelaCadastroOcorrencia();
				j.setVisible(true);
			}
		});
		mnResponsavel.add(mntmOcorrencias);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem menuItem_9 = new JMenuItem("Ocorrencia");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarOcorrencia j = new TelaAtualizarOcorrencia();
				j.setVisible(true);
			}
		});
		mnAtualizar.add(menuItem_9);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		JMenuItem menuItem_6 = new JMenuItem("Ocorrencia");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeletarOcorrencia j = new TelaDeletarOcorrencia();
				j.setVisible(true);
			}
		});
		mnExcluir.add(menuItem_6);
		
		JMenu menu = new JMenu("Consultas");
		menuBar.add(menu);
		
		JMenuItem mntmTodas = new JMenuItem("Todas");
		mntmTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta j = new TelaConsulta();
				j.setVisible(true);
			}
		});
		menu.add(mntmTodas);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem menuItem_10 = new JMenuItem("Site");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemSite j = new TelaListagemSite();
				j.setVisible(true);
			}
		});
		mnListar.add(menuItem_10);
		
		JMenuItem menuItem_12 = new JMenuItem("Ocorrencia");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemOcorrencia j = new TelaListagemOcorrencia();
				j.setVisible(true);
			}
		});
		mnListar.add(menuItem_12);
	}
}
