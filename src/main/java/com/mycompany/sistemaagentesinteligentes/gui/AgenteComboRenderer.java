package com.mycompany.sistemaagentesinteligentes.gui;

import com.mycompany.sistemaagentesinteligentes.model.AgenteAsistenciaMedica;
import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import com.mycompany.sistemaagentesinteligentes.model.AgenteNavegacion;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * Muestra agentes en listas desplegables sin obligar al usuario a recordar
 * ni escribir el ID. El objeto conserva internamente su ID para las operaciones.
 */
public class AgenteComboRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof AgenteNavegacion agente) {
            setText(agente.getNombre() + " — " + agente.getOrigen() + " → " + agente.getDestino());
        } else if (value instanceof AgenteAsistenciaMedica agente) {
            String especialidad = agente.getEspecialidadMedica();
            if (especialidad == null || especialidad.isBlank()) {
                especialidad = "Asistencia medica";
            }
            setText(agente.getNombre() + " — " + especialidad);
        } else if (value instanceof AgenteInteligente agente) {
            setText(agente.getNombre() + " — " + agente.getClass().getSimpleName());
        } else if (value == null) {
            setText("No hay agentes registrados");
        }

        return this;
    }
}
