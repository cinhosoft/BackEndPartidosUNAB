/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.Controller;

import com.example.unab.Model.Equipo;
import com.example.unab.RepositorioJPA.IEquipoRepository;
import com.example.unab.service.IEquipoService;
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
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/equipo")
public class EquipoRestController {

    @Autowired
    private IEquipoService equipoService;

    //crear nuevo usuario
    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> create(@RequestBody Equipo equipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.save(equipo));
    }

    //actualizar
    @PutMapping("/{id}")    
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> update(@RequestBody Equipo newEquipo, @PathVariable(value = "id") Integer id) {
        Optional<Equipo> oEquipo = equipoService.findById(id);
        if (!oEquipo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        oEquipo.get().setNombre(newEquipo.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.save(oEquipo.get()));
    }
    
    //borrar
    @DeleteMapping("/{id}")    
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id){
        if(!equipoService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        equipoService.deleteEquipoById(id);
        return ResponseEntity.ok().build();
    }

    //leer un equipo
    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> read(@PathVariable(value = "id") Integer id) {
        Optional<Equipo> oEquipo = equipoService.findById(id);
        if (!oEquipo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oEquipo);
    }

    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<Equipo> readAll() {
        List<Equipo> equipos = StreamSupport
                     .stream(equipoService.findAll().spliterator(),false)
                     .collect(Collectors.toList());
        return equipos;
    }

}
