package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the TB_PROVEEDOR database table.
 * 
 */

public class ProveedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nit;

	private String apellidoEncargado;

	private String direccion;

	private String email;

	private String nombreEmpresa;

	private String nombreEncargado;

	private String telFijo;

	private String telMovil;

	private List<RepuestoDTO> tbRepuestos;

    public ProveedorDTO() {
    }

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getApellidoEncargado() {
		return this.apellidoEncargado;
	}

	public void setApellidoEncargado(String apellidoEncargado) {
		this.apellidoEncargado = apellidoEncargado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreEncargado() {
		return this.nombreEncargado;
	}

	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
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

	public List<RepuestoDTO> getTbRepuestos() {
		return this.tbRepuestos;
	}

	public void setTbRepuestos(List<RepuestoDTO> tbRepuestos) {
		this.tbRepuestos = tbRepuestos;
	}
	
}