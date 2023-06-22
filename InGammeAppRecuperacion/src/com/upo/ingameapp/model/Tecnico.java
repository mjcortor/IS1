package com.upo.ingameapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Tecnico extends BaseEntity {

    private String nombre;
    private String apellidos;
    private int numTareas;

    public Tecnico() {

    }

    public Tecnico(String nombre, String apellidos) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numTareas = 0;

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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumTareas() {
        return numTareas;
    }

    public void setNumTareas(int numTareas) {
        this.numTareas = numTareas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Técnico con nombre: ");
        sb.append(this.nombre);
        sb.append(",apellidos: " + this.apellidos);
        sb.append(" | nº de tareas asignadas al técnico: " + this.numTareas);
        return sb.toString();

    }

}
