package com.mitocode.model;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codUsuario;
	private String nombre;
	private String clave;	

	public Usuario() {
	}

	public Usuario(int codUsusrio, String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	public int getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {		
		this.nombre = nombre;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}	

}
