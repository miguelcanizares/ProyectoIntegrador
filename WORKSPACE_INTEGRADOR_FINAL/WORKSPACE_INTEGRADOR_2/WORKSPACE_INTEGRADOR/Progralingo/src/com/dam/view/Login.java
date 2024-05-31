package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.dam.control.ProgralingoListener;

import com.dam.model.data.Usuario;

//import com.dam.control.VLoginListener;
//import com.dam.model.DatosUsuario;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Login extends JPanel {
	public static final String ACT_CMN_BTN_REGISTRAR = "Registrar";
	public static final String ACT_CMN_BTN_ACCEDER = "Acceder";
	private static final int ANCHO = 350;
	private static final int ALTO = 200;
	private JTextField txtUsuario;
	private JPasswordField psswPassword;
	private JButton btnLogin;

	
	public Login() {
	
		
		configurarFrame();
		
		inicializarComponentes();
	}
	
	private void configurarFrame() {
		setLayout(null);
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		setLocation((pantalla.width - ANCHO) / 2,  (pantalla.height - ALTO) / 2);
	}
	
	private void inicializarComponentes() {
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(30, 27, 64, 14);
		add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(30, 68, 94, 14);
		add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(124, 24, 180, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		psswPassword = new JPasswordField();
		psswPassword.setBounds(124, 65, 180, 20);
		add(psswPassword);
		
		btnLogin = new JButton(ACT_CMN_BTN_ACCEDER);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(45, 109, 100, 25);
		add(btnLogin);
		
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	

	public Usuario getUsuario() {
		String user = txtUsuario.getText().trim();
		Usuario usuario = null;
		
		if (user.isEmpty()) {
			mostrarMensaje("Debe introducir el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			@SuppressWarnings("deprecation")
			String pwd = psswPassword.getText().trim();
			
			if (pwd.isEmpty()) {
				mostrarMensaje("Debe introducir la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				usuario = new Usuario(user, pwd);
			}
		}
		return usuario;
		
	}
	public void mostrarMensaje(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}
	public void setUsuario(String usuario) {
		txtUsuario.setText(usuario);
		// limpiar password
		psswPassword.setText("");
		
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setControlador(ProgralingoListener controlador) {
		btnLogin.addActionListener(controlador);
		
	}
}
