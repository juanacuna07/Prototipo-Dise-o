/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

/**
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public abstract class AgenteInteligente {

    private int idAgente;
    private String nombre;
    private double nivelAutonomia;
    private String estadoOperativo;
    private double nivelConfianza;

    public AgenteInteligente(int idAgente, String nombre)
    {
        this.idAgente = idAgente;
        this.nombre = nombre;
    }

    public AgenteInteligente(int idAgente, String nombre, double nivelAutonomia, String estadoOperativo, double nivelConfianza) throws Exception
    {
        this(idAgente, nombre);
        setIdAgente(idAgente);
        setNivelAutonomia(nivelAutonomia);
        setEstadoOperativo(estadoOperativo);
        setNivelConfianza(nivelConfianza);
    }

    public int getIdAgente()
    {
        return idAgente;
    }

    public void setIdAgente(int idAgente) throws Exception
    {
        if (idAgente <= 0) {
            throw new Exception("El ID del agente debe ser un numero entero positivo (mayor que 0)");
        }
        this.idAgente = idAgente;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getNivelAutonomia()
    {
        return nivelAutonomia;
    }

    public void setNivelAutonomia(double nivelAutonomia) throws Exception
    {
        if(nivelAutonomia >= 0 && nivelAutonomia <= 100){
            this.nivelAutonomia = nivelAutonomia;
        } else {
            throw new Exception("Nivel de autonomia debe estar entre 0 y 100");
        }
    }

    public String getEstadoOperativo()
    {
        return estadoOperativo;
    }

    public void setEstadoOperativo(String estadoOperativo) throws Exception
    {
        if(estadoOperativo != null && (estadoOperativo.equalsIgnoreCase("ACTIVO")
                || estadoOperativo.equalsIgnoreCase("INACTIVO")
                || estadoOperativo.equalsIgnoreCase("MANTENIMIENTO"))){
            this.estadoOperativo = estadoOperativo.toUpperCase();
        } else {
            throw new Exception("Estado operativo invalido. Use ACTIVO, INACTIVO o MANTENIMIENTO");
        }
    }

    public double getNivelConfianza()
    {
        return nivelConfianza;
    }

    public void setNivelConfianza(double nivelConfianza) throws Exception
    {
        if(nivelConfianza >= 0 && nivelConfianza <= 100){
            this.nivelConfianza = nivelConfianza;
        } else {
            throw new Exception("Nivel de confianza debe estar entre 0 y 100");
        }
    }

    /**
     * Calcula un valor de rendimiento del agente a partir de sus propios
     * atributos. Cada clase derivada (AgenteNavegacion, AgenteAsistenciaMedica)
     * sobreescribe este metodo con su propia formula, de forma que al
     * invocarlo sobre una referencia de tipo AgenteInteligente se aplica
     * polimorfismo: el calculo real depende del tipo concreto del objeto
     * en tiempo de ejecucion.
     *
     * @return el valor de rendimiento calculado para el agente.
     */
    public abstract double calcularRendimiento();
}
