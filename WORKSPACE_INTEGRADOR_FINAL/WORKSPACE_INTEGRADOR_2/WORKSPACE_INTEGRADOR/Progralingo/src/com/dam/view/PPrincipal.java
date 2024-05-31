package com.dam.view;

import javax.swing.JFrame;

import com.dam.control.ProgralingoListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;


public class PPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ACR_PP_INI_SESION = "INICIO SESION";
	private static final String ACT_PP_REG = "REGISTRO";
	private static final String ACR_PP_OP = "OPCIONES";
	private JScrollPane scrpContenedor;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmInicioS;
	private JLabel lblProgralingo;
	private JMenu mnOpciones;
	private JMenuBar menuBar;
	
	
	public PPrincipal() {
		
		crearComp();
		initComponents();
	}
	private void crearComp() {
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnOpciones = new JMenu(ACR_PP_OP);
		menuBar.add(mnOpciones);
		
		mntmRegistro = new JMenuItem(ACT_PP_REG);
		mnOpciones.add(mntmRegistro);
		
		mntmInicioS = new JMenuItem(ACR_PP_INI_SESION);
		mnOpciones.add(mntmInicioS);
		
		
	}
	private void initComponents(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		lblProgralingo = new JLabel("                             PROGRALINGO");
		lblProgralingo.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrpContenedor.setColumnHeaderView(lblProgralingo);
	}

	public JMenuItem getMntmRegistro() {
		return mntmRegistro;
	}

	public JMenuItem getMntmInicioSesion() {
		return mntmInicioS;
	}
	public void hacerVisible() {
		setVisible(true);		
	}
	public void setControlador(ProgralingoListener controlador) {
		mntmInicioS.addActionListener(controlador);
		mntmRegistro.addActionListener(controlador);
	}
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
		
	}
}
