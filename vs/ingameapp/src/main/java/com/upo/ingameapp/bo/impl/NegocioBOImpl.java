package com.upo.ingameapp.bo.impl;

import com.upo.ingameapp.bo.INegocioBO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.upo.ingameapp.model.AlmacenDatos;
import com.upo.ingameapp.model.Grupo;
import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tarea;
import com.upo.ingameapp.model.Tecnico;

/**
 *
 * @author Manuel
 */
public class NegocioBOImpl implements INegocioBO {

    private AlmacenDatos almacenDatos;

    public NegocioBOImpl() {
        this.almacenDatos = new AlmacenDatos();
    }

    @Override
    public void introducirDatosTecnico(String codigo, String nom, String ape) {
        Optional<Tecnico> opCodigoExistente = this.almacenDatos.getListaTecnicos().stream().filter(t -> t.getCodigo().equals(codigo)).findAny();
        if (!opCodigoExistente.isPresent()) {
            Tecnico t = new Tecnico(codigo, nom, ape);
            this.almacenDatos.getListaTecnicos().add(t);
            System.out.println("El Técnico " + t.toString() + " ha sido agregado al sistema con éxito.");
        } else {
            System.err.println("Error, código" + codigo + " ya existe para el téncnico:" + opCodigoExistente.get().toString());
            System.out.println("No se ha creado técnico nuevo.");
        }
    }

    @Override
    public void introducirDatosIncidencia(String nombre, String descripcion) {
        Incidencia i = new Incidencia(nombre, descripcion);
        this.almacenDatos.getListaIncidencias().add(i);
        System.out.println("La incidencia " + i.toString() + " ha sido agregada al sistema con éxito.");
    }

    @Override
    public void listarIncidenias() {
        System.out.println("Listado de incidencias:");
        this.almacenDatos.getListaIncidencias().forEach(i -> {
            System.out.println(i.toString());
        });
    }

    @Override
    public Incidencia seleccionarIncidencia(int index) {
        Incidencia i = null;
        if (index <= this.almacenDatos.getListaIncidencias().size()) {
            i = this.almacenDatos.getListaIncidencias().get(index);
        } else {
            System.err.println("Ha introducido un número incorrecto de incidencia.");
        }
        return i;
    }

    @Override
    public Tecnico seleccionarTecnico(int index) {
        Tecnico t = null;
        if (index <= this.almacenDatos.getListaTecnicos().size()) {
            t = this.almacenDatos.getListaTecnicos().get(index);
        } else {
            System.err.println("Ha introducido un número incorrecto de técnico.");
        }
        return t;
    }

    @Override
    public void crearGrupo(String codigoGrupo, String nombre) {

        Optional<Grupo> opCodigoExistente = this.almacenDatos.getListaGrupos().stream().filter(t -> t.getCodigo().equals(codigoGrupo)).findAny();
        if (!opCodigoExistente.isPresent()) {
            Grupo g = new Grupo(codigoGrupo, nombre);
            this.almacenDatos.getListaGrupos().add(g);
            System.out.println("El Grupo " + g.toString() + " ha sido agregado al sistema con éxito.");
        } else {
            System.err.println("Error, código" + codigoGrupo + " ya existe para el grupo:" + opCodigoExistente.get().toString());
            System.out.println("No se ha creado grupo nuevo.");
        }

    }

    @Override
    public void listarTareasGrupo(int index) {
        if (index <= this.almacenDatos.getListaGrupos().size()) {
            Grupo g = this.almacenDatos.getListaGrupos().get(index);
            System.out.println("Listando las tareas asociadas al grupo: " + g.toString());
            g.getListaTecnicosGrupo().forEach(t -> {
                System.out.println("\t Mostrando las tareas del Técnico: " + t.toString());
                t.getListaTareas().forEach(x -> {
                    System.out.println(x.toString());
                });
            });
        } else {
            System.err.println("Ha introducido un número incorrecto de Grupo");
        }
    }

    @Override
    public void consultarTareasTecnico(Tecnico t) {
        System.out.println("Mostrando las tareas del Técnico" + t.toString());
        t.getListaTareas().forEach(x -> {
            System.out.println(x.toString());
        });
    }

    @Override
    public void consultarTareasGrupo(Grupo g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void obtenerTecnicos() {
        System.out.println("Mostrando Técnicos: ");
        int contador = 1;
        for (Tecnico t : this.almacenDatos.getListaTecnicos()) {
            System.out.println(contador + ". " + t.toString());
            contador++;
        }
    }

    @Override
    public void seleccionarTecnicoGrupo(Tecnico t, Grupo g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarAsocicacionTareasGrupoAutomaticamente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listarTecnicosDisponibles() {
        //Muestra los técnicos que tienen menos de 3 tareas en su lista de tareas.
        System.out.println("Mostrando Técnicos disponibles: (Tienen menos de 3 tareas asociadas)");
        int contador = 0;
        List<Tecnico> sublistTecnicosDisponible = this.almacenDatos.getListaTecnicos().stream().filter(t -> t.getListaTareas().size() < 3).collect(Collectors.toList());
        for(Tecnico t : sublistTecnicosDisponible){
            System.out.println(contador + ". " + t.toString());
            contador++;
        }
           
            
       
    }

    @Override
    public void realizarCargaMasivaDeDatos() {
        Tecnico t1 = new Tecnico("1", "lino", "cordoba");
        Tecnico t2 = new Tecnico("2", "lucia", "vg");
        Tecnico t3 = new Tecnico("3", "gonzalo", "sequera");
        Tecnico t4 = new Tecnico("4", "eduardo", "camavinga");
        Tecnico t5 = new Tecnico("5", "antonio", "cifuentes");
        Tecnico t6 = new Tecnico("6", "blanca", "romanones");
        Tecnico t7 = new Tecnico("7", "nathan", "drake");

        Tarea ta1 = new Tarea("Tarea1", "Descripcion tarea 1", 24);

        t1.getListaTareas().add(ta1);

        //Añadimos a almacenanmiento
        this.almacenDatos.getListaTecnicos().add(t1);
        this.almacenDatos.getListaTecnicos().add(t2);
        this.almacenDatos.getListaTecnicos().add(t3);
        this.almacenDatos.getListaTecnicos().add(t4);
        this.almacenDatos.getListaTecnicos().add(t5);
        this.almacenDatos.getListaTecnicos().add(t6);
        this.almacenDatos.getListaTecnicos().add(t7);

        Incidencia i1 = new Incidencia("Incidencia en la UI", "Error en la UI");
        Incidencia i2 = new Incidencia("Incidencia en el loggin", "Error al logarse desde la plataforma de Play Station.");
        Incidencia i3 = new Incidencia("Incidencia en juego", "Error al equipar el cosmetico HackEye.");

        this.almacenDatos.getListaIncidencias().add(i1);
        this.almacenDatos.getListaIncidencias().add(i2);
        this.almacenDatos.getListaIncidencias().add(i3);

        Grupo grupoTrabajo1 = new Grupo("grupoTrabajo1", "Grupo de trabajo 1");
        grupoTrabajo1.getListaTecnicosGrupo().add(t1);
        grupoTrabajo1.getListaTecnicosGrupo().add(t2);
        this.almacenDatos.getListaGrupos().add(grupoTrabajo1);

    }

}
