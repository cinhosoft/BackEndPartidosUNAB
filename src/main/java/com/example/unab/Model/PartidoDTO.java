/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.Model;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marlon
 */ 
public class PartidoDTO {
     
    private int id;
    private  Timestamp fecha;
    private int goles_local;
    private int goles_visitante;
    private int usuario;
    private int local;
    private int visitante;

    public PartidoDTO() {
    }

    public PartidoDTO(int id, Timestamp fecha, int goles_local, int goles_visitante, int usuario, int local, int visitante) {
        this.id = id;
        this.fecha = fecha;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.usuario = usuario;
        this.local = local;
        this.visitante = visitante;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_logal) {
        this.goles_local = goles_logal;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "PartidoDTO{" + "id=" + id + ", fecha=" + fecha + ", goles_local=" + goles_local + ", goles_visitante=" + goles_visitante + ", usuario=" + usuario + ", local=" + local + ", visitante=" + visitante + '}';
    }

    
 

    
    
   
}
