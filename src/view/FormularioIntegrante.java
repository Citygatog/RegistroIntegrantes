package view;
import javax.swing.*;
import java.awt.*;

public class FormularioIntegrante extends JFrame {
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtRepositorio;

    private JRadioButton rbNuevo;
    private JRadioButton rbAntiguo;
    private ButtonGroup grupoTipo;

    private JComboBox<String> cbProyecto;

    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnLimpiar;

    public FormularioIntegrante() {
        setTitle("Registro de Integrantes");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel(
                "REGISTRO DE INTEGRANTES",
                JLabel.CENTER
        );

        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(
                new GridLayout(5, 2, 5, 10)
        );

        panelFormulario.setBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        // Nombres
        panelFormulario.add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        panelFormulario.add(txtNombres);

        // Apellidos
        panelFormulario.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelFormulario.add(txtApellidos);

        // Link repositorio de GitHub
        panelFormulario.add(new JLabel("Repositorio GitHub:"));
        txtRepositorio = new JTextField();
        panelFormulario.add(txtRepositorio);

        // Tipo de estudiante
        panelFormulario.add(new JLabel("Tipo de estudiante:"));
        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbNuevo = new JRadioButton("Nuevo");
        rbAntiguo = new JRadioButton("Antiguo");
        grupoTipo = new ButtonGroup();
        grupoTipo.add(rbNuevo);
        grupoTipo.add(rbAntiguo);
        panelTipo.add(rbNuevo);
        panelTipo.add(rbAntiguo);
        panelFormulario.add(panelTipo);

        // Carrera
        panelFormulario.add(new JLabel("Proyecto educativo:"));
        String[] proyectos = {
            "Seleccione una opción",
            "Ingeniería de Sistemas",
            "Ingeniería Electrónica",
            "Ingeniería Industrial",
            "Ingeniería Civil"
        };
        cbProyecto = new JComboBox<>(proyectos);
        panelFormulario.add(cbProyecto);
        panelPrincipal.add(
                panelFormulario,
                BorderLayout.CENTER
        );

        // Botones
        JPanel panelBotones = new JPanel();

        btnRegistrar = new JButton("Registrar");
        btnConsultar = new JButton("Consultar");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnLimpiar);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        add(panelPrincipal);
    }
    
    public void mostrarVentana() {
    setVisible(true);

    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public JTextField getTxtRepositorio() {
        return txtRepositorio;
    }

    public JRadioButton getRbNuevo() {
        return rbNuevo;
    }

    public JRadioButton getRbAntiguo() {
        return rbAntiguo;
    }

    public JComboBox<String> getCbProyecto() {
        return cbProyecto;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }
}