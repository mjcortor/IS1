package com.upo.ingameapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Incidencia extends BaseEntity {

    private String nombre;
    private String descripcion;
    private String estado;
    private int estimacion;
    private Tarea tarea;

    public Incidencia(String nombre, String descripcion, int estimacion, Tarea t) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarea = t;
        this.estado = Constantes.ESTADO_INCIDENCIA_NUEVA;

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

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEstimacion() {
        return estimacion;
    }

    public void setEstimacion(int estimacion) {
        this.estimacion = estimacion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Incidencia: ");
        sb.append(nombre);
        sb.append(", Descripción Incidencia:");
        sb.append(descripcion);
        sb.append(", Estado de la incidencia: ");
        sb.append(estado);
        return sb.toString();
    }

}
