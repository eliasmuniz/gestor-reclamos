package com.reclamos.gestor.persistence.crud;

import com.reclamos.gestor.persistence.entity.Reclamo;
import org.springframework.data.repository.CrudRepository;

public interface ReclamoCrudRepository  extends CrudRepository<Reclamo, Integer> {

}
