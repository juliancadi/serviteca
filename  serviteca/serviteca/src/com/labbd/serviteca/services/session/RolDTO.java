package com.labbd.serviteca.services.session;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the TB_ROL database table.
 * 
 */

public class RolDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String codigo;

	private String descripcion;

	private String nombre;


	private List<UsuarioDTO> tbUsuarios;

    public RolDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioDTO> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<UsuarioDTO> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}
	
}