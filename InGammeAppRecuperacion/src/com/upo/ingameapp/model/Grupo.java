package com.upo.ingameapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Grupo  extends BaseEntity{

    private String codigo;
    private String nombre;
    private List<Tecnico> listaTecnicosGrupo;

    public Grupo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaTecnicosGrupo = new ArrayList<>();
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
     * @return the listaTecnicosGrupo
     */
    public List<Tecnico> getListaTecnicosGrupo() {
        return listaTecnicosGrupo;
    }

    /**
     * @param listaTecnicosGrupo the listaTecnicosGrupo to set
     */
    public void setListaTecnicosGrupo(List<Tecnico> listaTecnicosGrupo) {
        this.listaTecnicosGrupo = listaTecnicosGrupo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grupo con nombre:" + nombre);
        sb.append(", con código;" +codigo);
        return sb.toString();
    }

}
