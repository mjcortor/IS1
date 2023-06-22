package com.upo.ingameapp.main;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manuel
 */
public class IO {

    private final InputStreamReader isr = new InputStreamReader(System.in);
    private final BufferedReader buffer = new BufferedReader(isr);
    
    public  BufferedReader obtenerBuffer(){
        return this.buffer;
    }

}
