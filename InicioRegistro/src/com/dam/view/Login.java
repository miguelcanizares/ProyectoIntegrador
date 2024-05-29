package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

//import com.dam.control.VLoginListener;
//import com.dam.model.DatosUsuario;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Login extends JFrame {
	public static final String ACT_CMN_BTN_REGISTRAR = "Registrar";
	public static final String ACT_CMN_BTN_ACCEDER = "Acceder";
	private static final int ANCHO = 350;
	private static final int ALTO = 200;
	private JTextField txtUsuario;
	private JPasswordField psswPassword;
	private JButton btnLogin;
	private JButton btnRegistrar;
	
	public Login() {
		setTitle("Login");
		
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
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(30, 27, 64, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(30, 68, 94, 14);
		getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(124, 24, 180, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		psswPassword = new JPasswordField();
		psswPassword.setBounds(124, 65, 180, 20);
		getContentPane().add(psswPassword);
		
		btnLogin = new JButton(ACT_CMN_BTN_ACCEDER);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(45, 109, 100, 25);
		getContentPane().add(btnLogin);
		
		btnRegistrar = new JButton(ACT_CMN_BTN_REGISTRAR);
		btnRegistrar.setBounds(190, 109, 100, 25);
		getContentPane().add(btnRegistrar);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	//public void setListener(VLoginListener listener) {
		//btnLogin.addActionListener(listener);
		//btnRegistrar.addActionListener(listener);
		
//	}

	/*public DatosUsuario getDatosUsuario() {
		DatosUsuario du = null;
		
		String user = txtUsuario.getText().trim();
		String pwd = psswPassword.getText().trim();
		
		if (user.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El nombre de usuario es un dato obligatorio", 
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else if (pwd.isEmpty()) {
			JOptionPane.showMessageDialog(this, "La contraseña es un dato obligatorio", 
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else if (pwd.length() < 8) {
			JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 8 caracteres", 
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else {
			du = new DatosUsuario(user, pwd);
		}
		
		return du;
	}*/

	public void setUsuario(String usuario) {
		txtUsuario.setText(usuario);
		// limpiar password
		psswPassword.setText("");
		
	}
}
