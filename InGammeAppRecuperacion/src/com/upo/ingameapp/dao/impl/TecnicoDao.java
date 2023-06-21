/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upo.ingameapp.dao.impl;

import com.upo.ingameapp.dao.IBaseDAO;
import com.upo.ingameapp.model.AlmacenDatos;
import com.upo.ingameapp.model.Tecnico;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Manuel
 */
public class TecnicoDao implements IBaseDAO<Tecnico> {

    private final AlmacenDatos almacen;

    public TecnicoDao(AlmacenDatos a) {
        this.almacen = a;
    }

    @Override
    public Tecnico obtenerPorId(long id) {
        return almacen.getListaTecnicos().stream().filter(t -> t.getId() == id).findAny().get();
    }

    @Override
    public void save(Tecnico t) {
        almacen.getListaTecnicos().add(t);
    }

    @Override
    public void delete(Tecnico t) {
        almacen.getListaTecnicos().remove(t);
    }

    @Override
    public List<Tecnico> findAll() {
        return almacen.getListaTecnicos();
    }

    @Override
    public void saveAll(List<Tecnico> t) {
        almacen.getListaTecnicos().addAll(t);
    }

    public List<Tecnico> findTecnicoDisponible() {
        return almacen.getListaTecnicos().stream().filter(t -> t.getNumTareas() < 3).collect(Collectors.toList());
    }

    @Override
    public Tecnico update(Tecnico t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
