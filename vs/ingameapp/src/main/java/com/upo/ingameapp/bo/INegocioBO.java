package com.upo.ingameapp.bo;

import com.upo.ingameapp.model.Grupo;
import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tecnico;

/**
 *
 * @author Manuel
 */
public interface INegocioBO {
    public void introducirDatosTecnico(String codigo, String nom, String ape);
    public void introducirDatosIncidencia(String nombre, String descripcion);
    public void listarIncidenias();
    public Incidencia seleccionarIncidencia(int index);
    public Tecnico seleccionarTecnico(int index);
    public void crearGrupo(String codigoGrupo, String nombre);
    public void listarTareasGrupo(int index);
    public void consultarTareasTecnico(Tecnico t);
    public void consultarTareasGrupo(Grupo g);
    public void obtenerTecnicos();
    public void seleccionarTecnicoGrupo(Tecnico t, Grupo g);
    public void realizarAsocicacionTareasGrupoAutomaticamente();
    public void listarTecnicosDisponibles();
    public void realizarCargaMasivaDeDatos();
        
    
}
