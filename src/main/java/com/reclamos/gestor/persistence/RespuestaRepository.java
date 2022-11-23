package com.reclamos.gestor.persistence;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.Reply;
import com.reclamos.gestor.domain.repository.ReplyRepository;
import com.reclamos.gestor.persistence.crud.ReclamoCrudRepository;
import com.reclamos.gestor.persistence.crud.RespuestaCrudRepository;
import com.reclamos.gestor.persistence.entity.Reclamo;
import com.reclamos.gestor.persistence.entity.Respuesta;
import com.reclamos.gestor.persistence.mapper.ClaimMapper;
import com.reclamos.gestor.persistence.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RespuestaRepository implements ReplyRepository {
    @Autowired
    private RespuestaCrudRepository respuestaCrudRepository;

    @Autowired
    private ReplyMapper mapper;

    @Override
    public List<Reply> getAll(){
        List<Respuesta> respuestas = (List<Respuesta>) respuestaCrudRepository.findAll();
        return mapper.toReplies(respuestas);
    }

    @Override
    public Optional<Reply> getReply(int replyId){
        return respuestaCrudRepository.findById(replyId).map(respuesta->mapper.toReply(respuesta));
    }

    @Override
    public void delete(int productId){
        respuestaCrudRepository.deleteById(productId);
    }

    @Override
    public Reply save(Reply reply) {
        Respuesta respuesta = mapper.toRespuesta(reply);
        return mapper.toReply(respuestaCrudRepository.save(respuesta));
    }
}
