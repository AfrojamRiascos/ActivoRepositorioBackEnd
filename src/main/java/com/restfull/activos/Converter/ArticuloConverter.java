package com.restfull.activos.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restfull.activos.Entity.Articulo;
import com.restfull.activos.Models.ArticuloModel;

@Component("ArticuloConverter")
public class ArticuloConverter {
	
	public List<ArticuloModel> ListConverter(List<Articulo> articulo){
		List<ArticuloModel> articuloModel = new ArrayList<>();
		
		for(Articulo artic: articulo) {
			articuloModel.add(new ArticuloModel(artic));
		}
		return articuloModel;
	}

}
