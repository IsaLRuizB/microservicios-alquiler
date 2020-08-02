package com.app.microservicio.alquiler.service;

import java.util.List;

import com.app.commons.alquiler.models.entity.Alquiler;
import com.common.microservicios.service.CommonsService;

public interface AlquilerService extends CommonsService<Alquiler>{
	
	public List<Alquiler> findAlquilerByClienteNombreAndApellidoOrDocumento(String term, String apellido, String doc);

	public List<Alquiler> findAlquilerByJuegoTitulo(String term);
}
