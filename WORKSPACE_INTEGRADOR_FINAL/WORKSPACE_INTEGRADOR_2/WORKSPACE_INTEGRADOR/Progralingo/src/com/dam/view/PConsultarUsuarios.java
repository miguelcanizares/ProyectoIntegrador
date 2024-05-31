package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.dam.control.ProgralingoListener;



public class PConsultarUsuarios extends JPanel {
	private static final int ALTO = 430;
	private static final int ANCHO = 720;

	public static final String TODAS = "TODAS";
	
	private JTable tblRestaurantes;
	private JComboBox<String> cmbLenguajes;
	private JButton btnConsultar;
	private JScrollPane scrpUsuarios;
	private DefaultComboBoxModel<String> dcbmDist;
	private DefaultComboBoxModel<String> dcbmReg;
	private DefaultTableModel tModel;
	private JButton btnEliminar;
	private JLabel lblRankingUsu;
	
	public PConsultarUsuarios() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setSize(ANCHO, ALTO);
		
		JLabel lblConsulta = new JLabel("RANKING");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsulta.setBounds(15, 16, 300, 20);
		add(lblConsulta);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(35, 52, 149, 20);
		add(lblFiltro);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setBounds(61, 85, 64, 20);
		add(lblLenguaje);
		
		cmbLenguajes = new JComboBox<String>();
		dcbmReg = new DefaultComboBoxModel<String>();
		cmbLenguajes.setModel(dcbmReg);
		cmbLenguajes.setBounds(140, 82, 212, 26);
		add(cmbLenguajes);
		dcbmDist = new DefaultComboBoxModel<String>();
		dcbmDist.addElement(TODAS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(525, 125, 133, 29);
		add(btnConsultar);
		
		lblRankingUsu = new JLabel("RANKING USUARIOS");
		lblRankingUsu.setVisible(false);
		lblRankingUsu.setBounds(35, 134, 218, 20);
		add(lblRankingUsu);
		
		scrpUsuarios = new JScrollPane();
		scrpUsuarios.setVisible(false);
		scrpUsuarios.setBounds(61, 169, 597, 175);
		add(scrpUsuarios);
		
		tblRestaurantes = new JTable();
		tblRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblRestaurantes.setBounds(0, 0, 1, 1);
		scrpUsuarios.setViewportView(tblRestaurantes);
		
		
		
		
	}

	public void setControlador(ProgralingoListener controlador) {
		// TODO Auto-generated method stub
		
	}

	
	
}
