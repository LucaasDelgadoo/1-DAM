package dam.cajero;

import javax.swing.JOptionPane;

public class CajeroLDF {
    public static void main(String[] args) {
        
    	Banco banco = new Banco();
        
    	banco.inicializarDatos(); // Crear usuarios iniciales

        Cliente cliente = banco.iniciarSesion();

        if (cliente != null) {
            
        	JOptionPane.showMessageDialog(null, "Bienvenido, " + cliente.getNombre());
            
        	JOptionPane.showMessageDialog(null, banco.obtenerResumenPosicionGlobal(cliente));
            
        	boolean salir = false;

            while (!salir) {
            
            	int opcion = banco.mostrarMenuPrincipal(cliente);

                switch (opcion) {
                
                case 0:
                
                	banco.retirarDinero(cliente);
                    
                	break;
                    
                case 1:
                
                	banco.ingresarDinero(cliente);
                    
                	break;
                    
                case 2:
                
                	banco.transferirEntreCuentas(cliente);
                    
                	break;
                    
                case 3:
                
                	banco.transferirExternamente(cliente);
                    
                	break;
                    
                case 4:
                
                	banco.contratarDeposito(cliente);
                    
                	break;
                    
                case 5:
                
                	salir = true;
                    
                	break;
                    
                default:
                
                	JOptionPane.showMessageDialog(null, "Opción inválida.");
                
                }
                       
            }
        
        } else {
           
        	JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Fin del programa.");
        
        }
    
    }
}
