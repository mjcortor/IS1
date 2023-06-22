package com.upo.ingameapp.view;

import com.upo.ingameapp.main.IO;
import com.upo.ingameapp.controller.IController;
import com.upo.ingameapp.controller.impl.ControllerImpl;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class View {

    /* SERVICIOS */
    private final IController controller = new ControllerImpl();
    private IO io = new IO();

    public void menu() throws IOException {
        int opc = 0;
        boolean salir = false;

        do {
            mostrarMenuPrincipal();

//            try {
            opc = Integer.valueOf(io.obtenerBuffer().readLine());

            switch (opc) {

                case 1:
                    menuGestionTecnicos();

                    break;
                case 2:
                    menuGestionIncidencias();

                    break;

                case 3:
                    menuTareas();

                case 4:
                    menuEstadisticas();

                    break;
                case 0:
                    salir = true;
                    break;

            }

//            } catch (InputMismatchException e) {
//                System.out.println("Debes introducir un numero");
//                sc.next();
//            }
        } while (!salir);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("Menu InGameSupportApp");
        System.out.println("-------------------------------");
        System.out.println("1. Gestionar Técnicos.");
        System.out.println("2. Gestion Incidencias.");
        System.out.println("3. Gestionar Tareas.");
        System.out.println("4. Estadisticas.");
        System.out.println("");
        System.out.println("0. Salir");
    }

    private void mostrarMenuGestionTecnicos() {
        System.out.println("Menu Gestión Técnicos");
        System.out.println("-------------------------------");
        System.out.println("1. Añadir Técnico.");
        System.out.println("2. Crear Grupo.");
        System.out.println("");
        System.out.println("0. Salir");

    }

    private void mostrarMenuGestionIncidencias() {
        System.out.println("Menu Gestión Incidencias");
        System.out.println("-------------------------------");
        System.out.println("1. Añadir Incidencia.");
        System.out.println("2. Listar Incidencias disponibles.");
        System.out.println("");
        System.out.println("0. Salir");

    }

    private void mostrarMenuGestionTareas() {
        System.out.println("Menu Gestión Incidencias");
        System.out.println("-------------------------------");
        System.out.println("1. Introducir Tarea.");
        System.out.println("2. Asignación Automática de Tareas.");
        System.out.println("");
        System.out.println("0. Salir");

    }

    private void mostrarMenuEstadisticas() {
        System.out.println("Menu Estadisticas");
        System.out.println("-------------------------------");

        System.out.println("1. Obtener estadísticas del sistema.");
        System.out.println("2. Consultar Tareas.");
        System.out.println("3. Consultar Incidencias.");
        System.out.println("4. Consultar Técnicos.");
        System.out.println("5. Consultar Grupos.");
        System.out.println("6. Realizar carga masiva de datos.");
        System.out.println("");
        System.out.println("0. Salir");
    }

    private void menuGestionTecnicos() throws IOException {

        int opc;

        mostrarMenuGestionTecnicos();

        opc = Integer.valueOf(io.obtenerBuffer().readLine());

        switch (opc) {

            case 1:
                System.out.println("Entrando a añadir técnico...");
                controller.aniadirTecnico();

                break;
            case 2:
                System.out.println("Entrando a añadir grupo...");
                controller.aniadirGrupo();
                break;

            case 0:
                System.out.println("Volviendo atras...");
                menu();
                break;
            default:
                System.out.println("Esa opción no está disponible. Volviendo atrás.");
                break;

        }

    }

    private void menuGestionIncidencias() throws IOException {

        int opc;

        mostrarMenuGestionIncidencias();

        opc = Integer.valueOf(io.obtenerBuffer().readLine());

        switch (opc) {

            case 1:
                System.out.println("Entrando a añadir incidencia...");
                controller.aniadirIncidencia();
                break;
            case 2:
                System.out.println("Entrando a listar incidencias...");
                controller.listarIncidenciasDisponibles();
                break;

            case 0:
                System.out.println("Volviendo atras...");
                menu();
                break;
            default:
                System.out.println("Esa opción no está disponible. Volviendo atrás.");
                break;

        }

    }

    private void menuTareas() throws IOException {

        int opc;

        mostrarMenuGestionTareas();

        opc = Integer.valueOf(io.obtenerBuffer().readLine());

        switch (opc) {

            case 1:
                System.out.println("Entrando a Crear Tarea...");
                controller.crearTarea();
                break;
            case 2:
                System.out.println("Entrando a Asignación Automática de Tareas...");
                controller.asignacionAutomaticaTareas();
                break;

            case 0:
                System.out.println("Volviendo atras...");

                menu();
                break;
            default:
                System.out.println("Esa opción no está disponible. Volviendo atrás.");
                break;

        }

    }

    private void menuEstadisticas() throws IOException {

        int opc;

        mostrarMenuEstadisticas();

        opc = Integer.valueOf(io.obtenerBuffer().readLine());

        switch (opc) {

            case 1:
                System.out.println("Consultar Estadísticas: ");
                controller.mostrarEstadisticas();
                break;

            case 2:
                System.out.println("Mostrando todas las Tareas:");
                controller.listarTodasTareas();
                break;
            case 3:
                System.out.println("Mostrando todas las Incidencias:");
                controller.listarIncidencias();
                break;
            case 4:
                System.out.println("Mostrando todos los técnicos:");
                controller.listarTodosTecnicos();
                break;
            case 5:
                System.out.println("Mostrando todos los grupos:");
                controller.listarTodosGrupos();
            case 6:
                System.out.println("Realizando Carga Masiva de datos....");
                controller.realizarCargaDeDatos();
            case 0:
                System.out.println("Volviendo atrás..");

                menu();
                break;

        }

    }

    // Métodos taareas de menu gestión de Técnicos.
}
