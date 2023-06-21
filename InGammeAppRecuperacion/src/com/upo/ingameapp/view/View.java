package com.upo.ingameapp.view;

import com.upo.ingameapp.controller.IController;
import com.upo.ingameapp.controller.impl.ControllerImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class View {

    /* SERVICIOS */
    private IController controller = new ControllerImpl();

    public void menu() {
        int opc = 0;
        boolean salir = false;
        Scanner sc = new Scanner(System.in);

        do {
            mostrarMenuPrincipal();

            try {

                opc = sc.nextInt();

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

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero");
                sc.next();
            }

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
        System.out.println("2. Listar Incidencias.");
        System.out.println("");
        System.out.println("0. Salir");

    }

    private void mostrarMenuGestionTareas() {
        System.out.println("Menu Gestión Incidencias");
        System.out.println("-------------------------------");
        System.out.println("1. Introducir Tarea.");
        System.out.println("2. Introducir Tareas a Grupos.");
        System.out.println("");
        System.out.println("0. Salir");

    }

    private void mostrarMenuEstadisticas() {
        System.out.println("Menu Estadisticas");
        System.out.println("-------------------------------");

        System.out.println("1. Consultar Tarea Técnico");
        System.out.println("2. Consultar Tarea Grupo");
        System.out.println("3. Consultar Incidencias");
        System.out.println("4. Agrupación Automática de Tareas a Grupos.");
        System.out.println("");
        System.out.println("0. Salir");
    }

    private void menuGestionTecnicos() {

        int opc;
        Scanner sc = new Scanner(System.in);

        try {

            mostrarMenuGestionTecnicos();

            opc = sc.nextInt();

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

        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un numero");
            sc.next();
        }
    }

    private void menuGestionIncidencias() {

        int opc;
        Scanner sc = new Scanner(System.in);

        try {

            mostrarMenuGestionIncidencias();

            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("Entrando a añadir incidencia...");

                    break;
                case 2:
                    System.out.println("Entrando a listar incidencias...");

                    break;

                case 0:
                    System.out.println("Volviendo atras...");

                    menu();
                    break;
                default:
                    System.out.println("Esa opción no está disponible. Volviendo atrás.");
                    break;

            }

        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un numero");
            sc.next();
        }
    }

    private void menuTareas() {

        int opc;
        Scanner sc = new Scanner(System.in);

        try {

            mostrarMenuGestionTareas();

            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("Entrando a añadir tarea a técnico...");

                    break;
                case 2:
                    System.out.println("Entrando a añadir tareas a grupo...");

                    break;

                case 0:
                    System.out.println("Volviendo atras...");

                    menu();
                    break;
                default:
                    System.out.println("Esa opción no está disponible. Volviendo atrás.");
                    break;

            }

        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un numero");
            sc.next();
        }
    }

    private void menuEstadisticas() {

        int opc;
        Scanner sc = new Scanner(System.in);

        try {

            mostrarMenuEstadisticas();

            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("Consultar Estadísticas: ");
                    controller.mostrarEstadisticas();
                    break;

                case 0:
                    System.out.println("Volviendo atras...");

                    menu();
                    break;

            }

        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un numero");
            sc.next();
        }
    }

    // Métodos taareas de menu gestión de Técnicos.
}
