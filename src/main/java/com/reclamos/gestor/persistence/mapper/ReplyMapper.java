package com.reclamos.gestor.persistence.mapper;

import com.reclamos.gestor.domain.Reply;
import com.reclamos.gestor.persistence.entity.Respuesta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {

    @Mappings({
            @Mapping(source = "idRespuesta", target = "replyId"),
            @Mapping(source = "idReclamo", target = "claimId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "fechaRespuesta", target = "dateReply"),
    })
    Reply toReply(Respuesta respuesta);

    List<Reply> toReplies(List<Respuesta> respuestas);

    @InheritInverseConfiguration
    @Mapping(target= "reclamo", ignore = true)
    @Mapping(target= "usuario", ignore = true)
    Respuesta toRespuesta(Reply reply);
}
