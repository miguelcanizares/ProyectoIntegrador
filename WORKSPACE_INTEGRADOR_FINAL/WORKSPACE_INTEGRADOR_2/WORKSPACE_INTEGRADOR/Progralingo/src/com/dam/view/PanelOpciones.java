package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.ProgralingoListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelOpciones extends JPanel {
	private JButton btnTiposLenguaje;
	private JButton btnCerrarSesion;
	private JButton btnModificarUsu;
	public PanelOpciones() {
		setSize(521, 420);
		setLayout(null);
		
		btnModificarUsu = new JButton("MODIFICAR USUARIO");
		btnModificarUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarUsu.setBounds(95, 141, 140, 69);
		add(btnModificarUsu);
		
		btnCerrarSesion = new JButton("CERRAR SESIÓN");
		btnCerrarSesion.setBounds(216, 358, 140, 35);
		add(btnCerrarSesion);
		
		btnTiposLenguaje = new JButton("TIPOS DE LENGUAJE");
		btnTiposLenguaje.setBounds(317, 141, 140, 69);
		add(btnTiposLenguaje);
		
		JLabel lblNewLabel_1 = new JLabel("BIENVENIDO A PROGRALINGO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(133, 30, 324, 48);
		add(lblNewLabel_1);
		
		JButton btnRanking = new JButton("RANKING");
		btnRanking.setBounds(216, 241, 140, 69);
		add(btnRanking);
	}
	public void hacerVisible() {
		setVisible(true);		
	}
	public JButton getBtnModificar() {
		return btnModificarUsu;
	}
	public JButton getBtnLenguajes() {
		return btnTiposLenguaje;
	}
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}
	public void setControlador(ProgralingoListener controlador) {
		btnCerrarSesion.addActionListener(controlador);
		btnModificarUsu.addActionListener(controlador);
		btnTiposLenguaje.addActionListener(controlador);
		
		
	}
}
