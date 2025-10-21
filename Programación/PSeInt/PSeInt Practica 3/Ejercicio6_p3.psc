Algoritmo Ejercicio1
	Definir numeroUsuarioAdivinar Como Entero
	Definir intento Como Entero
	Definir contador Como Entero
	Definir adivinado Como Logico
	
	Escribir "Introduce un n�mero del 1 al 100 que tengan que adivinar:"
	Leer numeroUsuarioAdivinar
	
	Mientras numeroUsuarioAdivinar < 1 O numeroUsuarioAdivinar > 100 Hacer
		Escribir "N�mero inv�lido. Debe estar entre 1 y 100. Int�ntalo de nuevo:"
		Leer numeroUsuarioAdivinar
	Fin Mientras
	
	contador = 0
	adivinado = Falso
	
	Mientras contador <= 6 Y adivinado = Falso Hacer
		Escribir "Adivina el n�mero secreto, tienes 6 intentos para adivinarlo "
		Leer intento
		
		contador = contador + 1
		
		Si intento = numeroUsuarioAdivinar Entonces
			adivinado = Verdadero
		SiNo
			Si intento > numeroUsuarioAdivinar Entonces
				Escribir "El n�mero secreto es menor."
			SiNo
				Escribir "El n�mero secreto es mayor."
			FinSi
		FinSi
	Fin Mientras
	
	Si adivinado = Verdadero Entonces
		Escribir "�Enhorabuena! Adivinaste el n�mero secreto en ", contador, " intentos."
	SiNo
		Escribir "Fin de la partida. No lo conseguiste en 6 intentos."
		Escribir "El n�mero secreto era: ", numeroUsuarioAdivinar
	FinSi
FinAlgoritmo