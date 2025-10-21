Algoritmo Ejercicio7
	Definir Modulo Como Caracter
	Definir NotaModuloMedia Como Real
	Definir Nota1 Como Real
	Definir Nota2 Como Real
	Definir Nota3 como Real
	Escribir "Introduce el nombre del modulo "
	Leer Modulo
	Escribir "Introduce las tres notas de las 3 evaluaciones en orden, 1º, 2º y 3º Evaluacion "
	Leer Nota1
	Leer Nota2
	Leer Nota3
	NotaModuloMedia = (Nota1 * 0.33) + (Nota2 * 0.33) + (Nota3 * 0.33)
	Si NotaModuloMedia < 5 Entonces
		Escribir "La nota final del ", Modulo, " es Suspenso "
	FinSi
	
	SI NotaModuloMedia > 5 Entonces
		Si NotaModuloMedia < 6 Entonces
			Escribir "La nota final del ", Modulo, " es Aprobado "
		FinSi
			
				SI NotaModuloMedia > 6 Entonces
					Si NotaModuloMedia < 7 Entonces
						Escribir "La nota final del ", Modulo, " es Bien "
					FinSi
					
					
						Si NotaModuloMedia > 7 Entonces
							Si NotaModuloMedia < 9 Entonces
							Escribir "La nota final del ", Modulo, " es Notable "
						FinSi
						
					
						
						Si NotaModuloMedia > 9 Entonces
							Si NotaModuloMedia < 10 Entonces
								Escribir "La nota final del ", Modulo, " es Sobresaliente "
							FinSi
						FinSi
						
							
				
						
							
							Si NotaModuloMedia > 10 Entonces
								Escribir "La nota media no existe, porfavor compruebe si ha introducido bien los numeros "
								
							
								
								Si NotaModuloMedia < 0 Entonces
									Escribir "La nota media no existe, porfavor compruebe si ha introducido bien los numeros "
							FinSi
						FinSi
					FinSi
				FinSi
			FinSi
		
		
FinAlgoritmo
