package com.restfull.activos.Repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restfull.activos.Entity.Articulo;

@Repository("ArticuloReposirory")
public interface ArticuloRepository extends JpaRepository<Articulo, Serializable>{
	
	public List<Articulo> findById(int id);
	public List<Articulo> findByTipoArticulo(String tipoArticulo);
	public Articulo findByFechaCompra(Date fechaCompra);
	public Articulo findBySerial(String serial);
	public Articulo findByArticuloNombreAndId(String articuloNombre, int id);
	@Query("select a from Articulo a where a.tipoArticulo = ?1 and a.fechaCompra =?2 and a.serial = ?3")
	public List<Articulo> findByTipoArticuloAndFechaCompraAndSerial(@Param("tipoArticulo") String tipoArticulo, 
			@Param("fechaCompra") Date fechaCompra, @Param("serial")String serial);
	
}
