package com.reclamos.gestor.web.controller;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.Reply;
import com.reclamos.gestor.domain.service.ClaimService;
import com.reclamos.gestor.domain.service.ReplyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping()
    @ApiOperation("Get all replies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Replies not found"),
    })
    public ResponseEntity<List<Reply>> getAll(){
        return new ResponseEntity<>(replyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @ApiOperation("Search a claim by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Claim not found"),
    })
    public ResponseEntity<Reply> getReply(@ApiParam(value= "The id of the claim", required = true, example = "1") @PathVariable("id") int replyId){
        return replyService.getReply(replyId)
                .map(reply -> new ResponseEntity<>(reply, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByClaimId/{claimId}")
    @ApiOperation("Get All claim by userId")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Claim not found"),
    })
    public ResponseEntity<List<Reply>> getClaimsByUserId(@PathVariable("claimId") int claimId) {
        return replyService.getRepliesByClaimId(claimId)
                .map(replies -> new ResponseEntity<>(replies, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/add")
    public ResponseEntity<Reply> save(@RequestBody Reply reply){
        return new ResponseEntity<>(replyService.save(reply), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int replyId){
        if(replyService.delete(replyId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
