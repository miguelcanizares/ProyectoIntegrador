package com.dam.main;

import java.awt.EventQueue;

import com.dam.control.ProgralingoListener;

import com.dam.view.IntroLeng;
import com.dam.view.Login;
import com.dam.view.ModificarUsuario;
import com.dam.view.PConsultarUsuarios;
import com.dam.view.PPrincipal;
import com.dam.view.PanelOpciones;
import com.dam.view.Registro;
import com.dam.view.TestPanelC;
import com.dam.view.TestPanelP;
import com.dam.view.TestPanelJ;
import com.dam.view.TestPanelCplus;


public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				PPrincipal pp = new PPrincipal();
				
			
				Login lg = new Login();
				Registro rg = new Registro();
				ModificarUsuario mu = new ModificarUsuario();
				PanelOpciones po = new PanelOpciones();
				PConsultarUsuarios pcu = new PConsultarUsuarios();
				IntroLeng il = new IntroLeng();
				TestPanelC tpc = new TestPanelC();
				TestPanelP tpcp = new TestPanelP();
				TestPanelJ tpj = new TestPanelJ();
				TestPanelCplus tpp = new TestPanelCplus();
				
				
				ProgralingoListener controlador = new ProgralingoListener(pp);
			
				controlador.setLogin(lg);
				controlador.setRegistro(rg);
				controlador.setPo(po);
				controlador.setPcu(pcu);
				controlador.setMu(mu);
				controlador.setIl(il);
				controlador.setTpc(tpc);
				controlador.setTpcp(tpcp);
				controlador.setTpj(tpj);
				controlador.setTpp(tpp);
				
				pp.setControlador(controlador);
	
				lg.setControlador(controlador);
				rg.setControlador(controlador);
				po.setControlador(controlador);
				pcu.setControlador(controlador);
				mu.setControlador(controlador);
				il.setControlador(controlador);
				tpc.setControlador(controlador);
				tpcp.setControlador(controlador);
				tpj.setControlador(controlador);
				tpp.setControlador(controlador);
				
				pp.hacerVisible();
				
			}
		});

	}
}