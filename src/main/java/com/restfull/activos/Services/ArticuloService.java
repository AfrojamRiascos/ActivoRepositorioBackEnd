package com.restfull.activos.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.restfull.activos.Converter.ArticuloConverter;
import com.restfull.activos.Entity.Articulo;
import com.restfull.activos.Models.ArticuloModel;
import com.restfull.activos.Repository.ArticuloRepository;

@Service("articuloService")
public class ArticuloService {

	@Autowired
	@Qualifier("ArticuloReposirory")
	private ArticuloRepository articuloRepo;

	@Autowired
	@Qualifier("ArticuloConverter")
	private ArticuloConverter articuloConvert;

	public Articulo Crear(Articulo articulo) {

		try {
			return articuloRepo.save(articulo);
			// System.out.println("Información guardada con Éxito!");
			// return true;
		} catch (Exception e) {
			System.out.println("Error al guardar la información!");
			// return false;
		}
		return null;
	}

	public Articulo Editar(Articulo articulo) {

		try {
			return articuloRepo.save(articulo);
			//System.out.println("Información actualizada con Éxito!");
			//return true;
		} catch (Exception e) {
			//System.out.println("Error al actualizar la información!");
			//return false;
		}
		return null;
	}

	public boolean Eliminar(String nombreArticulo, int id) {

		try {
			Articulo articulo = articuloRepo.findByArticuloNombreAndId(nombreArticulo, id);
			articuloRepo.delete(articulo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<ArticuloModel> listaArticulo(){
		/**List<ArticuloModel> articluloModelList = null;
		List<Articulo> listaArticulos = articuloRepo.findAll();**/
		return articuloConvert.ListConverter(articuloRepo.findAll());		
	}
	
	public List<ArticuloModel> listaTipoFechaSerial(String tipo, Date fecha, String serial){
		return articuloConvert.ListConverter(articuloRepo.findByTipoArticuloAndFechaCompraAndSerial(tipo, fecha, serial));

	}
	
	public List<ArticuloModel> listaTipoArticulo(String tipoArticulo){
		return articuloConvert.ListConverter(articuloRepo.findByTipoArticulo(tipoArticulo));
	}
	
	public List<ArticuloModel> ariculoPorId(int id) {
		return articuloConvert.ListConverter(articuloRepo.findById(id));

	}
}
