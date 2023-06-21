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
public class Id {

    private static long id = 1;

    public static long sequenceNextVal() {
        return Id.id++;
    }
}
