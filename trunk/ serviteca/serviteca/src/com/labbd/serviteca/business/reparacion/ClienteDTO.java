package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the TB_CLIENTE database table.
 * 
 */

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String cedula;

	private String apellido;

	private String email;

	private String nombre;


	private String telFijo;


	private String telMovil;


	private List<AutomovilDTO> tbAutomovils;

    public ClienteDTO() {
    }

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelFijo() {
		return this.telFijo;
	}

	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	public String getTelMovil() {
		return this.telMovil;
	}

	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
	}

	public List<AutomovilDTO> getTbAutomovils() {
		return this.tbAutomovils;
	}

	public void setTbAutomovils(List<AutomovilDTO> tbAutomovils) {
		this.tbAutomovils = tbAutomovils;
	}
	
}