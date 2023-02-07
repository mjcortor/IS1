package com.upo.ingameapp.view;

import com.upo.ingameapp.bo.impl.NegocioBOImpl;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.upo.ingameapp.model.Tecnico;

/**
 *
 * @author Manuel
 */
public class View {

    private NegocioBOImpl negocio = new NegocioBOImpl();

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

    public void menu() {
        int opc = 0;
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        //carga datos masiva:
        this.negocio.realizarCargaMasivaDeDatos();
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

    private void menuGestionTecnicos() {

        int opc;
        Scanner sc = new Scanner(System.in);

        try {

            mostrarMenuGestionTecnicos();

            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("Entrando a añadir técnico...");
                    aniadirTecnico();

                    break;
                case 2:
                    System.out.println("Entrando a añadir grupo...");
                    aniadirGrupo();
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
                    System.out.println("Entrando a Consultar Tarea Técnico...");
                    consultarTareasTecnico();
                    break;
                case 2:
                    System.out.println("Entrando a Consultar Tarea Grupo...");

                    break;

                case 3:
                    System.out.println("Entrando a Consultar Incidencias...");

                    break;

                case 4:
                    System.out.println("Entrando a Agrupación Automática de Tareas a Grupos...");

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

    //Métodos taareas de menu gestión de Técnicos.
    private void aniadirTecnico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el código único para el Técnico:");
        String codigo = sc.next();
        System.out.println("Introduzca el nombre del Técnico");
        String nombre = sc.next();
        System.out.println("Introduzca el apellido del Técnico");
        this.negocio.introducirDatosTecnico(codigo, nombre, nombre);
        System.out.println("Ahora los técnicos son los siguientes:");
        this.negocio.obtenerTecnicos();

    }

    private void aniadirGrupo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del grupo.");
        String nombreGrupo = sc.next();
        System.out.println("Introduzca el código del grupo:");
        String codigo = sc.next();
        this.negocio.crearGrupo(nombreGrupo, codigo);

    }

    //Implementar métodos para menu de Incidencias y menú de Tareas
    //Métodos para menú de estadisticas:
    private void consultarTareasTecnico() {
        Scanner sc = new Scanner(System.in);
        this.negocio.obtenerTecnicos();
        int index = sc.nextInt();       
        this.negocio.consultarTareasTecnico( this.negocio.seleccionarTecnico(index));
    }
}
