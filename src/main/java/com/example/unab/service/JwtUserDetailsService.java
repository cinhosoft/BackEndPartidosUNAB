/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.service;

import com.example.unab.Model.Usuario;
import com.example.unab.RepositorioJPA.IUsuarioRepository;
import java.util.ArrayList;
import static org.apache.tomcat.jni.User.username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marlon
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public Usuario save(Usuario user) {
       
        Usuario usuario=new Usuario();
        usuario.setNombre(user.getNombre());
        usuario.setCorreo(user.getCorreo());
        usuario.setUsername(user.getUsername());
        usuario.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepo.save(usuario);
    }

}
