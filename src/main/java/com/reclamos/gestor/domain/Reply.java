package com.reclamos.gestor.domain;


import org.mapstruct.Mapping;

import java.time.LocalDateTime;

public class Reply {
    private int replyId;
    private int claimId;
    private int userId;
    private String description;
    private LocalDateTime dateReply;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateReply() {
        return dateReply;
    }

    public void setDateReply(LocalDateTime dateReply) {
        this.dateReply = dateReply;
    }
}
