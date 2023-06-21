/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.upo.ingameapp;
import com.upo.ingameapp.bo.impl.NegocioBOImpl;
import com.upo.ingameapp.model.Tecnico;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 *
 * @author Manuel
 */
public class TecnicoTest {
     private NegocioBOImpl tecnicoManager;

    @Before
    public void setUp() {
        tecnicoManager = new NegocioBOImpl();
    }

    @Test
    public void testIntroducirDatosTecnico_NuevoTecnico() {
        String codigo = "T001";
        String nombre = "John";
        String apellido = "Doe";

        tecnicoManager.introducirDatosTecnico(codigo, nombre, apellido);

        List<Tecnico> listaTecnicos = tecnicoManager.getAlmacenDatos().getListaTecnicos();
        assertEquals(1, listaTecnicos.size());

        Tecnico tecnico = listaTecnicos.get(0);
        assertEquals(codigo, tecnico.getCodigo());
        assertEquals(nombre, tecnico.getNombre());
        assertEquals(apellido, tecnico.getApellidos());
    }

    @Test
    public void testIntroducirDatosTecnico_TecnicoExistente() {
        String codigo = "T001";
        String nombre = "John";
        String apellido = "Doe";

        Tecnico tecnicoExistente = new Tecnico(codigo, nombre, apellido);
        List<Tecnico> listaTecnicos = new ArrayList<>();
        listaTecnicos.add(tecnicoExistente);
        tecnicoManager.getAlmacenDatos().setListaTecnicos(listaTecnicos);

        tecnicoManager.introducirDatosTecnico(codigo, "Jane", "Smith");

        List<Tecnico> listaTecnicosActualizada = tecnicoManager.getAlmacenDatos().getListaTecnicos();
        assertEquals(1, listaTecnicosActualizada.size());

        Tecnico tecnico = listaTecnicosActualizada.get(0);
        assertEquals(tecnicoExistente, tecnico);
    }
}