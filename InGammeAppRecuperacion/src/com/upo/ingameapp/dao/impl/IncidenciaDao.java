/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upo.ingameapp.dao.impl;

import com.upo.ingameapp.dao.IBaseDAO;
import com.upo.ingameapp.model.AlmacenDatos;
import com.upo.ingameapp.model.Constantes;
import com.upo.ingameapp.model.Incidencia;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author Manuel
 */
public class IncidenciaDao implements IBaseDAO<Incidencia> {

    private final AlmacenDatos almacen;

    public IncidenciaDao(AlmacenDatos a) {
        this.almacen = a;
    }

    @Override
    public Incidencia obtenerPorId(long id) {
        return almacen.getListaIncidencias().stream().filter(t -> t.getId() == id).findAny().get();
    }

    @Override
    public void save(Incidencia t) {
        almacen.getListaIncidencias().add(t);
    }

    @Override
    public void delete(Incidencia t) {
        almacen.getListaIncidencias().remove(t);
    }

    @Override
    public List<Incidencia> findAll() {
        return almacen.getListaIncidencias();
    }
    
    @Override
    public void saveAll(List<Incidencia> t) {
        almacen.getListaIncidencias().addAll(t);
    }

    public List<Incidencia> findIncidenciasNuevasSinTarea() {
        return almacen.getListaIncidencias().stream().filter(i
                -> Objects.isNull(i.getTarea())
                && Constantes.ESTADO_INCIDENCIA_NUEVA.equals(i.getEstado()))
                .collect(Collectors.toList());
    }

    @Override
    public Incidencia update(Incidencia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
