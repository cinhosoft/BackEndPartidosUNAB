/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.service;

import com.example.unab.Model.Partido;
import com.example.unab.Model.PartidoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Marlon
 */
public interface IPartidoService {
    
    public Iterable<Partido> findAll();
    public Page<Partido> findAll(Pageable pagenable);
    public Optional<Partido> findById(Integer id);
    public Partido save(PartidoDTO partido);
    public Partido update(Partido partido);
    public void deletePartidoById(Integer id);
    
}
