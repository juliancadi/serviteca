package com.labbd.serviteca.business.factura;

import java.io.Serializable;


import com.labbd.serviteca.business.reparacion.ReparacionDTO;

import java.math.BigDecimal;


/**
 * The persistent class for the TB_FACTURA database table.
 * 
 */

public class FacturaDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String codigo;

	private BigDecimal iva;


	private BigDecimal valorNeto;


	private BigDecimal valorTotal;


	private ReparacionDTO tbReparacion;

    public FacturaDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getValorNeto() {
		return this.valorNeto;
	}

	public void setValorNeto(BigDecimal valorNeto) {
		this.valorNeto = valorNeto;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ReparacionDTO getTbReparacion() {
		return this.tbReparacion;
	}

	public void setTbReparacion(ReparacionDTO tbReparacion) {
		this.tbReparacion = tbReparacion;
	}
	
}