/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upo.ingameapp.dao.impl;

import com.upo.ingameapp.dao.IBaseDAO;
import com.upo.ingameapp.model.AlmacenDatos;
import com.upo.ingameapp.model.Grupo;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class GrupoDao implements IBaseDAO<Grupo> {

    private AlmacenDatos almacen;

    public GrupoDao(AlmacenDatos a) {
        this.almacen = a;
    }

    @Override
    public Grupo obtenerPorId(long id) {
        return almacen.getListaGrupos().stream().filter(t -> t.getId() == id).findAny().get();
    }

    @Override
    public void save(Grupo t) {
        almacen.getListaGrupos().add(t);
    }

    @Override
    public void delete(Grupo t) {
        almacen.getListaGrupos().remove(t);
    }

    @Override
    public List<Grupo> findAll() {
        return almacen.getListaGrupos();
    }

    @Override
    public void saveAll(List<Grupo> t) {
        almacen.getListaGrupos().addAll(t);
    }

    @Override
    public Grupo update(Grupo t) {
        Grupo grupoUpdate = almacen.getListaGrupos().stream().filter(g -> g.equals(t)).findFirst().get();
        grupoUpdate.setCodigo(t.getCodigo());
        grupoUpdate.setNombre(t.getNombre());
        grupoUpdate.setListaTecnicosGrupo(t.getListaTecnicosGrupo());
        return grupoUpdate;
    }

}
