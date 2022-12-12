package com.reclamos.gestor.web.controller;


import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.service.ClaimService;
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
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    @ApiOperation("Get all claims")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Claims not found"),
    })
    public ResponseEntity<List<Claim>> getAll(){
        return new ResponseEntity<>(claimService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @ApiOperation("Search a claim by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Claim not found"),
    })
    public ResponseEntity<Claim> getClaim(@ApiParam(value= "The id of the claim", required = true, example = "1") @PathVariable("id") int claimId){
        return claimService.getClaim(claimId)
                .map(claim -> new ResponseEntity<>(claim, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByUserId/{idUser}")
    @ApiOperation("Get All claim by userId")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Claim not found"),
    })
    public ResponseEntity<List<Claim>> getClaimsByUserId(@PathVariable("idUser") int userId) {
        return claimService.getClaimsByUserId(userId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/add")
    public ResponseEntity<Claim> save(@RequestBody Claim claim){
        return new ResponseEntity<>(claimService.save(claim), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int claimId){
        if(claimService.delete(claimId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
