package com.reclamos.gestor.domain.repository;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.Reply;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository {
    List<Reply> getAll();

    Optional<Reply> getReply(int replyId);

    Optional<List<Reply>> getRepliesByClaimId(int claimId);

    Reply save(Reply reply);

    void delete(int replyId);
}
