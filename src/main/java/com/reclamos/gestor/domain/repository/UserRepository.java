package com.reclamos.gestor.domain.repository;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();

    Optional<User> getUser(int userId);


    Optional<User> getByEmail(String email);


    User save(User user);

    void delete(int userId);
}
