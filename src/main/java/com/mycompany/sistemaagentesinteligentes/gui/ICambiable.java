/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.gui;

/**
 * Implementada por las ventanas que deben refrescar su contenido cada vez
 * que el ServicioObserver notifica un cambio en los datos de agentes
 * (adicion, edicion o eliminacion), sin importar en que ventana ocurrio.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public interface ICambiable {

    public void cambio();
}
