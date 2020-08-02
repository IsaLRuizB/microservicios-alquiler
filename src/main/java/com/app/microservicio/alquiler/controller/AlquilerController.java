package com.app.microservicio.alquiler.controller;


import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.commons.alquiler.models.entity.Alquiler;
import com.app.microservicio.alquiler.service.AlquilerService;
import com.common.microservicios.controller.CommonController;

@RestController
public class AlquilerController extends CommonController<Alquiler, AlquilerService> {
	
	@GetMapping("/filtrar/{term}/{apellido}/{doc}")
	public ResponseEntity<?> generarBalance(@PathVariable String term, @PathVariable String apellido, @PathVariable String doc){
		return ResponseEntity.ok(service.findAlquilerByClienteNombreAndApellidoOrDocumento(term, apellido, doc));
		
	}
	
	@PostMapping(path = "/registrar")
	public ResponseEntity<?> registrarAlquiler(@RequestBody Alquiler alquiler){
		Date fecha = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, 3);// se establece como regla de negocio 3 dias para entregar			
		alquiler.setFechaEntrega(calendar.getTime());
		Alquiler entityDB = this.service.save(alquiler);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
		
	}
	
	@GetMapping("/listar/alquiler/{term}")
	public ResponseEntity<?> listarAlquilerPorJuego(@PathVariable String term){
		return ResponseEntity.ok(service.findAlquilerByJuegoTitulo(term));
		
	}

}
