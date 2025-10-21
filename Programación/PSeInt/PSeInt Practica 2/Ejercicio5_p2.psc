Algoritmo Ejercicio5
	Definir OpcionUsuario Como Entero
	Escribir "Para cursar DAM debera de indicar los titulos que ha obtenido previamente, necesita un título de Bachillerato, un título de Grado Medio o haber superado la prueba de acceso"
	Escribir "----"
	Escribir "Seleccione la opcion que se ajuste a su situacion "
	Escribir " 1. Título de Bachillerato "
	Escribir " 2. Título de Grado Medio "
	Escribir " 3. He superado la prueba de acceso "
	Escribir " 4. No tengo ningun titulo de los anteriores "
	Leer OpcionUsuario
	Si OpcionUsuario = 1 Entonces
		Escribir "Usted puede cursar el ciclo de DAM "
	SiNo
		Si OpcionUsuario = 2 Entonces
			Escribir "Usted puede cursar el ciclo de DAM "
		SiNo
			Si OpcionUsuario = 3 Entonces
				Escribir "Usted puede cursar el ciclo de DAM "
			SiNo
				Si OpcionUsuario = 4 Entonces
					Escribir "Usted no puede cursar el ciclo de DAM debido a la falta de un título necesario o el aprobado de la prueba de acceso"
				FinSi
			FinSi
		FinSi
	FinSi
FinAlgoritmo
