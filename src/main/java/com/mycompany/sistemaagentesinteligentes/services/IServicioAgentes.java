/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import java.util.Map;

/**
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public interface IServicioAgentes {

    public void addAgente(AgenteInteligente agente) throws Exception;
    public Map<Integer, AgenteInteligente> getAgentes();
    public void deleteAgente(int id) throws Exception;
    public void actualizarAgente(int id, AgenteInteligente agente) throws Exception;
    public AgenteInteligente buscarAgente(int id) throws Exception;
}
