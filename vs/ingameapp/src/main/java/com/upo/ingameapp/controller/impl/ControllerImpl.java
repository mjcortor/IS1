package com.upo.ingameapp.controller.impl;

import java.util.Scanner;

import com.upo.ingameapp.bo.INegocioBO;
import com.upo.ingameapp.bo.impl.NegocioBOImpl;
import com.upo.ingameapp.controller.IController;

public class ControllerImpl implements IController {

    /* SERVICIOS */
    private INegocioBO negocioBO = new NegocioBOImpl();;

    @Override
    public void aniadirTecnico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el código único para el Técnico:");
        String codigo = sc.next();
        System.out.println("Introduzca el nombre del Técnico");
        String nombre = sc.next();
        System.out.println("Introduzca el apellido del Técnico");
        String apellido = sc.next();
        this.negocioBO.introducirDatosTecnico(codigo, nombre, apellido);
        System.out.println("Ahora los técnicos son los siguientes:");
        this.negocioBO.obtenerTecnicos();

    }

    @Override
    public void aniadirGrupo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del grupo.");
        String nombreGrupo = sc.next();
        System.out.println("Introduzca el código del grupo:");
        String codigo = sc.next();
        this.negocioBO.crearGrupo(nombreGrupo, codigo);
    }

    @Override
    public void aniadirIncidencia() {
        // TODO Auto-generated method stub

    }

    @Override
    public void listarIncidencias() {
        // TODO Auto-generated method stub

    }

    @Override
    public void agregarTareaTecnico() {
        // TODO Auto-generated method stub

    }

    @Override
    public void agregarTareasGrupo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void consultarTareasTecnico() {
        Scanner sc = new Scanner(System.in);
        this.negocioBO.obtenerTecnicos();
        int index = sc.nextInt();
        this.negocioBO.consultarTareasTecnico(this.negocioBO.seleccionarTecnico(index));

    }

    @Override
    public void consultarTareasGrupo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void consultarIndicencias() {
        // TODO Auto-generated method stub

    }

    @Override
    public void agrupacionAutomaticaTareasGrupos() {
        // TODO Auto-generated method stub

    }

}
