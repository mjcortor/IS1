/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upo.ingameapp.model;

/**
 *
 * @author Manuel
 */
public class BaseEntity {
    private long id;
    
    public BaseEntity(){
        this.id = Id.sequenceNextVal();
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId(){
        return this.id;
    }
    
    @Override
    public boolean equals(Object o){
        BaseEntity be = (BaseEntity) o;
        return this.id == be.getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
}
