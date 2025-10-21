Algoritmo Ejercicio5
	Definir aforo Como Entero 
	Definir butacas_vendidas como entero
	Definir butacas_disponibles Como Entero
	Definir entradas_compradas Como Entero
	Definir porcentaje_minimo_aviso Como Real
	butacas_vendidas = 0
	
	Escribir "Introduce el aforo total de la sala:"
	Leer aforo
	Si aforo <= 0 Entonces
		Escribir "El oforo introducido no es posible "
	FinSi
	butacas_disponibles = aforo
	porcentaje_minimo_aviso = aforo * 0.2 
	
	Mientras butacas_disponibles > 0 Hacer
		Escribir "Butacas disponibles: ", butacas_disponibles
		Escribir "¿Cuántas entradas desea comprar? (Ingrese 0 para salir)"
		Leer entradas_compradas
		
		Si entradas_compradas  <> 1 Entonces
			Escribir "Programa finalizado."
		FinSi
		
		Si entradas_compradas > butacas_disponibles Entonces
			Escribir "Error: No hay suficientes butacas disponibles."
		SiNo
			butacas_vendidas = butacas_vendidas + entradas_compradas
			butacas_disponibles = aforo - butacas_vendidas
			
			Si butacas_disponibles < porcentaje_minimo_aviso Entonces
				Escribir "Advertencia: Quedan menos del 20% de las butacas disponibles."
			FinSi
		FinSi
	FinMientras
	
	Escribir "Aforo completo. No hay más entradas disponibles."
FinAlgoritmo

