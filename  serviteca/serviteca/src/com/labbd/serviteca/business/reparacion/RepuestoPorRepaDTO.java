package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_REPUESTO_POR_REPA database table.
 * 
 */

public class RepuestoPorRepaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal cantidad;

	private BigDecimal costoVenta;


	private ReparacionDTO tbReparacion;


	private RepuestoDTO tbRepuesto;

    public RepuestoPorRepaDTO() {
    }

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCostoVenta() {
		return this.costoVenta;
	}

	public void setCostoVenta(BigDecimal costoVenta) {
		this.costoVenta = costoVenta;
	}

	public ReparacionDTO getTbReparacion() {
		return this.tbReparacion;
	}

	public void setTbReparacion(ReparacionDTO tbReparacion) {
		this.tbReparacion = tbReparacion;
	}
	
	public RepuestoDTO getTbRepuesto() {
		return this.tbRepuesto;
	}

	public void setTbRepuesto(RepuestoDTO tbRepuesto) {
		this.tbRepuesto = tbRepuesto;
	}
	
}