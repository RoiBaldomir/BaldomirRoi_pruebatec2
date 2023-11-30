
package com.pruebatecnica.baldomirroi_pruebatec2.logica;

import com.pruebatecnica.baldomirroi_pruebatec2.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Roi Baldomir
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    // Métodos Turno
    public void crearTurno(Turno turno) {
        controlPersis.crearTurno(turno);
    }
    
    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }
    
    public void borrarTurno(long id) {
        controlPersis.borrarTurno(id);
    }
    
    public List<Turno> traerTurnos(LocalDate fecha, boolean isEstado) {
        // Trae la lista de turnos
        List<Turno> listaTurnos = controlPersis.traerTurnos();
        // Filtra por la fecha y estado introducido por el usuario
        List<Turno> turnosFechaEstado = listaTurnos.stream()
                .filter(t -> t.getFecha().equals(fecha))
                .filter(t -> t.isEstadoTurno() == isEstado)
                .toList();
       
        // Se devuelven los turnos correspondientes a la fecha y estado
        return turnosFechaEstado;
    }
    
    public List<Turno> traerTurnos(LocalDate fecha) {
        // Trae la lista de turnos
        List<Turno> listaTurnos = controlPersis.traerTurnos();
        // Filtra por la fecha introducida por el usuario
        List<Turno> turnosFechaCoincidente = listaTurnos.stream()
                .filter(t -> t.getFecha().equals(fecha))
                .toList();
       
        // Se devuelven los turnos correspondientes a la fecha
        return turnosFechaCoincidente;
    }
    
    public Turno traerTurno(long id) {
        return controlPersis.traerTurno(id);
    }
    
    // Métodos Ciudadano
    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }

    public Ciudadano traerCiudadano(long id) {
        return controlPersis.traerCiudadano(id);
    }
    
    public List<Ciudadano> traerCiudadanos() {
        List<Ciudadano> listaCiudadanos = controlPersis.traerCiudadanos();
        return listaCiudadanos;
    }
}
