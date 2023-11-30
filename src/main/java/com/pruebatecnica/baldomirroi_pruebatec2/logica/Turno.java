
package com.pruebatecnica.baldomirroi_pruebatec2.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Roi Baldomir
 */
@Entity
public class Turno implements Serializable {
    @Id
    private long numeroTurno; // Valor identificativo del turno
    private LocalDate fecha; // Fecha asignada al turno
    private String descripcionTramite; // Descripción del tramite asignado al turno
    private boolean estadoTurno; // Estado del turno | "Asignado" o "en espera"
    
    // Relación de la clase turno con la clase ciudadano con manyToOne
    @ManyToOne
    @JoinColumn(name = "CIUDADANO_ID") // Nombre de la columna a crear en la BD
    private Ciudadano ciudadanoSolicitante;

    public Turno() {
    }

    public Turno(long numeroTurno, LocalDate fecha, String descripcionTramite, Ciudadano ciudadanoSolicitante) {
        this.numeroTurno = numeroTurno;
        this.fecha = fecha;
        this.descripcionTramite = descripcionTramite;
        this.ciudadanoSolicitante = ciudadanoSolicitante;
        this.estadoTurno = false;
    }

    public long getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(long numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionTramite() {
        return descripcionTramite;
    }

    public void setDescripcionTramite(String descripcionTramite) {
        this.descripcionTramite = descripcionTramite;
    }

    public Ciudadano getCiudadanoSolicitante() {
        return ciudadanoSolicitante;
    }

    public void setCiudadanoSolicitante(Ciudadano ciudadanoSolicitante) {
        this.ciudadanoSolicitante = ciudadanoSolicitante;
    }

    public boolean isEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(boolean estadoTurno) {
        this.estadoTurno = estadoTurno;
    }
 
}
