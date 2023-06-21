package com.upo.ingameapp.controller.impl;

import java.util.Scanner;

import com.upo.ingameapp.bo.INegocioBO;
import com.upo.ingameapp.bo.impl.NegocioBOImpl;
import com.upo.ingameapp.controller.IController;
import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tecnico;
import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements IController {

    /* SERVICIOS */
    private final INegocioBO negocioBO = new NegocioBOImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void aniadirTecnico() {
        System.out.println("Introduzca el nombre del Técnico");
        String nombre = sc.next();
        System.out.println("Introduzca los apellidos del Técnico");
        String apellido = sc.next();
        this.negocioBO.crearTecnico(nombre, apellido);
        System.out.println("Ahora los técnicos son los siguientes:");
        this.negocioBO.listarTecnicos();

    }

    @Override
    public void aniadirGrupo() {
        System.out.println("Introduzca el nombre del grupo.");
        String nombre = sc.next();
        System.out.println("Introduzca el codigo del grupo");
        String codigo = sc.next();
        this.negocioBO.crearGrupo(codigo, nombre);
    }

    @Override
    public void aniadirIncidencia() {
        System.out.println("Introduzca el nombre de la nueva incidencia:");
        String nombreIndicencia = sc.next();
        System.out.println("Introduzca la descripcion de la nueva incidencia:");
        String descripcionIncidencia = sc.next();
        int estimacion = 0;
        while (estimacion < 1 && estimacion > 24) {
            System.out.println("Introduzca la estmación de la incidencia: (1 a 24)Horas");
            estimacion = sc.nextInt();
        }
        this.negocioBO.crearIncidencia(nombreIndicencia, descripcionIncidencia, estimacion);
    }

    @Override
    public void listarIncidencias() {
        System.out.println("TODAS LAS INCIDENCIAS:");
        System.out.println("-------------------------");
        negocioBO.listarIncidenias();
        System.out.println("TODAS LAS INCIDENCIAS SIN TAREAS ASIGNADAS Y EN NUEVA:");
        System.out.println("-------------------------");
        negocioBO.listarIncideciasDisponibles();
    }

    @Override
    public void crearTarea() {
        List<Incidencia> incidenciasSeleccionadas = new ArrayList<>();
        Tecnico t;
        int opc = 0;
        System.out.println("Introduzca el nombre de la Tarea:");
        String nombre = sc.next();
        System.out.println("Seleccione un ténico:");
        negocioBO.listarTecnicosDisponibles();
        int i = sc.nextInt();
        t = negocioBO.seleccionarTecnico(i);
        System.out.println("Agregue incidencias mientras haya disponibles o lo decida:");
        while (opc < 1 && opc > 2) {
            switch (opc) {
                case 1:
                    negocioBO.listarIncideciasDisponibles();
                    System.out.println("Seleccione una incidencia de la lista");
                    int index = sc.nextInt();
                    incidenciasSeleccionadas.add(negocioBO.seleccionarIncidencia(index));
                    break;
                case 2:
                    System.out.println("saliendo de agregar incidencias a Tarea.");
                    break;
                default:
                    System.out.println("Opción no disponible");
                    break;
            }
            opc = sc.nextInt();
        }
        negocioBO.crearTarea(nombre, t, incidenciasSeleccionadas);
        System.out.println("Tarea creada correctamente.");
        
        
    }

    @Override
    public void asignacionAutomaticaTareas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarEstadisticas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarIncidenciasDisponibles() {
        negocioBO.listarIncideciasDisponibles();
    }

}
