Algoritmo sin_titulo
		Definir vida como entero
		Definir ataque Como Entero
		Definir pocionRevivir Como Logico
		pocionRevivir = Verdadero
		Leer ataque
		vida = 100
		Vida = vida - ataque
		
		Si (vida < 0 y no(pocionRevivir)) Entonces
			Escribir "Pokemon muerto "
		FinSi
FinAlgoritmo

