/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

import com.mycompany.sistemaagentesinteligentes.model.Usuario;
import java.util.Map;

/**
 * Servicio para gestionar la Clase D (Usuario), asociada a la Clase B
 * (AgenteAsistenciaMedica).
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public interface IServicioUsuarios {

    public void addUsuario(Usuario usuario) throws Exception;
    public Map<Integer, Usuario> getUsuarios();
    public void deleteUsuario(int id) throws Exception;
    public void actualizarUsuario(int id, Usuario usuario) throws Exception;
    public Usuario buscarUsuario(int id) throws Exception;
}
