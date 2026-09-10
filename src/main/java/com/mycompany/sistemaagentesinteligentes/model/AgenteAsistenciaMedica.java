/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase cumple el rol de "Clase B" del diagrama de clases: hereda de
 * AgenteInteligente (Clase A) y esta asociada a Usuario (Clase D) a traves
 * de la lista usuariosAsistidos (gestionada por ServicioUsuarios). Ademas
 * sobreescribe calcularRendimiento() para aplicar polimorfismo junto con
 * AgenteNavegacion.
 *
 * Se mantienen unicamente los atributos propios esenciales para el caso de
 * estudio (tipo de asistencia, urgencia, especialidad y protocolo de
 * emergencia), sin atributos adicionales que no aportan al objetivo del
 * prototipo.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class AgenteAsistenciaMedica extends AgenteInteligente {

    private String tipoAsistencia;
    private int nivelUrgencia;
    private String especialidadMedica;
    private boolean protocoloEmergencia;

    // Asociacion 1 (AgenteAsistenciaMedica) -- 1..* (Usuario): "asiste"
    private List<Usuario> usuariosAsistidos;

    public AgenteAsistenciaMedica(int idAgente, String nombre, double nivelAutonomia, String estadoOperativo, double nivelConfianza,
            String tipoAsistencia, int nivelUrgencia, String especialidadMedica, boolean protocoloEmergencia) throws Exception
    {
        super(idAgente, nombre, nivelAutonomia, estadoOperativo, nivelConfianza);
        this.tipoAsistencia = tipoAsistencia;
        setNivelUrgencia(nivelUrgencia);
        this.especialidadMedica = especialidadMedica;
        this.protocoloEmergencia = protocoloEmergencia;
        this.usuariosAsistidos = new ArrayList<>();
    }

    public List<Usuario> getUsuariosAsistidos()
    {
        return usuariosAsistidos;
    }

    public void agregarUsuarioAsistido(Usuario usuario) throws Exception
    {
        if(usuario == null){
            throw new Exception("El usuario a asistir no puede ser nulo");
        }
        this.usuariosAsistidos.add(usuario);
    }

    public void removerUsuarioAsistido(Usuario usuario)
    {
        this.usuariosAsistidos.remove(usuario);
    }

    public String getTipoAsistencia()
    {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(String tipoAsistencia)
    {
        this.tipoAsistencia = tipoAsistencia;
    }

    public int getNivelUrgencia()
    {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) throws Exception
    {
        if(nivelUrgencia >= 1 && nivelUrgencia <= 5){
            this.nivelUrgencia = nivelUrgencia;
        } else {
            throw new Exception("El nivel de urgencia debe estar entre 1 y 5");
        }
    }

    public String getEspecialidadMedica()
    {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(String especialidadMedica)
    {
        this.especialidadMedica = especialidadMedica;
    }

    public boolean isProtocoloEmergencia()
    {
        return protocoloEmergencia;
    }

    public void setProtocoloEmergencia(boolean protocoloEmergencia)
    {
        this.protocoloEmergencia = protocoloEmergencia;
    }

    /**
     * Calculo de rendimiento propio de un agente de asistencia medica: parte
     * del nivel de confianza, penaliza segun la urgencia del caso (a mayor
     * urgencia, mas exigente es el estandar) y otorga un bono si el agente
     * tiene activado el protocolo de emergencia.
     */
    @Override
    public double calcularRendimiento()
    {
        double resultado = getNivelConfianza()
                - (nivelUrgencia * 10)
                + (protocoloEmergencia ? 15 : 0);
        return Math.max(0, resultado);
    }
}
