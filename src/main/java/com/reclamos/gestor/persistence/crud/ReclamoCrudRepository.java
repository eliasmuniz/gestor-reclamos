package com.reclamos.gestor.persistence.crud;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.persistence.entity.Reclamo;
import com.reclamos.gestor.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReclamoCrudRepository  extends CrudRepository<Reclamo, Integer> {
    Optional<List<Reclamo>> findByIdUsuario(int userId);

}
