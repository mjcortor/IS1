package com.upo.ingameapp.model;

/**
 *
 * @author Manuel
 */
public class Tarea {
    private String nombre;
    private String descripcion;
    private float estimacion;

    public Tarea(String nombre, String descripcion, float estimacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estimacion = estimacion;
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

    /**
     * @return the estimacion
     */
    public float getEstimacion() {
        return estimacion;
    }

    /**
     * @param estimacion the estimacion to set
     */
    public void setEstimacion(float estimacion) {
        this.estimacion = estimacion;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tarea: "+ this.nombre);
        sb.append("\n descripción Tarea: " + this.descripcion);
        sb.append(" \n estimación Tarea: " + this.estimacion);
        return sb.toString();
    }
}
