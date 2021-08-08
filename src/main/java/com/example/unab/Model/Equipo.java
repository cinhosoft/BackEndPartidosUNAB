/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.Model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marlon
 */
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   
    @Column(name ="nombre", length=20) 
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @OneToMany(mappedBy="local", fetch=FetchType.LAZY)
    private Set<Partido> local;
    @OneToMany(mappedBy="visitante", fetch=FetchType.LAZY)
    private Set<Partido> visitante;

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", local=" + local + ", visitante=" + visitante + '}';
    }
    
    
    
}
