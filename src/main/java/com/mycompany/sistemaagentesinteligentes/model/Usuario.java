/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

import java.io.Serializable;

/**
 * Representa a un usuario que es asistido por un AgenteAsistenciaMedica.
 * Asociacion: 1 AgenteAsistenciaMedica -- 1..* Usuario ("asiste").
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idUsuario;
    private String nombre;
    private String correo;

    public Usuario(int idUsuario, String nombre, String correo)
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
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
}
