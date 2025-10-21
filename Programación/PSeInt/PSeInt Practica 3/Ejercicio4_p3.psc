Algoritmo Ejercicio4
	Definir numUsuario Como Real
	Definir mayor Como Real 
	Definir menor Como Real 
	Definir suma Como Real
	Definir contador como real
	Definir media Como Real
	suma = 0
	contador = 0

	Escribir "Introduce números, si quieres que el progrmaa haga la media aritmetica de los numero introducidos presion el 0 "
	Leer numUsuario

	Si numUsuario <> 0 Entonces
		mayor = numUsuario
		menor = numUsuario
	FinSi

	Mientras numUsuario <> 0 Hacer
		suma = suma + numUsuario
		contador = contador + 1
	
		Si numUsuario > mayor Entonces
		mayor = numUsuario
		FinSi
	
		Si numUsuario < menor Entonces
		menor = numUsuario
		FinSi
		Leer numUsuario
	FinMientras

Si contador > 0 Entonces
	media = suma / contador
	Escribir "El número mayor es: ", mayor
	Escribir "El número menor es: ", menor
	Escribir "La media de los números es: ", media
SiNo
	Escribir "No se ingresaron números válidos."
FinSi
FinAlgoritmo

