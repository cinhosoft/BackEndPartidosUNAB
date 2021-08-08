/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.service;

import com.example.unab.Model.Equipo;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Marlon
 */
public interface IEquipoService {
    
    public Iterable<Equipo> findAll();
    public Page<Equipo> findAll(Pageable pagenable);
    public Optional<Equipo> findById(Integer id);
    public Equipo save(Equipo equipo);
    public void deleteEquipoById(Integer id);
    
}
