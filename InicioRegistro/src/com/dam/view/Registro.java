package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

//import com.dam.control.VLoginListener;
//import com.dam.model.DatosUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {
	
	public static final String ACT_CMN_BTN_CANCELAR = "Cancelar";
	public static final String ACT_CMN_BTN_ACEPTAR = "Aceptar";
	private static final int ANCHO = 500;
	private static final int ALTO = 350;
	private JTextField txtUsuario;
	private JPasswordField pssPwd;
	private JPasswordField pssPwd2;
	private JButton btnOK;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnCancel;

	public Registro() {
		super("Registro de usuario");
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
		lblUsuario.setBounds(27, 29, 65, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblPwd = new JLabel("Contraseña");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPwd.setBounds(27, 139, 91, 14);
		getContentPane().add(lblPwd);
		
		JLabel lblConfirPwd = new JLabel("Confirmar contraseña");
		lblConfirPwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirPwd.setBounds(27, 194, 125, 14);
		getContentPane().add(lblConfirPwd);
		
		btnOK = new JButton(ACT_CMN_BTN_ACEPTAR);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOK.setBounds(90, 255, 107, 28);
		getContentPane().add(btnOK);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(179, 26, 257, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pssPwd = new JPasswordField();
		pssPwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pssPwd.setBounds(179, 136, 257, 20);
		getContentPane().add(pssPwd);
		
		pssPwd2 = new JPasswordField();
		pssPwd2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pssPwd2.setBounds(179, 191, 257, 20);
		getContentPane().add(pssPwd2);
		
		lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setBounds(27, 84, 119, 14);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(179, 81, 257, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(287, 255, 107, 28);
		getContentPane().add(btnCancel);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
