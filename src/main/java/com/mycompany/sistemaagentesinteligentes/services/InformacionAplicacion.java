/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

/**
 * Clase Singleton que guarda la informacion general de la aplicacion
 * (nombre, version e integrantes del equipo). Es utilizada por la ventana
 * principal para mostrar el cuadro "Acerca de..." del menu Ayuda.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class InformacionAplicacion {

    private final String nombreAplicacion;
    private final String version;
    private final String integrantes;

    // Unica instancia de la clase
    private static InformacionAplicacion instancia;

    // Constructor privado
    private InformacionAplicacion() {
        this.nombreAplicacion = "Sistema de Agentes Inteligentes";
        this.version = "Version 3.0";
        this.integrantes = "Juan Acuña, Luis Hernández, Stephany Trujillo";
    }

    // Metodo para obtener la unica instancia
    public static InformacionAplicacion getInstancia() {
        if (instancia == null) {
            instancia = new InformacionAplicacion();
        }

        return instancia;
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public String getVersion() {
        return version;
    }

    public String getIntegrantes() {
        return integrantes;
    }
}
