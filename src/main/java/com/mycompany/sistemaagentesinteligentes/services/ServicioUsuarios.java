/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

import com.mycompany.sistemaagentesinteligentes.model.AgenteAsistenciaMedica;
import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import com.mycompany.sistemaagentesinteligentes.model.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 * Servicio central de usuarios (Clase D). Sigue el mismo patron Singleton
 * que ServicioAgentes: los datos viven unicamente en memoria mientras la
 * aplicacion esta abierta.
 *
 * Cada Usuario queda asociado a un AgenteAsistenciaMedica (Clase B) a
 * traves de su idAgenteAsistencia, igual que AccesorioCuerda se asocia a
 * InstrumentoCuerda en la guia: al adicionar, actualizar o eliminar un
 * Usuario, este servicio mantiene sincronizada la lista de usuarios
 * asistidos del AgenteAsistenciaMedica correspondiente.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class ServicioUsuarios implements IServicioUsuarios {

    private Map<Integer, Usuario> usuarios = new HashMap<>();

    // Unica instancia de la clase
    private static ServicioUsuarios instancia;

    // Constructor privado
    private ServicioUsuarios() {
    }

    // Metodo para obtener la unica instancia
    public static ServicioUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ServicioUsuarios();
        }

        return instancia;
    }

    private AgenteAsistenciaMedica buscarAgenteAsistenciaMedica(int idAgenteAsistencia) throws Exception {
        AgenteInteligente agente = ServicioAgentes.getInstancia().buscarAgente(idAgenteAsistencia);
        if (agente == null) {
            throw new Exception("No existe ningún agente con el ID " + idAgenteAsistencia);
        }
        if (!(agente instanceof AgenteAsistenciaMedica)) {
            throw new Exception("El agente con ID " + idAgenteAsistencia + " no es un agente de asistencia medica");
        }
        return (AgenteAsistenciaMedica) agente;
    }

    @Override
    public Map<Integer, Usuario> getUsuarios() {
        return Map.copyOf(usuarios);
    }

    @Override
    public void addUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("El usuario no puede ser nulo");
        }
        if (usuarios.containsKey(usuario.getIdUsuario())) {
            throw new Exception("Ya existe un usuario registrado con el ID " + usuario.getIdUsuario());
        }

        AgenteAsistenciaMedica agente = buscarAgenteAsistenciaMedica(usuario.getIdAgenteAsistencia());
        agente.agregarUsuarioAsistido(usuario);

        usuarios.put(usuario.getIdUsuario(), usuario);
        ServicioObserver.cambio();
    }

    @Override
    public void deleteUsuario(int id) throws Exception {
        Usuario usuarioActual = usuarios.get(id);
        if (usuarioActual == null) {
            throw new Exception("No se ha encontrado ningun usuario para eliminar");
        }

        AgenteAsistenciaMedica agente = buscarAgenteAsistenciaMedica(usuarioActual.getIdAgenteAsistencia());
        agente.removerUsuarioAsistido(usuarioActual);

        usuarios.remove(id);
        ServicioObserver.cambio();
    }

    @Override
    public void actualizarUsuario(int id, Usuario usuarioNuevo) throws Exception {
        Usuario usuarioActual = usuarios.get(id);
        if (usuarioActual == null) {
            throw new Exception("No se ha encontrado ningun usuario para actualizar");
        }
        if (usuarioNuevo == null) {
            throw new Exception("El usuario actualizado no puede ser nulo");
        }
        if (usuarioNuevo.getIdUsuario() != id && usuarios.containsKey(usuarioNuevo.getIdUsuario())) {
            throw new Exception("Ya existe un usuario registrado con el ID " + usuarioNuevo.getIdUsuario());
        }

        // Se valida primero que el nuevo agente asociado exista y sea valido
        AgenteAsistenciaMedica agenteNuevo = buscarAgenteAsistenciaMedica(usuarioNuevo.getIdAgenteAsistencia());

        // Se retira el usuario actual de su agente original
        AgenteAsistenciaMedica agenteActual = buscarAgenteAsistenciaMedica(usuarioActual.getIdAgenteAsistencia());
        agenteActual.removerUsuarioAsistido(usuarioActual);

        // Se agrega el usuario actualizado a su agente (puede ser el mismo u otro)
        agenteNuevo.agregarUsuarioAsistido(usuarioNuevo);

        usuarios.remove(id);
        usuarios.put(usuarioNuevo.getIdUsuario(), usuarioNuevo);
        ServicioObserver.cambio();
    }

    @Override
    public Usuario buscarUsuario(int id) {
        return usuarios.get(id);
    }
}
