Algoritmo Ejercicio7
	
	Definir precio Como Real
	Definir pagado Como Real
	Definir cambio Como Real
	Definir monedas200 Como Entero
	Definir monedas100 Como Entero
	Definir monedas50 Como Entero
	Definir monedas20 Como Entero
	Definir monedas10 Como Entero
	Definir monedas5 Como Entero
	Definir monedas2 Como Entero
	Definir monedas1 Como Entero
	
	
	Escribir "Introduce el precio del artículo (en euros): "
	Leer precio
	Escribir "Introduce el dinero pagado por el cliente (en euros): "
	Leer pagado
	
	cambio = pagado - precio
	
	Si cambio < 0 Entonces
		Escribir "La cantidad de pagado es insuficiente para pagar el producto "
	Sino
		
		monedas200 = 0
		monedas100 = 0
		monedas50 = 0
		monedas20 = 0
		monedas10 = 0
		monedas5 = 0
		monedas2 = 0
		monedas1 = 0
		
		
		monedas200 = Trunc(cambio / 2)
		cambio = cambio - (monedas200 * 2)
		
		monedas100 = Trunc(cambio / 1)
		cambio = cambio - (monedas100 * 1)
		
		monedas50 = Trunc(cambio / 0.5)
		cambio = cambio - (monedas50 * 0.5)
		
		monedas20 = Trunc(cambio / 0.2)
		cambio = cambio - (monedas20 * 0.2)
		
		monedas10 = Trunc(cambio / 0.1)
		cambio = cambio - (monedas10 * 0.1)
		
		monedas5 = Trunc(cambio / 0.05)
		cambio = cambio - (monedas5 * 0.05)
		
		monedas2 = Trunc(cambio / 0.02)
		cambio = cambio - (monedas2 * 0.02)
		
		monedas1 = Trunc(cambio / 0.01)
		cambio = cambio - (monedas1 * 0.01)
		
		Escribir "Monedas a devolver: "
		Si monedas200 > 0 Entonces
			Escribir "Monedas de 2 euros: ", monedas200
		FinSi
		Si monedas100 > 0 Entonces
			Escribir "Monedas de 1 euros: ", monedas100
		FinSi
		Si monedas50 > 0 Entonces
			Escribir "Monedas de 0.50 euros: ", monedas50
		FinSi
		Si monedas20 > 0 Entonces
			Escribir "Monedas de 0.20 euros: ", monedas20
		FinSi
		Si monedas10 > 0 Entonces
			Escribir "Monedas de 0.10 euros: ", monedas10
		FinSi
		Si monedas5 > 0 Entonces
			Escribir "Monedas de 0.05 euros: ", monedas5
		FinSi
		Si monedas2 > 0 Entonces
			Escribir "Monedas de 0.02 euros: ", monedas2
		FinSi
		Si monedas1 > 0 Entonces
			Escribir "Monedas de 0.01 euros: ", monedas1
		FinSi
	FinSi
FinProceso
