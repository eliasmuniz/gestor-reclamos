package com.reclamos.gestor.persistence;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.repository.ClaimRepository;
import com.reclamos.gestor.persistence.crud.ReclamoCrudRepository;
import com.reclamos.gestor.persistence.entity.Reclamo;
import com.reclamos.gestor.persistence.mapper.ClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReclamoRepository implements ClaimRepository {
    @Autowired
    private ReclamoCrudRepository reclamoCrudRepository;

    @Autowired
    private ClaimMapper mapper;

    @Override
    public List<Claim> getAll(){
        List<Reclamo> reclamos = (List<Reclamo>) reclamoCrudRepository.findAll();
        return mapper.toClaims(reclamos);
    }

    @Override
    public Optional<Claim> getClaim(int claimId){
        return reclamoCrudRepository.findById(claimId).map(reclamo->mapper.toClaim(reclamo));
    }

    @Override
    public void delete(int productId){
        reclamoCrudRepository.deleteById(productId);
    }

    @Override
    public Claim save(Claim claim) {
        Reclamo reclamo = mapper.toReclamo(claim);
        return mapper.toClaim(reclamoCrudRepository.save(reclamo));
    }
}
