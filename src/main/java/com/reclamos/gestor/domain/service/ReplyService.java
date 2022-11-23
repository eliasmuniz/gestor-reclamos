package com.reclamos.gestor.domain.service;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.Reply;
import com.reclamos.gestor.domain.repository.ClaimRepository;
import com.reclamos.gestor.domain.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getAll(){
        return replyRepository.getAll();
    }

    public Optional<Reply> getReply(int replyId){
        return replyRepository.getReply(replyId);
    }

    public Reply save(Reply reply){
        return replyRepository.save(reply);
    }

    public boolean delete(int replyId){
        return getReply(replyId).map(reply -> {
            replyRepository.delete(replyId);
            return true;
        }).orElse(false);
    }
}
