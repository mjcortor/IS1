/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upo.ingameapp.dao;

import java.util.List;

/**
 *
 * @author Manuel
 */
public interface IBaseDAO<T> {

    T obtenerPorId(long id);

    void save(T t);

    T update(T t);
    
    void delete(T t);
    
    List<T> findAll();
    
    void saveAll(List<T> t);

}
