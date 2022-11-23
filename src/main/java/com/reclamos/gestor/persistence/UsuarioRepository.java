package com.reclamos.gestor.persistence;

import com.reclamos.gestor.domain.Reply;
import com.reclamos.gestor.domain.User;
import com.reclamos.gestor.domain.repository.ClaimRepository;
import com.reclamos.gestor.domain.repository.UserRepository;
import com.reclamos.gestor.persistence.crud.RespuestaCrudRepository;
import com.reclamos.gestor.persistence.crud.UsuarioCrudRepository;
import com.reclamos.gestor.persistence.entity.Respuesta;
import com.reclamos.gestor.persistence.entity.Usuario;
import com.reclamos.gestor.persistence.mapper.ReplyMapper;
import com.reclamos.gestor.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll(){
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> getUser(int userId){
        return usuarioCrudRepository.findById(userId).map(usuario->mapper.toUser(usuario));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return usuarioCrudRepository.findByEmail(email).map(usuario->mapper.toUser(usuario));
    }

    @Override
    public void delete(int productId){
        usuarioCrudRepository.deleteById(productId);
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }
}
