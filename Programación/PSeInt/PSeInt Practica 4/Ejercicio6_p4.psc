Proceso Ejercicio6
    Definir jugadorSeleccion Como Entero
    Definir ronda Como Entero
    Definir resultado Como Cadena
	Definir opcionUsuario Como Entero
    Definir puntuacionJugador, puntuacionMaquina Como Entero
    puntuacionJugador = 0
    puntuacionMaquina = 0
	
    Escribir "Bienvenido al juego Piedra, Papel o Tijera"
    
	
	
    Para ronda = 1 Hasta 5 Hacer
        Escribir "Ronda ", ronda
        jugadorSeleccion = LeerSeleccion(opcionUsuario)
        resultado = jugarRonda(puntuacionJugador)
        
        Si resultado = "Jugador gana" Entonces
            puntuacionJugador = puntuacionJugador + 1
        Sino Si resultado = "Máquina gana" Entonces
				puntuacionMaquina = puntuacionMaquina + 1
			FinSi
		FinSi
		
		Escribir "Resultado de la ronda: ", puntuacionJugador, " y ", puntuacionMaquina
	FinPara
		

		Escribir "Puntuación final: "
		Escribir "Jugador: ", puntuacionJugador
		Escribir "Máquina: ", puntuacionMaquina
		
		Si puntuacionJugador > puntuacionMaquina Entonces
			Escribir "¡El jugador gana la partida!"
		Sino Si puntuacionMaquina > puntuacionJugador Entonces
				Escribir "¡La máquina gana la partida!"
			Sino
				Escribir "¡Es un empate!"
			FinSi
		FinSi
		
		
FinProceso


Funcion dependeLaEleccion <- jugarRonda(jugadorSeleccion)
    Definir dependeLaEleccion Como Entero
	Definir maquinaSeleccion Como Entero
	maquinaSeleccion = azar(3) 
    
	Si dependeLaEleccion >= 1 O dependeLaEleccion <= 3 Entonces
		
		Si jugadorSeleccion = maquinaSeleccion Entonces
			Escribir "La maquina ha seleccionado: ", maquinaSeleccion
			Escribir "Empate"
		Sino 
			Si (jugadorSeleccion = 0 Y maquinaSeleccion = 2) O (jugadorSeleccion = 1 Y maquinaSeleccion = 0) O (jugadorSeleccion = 2 Y maquinaSeleccion = 1) Entonces
				Escribir "La maquina ha seleccionado: ", maquinaSeleccion
				Escribir  "Jugador gana"
			FinSi
		
			Si (jugadorSeleccion = 2 Y maquinaSeleccion = 0) O (jugadorSeleccion = 0 Y maquinaSeleccion = 1) O (jugadorSeleccion = 1 Y maquinaSeleccion = 2) Entonces
				Escribir "La maquina ha seleccionado: ", maquinaSeleccion
				Escribir  "Máquina gana"
			FinSi
		FinSi	
	FinSi
FinFuncion


Funcion seleccion <- LeerSeleccion(EleccionJugador)
    Definir seleccion Como Entero
    Repetir
        Escribir "Ingresa tu selección (0: Piedra, 1: Papel, 2: Tijera): "
        Leer seleccion
    Hasta Que seleccion >= 0 Y seleccion <= 2
FinFuncion
