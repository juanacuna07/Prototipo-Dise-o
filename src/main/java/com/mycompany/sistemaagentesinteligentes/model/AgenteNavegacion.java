/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.model;

/**
 * AgenteNavegacion cumple el rol de "Clase C" del diagrama de clases:
 * hereda de AgenteInteligente (Clase A) e implementa la interfaz
 * IAplicable, ademas de sobreescribir calcularRendimiento() para
 * aplicar polimorfismo junto con AgenteAsistenciaMedica.
 *
 * Se mantienen unicamente los atributos propios esenciales para el caso de
 * estudio (origen, destino y precision GPS), sin atributos adicionales que
 * no aportan al objetivo del prototipo.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class AgenteNavegacion extends AgenteInteligente implements IAplicable {

    private String origen;
    private String destino;
    private double precisionGPS;

    public AgenteNavegacion(int idAgente, String nombre, double nivelAutonomia, String estadoOperativo, double nivelConfianza,
            String origen, String destino, double precisionGPS) throws Exception
    {
        super(idAgente, nombre, nivelAutonomia, estadoOperativo, nivelConfianza);
        this.origen = origen;
        this.destino = destino;
        setPrecisionGPS(precisionGPS);
    }

    public String getOrigen()
    {
        return origen;
    }

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }

    public String getDestino()
    {
        return destino;
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public double getPrecisionGPS()
    {
        return precisionGPS;
    }

    public void setPrecisionGPS(double precisionGPS) throws Exception
    {
        if(precisionGPS >= 0 && precisionGPS <= 100){
            this.precisionGPS = precisionGPS;
        } else {
            throw new Exception("La precision GPS debe estar entre 0 y 100");
        }
    }

    /**
     * Calculo de rendimiento propio de un agente de navegacion: promedia
     * la precision GPS con el nivel de confianza.
     */
    @Override
    public double calcularRendimiento()
    {
        double resultado = (precisionGPS + getNivelConfianza()) / 2.0;
        return Math.max(0, resultado);
    }

    /**
     * Implementacion de IAplicable: aplica una recalibracion del sistema
     * de navegacion, mejorando la precision GPS.
     */
    @Override
    public void aplicar()
    {
        try {
            setPrecisionGPS(Math.min(100, this.precisionGPS + 5));
        } catch (Exception e) {
            // No deberia ocurrir: el valor usado siempre es valido.
        }
    }
}
