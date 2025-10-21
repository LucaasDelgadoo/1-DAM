Algoritmo Ejercicio4
	Definir cantidadDinero Como Real
	Definir opUsuario Como Entero
	Definir dineroCambio Como Real
	Definir DineroCambiado Como Real
	Escribir "Introduce la cantidad (en euros) que deseas cambiar "
	Leer cantidadDinero
	
	Si cantidadDinero <= 0 Entonces
		Escribir " No existe esa cantidad "
	FinSi
	
	Si cantidadDinero > 0 Entonces
		Escribir "Selecciona el tipo de moneda que deseas obtener "
		Escribir "1. Dolares " 
		Escribir "2. Libras "
		Escribir "3. Yuanes "
		Leer opUsuario
		
		Si opUsuario = 1 Entonces
			DineroCambiado = cambioMoneda (opUsuario, cantidadDinero)
			Escribir " Su cantidad de dinero es: ", DineroCambiado, " dolares "
		FinSi
	
		Si opUsuario = 2 Entonces
			DineroCambiado = cambioMoneda (opUsuario, cantidadDinero)
			Escribir " Su cantidad de dinero es: ", DineroCambiado, " libras "
		FinSi
	
		Si opUsuario = 3 Entonces
			DineroCambiado = cambioMoneda (opUsuario, cantidadDinero)
			Escribir " Su cantidad de dinero es: ", DineroCambiado, " yuanes "
		FinSi
	 
		Si opUsuario >= 4 O opUsuario <= 0 Entonces
			Escribir "NO EXISTE ESA OPCION!!!"
		FinSi
	FinSi
	
	
	
	
FinAlgoritmo

	
Funcion resultado <- cambioMoneda (opcionUs, dinero)
	Definir resultado Como Real
	Si opcionUs = 1 Entonces
		resultado = dinero * 0.9009009
	FinSi
	
	Si opcionUs = 2 Entonces
		resultado = dinero * 0.83
	FinSi
	
	Si opcionUs = 3 Entonces
		resultado = dinero * 7.79
	FinSi
Fin Funcion












