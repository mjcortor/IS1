/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upo.ingameapp.dao.impl;

import com.upo.ingameapp.dao.IBaseDAO;
import com.upo.ingameapp.model.AlmacenDatos;
import com.upo.ingameapp.model.Tarea;
import com.upo.ingameapp.model.Tecnico;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Manuel
 */
public class TareaDao implements IBaseDAO<Tarea> {

    private final AlmacenDatos almacen;

    public TareaDao(AlmacenDatos a) {
        this.almacen = a;
    }

    @Override
    public Tarea obtenerPorId(long id) {
        return almacen.getListaTareas().stream().filter(t -> t.getId() == id).findFirst().get();
    }

    @Override
    public void save(Tarea t) {
        almacen.getListaTareas().add(t);
    }

    @Override
    public void delete(Tarea t) {
        almacen.getListaTareas().remove(t);
    }

    @Override
    public List<Tarea> findAll() {
        return almacen.getListaTareas();
    }
    
    @Override
    public void saveAll(List<Tarea> t) {
        almacen.getListaTareas().addAll(t);
    }

    public List<Tarea> findTareaByTecnico(Tecnico tecnico) {
        return almacen.getListaTareas().stream().filter(t -> t.getTecnico().equals(tecnico)).collect(Collectors.toList());

    }

    @Override
    public Tarea update(Tarea t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
