/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

/**
 * Representa a un usuario que es asistido por un AgenteAsistenciaMedica.
 * Cumple el rol de "Clase D" del diagrama de clases: esta asociada a la
 * Clase B (AgenteAsistenciaMedica) a traves del ID del agente al que
 * queda asignado (idAgenteAsistencia), igual que AccesorioCuerda se asocia
 * a InstrumentoCuerda mediante idInstrumento en la guia.
 * Asociacion: 1 AgenteAsistenciaMedica -- 1..* Usuario ("asiste").
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String correo;
    private int idAgenteAsistencia;

    public Usuario(int idUsuario, String nombre, String correo, int idAgenteAsistencia)
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.idAgenteAsistencia = idAgenteAsistencia;
    }

    public int getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public int getIdAgenteAsistencia()
    {
        return idAgenteAsistencia;
    }

    public void setIdAgenteAsistencia(int idAgenteAsistencia)
    {
        this.idAgenteAsistencia = idAgenteAsistencia;
    }
}
