package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class Acceso extends JFrame {
	
	private static final int ANCHO = 350;
	private static final int ALTO = 200;

	public Acceso() {
		super("Ventana principal");
		
		configurarFrame();
		
		inicializarComponentes();
	}

	private void configurarFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		setLocation((pantalla.width - ANCHO) / 2,  (pantalla.height - ALTO) / 2);
	}

	private void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Acceso conseguido!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(88, 69, 160, 25);
		getContentPane().add(lblTitulo);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
