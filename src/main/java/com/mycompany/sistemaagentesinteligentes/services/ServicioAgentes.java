/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import java.util.HashMap;
import java.util.Map;

/**
 * Servicio central de agentes. Sigue el mismo patron Singleton que
 * ServicioInstrumentos de la guia: los datos viven unicamente en memoria
 * mientras la aplicacion esta abierta (no se guarda ni se lee nada de disco).
 * Cada vez que se adiciona, actualiza o elimina un agente se notifica a
 * traves de ServicioObserver para que las ventanas de listado se refresquen
 * automaticamente.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class ServicioAgentes implements IServicioAgentes {

    private Map<Integer, AgenteInteligente> agentes = new HashMap<>();

    // Unica instancia de la clase
    private static ServicioAgentes instancia;

    // Constructor privado
    private ServicioAgentes() {
    }

    // Metodo para obtener la unica instancia
    public static ServicioAgentes getInstancia() {
        if (instancia == null) {
            instancia = new ServicioAgentes();
        }

        return instancia;
    }

    @Override
    public Map<Integer, AgenteInteligente> getAgentes() {
        return Map.copyOf(agentes);
    }

    @Override
    public void addAgente(AgenteInteligente agente) throws Exception {
        if (agente == null) {
            throw new Exception("El agente no puede ser nulo");
        }
        if (agentes.containsKey(agente.getIdAgente())) {
            throw new Exception("Ya existe un agente registrado con el ID " + agente.getIdAgente());
        }

        agentes.put(agente.getIdAgente(), agente);
        ServicioObserver.cambio();
    }

    @Override
    public void deleteAgente(int id) throws Exception {
        if (!agentes.containsKey(id)) {
            throw new Exception("No se ha encontrado ningun agente para eliminar");
        }

        agentes.remove(id);
        ServicioObserver.cambio();
    }

    @Override
    public void actualizarAgente(int id, AgenteInteligente agente) throws Exception {
        if (!agentes.containsKey(id)) {
            throw new Exception("No se ha encontrado ningun agente para actualizar");
        }
        if (agente == null) {
            throw new Exception("El agente actualizado no puede ser nulo");
        }

        agentes.remove(id);
        agentes.put(agente.getIdAgente(), agente);
        ServicioObserver.cambio();
    }

    @Override
    public AgenteInteligente buscarAgente(int id) {
        return agentes.get(id);
    }
}
