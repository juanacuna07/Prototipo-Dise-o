/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

/**
 * Interfaz que deben implementar los agentes capaces de recalibrar sus
 * parametros de operacion (por ejemplo, mejorar su precision o reiniciar
 * contadores de error tras una revision).
 *
 * En el diagrama de clases, esta interfaz cumple el mismo rol que
 * "ICertificable" / "IAplicable": es implementada por la clase que hace
 * las veces de "Clase C".
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public interface IRecalibrable {

    /**
     * Recalibra al agente, ajustando alguno de sus parametros operativos.
     */
    public void recalibrar();
}
