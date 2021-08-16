/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.Controller;


import com.example.unab.RepositorioJPA.IUsuarioRepository;
import com.example.unab.Model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
 
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Marlon
 */
@RestController 
public class UsuarioRestController {
    @Autowired
    private IUsuarioRepository usuarioRepo;
    
    @GetMapping("/usuario/todos")
    public List<Usuario> todos(){
        System.out.println("Mostrar Usuarios");
        return usuarioRepo.findAll();
    }

    @PostMapping("/usuario/crear")
    public Usuario crear(
            @Param("nombre") String nombre,
            @Param("correo") String correo,
            @Param("username") String username,
            @Param("password") String password          
            
    ){
        Usuario usuario=new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuarioRepo.save(usuario);
        return usuario;
    }
}
