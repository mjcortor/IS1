package com.upo.ingameapp.model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class AlmacenDatos {
    private List<Tecnico> listaTecnicos;
    private List<Grupo> listaGrupos;
    private List<Incidencia> listaIncidencias;
    private List<Tarea> listaTareas;
    
    public AlmacenDatos(){
        this.listaTecnicos = new ArrayList<>();
        this.listaGrupos = new ArrayList<>();
        this.listaIncidencias = new ArrayList<>();
        this.listaTareas = new ArrayList<>();
    }

    public List<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(List<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(List<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public List<Incidencia> getListaIncidencias() {
        return listaIncidencias;
    }

    public void setListaIncidencias(List<Incidencia> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }
    
    

  
    
}
