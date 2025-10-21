Algoritmo ejemploModular
	Definir numFinal Como Entero
	Definir numUsuario como entero	
	Escribir "Introduce el numero limite "
	Leer numFinal
	Repetir 
		numUsuario = introducirNumero(numFinal)
	Hasta Que numUsuario >= 1 Y numUsuario <= numFinal
	Escribir "El numero elegido es ", numUsuario
FinAlgoritmo	


Funcion num = introducirNumero (numLimite)
	Definir num Como Entero
	Escribir "Introduzca un numero el 1 al ", numLimite, " : "
	Leer num 
	Si num < 1 O num > numLimite Entonces
		Escribir "Error, el numero es incorrecto "
	FinSi
FinFuncion
	