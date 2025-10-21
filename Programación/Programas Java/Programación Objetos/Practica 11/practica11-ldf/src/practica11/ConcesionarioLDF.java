package practica11;

import javax.swing.JOptionPane;

public class ConcesionarioLDF {

    public static void main(String[] args) {
        
        Vehiculo[] vehiculos = new Vehiculo[100];
        Coche[] coches = new Coche[100];
        Furgoneta[] furgonetas = new Furgoneta[100];
        int numVehiculos = 0;
        int numCoches = 0;
        int numFurgonetas = 0;
        int opcionUsuarioConcesionario;
        
        JOptionPane.showMessageDialog(null, textoInicio());
        
        JOptionPane.showMessageDialog(null, "Vehiculo");
        Vehiculo vehiculoPorDefecto = new Vehiculo();
        vehiculos[numVehiculos++] = vehiculoPorDefecto;
        JOptionPane.showMessageDialog(null, vehiculoPorDefecto.getInfo());
        
        JOptionPane.showMessageDialog(null, "Coche");
        Coche cochePorDefecto = new Coche();
        vehiculos[numVehiculos++] = cochePorDefecto;
        JOptionPane.showMessageDialog(null, cochePorDefecto.getInfo());
        
        JOptionPane.showMessageDialog(null, "Furgoneta");
        Furgoneta furgonetaPorDefecto = new Furgoneta();
        vehiculos[numVehiculos++] = furgonetaPorDefecto;
        JOptionPane.showMessageDialog(null, furgonetaPorDefecto.getInfo());
        

        do {
            opcionUsuarioConcesionario = opcionCrearSalir();
            
            switch (opcionUsuarioConcesionario) {
            
                case 0: 
                
                    int opcionUsuarioCuandoCrea;
                                    
                    do {
                                        
                        opcionUsuarioCuandoCrea = opcionSeleccionarTipoCreacion();
                                        
                        switch (opcionUsuarioCuandoCrea) {
                                        
                            case 0:
                                Coche coche = crearCoche();
                                coches[numCoches++] = coche;
                                vehiculos[numVehiculos++] = coche;
                                JOptionPane.showMessageDialog(null, coche.getInfo());
                                JOptionPane.showMessageDialog(null, coche.toString());
                                break;
                                 
                            case 1:
                                Furgoneta furgoneta = crearFurgoneta();
                                furgonetas[numFurgonetas++] = furgoneta;
                                vehiculos[numVehiculos++] = furgoneta;
                                JOptionPane.showMessageDialog(null, furgoneta.getInfo());
                                JOptionPane.showMessageDialog(null, furgoneta.toString());
                                break;
                                 
                            case 2:
                                Vehiculo vehiculo = crearVehiculo();
                                vehiculos[numVehiculos++] = vehiculo;
                                JOptionPane.showMessageDialog(null, vehiculo.getInfo());
                                JOptionPane.showMessageDialog(null, vehiculo.toString());
                                break;
                                        
                            case 3:
                                // Volver atrás
                                break;
                        }
                                        
                    } while (opcionUsuarioCuandoCrea != 3);
                                    
                    break;
                
                case 1:
                    mostrarResumen(vehiculos, coches, furgonetas, numVehiculos, numCoches, numFurgonetas);
                    break;
                                        
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida, seleccione una opcion");
                    break;
            }
            
        } while (opcionUsuarioConcesionario != 1);
        
    }
    
    private static String textoInicio() {
        String textoInicio = "Bienvenido/a a el concesionario de Lucas Delgado, estas en la practica 11. \n \n"
                + "En nuestro concesionario podras seleccionar el vehiculo que usted quiera. \n"
                + "Para ello debera de saber que tenemos varias opciones de creacion de vehiculos. \n"
                + "Hay dos tipos de vehiculos que puede adquirir, y estos tendran un valor dependiendo de lo que usted \n"
                + "seleccione en nuestro concesionario.\n \n"
                + "Primero le enseñaremos los 3 tipos de productos que tenemos en el concesionario \n"
                + "con los valores que son por defecto";
                
        return textoInicio;
    }
    
    private static Furgoneta crearFurgoneta() {
        
        JOptionPane.showMessageDialog(null, "Has seleccionado la opcion de crear una Furgoneta \n"
                  + "Ahora le daras los valores que desees en la proxima ventana");
        
        String precioFurgoneta = JOptionPane.showInputDialog("Introduce el precio de la furgoneta");
        int precioFurgonetaInt = Integer.parseInt(precioFurgoneta);
        String colorFurgoneta = JOptionPane.showInputDialog("Introduce el color de la furgoneta");
        String gamaFurgoneta = JOptionPane.showInputDialog("Introduce la gama de la furgoneta");
        String pesoFurgoneta = JOptionPane.showInputDialog("Introduce el peso de la furgoneta");
        int pesoFurgonetaInt = Integer.parseInt(pesoFurgoneta);
        String cargaFurgoneta = JOptionPane.showInputDialog("Introduce la carga de la furgoneta");
        double cargaFurgonetaDouble = Double.parseDouble(cargaFurgoneta);
        int opcionElectrica = opcionElectricaFurgoneta();
            
        return new Furgoneta(precioFurgonetaInt, colorFurgoneta, gamaFurgoneta, pesoFurgonetaInt, cargaFurgonetaDouble, opcionElectrica);
        
    }
    
    private static Coche crearCoche() {
        
        JOptionPane.showMessageDialog(null, "Has seleccionado la opcion de crear un Coche \n"
                  + "Ahora le daras los valores que desees en la proxima ventana");

        String precioCoche = JOptionPane.showInputDialog("Introduce el precio del coche");
        int precioCocheInt = Integer.parseInt(precioCoche);
        String colorCoche = JOptionPane.showInputDialog("Introduce el color del coche");
        String gamaCoche = JOptionPane.showInputDialog("Introduce la gama del coche");
        String pesoCoche = JOptionPane.showInputDialog("Introduce el peso del coche");
        int pesoCocheInt = Integer.parseInt(pesoCoche);
        String potenciaCoche = JOptionPane.showInputDialog("Introduce la potencia del coche");
        int potenciaCocheInt = Integer.parseInt(potenciaCoche);

        return new Coche(precioCocheInt, colorCoche, gamaCoche, pesoCocheInt, potenciaCocheInt);
    }
    
    private static Vehiculo crearVehiculo() {
        
        JOptionPane.showMessageDialog(null, "Has seleccionado la opcion de crear un Vehiculo \n"
                  + "Ahora le daras los valores que desees en la proxima ventana");
        
        String precioVehiculo = JOptionPane.showInputDialog("Introduce el precio del vehiculo");
        int precioVehiculoInt = Integer.parseInt(precioVehiculo);
        String colorVehiculo = JOptionPane.showInputDialog("Introduce el color del vehiculo");
        String gamaVehiculo = JOptionPane.showInputDialog("Introduce la gama del vehiculo");
        String pesoVehiculo = JOptionPane.showInputDialog("Introduce el peso del vehiculo");
        int pesoVehiculoInt = Integer.parseInt(pesoVehiculo);
        
        return new Vehiculo(precioVehiculoInt, colorVehiculo, gamaVehiculo, pesoVehiculoInt);
        
    }
    
    private static int opcionCrearSalir() {
        String[] opcionesCrearSalir = {"Crear", "Salir"};
        String mensajeCreacion = "Bienvenido a nuestro concesionario, selecciona que queieres hacer";
        
        int opcionCreacionVehiculo = JOptionPane.showOptionDialog(null, mensajeCreacion, "CREACION DEL VEHICULO", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCrearSalir, "");
        
        return opcionCreacionVehiculo;
    }
    
    private static int opcionSeleccionarTipoCreacion() {
        String[] opcionesCreaciones = {"Coche", "Furgoneta", "Vehiculo", "Salir"};
        String mensajeCreacion = "Aqui puedes seleccionar el tipo de creacion que quieres en nuestro concesionario. \n"
                + "Elige el tipo para despues poder ponerlo a tu gusto.";
        
        int opcionCreacionVehiculo = JOptionPane.showOptionDialog(null, mensajeCreacion, "CREACION DEL VEHICULO", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCreaciones, "");
        
        return opcionCreacionVehiculo;
    }
    
    private static int opcionElectricaFurgoneta() {
        String[] opcionesElectrico = {"Si", "No"};
        String mensajeElectrica = "¿La furgoneta es electrica?";
        int opcionElectricaFurgoneta = JOptionPane.showOptionDialog(null, mensajeElectrica, "CREACION DEL VEHICULO", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesElectrico, "");
        
        return opcionElectricaFurgoneta;
    }

	public static void mostrarResumen (Vehiculo[] vehiculos, Coche[] coches, Furgoneta[] furgonetas, 
										int numVehiculos, int numCoches, int numFurgonetas) {
		
		int precioTotalVehiculos = 0;
		int precioTotalCoches = 0;
		int precioTotalFurgonetas = 0;
	
		for (int i = 0; i < numVehiculos; i++) {
			precioTotalVehiculos = precioTotalVehiculos + vehiculos[i].precioFinal();
		}
		
		for (int i = 0; i < numCoches; i++) {
			precioTotalCoches = precioTotalCoches + coches[i].precioFinal();
		}
		
		for (int i = 0; i < numFurgonetas; i++) {
			precioTotalFurgonetas = precioTotalFurgonetas + furgonetas[i].precioFinal();
		}
		
		String infoCochesCreados = "Resumen de vehículos dados de alta: \n"
				+ "Número de vehículos: " + numVehiculos + "\n"
				+ "Número de coches: " + numCoches + "\n"
				+ "Número de furgonetas: " + numFurgonetas + "\n"
				+ "Precio total vehículos: " + precioTotalVehiculos + " € \n"
		        + "Precio total coches: " + precioTotalCoches + " € \n"
		        + "Precio total furgonetas: " + precioTotalFurgonetas + " €";
		
		JOptionPane.showMessageDialog(null, infoCochesCreados);

	    }
	
	
	
	
	

}