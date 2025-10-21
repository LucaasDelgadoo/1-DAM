Algoritmo Ejercicio5
	Definir Peso Como real
	Definir AlturaCentimetros Como real
	Definir IMC Como real
	Definir AlturaMetros Como Real
	Escribir  " Introduce tu peso en Kg "
	Leer Peso
	Escribir "Introduce tu altura en Cm "
	Leer AlturaCentimetros
	AlturaMetros = AlturaCentimetros / 100
	IMC = Peso / (AlturaMetros^2)
	Escribir "El índice de masas corporal el: ", IMC
FinAlgoritmo
