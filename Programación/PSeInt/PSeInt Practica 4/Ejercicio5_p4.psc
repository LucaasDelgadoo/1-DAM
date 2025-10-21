Algoritmo  Ejercicio5
    Definir numeroSecretoJugador1 Como Entero
	Definir numeroAdivinado  Como Entero
	Definir resultado como entero
	Definir intentos Como Entero
    intentos = 0
    
    numeroSecretoJugador1 = introducirNumero(numeroAdivinado)
	
	Mientras intentos < 4 Hacer
		intentos = intentos + 1
		Escribir "Usuario 2: Intenta adivinar el número secreto. Intento ", intentos, " de 4."
		Escribir "Si aparece un (-1) es que el numero introducido es menor que el numero secreto "
		Escribir "Si aparece un (1) es que el numero introducido es mayor que el numero secreto "
		Leer numeroAdivinado
		numeroAdivinado = comprobarNumero(numeroAdivinado, numeroSecretoJugador1)
        resultado = comprobarNumero(numeroSecretoJugador1, numeroSecretoJugador1)
        
		Si numeroAdivinado = numeroSecretoJugador1 Entonces
            Escribir "¡Enhorabuena! Has acertado el número secreto en ", intentos, " intentos."
	
		Si numeroAdivinado <> numeroSecretoJugador1 Entonces
			Escribir "El número secreto es menor que ", numeroAdivinado
		FinSi
		
		SiNo
		Escribir "El número secreto es mayor que ", numeroAdivinado
	FinSi
FinMientras


Si intentos = 4 Y resultado <> 0 Entonces
	Escribir "Fin de la partida. No has conseguido adivinar el número secreto."
	Escribir "El número secreto era: ", numeroSecreto
FinSi
FinAlgoritmo



Funcion FuncionIntroNum <- introducirNumero (num)
	Definir FuncionIntroNum Como Entero
    Escribir "Introduce un número entre 1 y 50: "
	Leer num
	Si num >= 1 y num <= 50 Entonces
		Escribir "Has seleccionado el numero: ", num
	SiNo
		Escribir "El numero introducido no es válido, intentalo de nuevo "
	FinSi
FinFuncion


Funcion comprobacionNumero <- comprobarNumero (numeroAdivinadoJugador2, numeroSecreto)
	Definir comprobacionNumero Como Entero
    Si numeroAdivinadoJugador2 = numeroSecreto Entonces
        comprobacionNumero = 0 
	FinSi
	
	Si numeroAdivinadoJugador2 > numeroSecreto Entonces
			comprobacionNumero = -1 
	FinSi
	
	Si numeroAdivinadoJugador2 < numeroSecreto Entonces
			comprobacionNumero = 1
	FinSi
    
FinFuncion














