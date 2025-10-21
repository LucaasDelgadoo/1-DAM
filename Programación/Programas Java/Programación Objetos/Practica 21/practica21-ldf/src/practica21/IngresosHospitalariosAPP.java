package practica21;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class IngresosHospitalariosAPP extends JFrame {
	
	private static final String NOMBRE_BASE_DE_DATOS = "jdbc:sqlite:C:\\Users\\lucas.delfer\\Desktop\\ECLIPSE\\SQLiteDatabaseBrowserPortable\\practica21.db";
	private static final String RUTA_ARCHIVO = "src/configuracion.txt";
	private static JPanel panel1;
	private static JPanel panel2;
	private static JPanel panel3;
	private static JPanel labelPanel1;
	private static JPanel labelPanel2;
	private static JPanel labelPanel3;
	private static JTabbedPane panelDePestañas;
	private static JButton anadirButton;
	private static JButton modificarButton;
	private static JButton eliminarButton;
	private static JButton configuracionButton;
	private static int opcionInicial;
	private static int opcionModificar;
	private static File archivoTexto;
	
	public static void main(String [] args) {
		
		//MENSAJES INICIALES DEL PROGRAMA AL INICIARLO
		mensajeBienvenidaPrograma();
		mensajeCreacionTablas();
		
		//ELECCION DE CREACION DE TABLAS O SALIDA DEL PROGRAMA
		opcionInicial = opcionesMenuProgramaTablasNoCreadas();
		
		if (opcionInicial == 0) {
			
			IngresosHospitalariosAPP APP = new IngresosHospitalariosAPP();
			crearTablaPacientes();
			crearTablaMedicos();
			crearTablaIngresos();
			crearArchivoTextoConfiguracion();
			
			
			//IMPORTATE CAMBIAR LAS FUNCIONES DE LOS BOTONES DEPENDIENDO DE QUE PESTAÑA ESTA SELECCIONADA
			
		} else if (opcionInicial == 1) {
			
			JOptionPane.showMessageDialog(null, "HAS SALIDO DEL PROGRAMA");
			
		}
		
	}

	/*AQUI VA TODA LA INTERFAZ, PESTAÑAS, BOTONES Y DESPUES DEBO DE ENLAZARLO 
	  CON LA FUNCION DEL BOTON AL LOS METODOS DE LAS BASES DE DATOS*/
	public IngresosHospitalariosAPP() {
		
	    JFrame frame = new JFrame("PRACTICA 21");
	    frame.setSize(800, 600);
	    frame.setLayout(new BorderLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    panelDePestañas = new JTabbedPane();
	    
	    //PESTAÑA PACIENTES
	    panel1 = new JPanel();
	    panel1.setLayout(new GridLayout(2, 2));
	    labelPanel1 = new JPanel();
	    labelPanel1.setSize(100, 600);
	    
	    JLabel id_paciente = new JLabel("ID");
	    JLabel nombre_paciente = new JLabel("Nombre");
	    JLabel apellidos_paciente = new JLabel("Apellidos");
	    JLabel domicilio_paciente = new JLabel("Domicilio");
	    JLabel telefono_paciente = new JLabel("Telefono");
	    JLabel n_ss_paciente = new JLabel("N_SS");
	    JLabel observaciones_paciente = new JLabel("Observaciones");
	    
	    labelPanel1.add(id_paciente, SwingConstants.CENTER);
	    labelPanel1.add(nombre_paciente, SwingConstants.CENTER);
	    labelPanel1.add(apellidos_paciente, SwingConstants.CENTER);
	    labelPanel1.add(domicilio_paciente, SwingConstants.CENTER);
	    labelPanel1.add(telefono_paciente, SwingConstants.CENTER);
	    labelPanel1.add(n_ss_paciente, SwingConstants.CENTER);
	    labelPanel1.add(observaciones_paciente, SwingConstants.CENTER);
	    
	    panel1.add(labelPanel1, BorderLayout.NORTH);
	    
	    panelDePestañas.addTab("Pacientes", panel1);
	    panelDePestañas.setMnemonicAt(0, KeyEvent.VK_1);
	    
	    //PESTAÑA MEDICOS
	    panel2 = new JPanel();
	    panel2.setLayout(new GridLayout(2, 2));
	    labelPanel2 = new JPanel();
	    labelPanel2.setSize(100, 600);
	    
	    JLabel id_medico = new JLabel("ID");
	    JLabel nombre_medico = new JLabel("Nombre");
	    JLabel apellidos_medico = new JLabel("Apellidos");
	    JLabel especialidad_medico = new JLabel("Especialidad");
	    JLabel n_colegiado_medico = new JLabel("N_Colegiado");
	    JLabel cargo_medico = new JLabel("Cargo");
	    JLabel observaciones_medico = new JLabel("Observaciones");
	    
	    labelPanel2.add(id_medico, SwingConstants.CENTER);
	    labelPanel2.add(nombre_medico, SwingConstants.CENTER);
	    labelPanel2.add(apellidos_medico, SwingConstants.CENTER);
	    labelPanel2.add(especialidad_medico, SwingConstants.CENTER);
	    labelPanel2.add(n_colegiado_medico, SwingConstants.CENTER);
	    labelPanel2.add(cargo_medico, SwingConstants.CENTER);
	    labelPanel2.add(observaciones_medico, SwingConstants.CENTER);
	    
	    panel2.add(labelPanel2, BorderLayout.NORTH);
	    
	    panelDePestañas.addTab("Medicos", panel2);
	    panelDePestañas.setMnemonicAt(0, KeyEvent.VK_2);
	    
	    //PESTAÑA INGRESOS
	    panel3 = new JPanel();
	    panel3.setLayout(new GridLayout(2, 2));
	    labelPanel3 = new JPanel();
	    labelPanel3.setSize(100, 600);
	    
	    JLabel id_ingreso = new JLabel("ID");
	    JLabel id_paciente_FK = new JLabel("ID_Paciente");
	    JLabel id_medico_FK = new JLabel("ID_Medico");
	    JLabel fecha_ingreso = new JLabel("Fecha_Ingreso");
	    JLabel planta_ingreso = new JLabel("Planta");
	    JLabel cama_ingreso = new JLabel("Cama");
	    JLabel observaciones_ingreso = new JLabel("Observaciones");
	    
	    labelPanel3.add(id_ingreso, SwingConstants.CENTER);
	    labelPanel3.add(id_paciente_FK, SwingConstants.CENTER);
	    labelPanel3.add(id_medico_FK, SwingConstants.CENTER);
	    labelPanel3.add(fecha_ingreso, SwingConstants.CENTER);
	    labelPanel3.add(planta_ingreso, SwingConstants.CENTER);
	    labelPanel3.add(cama_ingreso, SwingConstants.CENTER);
	    labelPanel3.add(observaciones_ingreso, SwingConstants.CENTER);
	   
	    panel3.add(labelPanel3, BorderLayout.NORTH);
	    
	    panelDePestañas.addTab("Ingresos", panel3);
	    panelDePestañas.setMnemonicAt(0, KeyEvent.VK_2);
	    
	    //---------------------------------------------------------------------
	    
	    //BOTON AÑADIR Y PANEL
	    JPanel panelBotones = new JPanel();
	    panelBotones.setLayout(new FlowLayout());
	    
	    anadirButton = new JButton("Añadir");
	    anadirButton.setVerticalTextPosition(AbstractButton.CENTER);
	    anadirButton.setHorizontalTextPosition(AbstractButton.CENTER);
	    
	    //METODO PARA QUE DEPENDIENDO DE LA PESTAÑA SELECCIONADA UTILICE EL METODO CORRECTO
	    anadirButton.addActionListener(new ActionListener() {
	    	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                int seleccionPanel = panelDePestañas.getSelectedIndex();
                
                if (seleccionPanel == 0) {
                	
                	insertarNuevoPaciente();
                    
                } else if (seleccionPanel == 1) {
                	
                	insertarNuevoMedico();
                    
                } else if (seleccionPanel == 2) 
                	
                	insertarNuevoIngreso();
                	
            }
            
        });
	    
	    anadirButton.setMnemonic(KeyEvent.VK_A);
	    
	    //BOTON MODIFICAR
	    modificarButton = new JButton("Modificar");
	    modificarButton.setVerticalTextPosition(AbstractButton.CENTER);
	    modificarButton.setHorizontalTextPosition(AbstractButton.CENTER);
	    
	    //METODO PARA QUE DEPENDIENDO DE LA PESTAÑA SELECCIONADA UTILICE EL METODO CORRECTO
	    modificarButton.addActionListener(new ActionListener() {
	    	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                int seleccionPanel = panelDePestañas.getSelectedIndex();
                
                if (seleccionPanel == 0) {
                	
                	actualizarDatosPacientes();
                    
                } else if (seleccionPanel == 1) {
                	
                	actualizarDatosMedicos();
                    
                } else if (seleccionPanel == 2) 
                	
                	actualizarDatosIngresos();
                	
            }
            
        });
	    
	    modificarButton.setMnemonic(KeyEvent.VK_M);
	    
	    //BOTON ELIMINAR
	    eliminarButton = new JButton("Eliminar");
	    eliminarButton.setVerticalTextPosition(AbstractButton.CENTER);
	    eliminarButton.setHorizontalTextPosition(AbstractButton.CENTER);
	    
	    //METODO PARA QUE DEPENDIENDO DE LA PESTAÑA SELECCIONADA UTILICE EL METODO CORRECTO
	    eliminarButton.addActionListener(new ActionListener() {
	    	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                int seleccionPanel = panelDePestañas.getSelectedIndex();
                
                if (seleccionPanel == 0) {
                	
                	eliminarPacientePorID();
                    
                } else if (seleccionPanel == 1) {
                	
                	eliminarMedicoPorID();
                    
                } else if (seleccionPanel == 2) 
                	
                	eliminarIngresoPorID();
                	
            }
            
        });
	    
	    eliminarButton.setMnemonic(KeyEvent.VK_E);
	    
	    //BOTON CONFIGURACION (PARA VER EL LOG Y LA RUTA DE LA BASE DE DATOS)
	    configuracionButton = new JButton("Configuracion");
	    configuracionButton.setVerticalTextPosition(AbstractButton.CENTER);
	    configuracionButton.setHorizontalTextPosition(AbstractButton.CENTER);
	    configuracionButton.addActionListener(e -> lecturaArchivoTexto());
	    
	    /*
	    opcionConfig = opcionesConfiguracion();
	    
	    if (opcionConfig == 1) {
	    	
	    	configuracionButton.addActionListener(e -> lecturaArchivoTexto());
	    	
	    } else if (opcionConfig == 1) {
	    	
	    	//SALIR
	    	
	    } 
	    */
	    
	    configuracionButton.setMnemonic(KeyEvent.VK_C);
	    
	    panelBotones.add(anadirButton, BorderLayout.SOUTH);
	    panelBotones.add(modificarButton, BorderLayout.SOUTH);
	    panelBotones.add(eliminarButton, BorderLayout.SOUTH);
	    panelBotones.add(configuracionButton, BorderLayout.SOUTH);
	    panelBotones.setSize(600, 150);
	    
	    //AÑADIR LAS PESTAÑAS AL PANEL
	    frame.add(panelDePestañas, BorderLayout.CENTER);
	    frame.add(panelBotones, BorderLayout.SOUTH);
	    frame.setVisible(true);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------
	
	//METODOS REFERIDOS CON LA BASE DE DATOS
	
	//CREACION DE LAS TABLAS
	
	//PACIENTES
	private static void crearTablaPacientes() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaPacientes = "CREATE TABLE IF NOT EXISTS Pacientes ("
                    + "id_paciente INTEGER PRIMARY KEY, "
                    + "nombre VARCHAR(100) NOT NULL, "
                    + "apellidos VARCHAR(100) NOT NULL, "
                    + "domicilio VARCHAR(100) NOT NULL, "
                    + "telefono VARCHAR(100) NOT NULL, "
                    + "n_ss VARCHAR(100) NOT NULL, "
                    + "observaciones VARCHAR(100) NOT NULL);";

            miStatement.executeUpdate(crearTablaPacientes);
            JOptionPane.showMessageDialog(null, "Tabla Pacientes creada correctamente");

        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Pacienes: " + e.getMessage());
            
        }
    }
	
	//MEDICOS
	private static void crearTablaMedicos() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaMedicos = "CREATE TABLE IF NOT EXISTS Medicos ("
                    + "id_medico INTEGER PRIMARY KEY, "
                    + "nombre VARCHAR(100) NOT NULL, "
                    + "apellidos VARCHAR(100) NOT NULL, "
                    + "especialidad VARCHAR(100) NOT NULL, "
                    + "n_colegiado VARCHAR(100) NOT NULL, "
                    + "cargo VARCHAR(100) NOT NULL, "
                    + "observaciones VARCHAR(100) NOT NULL);";

            miStatement.executeUpdate(crearTablaMedicos);
            JOptionPane.showMessageDialog(null, "Tabla Medicos creada correctamente");

        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Medicos: " + e.getMessage());
            
        }
    }
	
	//INGRESOS
	private static void crearTablaIngresos() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaIngresos = "CREATE TABLE IF NOT EXISTS Ingresos ("
                    + "id_ingreso INTEGER PRIMARY KEY, "
                    + "id_paciente INTEGER NOT NULL, "
                    + "id_medico INTEGER NOT NULL, "
                    + "fecha_ingreso DATE NOT NULL, "
                    + "planta INTEGER NOT NULL, "
                    + "cama INTEGER NOT NULL, "
                    + "observaciones VARCHAR(100) NOT NULL, "
                    + "FOREIGN KEY (id_paciente) REFERENCES Pacientes(id_paciente), "
                    + "FOREIGN KEY (id_medico) REFERENCES Medicos(id_medico));";

            miStatement.executeUpdate(crearTablaIngresos);
            JOptionPane.showMessageDialog(null, "Tabla Ingresos creada correctamente");

        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Ingresos: " + e.getMessage());
            
        }
    }
	
	//INSERCION DE LOS DATOS EN CADA TABLA PREGUNTANDO AL USUARIO
	
	//PACIENTES
	private static void insertarNuevoPaciente() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String pacienteIDString = JOptionPane.showInputDialog("Introduce el ID del paciente nuevo:");
            int pacienteIDInt = Integer.parseInt(pacienteIDString);
            String nombre = JOptionPane.showInputDialog("Introduce el nombre (SOLO NOMBRE) del paciente nuevo:");
            String apellidos = JOptionPane.showInputDialog("Introduce los apellidos (PRIMER Y SEGUNDO APELLIDO) del paciente nuevo:");
            String domicilio = JOptionPane.showInputDialog("Introduce el domicilio del paciente nuevo:");
            String telefono = JOptionPane.showInputDialog("Introduce el teléfono (SIN EL +34) del paciente nuevo:");
            String n_ss = JOptionPane.showInputDialog("Introduce el numero de la Seguridad Social (SS) del paciente nuevo:");
            String observaciones = JOptionPane.showInputDialog("Introduce observaciones del paciente nuevo:");
           
            String sql = "INSERT INTO Pacientes (id_paciente, nombre, apellidos, domicilio, telefono, n_ss, observaciones) VALUES ("
                    + pacienteIDInt + ", '" + nombre + "', '" + apellidos + "', '" + domicilio + "', '" + telefono + "', '" + n_ss + "', '"
                    + observaciones + "');";
            
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
            
        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Paciente: " + e.getMessage());
            
        } catch (NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
        
    }
	
	//MEDICOS
	private static void insertarNuevoMedico() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String medicoIDString = JOptionPane.showInputDialog("Introduce el ID del medico nuevo:");
            int medicoIDInt = Integer.parseInt(medicoIDString);
            String nombre = JOptionPane.showInputDialog("Introduce el nombre (SOLO NOMBRE) del medico nuevo:");
            String apellidos = JOptionPane.showInputDialog("Introduce los apellidos (PRIMER Y SEGUNDO APELLIDO) del medico nuevo:");
            String especialidad = JOptionPane.showInputDialog("Introduce la especialidad del medico nuevo:");
            String n_colegiado = JOptionPane.showInputDialog("Introduce el numero de colegiado del medico nuevo:");
            String cargo = JOptionPane.showInputDialog("Introduce el cargo del medico nuevo:");
            String observaciones = JOptionPane.showInputDialog("Introduce observaciones del medico nuevo:");
           
            String sql = "INSERT INTO Medicos (id_medico, nombre, apellidos, especialidad, n_colegiado, cargo, observaciones) VALUES ("
                    + medicoIDInt + ", '" + nombre + "', '" + apellidos + "', '" + especialidad + "', '" + n_colegiado + "', '" + cargo + "', '"
                    + observaciones + "');";
            
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
            
        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Medico: " + e.getMessage());
            
        } catch (NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
        
    }
	
	//INGRESOS
	private static void insertarNuevoIngreso() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String ingresoIDString = JOptionPane.showInputDialog("Introduce el ID del ingreso nuevo:");
            int ingresoIDInt = Integer.parseInt(ingresoIDString);
            String pacienteIDString = JOptionPane.showInputDialog("Introduce el ID del paciente nuevo:");
            int pacienteIDInt = Integer.parseInt(pacienteIDString);
            String medicoIDString = JOptionPane.showInputDialog("Introduce el ID del medico nuevo:");
            int medicoIDInt = Integer.parseInt(medicoIDString);
            String fecha_ingreso = JOptionPane.showInputDialog("Introduce la fecha del ingreso nuevo:");
            String planta = JOptionPane.showInputDialog("Introduce la planta del ingreso nuevo:");
            String cama = JOptionPane.showInputDialog("Introduce la cama del ingreso nuevo:");
            String observaciones = JOptionPane.showInputDialog("Introduce las observacione del ingreso nuevo:");
           
            String sql = "INSERT INTO Ingresos (id_ingreso, id_paciente, id_medico, fecha_ingreso, planta, cama, observaciones) VALUES ("
                    + ingresoIDInt + ", '" + pacienteIDInt + "', '" + medicoIDInt + "', '" + fecha_ingreso + "', '" + planta + "', '" + cama + "', '"
                    + observaciones + "');";
            
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
            
        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Ingreso: " + e.getMessage());
            
        } catch (NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
        
    }
	
	//ELIMINACION DE FILAS PREGUNTANDO EL ID DE CADA TABLA
	
	//PACIENTES
	private static void eliminarPacientePorID() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS)) {
        	
            miConexion.setAutoCommit(false);
            
            String id_pacienteString = JOptionPane.showInputDialog("Introduce el id_paciente que deseas eliminar:");
            int id_paciente = Integer.parseInt(id_pacienteString);
            
            String sql = "DELETE FROM Pacientes WHERE id_paciente = " + id_paciente;
            
            try (PreparedStatement ps = miConexion.prepareStatement(sql)) {
            	
                int filasAfectadas = ps.executeUpdate();
                miConexion.commit();
                JOptionPane.showMessageDialog(null, "Pacientes eliminados: " + filasAfectadas);
                
            }
            
        } catch (SQLException e) {
        	
            System.out.println("Error en eliminarPacientePorID: " + e.getMessage());
            e.printStackTrace();
            
        } catch (NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "Formato incorrecto: " + e.getMessage());
            
        }
        
    }
	
	//MEDICOS
	private static void eliminarMedicoPorID() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS)) {
        	
            miConexion.setAutoCommit(false);
            
            String id_medicoString = JOptionPane.showInputDialog("Introduce el id_medico que deseas eliminar:");
            int id_medico = Integer.parseInt(id_medicoString);
            
            String sql = "DELETE FROM Medicos WHERE id_medico = " + id_medico;
            try (PreparedStatement ps = miConexion.prepareStatement(sql)) {
            	
                int filasAfectadas = ps.executeUpdate();
                miConexion.commit();
                JOptionPane.showMessageDialog(null, "Pacientes eliminados: " + filasAfectadas);
            }
            
        } catch (SQLException e) {
        	
            System.out.println("Error en eliminarMedicoPorID: " + e.getMessage());
            e.printStackTrace();
            
        } catch (NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "Formato incorrecto: " + e.getMessage());
            
        }
        
    }
	
	//INGRESOS
	private static void eliminarIngresoPorID() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS)) {
        	
            miConexion.setAutoCommit(false);
            
            String id_ingresoString = JOptionPane.showInputDialog("Introduce el id_ingreso que deseas eliminar:");
            int id_ingreso = Integer.parseInt(id_ingresoString);
            
            String sql = "DELETE FROM Ingresos WHERE id_ingreso = " + id_ingreso;
            try (PreparedStatement ps = miConexion.prepareStatement(sql)) {
            	
                int filasAfectadas = ps.executeUpdate();
                miConexion.commit();
                JOptionPane.showMessageDialog(null, "Pacientes eliminados: " + filasAfectadas);
            }
            
        } catch (SQLException e) {
        	
            System.out.println("Error en eliminarIngresoPorID: " + e.getMessage());
            e.printStackTrace();
            
        } catch (NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "Formato incorrecto: " + e.getMessage());
            
        }
        
    }
	
	//ACTUALZIACION DE LOS DATOS PREGUNTANDO POR EL IDÇ
	
	//PACIENTES
	private static void actualizarDatosPacientes() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
        	
        	opcionModificar = opcionesActualizacionPacientes();
        	
        	if (opcionModificar == 0) {
        		
        		String id_pacienteAntiguoString = JOptionPane.showInputDialog("Introduce el id_paciente que deseas cambiar");
            	int id_pacienteAntiguoInt = Integer.parseInt(id_pacienteAntiguoString);
        		
        		String nuevo_id_paciente = JOptionPane.showInputDialog("Introduce el nuevo id_paciente");
                int id_paciente = Integer.parseInt(nuevo_id_paciente);
  
                String actualizar_id_paciente = "UPDATE Pacientes SET id_paciente = '" + id_paciente + "' WHERE id_paciente = '" + id_pacienteAntiguoInt + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_id_paciente);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 1) {
        		
        		String nombreAntiguo = JOptionPane.showInputDialog("Introduce el nombre que deseas cambiar");
        		
        		String nuevo_nombre = JOptionPane.showInputDialog("Introduce el nuevo nombre");

        		String actualizar_id_paciente = "UPDATE Pacientes SET nombre = '" + nuevo_nombre + "' WHERE nombre = '" + nombreAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_id_paciente);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 2) {
        		
        		String apellidosAntiguo = JOptionPane.showInputDialog("Introduce los apellidos que deseas cambiar");
        		
        		String nuevos_apellidos = JOptionPane.showInputDialog("Introduce los nuevos apellidos");

        		String actualizar_apellidos = "UPDATE Pacientes SET apellidos = '" + nuevos_apellidos + "' WHERE apeliidos = '" + apellidosAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_apellidos);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 3) {
        		
        		String domicilioAntiguo = JOptionPane.showInputDialog("Introduce el domicilio que deseas cambiar");
        		
        		String nuevo_domicilio = JOptionPane.showInputDialog("Introduce el nuevo domicilio");

        		String actualizar_dommicilio = "UPDATE Pacientes SET domicilio = '" + nuevo_domicilio + "' WHERE domicilio = '" + domicilioAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_dommicilio);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 4) {
        		
        		String telefonoAntiguo = JOptionPane.showInputDialog("Introduce el telefono que deseas cambiar");
        		
        		String nuevo_telefono = JOptionPane.showInputDialog("Introduce el nuevo telefono");

        		String actualizar_telefono = "UPDATE Pacientes SET telefono = '" + nuevo_telefono + "' WHERE telefono = '" + telefonoAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_telefono);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 5) {

        		String n_ssAntiguo= JOptionPane.showInputDialog("Introduce el n_ss que deseas cambiar");
        		
        		String nuevo_n_ss= JOptionPane.showInputDialog("Introduce el nuevo n_ss");

        		String actualizar_n_ss = "UPDATE Pacientes SET n_ss = '" + nuevo_n_ss + "' WHERE n_ss = '" + n_ssAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_n_ss);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 6) {
        		
        		String observacionesAntiguo = JOptionPane.showInputDialog("Introduce las observaciones que deseas cambiar");
        		
        		String nuevo_observaciones = JOptionPane.showInputDialog("Introduce las nuevas observaciones");

        		String actualizar_observaciones = "UPDATE Pacientes SET observaciones = '" + nuevo_observaciones + "' WHERE observaciones = '" + observacionesAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_observaciones);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	}
            
        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en actualizar datos: " + e.getMessage());
            
        }
        
    }
	
	private static int opcionesActualizacionPacientes() {
		
		String[] opcionesActualizaciones = { "id_paciente", "nombre", "apellidos", "domicilio", "telefono", "n_ss", "observaciones" };
		
		int opcionActualizacion = JOptionPane.showOptionDialog(null, "ACTUALIZACION DE DATOS", "SELECCIONE QUE TIPO DE DATO DESEA ACTUALIZAR", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesActualizaciones, "");
		
		return opcionActualizacion;
		
	}
	
	//MEDICOS
	private static void actualizarDatosMedicos() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
        	
        	opcionModificar = opcionesActualizacionMedicos();
        	
        	if (opcionModificar == 0) {
        		
        		String id_medicoAntiguoString = JOptionPane.showInputDialog("Introduce el id_medico que deseas cambiar");
            	int id_medicoAntiguoInt = Integer.parseInt(id_medicoAntiguoString);
        		
        		String nuevo_id_medico = JOptionPane.showInputDialog("Introduce el nuevo id_medico");
                int id_medico = Integer.parseInt(nuevo_id_medico);

                String actualizar_id_medico = "UPDATE Medicos SET id_medico = '" + id_medico + "' WHERE id_medico = '" + id_medicoAntiguoInt + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_id_medico);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 1) {
        		
        		String nombreAntiguo = JOptionPane.showInputDialog("Introduce el nombre que deseas cambiar");
        		
        		String nuevo_nombre = JOptionPane.showInputDialog("Introduce el nuevo nombre");

        		String actualizar_nombre = "UPDATE Medicos SET nombre = '" + nuevo_nombre + "' WHERE nombre = '" + nombreAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_nombre);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 2) {
        		
        		String apellidosAntiguo = JOptionPane.showInputDialog("Introduce los apellidos que deseas cambiar");
        		
        		String nuevos_apellidos = JOptionPane.showInputDialog("Introduce los nuevos apellidos");

        		String actualizar_apellidos = "UPDATE Medicos SET apellidos = '" + nuevos_apellidos + "' WHERE apellidos = '" + apellidosAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_apellidos);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 3) {
        		
        		String especialidadAntiguo = JOptionPane.showInputDialog("Introduce la especialidad que deseas cambiar");
        		
        		String nuevo_especialidad = JOptionPane.showInputDialog("Introduce la nuevo especialidad");

        		String actualizar_especialidad = "UPDATE Medicos SET especialidad = '" + nuevo_especialidad + "' WHERE especialidad = '" + especialidadAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_especialidad);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 4) {
        		
        		String n_colegiadoAntiguo = JOptionPane.showInputDialog("Introduce el n_colegiado que deseas cambiar");
        		
        		String nuevo_n_colegiado = JOptionPane.showInputDialog("Introduce el nuevo n_colegiado");

        		String actualizar_n_colegiado = "UPDATE Medicos SET n_colegiado = '" + nuevo_n_colegiado + "' WHERE n_colegiado = '" + n_colegiadoAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_n_colegiado);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 5) {

        		String cargoAntiguo = JOptionPane.showInputDialog("Introduce el cargo que deseas cambiar");
        		
        		String nuevo_cargo = JOptionPane.showInputDialog("Introduce el nuevo cargo");

        		String actualizar_cargo= "UPDATE Medicos SET cargo = '" + nuevo_cargo + "' WHERE cargo = '" + cargoAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_cargo);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 6) {
        		
        		String observacionesAntiguo = JOptionPane.showInputDialog("Introduce las observaciones que deseas cambiar");
        		
        		String nuevo_observaciones = JOptionPane.showInputDialog("Introduce las nuevas observaciones");

        		String actualizar_observaciones = "UPDATE Medicos SET observaciones = '" + nuevo_observaciones + "' WHERE observaciones = '" + observacionesAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_observaciones);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	}
            
        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en actualizar datos: " + e.getMessage());
            
        }
        
    }
	
	private static int opcionesActualizacionMedicos() {
		
		String[] opcionesActualizaciones = { "id_medico", "nombre", "apellidos", "especialidad", "n_colegiado", "cargo", "observaciones" };
		
		int opcionActualizacion = JOptionPane.showOptionDialog(null, "ACTUALIZACION DE DATOS", "SELECCIONE QUE TIPO DE DATO DESEA ACTUALIZAR", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesActualizaciones, "");
		
		return opcionActualizacion;
		
	}
	
	//INGRESOS
	private static void actualizarDatosIngresos() {
		
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
        	
        	opcionModificar = opcionesActualizacionIngresos();
        	
        	if (opcionModificar == 0) {
        		
        		String id_ingresoAntiguoString = JOptionPane.showInputDialog("Introduce el id_ingreso que deseas cambiar");
            	int id_ingresoAntiguoInt = Integer.parseInt(id_ingresoAntiguoString);
        		
        		String nuevo_id_ingreso = JOptionPane.showInputDialog("Introduce el nuevo id_ingreso");
                int id_ingreso = Integer.parseInt(nuevo_id_ingreso);

                String actualizar_id_ingreso = "UPDATE Ingresos SET id_ingreso = '" + id_ingreso + "' WHERE id_ingreso = '" + id_ingresoAntiguoInt + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_id_ingreso);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 1) {
        		
        		String id_pacienteAntiguoString = JOptionPane.showInputDialog("Introduce el id_paciente que deseas cambiar");
            	int id_pacienteAntiguoInt = Integer.parseInt(id_pacienteAntiguoString);
        		
        		String nuevo_id_paciente = JOptionPane.showInputDialog("Introduce el nuevo id_paciente");
                int id_paciente = Integer.parseInt(nuevo_id_paciente);
                
        		String actualizar_id_paciente = "UPDATE Ingresos SET id_paciente = '" + id_paciente + "' WHERE id_paciente = '" + id_pacienteAntiguoInt + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_id_paciente);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 2) {
        		
        		String id_medicoAntiguoString = JOptionPane.showInputDialog("Introduce el id_medico que deseas cambiar");
            	int id_medicoAntiguoInt = Integer.parseInt(id_medicoAntiguoString);
        		
        		String nuevo_id_medico = JOptionPane.showInputDialog("Introduce el nuevo id_medico");
                int id_medico = Integer.parseInt(nuevo_id_medico);

        		String actualizar_id_medico = "UPDATE Ingresos SET id_medico = '" + id_medico + "' WHERE id_medico = '" + id_medicoAntiguoInt + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_id_medico);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 3) {
        		
        		String fecha_ingreso = JOptionPane.showInputDialog("Introduce la fecha_ingreso que deseas cambiar");
        		
        		String nuevo_fecha_ingreso = JOptionPane.showInputDialog("Introduce la nueva fecha_ingreso");

        		String actualizar_fecha_ingreso = "UPDATE Ingresos SET fecha_ingreso = '" + nuevo_fecha_ingreso + "' WHERE fecha_ingreso = '" + fecha_ingreso + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_fecha_ingreso);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 4) {
        		
        		String plantaAntiguo = JOptionPane.showInputDialog("Introduce la planta que deseas cambiar");
        		
        		String nuevo_planta = JOptionPane.showInputDialog("Introduce la nueva planta");

        		String actualizar_cama= "UPDATE Ingresos SET planta = '" + nuevo_planta + "' WHERE planta = '" + plantaAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_cama);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 5) {

        		String camaAntiguo= JOptionPane.showInputDialog("Introduce la cama que deseas cambiar");
        		
        		String nuevo_cama = JOptionPane.showInputDialog("Introduce la nueva cama");

        		String actualizar_cama = "UPDATE Ingresos SET cama = '" + nuevo_cama + "' WHERE cama = '" + camaAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_cama);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	} else if (opcionModificar == 6) {
        		
        		String observacionesAntiguo = JOptionPane.showInputDialog("Introduce las observaciones que deseas cambiar");
        		
        		String nuevo_observaciones = JOptionPane.showInputDialog("Introduce las nuevas observaciones");

        		String actualizar_observaciones = "UPDATE Ingresos SET observaciones = '" + nuevo_observaciones + "' WHERE observaciones = '" + observacionesAntiguo + "'";
                int filasAfectadas = miStatement.executeUpdate(actualizar_observaciones);
                JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        		
        	}
            
        } catch (SQLException e) {
        	
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en actualizar datos: " + e.getMessage());
            
        }
        
    }
	
	private static int opcionesActualizacionIngresos() {
		
		String[] opcionesActualizaciones = { "id_ingreso", "id_paciente", "id_medico", "fecha_ingreso", "planta", "cama", "observaciones" };
		
		int opcionActualizacion = JOptionPane.showOptionDialog(null, "ACTUALIZACION DE DATOS", "SELECCIONE QUE TIPO DE DATO DESEA ACTUALIZAR", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesActualizaciones, "");
		
		return opcionActualizacion;
		
	}
	
	//CREACION DEL ARCHIVO DE TEXTO PARA VER LA UBICACION DE LA BASE DE DATOS
	private static void crearArchivoTextoConfiguracion() { 

		archivoTexto = new File(RUTA_ARCHIVO);

		try {
	        	
	         if (archivoTexto.createNewFile()) {
	            	
	        	 JOptionPane.showMessageDialog(null,"Archivo creado con éxito: " + archivoTexto.getAbsolutePath());
	                
	             try (FileWriter escritor = new FileWriter(archivoTexto)) {
	                	
	            	 escritor.write("Ruta Base de datos: " + NOMBRE_BASE_DE_DATOS);
	                 JOptionPane.showMessageDialog(null, "Contenido agregado al archivo.");
	                    
	             }
	                
	          } else {
	            	
	        	  JOptionPane.showMessageDialog(null,"El archivo ya existe.");
	                
	          }
	            
	     } catch (IOException e) {
	        	
	    	 JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage());
	            
	     }
	        
	}	
	
	//LEER ARCHIVO DONDE VA EL .LOG Y LA RUTA DE LA BASE DE DATOS
	private static void lecturaArchivoTexto() {
		
		String rutaArchivo = RUTA_ARCHIVO;

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
				
			String linea;
			
			while ((linea = br.readLine()) != null) {
				
				JOptionPane.showMessageDialog(null, linea);
				
	        }
	        
		} catch (IOException e) {
	
			JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
		
		}
	    
	}
	
	//MENSAJE DE EXPLICACION DE LA APLICACION
	private static void mensajeBienvenidaPrograma() {
		
        String mensaje = "Bienvenido/a a la Practica21! 🚀\n\n"
                + "Inicializando conexión con la base de datos... 🔄\n\n"
                + "✅ Conexión establecida correctamente.\n"
                + "🗄️ Base de datos lista para operar.\n\n"
                + "¡Que tengas una excelente experiencia!\n"
                + "Para poder utilizar el programa, deberás crear las tablas para posteriormente realizar consultas y almacenar datos.";
        
        JOptionPane.showMessageDialog(null, mensaje);
        
    }
	
	//MENSAJE DE OBLIGACION DE CREAR TABLAS
	private static void mensajeCreacionTablas() {
		
        String mensaje = "Para que tu base de datos funcione correctamente, debes crear todas las tablas que aparecen en el menú de opciones.\n"
                + "Una vez que las hayas creado, podrás pasar al menú principal donde podrás realizar las consultas que desees.";
        
        JOptionPane.showMessageDialog(null, mensaje);
        
    }
	
	//OPCION DE CREACION DE TABLAS O SALIR DEL PROGRAMA
	private static int opcionesMenuProgramaTablasNoCreadas() {
		
        String[] opciones = { "Crear tablas", "Salir" };
        
        int opcion = JOptionPane.showOptionDialog(null, "Selecciona qué deseas hacer en la base de datos", "MENÚ PRINCIPAL",
        		JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "");
        
        return opcion;
        
    }
	
	//BOTON DE CONFIGURACION
	private static int opcionesConfiguracion() {
		
		String[] opcionesConfiguracion = { "Ver ruta de la Base de Datos y log", "Salir" };
		
		int opcion =  JOptionPane.showOptionDialog(null, "Selecciona que deseas hacer", "MENU CONFIGURACIÓN", 
				JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opcionesConfiguracion, "");
	
		return opcion;
		
	}
	
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

