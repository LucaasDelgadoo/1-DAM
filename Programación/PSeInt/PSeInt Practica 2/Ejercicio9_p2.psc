Algoritmo Ejercicio9
	Definir D�a Como Entero
	Definir Mes como entero
	Definir A�o Como Entero
	Definir MesUsuario Como Caracter
	Escribir "Introduzca el d�a, mes y a�o en ese orden "
	Leer D�a
	Leer Mes
	Leer A�o
	
	Si D�a < 1 Entonces
		Escribir "La fecha establecida no existe "
	FinSi

	Si D�a >= 32 Entonces
		Escribir "La fecha establecida no existe "
	FinSi
	
	Si Mes < 1 Entonces
		Escribir "La fecha establecida no existe "
	FinSi
	Si Mes >= 13 Entonces
			Escribir "La fecha establecida no existe "
	FinSi
		
	Si A�o >= 2025 Entonces
		Escribir "La fecha establecida no existe "
	FinSi
			
	Si A�o < 1 Entonces
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
														
	Escribir "Su fecha introducida es ", D�a, "/", MesUsuario, "/", A�o
	
		
FinAlgoritmo
