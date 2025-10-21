Algoritmo EjemploECM
	Definir nota Como Real
	Escribir "Introduce nota: "
	Leer nota
	Si nota > 0 Entonces
		Si nota > 5 Entonces
			Escribir "Aprobado "
		FinSi
		Si nota > 6 Entonces
			Escribir  "Bien "
				
			Si nota > 7 Entonces
				Escribir "Notable "
			SiNo
				Escribir "Sobresaliente "
			FinSi
		FinSi
	SiNo
		Escribir "Nota incorrecta "
	FinSi
FinAlgoritmo
