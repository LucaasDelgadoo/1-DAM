Algoritmo Ejercicio2
	Definir NumeroUsuario1 como entero
	Definir NumeroUsuario2 Como Entero
	Definir NumeroUsuario3 Como Entero
	Leer NumeroUsuario1
	Leer NumeroUsuario2
	Leer NumeroUsuario3
	
	Si NumeroUsuario1 > NumeroUsuario2 Entonces
		Si NumeroUsuario1 > NumeroUsuario3 Entonces
			Escribir  "El numero mayor es ", NumeroUsuario1
		FinSi
		
	FinSi
	Si NumeroUsuario2 > NumeroUsuario1 Entonces
		Si NumeroUsuario2 > NumeroUsuario3 Entonces
			Escribir "El numero mayor es ", NumeroUsuario2
		FinSi
	FinSi
	SI NumeroUsuario3 > NumeroUsuario1 Entonces
		sI	NumeroUsuario3 > NumeroUsuario2 Entonces
			Escribir "El numero mayor es ", NumeroUsuario3
		FinSi
	FinSi
	

	
	Si NumeroUsuario1 = NumeroUsuario2 Entonces
		Si NumeroUsuario3 < NumeroUsuario1 Entonces
			si NumeroUsuario3 < NumeroUsuario2 Entonces
				Escribir " Los numeros (1º) ", NumeroUsuario1, " y (2º) ", NumeroUsuario2, " son iguales "
			FinSi
		FinSi
		
	SiNo
		Si NumeroUsuario2 = NumeroUsuario3 Entonces
			SI NumeroUsuario1 < NumeroUsuario2 Entonces
				Si NumeroUsuario1 < NumeroUsuario3 Entonces
					Escribir " Los numeros (1º) ", NumeroUsuario1, " y (2º) ", NumeroUsuario2, " son iguales "
				FinSi
			FinSi
			
		FinSi
		
			
		Si NumeroUsuario1 = NumeroUsuario3 Entonces
			Si NumeroUsuario2 < NumeroUsuario1 Entonces
				Si NumeroUsuario2 < NumeroUsuario3 Entonces
					Escribir " Tus numeros (1º) ", NumeroUsuario1, " y (3º) ", NumeroUsuario3, " son iguales "
				FinSi
			FinSi
			
		FinSi
		
		
	FinSi
	
	Si NumeroUsuario1 = NumeroUsuario2 Entonces
		Si NumeroUsuario2 = NumeroUsuario3 Entonces
			Escribir "Los tres numeros son iguales ", NumeroUsuario1
		FinSi
	FinSi
FinAlgoritmo
