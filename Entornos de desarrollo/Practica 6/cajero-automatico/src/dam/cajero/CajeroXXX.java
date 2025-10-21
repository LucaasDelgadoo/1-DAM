package dam.cajero;

import javax.swing.JOptionPane;

public class CajeroXXX {
    public static void main(String[] args) {
        
    	Banco banco = new Banco();
        banco.inicializarDatos(); // Crear usuarios iniciales

        Cliente cliente = banco.iniciarSesion();
        
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido, " + cliente.getNombre());
            boolean salir = false;

            while (!salir) {
                String opcion = banco.mostrarMenuPrincipal(cliente);
                switch (opcion) {
                    case "1":
                        banco.retirarDinero(cliente);
                        break;
                    case "2":
                        banco.ingresarDinero(cliente);
                        break;
                    case "3":
                        banco.transferirEntreCuentas(cliente);
                        break;
                    case "4":
                        banco.transferirExternamente(cliente);
                        break;
                    case "5":
                        banco.contratarDeposito(cliente);
                        break;
                    case "0":
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

