Algoritmo Ejercicio10
	Definir NotaExamen Como Real
	Definir NotaMediaPracticas Como Real
	Definir OpcionUsuario Como Entero
	Definir NotaFinal Como Real
	Escribir "¿Has realizado todas las prácticas? "
	Escribir "1. Si "
	Escribir "2. No "
	Leer OpcionUsuario
	Escribir "Escribe la nota de tu examen "
	Leer NotaExamen
	Escribir "Escribe la nota media de las practicas "
	Leer NotaMediaPracticas
	Si OpcionUsuario = 1 Entonces
		NotaFinal = (NotaExamen * 0.7) + (NotaMediaPracticas * 0.3)
			Escribir "Tu nota del curso es ", NotaFinal
		SiNo
			Si OpcionUsuario = 2 Entonces
		NotaFinal = (NotaExamen * 0.7) + (NotaMediaPracticas * 0.2)
			Escribir "Tu nota del curso es ", NotaFinal
		FinSi
		
	FinSi
	
FinAlgoritmo
