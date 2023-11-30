/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebatecnica.baldomirroi_pruebatec2.persistencia;

import com.pruebatecnica.baldomirroi_pruebatec2.logica.Ciudadano;
import com.pruebatecnica.baldomirroi_pruebatec2.logica.Turno;
import com.pruebatecnica.baldomirroi_pruebatec2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roi Baldomir
 */
public class ControladoraPersistencia {
    
    TurnoJpaController turnoJPA = new TurnoJpaController();
    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();
    
    // Métodos Turno
    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }
    
    public void editarTurno(Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarTurno(long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Turno> traerTurnos() {
        return turnoJPA.findTurnoEntities();
    }
    
    public Turno traerTurno(long id) {
        return turnoJPA.findTurno(id);
    }
    
    // Métodos Ciudadano
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }
    
    public Ciudadano traerCiudadano(long id) {
        return ciudadanoJPA.findCiudadano(id);
    }
    
    public List<Ciudadano> traerCiudadanos() {
        return ciudadanoJPA.findCiudadanoEntities();
    }
}
