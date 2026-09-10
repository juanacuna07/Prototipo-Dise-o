/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

/**
 * Interfaz que deben implementar los agentes capaces de "aplicar" un ajuste
 * sobre sus propios parametros de operacion (por ejemplo, recalibrar su
 * precision o reiniciar su descripcion de obstaculos tras una revision).
 *
 * En el diagrama de clases del proyecto, esta interfaz cumple el rol de
 * IAplicable: es implementada por la clase que hace las veces de "Clase C"
 * (en este proyecto, AgenteNavegacion).
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public interface IAplicable {

    /**
     * Aplica un ajuste/recalibracion sobre el agente.
     */
    public void aplicar();
}
