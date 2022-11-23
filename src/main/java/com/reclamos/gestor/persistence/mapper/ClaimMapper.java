package com.reclamos.gestor.persistence.mapper;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.persistence.entity.Reclamo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClaimMapper {
    @Mappings({
            @Mapping(source = "idReclamo", target = "claimId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "titulo", target = "title"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "fechaCreacion", target = "createdAt"),
    })
    Claim toClaim(Reclamo reclamo);

    List<Claim> toClaims(List<Reclamo> reclamos);

    @InheritInverseConfiguration
    Reclamo toReclamo(Claim claim);
}
