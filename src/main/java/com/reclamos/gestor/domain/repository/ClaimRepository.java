package com.reclamos.gestor.domain.repository;


import com.reclamos.gestor.domain.Claim;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ClaimRepository {
    //Se definen las reglas/objetos de dominio y se desacopla la persistencia de la solución
    List<Claim> getAll();

    Optional<Claim> getClaim(int claimId);

    Claim save(Claim claim);

    void delete(int claimId);
}
