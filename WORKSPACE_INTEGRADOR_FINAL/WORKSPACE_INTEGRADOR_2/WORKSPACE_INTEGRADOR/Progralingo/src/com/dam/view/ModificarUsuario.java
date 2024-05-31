package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.dam.control.ProgralingoListener;

import javax.swing.JLabel;
import java.awt.Font;

public class ModificarUsuario extends JPanel {
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton btnGuardar;

    public ModificarUsuario() {
        setSize(520, 420);
        setLayout(null);

        btnGuardar = new JButton("GUARDAR DATOS");
        btnGuardar.setBounds(209, 350, 140, 35);
        add(btnGuardar);

        textField = new JTextField();
        textField.setBounds(155, 83, 140, 20);
        add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("NOMBRE DE USUARIO");
        lblNewLabel.setBounds(25, 86, 107, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("ANTIGUA CONTRASEÑA");
        lblNewLabel_2.setBounds(36, 212, 136, 14);
        add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(182, 209, 86, 20);
        add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(182, 258, 86, 20);
        add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("NUEVA CONTRASEÑA");
        lblNewLabel_2_1.setBounds(36, 261, 136, 14);
        add(lblNewLabel_2_1);

        JLabel lblNewLabel_1 = new JLabel("MODIFICAR USUARIO");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(147, 21, 274, 48);
        add(lblNewLabel_1);
    }

    public void hacerVisible() {
        setVisible(true);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setControlador(ProgralingoListener controlador) {
        btnGuardar.addActionListener(controlador);
    }

    public String getNombreUsuario() {
        return textField.getText();
    }

    public String getAntiguaContrasena() {
        return textField_2.getText();
    }

    public String getNuevaContrasena() {
        return textField_3.getText();
    }
}

