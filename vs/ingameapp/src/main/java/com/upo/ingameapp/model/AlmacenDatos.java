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
    
    public AlmacenDatos(){
        this.listaTecnicos = new ArrayList<>();
        this.listaGrupos = new ArrayList<>();
        this.listaIncidencias = new ArrayList<>();
    }

    /**
     * @return the listaTecnicos
     */
    public List<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    /**
     * @return the listaGrupos
     */
    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    /**
     * @return the listaIncidencias
     */
    public List<Incidencia> getListaIncidencias() {
        return listaIncidencias;
    }
    
    
}
