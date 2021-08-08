/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.service;

import com.example.unab.Model.Equipo;
import com.example.unab.Model.Partido;
import com.example.unab.Model.PartidoDTO;
import com.example.unab.Model.Usuario;
import com.example.unab.RepositorioJPA.IEquipoRepository;
import com.example.unab.RepositorioJPA.IPartidoRepository;
import com.example.unab.RepositorioJPA.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marlon
 */
@Service
public class PartidoServiceImp implements IPartidoService {

    @Autowired
    private IPartidoRepository partidoRepo;
    @Autowired
    private IEquipoRepository equipoRepo;
    @Autowired
    private IUsuarioRepository usuarioRepo;
    

    @Override
    @Transactional(readOnly = true)
    public Iterable<Partido> findAll() {
        return partidoRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Partido> findAll(Pageable pagenable) {
        return partidoRepo.findAll(pagenable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Partido> findById(Integer id) {
        return partidoRepo.findById(id);
    }

    @Override
    @Transactional()
    public void deletePartidoById(Integer id) {
        partidoRepo.deleteById(id);
    }

    @Override
    public Partido save(PartidoDTO partido) {
        System.out.println(partido);
        Partido newPartido = new Partido();
        newPartido.setFecha(partido.getFecha());
        newPartido.setGoles_local(partido.getGoles_local());
        newPartido.setGoles_visitante(partido.getGoles_visitante());
        Optional<Equipo> oEquipoLocal = equipoRepo.findById(partido.getLocal());
        System.out.println(oEquipoLocal);
        if(oEquipoLocal.isPresent()){
             newPartido.setLocal(oEquipoLocal.get());
        }
        Optional<Equipo> oEquipoVisitante = equipoRepo.findById(partido.getVisitante());
        if(oEquipoVisitante.isPresent()){
             newPartido.setVisitante(oEquipoVisitante.get());
        }
        Optional<Usuario> oUsuario = usuarioRepo.findById(partido.getUsuario());
        if(oUsuario.isPresent()){
             newPartido.setUsuario(oUsuario.get());
        }
       
        return partidoRepo.save(newPartido);
    }

    @Override
    public Partido update(Partido partido) {
        return partidoRepo.save(partido);
    }

}
