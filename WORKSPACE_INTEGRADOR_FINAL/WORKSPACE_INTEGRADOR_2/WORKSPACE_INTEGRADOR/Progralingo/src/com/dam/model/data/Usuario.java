package com.dam.model.data;

public class Usuario {
	private String nombre;
	private String contraseña;
	
	public Usuario(String nombre, String contraseña) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContraseña() {
		return contraseña;
	}
	
	

}
