/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.Controller;

import com.example.unab.Model.Equipo;
import com.example.unab.Model.Partido;
import com.example.unab.Model.PartidoDTO;
import com.example.unab.Model.Usuario;
import com.example.unab.RepositorioJPA.IEquipoRepository;
import com.example.unab.RepositorioJPA.IUsuarioRepository;
import com.example.unab.service.IPartidoService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marlon
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/partido")
public class PartidoRestController {

    @Autowired
    private IPartidoService partidoService;
    @Autowired
    private IEquipoRepository equipoService;
    @Autowired
    private IUsuarioRepository usuarioService;
    //crear nuevo
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PartidoDTO partido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoService.save(partido));
    }

    //actualizar
    @PutMapping("/{id}")
    @CrossOrigin(origins = "/*")
    public ResponseEntity<?> update(@RequestBody PartidoDTO newPartido, @PathVariable(value = "id") Integer id) {
        Optional<Partido> oPartido = partidoService.findById(id);
        if (!oPartido.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if(newPartido.getFecha() !=null){
            oPartido.get().setFecha(newPartido.getFecha());
        }
        oPartido.get().setGoles_local(newPartido.getGoles_local());
        oPartido.get().setGoles_visitante(newPartido.getGoles_visitante());
         
        Optional<Equipo> oEquipoLocal = equipoService.findById(newPartido.getLocal());
        if(oEquipoLocal.isPresent()){
             oPartido.get().setLocal(oEquipoLocal.get());
        }
        Optional<Equipo> oEquipoVisitante = equipoService.findById(newPartido.getVisitante());
        if(oEquipoVisitante.isPresent()){
             oPartido.get().setVisitante(oEquipoVisitante.get());
        }
        Optional<Usuario> oUsuario = usuarioService.findById(newPartido.getUsuario());
        if(oUsuario.isPresent()){
             oPartido.get().setUsuario(oUsuario.get());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoService.update(oPartido.get()));
    }
    
    //borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id){
        if(!partidoService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        partidoService.deletePartidoById(id);
        return ResponseEntity.ok().build();
    }

    //leer un equipo
    @GetMapping("/{id}")
     @CrossOrigin(origins = "/*")
    public ResponseEntity<?> read(@PathVariable(value = "id") Integer id) {
        Optional<Partido> oEquipo = partidoService.findById(id);
        if (!oEquipo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oEquipo);
    }

    @GetMapping()
    public List<Partido> readAll() {
        List<Partido> partidos = StreamSupport
                     .stream(partidoService.findAll().spliterator(),false)
                     .collect(Collectors.toList());
        return partidos;
    }

}
