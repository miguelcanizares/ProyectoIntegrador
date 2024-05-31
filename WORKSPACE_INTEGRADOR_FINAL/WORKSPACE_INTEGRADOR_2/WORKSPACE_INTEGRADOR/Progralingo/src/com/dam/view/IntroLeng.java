package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import com.dam.control.ProgralingoListener;

public class IntroLeng extends JPanel {
    private JButton btnPython;
    private JButton btnJavaS;
    private JButton btnJava;
    private JButton btnCplus;

    public IntroLeng() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        btnCplus = new JButton("");
        btnCplus.setBackground(Color.WHITE);
        btnCplus.setIcon(new ImageIcon(IntroLeng.class.getResource("/img/c++.jpg")));
        btnCplus.setBounds(69, 24, 100, 100);
        add(btnCplus);
        
        btnJava = new JButton("");
        btnJava.setIcon(new ImageIcon(IntroLeng.class.getResource("/img/javaP.jpg")));
        btnJava.setBounds(267, 21, 100, 100);
        add(btnJava);
        
        btnJavaS = new JButton("");
        btnJavaS.setIcon(new ImageIcon(IntroLeng.class.getResource("/img/c#.jpg")));
        btnJavaS.setBounds(69, 143, 100, 100);
        add(btnJavaS);
        
        btnPython = new JButton("");
        btnPython.setIcon(new ImageIcon(IntroLeng.class.getResource("/img/python.jpg")));
        btnPython.setBounds(267, 142, 100, 100);
        add(btnPython);
    }

    public void hacerVisible() {
        setVisible(true);
    }

    public JButton getBtnCplus() {
        return btnCplus;
    }

    public JButton getBtnJava() {
        return btnJava;
    }

    public JButton getBtnJavaScript() {
        return btnJavaS;
    }

    public JButton getBtnPhyton() {
        return btnPython;
    }

    public void setControlador(ProgralingoListener controlador) {
        btnCplus.addActionListener(controlador);
        btnJava.addActionListener(controlador);
        btnJavaS.addActionListener(controlador);
        btnPython.addActionListener(controlador);
    }
}

