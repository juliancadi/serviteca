package com.labbd.serviteca.business.reparacion;

import java.io.Serializable;

import com.labbd.serviteca.business.factura.FacturaDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TB_REPARACION database table.
 * 
 */

public class ReparacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String codigo;

	private BigDecimal costo;


	private Date fechaIngreso;


	private Date fechaSalida;


	private List<FacturaDTO> tbFacturas;


	private AutomovilDTO tbAutomovil;


	private EstadoDTO tbEstado;


	private MecanicoDTO tbMecanico;


	private List<RepuestoPorRepaDTO> tbRepuestoPorRepas;

    public ReparacionDTO() {
    }

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public List<FacturaDTO> getTbFacturas() {
		return this.tbFacturas;
	}

	public void setTbFacturas(List<FacturaDTO> tbFacturas) {
		this.tbFacturas = tbFacturas;
	}
	
	public AutomovilDTO getTbAutomovil() {
		return this.tbAutomovil;
	}

	public void setTbAutomovil(AutomovilDTO tbAutomovil) {
		this.tbAutomovil = tbAutomovil;
	}
	
	public EstadoDTO getTbEstado() {
		return this.tbEstado;
	}

	public void setTbEstado(EstadoDTO tbEstado) {
		this.tbEstado = tbEstado;
	}
	
	public MecanicoDTO getTbMecanico() {
		return this.tbMecanico;
	}

	public void setTbMecanico(MecanicoDTO tbMecanico) {
		this.tbMecanico = tbMecanico;
	}
	
	public List<RepuestoPorRepaDTO> getTbRepuestoPorRepas() {
		return this.tbRepuestoPorRepas;
	}

	public void setTbRepuestoPorRepas(List<RepuestoPorRepaDTO> tbRepuestoPorRepas) {
		this.tbRepuestoPorRepas = tbRepuestoPorRepas;
	}
	
}