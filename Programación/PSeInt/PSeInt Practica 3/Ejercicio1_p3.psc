Algoritmo Ejercicio1
	Definir numeroUsuario Como Entero
	Definir i  Como Entero
	Definir numeroTabla Como Entero
	Repetir
		Escribir "Introduce un numero del 1 al 10 "
		Leer numeroUsuario
		Si numeroUsuario < 1 O numeroUsuario > 10 Entonces
			Escribir  "Error, el numero introducido es incorrecto "
		FinSi
	Hasta Que numeroUsuario >= 1 Y numeroUsuario <= 10
	
	Para i = 0 Hasta 10 Hacer
		Escribir numeroUsuario, " + ", numeroTabla + i " = ",  numeroUsuario + i
	FinPara
	Escribir " ---------------------------------------------- "
	
	Para i = 0 Hasta 10 Hacer
		Escribir numeroUsuario, " - ", numeroTabla + i " = ", numeroUsuario - i
	FinPara
	Escribir " ---------------------------------------------- "
	
	Para i = 0 Hasta 10 Hacer
		Escribir numeroUsuario, " * ", numeroTabla + i " = ", numeroUsuario * i
	FinPara
	Escribir " ---------------------------------------------- "
	
	Para i = 0 Hasta 10 Hacer
		Si i >= 1 Y i <= 10 Entonces
			Escribir numeroUsuario, " / ", numeroTabla + i " = ", numeroUsuario / i
		FinSi
		
		Si i = 0 Entonces
			Escribir numeroUsuario, " / ", numeroTabla + i, " = Infinito "
		FinSi
	FinPara
	

	
	
	
	
	
	
	
	
	
	
	
	
	
FinAlgoritmo
