package com.reclamos.gestor.domain.repository;


import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.persistence.entity.Reclamo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ClaimRepository {
    //Se definen las reglas/objetos de dominio y se desacopla la persistencia de la solución
    List<Claim> getAll();

    Optional<Claim> getClaim(int claimId);

    Optional<List<Claim>> getClaimsByUserId(int userId);

    Claim save(Claim claim);

    void delete(int claimId);
}
