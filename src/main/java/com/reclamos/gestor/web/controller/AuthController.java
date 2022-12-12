package com.reclamos.gestor.web.controller;

import com.reclamos.gestor.domain.Claim;
import com.reclamos.gestor.domain.Reply;
import com.reclamos.gestor.domain.User;
import com.reclamos.gestor.domain.dto.AuthenticationRequest;
import com.reclamos.gestor.domain.dto.AuthenticationResponse;
import com.reclamos.gestor.domain.dto.UserDTO;
import com.reclamos.gestor.domain.service.UserGestorDetailsService;
import com.reclamos.gestor.domain.service.UserService;
import com.reclamos.gestor.web.security.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserGestorDetailsService userGestorDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/authenticate")
    public  ResponseEntity<UserDTO> createToken(@RequestBody AuthenticationRequest request){

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = userGestorDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            if(userService.getUserByEmail(request.getUsername()).isPresent()){
                UserDTO userDTO = new UserDTO();

                userDTO.setUsername(request.getUsername());
                userDTO.setJwt((new AuthenticationResponse(jwt)).getJwt());
                userDTO.setUserId(userService.getUserByEmail(request.getUsername())
                        .map(user -> user.getUserId())
                        .orElse(null));

                userDTO.setRoleId(userService.getUserByEmail(request.getUsername())
                        .map(user -> user.getRoleId())
                        .orElse(null));

                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            }else{
                UserDTO userDTO = new UserDTO();

                userDTO.setUsername(null);
                userDTO.setJwt(null);
                return new ResponseEntity<>( userDTO, HttpStatus.OK);
            }


        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

}
