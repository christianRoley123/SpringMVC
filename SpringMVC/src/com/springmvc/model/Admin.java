package com.springmvc.model;

import java.sql.Timestamp;

public class Admin {
	private int codigo;
	private String nombre;
	private String cargo;
	private Timestamp fechaCreacion;
	
	public Admin() {
		
	}
	
	
	public Admin(String nombre, String cargo, Timestamp fechaCreacion) {
		super();
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}


	


	public Admin(int codigo, String nombre, String cargo, Timestamp fechaCreacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp timestamp) {
		this.fechaCreacion = timestamp;
	}


	@Override
	public String toString() {
		StringBuilder objeto = new StringBuilder();
		objeto.append(this.codigo).append(" " + this.nombre).append(" " + this.cargo).append(" " + this.fechaCreacion);
		
		return objeto.toString() ;
	}
	
	
	

}
