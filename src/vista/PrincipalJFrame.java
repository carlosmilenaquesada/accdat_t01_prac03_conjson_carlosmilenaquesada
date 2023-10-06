package vista;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import controlador.Conexion;
import controlador.CrudDatos;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnoAD;
import static vista.Mensajes.MENSAJES;

public class PrincipalJFrame extends javax.swing.JFrame {

    private enum TipoFileChooser {
        SAVE, OPEN, DEFAULT;
    }
    ArrayList<AlumnoAD> alumnosAD = null;

    //VARIABLES AUXILIARES
    String regexMatricula = "^[1-9]\\d{0,8}$";//evita matriculas negativas, con decimales y de más de 9 dígitos
    String regexNotas = "^[1-9]\\d{0,1}(\\.\\d{1,2})?$";//evita notas con más de dos número enteros y más de dos decimales, así como negativas
    Color miRojo = new Color(255, 105, 97);
    Color defecto = Color.WHITE;

    ArrayList<JTextField> AJtfCrear = null;
    ArrayList<JTextField> AJtfActu = null;

    //ELEMENTOS PESTAÑA READ
    DefaultListModel dlmRead = null;
    DefaultTableModel dtmRead = null;

    //ELEMENTOS PESTAÑA UPDATE
    DefaultListModel dlmUpdate = null;

    //ELEMENTOS PESTAÑA DELETE
    DefaultListModel dlmDelete = null;
    DefaultTableModel dtmDelete = null;

    public PrincipalJFrame() {
        initComponents();
        alumnosAD = Conexion.importarColeccion();

        //ELEMENTOS PESTAÑA READ
        dlmRead = new DefaultListModel();
        jListLeer.setModel(dlmRead);
        dtmRead = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//el programa utiliza esta función para saber si se
                //puede editar una celda o no. Al sobrecargarlo para
                //que siempre devuelva falso, no dejará que se edite
                //ninguna celdas.
            }
        };
        dtmRead.setColumnIdentifiers(new String[]{
            "Nº Matricula", "Nombre Alumno", "Nota 1ª Ev.", "Nota 2ª Ev.", "Nota final", "Nota extra"
        });

        jTableLeerTabla.setModel(dtmRead);
        jRadioButtonLeerManual.setSelected(true);

        //ELEMENTOS PESTAÑA UPDATE
        dlmUpdate = new DefaultListModel();
        jListModificar.setModel(dlmUpdate);
        jRadioButtonActuManual.setSelected(true);

        //ELEMENTOS DE LA PESTAÑA BORRAR
        dlmDelete = new DefaultListModel();
        jListBorrar.setModel(dlmDelete);
        dtmDelete = new DefaultTableModel();
        dtmDelete.setColumnIdentifiers(new String[]{
            "Nº Matricula", "Nombre Alumno", "Nota 1ª Ev.", "Nota 2ª Ev.", "Nota final", "Nota extra"
        });
        jTableBorrarTabla.setModel(dtmDelete);
        jRadioButtonBorrarManual.setSelected(true);

        AJtfCrear = new ArrayList<>() {
            {
                add(jTextFieldCrearMatricula);
                add(jTextFieldCrearNombre);
                add(jTextFieldCrearNot1Ev);
                add(jTextFieldCrearNot2Ev);
                add(jTextFieldCrearNotFinal);
                add(jTextFieldCrearNotExtra);
            }
        };

        AJtfActu = new ArrayList<>() {
            {
                add(jTextFieldModificarMatricula);
                add(jTextFieldModificarNombre);
                add(jTextFieldModificarNot1Ev);
                add(jTextFieldModificarNot2Ev);
                add(jTextFieldModificarNotFinal);
                add(jTextFieldModificarNotExtra);
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLeer = new javax.swing.ButtonGroup();
        buttonGroupActualizar = new javax.swing.ButtonGroup();
        buttonGroupBorrar = new javax.swing.ButtonGroup();
        jTabbedPaneGeneral = new javax.swing.JTabbedPane();
        jPanelCrear = new javax.swing.JPanel();
        jLabelCrearMatricula = new javax.swing.JLabel();
        jTextFieldCrearMatricula = new javax.swing.JTextField();
        jLabelCrearNombre = new javax.swing.JLabel();
        jTextFieldCrearNombre = new javax.swing.JTextField();
        jLabelCrearNot1Ev = new javax.swing.JLabel();
        jTextFieldCrearNot1Ev = new javax.swing.JTextField();
        jLabelCrearNot2Ev = new javax.swing.JLabel();
        jTextFieldCrearNot2Ev = new javax.swing.JTextField();
        jLabelCrearNotFinal = new javax.swing.JLabel();
        jTextFieldCrearNotFinal = new javax.swing.JTextField();
        jLabelCrearNotExtra = new javax.swing.JLabel();
        jTextFieldCrearNotExtra = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        jButtonCrearLimpiar = new javax.swing.JButton();
        jLabelTituloCrear = new javax.swing.JLabel();
        jPanelLeer = new javax.swing.JPanel();
        jScrollPaneLeerLista = new javax.swing.JScrollPane();
        jListLeer = new javax.swing.JList<>();
        jButtonLeerAniadir = new javax.swing.JButton();
        jScrollPaneLeerTabla = new javax.swing.JScrollPane();
        jTableLeerTabla = new javax.swing.JTable();
        jButtonLeerLimpiarTabla = new javax.swing.JButton();
        jRadioButtonLeerManual = new javax.swing.JRadioButton();
        jRadioButtonLeerLista = new javax.swing.JRadioButton();
        jLabelTituloLeer = new javax.swing.JLabel();
        jTextFieldLeerManual = new javax.swing.JTextField();
        jButtonLeerExportarJson = new javax.swing.JButton();
        jButtonLeerImportarJson = new javax.swing.JButton();
        jPanelActualizar = new javax.swing.JPanel();
        jLabelModificarMatricula = new javax.swing.JLabel();
        jTextFieldModificarMatricula = new javax.swing.JTextField();
        jTextFieldModificarNombre = new javax.swing.JTextField();
        jTextFieldModificarNot1Ev = new javax.swing.JTextField();
        jTextFieldModificarNot2Ev = new javax.swing.JTextField();
        jTextFieldModificarNotFinal = new javax.swing.JTextField();
        jTextFieldModificarNotExtra = new javax.swing.JTextField();
        jLabelModificarNotExtra = new javax.swing.JLabel();
        jLabelModificarNotFinal = new javax.swing.JLabel();
        jLabelModificarNot2Ev = new javax.swing.JLabel();
        jLabelModificarNot1Ev = new javax.swing.JLabel();
        jLabelModificarNombre = new javax.swing.JLabel();
        jButtonModificarLimpiar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jScrollPaneModificarLista = new javax.swing.JScrollPane();
        jListModificar = new javax.swing.JList<>();
        jButtonModificarIniciar = new javax.swing.JButton();
        jRadioButtonActuManual = new javax.swing.JRadioButton();
        jRadioButtonActuLista = new javax.swing.JRadioButton();
        jLabelTituloActualizar = new javax.swing.JLabel();
        jPanelBorrar = new javax.swing.JPanel();
        jButtonBorrarLimpiarTabla = new javax.swing.JButton();
        jScrollPaneBorrarTabla = new javax.swing.JScrollPane();
        jTableBorrarTabla = new javax.swing.JTable();
        jButtonBorrarAniadirTabla = new javax.swing.JButton();
        jButtonBorrarRegistros = new javax.swing.JButton();
        jRadioButtonBorrarLista = new javax.swing.JRadioButton();
        jRadioButtonBorrarManual = new javax.swing.JRadioButton();
        jTextFieldBorrarManual = new javax.swing.JTextField();
        jLabelTituloActualizar1 = new javax.swing.JLabel();
        jScrollPaneBorrarLista = new javax.swing.JScrollPane();
        jListBorrar = new javax.swing.JList<>();
        jPanelGuardar = new javax.swing.JPanel();
        jLabelGuardarDescartar = new javax.swing.JLabel();
        jButtonGuardarDescartar = new javax.swing.JButton();
        jLabelGuardarDescartarSalir = new javax.swing.JLabel();
        jButtonGuardarDescartarSalir = new javax.swing.JButton();
        jLabelGuardarGuardarSalir = new javax.swing.JLabel();
        jButtonGuardarGuardarSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de alumnos");
        setMinimumSize(new java.awt.Dimension(680, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPaneGeneral.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneGeneralStateChanged(evt);
            }
        });

        jPanelCrear.setLayout(null);

        jLabelCrearMatricula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCrearMatricula.setText("Número de matrícula");
        jLabelCrearMatricula.setPreferredSize(new java.awt.Dimension(150, 14));
        jPanelCrear.add(jLabelCrearMatricula);
        jLabelCrearMatricula.setBounds(50, 50, 150, 14);

        jTextFieldCrearMatricula.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelCrear.add(jTextFieldCrearMatricula);
        jTextFieldCrearMatricula.setBounds(220, 40, 300, 30);

        jLabelCrearNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCrearNombre.setText("Nombre y apellidos");
        jLabelCrearNombre.setPreferredSize(new java.awt.Dimension(150, 14));
        jPanelCrear.add(jLabelCrearNombre);
        jLabelCrearNombre.setBounds(50, 90, 150, 14);

        jTextFieldCrearNombre.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelCrear.add(jTextFieldCrearNombre);
        jTextFieldCrearNombre.setBounds(220, 80, 300, 30);

        jLabelCrearNot1Ev.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCrearNot1Ev.setText("Nota primera evaluación");
        jLabelCrearNot1Ev.setPreferredSize(new java.awt.Dimension(150, 14));
        jPanelCrear.add(jLabelCrearNot1Ev);
        jLabelCrearNot1Ev.setBounds(50, 130, 150, 14);

        jTextFieldCrearNot1Ev.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelCrear.add(jTextFieldCrearNot1Ev);
        jTextFieldCrearNot1Ev.setBounds(220, 120, 300, 30);

        jLabelCrearNot2Ev.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCrearNot2Ev.setText("Nota segunda evaluación");
        jLabelCrearNot2Ev.setPreferredSize(new java.awt.Dimension(150, 14));
        jPanelCrear.add(jLabelCrearNot2Ev);
        jLabelCrearNot2Ev.setBounds(50, 170, 150, 14);

        jTextFieldCrearNot2Ev.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelCrear.add(jTextFieldCrearNot2Ev);
        jTextFieldCrearNot2Ev.setBounds(220, 160, 300, 30);

        jLabelCrearNotFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCrearNotFinal.setText("Nota final");
        jLabelCrearNotFinal.setPreferredSize(new java.awt.Dimension(150, 14));
        jPanelCrear.add(jLabelCrearNotFinal);
        jLabelCrearNotFinal.setBounds(50, 210, 150, 14);

        jTextFieldCrearNotFinal.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelCrear.add(jTextFieldCrearNotFinal);
        jTextFieldCrearNotFinal.setBounds(220, 200, 300, 30);

        jLabelCrearNotExtra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCrearNotExtra.setText("Nota extra");
        jLabelCrearNotExtra.setPreferredSize(new java.awt.Dimension(150, 14));
        jPanelCrear.add(jLabelCrearNotExtra);
        jLabelCrearNotExtra.setBounds(50, 250, 150, 14);

        jTextFieldCrearNotExtra.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelCrear.add(jTextFieldCrearNotExtra);
        jTextFieldCrearNotExtra.setBounds(220, 240, 300, 30);

        jButtonCrear.setText("Crear alumno");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanelCrear.add(jButtonCrear);
        jButtonCrear.setBounds(400, 290, 120, 23);

        jButtonCrearLimpiar.setText("Limpiar campos");
        jButtonCrearLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearLimpiarActionPerformed(evt);
            }
        });
        jPanelCrear.add(jButtonCrearLimpiar);
        jButtonCrearLimpiar.setBounds(220, 290, 130, 23);

        jLabelTituloCrear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTituloCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloCrear.setText("Crear un nuevo alumno");
        jPanelCrear.add(jLabelTituloCrear);
        jLabelTituloCrear.setBounds(10, 10, 580, 20);

        jTabbedPaneGeneral.addTab("Crear", jPanelCrear);

        jPanelLeer.setLayout(null);

        jListLeer.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListLeer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneLeerLista.setViewportView(jListLeer);

        jPanelLeer.add(jScrollPaneLeerLista);
        jScrollPaneLeerLista.setBounds(30, 70, 110, 240);

        jButtonLeerAniadir.setText("Consultar matricula");
        jButtonLeerAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeerAniadirActionPerformed(evt);
            }
        });
        jPanelLeer.add(jButtonLeerAniadir);
        jButtonLeerAniadir.setBounds(160, 80, 160, 30);

        jTableLeerTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLeerTabla.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableLeerTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPaneLeerTabla.setViewportView(jTableLeerTabla);

        jPanelLeer.add(jScrollPaneLeerTabla);
        jScrollPaneLeerTabla.setBounds(160, 120, 470, 190);

        jButtonLeerLimpiarTabla.setText("Limpiar tabla");
        jButtonLeerLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeerLimpiarTablaActionPerformed(evt);
            }
        });
        jPanelLeer.add(jButtonLeerLimpiarTabla);
        jButtonLeerLimpiarTabla.setBounds(510, 330, 120, 23);

        buttonGroupLeer.add(jRadioButtonLeerManual);
        jRadioButtonLeerManual.setText("Insertar una matrícula manualmente");
        jRadioButtonLeerManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLeerManualActionPerformed(evt);
            }
        });
        jPanelLeer.add(jRadioButtonLeerManual);
        jRadioButtonLeerManual.setBounds(330, 40, 240, 25);

        buttonGroupLeer.add(jRadioButtonLeerLista);
        jRadioButtonLeerLista.setText("Elegir una matrícula de la lista");
        jRadioButtonLeerLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLeerListaActionPerformed(evt);
            }
        });
        jPanelLeer.add(jRadioButtonLeerLista);
        jRadioButtonLeerLista.setBounds(30, 40, 240, 25);

        jLabelTituloLeer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTituloLeer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloLeer.setText("Consultar datos de uno o varios alumnos por medio de su número de matrícula");
        jPanelLeer.add(jLabelTituloLeer);
        jLabelTituloLeer.setBounds(10, 10, 580, 20);
        jPanelLeer.add(jTextFieldLeerManual);
        jTextFieldLeerManual.setBounds(330, 70, 200, 25);

        jButtonLeerExportarJson.setText("Exportar a JSON");
        jButtonLeerExportarJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeerExportarJsonActionPerformed(evt);
            }
        });
        jPanelLeer.add(jButtonLeerExportarJson);
        jButtonLeerExportarJson.setBounds(513, 390, 120, 23);

        jButtonLeerImportarJson.setText("Importar de JSON");
        jButtonLeerImportarJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeerImportarJsonActionPerformed(evt);
            }
        });
        jPanelLeer.add(jButtonLeerImportarJson);
        jButtonLeerImportarJson.setBounds(10, 390, 130, 23);

        jTabbedPaneGeneral.addTab("Leer", jPanelLeer);

        jPanelActualizar.setLayout(null);

        jLabelModificarMatricula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelModificarMatricula.setText("Número de matrícula");
        jPanelActualizar.add(jLabelModificarMatricula);
        jLabelModificarMatricula.setBounds(40, 60, 150, 30);
        jPanelActualizar.add(jTextFieldModificarMatricula);
        jTextFieldModificarMatricula.setBounds(200, 60, 220, 30);
        jPanelActualizar.add(jTextFieldModificarNombre);
        jTextFieldModificarNombre.setBounds(200, 100, 220, 30);
        jPanelActualizar.add(jTextFieldModificarNot1Ev);
        jTextFieldModificarNot1Ev.setBounds(200, 140, 220, 30);
        jPanelActualizar.add(jTextFieldModificarNot2Ev);
        jTextFieldModificarNot2Ev.setBounds(200, 180, 220, 30);
        jPanelActualizar.add(jTextFieldModificarNotFinal);
        jTextFieldModificarNotFinal.setBounds(200, 220, 220, 30);
        jPanelActualizar.add(jTextFieldModificarNotExtra);
        jTextFieldModificarNotExtra.setBounds(200, 260, 220, 30);

        jLabelModificarNotExtra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelModificarNotExtra.setText("Nota extra");
        jPanelActualizar.add(jLabelModificarNotExtra);
        jLabelModificarNotExtra.setBounds(40, 260, 150, 30);

        jLabelModificarNotFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelModificarNotFinal.setText("Nota final");
        jPanelActualizar.add(jLabelModificarNotFinal);
        jLabelModificarNotFinal.setBounds(40, 220, 150, 30);

        jLabelModificarNot2Ev.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelModificarNot2Ev.setText("Nota segunda evaluación");
        jPanelActualizar.add(jLabelModificarNot2Ev);
        jLabelModificarNot2Ev.setBounds(40, 180, 150, 30);

        jLabelModificarNot1Ev.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelModificarNot1Ev.setText("Nota primera evaluación");
        jPanelActualizar.add(jLabelModificarNot1Ev);
        jLabelModificarNot1Ev.setBounds(40, 140, 150, 30);

        jLabelModificarNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelModificarNombre.setText("Nombre y apellidos");
        jPanelActualizar.add(jLabelModificarNombre);
        jLabelModificarNombre.setBounds(40, 100, 150, 30);

        jButtonModificarLimpiar.setText("Limpiar campos");
        jButtonModificarLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarLimpiarActionPerformed(evt);
            }
        });
        jPanelActualizar.add(jButtonModificarLimpiar);
        jButtonModificarLimpiar.setBounds(200, 300, 130, 23);

        jButtonModificar.setText("Aplicar cambios");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelActualizar.add(jButtonModificar);
        jButtonModificar.setBounds(490, 310, 120, 40);

        jListModificar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListModificar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneModificarLista.setViewportView(jListModificar);

        jPanelActualizar.add(jScrollPaneModificarLista);
        jScrollPaneModificarLista.setBounds(450, 90, 160, 200);

        jButtonModificarIniciar.setText("Iniciar modificación");
        jButtonModificarIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarIniciarActionPerformed(evt);
            }
        });
        jPanelActualizar.add(jButtonModificarIniciar);
        jButtonModificarIniciar.setBounds(460, 30, 140, 23);

        buttonGroupActualizar.add(jRadioButtonActuManual);
        jRadioButtonActuManual.setText("Insertar una matrícula manualmente");
        jRadioButtonActuManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActuManualActionPerformed(evt);
            }
        });
        jPanelActualizar.add(jRadioButtonActuManual);
        jRadioButtonActuManual.setBounds(200, 30, 240, 23);

        buttonGroupActualizar.add(jRadioButtonActuLista);
        jRadioButtonActuLista.setText("Elegir una matrícula de la lista");
        jRadioButtonActuLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActuListaActionPerformed(evt);
            }
        });
        jPanelActualizar.add(jRadioButtonActuLista);
        jRadioButtonActuLista.setBounds(450, 60, 190, 23);

        jLabelTituloActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTituloActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloActualizar.setText("Modifiar un alumno");
        jPanelActualizar.add(jLabelTituloActualizar);
        jLabelTituloActualizar.setBounds(10, 10, 580, 20);

        jTabbedPaneGeneral.addTab("Actualizar", jPanelActualizar);

        jPanelBorrar.setLayout(null);

        jButtonBorrarLimpiarTabla.setText("Limpiar tabla");
        jButtonBorrarLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarLimpiarTablaActionPerformed(evt);
            }
        });
        jPanelBorrar.add(jButtonBorrarLimpiarTabla);
        jButtonBorrarLimpiarTabla.setBounds(140, 300, 120, 23);

        jTableBorrarTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBorrarTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPaneBorrarTabla.setViewportView(jTableBorrarTabla);

        jPanelBorrar.add(jScrollPaneBorrarTabla);
        jScrollPaneBorrarTabla.setBounds(127, 98, 461, 190);

        jButtonBorrarAniadirTabla.setText("Añadir a tabla");
        jButtonBorrarAniadirTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarAniadirTablaActionPerformed(evt);
            }
        });
        jPanelBorrar.add(jButtonBorrarAniadirTabla);
        jButtonBorrarAniadirTabla.setBounds(130, 60, 120, 23);

        jButtonBorrarRegistros.setText("Eliminar alumno");
        jButtonBorrarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarRegistrosActionPerformed(evt);
            }
        });
        jPanelBorrar.add(jButtonBorrarRegistros);
        jButtonBorrarRegistros.setBounds(450, 300, 140, 23);

        buttonGroupBorrar.add(jRadioButtonBorrarLista);
        jRadioButtonBorrarLista.setText("Elegir una matrícula de la lista");
        jRadioButtonBorrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBorrarListaActionPerformed(evt);
            }
        });
        jPanelBorrar.add(jRadioButtonBorrarLista);
        jRadioButtonBorrarLista.setBounds(20, 30, 200, 23);

        buttonGroupBorrar.add(jRadioButtonBorrarManual);
        jRadioButtonBorrarManual.setText("Insertar una matrícula manualmente");
        jRadioButtonBorrarManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBorrarManualActionPerformed(evt);
            }
        });
        jPanelBorrar.add(jRadioButtonBorrarManual);
        jRadioButtonBorrarManual.setBounds(260, 30, 230, 23);
        jPanelBorrar.add(jTextFieldBorrarManual);
        jTextFieldBorrarManual.setBounds(280, 60, 200, 25);

        jLabelTituloActualizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTituloActualizar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloActualizar1.setText("Eliminar un alumno");
        jPanelBorrar.add(jLabelTituloActualizar1);
        jLabelTituloActualizar1.setBounds(10, 10, 580, 20);

        jListBorrar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneBorrarLista.setViewportView(jListBorrar);

        jPanelBorrar.add(jScrollPaneBorrarLista);
        jScrollPaneBorrarLista.setBounds(20, 60, 90, 230);

        jTabbedPaneGeneral.addTab("Borrar", jPanelBorrar);

        jPanelGuardar.setLayout(null);

        jLabelGuardarDescartar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGuardarDescartar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGuardarDescartar.setText("Deshacer todos los cambios");
        jPanelGuardar.add(jLabelGuardarDescartar);
        jLabelGuardarDescartar.setBounds(20, 40, 200, 15);

        jButtonGuardarDescartar.setText("Aceptar");
        jButtonGuardarDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarDescartarActionPerformed(evt);
            }
        });
        jPanelGuardar.add(jButtonGuardarDescartar);
        jButtonGuardarDescartar.setBounds(250, 35, 71, 23);

        jLabelGuardarDescartarSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGuardarDescartarSalir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGuardarDescartarSalir.setText("Deshacer todos los cambios y Salir");
        jPanelGuardar.add(jLabelGuardarDescartarSalir);
        jLabelGuardarDescartarSalir.setBounds(20, 80, 200, 15);

        jButtonGuardarDescartarSalir.setText("Aceptar");
        jButtonGuardarDescartarSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarDescartarSalirActionPerformed(evt);
            }
        });
        jPanelGuardar.add(jButtonGuardarDescartarSalir);
        jButtonGuardarDescartarSalir.setBounds(250, 75, 71, 23);

        jLabelGuardarGuardarSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGuardarGuardarSalir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGuardarGuardarSalir.setText("Guardar todos los cambios y Salir");
        jPanelGuardar.add(jLabelGuardarGuardarSalir);
        jLabelGuardarGuardarSalir.setBounds(20, 120, 200, 15);

        jButtonGuardarGuardarSalir.setText("Aceptar");
        jButtonGuardarGuardarSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarGuardarSalirActionPerformed(evt);
            }
        });
        jPanelGuardar.add(jButtonGuardarGuardarSalir);
        jButtonGuardarGuardarSalir.setBounds(250, 115, 71, 23);

        jTabbedPaneGeneral.addTab("Guardar y salir", jPanelGuardar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //MÉTODOS AUXILIARES
    //--------------------------------------------------------------------------
    private void actualizarListaMatriculas(DefaultListModel dlm) {
        dlm.removeAllElements();
        for (AlumnoAD a : alumnosAD) {
            dlm.addElement("" + a.getNMatricula());
        }
    }

    private void agregarAlumnoATabla(DefaultTableModel dtm, AlumnoAD alu) {
        dtm.addRow(new Object[]{
            alu.getNMatricula(),
            alu.getNombre(),
            alu.getNot1Ev(),
            alu.getNota2Ev(),
            alu.getNotaExtra(),
            alu.getNotaFinal()}
        );
    }

    private boolean agregarDeMatriculaATabla(int numMat, DefaultTableModel dtm) {
        boolean encontrado = false;
        AlumnoAD alu = CrudDatos.read(alumnosAD, numMat);
        if (alu != null) {
            agregarAlumnoATabla(dtm, alu);
            encontrado = true;
        }

        return encontrado;
    }

    private void limpiarVariosJTextFields(ArrayList<JTextField> listaTextFields) {
        for (JTextField t : listaTextFields) {
            t.setText("");
        }
    }

    private void limpiarTabla(DefaultTableModel dtm) {
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    private boolean agregarDeNumMatriACamposModificacion(int numMatri, ArrayList<JTextField> AJtf) {

        boolean encontrada = false;
        for (int i = 0; i < alumnosAD.size() && encontrada == false; i++) {
            if (alumnosAD.get(i).getNMatricula() == numMatri) {
                encontrada = true;
                AJtf.get(0).setText("" + alumnosAD.get(i).getNMatricula());
                AJtf.get(1).setText("" + alumnosAD.get(i).getNombre());
                AJtf.get(2).setText("" + alumnosAD.get(i).getNot1Ev());
                AJtf.get(3).setText("" + alumnosAD.get(i).getNota2Ev());
                AJtf.get(4).setText("" + alumnosAD.get(i).getNotaFinal());
                AJtf.get(5).setText("" + alumnosAD.get(i).getNotaExtra());
            }
        }
        return encontrada;
    }

    private void modificarAlumno() {

        AlumnoAD aluAD = new AlumnoAD();
        aluAD.setNMatricula(Integer.parseInt(jTextFieldModificarMatricula.getText()));

        aluAD.setNombre(jTextFieldModificarNombre.getText());

        if (asignarCamposNotasAAlumno(aluAD, jTextFieldModificarNot1Ev, jTextFieldModificarNot2Ev, jTextFieldModificarNotFinal, jTextFieldModificarNotExtra)) {

            if (CrudDatos.update(alumnosAD, aluAD)) {
                JOptionPane.showMessageDialog(null, MENSAJES[0][27]
                        + aluAD.toString() + MENSAJES[0][28]);
            }

        } else {
            JOptionPane.showMessageDialog(null, MENSAJES[0][8]);
        }
    }

    private void crearAlumno() {
        AlumnoAD aluAD = new AlumnoAD();

        if (!jTextFieldCrearMatricula.getText().isEmpty() && jTextFieldCrearMatricula.getText().matches(regexMatricula)) {

            aluAD.setNMatricula(Integer.parseInt(jTextFieldCrearMatricula.getText()));

            aluAD.setNombre(jTextFieldCrearNombre.getText());

            if (asignarCamposNotasAAlumno(aluAD, jTextFieldCrearNot1Ev, jTextFieldCrearNot2Ev, jTextFieldCrearNotFinal, jTextFieldCrearNotExtra)) {
                if (CrudDatos.create(alumnosAD, aluAD)) {
                    JOptionPane.showMessageDialog(null, MENSAJES[0][27]
                            + aluAD.toString() + MENSAJES[0][28]);
                } else {
                    JOptionPane.showMessageDialog(null, MENSAJES[0][29] + aluAD.getNMatricula() + MENSAJES[0][30]);
                }
            } else {
                JOptionPane.showMessageDialog(null, MENSAJES[0][8]);
            }
        } else {
            JOptionPane.showMessageDialog(null, MENSAJES[0][10]);
        }
    }

    //Auxiliar para tomar los datos del formulario para crear/modificar alumno
    private boolean asignarCamposNotasAAlumno(AlumnoAD alu, JTextField not1, JTextField not2, JTextField notFi, JTextField notEx) {
        boolean asignacionCorrecta = true;
        not1.setBackground(defecto);
        not2.setBackground(defecto);
        notFi.setBackground(defecto);
        notEx.setBackground(defecto);

        if (not1.getText().isEmpty() || not1.getText().matches(regexNotas)) {
            alu.setNot1Ev(Float.parseFloat("0" + not1.getText()));
        } else {
            not1.setBackground(miRojo);
            asignacionCorrecta = false;
        }
        if (not2.getText().isEmpty() || not2.getText().matches(regexNotas)) {
            alu.setNota2Ev(Float.parseFloat("0" + not2.getText()));
        } else {
            not2.setBackground(miRojo);
            asignacionCorrecta = false;
        }
        if (notFi.getText().isEmpty() || notFi.getText().matches(regexNotas)) {
            alu.setNotaFinal(Float.parseFloat("0" + notFi.getText()));
        } else {
            notFi.setBackground(miRojo);
            asignacionCorrecta = false;
        }
        if (notEx.getText().isEmpty() || notEx.getText().matches(regexNotas)) {
            alu.setNotaExtra(Float.parseFloat("0" + notEx.getText()));
        } else {
            notEx.setBackground(miRojo);
            asignacionCorrecta = false;
        }
        return asignacionCorrecta;
    }

    private void borrarRegistros() {
        HashSet<Integer> matriculasABorrar = new HashSet<>();
        for (int i = dtmDelete.getRowCount() - 1; i >= 0; i--) {
            matriculasABorrar.add((Integer) dtmDelete.getValueAt(i, 0));
        }

        for (Integer i : matriculasABorrar) {
            CrudDatos.delete(alumnosAD, i);
        }
        limpiarTabla(dtmDelete);
    }

    private ArrayList<AlumnoAD> exportarDeTablaAColeccion(DefaultTableModel dtm) {
        ArrayList<AlumnoAD> tablaAlumnos = new ArrayList<>();
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {

            int mat = Integer.parseInt(String.valueOf(dtm.getValueAt(i, 0)));
            String nom = (String) dtm.getValueAt(i, 1);
            float not1 = Float.parseFloat(String.valueOf(dtm.getValueAt(i, 2)));
            float not2 = Float.parseFloat(String.valueOf(dtm.getValueAt(i, 3)));
            float notFi = Float.parseFloat(String.valueOf(dtm.getValueAt(i, 4)));
            float notEx = Float.parseFloat(String.valueOf(dtm.getValueAt(i, 5)));

            tablaAlumnos.add(new AlumnoAD(mat, nom, not1, not2, notFi, notEx));
        }
        return tablaAlumnos;

    }

    private File obtenerFileDeFileChooser(TipoFileChooser tipo) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        if (tipo.equals(TipoFileChooser.SAVE)) {
            fc.showSaveDialog(null);
        } else {
            if (tipo.equals(TipoFileChooser.OPEN)) {
                fc.showOpenDialog(null);
            } else {
                if (tipo.equals(TipoFileChooser.DEFAULT)) {
                    fc.showDialog(null, "");
                }
            }
        }
        return fc.getSelectedFile();
    }

    private String generarJsonDeUnaTabla(DefaultTableModel dtm) {
        ArrayList<AlumnoAD> alumnos = exportarDeTablaAColeccion(dtm);
        String json = "";
        if (!alumnos.isEmpty()) {
            Gson gson = new Gson();
            json = gson.toJson(alumnos);
        }
        return json;
    }

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        crearAlumno();
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonCrearLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearLimpiarActionPerformed
        limpiarVariosJTextFields(AJtfCrear);
    }//GEN-LAST:event_jButtonCrearLimpiarActionPerformed

    private void jTabbedPaneGeneralStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneGeneralStateChanged
        // TODO add your handling code here:
        int indexActual = jTabbedPaneGeneral.getModel().getSelectedIndex();

        switch (indexActual) {
            case 0:

                break;
            case 1:
                jTextFieldLeerManual.setVisible(true);
                jListLeer.setVisible(false);
                limpiarTabla(dtmRead);
                jRadioButtonLeerManual.setSelected(true);
                jTextFieldLeerManual.setText("");
                break;
            case 2:
                jRadioButtonActuManual.setSelected(true);
                for (JTextField t : AJtfActu) {
                    t.setEnabled(false);
                }
                jTextFieldModificarMatricula.setEnabled(true);
                jTextFieldModificarMatricula.setEditable(true);
                jTextFieldModificarMatricula.setBackground(Color.WHITE);

                limpiarVariosJTextFields(AJtfActu);

                jListModificar.setVisible(false);
                break;
            case 3:
                jRadioButtonBorrarManual.setSelected(true);
                jTextFieldBorrarManual.setVisible(true);
                jTextFieldBorrarManual.setText("");
                jListBorrar.setVisible(false);
                limpiarTabla(dtmDelete);

                break;
            case 4:
                break;
        }
    }//GEN-LAST:event_jTabbedPaneGeneralStateChanged

    private void jButtonLeerAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerAniadirActionPerformed
        if (jRadioButtonLeerManual.isSelected()) {

            if (!jTextFieldLeerManual.getText().isEmpty() && jTextFieldLeerManual.getText().matches(regexMatricula)) {

                if (!agregarDeMatriculaATabla(Integer.parseInt(jTextFieldLeerManual.getText()), dtmRead)) {
                    JOptionPane.showMessageDialog(null, MENSAJES[0][11]);
                }
            } else {
                JOptionPane.showMessageDialog(null, MENSAJES[0][12]);
            }
        } else {
            if (!jListLeer.isSelectionEmpty()) {
                agregarDeMatriculaATabla(Integer.parseInt(jListLeer.getSelectedValue()), dtmRead);
            } else {
                JOptionPane.showMessageDialog(null, MENSAJES[0][13]);
            }
        }
    }//GEN-LAST:event_jButtonLeerAniadirActionPerformed

    private void jButtonLeerLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerLimpiarTablaActionPerformed
        limpiarTabla(dtmRead);
    }//GEN-LAST:event_jButtonLeerLimpiarTablaActionPerformed

    private void jButtonModificarIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarIniciarActionPerformed
        if (jRadioButtonActuManual.isSelected()) {
            if (!jTextFieldModificarMatricula.getText().isEmpty() && jTextFieldModificarMatricula.getText().matches(regexMatricula)) {

                if (!agregarDeNumMatriACamposModificacion(Integer.parseInt(jTextFieldModificarMatricula.getText()), AJtfActu)) {
                    JOptionPane.showMessageDialog(null, MENSAJES[0][14]);
                } else {
                    for (JTextField t : AJtfActu) {
                        t.setEnabled(true);
                    }
                    jTextFieldModificarMatricula.setEditable(false);
                    jTextFieldModificarMatricula.setBackground(Color.lightGray);
                }
            } else {
                JOptionPane.showMessageDialog(null, MENSAJES[0][12]);
            }
        } else {
            if (!jListModificar.isSelectionEmpty()) {
                if (agregarDeNumMatriACamposModificacion(Integer.parseInt(jListModificar.getSelectedValue()), AJtfActu)) {
                    for (JTextField t : AJtfActu) {
                        t.setEnabled(true);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, MENSAJES[0][16]);
            }

        }
    }//GEN-LAST:event_jButtonModificarIniciarActionPerformed

    private void jButtonModificarLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarLimpiarActionPerformed
        limpiarVariosJTextFields(new ArrayList<>(AJtfActu.subList(1, AJtfActu.size())));
    }//GEN-LAST:event_jButtonModificarLimpiarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (!jTextFieldModificarMatricula.getText().isEmpty()) {
            modificarAlumno();
        } else {
            JOptionPane.showMessageDialog(null, MENSAJES[0][17]);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBorrarAniadirTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarAniadirTablaActionPerformed

        if (jRadioButtonBorrarManual.isSelected()) {

            if (!jTextFieldBorrarManual.getText().isEmpty() && jTextFieldBorrarManual.getText().matches(regexMatricula)) {
                agregarDeMatriculaATabla(Integer.parseInt(jTextFieldBorrarManual.getText()), dtmDelete);
            } else {
                JOptionPane.showMessageDialog(null, MENSAJES[0][12]);
            }
        } else {
            if (jListBorrar.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, MENSAJES[0][14]);

            } else {
                if (!agregarDeMatriculaATabla(Integer.parseInt(jListBorrar.getSelectedValue()), dtmDelete)) {
                    JOptionPane.showMessageDialog(null, MENSAJES[0][20]);
                }
            }
        }

    }//GEN-LAST:event_jButtonBorrarAniadirTablaActionPerformed

    private void jButtonBorrarLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarLimpiarTablaActionPerformed
        limpiarTabla(dtmDelete);
    }//GEN-LAST:event_jButtonBorrarLimpiarTablaActionPerformed

    private void jButtonBorrarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarRegistrosActionPerformed

        if (jTableBorrarTabla.getRowCount() > 0) {

            int opcion = JOptionPane.showConfirmDialog(null, MENSAJES[0][21], MENSAJES[0][31], JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null);

            if (opcion == 0) {
                borrarRegistros();
                limpiarTabla(dtmDelete);
            }
            actualizarListaMatriculas(dlmDelete);
        } else {
            JOptionPane.showMessageDialog(null, MENSAJES[0][22]);
        }
    }//GEN-LAST:event_jButtonBorrarRegistrosActionPerformed

    private void jButtonGuardarDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarDescartarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, MENSAJES[0][23], MENSAJES[0][32], JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null);
        if (opcion == 0) {
            alumnosAD = Conexion.importarColeccion();
        }
    }//GEN-LAST:event_jButtonGuardarDescartarActionPerformed

    private void jButtonGuardarDescartarSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarDescartarSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, MENSAJES[0][24], MENSAJES[0][33], JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null);
        if (opcion == 0) {
            alumnosAD = null;
            System.exit(0);
        }

    }//GEN-LAST:event_jButtonGuardarDescartarSalirActionPerformed

    private void jButtonGuardarGuardarSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarGuardarSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, MENSAJES[0][25], MENSAJES[0][34], JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null);
        if (opcion == 0) {
            opcion = JOptionPane.showConfirmDialog(null, MENSAJES[0][26],
                    "Confirmar salida y guardado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null);
            if (opcion == 0) {
                Conexion.exportarColecion(alumnosAD);
                System.exit(0);
            }
        }
    }//GEN-LAST:event_jButtonGuardarGuardarSalirActionPerformed

    private void jRadioButtonLeerManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLeerManualActionPerformed
        jTextFieldLeerManual.setVisible(true);

        jTextFieldLeerManual.setText("");
        jListLeer.setVisible(false);
    }//GEN-LAST:event_jRadioButtonLeerManualActionPerformed

    private void jRadioButtonLeerListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLeerListaActionPerformed
        jListLeer.setVisible(true);
        actualizarListaMatriculas(dlmRead);
        jTextFieldLeerManual.setVisible(false);
    }//GEN-LAST:event_jRadioButtonLeerListaActionPerformed

    private void jRadioButtonActuManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonActuManualActionPerformed
        jTextFieldModificarMatricula.setEditable(true);
        jTextFieldModificarMatricula.setBackground(Color.WHITE);
        limpiarVariosJTextFields(AJtfActu);
        jListModificar.setVisible(false);

    }//GEN-LAST:event_jRadioButtonActuManualActionPerformed

    private void jRadioButtonActuListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonActuListaActionPerformed
        jTextFieldModificarMatricula.setEditable(false);
        jTextFieldModificarMatricula.setBackground(Color.lightGray);

        limpiarVariosJTextFields(AJtfActu);
        actualizarListaMatriculas(dlmUpdate);
        jListModificar.setVisible(true);
    }//GEN-LAST:event_jRadioButtonActuListaActionPerformed

    private void jRadioButtonBorrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBorrarListaActionPerformed
        actualizarListaMatriculas(dlmDelete);
        jListBorrar.setVisible(true);
        jTextFieldBorrarManual.setVisible(false);
    }//GEN-LAST:event_jRadioButtonBorrarListaActionPerformed

    private void jRadioButtonBorrarManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBorrarManualActionPerformed
        jTextFieldBorrarManual.setVisible(true);
        jListBorrar.setVisible(false);
    }//GEN-LAST:event_jRadioButtonBorrarManualActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int campo = JOptionPane.showConfirmDialog(null, MENSAJES[0][35], MENSAJES[0][33], JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null);
        if (campo == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonLeerExportarJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerExportarJsonActionPerformed
        String json = generarJsonDeUnaTabla(dtmRead);
        FileOutputStream fos = null;
        if (json.isEmpty()) {
            JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][38]);
        } else {
            try {
                File file = obtenerFileDeFileChooser(TipoFileChooser.SAVE);
                if (file != null && file.isFile()) {
                    fos = new FileOutputStream(file);

                    for (char c : json.toCharArray()) {
                        try {
                            fos.write(c);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][6]);
                        }
                    }
                    JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][39]);
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][6]);
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][7]);
                }
            }
        }

    }//GEN-LAST:event_jButtonLeerExportarJsonActionPerformed

    private void jButtonLeerImportarJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerImportarJsonActionPerformed
        File file = obtenerFileDeFileChooser(TipoFileChooser.OPEN);

        if (file != null && file.isFile()) {
            FileInputStream fis = null;
            String jsonTexto = "";
            try {
                fis = new FileInputStream(file);
                int caracter = 0;

                while ((caracter = fis.read()) != -1) {
                    jsonTexto += (char) caracter;
                }

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][1]);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][3]);
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][7]);
                }
            }
            if (!jsonTexto.isEmpty()) {
                Gson gson = new Gson();
                try {
                    ArrayList<AlumnoAD> alumnos = new ArrayList<>(Arrays.asList(gson.fromJson(jsonTexto, AlumnoAD[].class)));
                    for (AlumnoAD alu : alumnos) {
                        agregarAlumnoATabla(dtmRead, alu);
                    }
                } catch (JsonSyntaxException e) {
                    JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][37]);
                }
            } else {
                JOptionPane.showMessageDialog(null, Mensajes.MENSAJES[0][9]);
            }

        }


    }//GEN-LAST:event_jButtonLeerImportarJsonActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupActualizar;
    private javax.swing.ButtonGroup buttonGroupBorrar;
    private javax.swing.ButtonGroup buttonGroupLeer;
    private javax.swing.JButton jButtonBorrarAniadirTabla;
    private javax.swing.JButton jButtonBorrarLimpiarTabla;
    private javax.swing.JButton jButtonBorrarRegistros;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonCrearLimpiar;
    private javax.swing.JButton jButtonGuardarDescartar;
    private javax.swing.JButton jButtonGuardarDescartarSalir;
    private javax.swing.JButton jButtonGuardarGuardarSalir;
    private javax.swing.JButton jButtonLeerAniadir;
    private javax.swing.JButton jButtonLeerExportarJson;
    private javax.swing.JButton jButtonLeerImportarJson;
    private javax.swing.JButton jButtonLeerLimpiarTabla;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModificarIniciar;
    private javax.swing.JButton jButtonModificarLimpiar;
    private javax.swing.JLabel jLabelCrearMatricula;
    private javax.swing.JLabel jLabelCrearNombre;
    private javax.swing.JLabel jLabelCrearNot1Ev;
    private javax.swing.JLabel jLabelCrearNot2Ev;
    private javax.swing.JLabel jLabelCrearNotExtra;
    private javax.swing.JLabel jLabelCrearNotFinal;
    private javax.swing.JLabel jLabelGuardarDescartar;
    private javax.swing.JLabel jLabelGuardarDescartarSalir;
    private javax.swing.JLabel jLabelGuardarGuardarSalir;
    private javax.swing.JLabel jLabelModificarMatricula;
    private javax.swing.JLabel jLabelModificarNombre;
    private javax.swing.JLabel jLabelModificarNot1Ev;
    private javax.swing.JLabel jLabelModificarNot2Ev;
    private javax.swing.JLabel jLabelModificarNotExtra;
    private javax.swing.JLabel jLabelModificarNotFinal;
    private javax.swing.JLabel jLabelTituloActualizar;
    private javax.swing.JLabel jLabelTituloActualizar1;
    private javax.swing.JLabel jLabelTituloCrear;
    private javax.swing.JLabel jLabelTituloLeer;
    private javax.swing.JList<String> jListBorrar;
    private javax.swing.JList<String> jListLeer;
    private javax.swing.JList<String> jListModificar;
    private javax.swing.JPanel jPanelActualizar;
    private javax.swing.JPanel jPanelBorrar;
    private javax.swing.JPanel jPanelCrear;
    private javax.swing.JPanel jPanelGuardar;
    private javax.swing.JPanel jPanelLeer;
    private javax.swing.JRadioButton jRadioButtonActuLista;
    private javax.swing.JRadioButton jRadioButtonActuManual;
    private javax.swing.JRadioButton jRadioButtonBorrarLista;
    private javax.swing.JRadioButton jRadioButtonBorrarManual;
    private javax.swing.JRadioButton jRadioButtonLeerLista;
    private javax.swing.JRadioButton jRadioButtonLeerManual;
    private javax.swing.JScrollPane jScrollPaneBorrarLista;
    private javax.swing.JScrollPane jScrollPaneBorrarTabla;
    private javax.swing.JScrollPane jScrollPaneLeerLista;
    private javax.swing.JScrollPane jScrollPaneLeerTabla;
    private javax.swing.JScrollPane jScrollPaneModificarLista;
    private javax.swing.JTabbedPane jTabbedPaneGeneral;
    private javax.swing.JTable jTableBorrarTabla;
    private javax.swing.JTable jTableLeerTabla;
    private javax.swing.JTextField jTextFieldBorrarManual;
    private javax.swing.JTextField jTextFieldCrearMatricula;
    private javax.swing.JTextField jTextFieldCrearNombre;
    private javax.swing.JTextField jTextFieldCrearNot1Ev;
    private javax.swing.JTextField jTextFieldCrearNot2Ev;
    private javax.swing.JTextField jTextFieldCrearNotExtra;
    private javax.swing.JTextField jTextFieldCrearNotFinal;
    private javax.swing.JTextField jTextFieldLeerManual;
    private javax.swing.JTextField jTextFieldModificarMatricula;
    private javax.swing.JTextField jTextFieldModificarNombre;
    private javax.swing.JTextField jTextFieldModificarNot1Ev;
    private javax.swing.JTextField jTextFieldModificarNot2Ev;
    private javax.swing.JTextField jTextFieldModificarNotExtra;
    private javax.swing.JTextField jTextFieldModificarNotFinal;
    // End of variables declaration//GEN-END:variables

}
