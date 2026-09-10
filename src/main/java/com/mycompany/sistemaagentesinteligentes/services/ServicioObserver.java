/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

import com.mycompany.sistemaagentesinteligentes.gui.ICambiable;
import java.util.ArrayList;

/**
 * Patron Observer: mantiene la lista de ventanas (GUIListar...) que deben
 * refrescarse automaticamente cada vez que ServicioAgentes cambia sus datos.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class ServicioObserver {

    private static ArrayList<ICambiable> guisAgente = new ArrayList<>();

    public static void addGUIAgente(ICambiable gui) {
        guisAgente.add(gui);
    }

    public static void cambio() {
        for (ICambiable gui : guisAgente) {
            gui.cambio();
        }
    }

    public static void delGUIAgente(ICambiable gui) {
        guisAgente.remove(gui);
    }
}
