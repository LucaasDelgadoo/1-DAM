Algoritmo Ejercicio8
	Definir Tiempo como entero	
	Definir Precio Como Real
	Definir PrecioInicialFijo Como Real
	Definir PrecioExtra Como Real
	Definir TiempoExtra Como Entero
	Escribir "Los 60 minutos de parking valen 1,35 euros más un coste inicial fijo de 0,5 euros "
	Escribir "Si sobrepasa los 90 minutos, el coste de cada hora proxima sera de 0,9 euros "
	Escribir "Introduzca el tiempo que quiere en minutos "
	Leer Tiempo
	PrecioInicialFijo = 0.5
	Precio = ((1.35 / 60) * Tiempo) + PrecioInicialFijo
	
		Si Tiempo <= 90 Entonces
			Escribir "Su coste por el parking es de ", Precio, " euros "
		
			SiNo
		
			Si Tiempo > 90 Entonces
				Escribir "Introduzca los minutos superiores a los 90 que va ausar el parking "
				Leer TiempoExtra
				PrecioExtra = ((0.9 / 60) * TiempoExtra) + 1.85
					Escribir "Su coste por el parking es de ", PrecioExtra, " euros "
		FinSi
	FinSi
	
	
	
	
	
FinAlgoritmo
