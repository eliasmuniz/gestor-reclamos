package com.reclamos.gestor.persistence.mapper;

import com.reclamos.gestor.domain.Role;
import com.reclamos.gestor.persistence.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(source = "idRol", target = "roleId"),
            @Mapping(source = "nombre", target = "name"),
    })
    Role toRole(Rol rol);

    List<Role> toRoles(List<Rol> roles);

    @InheritInverseConfiguration
    Rol toRol(Role role);
}
