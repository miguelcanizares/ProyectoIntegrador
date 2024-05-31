package com.dam.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.dam.control.ProgralingoListener;
import com.dam.model.data.Usuario;


public class Registro extends JPanel {
	
	public static final String ACT_CMN_BTN_CANCELAR = "Cancelar";
	public static final String ACT_CMN_BTN_ACEPTAR = "Aceptar";
	private static final int ANCHO = 500;
	private static final int ALTO = 350;
	private JTextField txtNombre;
	private JPasswordField pssPwd;
	private JPasswordField pssPwd2;
	private JButton btnOK;
	
	private JButton btnCancel;

	public Registro() {
		configurarPanel();
		inicializarComponentes();
	}
	
	private void configurarPanel() {
		setLayout(null); // Usando un diseño absoluto, aunque se recomienda un diseño más flexible como BorderLayout o GridLayout
		setSize(ANCHO, ALTO);
	}

	private void inicializarComponentes() {
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(27, 29, 65, 14);
		add(lblUsuario);
		
		JLabel lblPwd = new JLabel("Contraseña");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPwd.setBounds(27, 139, 91, 14);
		add(lblPwd);
		
		JLabel lblConfirPwd = new JLabel("Confirmar contraseña");
		lblConfirPwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirPwd.setBounds(27, 194, 125, 14);
		add(lblConfirPwd);
		
		btnOK = new JButton(ACT_CMN_BTN_ACEPTAR);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOK.setBounds(90, 255, 107, 28);
		add(btnOK);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(179, 26, 257, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		pssPwd = new JPasswordField();
		pssPwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pssPwd.setBounds(179, 136, 257, 20);
		add(pssPwd);
		
		pssPwd2 = new JPasswordField();
		pssPwd2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pssPwd2.setBounds(179, 191, 257, 20);
		add(pssPwd2);
		
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(287, 255, 107, 28);
		add(btnCancel);
	}

	
	public void hacerVisible() {
		setVisible(true);
	}
	public JButton getBtnOK() {
		return btnOK;
	}
	
	public void setControlador(ProgralingoListener controlador) {
		btnOK.addActionListener(controlador);
		
	}
	public Usuario obtenerUsuario() {
		Usuario u = null;
		
		String nombre = txtNombre.getText().trim();
		String contraseña = new String(pssPwd.getPassword());
        String contraseña2 = new String(pssPwd2.getPassword());
	
	        if (nombre.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe introducir el nombre del restaurante", 
	                    "Error de datos", JOptionPane.ERROR_MESSAGE);
	            
	        } else if (contraseña.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe introducir la contraseña", 
	                    "Error de datos", JOptionPane.ERROR_MESSAGE);
	        } else if (contraseña2.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe introducir la contraseña", 
	                    "Error de datos", JOptionPane.ERROR_MESSAGE);
	        } else if (!contraseña.equals(contraseña2) ) {
	            JOptionPane.showMessageDialog(this, "Las contraseñas deben coincidir", 
	                    "Error de datos", JOptionPane.ERROR_MESSAGE);
	                
	        
	        } else {
	        	JOptionPane.showMessageDialog(this, "Informacion correcta", 
	                    "Consulta de datos", JOptionPane.INFORMATION_MESSAGE);
	        	
	            u = new Usuario(nombre, contraseña);
	   
		
	
	}
	        return u;
}
}
