package com.app.microservicio.alquiler.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.commons.alquiler.models.entity.Alquiler;


@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, Long> {
	
	//@Query("select a  from Alquiler a join fetch a.clientes c where c.nombre like %?1%")
	@Query("select a  from Alquiler a join fetch a.clientes c where c.nombre=?1 and c.apellido=?2 or c.documento=?3")
	public List<Alquiler> findAlquilerByClienteNombreAndApellidoOrDocumento(String term,String apellido, String documento);
	@Query("select a  from Alquiler a join fetch a.juegos j where j.titulo=?1")
	public List<Alquiler> findAlquilerByJuegoTitulo(String term);

}
