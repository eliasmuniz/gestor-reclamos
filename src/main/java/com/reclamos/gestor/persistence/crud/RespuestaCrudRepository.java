package com.reclamos.gestor.persistence.crud;

import com.reclamos.gestor.persistence.entity.Reclamo;
import com.reclamos.gestor.persistence.entity.Respuesta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RespuestaCrudRepository extends CrudRepository<Respuesta, Integer> {
    Optional<List<Respuesta>> findByIdReclamo(int idUsuario);
}
