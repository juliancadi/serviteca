package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_REPUESTO database table.
 * 
 */

public class RepuestoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;

	private BigDecimal costoCompra;

	private String descripcion;

	private BigDecimal existencias;

	private String marca;

	private String nombre;


	private ProveedorDTO tbProveedor;


	private List<RepuestoPorRepaDTO> tbRepuestoPorRepas;

    public RepuestoDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getCostoCompra() {
		return this.costoCompra;
	}

	public void setCostoCompra(BigDecimal costoCompra) {
		this.costoCompra = costoCompra;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getExistencias() {
		return this.existencias;
	}

	public void setExistencias(BigDecimal existencias) {
		this.existencias = existencias;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProveedorDTO getTbProveedor() {
		return this.tbProveedor;
	}

	public void setTbProveedor(ProveedorDTO tbProveedor) {
		this.tbProveedor = tbProveedor;
	}
	
	public List<RepuestoPorRepaDTO> getTbRepuestoPorRepas() {
		return this.tbRepuestoPorRepas;
	}

	public void setTbRepuestoPorRepas(List<RepuestoPorRepaDTO> tbRepuestoPorRepas) {
		this.tbRepuestoPorRepas = tbRepuestoPorRepas;
	}
	
}