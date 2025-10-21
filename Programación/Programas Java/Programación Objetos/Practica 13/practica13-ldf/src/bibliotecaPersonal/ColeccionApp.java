package bibliotecaPersonal;

import javax.swing.JOptionPane;

public class ColeccionApp {

    public static void main(String[] args) {
        
    	int opcionMenuPrincipal;
    	int opcionMenuDarDeAlta;
        int cantidadColeccionablesRegistrados;

        mensajeInicialBiblioteca();
        
        String nombrePropietario = nombrePropietario();
        Biblioteca biblioteca = new Biblioteca(nombrePropietario);
       
        do {
            
        	opcionMenuPrincipal = opcionesMenuBiblioteca(nombrePropietario);
            
            switch (opcionMenuPrincipal) {
                
            case 0:
            
            	do {
                
            		opcionMenuDarDeAlta = opcionesMenuDarDeAlta();
                        
                        switch (opcionMenuDarDeAlta) {
                    
                        case 0:
                        
                        	Libro libro = crearLibro();
                            
                        	mostrarInfoJOptionPane(libro);
                            
                        	biblioteca.añadirColeccionable(libro);
                            
                        	break;
                            
                        case 1:
                        
                        	SerieTv serie = crearSerieTv();
                            
                        	mostrarInfoJOptionPane(serie);
                            
                        	biblioteca.añadirColeccionable(serie);
                            
                        	break;
                            
                        case 2:
                        
                        	Videojuego videojuego = crearVideojuego();
                            
                        	mostrarInfoJOptionPane(videojuego);
                            
                        	biblioteca.añadirColeccionable(videojuego);
                            
                        	break;
                            
                        case 3:
                        
                        	// Salir del menú
                            
                        	break;
                        }
                        
                    } while (opcionMenuDarDeAlta != 3);
                    
                    break;
                    
                case 1:
                	
                    do {
                    	
                        cantidadColeccionablesRegistrados = seleccionVerNumeroColeccionables();
                        
                        switch (cantidadColeccionablesRegistrados) {
                        
                            case 0:
                                
                                biblioteca.contarColeccionables();
                                
                                break;
                        
                            case 1:
                            
                            	// Salida del menú
                                
                            	break;
                        
                        }
                    
                    } while (cantidadColeccionablesRegistrados != 1);
                    
                    break;
                
                case 2:
                
                	// Salida de la aplicación
                    
                	break;
            
            }
        
        } while (opcionMenuPrincipal != 2);
    
    }

    private static void mostrarInfoJOptionPane(Coleccionable coleccionable) {
        JOptionPane.showMessageDialog(null, coleccionable.mostrar());
    }

    private static Libro crearLibro() {
        JOptionPane.showMessageDialog(null, "Has seleccionado la opción de dar de alta un Libro.\nCompleta las siguientes ventanas para registrar el libro.");

        String tituloLibro = JOptionPane.showInputDialog(null, "Introduce el nombre del libro");
        String autorLibro = JOptionPane.showInputDialog(null, "Introduce el autor del libro");
        String editorialLibro = JOptionPane.showInputDialog(null, "Introduce la editorial del libro");
        String paginasLibro = JOptionPane.showInputDialog(null, "Introduce el número de páginas del libro");
        int paginasLibroInt = Integer.parseInt(paginasLibro);

        return new Libro(tituloLibro, autorLibro, editorialLibro, paginasLibroInt);
    }

    private static SerieTv crearSerieTv() {
        JOptionPane.showMessageDialog(null, "Has seleccionado la opción de dar de alta una Serie de TV.\nCompleta las siguientes ventanas para registrar la serie.");

        String nombreSerie = JOptionPane.showInputDialog(null, "Introduce el nombre de la serie");
        String numeroTemporadas = JOptionPane.showInputDialog(null, "Introduce el número de temporadas");
        int numeroTemporadasInt = Integer.parseInt(numeroTemporadas);
        String numeroCapitulos = JOptionPane.showInputDialog(null, "Introduce el número de capítulos por temporada");
        int numeroCapitulosInt = Integer.parseInt(numeroCapitulos);

        return new SerieTv(nombreSerie, numeroTemporadasInt, numeroCapitulosInt);
    }

    private static Videojuego crearVideojuego() {
        JOptionPane.showMessageDialog(null, "Has seleccionado la opción de dar de alta un Videojuego.\nCompleta las siguientes ventanas para registrar el videojuego.");

        String nombreVideojuego = JOptionPane.showInputDialog(null, "Introduce el nombre del videojuego");

        String[] plataformas = { "PC", "Mobile", "Playstation", "XBOX", "Switch", "Other" };
        int plataformaVideojuego = JOptionPane.showOptionDialog(null, "Selecciona la plataforma del videojuego", "Selecciona tu plataforma",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, plataformas, "");

        String plataformaVideojuegoString = plataformas[plataformaVideojuego];

        return new Videojuego(nombreVideojuego, plataformaVideojuegoString);
    }

    public static void mensajeInicialBiblioteca() {
        JOptionPane.showMessageDialog(null, "Bienvenido a tu biblioteca personal.\n"
                + "Aquí podrás dar de alta libros, series de TV y videojuegos, ¡tantos como quieras!\n\n"
                + "Para ello deberás introducir algunos datos referidos a los coleccionables que deseas dar de alta.\n"
                + "En las siguientes ventanas podrás aportar la información y posteriormente consultar en nuestro menú de la biblioteca "
                + "los coleccionables registrados con todos sus datos.");
    }

    public static int opcionesMenuBiblioteca(String nombrePropietario) {
        String[] opcionesMenu = { "Dar de alta un coleccionable", "Cantidad de coleccionables dados de alta", "Salir" };

        return JOptionPane.showOptionDialog(null, "Selecciona qué opción deseas hacer " + nombrePropietario, "Menú de la biblioteca",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, "");
    }

    public static int opcionesMenuDarDeAlta() {
        String[] opcionesMenuAlta = { "Libro", "Serie de TV", "Videojuego", "Salir" };

        return JOptionPane.showOptionDialog(null, "Selecciona qué tipo de coleccionable deseas dar de alta", "Menú Dar de Alta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesMenuAlta, "");
    }

    public static String nombrePropietario() {
        return JOptionPane.showInputDialog(null, "Introduce tu nombre para crear tu biblioteca personal");
    }

    public static int seleccionVerNumeroColeccionables() {
        String[] opciones = { "Ver cantidad de coleccionables", "Salir" };

        return JOptionPane.showOptionDialog(null, "Selecciona qué deseas hacer", "Menú de Cantidad de Coleccionables",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "");
    }
}