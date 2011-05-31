package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the TB_ESPECIALIDAD database table.
 * 
 */

public class EspecialidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;

	private String descripcion;

	private String nombre;

	private List<MecanicoDTO> tbMecanicos;

    public EspecialidadDTO() {
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

	public List<MecanicoDTO> getTbMecanicos() {
		return this.tbMecanicos;
	}

	public void setTbMecanicos(List<MecanicoDTO> tbMecanicos) {
		this.tbMecanicos = tbMecanicos;
	}
	
}