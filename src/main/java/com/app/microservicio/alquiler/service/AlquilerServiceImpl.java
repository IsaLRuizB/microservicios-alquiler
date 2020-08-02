package com.app.microservicio.alquiler.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.commons.alquiler.models.entity.Alquiler;
import com.app.microservicio.alquiler.models.repository.AlquilerRepository;
import com.common.microservicios.service.CommonsServiceImpl;

@Service
public class AlquilerServiceImpl extends CommonsServiceImpl<Alquiler, AlquilerRepository> implements AlquilerService {

	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alquiler> findAlquilerByClienteNombreAndApellidoOrDocumento(String term,String apellido, String doc){
		return alquilerRepository.findAlquilerByClienteNombreAndApellidoOrDocumento(term, apellido, doc) ;		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alquiler> findAlquilerByJuegoTitulo(String term) {
		return alquilerRepository.findAlquilerByJuegoTitulo(term);
	}


	
}
