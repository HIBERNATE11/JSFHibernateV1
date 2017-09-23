package com.mitocode.model;

public class Tablagorka implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;

	public Tablagorka() {
	}

	public Tablagorka(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
