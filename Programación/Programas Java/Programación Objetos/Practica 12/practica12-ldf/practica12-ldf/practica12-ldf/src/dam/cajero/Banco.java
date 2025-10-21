package dam.cajero;

import javax.swing.JOptionPane;

public class Banco {
	
    public static final int MAXIMO_CLIENTES = 3;
    
    private Cliente[] clientes = new Cliente[MAXIMO_CLIENTES];

    // Inicializa los clientes del banco con datos predefinidos
    public void inicializarDatos() {
        
    	Cliente JeffPrestonBezos = new Cliente("Jeff", "Preston Bezos", "72343698G", "12/01/1964", "Hombre", "amazon", 0666);
        
    	Cliente AnaPatriciaBotínSanz = new Cliente("Ana Patricia", "Botín Sanz", "08269547N", "04/10/1960", "Mujer", "santander", 1234);
        
    	Cliente MarkLenders = new Cliente("Mark", "Lenders", "94827645W", "07/07/2007", "Hombre", "toho", 9999);

        clientes[0] = JeffPrestonBezos;
        
        clientes[1] = AnaPatriciaBotínSanz;
        
        clientes[2] = MarkLenders;

        String divisaEuros = "EU";
        String divisaDolares = "USD";

        clientes[0].agregarCuenta(new CuentaNomina("12345678900", 350000, divisaDolares));
        clientes[0].agregarCuenta(new CuentaCorriente("13243546576", 1000000, divisaDolares));
        clientes[0].agregarCuenta(new CuentaCorriente("00987654321", 565000, divisaEuros));

        clientes[1].agregarCuenta(new CuentaCorriente("08978675645", 15000, divisaEuros));
        clientes[1].agregarCuenta(new CuentaCorriente("99998888444", 182000, divisaEuros));

        clientes[2].agregarCuenta(new CuentaCorriente("16273849506", 0, divisaEuros));

        clientes[0].agregarDeposito(new Deposito("MAX", 375000, 3, 36));
        clientes[1].agregarDeposito(new Deposito("Senior", 56754, 2.75, 24));
        
        Deposito depositoJunior = new Deposito("Junior", 500, 2.5, 12); 
        
        Deposito depositoSenior = new Deposito("Senior", 5000, 2.75, 24); 
        
        Deposito depositoMAX = new Deposito("MAX", 20000, 3, 36);
    }

    // Iniciar sesión con usuario y PIN, y retorna el cliente, si existe
    public Cliente iniciarSesion() {
        
    	JOptionPane.showMessageDialog(null, "Bienvenido al cajero automático. Indica tus datos para iniciar sesión.");
        
    	String nombreUsuario = JOptionPane.showInputDialog("Introduce el Usuario de tu Cuenta Bancaria");
        
    	String pinUsuario = JOptionPane.showInputDialog("Introduce el PIN de tu Cuenta Bancaria");
        
    	int pinUsuarioInt = Integer.parseInt(pinUsuario);

        for (Cliente cliente : clientes) {
            
        	if (cliente != null && cliente.getUsuario().equals(nombreUsuario) && cliente.getPin() == pinUsuarioInt) {
            
        		return cliente;
            
        	}
        
        }
        
        return null;
    
    }

    // Muestra el menú principal al cliente y retorna la selección del cliente
    public int mostrarMenuPrincipal(Cliente cliente) {
        
    	String[] opcionesUsuario = { "Retirar dinero", "Ingresar dinero", "Transferir dinero entre cuentas", "Transferir dinero externamente", "Contratar depósito", "Salir" };
        
    	return JOptionPane.showOptionDialog(null, "¿Qué deseas hacer, " + cliente.getNombre() + "?", "MENÚ PRINCIPAL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesUsuario, opcionesUsuario[0]);
    
    }

    // Retirada de dinero de las cuentas de los clientes
    public void retirarDinero(Cliente cliente) {
        
    	int opcion = opcionesRetirarDinero();
        
    	if (opcion == 1) return; // Salir de la operación

    	int seleccionCuenta = seleccionCuenta();
        
    	Cuenta cuenta = cliente.getCuentas()[seleccionCuenta];
        
    	double cantidad = cantidadQueQuiereRetirar();

        if (cuenta instanceof CuentaCorriente) {
        
        	if (cantidad > 300 || cantidad > cuenta.getSaldo() * 0.25) {
            
        		JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                
        		return;
            
        	}
        
        } else if (cuenta instanceof CuentaNomina) {
        
        	if (cantidad > 500 || cantidad > cuenta.getSaldo() * 0.25) {
            
        		JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                
        		return;
            
        	}
        
        }

        if (!cuenta.retirarDinero(cantidad)) {
        
        	JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
            
        	return;
        
        }

       mostrarBilletes(cantidad, cuenta.getDivisa());
       
       JOptionPane.showMessageDialog(null, "Retiro exitoso. Nuevo saldo: " + cuenta.getSaldo());
    
    }

    // Ingreso en las cuentas de los clientes
    public void ingresarDinero(Cliente cliente) {
    	
    	int opcion = opcionesIngresarDinero();
        
    	if (opcion == 1) return; // Salir de la operación

        
    	int seleccionCuenta = seleccionCuenta();
        
    	Cuenta cuenta = cliente.getCuentas()[seleccionCuenta];
        
    	double cantidad = cantidadQueQuiereIngresar();

        
    	cuenta.ingresarDinero(cantidad);
        
    	mostrarBilletes(cantidad, cuenta.getDivisa());
        
    	JOptionPane.showMessageDialog(null, "Ingreso exitoso. Nuevo saldo: " + cuenta.getSaldo());
    
    }

    // Lógica para transferir entre cuentas propias
    public void transferirEntreCuentas(Cliente cliente) {
        
    	if (cliente.getCuentas().length < 2) {
        
    		JOptionPane.showMessageDialog(null, "No tienes suficientes cuentas para realizar una transferencia.");
            
    		return;
        
    	}

        String[] opcionesCuentas = new String[cliente.getCuentas().length];
        
        for (int i = 0; i < cliente.getCuentas().length; i++) {
        
        	opcionesCuentas[i] = "Cuenta " + (i + 1) + ": " + cliente.getCuentas()[i].getIban() + " - Saldo: " + cliente.getCuentas()[i].getSaldo() + " " + cliente.getCuentas()[i].getDivisa();
        
        }

        int cuentaOrigen = JOptionPane.showOptionDialog(null, "Selecciona la cuenta de origen:", "Transferir entre Cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCuentas, opcionesCuentas[0]);
        
        int cuentaDestino = JOptionPane.showOptionDialog(null, "Selecciona la cuenta de destino:", "Transferir entre Cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCuentas, opcionesCuentas[0]);

        if (cuentaOrigen == cuentaDestino) {
        
        	JOptionPane.showMessageDialog(null, "La cuenta de origen y destino no pueden ser la misma.");
            
        	return;
        
        }

        String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad a transferir:");
        
        double cantidad = Double.parseDouble(cantidadStr);

        if (cantidad > cliente.getCuentas()[cuentaOrigen].getSaldo()) {
        
        	JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
            
        	return;
        
        }

        String divisaOrigen = cliente.getCuentas()[cuentaOrigen].getDivisa();
        
        String divisaDestino = cliente.getCuentas()[cuentaDestino].getDivisa();
        
        double cantidadConvertida = convertirDivisa(cantidad, divisaOrigen, divisaDestino);

        cliente.getCuentas()[cuentaOrigen].retirarDinero(cantidad);
        
        cliente.getCuentas()[cuentaDestino].ingresarDinero(cantidadConvertida);

        JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito.\n" +
                "Nuevo saldo cuenta origen: " + cliente.getCuentas()[cuentaOrigen].getSaldo() + " " + divisaOrigen + "\n" +
                "Nuevo saldo cuenta destino: " + cliente.getCuentas()[cuentaDestino].getSaldo() + " " + divisaDestino);
    
    }

    // Lógica para transferir a cuentas externas
    public void transferirExternamente(Cliente cliente) {
        
    	int opcion = opcionesTransferirDinero();
       
    	if (opcion == 1) return; // Salir de la operación

        
    	int opcionTipoTransferencia = tipoTransferencia();
        
    	if (opcionTipoTransferencia == JOptionPane.CLOSED_OPTION) return; // Salir de la operación

        JOptionPane.showMessageDialog(null, "Introduce los datos necesarios para poder realizar la transferencia.");

        String IBANDestinatario = JOptionPane.showInputDialog("Introduce el IBAN del destinatario");
        
        String titularDestinatario = JOptionPane.showInputDialog("Introduce el titular del destinatario");
        
        String conceptoTransferencia = JOptionPane.showInputDialog("Introduce el concepto de la transferencia");
        double cantidadDeDinero = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de dinero que deseas transferir"));

        String[] cuentas = new String[cliente.getCuentas().length];
        
        for (int i = 0; i < cliente.getCuentas().length; i++) {
        
        	if (cliente.getCuentas()[i] != null) {
            
        		cuentas[i] = "Cuenta: " + cliente.getCuentas()[i].getIban() + " - Saldo: " + cliente.getCuentas()[i].getSaldo() + " " + cliente.getCuentas()[i].getDivisa();
            
        	}
        
        }

        int cuentaSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona la cuenta desde la cual deseas realizar la transferencia:", "Seleccionar Cuenta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cuentas, cuentas[0]);
        
        Cuenta cuentaOrigen = cliente.getCuentas()[cuentaSeleccionada];

        double comision = opcionTipoTransferencia == 1 ? 20.0 : Math.max(3.95, cantidadDeDinero * 0.003);
        
        double total = cantidadDeDinero + comision;

        if (total > cuentaOrigen.getSaldo()) {
        
        	JOptionPane.showMessageDialog(null, "Fondos insuficientes para realizar la transferencia.");
            
        	return;
        
        }

        cuentaOrigen.retirarDinero(total);

        JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito.\n" +
                "Importe transferido: " + cantidadDeDinero + "€/$\n" +
                "Comisión aplicada: " + comision + "€/$\n" +
                "Nuevo saldo de la cuenta: " + cuentaOrigen.getSaldo() + " " + cuentaOrigen.getDivisa());

        int imprimirJustificante = JOptionPane.showConfirmDialog(null, "¿Deseas imprimir un justificante de la transferencia por 3€/$ adicionales?", "Imprimir Justificante", JOptionPane.YES_NO_OPTION);
        
        if (imprimirJustificante == JOptionPane.YES_OPTION) {
        
        	if (cuentaOrigen.getSaldo() < 3) {
            
        		JOptionPane.showMessageDialog(null, "Fondos insuficientes para imprimir el justificante.");
            
        	} else {
            
        		cuentaOrigen.retirarDinero(3);
                
        		JOptionPane.showMessageDialog(null, "Justificante impreso. Se han descontado 3€/$ de tu cuenta.");
            
        	}
        
        }
    
    }

    // Lógica para contratar depósitos
    public void contratarDeposito(Cliente cliente) {
    
    	if (contarDepositos(cliente) >= Cliente.MAXIMO_DEPOSITOS) {
        
    		JOptionPane.showMessageDialog(null, "Ya has alcanzado el máximo de depósitos permitidos.");
            
    		return;
        
    	}

        String[] opcionesDeposito = { "Depósito Junior", "Depósito Senior", "Depósito MAX", "Cancelar" };
        
        int opcionDeposito = JOptionPane.showOptionDialog(null, "Selecciona el tipo de depósito que deseas contratar", "Contratar Depósito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesDeposito, opcionesDeposito[0]);

        if (opcionDeposito == 3 || opcionDeposito == JOptionPane.CLOSED_OPTION) {
        
        	return; // Cancelar operación
        
        }

        double importeMinimo = 0;
        
        double interesTAE = 0;
        
        int plazoMeses = 0;

        switch (opcionDeposito) {
        
        case 0: // Depósito Junior
        
        	importeMinimo = 500;
            
        	interesTAE = 2.5;
            
        	plazoMeses = 12;
            
        	break;
            
        case 1: // Depósito Senior
        
        	if (!esAdulto(cliente)) {
            
        		JOptionPane.showMessageDialog(null, "Solo los adultos pueden contratar el Depósito Senior.");
                
        		return;
                
        	}
            
        	importeMinimo = 5000;
            
        	interesTAE = 2.75;
            
        	plazoMeses = 24;
            
        	break;
            
        case 2: // Depósito MAX
        
        	if (!esAdulto(cliente)) {
            
        		JOptionPane.showMessageDialog(null, "Solo los adultos pueden contratar el Depósito MAX.");
                
        		return;
                
        	}
            
        	importeMinimo = 20000;
            
        	interesTAE = 3.0;
            
        	plazoMeses = 36;
            
        	break;
        
        }

        double importe = Double.parseDouble(JOptionPane.showInputDialog("Introduce el importe para el depósito (mínimo " + importeMinimo + "€/$):"));
       
        if (importe < importeMinimo) {
        
        	JOptionPane.showMessageDialog(null, "El importe es inferior al mínimo requerido para este depósito.");
            
        	return;
        
        }

        String[] cuentas = new String[cliente.getCuentas().length];
        
        for (int i = 0; i < cliente.getCuentas().length; i++) {
        
        	if (cliente.getCuentas()[i] != null) {
            
        		cuentas[i] = "Cuenta: " + cliente.getCuentas()[i].getIban() + " - Saldo: " + cliente.getCuentas()[i].getSaldo() + " " + cliente.getCuentas()[i].getDivisa();
            
        	}
        
        }

        int cuentaSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona la cuenta desde la cual deseas traspasar el dinero para el depósito:", "Seleccionar Cuenta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cuentas, cuentas[0]);
        
        Cuenta cuentaOrigen = cliente.getCuentas()[cuentaSeleccionada];

        if (importe > cuentaOrigen.getSaldo()) {
        
        	JOptionPane.showMessageDialog(null, "El saldo de la cuenta seleccionada es insuficiente para realizar este depósito.");
            
        	return;
        
        }

        cuentaOrigen.retirarDinero(importe);
        
        Deposito deposito = new Deposito(opcionesDeposito[opcionDeposito], importe, interesTAE, plazoMeses);
        
        cliente.agregarDeposito(deposito);

        double interesesNetos = deposito.calcularIntereses();
        
        double importeFinal = importe + interesesNetos;

        JOptionPane.showMessageDialog(null, "Depósito contratado con éxito.\n" +
                "Importe: " + importe + "€/$\n" +
                "Intereses generados: " + interesesNetos + "€/$\n" +
                "Importe final al término del plazo: " + importeFinal + "€/$");
    
    }

	// Métodos auxiliares
	
	// Comprueba si el cliente es adulto (18 años o más)
	private boolean esAdulto(Cliente cliente) {
	
		String[] fechaParts = cliente.getFechaNacimiento().split("/");
	    
		int anioNacimiento = Integer.parseInt(fechaParts[2]);
	    
		int anioActual = 2025; // Supongamos que estamos en el año 2025
	    
		return (anioActual - anioNacimiento) >= 18;
	
	}
	
	// Cuenta el número de depósitos del cliente
	private int contarDepositos(Cliente cliente) {
	    
		int contador = 0;
	    
		for (Deposito deposito : cliente.getDepositos()) {
	    
			if (deposito != null) {
	        
				contador++;
	        
			}
	    
		}
	    
		return contador;
	
	}
	
	// Muestra los billetes entregados en una operación de retiro de dinero
	private static void mostrarBilletes(double cantidad, String divisa) {
	
		int[] billetes;
	    
		String mensaje = "Billetes entregados: \n";
	
	    // Determinar las denominaciones de billetes según la divisa
		if (divisa.equals("EU")) {
	    
			billetes = new int[]{100, 50, 20, 10};
	    
		} else {
	        
			billetes = new int[]{50, 20, 10};
	    
		}
	
	    // Calcular los billetes entregados
	    for (int billete : billetes) {
	    
	    	int numBilletes = (int) (cantidad / billete);
	        
	    	if (numBilletes > 0) {
	        
	    		mensaje += numBilletes + " billete(s) de " + billete + " " + divisa + "\n";
	            
	    		cantidad %= billete;
	        
	    	}
	    
	    }
	
	    
	    JOptionPane.showMessageDialog(null, mensaje);
	
	}
	
	// Realiza un cambio de una cantidad de divisa origen a destino
	public static double convertirDivisa(double cantidad, String divisaOrigen, String divisaDestino) {
	   
		if (divisaOrigen.equals("EU") && divisaDestino.equals("USD")) {
	   
			return cantidad * 1.1;
	    
		} else if (divisaOrigen.equals("USD") && divisaDestino.equals("EU")) {
	     
			return cantidad / 1.1;

		}
	   
		return cantidad;
	
	}
	
	// Retorna la posición global del cliente en el banco (cuentas/depósitos con sus saldos y saldo total)
	public String obtenerResumenPosicionGlobal(Cliente cliente) {
	    
		String resumen = "El cliente " + cliente.getNombre() + " tiene un total de " + cliente.getCuentas().length + " cuentas.\n";
	    
		double saldoTotal = 0;

		for (Cuenta cuenta : cliente.getCuentas()) {
	        
			if (cuenta != null) {
	            
				resumen += "Cuenta: " + cuenta.getIban() + ", Saldo: " + cuenta.getSaldo() + " " + cuenta.getDivisa() + "\n";
	            
				saldoTotal += cuenta.getSaldo();
	        
			}
	    
		}
	    
		resumen += "Saldo total: " + saldoTotal;
	    
		return resumen;
	
	}
	
	// Métodos para opciones de menú
	public int opcionesRetirarDinero() {
	    
		String[] opcionesRetirarDinero = { "Retirar dinero", "Salir" };
	    
		return JOptionPane.showOptionDialog(null, "Selecciona la opción que deseas realizar", "RETIRAR DINERO", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcionesRetirarDinero, "");
	
	}
	
	public int opcionesIngresarDinero() {
	    
		String[] opcionesIngresarDinero = { "Ingresar dinero", "Salir" };
	    
		return JOptionPane.showOptionDialog(null, "Selecciona la opción que deseas realizar", "INGRESAR DINERO", JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE, null, opcionesIngresarDinero, "");
	
	}
	
	public int opcionesTransferirDinero() {
	   
		String[] opcionesTransferirDinero = { "Transferir dinero", "Salir" };
	    
		return JOptionPane.showOptionDialog(null, "Selecciona la opción que deseas realizar", "TRANSFERIR DINERO", JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE, null, opcionesTransferirDinero, "");
	
	}
	
	public int tipoTransferencia() {
	    
		String[] tiposTransferencia = { "Transferencia Estándar", "Transferencia Urgente" };
	    
		return JOptionPane.showOptionDialog(null, "Selecciona el tipo de transferencia que deseas realizar", "TIPO DE TRANSFERENCIA", JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE, null, tiposTransferencia, "");
	
	}
	
	public int seleccionCuenta() {
	    
		String[] opcionesCuenta = { "Corriente", "Nomina" };
	    
		return JOptionPane.showOptionDialog(null, "¿De qué tipo de cuenta quieres retirar dinero?", "SELECCIONA TIPO DE CUENTA", JOptionPane.DEFAULT_OPTION,
	            JOptionPane.QUESTION_MESSAGE, null, opcionesCuenta, "");
	
	}
	
	public double cantidadQueQuiereRetirar() {
	    
		String cantidadARetirar = JOptionPane.showInputDialog("¿Cuánta cantidad de dinero deseas retirar?");
	    
		return Double.parseDouble(cantidadARetirar);
	
	}
	
	public double cantidadQueQuiereIngresar() {
	   
		String cantidadAIngresar = JOptionPane.showInputDialog("¿Cuánta cantidad de dinero deseas ingresar?");
	    
		return Double.parseDouble(cantidadAIngresar);
	
	}
}
