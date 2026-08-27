/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.services;

import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

/**
 * Servicio central de agentes. Los datos se guardan automaticamente en disco
 * cada vez que se agrega, actualiza o elimina un agente, y se vuelven a cargar
 * al iniciar el programa.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class ServicioAgentes {

    private static final Path ARCHIVO_DATOS = obtenerRutaArchivo();
    private static Map<Integer, AgenteInteligente> agentes = cargarAgentes();

    static {
        // Respaldo adicional: al cerrar la aplicacion se vuelve a guardar el mapa.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                guardarAgentes();
            } catch (Exception e) {
                System.err.println("No se pudieron guardar los agentes al cerrar: " + e.getMessage());
            }
        }, "guardar-agentes"));
    }

    private static Path obtenerRutaArchivo() {
        String rutaPersonalizada = System.getProperty("sistema.agentes.archivo");
        if (rutaPersonalizada != null && !rutaPersonalizada.isBlank()) {
            return Paths.get(rutaPersonalizada);
        }
        return Paths.get(System.getProperty("user.home"), ".sistema-agentes-inteligentes", "agentes.dat");
    }

    @SuppressWarnings("unchecked")
    private static Map<Integer, AgenteInteligente> cargarAgentes() {
        if (!Files.exists(ARCHIVO_DATOS)) {
            return new HashMap<>();
        }

        try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(ARCHIVO_DATOS))) {
            Object datos = entrada.readObject();
            if (datos instanceof Map<?, ?> mapa) {
                Map<Integer, AgenteInteligente> cargados = new HashMap<>();
                for (Map.Entry<?, ?> entradaMapa : mapa.entrySet()) {
                    if (entradaMapa.getKey() instanceof Integer id
                            && entradaMapa.getValue() instanceof AgenteInteligente agente) {
                        cargados.put(id, agente);
                    }
                }
                return cargados;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No se pudieron cargar los agentes guardados: " + e.getMessage());
        }

        return new HashMap<>();
    }

    private static synchronized void guardarAgentes() throws IOException {
        Path carpeta = ARCHIVO_DATOS.getParent();
        if (carpeta != null) {
            Files.createDirectories(carpeta);
        }

        Path temporal = ARCHIVO_DATOS.resolveSibling(ARCHIVO_DATOS.getFileName() + ".tmp");
        try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(temporal))) {
            salida.writeObject(agentes);
        }

        try {
            Files.move(temporal, ARCHIVO_DATOS, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            // Algunos sistemas de archivos no permiten ATOMIC_MOVE.
            Files.move(temporal, ARCHIVO_DATOS, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static synchronized Map<Integer, AgenteInteligente> getAgentes(){
        return Map.copyOf(agentes);
    }

    public static synchronized void addAgente(AgenteInteligente agente){
        if (agente == null) {
            throw new IllegalArgumentException("El agente no puede ser nulo");
        }
        agentes.put(agente.getIdAgente(), agente);
        try {
            guardarAgentes();
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo guardar la informacion: " + e.getMessage(), e);
        }
    }

    public static synchronized AgenteInteligente obtenerAgente(int id) {
        return agentes.get(id);
    }

    public static synchronized void deleteAgente(int id) throws Exception
    {
        if (!agentes.containsKey(id)) {
            throw new Exception("No se ha encontrado ningun agente para eliminar");
        }

        agentes.remove(id);
        guardarAgentes();
    }

    public static synchronized void actualizarAgente(int id, AgenteInteligente agente) throws Exception
    {
        if (!agentes.containsKey(id)) {
            throw new Exception("No se ha encontrado ningun agente para actualizar");
        }
        if (agente == null) {
            throw new Exception("El agente actualizado no puede ser nulo");
        }

        agentes.remove(id);
        agentes.put(agente.getIdAgente(), agente);
        guardarAgentes();
    }

    public static synchronized AgenteInteligente buscarAgente(int id)
    {
        return agentes.get(id);
    }

    /**
     * Fuerza un guardado manual. Normalmente no hace falta llamarlo porque las
     * operaciones de alta, actualizacion y eliminacion ya guardan automaticamente.
     */
    public static synchronized void guardarDatos() throws IOException {
        guardarAgentes();
    }

    public static Path getRutaArchivoDatos() {
        return ARCHIVO_DATOS;
    }
}
