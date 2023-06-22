package com.upo.ingameapp.controller;

import java.io.IOException;

public interface IController {

    void aniadirTecnico() throws IOException;

    void aniadirGrupo() throws IOException;

    void aniadirIncidencia() throws IOException;

    void listarIncidencias();

    void crearTarea() throws IOException;

    void asignacionAutomaticaTareas();

    void mostrarEstadisticas();

    void listarIncidenciasDisponibles();

    void listarTodasTareas();

    void listarTodosGrupos();
   
    void listarTodosTecnicos();

    void realizarCargaDeDatos();
    
    void cambiarEstadoIncidencia();
    
    void crearGrupo() throws IOException;
            
    
}
