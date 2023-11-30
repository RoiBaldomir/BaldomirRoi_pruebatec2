package com.pruebatecnica.baldomirroi_pruebatec2.logica;

import com.pruebatecnica.baldomirroi_pruebatec2.logica.Ciudadano;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-11-30T01:53:40")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Long> numeroTurno;
    public static volatile SingularAttribute<Turno, Boolean> estadoTurno;
    public static volatile SingularAttribute<Turno, LocalDate> fecha;
    public static volatile SingularAttribute<Turno, String> descripcionTramite;
    public static volatile SingularAttribute<Turno, Ciudadano> ciudadanoSolicitante;

}