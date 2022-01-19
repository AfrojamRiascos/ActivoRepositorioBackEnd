package com.restfull.activos.Models;

import java.sql.Date;

import com.restfull.activos.Entity.Articulo;

public class ArticuloModel {

	private int id;
	private String articuloNombre;
	private Date fechaCompra;
	private int valorCompra;
	private String tipoArticulo;
	private String serial;

	public ArticuloModel() {

	}

	public ArticuloModel(Articulo articulo) {
		this.id = articulo.getId();
		this.articuloNombre = articulo.getArticuloNombre();
		this.fechaCompra = articulo.getFechaCompra();
		this.valorCompra = articulo.getValorCompra();
		this.tipoArticulo = articulo.getTipoArticulo();
		this.serial = articulo.getSerial();
	}

	public ArticuloModel(int id, String articuloNombre, Date fechaCompra, int valorCompra, String tipoArticulo,
			String serial) {
		this.id = id;
		this.articuloNombre = articuloNombre;
		this.fechaCompra = fechaCompra;
		this.valorCompra = valorCompra;
		this.tipoArticulo = tipoArticulo;
		this.serial = serial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticuloNombre() {
		return articuloNombre;
	}

	public void setArticuloNombre(String articuloNombre) {
		this.articuloNombre = articuloNombre;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(int valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getTipoArticulo() {
		return tipoArticulo;
	}

	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
}
