package com.upo.ingameapp.main;

import com.upo.ingameapp.view.View;
import java.io.IOException;

/**
 *
 * @author Manuel
 */
public class InGameSupportRunApp {

    public static void main(String[] args) {
        try {
            View v = new View();
            v.menu();
        } catch (IOException e) {
            System.err.println("SE HA PRODUCIDO UN ERROR DE ENTGRADA SALIDA EN EL MENU.");
        }
    }
}
