package com.upo.ingameapp.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Tarea extends BaseEntity {
    
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private List<Incidencia> incidencias;
    private Tecnico tecnico;
    
    public Tarea(String nombre, Tecnico t, List<Incidencia> incidencias) {
        this.nombre = nombre;
        this.fechaInicio = new Date();
        this.estado = Constantes.ESTADO_TAREA_NUEVA;
        this.incidencias = incidencias;
        this.tecnico = t;
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Date getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<Incidencia> getIncidencias() {
        return incidencias;
    }
    
    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public Tecnico getTecnico() {
        return tecnico;
    }
    
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarea: " + this.nombre);
        sb.append("\n Mostrando Técnico de la Tarea:" + this.tecnico.toString());
        sb.append("\n Mostrando Incidencias de la Tarea: ");
        this.incidencias.forEach(i -> sb.append(i.toString()));
        return sb.toString();
    }
    
}
