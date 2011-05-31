package com.labbd.serviteca.services.session;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the TB_USUARIO database table.
 * 
 */

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String nombre;

	private String clave;

	private List<RolDTO> tbRols;

    public UsuarioDTO() {
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

	public List<RolDTO> getTbRols() {
		return this.tbRols;
	}

	public void setTbRols(List<RolDTO> tbRols) {
		this.tbRols = tbRols;
	}
	
}