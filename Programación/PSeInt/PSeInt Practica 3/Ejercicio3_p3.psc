Algoritmo Ejercicio3
	Definir numUsuario Como Real 
	Definir  suma Como Real
	Definir contador Como Real
	suma = 0
	contador = 0
	
	Escribir "Introduce un número (-1 para terminar):"
	Leer numUsuario
	
	Mientras numUsuario <> -1 Hacer
		suma = suma + numUsuario
		contador = contador + 1
		Escribir "Introduce otro número (-1 para terminar):"
		Leer numUsuario
	FinMientras
	
	Si contador > 0 Entonces
		Escribir "La media aritmética es: ", suma / contador
	SiNo
		Escribir "No se introdujeron números válidos."
	FinSi
FinAlgoritmo

