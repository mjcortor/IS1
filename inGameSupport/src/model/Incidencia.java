package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Incidencia {

    private String nombre;
    private String descripcion;
    private List<Tarea> listaTareas;
    

    public Incidencia(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaTareas = new ArrayList<>();
       
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
     * @return the listaTareas
     */
    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    /**
     * @param listaTareas the listaTareas to set
     */
    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

   
    
    
}
