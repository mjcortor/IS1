package com.upo.ingameapp.controller.impl;

import java.util.Scanner;

import com.upo.ingameapp.bo.INegocioBO;
import com.upo.ingameapp.bo.impl.NegocioBOImpl;
import com.upo.ingameapp.controller.IController;
import com.upo.ingameapp.main.IO;
import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tecnico;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements IController {

    /* SERVICIOS */
    private final INegocioBO negocioBO = new NegocioBOImpl();
    private IO io = new IO();

    @Override
    public void aniadirTecnico() throws IOException{
        System.out.println("Introduzca el nombre del Técnico");
        String nombre = io.obtenerBuffer().readLine();
        System.out.println("Introduzca los apellidos del Técnico");
        String apellido = io.obtenerBuffer().readLine();
        this.negocioBO.crearTecnico(nombre, apellido);
        System.out.println("Ahora los técnicos son los siguientes:");
        this.negocioBO.listarTecnicos();

    }

    @Override
    public void aniadirGrupo() throws IOException{
        System.out.println("Introduzca el nombre del grupo.");
        String nombre = io.obtenerBuffer().readLine();
        System.out.println("Introduzca el codigo del grupo");
        String codigo = io.obtenerBuffer().readLine();
        this.negocioBO.crearGrupo(codigo, nombre);
    }

    @Override
    public void aniadirIncidencia() throws IOException{
        System.out.println("Introduzca el nombre de la nueva incidencia:");
        String nombreIndicencia = io.obtenerBuffer().readLine();
        System.out.println("Introduzca la descripcion de la nueva incidencia:");
        String descripcionIncidencia = io.obtenerBuffer().readLine();
        int estimacion = 0;
        do {
            System.out.println("Introduzca la estmación de la incidencia: (1 a 24)Horas");
            estimacion = Integer.valueOf(io.obtenerBuffer().readLine());
        } while (estimacion < 1 && estimacion > 24);
        this.negocioBO.crearIncidencia(nombreIndicencia, descripcionIncidencia, estimacion);
    }

    @Override
    public void listarIncidencias() {
        negocioBO.listarIncidenias();

    }

    @Override
    public void crearTarea() throws IOException{
        
        List<Incidencia> incidenciasSeleccionadas = new ArrayList<>();
        Tecnico t;
        int opc = 0;
        System.out.println("Introduzca el nombre de la Tarea:");
        String nombre = io.obtenerBuffer().readLine();
        negocioBO.listarTecnicosDisponibles();
        System.out.println("Seleccione un ténico:");
        int i = Integer.valueOf(io.obtenerBuffer().readLine());
        t = negocioBO.seleccionarTecnico(i);
        System.out.println("Agregue incidencias mientras haya disponibles o lo decida:");
        do {
            switch (opc) {
                case 1:
                    negocioBO.listarIncideciasDisponibles();
                    System.out.println("Seleccione una incidencia de la lista");
                    int index = Integer.valueOf(io.obtenerBuffer().readLine());
                    incidenciasSeleccionadas.add(negocioBO.seleccionarIncidencia(index));
                    break;
                case 2:
                    System.out.println("saliendo de agregar incidencias a Tarea.");
                    break;
                default:
                    System.out.println("Opción no disponible");
                    break;
            }
            opc = Integer.valueOf(io.obtenerBuffer().readLine());
        } while (opc < 1 && opc > 2);
        negocioBO.crearTarea(nombre, t, incidenciasSeleccionadas);
        System.out.println("Tarea creada correctamente.");
    }

    @Override
    public void asignacionAutomaticaTareas() {
        System.out.println("Algoritmo de asignación Automática de Tareas.");
    }

    @Override
    public void mostrarEstadisticas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarIncidenciasDisponibles() {
        negocioBO.listarIncideciasDisponibles();
    }

    @Override
    public void listarTodasTareas() {
        negocioBO.listarTareas();
    }

    @Override
    public void listarTodosGrupos() {
        negocioBO.listarGrupos();
    }

    @Override
    public void listarTodosTecnicos() {
        negocioBO.listarTecnicos();
    }

    @Override
    public void realizarCargaDeDatos() {
        negocioBO.realizarCargaMasivaDeDatos();
    }

}
