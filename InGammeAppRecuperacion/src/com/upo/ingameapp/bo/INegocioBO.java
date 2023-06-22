package com.upo.ingameapp.bo;

import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tecnico;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface INegocioBO {

    void listarIncidenias();

    void listarTecnicos();

    void listarTareas();

    void listarGrupos();

    void crearTecnico(String nom, String ape);

    void crearIncidencia(String nombre, String descripcion, int tiempoEstimacion);

    void crearTarea(String nombre, Tecnico tecnico, List<Incidencia> incidencias);

    Incidencia seleccionarIncidencia(int seleccion);

    Tecnico seleccionarTecnico(int seleccion);

    void crearGrupo(String nombre, String codigo);

    void listarTecnicosDisponibles();

    void listarIncideciasDisponibles();

    void realizarCargaMasivaDeDatos();
    
    void asignacionAutomaticaTareas();

}
