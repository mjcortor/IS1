/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.upo.ingameapp;

import com.upo.ingameapp.bo.impl.NegocioBOImpl;
import com.upo.ingameapp.dao.impl.IncidenciaDao;
import com.upo.ingameapp.dao.impl.TareaDao;
import com.upo.ingameapp.dao.impl.TecnicoDao;
import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tarea;
import com.upo.ingameapp.model.Tecnico;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Manuel
 */
public class NegocioBOTest {

    private NegocioBOImpl negocioBO;
    TecnicoDao tecnicoDAO;
    TareaDao tareaDAO;
    IncidenciaDao incideciaDAO;

    @Before
    public void setUp() {
        negocioBO = new NegocioBOImpl();

        tecnicoDAO = new TecnicoDao(negocioBO.getAlmacen());
        tareaDAO = new TareaDao(negocioBO.getAlmacen());
        tareaDAO = new TareaDao(negocioBO.getAlmacen());
        incideciaDAO = new IncidenciaDao(negocioBO.getAlmacen());
    }

    @Test
    public void testIntroducirDatosTecnico_NuevoTecnico() {
        String codigo = "T001";
        String nombre = "John";
        String apellido = "Doe";

        negocioBO.crearTecnico(nombre, apellido);

        List<Tecnico> listaTecnicos = negocioBO.getAlmacen().getListaTecnicos();
        assertEquals(1, listaTecnicos.size());

        Tecnico tecnico = listaTecnicos.get(0);
        assertEquals(nombre, tecnico.getNombre());
        assertEquals(apellido, tecnico.getApellidos());
    }

    @Test
    public void testIntroducirDatosTecnico_TecnicoExistente() {
        String codigo = "T001";
        String nombre = "John";
        String apellido = "Doe";

        Tecnico tecnicoExistente = new Tecnico(nombre, apellido);
        List<Tecnico> listaTecnicos = new ArrayList<>();
        listaTecnicos.add(tecnicoExistente);
        negocioBO.getAlmacen().setListaTecnicos(listaTecnicos);

        negocioBO.crearTecnico("Jane", "Smith");

        List<Tecnico> listaTecnicosActualizada = negocioBO.getAlmacen().getListaTecnicos();
        assertEquals(1, listaTecnicosActualizada.size());

        Tecnico tecnico = listaTecnicosActualizada.get(0);
        assertEquals(tecnicoExistente, tecnico);
    }


    @Test
    public void testCrearTecnico() {
        String nombre = "John";
        String apellido = "Doe";

        negocioBO.crearTecnico(nombre, apellido);

        Tecnico tecnicoCreado = tecnicoDAO.obtenerPorId(1L);
        assertNotNull(tecnicoCreado);
        assertEquals(nombre, tecnicoCreado.getNombre());
        assertEquals(apellido, tecnicoCreado.getApellidos());
       
    }

    @Test
    public void testCrearIncidencia() {
        String nombre = "Incidencia 1";
        String descripcion = "Descripción de la incidencia";
        int tiempoEstimacion = 10;

        negocioBO.crearIncidencia(nombre, descripcion, tiempoEstimacion);

        Incidencia incidenciaCreada = incideciaDAO.obtenerPorId(1L);
        assertNotNull(incidenciaCreada);
        assertEquals(nombre, incidenciaCreada.getNombre());
        assertEquals(descripcion, incidenciaCreada.getDescripcion());
        assertEquals(tiempoEstimacion, incidenciaCreada.getEstimacion());
        assertNull(incidenciaCreada.getTarea());
    }

    @Test
    public void testCrearTarea() {
        String nombreTarea = "Tarea 1";
        Tecnico tecnico = new Tecnico("John", "Doe");
        List<Incidencia> incidencias = new ArrayList<>();
        incidencias.add(new Incidencia("Incidencia 1", "Descripción 1", 10, null));
        incidencias.add(new Incidencia("Incidencia 2", "Descripción 2", 20, null));

        negocioBO.crearTarea(nombreTarea, tecnico, incidencias);

        Tarea tareaCreada = tareaDAO.obtenerPorId(1L);
        assertNotNull(tareaCreada);
        assertEquals(nombreTarea, tareaCreada.getNombre());
        assertEquals(tecnico, tareaCreada.getTecnico());
        assertEquals(incidencias, tareaCreada.getIncidencias());

        Tecnico tecnicoActualizado = tecnicoDAO.obtenerPorId(tecnico.getId());
        assertNotNull(tecnicoActualizado);
        assertEquals(tecnico.getNumTareas() + 1, tecnicoActualizado.getNumTareas());
    }
}
