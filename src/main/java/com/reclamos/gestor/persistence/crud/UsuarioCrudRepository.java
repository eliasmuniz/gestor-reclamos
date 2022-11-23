package com.reclamos.gestor.persistence.crud;

import com.reclamos.gestor.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository  extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
