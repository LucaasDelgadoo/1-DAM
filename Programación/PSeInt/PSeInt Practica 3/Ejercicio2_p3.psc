Algoritmo Ejercicio2
	Definir numUsuario Como Entero
	Definir suma Como Entero
	Definir multiplos Como Entero
	Definir i como entero
	suma = 0
	
	Escribir "Introduce un numero entero positivo igual o mayor que 1 "
	Leer numUsuario
	Si numUsuario >= 1 Entonces
		Para i = 1 Hasta numUsuario Hacer
			multiplos = 3 * i
			suma = suma + multiplos
		FinPara
		Escribir "La suma de los primeros ", numUsuario, " multiplos de 3 es ", suma
	SiNo
		Escribir "El numero introducido no es posible "
	FinSi 
FinAlgoritmo

