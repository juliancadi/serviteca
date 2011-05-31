package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the TB_AUTOMOVIL database table.
 * 
 */

public class AutomovilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;

	private String chasis;

	private String color;

	private String linea;

	private String marca;

	private String matricula;

	private String modelo;

	private String motor;

	private String observaciones;

	private String placa;


	private ClienteDTO tbCliente;


	private List<ReparacionDTO> tbReparacions;

    public AutomovilDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLinea() {
		return this.linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMotor() {
		return this.motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public ClienteDTO getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(ClienteDTO tbCliente) {
		this.tbCliente = tbCliente;
	}
	
	public List<ReparacionDTO> getTbReparacions() {
		return this.tbReparacions;
	}

	public void setTbReparacions(List<ReparacionDTO> tbReparacions) {
		this.tbReparacions = tbReparacions;
	}
	
}