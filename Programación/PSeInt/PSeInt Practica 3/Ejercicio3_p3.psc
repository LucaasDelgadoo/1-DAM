Algoritmo Ejercicio3
	Definir numUsuario Como Real 
	Definir  suma Como Real
	Definir contador Como Real
	suma = 0
	contador = 0
	
	Escribir "Introduce un n�mero (-1 para terminar):"
	Leer numUsuario
	
	Mientras numUsuario <> -1 Hacer
		suma = suma + numUsuario
		contador = contador + 1
		Escribir "Introduce otro n�mero (-1 para terminar):"
		Leer numUsuario
	FinMientras
	
	Si contador > 0 Entonces
		Escribir "La media aritm�tica es: ", suma / contador
	SiNo
		Escribir "No se introdujeron n�meros v�lidos."
	FinSi
FinAlgoritmo

