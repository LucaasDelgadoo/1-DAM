Algoritmo Ejercicio2
	Definir opUsuario Como Entero
	Definir Suma Como Real
	Definir Resta como real
	Definir NumeroUsuario1 Como Real
	Definir NumeroUsuario2 Como Real
	
	Repetir
		Escribir " Seleccione una ocpion del Menú "
		Escribir " 1. Introducir numeros "
		Escribir " 2. Sumar numeros "
		Escribir " 3. Restar numeros "
		Escribir " 4. Salir "
		Leer opUsuario
		Si opUsuario = 4 Entonces
			Escribir "Has salido del programa "
		FinSi
		Si opUsuario = 1 Entonces
			Escribir "Has seleccionado la primera opcion "
			NumeroUsuario1 <- introducirNumero()
			NumeroUsuario2 <- introducirNumero()
		FinSi
		
		Si opUsuario = 2 Entonces
			Suma <- SumaNumerosIntroducidos (NumeroUsuario1, NumeroUsuario2)
			Escribir "La suma es: ", Suma
		FinSi		
		
		Si opUsuario = 3 Entonces
			Resta = RestaNumerosIntroducidos (NumeroUsuario1, NumeroUsuario2)
			Escribir "La resta es: ", Resta
		FinSi
		
		Si opUsuario < 1 O opUsuario > 4 Entonces
			Escribir "No existe esa opcion, Por favor seleccione una opcion de las mostradas "
		FinSi
	Hasta Que opUsuario = 4
FinAlgoritmo

Funcion num1 <- introducirNumero()
	Definir num1 como entero
	Escribir "Introduzca 1 numero del 1 al 50 "
	Leer num1
	Repetir
		Si num1 >= 51 O num1 <= 0 Entonces
			Escribir "No puedes introducir este numero " num1
		FinSi
	Hasta Que num1 <= 50 Y num1 >= 1
	
Fin Funcion

Funcion operacionSuma <- SumaNumerosIntroducidos (num1, num2)
	Definir operacionSuma Como Real
	Escribir "Has seleccionado ver la suma de los numeros establecidos "
	operacionSuma <- num1 + num2
Fin Funcion

Funcion operacionResta <- RestaNumerosIntroducidos (num1, num2)
	Definir operacionResta Como Real
	Escribir "Has seleccionado ver la resta de los numeros establecidos "
	operacionResta <- num1 - num2
FinFuncion

