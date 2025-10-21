Algoritmo Ejercicio9
	Definir Día Como Entero
	Definir Mes como entero
	Definir Año Como Entero
	Definir MesUsuario Como Caracter
	Escribir "Introduzca el día, mes y año en ese orden "
	Leer Día
	Leer Mes
	Leer Año
	
	Si Día < 1 Entonces
		Escribir "La fecha establecida no existe "
	FinSi

	Si Día >= 32 Entonces
		Escribir "La fecha establecida no existe "
	FinSi
	
	Si Mes < 1 Entonces
		Escribir "La fecha establecida no existe "
	FinSi
	Si Mes >= 13 Entonces
			Escribir "La fecha establecida no existe "
	FinSi
		
	Si Año >= 2025 Entonces
		Escribir "La fecha establecida no existe "
	FinSi
			
	Si Año < 1 Entonces
				Escribir "La fecha establecida no existe "
	FinSi
		
		Si Mes = 1 Entonces
				MesUsuario = "Enero"
			FinSi
			
		Si Mes = 2 Entonces
					MesUsuario = "Febrero"
				FinSi
					
			Si Mes = 3 Entonces
						MesUsuario = "Marzo"
					FinSi
					
			Si Mes = 4 Entonces
							MesUsuario = "Abril"
						FinSi
						
				Si Mes = 5 Entonces
								MesUsuario = "Mayo"
							FinSi
							
					Si Mes = 6 Entonces
									MesUsuario = "Junio"
								FinSi
								
						Si Mes = 7 Entonces
										MesUsuario = "Julio"
									FinSi
									
							Si Mes = 8 Entonces
											MesUsuario = "Agosto"
										FinSi
										
								Si Mes = 9 Entonces
												MesUsuario = "Septiembre"
											FinSi
											
									Si Mes = 10 Entonces
													MesUsuario = "Octubre"
												FinSi
												
										Si Mes = 11 Entonces
														MesUsuario = "Noviembre"
													FinSi
													
											Si Mes = 12 Entonces
															MesUsuario = "Diciembre"
														FinSi
														
	Escribir "Su fecha introducida es ", Día, "/", MesUsuario, "/", Año
	
		
FinAlgoritmo
