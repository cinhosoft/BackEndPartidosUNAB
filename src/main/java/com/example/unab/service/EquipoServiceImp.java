/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.service;

import com.example.unab.Model.Equipo;
import com.example.unab.RepositorioJPA.IEquipoRepository;
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
public class EquipoServiceImp implements IEquipoService {

    @Autowired
    private  IEquipoRepository equipoRepo;
    @Override
    @Transactional(readOnly=true)
    public Iterable<Equipo> findAll() {
        return equipoRepo.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Equipo> findAll(Pageable pagenable) {
        return equipoRepo.findAll(pagenable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Equipo> findById(Integer id) {
        System.out.println("Equipo Buscado:" + id);
        return equipoRepo.findById(id);
    }

    @Override
    @Transactional
    public Equipo save(Equipo equipo) {
        return equipoRepo.save(equipo);
    }

    @Override
    @Transactional
    public void deleteEquipoById(Integer id) {
        equipoRepo.deleteById(id);
    }
    
}
