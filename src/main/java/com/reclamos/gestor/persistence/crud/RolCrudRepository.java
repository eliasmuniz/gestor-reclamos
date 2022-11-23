package com.reclamos.gestor.persistence.crud;

import com.reclamos.gestor.persistence.entity.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolCrudRepository extends CrudRepository<Rol, Integer> {
}
