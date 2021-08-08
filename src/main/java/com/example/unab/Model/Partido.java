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
@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="fecha")
    private  Timestamp fecha;
    @Column(name ="goles_local")
    private int goles_local;
    @Column(name ="goles_visitante")
    private int goles_visitante;
   
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "local", nullable = false)
    private Equipo local;
    
    @JoinColumn(name = "visitante", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Equipo visitante;

    public Partido() {
    }

    public Partido(int id, Timestamp fecha, int goles_logal, int goles_visitante, Usuario usuario, Equipo local, Equipo visitante) {
        this.id = id;
        this.fecha = fecha;
        this.goles_local = goles_logal;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "Partido{" + "id=" + id + ", fecha=" + fecha + ", goles_local=" + goles_local + ", goles_visitante=" + goles_visitante + ", usuario=" + usuario + ", local=" + local + ", visitante=" + visitante + '}';
    }

    
    
   
}
