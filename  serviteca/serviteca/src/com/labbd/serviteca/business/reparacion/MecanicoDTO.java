package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_MECANICO database table.
 * 
 */

public class MecanicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cedula;

	private String apellido;

	private String email;

	private String nombre;

	private BigDecimal sueldo;

	private String telFijo;

	private String telMovil;

	private List<EspecialidadDTO> tbEspecialidades;


	private List<ReparacionDTO> tbReparaciones;

    public MecanicoDTO() {
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

	public BigDecimal getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
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

	public List<EspecialidadDTO> getTbEspecialidades() {
		return this.tbEspecialidades;
	}

	public void setTbEspecialidades(List<EspecialidadDTO> tbEspecialidades) {
		this.tbEspecialidades = tbEspecialidades;
	}
	
	public List<ReparacionDTO> getTbReparaciones() {
		return this.tbReparaciones;
	}

	public void setTbReparaciones(List<ReparacionDTO> tbReparaciones) {
		this.tbReparaciones = tbReparaciones;
	}
	
}