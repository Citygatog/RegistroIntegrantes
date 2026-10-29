package controller;

import model.Integrante;
import view.FormularioIntegrante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IntegranteController {

    private FormularioIntegrante vista;
    private ArrayList<Integrante> integrantes;

    private JFrame ventanaConsulta;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public IntegranteController(FormularioIntegrante vista) {
        this.vista = vista;
        this.integrantes = new ArrayList<>();
        this.vista.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarIntegrante();
            }
        });

        this.vista.getBtnConsultar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarIntegrantes();
            }
        });

        this.vista.getBtnLimpiar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
    }

    private void registrarIntegrante() {
        String nombres = vista.getTxtNombres().getText().trim();
        String apellidos = vista.getTxtApellidos().getText().trim();
        String repositorio = vista.getTxtRepositorio().getText().trim();
        String tipoEstudiante = "";

        if (vista.getRbNuevo().isSelected()) {
            tipoEstudiante = "Nuevo";
        } else if (vista.getRbAntiguo().isSelected()) {
            tipoEstudiante = "Antiguo";
        }
        String proyecto = (String) vista.getCbProyecto().getSelectedItem();

        // Validar campos obligatorios
        if (nombres.isEmpty() || apellidos.isEmpty() || repositorio.isEmpty()) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Complete todos los campos obligatorios."
            );
            return;
        }

        // Validar tipo de estudiante
        if (tipoEstudiante.isEmpty()) {
            JOptionPane.showMessageDialog(vista,"Seleccione el tipo de estudiante.");
            return;
        }

        // Validar proyecto educativo
        if (vista.getCbProyecto().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vista,"Seleccione un proyecto educativo.");
            return;
        }

        // Validar URL
        if (!validarURL(repositorio)) {

            JOptionPane.showMessageDialog(vista,"Ingrese una URL valida de GitHub.\n" + "Ejemplo: https://github.com/usuario/proyecto");
            return;
        }

        // Crear objeto Integrante
        Integrante integrante = new Integrante(nombres,apellidos,repositorio,tipoEstudiante,proyecto);

        // Agregar nuevo integrante
        integrantes.add(integrante);

        // Actualizar la tabla si la consulta está abierta
        actualizarTabla();
        JOptionPane.showMessageDialog(vista,"Integrante registrado correctamente.\n"+ "Total de integrantes registados: " + integrantes.size());
        limpiarFormulario();
    }

    private boolean validarURL(String url) {
        try {
            URI direccion = new URI(url);
            String esquema = direccion.getScheme();
            String host = direccion.getHost();
            return esquema != null
                    && (esquema.equalsIgnoreCase("http")
                    || esquema.equalsIgnoreCase("https"))
                    && host != null
                    && host.contains(".")
                    && direccion.getUserInfo() == null;
        } catch (Exception e) {
            return false;
        }
    }

    private void consultarIntegrantes() {
        if (integrantes.isEmpty()) {
            JOptionPane.showMessageDialog(vista,"No hay integrantes registrados.");
            return;
        }

        // Crear la ventana solamente una vez
        if (ventanaConsulta == null || !ventanaConsulta.isDisplayable()) {
            String[] columnas = {
                "Nombres",
                "Apellidos",
                "Repositorio",
                "Tipo",
                "Proyecto educativo"
            };

            modeloTabla = new DefaultTableModel(columnas, 0) {
                @Override
                public boolean isCellEditable(
                        int fila, int columna) {
                    return false;
                }
            };

            tabla = new JTable(modeloTabla);
            JScrollPane scroll = new JScrollPane(tabla);
            ventanaConsulta = new JFrame("Integrantes Registrados");
            ventanaConsulta.add(scroll);
            ventanaConsulta.setSize(800, 250);
            ventanaConsulta.setLocationRelativeTo(vista);
            ventanaConsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        actualizarTabla();
        ventanaConsulta.setVisible(true);
        ventanaConsulta.toFront();
    }

    private void actualizarTabla() {
        if (modeloTabla == null) {
            return;
        }
        // Eliminar filas anteriores de la tabla,
        // no los objetos guardados en el ArrayList
        modeloTabla.setRowCount(0);

        for (Integrante integrante : integrantes) {
            Object[] fila = {
                integrante.getNombres(),
                integrante.getApellidos(),
                integrante.getRepositorio(),
                integrante.getTipoEstudiante(),
                integrante.getProyectoEducativo()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarFormulario() {
        vista.getTxtNombres().setText("");
        vista.getTxtApellidos().setText("");
        vista.getTxtRepositorio().setText("");
        vista.getRbNuevo().setSelected(false);
        vista.getRbAntiguo().setSelected(false);
        vista.getCbProyecto().setSelectedIndex(0);
        vista.getTxtNombres().requestFocus();
    }
}