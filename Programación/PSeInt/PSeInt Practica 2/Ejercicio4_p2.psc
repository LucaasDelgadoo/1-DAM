Algoritmo Ejercicio5
	Definir Peso Como real
	Definir Altura Como real
	Definir  IMC Como real
	Escribir "Introduzca su Peso en Kg y su Altura en metros "
	Leer Peso
	Leer Altura
	IMC = Peso / (Altura^2)
	Escribir "El índice de masas corporal el: ", IMC
	Si IMC < 20 Entonces
		Escribir "Peso Insuficiente "
	SiNo
		Si IMC >= 20 Y IMC < 25 Entonces
			Escribir "Peso Normal "
		SiNo
			Si IMC >= 25 Y IMC < 30 Entonces
				Escribir "Sobrepeso "
			SiNo
				Si IMC > 30 Entonces
					Escribir "Obesidad "
				FinSi
			FinSi
			
		FinSi
	FinSi
FinAlgoritmo
