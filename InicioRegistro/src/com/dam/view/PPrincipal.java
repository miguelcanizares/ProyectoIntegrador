package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class PPrincipal extends JPanel {
	private JLabel lblProgralingo;
	private JLabel lblEligeUnaDe;
	private JLabel lblUsuario;
	private JButton btnRegistro;
	private JButton btnInicioSesion;
	public PPrincipal() {
		setLayout(null);
		
		lblProgralingo = new JLabel("PROGRALINGO");
		lblProgralingo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProgralingo.setBounds(160, 11, 135, 22);
		add(lblProgralingo);
		
		lblUsuario = new JLabel("USUARIO.");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(10, 73, 92, 33);
		add(lblUsuario);
		
		lblEligeUnaDe = new JLabel("Elige una de las siguientes opciones:");
		lblEligeUnaDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEligeUnaDe.setBounds(10, 103, 219, 33);
		add(lblEligeUnaDe);
		
		btnRegistro = new JButton("Regístrate");
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistro.setBounds(35, 187, 125, 72);
		add(btnRegistro);
		
		btnInicioSesion = new JButton("Inicia Sesión");
		btnInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInicioSesion.setBounds(279, 187, 125, 72);
		add(btnInicioSesion);
	}
}
