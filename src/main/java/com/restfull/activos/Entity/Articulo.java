package com.restfull.activos.Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "articulos")
@Entity
public class Articulo implements Serializable {

	@GeneratedValue
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "articulo_nombre")
	private String articuloNombre;
	
	@Column(name = "fecha_compra")
	private Date fechaCompra;
	
	@Column(name = "valor_compra")
	private int valorCompra;

	@Column(name = "tipo_articulo")
	private String tipoArticulo;

	@Column(name = "serial")
	private String serial;

	public Articulo() {

	}

	public Articulo(int id, String articuloNombre, Date fechaCompra, int valorCompra, String tipoArticulo,
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

	public void setFecha_compra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getValorCompra() {
		return valorCompra;
	}

	public void setValor_compra(int valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getTipoArticulo() {
		return tipoArticulo;
	}

	public void setTipo_articulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
}
