Algoritmo Ejercicio1
	Definir numeroUsuarioAdivinar Como Entero
	Definir intento Como Entero
	Definir contador Como Entero
	Definir adivinado Como Logico
	
	Escribir "Introduce un número del 1 al 100 que tengan que adivinar:"
	Leer numeroUsuarioAdivinar
	
	Mientras numeroUsuarioAdivinar < 1 O numeroUsuarioAdivinar > 100 Hacer
		Escribir "Número inválido. Debe estar entre 1 y 100. Inténtalo de nuevo:"
		Leer numeroUsuarioAdivinar
	Fin Mientras
	
	contador = 0
	adivinado = Falso
	
	Mientras contador <= 6 Y adivinado = Falso Hacer
		Escribir "Adivina el número secreto, tienes 6 intentos para adivinarlo "
		Leer intento
		
		contador = contador + 1
		
		Si intento = numeroUsuarioAdivinar Entonces
			adivinado = Verdadero
		SiNo
			Si intento > numeroUsuarioAdivinar Entonces
				Escribir "El número secreto es menor."
			SiNo
				Escribir "El número secreto es mayor."
			FinSi
		FinSi
	Fin Mientras
	
	Si adivinado = Verdadero Entonces
		Escribir "¡Enhorabuena! Adivinaste el número secreto en ", contador, " intentos."
	SiNo
		Escribir "Fin de la partida. No lo conseguiste en 6 intentos."
		Escribir "El número secreto era: ", numeroUsuarioAdivinar
	FinSi
FinAlgoritmo