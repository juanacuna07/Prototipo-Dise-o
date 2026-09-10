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
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class AgenteNavegacion extends AgenteInteligente implements IAplicable {

    private String origen;
    private String destino;
    // Los obstaculos ahora se guardan como texto para poder describirlos.
    private String obstaculosDetectados;
    private double precisionGPS;

    public AgenteNavegacion(int idAgente, String nombre, double nivelAutonomia, String estadoOperativo, double nivelConfianza,
            String origen, String destino, String obstaculosDetectados, double precisionGPS) throws Exception
    {
        super(idAgente, nombre, nivelAutonomia, estadoOperativo, nivelConfianza);
        this.origen = origen;
        this.destino = destino;
        setObstaculosDetectados(obstaculosDetectados);
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

    public String getObstaculosDetectados()
    {
        return obstaculosDetectados;
    }

    public void setObstaculosDetectados(String obstaculosDetectados)
    {
        this.obstaculosDetectados = obstaculosDetectados == null ? "" : obstaculosDetectados.trim();
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
     * Calcula una penalizacion aproximada a partir del texto de obstaculos.
     * Si se escriben varios obstaculos separados por coma o punto y coma,
     * cada uno cuenta como un obstaculo. Textos como "ninguno" no penalizan.
     */
    private int contarObstaculosDescritos()
    {
        if (obstaculosDetectados == null) {
            return 0;
        }

        String texto = obstaculosDetectados.trim();
        if (texto.isEmpty()
                || texto.equalsIgnoreCase("ninguno")
                || texto.equalsIgnoreCase("ninguna")
                || texto.equalsIgnoreCase("sin obstaculos")
                || texto.equalsIgnoreCase("no")) {
            return 0;
        }

        int cantidad = 0;
        for (String parte : texto.split("[,;\\n]+")) {
            if (!parte.trim().isEmpty()) {
                cantidad++;
            }
        }
        return Math.max(1, cantidad);
    }

    /**
     * Calculo de rendimiento propio de un agente de navegacion: promedia
     * la precision GPS con el nivel de confianza y penaliza segun los
     * obstaculos descritos.
     */
    @Override
    public double calcularRendimiento()
    {
        double base = (precisionGPS + getNivelConfianza()) / 2.0;
        double resultado = base - contarObstaculosDescritos();
        return Math.max(0, resultado);
    }

    /**
     * Implementacion de IAplicable: aplica una recalibracion del sistema
     * de navegacion, mejorando la precision GPS y limpiando la
     * descripcion de obstaculos detectados.
     */
    @Override
    public void aplicar()
    {
        try {
            setPrecisionGPS(Math.min(100, this.precisionGPS + 5));
            setObstaculosDetectados("Ninguno");
        } catch (Exception e) {
            // No deberia ocurrir: los valores usados siempre son validos.
        }
    }
}
