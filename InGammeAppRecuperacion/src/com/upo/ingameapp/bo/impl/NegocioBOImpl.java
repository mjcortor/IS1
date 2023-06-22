package com.upo.ingameapp.bo.impl;

import com.upo.ingameapp.bo.INegocioBO;
import com.upo.ingameapp.dao.impl.GrupoDao;
import com.upo.ingameapp.dao.impl.IncidenciaDao;
import com.upo.ingameapp.dao.impl.TareaDao;
import com.upo.ingameapp.dao.impl.TecnicoDao;
import com.upo.ingameapp.model.AlmacenDatos;
import com.upo.ingameapp.model.Grupo;
import com.upo.ingameapp.model.Incidencia;
import com.upo.ingameapp.model.Tarea;
import com.upo.ingameapp.model.Tecnico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class NegocioBOImpl implements INegocioBO {

    private final AlmacenDatos almacenDatos;
    private final TareaDao tareaDAO;
    private final GrupoDao grupoDAO;
    private final TecnicoDao tecnicoDAO;
    private final IncidenciaDao incidenciaDAO;

    public NegocioBOImpl() {
        this.almacenDatos = new AlmacenDatos();
        this.tareaDAO = new TareaDao(almacenDatos);
        this.grupoDAO = new GrupoDao(almacenDatos);
        this.tecnicoDAO = new TecnicoDao(almacenDatos);
        this.incidenciaDAO = new IncidenciaDao(almacenDatos);
    }

    @Override
    public void listarIncidenias() {
        System.out.println("Las incidencias que hay en el sistema son las siguientes:");
        System.out.println("-----------------------------------------------------");
        incidenciaDAO.findAll().forEach(i -> System.out.println(i.toString()));
    }

    @Override
    public void listarTecnicos() {
        System.out.println("Los técnicos que hay en el sistema son los siguientes:");
        System.out.println("-----------------------------------------------------");
        tecnicoDAO.findAll().forEach(t -> System.out.println(t.toString()));
    }

    @Override
    public void listarTareas() {
        System.out.println("Las tareas que hay en el sistema son las siguientes:");
        System.out.println("-----------------------------------------------------");
        tareaDAO.findAll().forEach(t -> System.out.println(t.toString()));
    }

    @Override
    public void listarGrupos() {
        System.out.println("Los grupos que hay en el sistema son los siguientes:");
        System.out.println("-----------------------------------------------------");
        grupoDAO.findAll().forEach(g -> System.out.println(g.toString()));
    }

    @Override
    public void crearTecnico(String nom, String ape) {
        Tecnico t = new Tecnico(nom, ape);
        tecnicoDAO.save(t);
        System.out.println("Se ha Creado el técnico: " + t.toString() + " con éxito.");
    }

    @Override
    public void crearIncidencia(String nombre, String descripcion, int tiempoEstimación) {
        Incidencia i = new Incidencia(nombre, descripcion, tiempoEstimación, null);
        incidenciaDAO.save(i);
    }

    @Override
    public void crearTarea(String nombre, Tecnico tecnico, List<Incidencia> incidencias) {
        Tarea tarea = new Tarea(nombre, tecnico, incidencias);
        int tareasTecnico = tecnicoDAO.obtenerPorId(tecnico.getId()).getNumTareas();
        tecnicoDAO.obtenerPorId(tecnico.getId()).setNumTareas(tareasTecnico + 1);
        incidencias.forEach((i) -> {
            incidenciaDAO.obtenerPorId(i.getId()).setTarea(tarea);
        });
        tareaDAO.save(tarea);
    }

    @Override
    public Incidencia seleccionarIncidencia(int index) {
        return incidenciaDAO.findIncidenciasNuevasSinTarea().get(index);

    }

    @Override
    public Tecnico seleccionarTecnico(int index) {
        return tecnicoDAO.findTecnicoDisponible().get(index);
    }

    @Override
    public void crearGrupo(String nombre, String codigo) {
        Grupo grupo = new Grupo(codigo, nombre);
        grupoDAO.save(grupo);
    }

    @Override
    public void listarTecnicosDisponibles() {
        System.out.println("Técnicos disponibles: ");
        System.out.println("-----------------------------");
        tecnicoDAO.findTecnicoDisponible().forEach(t -> {
            int cont = 0;
            System.out.println(t.toString() + "[" + cont + "]");
        });

    }

    @Override
    public void realizarCargaMasivaDeDatos() {
        Tecnico t1 = new Tecnico("Manuel ", "Córdoba");
        Tecnico t2 = new Tecnico("Pascuala ", "Herrero");
        Tecnico t3 = new Tecnico("Angeles  ", "Rubio");
        Tecnico t4 = new Tecnico("Óscar  ", "Tellez");
        Tecnico t5 = new Tecnico("Jone ", "Berrocal");
        Tecnico t6 = new Tecnico("Rodolfo  ", "Canto");
        Tecnico t7 = new Tecnico("Paulino  ", "Herreros");
        Tecnico t8 = new Tecnico("Glória  ", "Fuster");
        Tecnico t9 = new Tecnico("Andrei  ", "Palomo");
        Tecnico t10 = new Tecnico("Maria-Ester ", "Baños");
        Tecnico t11 = new Tecnico("Barbara  ", "Sánchez");
        Tecnico t12 = new Tecnico("Abdeslam ", "Royo");
        Tecnico t13 = new Tecnico("Raimundo  ", "Murcia");
        Tecnico t14 = new Tecnico("Paul  ", "Villa");
        Tecnico t15 = new Tecnico("Aleix  ", "Jordan");
        Tecnico t16 = new Tecnico("Maria Angels ", "Pina");
        Tecnico t17 = new Tecnico("Elisabeth ", "Molinero");
        Tecnico t18 = new Tecnico("Maria", "Beatriz Rojo");
        Tecnico t19 = new Tecnico("Amaia ", "Cuadrado");
        Tecnico t20 = new Tecnico("Aquilino", "Casanova");
        List<Tecnico> listaTecnicos = new ArrayList<>();
        listaTecnicos.add(t1);
        listaTecnicos.add(t2);
        listaTecnicos.add(t3);
        listaTecnicos.add(t4);
        listaTecnicos.add(t5);
        listaTecnicos.add(t6);
        listaTecnicos.add(t7);
        listaTecnicos.add(t8);
        listaTecnicos.add(t9);
        listaTecnicos.add(t10);
        listaTecnicos.add(t11);
        listaTecnicos.add(t12);
        listaTecnicos.add(t13);
        listaTecnicos.add(t14);
        listaTecnicos.add(t15);
        listaTecnicos.add(t16);
        listaTecnicos.add(t17);
        listaTecnicos.add(t18);
        listaTecnicos.add(t19);
        listaTecnicos.add(t20);
        tecnicoDAO.saveAll(listaTecnicos);

        Grupo g1 = new Grupo("GRU01", "Grupo de Hardware");
        Grupo g2 = new Grupo("GRU02", "Grupo de Software");
        Grupo g3 = new Grupo("GRU03", "Grupo de Incidencias menores");
        Grupo g4 = new Grupo("GRU04", "Grupo de Incidencias Consola");
        Grupo g5 = new Grupo("GRU05", "Grupo de Incidecias PC");
        List<Grupo> listaGrupos = new ArrayList<>();
        listaGrupos.add(g1);
        listaGrupos.add(g2);
        listaGrupos.add(g3);
        listaGrupos.add(g4);
        listaGrupos.add(g5);
        grupoDAO.saveAll(listaGrupos);

        Incidencia i1 = new Incidencia("Incidencia 01", "Error en el emparejamiento cruzado", 4, null);
        Incidencia i2 = new Incidencia("Incidencia 02", "Error en el soporte de guardado", 2, null);
        Incidencia i3 = new Incidencia("Incidencia 03", "Error en la carga de texturas", 6, null);
        Incidencia i4 = new Incidencia("Incidencia 04", "Error en la carga de niveles del juego.", 3, null);
        Incidencia i5 = new Incidencia("Incidencia 05", "Problema con la reproducción de sonidos en el menú principal.", 4, null);
        Incidencia i6 = new Incidencia("Incidencia 06", "Fallo en el sistema de detección de colisiones.", 5, null);
        Incidencia i7 = new Incidencia("Incidencia 07", "Error al guardar el progreso del jugador.", 6, null);
        Incidencia i8 = new Incidencia("Incidencia 08", "Pantalla en negro al iniciar el juego.", 6, null);
        Incidencia i9 = new Incidencia("Incidencia 09", "Problema con la sincronización de animaciones.", 7, null);
        Incidencia i10 = new Incidencia("Incidencia 10", "Inestabilidad en el rendimiento durante las partidas.", 10, null);
        Incidencia i11 = new Incidencia("Incidencia 11", "Error al conectarse a los servidores en línea.", 24, null);
        Incidencia i12 = new Incidencia("Incidencia 12", "Mensajes de error confusos al intentar iniciar sesión.", 16, null);
        Incidencia i13 = new Incidencia("Incidencia 13", "Problema con la configuración de controles personalizados.", 26, null);
        Incidencia i14 = new Incidencia("Incidencia 14", "Fallo en el sistema de autoguardado.", 7, null);
        Incidencia i15 = new Incidencia("Incidencia 15", "Bloqueo aleatorio del juego durante las partidas.", 8, null);
        Incidencia i16 = new Incidencia("Incidencia 16", "Texturas distorsionadas en los elementos del escenario.", 12, null);
        Incidencia i17 = new Incidencia("Incidencia 17", "Error al completar las misiones secundarias.", 12, null);
        Incidencia i18 = new Incidencia("Incidencia 18", "Problema con la generación procedural de niveles.", 15, null);
        Incidencia i19 = new Incidencia("Incidencia 19", "Incompatibilidad con ciertos controladores de gamepad.", 17, null);
        Incidencia i20 = new Incidencia("Incidencia 20", "Fallo en la sincronización de logros y trofeos.", 20, null);
        Incidencia i21 = new Incidencia("Incidencia 21", "Congelamiento de la pantalla al cambiar de ubicación.", 1, null);
        Incidencia i22 = new Incidencia("Incidencia 22", "Errores ortográficos en los textos del juego.", 3, null);
        Incidencia i23 = new Incidencia("Incidencia 23", "Problema con la inteligencia artificial de los enemigos.", 5, null);
        Incidencia i24 = new Incidencia("Incidencia 24", "Ralentización excesiva durante las escenas cinemáticas.", 9, null);
        Incidencia i25 = new Incidencia("Incidencia 25", "Fallo en la función de reinicio de niveles.", 12, null);
        Incidencia i26 = new Incidencia("Incidencia 26", "Error al desbloquear contenido adicional.", 24, null);
        Incidencia i27 = new Incidencia("Incidencia 27", "Problema con la detección de conexión a Internet.", 18, null);
        Incidencia i28 = new Incidencia("Incidencia 28", "Desincronización de logros en la versión para consola.", 21, null);
        Incidencia i29 = new Incidencia("Incidencia 29", "Falta de efectos de sonido en las secuencias de combate.", 6, null);
        Incidencia i30 = new Incidencia("Incidencia 30", "Problema con la estabilidad del servidor multijugador.", 4, null);
        Incidencia i31 = new Incidencia("Incidencia 31", "Error al guardar las configuraciones de audio.", 3, null);
        Incidencia i32 = new Incidencia("Incidencia 32", "Bloqueo del juego al abrir el inventario.", 9, null);
        Incidencia i33 = new Incidencia("Incidencia 33", "Problema con la generación aleatoria de eventos.", 10, null);
        List<Incidencia> listaIncidencias = new ArrayList<>();
        listaIncidencias.add(i1);
        listaIncidencias.add(i2);
        listaIncidencias.add(i3);
        listaIncidencias.add(i4);
        listaIncidencias.add(i5);
        listaIncidencias.add(i6);
        listaIncidencias.add(i7);
        listaIncidencias.add(i8);
        listaIncidencias.add(i9);
        listaIncidencias.add(i10);
        listaIncidencias.add(i11);
        listaIncidencias.add(i12);
        listaIncidencias.add(i13);
        listaIncidencias.add(i14);
        listaIncidencias.add(i15);
        listaIncidencias.add(i16);
        listaIncidencias.add(i17);
        listaIncidencias.add(i18);
        listaIncidencias.add(i19);
        listaIncidencias.add(i20);
        listaIncidencias.add(i21);
        listaIncidencias.add(i22);
        listaIncidencias.add(i23);
        listaIncidencias.add(i24);
        listaIncidencias.add(i25);
        listaIncidencias.add(i26);
        listaIncidencias.add(i27);
        listaIncidencias.add(i28);
        listaIncidencias.add(i29);
        listaIncidencias.add(i30);
        listaIncidencias.add(i31);
        listaIncidencias.add(i32);
        listaIncidencias.add(i33);
        incidenciaDAO.saveAll(listaIncidencias);

        List<Incidencia> listaIncidenciasTarea1 = new ArrayList<>();
        listaIncidenciasTarea1.add(i1);
        listaIncidenciasTarea1.add(i2);
        listaIncidenciasTarea1.add(i3);
        Tarea ta1 = new Tarea("Tarea 1: Realizar pruebas exhaustivas de rendimiento y"
                + " estabilidad del servidor en entornos de carga masiva, simulando"
                + " miles de usuarios simultáneos para identificar y corregir posibles "
                + "cuellos de botella y mejorar la capacidad de respuesta y escalabilidad del sistema.", t1, listaIncidenciasTarea1);
        i1.setTarea(ta1);
        i2.setTarea(ta1);
        i3.setTarea(ta1);

        List<Incidencia> listaIncidenciasTarea2 = new ArrayList<>();
        listaIncidenciasTarea1.add(i4);
        listaIncidenciasTarea1.add(i5);
        Tarea ta2 = new Tarea("Tarea 2: Investigar a fondo los errores de optimización"
                + " en el motor gráfico del juego, identificar las áreas problemáticas y"
                + " aplicar técnicas avanzadas de programación y renderizado para mejorar"
                + " la tasa de frames por segundo, reducir los tiempos de carga"
                + " y garantizar una experiencia visual fluida y de alta calidad.", t2, listaIncidenciasTarea1);
        i4.setTarea(ta2);
        i5.setTarea(ta2);

        List<Tarea> listaTareas = new ArrayList<>();
        listaTareas.add(ta1);
        listaTareas.add(ta2);
        tareaDAO.saveAll(listaTareas);

    }

    @Override
    public void listarIncideciasDisponibles() {
        System.out.println("Incidencias disponibles: ");
        System.out.println("-----------------------------");
        incidenciaDAO.findIncidenciasNuevasSinTarea().forEach(t -> System.out.println(t.toString()));
    }

}
