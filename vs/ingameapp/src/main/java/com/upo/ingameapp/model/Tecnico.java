package com.upo.ingameapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Tecnico {

    private String codigo;
    private String nombre;
    private String apellidos;
    private List<String> codigosGrupo;
    private List<Tarea> listaTareas;

    public Tecnico() {
        this.codigosGrupo = new ArrayList<>();
        this.listaTareas = new ArrayList<>();
    }

    public Tecnico(String codigo, String nombre, String apellidos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigosGrupo = new ArrayList<>();
        this.listaTareas = new ArrayList<>();
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    /**
     * @return the codigosGrupo
     */
    public List<String> getCodigosGrupo() {
        return codigosGrupo;
    }

    /**
     * @param codigosGrupo the codigosGrupo to set
     */
    public void setCodigosGrupo(List<String> codigosGrupo) {
        this.codigosGrupo = codigosGrupo;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Técnico con nombre: ");
        sb.append(this.nombre);
        sb.append(", apellidos: "+this.apellidos);
        sb.append(" y con código:"+ this.codigo);
        return sb.toString();
                
    }

}
