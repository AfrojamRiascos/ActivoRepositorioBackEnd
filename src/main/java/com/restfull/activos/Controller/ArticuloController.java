package com.restfull.activos.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restfull.activos.Entity.Articulo;
import com.restfull.activos.Models.ArticuloModel;
import com.restfull.activos.Services.ArticuloService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/activos")
public class ArticuloController {

	@Autowired
	@Qualifier("articuloService")
	ArticuloService articuloService;

	@PostMapping("/addArticulos")
	public ResponseEntity<Articulo> addArticulo(@RequestBody @Validated Articulo articulo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloService.Crear(articulo));
	}

	@GetMapping("/listArticulos")
	public List<ArticuloModel> listArticulos() {
		return articuloService.listaArticulo();
	}

	
	@GetMapping("/listTipos")
	public ResponseEntity<List<ArticuloModel>> obtenerTipos(@RequestParam(name = "tipo", required = false) String tipo) {
		List<ArticuloModel> tipoarticulos = articuloService.listaTipoArticulo(tipo);
		if (tipoarticulos.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
		}
		return ResponseEntity.ok(tipoarticulos);
	}


	@PutMapping("/updateArticulos")
	public ResponseEntity<Articulo> updateArticulo(@RequestBody @Validated Articulo articulo) {
		return ResponseEntity.status(HttpStatus.OK).body(articuloService.Editar(articulo));
	}


	/*
	 * @GetMapping("/tipoarticulos") public List<ArticuloModel>
	 * listArticuloTipoFechaSerial(String tipo, Date fecha, String serial) { return
	 * articuloService.listaTipoFechaSerial(tipo, fecha, serial); }
	 */

	@GetMapping("/tipoarticulos")
	public List<ArticuloModel> listArticuloTipoFechaSerial(String tipo, Date fecha, String serial) {
		return articuloService.listaTipoFechaSerial(tipo, fecha, serial);
	}

	@GetMapping("/tipo")
	public ResponseEntity<List<ArticuloModel>> obtenerTipoFchaSerie(@RequestParam(name = "tipo", required = false) String tipo, 
			@RequestParam(name = "fecha", required = false) Date fecha,
			@RequestParam(name = "serial", required = false)String serial) {
		List<ArticuloModel> articulos = articuloService.listaTipoFechaSerial(tipo, fecha, serial);
		if (articulos.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
		}
		return ResponseEntity.ok(articulos);
	}

	@DeleteMapping("/delteArticulo/{id}/{nombre}")
	public boolean deleteArticulo(@PathVariable("id") int id, @PathVariable("nombre") String nombre) {
		return articuloService.Eliminar(nombre, id);
	}

	
	@GetMapping(path = "/porIdtipo/{id}")
	public List<ArticuloModel> porId(int id) {
		return articuloService.ariculoPorId(id);
	}

}
