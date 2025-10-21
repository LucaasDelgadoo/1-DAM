package practica18;

import java.sql.*;
import javax.swing.JOptionPane;

public class BasesDeDatosApp {

    private static String NOMBRE_BASE_DE_DATOS = "jdbc:sqlite:C:\\Users\\LUCAS\\Escritorio\\JAVA\\SQLiteDatabaseBrowserPortable\\practica18.db";
    private static boolean VALOR_POR_DEFECTO_ACTIVO = true;

    public static void main(String[] args) {
        int opcionMenuPrincipalTablasCreadas;
        int opcionesMenuProgramaTablasNoCreadas;
        int opcionesMenuTablaParaInsercion;
        int opcionesMenuMostrarRegistros;

        mensajeBienvenidaPrograma();

        opcionesMenuProgramaTablasNoCreadas = opcionesMenuProgramaTablasNoCreadas();

        if (opcionesMenuProgramaTablasNoCreadas == 0) {

            mensajeCreacionTablas();
            crearTablaCategorias();
            crearTablaProvincias();
            crearTablaProductos();
            crearTablaPoblaciones();
            crearTablaClientes();

            do {
                opcionMenuPrincipalTablasCreadas = opcionesMenuProgramaTablasCreadas();

                switch (opcionMenuPrincipalTablasCreadas) {
                    case 0:
                        insercionDeClientesAleatorios();
                        insercionDePoblacionesAleatorios();
                        insercionDeProvinciasAleatorios();
                        insercionDeProductosAleatorios();
                        insercionDeCategoriasAleatorios();
                        break;

                    case 1:
                        opcionesMenuTablaParaInsercion = opcionesMenuTablaParaInsercion();
                        do {
                            switch (opcionesMenuTablaParaInsercion) {
                                case 0:
                                    insertarNuevoCliente();
                                    break;
                                case 1:
                                    insertarNuevoPoblacion();
                                    break;
                                case 2:
                                    insertarNuevoProvincia();
                                    break;
                                case 3:
                                    insertarNuevoProducto();
                                    break;
                                case 4:
                                    insertarNuevoCategoria();
                                    break;
                                case 5:
                                    // SALIR de este submenú
                                    break;
                            }
                            opcionesMenuTablaParaInsercion = opcionesMenuTablaParaInsercion();
                        } while (opcionesMenuTablaParaInsercion != 5);
                        break;

                    case 2:
                        opcionesMenuMostrarRegistros = opcionesMenuMostrarRegistros();
                        do {
                            switch (opcionesMenuMostrarRegistros) {
                                case 0:
                                    mostrarRegistrosClientes();
                                    break;
                                case 1:
                                    mostrarRegistrosPoblaciones();
                                    break;
                                case 2:
                                    mostrarRegistrosProvincias();
                                    break;
                                case 3:
                                    mostrarRegistrosProductos();
                                    break;
                                case 4:
                                    mostrarRegistrosCategorias();
                                    break;
                                case 5:
                                    // SALIR de este submenú
                                    break;
                            }
                            opcionesMenuMostrarRegistros = opcionesMenuMostrarRegistros();
                        } while (opcionesMenuMostrarRegistros != 5);
                        break;

                    case 3:
                        eliminarClientePorID();
                        break;

                    case 4:
                        actualizarPreciosAlLimiteEstablecido();
                        break;

                    case 5:
                        // SALIR del programa
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                }
            } while (opcionMenuPrincipalTablasCreadas != 5);

        } else if (opcionesMenuProgramaTablasNoCreadas == 1) {
            JOptionPane.showMessageDialog(null, "HAS SALIDO DEL PROGRAMA");
        }
    }

    // Métodos para la creación de tablas
    private static void crearTablaCategorias() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaCategorias = "CREATE TABLE IF NOT EXISTS Categorias7 ("
                    + "CategoriaID INTEGER PRIMARY KEY, "
                    + "NombreCategoria VARCHAR(100) NOT NULL, "
                    + "DescripcionCategoria TEXT);";

            miStatement.executeUpdate(crearTablaCategorias);
            JOptionPane.showMessageDialog(null, "Tabla Categorias creada correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Categorias: " + e.getMessage());
        }
    }

    private static void crearTablaProvincias() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaProvincias = "CREATE TABLE IF NOT EXISTS Provincias7 ("
                    + "ProvinciaID INTEGER PRIMARY KEY NOT NULL UNIQUE, "
                    + "NombreProvincia TEXT NOT NULL);";

            miStatement.executeUpdate(crearTablaProvincias);
            JOptionPane.showMessageDialog(null, "Tabla Provincias creada correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Provincias: " + e.getMessage());
        }
    }

    private static void crearTablaProductos() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaProductos = "CREATE TABLE IF NOT EXISTS Productos7 ("
                    + "ProductoID INTEGER PRIMARY KEY NOT NULL, "
                    + "NombreProducto TEXT NOT NULL, "
                    + "DescripcionProducto TEXT, "
                    + "PrecioUnitario REAL NOT NULL, "
                    + "StockDisponible INTEGER NOT NULL DEFAULT 0, "
                    + "CategoriaID INTEGER NOT NULL, "
                    + "FechaCreacion TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                    + "FOREIGN KEY (CategoriaID) REFERENCES Categorias7(CategoriaID));";

            miStatement.executeUpdate(crearTablaProductos);
            JOptionPane.showMessageDialog(null, "Tabla Productos creada correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Productos: " + e.getMessage());
        }
    }

    private static void crearTablaPoblaciones() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaPoblaciones = "CREATE TABLE IF NOT EXISTS Poblaciones7 ("
                    + "PoblacionID INTEGER PRIMARY KEY NOT NULL, "
                    + "NombrePoblacion TEXT NOT NULL, "
                    + "ProvinciaID INTEGER NOT NULL, "
                    + "FOREIGN KEY (ProvinciaID) REFERENCES Provincias7(ProvinciaID));";

            miStatement.executeUpdate(crearTablaPoblaciones);
            JOptionPane.showMessageDialog(null, "Tabla Poblaciones creada correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Poblaciones: " + e.getMessage());
        }
    }

    private static void crearTablaClientes() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String crearTablaClientes = "CREATE TABLE IF NOT EXISTS Clientes7 ("
                    + "ClienteID INTEGER PRIMARY KEY NOT NULL, "
                    + "Nombre TEXT NOT NULL, "
                    + "Apellido TEXT NOT NULL, "
                    + "Email TEXT NOT NULL UNIQUE, "
                    + "Telefono TEXT, "
                    + "Direccion TEXT, "
                    + "PoblacionID INTEGER NOT NULL, "
                    + "FechaNacimiento TEXT, "
                    + "Activo INTEGER NOT NULL DEFAULT 1, "
                    + "FechaCreacion TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                    + "FOREIGN KEY (PoblacionID) REFERENCES Poblaciones7(PoblacionID));";

            miStatement.executeUpdate(crearTablaClientes);
            JOptionPane.showMessageDialog(null, "Tabla Clientes creada correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en Clientes: " + e.getMessage());
        }
    }

    // Métodos de inserción de datos aleatorios
    private static void insercionDeClientesAleatorios() {
        String sql = "INSERT INTO Clientes7 (ClienteID, Nombre, Apellido, Email, Telefono, Direccion, PoblacionID, FechaNacimiento, Activo, FechaCreacion) VALUES "
                + "(1, 'Carlos', 'Pérez', 'carlos.perez@email.com', "
                + "'612345678', 'Calle Sol, 12', 1, '1985-07-12', 1, CURRENT_TIMESTAMP),"
                + "(2, 'Ana', 'Rodríguez', 'ana.rodriguez@email.com', "
                + "'612345679', 'Avenida Luna, 5', 2, '1992-03-25', 1, CURRENT_TIMESTAMP),"
                + "(3, 'David', 'García', 'david.garcia@email.com', "
                + "'613456789', 'Plaza Mayor, 3', 3, '1988-11-30', 0, CURRENT_TIMESTAMP),"
                + "(4, 'Lucía', 'Fernández', 'lucia.fernandez@email.com', "
                + "'614567890', 'Calle Estrella, 21', 4, '1995-08-19', 1, CURRENT_TIMESTAMP),"
                + "(5, 'Javier', 'López', 'javier.lopez@email.com', "
                + "'615678901', 'Avenida Marte, 7', 5, '1980-06-05', 1, CURRENT_TIMESTAMP),"
                + "(6, 'María', 'Sánchez', 'maria.sanchez@email.com', "
                + "'616789012', 'Calle Saturno, 9', 6, '1993-01-14', 0, CURRENT_TIMESTAMP),"
                + "(7, 'Pedro', 'Martín', 'pedro.martin@email.com', "
                + "'617890123', 'Calle Venus, 4', 7, '1990-04-22', 1, CURRENT_TIMESTAMP),"
                + "(8, 'Laura', 'Gómez', 'laura.gomez@email.com', "
                + "'618901234', 'Avenida Júpiter, 2', 8, '1997-12-11', 1, CURRENT_TIMESTAMP),"
                + "(9, 'Sergio', 'Ramírez', 'sergio.ramirez@email.com', "
                + "'619012345', 'Calle Neptuno, 15', 9, '1986-09-17', 0, CURRENT_TIMESTAMP),"
                + "(10, 'Carolina', 'Torres', 'carolina.torres@email.com', "
                + "'620123456', 'Paseo Urano, 8', 10, '1999-05-03', 1, CURRENT_TIMESTAMP);";

        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
            miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserción aleatoria de Clientes completada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en inserción de Clientes: " + e.getMessage());
        }
    }

    private static void insercionDePoblacionesAleatorios() {
        String sql = "INSERT INTO Poblaciones7 (PoblacionID, NombrePoblacion, ProvinciaID) VALUES "
                + "(1, 'Villa Sol', 101),"
                + "(2, 'Puerto Luna', 102),"
                + "(3, 'Monteverde', 103),"
                + "(4, 'Río Azul', 104),"
                + "(5, 'Valle Esmeralda', 105),"
                + "(6, 'Costa Dorada', 106),"
                + "(7, 'Sierra Brava', 107),"
                + "(8, 'Laguna Serena', 108),"
                + "(9, 'Campo Alegre', 109),"
                + "(10, 'Mirador Alto', 110);";

        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
            miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserción aleatoria de Poblaciones completada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en inserción de Poblaciones: " + e.getMessage());
        }
    }

    private static void insercionDeProvinciasAleatorios() {
        String sql = "INSERT INTO Provincias7 (ProvinciaID, NombreProvincia) VALUES "
                + "(101, 'Madrid'),"
                + "(102, 'Barcelona'),"
                + "(103, 'Valencia'),"
                + "(104, 'Sevilla'),"
                + "(105, 'Zaragoza'),"
                + "(106, 'Málaga'),"
                + "(107, 'Murcia'),"
                + "(108, 'Bilbao'),"
                + "(109, 'Granada'),"
                + "(110, 'Córdoba');";

        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
            miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserción aleatoria de Provincias completada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en inserción de Provincias: " + e.getMessage());
        }
    }

    private static void insercionDeProductosAleatorios() {
        String sql = "INSERT INTO Productos7 (ProductoID, NombreProducto, DescripcionProducto, PrecioUnitario, StockDisponible, CategoriaID, FechaCreacion) VALUES "
                + "(1, 'Smartphone X', 'Teléfono inteligente de última generación', 799.99, 25, 101, CURRENT_TIMESTAMP),"
                + "(2, 'Laptop Pro', 'Portátil potente para trabajo y gaming', 1299.99, 15, 102, CURRENT_TIMESTAMP),"
                + "(3, 'Auriculares Bass', 'Auriculares inalámbricos con sonido envolvente', 149.99, 50, 103, CURRENT_TIMESTAMP),"
                + "(4, 'Smartwatch Fit', 'Reloj inteligente con monitoreo de actividad', 199.99, 30, 104, CURRENT_TIMESTAMP),"
                + "(5, 'Cámara HD', 'Cámara digital de alta resolución', 599.99, 10, 105, CURRENT_TIMESTAMP),"
                + "(6, 'Teclado Mecánico', 'Teclado mecánico retroiluminado', 89.99, 40, 106, CURRENT_TIMESTAMP),"
                + "(7, 'Silla Ergonomía', 'Silla de oficina con soporte lumbar', 249.99, 20, 107, CURRENT_TIMESTAMP),"
                + "(8, 'Bicicleta Urbana', 'Bicicleta ligera para ciudad', 499.99, 12, 108, CURRENT_TIMESTAMP),"
                + "(9, 'Altavoz Bluetooth', 'Altavoz portátil con gran potencia', 99.99, 35, 109, CURRENT_TIMESTAMP),"
                + "(10, 'Consola Gamer', 'Consola de videojuegos con gráficos avanzados', 499.99, 18, 110, CURRENT_TIMESTAMP);";

        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
            miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserción aleatoria de Productos completada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en inserción de Productos: " + e.getMessage());
        }
    }

    private static void insercionDeCategoriasAleatorios() {
        String sql = "INSERT INTO Categorias7 (CategoriaID, NombreCategoria, DescripcionCategoria) VALUES "
                + "(101, 'Electrónica', 'Dispositivos y accesorios tecnológicos'),"
                + "(102, 'Informática', 'Equipos y periféricos de computación'),"
                + "(103, 'Audio y sonido', 'Auriculares, altavoces y equipos de sonido'),"
                + "(104, 'Relojería', 'Relojes inteligentes y convencionales'),"
                + "(105, 'Fotografía', 'Cámaras y accesorios fotográficos'),"
                + "(106, 'Accesorios PC', 'Teclados, ratones y complementos'),"
                + "(107, 'Mobiliario', 'Sillas y muebles para hogar y oficina'),"
                + "(108, 'Deportes', 'Bicicletas y equipamiento deportivo'),"
                + "(109, 'Hogar', 'Artículos para casa y decoración'),"
                + "(110, 'Videojuegos', 'Consolas y accesorios gaming');";

        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {
            miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserción aleatoria de Categorías completada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en inserción de Categorías: " + e.getMessage());
        }
    }

    // Métodos para inserción desde consola (datos proporcionados por el usuario)
    private static void insertarNuevoCliente() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String clienteIDString = JOptionPane.showInputDialog("Introduce el ID del cliente nuevo:");
            int clienteIDInt = Integer.parseInt(clienteIDString);
            String nombre = JOptionPane.showInputDialog("Introduce el nombre (SOLO NOMBRE) del cliente nuevo:");
            String apellido = JOptionPane.showInputDialog("Introduce el apellido (PRIMER APELLIDO) del cliente nuevo:");
            String email = JOptionPane.showInputDialog("Introduce el email del cliente nuevo:");
            String telefono = JOptionPane.showInputDialog("Introduce el teléfono (SIN EL +34) del cliente nuevo:");
            String direccion = JOptionPane.showInputDialog("Introduce la dirección (ej. Calle Rosaleda, 12) del cliente nuevo:");
            String poblacionIDString = JOptionPane.showInputDialog("Introduce el ID de la población del cliente nuevo:");
            int poblacionIDInt = Integer.parseInt(poblacionIDString);
            String fechaNacimiento = JOptionPane.showInputDialog("Introduce la fecha de nacimiento (dd-mm-yyyy) del cliente nuevo:");
            int activo = VALOR_POR_DEFECTO_ACTIVO ? 1 : 0;

            String sql = "INSERT INTO Clientes7 (ClienteID, Nombre, Apellido, Email, Telefono, Direccion, PoblacionID, FechaNacimiento, Activo) VALUES ("
                    + clienteIDInt + ", '" + nombre + "', '" + apellido + "', '" + email + "', '" + telefono + "', '" + direccion + "', "
                    + poblacionIDInt + ", '" + fechaNacimiento + "', " + activo + ")";
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Cliente: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
    }

    private static void insertarNuevoPoblacion() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String poblacionIDString = JOptionPane.showInputDialog("Introduce el ID de la población nueva:");
            int poblacionIDInt = Integer.parseInt(poblacionIDString);
            String nombrePoblacion = JOptionPane.showInputDialog("Introduce el nombre de la población nueva:");
            String provinciaIDString = JOptionPane.showInputDialog("Introduce el ID de la provincia donde se ubica la población:");
            int provinciaIDInt = Integer.parseInt(provinciaIDString);

            String sql = "INSERT INTO Poblaciones7 (PoblacionID, NombrePoblacion, ProvinciaID) VALUES ("
                    + poblacionIDInt + ", '" + nombrePoblacion + "', " + provinciaIDInt + ")";
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Población: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
    }

    private static void insertarNuevoProvincia() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String provinciaIDString = JOptionPane.showInputDialog("Introduce el ID de la provincia nueva:");
            int provinciaIDInt = Integer.parseInt(provinciaIDString);
            String nombreProvincia = JOptionPane.showInputDialog("Introduce el nombre de la provincia nueva:");

            String sql = "INSERT INTO Provincias7 (ProvinciaID, NombreProvincia) VALUES ("
                    + provinciaIDInt + ", '" + nombreProvincia + "')";
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Provincia: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
    }

    private static void insertarNuevoProducto() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String productoIDString = JOptionPane.showInputDialog("Introduce el ID del producto nuevo:");
            int productoIDInt = Integer.parseInt(productoIDString);
            String nombreProducto = JOptionPane.showInputDialog("Introduce el nombre del producto nuevo:");
            String descripcionProducto = JOptionPane.showInputDialog("Introduce una breve descripción del producto nuevo:");
            String precioUnitarioString = JOptionPane.showInputDialog("Introduce el precio/unidad (CON DECIMALES) del producto nuevo:");
            double precioUnitarioDouble = Double.parseDouble(precioUnitarioString);
            String stockDisponibleString = JOptionPane.showInputDialog("Introduce el stock disponible del producto nuevo:");
            int stockDisponibleInt = Integer.parseInt(stockDisponibleString);
            String categoriaIDString = JOptionPane.showInputDialog("Introduce el ID de la categoría a la que pertenece el producto nuevo:");
            int categoriaIDInt = Integer.parseInt(categoriaIDString);
            String fechaCreacion = JOptionPane.showInputDialog("Introduce la fecha de creación (dd-mm-yyyy) del producto nuevo:");

            String sql = "INSERT INTO Productos7 (ProductoID, NombreProducto, DescripcionProducto, PrecioUnitario, StockDisponible, CategoriaID, FechaCreacion) VALUES ("
                    + productoIDInt + ", '" + nombreProducto + "', '" + descripcionProducto + "', "
                    + precioUnitarioDouble + ", " + stockDisponibleInt + ", " + categoriaIDInt + ", '" + fechaCreacion + "')";
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Producto: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
    }

    private static void insertarNuevoCategoria() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String categoriaIDString = JOptionPane.showInputDialog("Introduce el ID de la categoría nueva:");
            int categoriaIDInt = Integer.parseInt(categoriaIDString);
            String nombreCategoria = JOptionPane.showInputDialog("Introduce el nombre de la categoría nueva:");
            String descripcionCategoria = JOptionPane.showInputDialog("Introduce una breve descripción de la categoría nueva:");

            String sql = "INSERT INTO Categorias7 (CategoriaID, NombreCategoria, DescripcionCategoria) VALUES ("
                    + categoriaIDInt + ", '" + nombreCategoria + "', '" + descripcionCategoria + "')";
            int filasAfectadas = miStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registros insertados: " + filasAfectadas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION al insertar Categoría: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato numérico: " + e.getMessage());
        }
    }

    // Métodos para mostrar registros
    private static void mostrarRegistrosClientes() {
        String sql = "SELECT Clientes7.*, Poblaciones7.ProvinciaID FROM Clientes7 " +
                     "JOIN Poblaciones7 ON Clientes7.PoblacionID = Poblaciones7.PoblacionID";
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement();
             ResultSet rs = miStatement.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ClienteID: " + rs.getInt("ClienteID"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Apellido: " + rs.getString("Apellido"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("Teléfono: " + rs.getString("Telefono"));
                System.out.println("Dirección: " + rs.getString("Direccion"));
                System.out.println("PoblacionID: " + rs.getInt("PoblacionID"));
                System.out.println("ProvinciaID: " + rs.getInt("ProvinciaID"));
                System.out.println("Fecha Nacimiento: " + rs.getString("FechaNacimiento"));
                System.out.println("Activo: " + rs.getInt("Activo"));
                System.out.println("Fecha Creación: " + rs.getString("FechaCreacion"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error en mostrarRegistrosClientes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarRegistrosPoblaciones() {
        String sql = "SELECT Poblaciones7.*, Provincias7.NombreProvincia FROM Poblaciones7 " +
                     "JOIN Provincias7 ON Poblaciones7.ProvinciaID = Provincias7.ProvinciaID";
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement();
             ResultSet rs = miStatement.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("PoblacionID: " + rs.getInt("PoblacionID"));
                System.out.println("Nombre Poblacion: " + rs.getString("NombrePoblacion"));
                System.out.println("ProvinciaID: " + rs.getInt("ProvinciaID"));
                System.out.println("Nombre Provincia: " + rs.getString("NombreProvincia"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error en mostrarRegistrosPoblaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarRegistrosProvincias() {
        String sql = "SELECT * FROM Provincias7";
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement();
             ResultSet rs = miStatement.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ProvinciaID: " + rs.getInt("ProvinciaID"));
                System.out.println("Nombre Provincia: " + rs.getString("NombreProvincia"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error en mostrarRegistrosProvincias: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarRegistrosProductos() {
        String sql = "SELECT Productos7.*, Categorias7.NombreCategoria FROM Productos7 " +
                     "JOIN Categorias7 ON Productos7.CategoriaID = Categorias7.CategoriaID";
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement();
             ResultSet rs = miStatement.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ProductoID: " + rs.getInt("ProductoID"));
                System.out.println("Nombre Producto: " + rs.getString("NombreProducto"));
                System.out.println("Descripción: " + rs.getString("DescripcionProducto"));
                System.out.println("Precio Unitario: " + rs.getDouble("PrecioUnitario"));
                System.out.println("Stock Disponible: " + rs.getInt("StockDisponible"));
                System.out.println("CategoriaID: " + rs.getInt("CategoriaID"));
                System.out.println("Nombre Categoria: " + rs.getString("NombreCategoria"));
                System.out.println("Fecha Creación: " + rs.getString("FechaCreacion"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error en mostrarRegistrosProductos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarRegistrosCategorias() {
        String sql = "SELECT * FROM Categorias7";
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement();
             ResultSet rs = miStatement.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("CategoriaID: " + rs.getInt("CategoriaID"));
                System.out.println("Nombre Categoria: " + rs.getString("NombreCategoria"));
                System.out.println("Descripción: " + rs.getString("DescripcionCategoria"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error en mostrarRegistrosCategorias: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para eliminar un cliente por ID
    private static void eliminarClientePorID() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS)) {
            miConexion.setAutoCommit(false);
            String idClienteStr = JOptionPane.showInputDialog("Introduce el ID del cliente que deseas eliminar:");
            int idCliente = Integer.parseInt(idClienteStr);
            String sql = "DELETE FROM Clientes7 WHERE ClienteID = " + idCliente;
            try (PreparedStatement ps = miConexion.prepareStatement(sql)) {
                int filasAfectadas = ps.executeUpdate();
                miConexion.commit();
                JOptionPane.showMessageDialog(null, "Clientes eliminados: " + filasAfectadas);
            }
        } catch (SQLException e) {
            System.out.println("Error en eliminarClientePorID: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto: " + e.getMessage());
        }
    }

    // Método para actualizar precios de productos por debajo de un límite
    private static void actualizarPreciosAlLimiteEstablecido() {
        try (Connection miConexion = DriverManager.getConnection(NOMBRE_BASE_DE_DATOS);
             Statement miStatement = miConexion.createStatement()) {

            String precioLimiteString = JOptionPane.showInputDialog("Introduce el precio límite que deseas marcar:");
            double precioLimite = Double.parseDouble(precioLimiteString);

            String actualizarPrecios = "UPDATE Productos7 SET PrecioUnitario = PrecioUnitario * 1.10 WHERE PrecioUnitario < " + precioLimite;
            int filasAfectadas = miStatement.executeUpdate(actualizarPrecios);
            JOptionPane.showMessageDialog(null, "Registros actualizados: " + filasAfectadas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION en actualizar precios: " + e.getMessage());
        }
    }

    // Mensajes y menús
    private static void mensajeBienvenidaPrograma() {
        String mensaje = "Bienvenido/a a [DB Practica18]! 🚀\n\n"
                + "Inicializando conexión con la base de datos... 🔄\n\n"
                + "✅ Conexión establecida correctamente.\n"
                + "🗄️ Base de datos lista para operar.\n\n"
                + "¡Que tengas una excelente experiencia!\n"
                + "Para poder utilizar el programa, deberás crear las tablas para posteriormente realizar consultas y almacenar datos.";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void mensajeCreacionTablas() {
        String mensaje = "Para que tu base de datos funcione correctamente, debes crear todas las tablas que aparecen en el menú de opciones.\n"
                + "Una vez que las hayas creado, podrás pasar al menú principal donde podrás realizar las consultas que desees.";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static int opcionesMenuProgramaTablasNoCreadas() {
        String[] opciones = { "Crear tablas", "Salir" };
        int opcion = JOptionPane.showOptionDialog(null,
                "Selecciona qué deseas hacer en la base de datos",
                "MENÚ PRINCIPAL",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                opciones,
                opciones[0]);
        return opcion;
    }

    private static int opcionesMenuProgramaTablasCreadas() {
        String[] opciones = {
            "Rellenar datos aleatorios",
            "Insertar un nuevo elemento en una tabla",
            "Mostrar registros de una tabla",
            "Eliminar un elemento de una tabla",
            "Actualizar precios de productos",
            "Salir"
        };
        int opcion = JOptionPane.showOptionDialog(null,
                "Selecciona qué deseas hacer en la base de datos",
                "MENÚ PRINCIPAL",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                opciones,
                opciones[0]);
        return opcion;
    }

    private static int opcionesMenuTablaParaInsercion() {
        String[] opciones = { "Clientes", "Población", "Provincias", "Productos", "Categorías", "Salir" };
        int opcion = JOptionPane.showOptionDialog(null,
                "Selecciona la tabla en la que deseas insertar datos",
                "Inserción",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                opciones,
                opciones[0]);
        return opcion;
    }

    private static int opcionesMenuMostrarRegistros() {
        String[] opciones = { "Clientes", "Población", "Provincias", "Productos", "Categorías", "Salir" };
        int opcion = JOptionPane.showOptionDialog(null,
                "Selecciona la tabla de la cual deseas mostrar registros",
                "Mostrar registros",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                opciones,
                opciones[0]);
        return opcion;
    }
}

