package com.reclamos.gestor.domain.service;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {
    // Inyección del claim repository

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> getAll(){
        return claimRepository.getAll();
    }

    public Optional<Claim> getClaim(int claimId){
        return claimRepository.getClaim(claimId);
    }
    public Optional<List<Claim>> getClaimsByUserId(int userId){
        return claimRepository.getClaimsByUserId(userId);
    }

    public Claim save(Claim claim){
        return claimRepository.save(claim);
    }

    public boolean delete(int claimId){
        return getClaim(claimId).map(claim -> {
            claimRepository.delete(claimId);
            return true;
        }).orElse(false);
    }
}
