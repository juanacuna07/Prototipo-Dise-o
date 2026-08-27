/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * AgenteAsistenciaMedica reemplaza a AgenteAsistencia: hereda (extends)
 * directamente de AgenteInteligente y contiene todos los atributos y metodos
 * que antes tenia AgenteAsistencia, mas sus propios atributos medicos.
 *
 * Esta clase cumple el rol de "Clase B" del diagrama de clases: hereda de
 * AgenteInteligente (Clase A) y esta asociada a Usuario (Clase D, sin
 * implementar sus funcionalidades en este prototipo). Ademas sobreescribe
 * calcularRendimiento() para aplicar polimorfismo junto con AgenteNavegacion.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class AgenteAsistenciaMedica extends AgenteInteligente {

    private static final long serialVersionUID = 1L;

    // Atributos que antes pertenecian a AgenteAsistencia
    private String usuarioAsignado;
    private String tipoAsistencia;
    private int nivelUrgencia;
    private int comandosProcesados;
    private String idiomaRespuesta;

    // Atributos propios de la asistencia medica
    private String especialidadMedica;
    private int nivelPrioridadPaciente;
    private boolean protocoloEmergencia;
    private int signosVitalesMonitoreados;
    private double tiempoRespuestaMedica;

    // Asociacion 1 (AgenteAsistenciaMedica) -- 1..* (Usuario): "asiste"
    private List<Usuario> usuariosAsistidos;

    public AgenteAsistenciaMedica(int idAgente, String nombre, double nivelAutonomia, String estadoOperativo, double nivelConfianza,
            String usuarioAsignado, String tipoAsistencia, int nivelUrgencia, int comandosProcesados, String idiomaRespuesta,
            String especialidadMedica, int nivelPrioridadPaciente, boolean protocoloEmergencia, int signosVitalesMonitoreados, double tiempoRespuestaMedica) throws Exception
    {
        super(idAgente, nombre, nivelAutonomia, estadoOperativo, nivelConfianza);
        this.usuarioAsignado = usuarioAsignado;
        this.tipoAsistencia = tipoAsistencia;
        setNivelUrgencia(nivelUrgencia);
        setComandosProcesados(comandosProcesados);
        this.idiomaRespuesta = idiomaRespuesta;
        this.especialidadMedica = especialidadMedica;
        setNivelPrioridadPaciente(nivelPrioridadPaciente);
        this.protocoloEmergencia = protocoloEmergencia;
        this.signosVitalesMonitoreados = signosVitalesMonitoreados;
        setTiempoRespuestaMedica(tiempoRespuestaMedica);
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

    public String getUsuarioAsignado()
    {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(String usuarioAsignado)
    {
        this.usuarioAsignado = usuarioAsignado;
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

    public int getComandosProcesados()
    {
        return comandosProcesados;
    }

    public void setComandosProcesados(int comandosProcesados) throws Exception
    {
        if(comandosProcesados >= 0){
            this.comandosProcesados = comandosProcesados;
        } else {
            throw new Exception("Los comandos procesados no pueden ser negativos");
        }
    }

    public String getIdiomaRespuesta()
    {
        return idiomaRespuesta;
    }

    public void setIdiomaRespuesta(String idiomaRespuesta)
    {
        this.idiomaRespuesta = idiomaRespuesta;
    }

    public String getEspecialidadMedica()
    {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(String especialidadMedica)
    {
        this.especialidadMedica = especialidadMedica;
    }

    public int getNivelPrioridadPaciente()
    {
        return nivelPrioridadPaciente;
    }

    public void setNivelPrioridadPaciente(int nivelPrioridadPaciente) throws Exception
    {
        if(nivelPrioridadPaciente >= 1 && nivelPrioridadPaciente <= 5){
            this.nivelPrioridadPaciente = nivelPrioridadPaciente;
        } else {
            throw new Exception("El nivel de prioridad del paciente debe estar entre 1 y 5");
        }
    }

    public boolean isProtocoloEmergencia()
    {
        return protocoloEmergencia;
    }

    public void setProtocoloEmergencia(boolean protocoloEmergencia)
    {
        this.protocoloEmergencia = protocoloEmergencia;
    }

    public int getSignosVitalesMonitoreados()
    {
        return signosVitalesMonitoreados;
    }

    public void setSignosVitalesMonitoreados(int signosVitalesMonitoreados)
    {
        this.signosVitalesMonitoreados = signosVitalesMonitoreados;
    }

    public double getTiempoRespuestaMedica()
    {
        return tiempoRespuestaMedica;
    }

    public void setTiempoRespuestaMedica(double tiempoRespuestaMedica) throws Exception
    {
        if(tiempoRespuestaMedica >= 0){
            this.tiempoRespuestaMedica = tiempoRespuestaMedica;
        } else {
            throw new Exception("El tiempo de respuesta medica no puede ser negativo");
        }
    }

    /**
     * Calculo de rendimiento propio de un agente de asistencia medica:
     * parte del nivel de confianza, suma un aporte por los signos vitales
     * monitoreados y penaliza segun la urgencia del caso y el tiempo de
     * respuesta medica.
     */
    @Override
    public double calcularRendimiento()
    {
        double resultado = getNivelConfianza()
                + (signosVitalesMonitoreados * 0.5)
                - (nivelUrgencia * 5)
                - tiempoRespuestaMedica;
        return Math.max(0, resultado);
    }
}
