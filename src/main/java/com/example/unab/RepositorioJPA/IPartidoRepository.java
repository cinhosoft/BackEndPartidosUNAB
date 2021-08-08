/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.RepositorioJPA;
 
import com.example.unab.Model.Partido;
import com.example.unab.Model.PartidoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marlon
 */
@Repository
public interface IPartidoRepository extends JpaRepository<Partido, Integer>{
        //Equipo findByNombre(String nombre);
    
}
