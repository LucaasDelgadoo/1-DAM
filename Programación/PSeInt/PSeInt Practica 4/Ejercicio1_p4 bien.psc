Algoritmo Ejercicio1
	Definir numComprobar como entero
	Escribir "Introduce un numero para comprobarlo "
	numComprobar = esParMultiploTres(numComprobar)
	
	Si numComprobar > 1 Entonces

		
		Si numComprobar es Par Y numComprobar mod 3 = 0 Entonces
			Escribir "El numero que has introducido " ,numComprobar " es par y es multiplo de 3 "
		FinSi
		
		Si numComprobar es Impar Y numComprobar mod 3 = 0 Entonces
			Escribir "El numero que has introducido ",numComprobar , " no es un numero par y es multiplo de 3 "
		FinSi
		
		Si numComprobar es Impar Y numComprobar mod 3 <> 0 Entonces
			Escribir "El numero que has introducido ",numComprobar , " no es un numero par y no es multiplo de 3 "
		FinSi
		
		Si numComprobar es Par Y numComprobar mod 3 <> 0 Entonces
			Escribir "El numero que has introducido ",numComprobar , " es un numero par y no es multiplo de 3 "
		FinSi
	FinSi
	
FinAlgoritmo

Funcion comprobacionNum <- esParMultiploTres (num)
	Definir comprobacionNum Como Entero
	Leer comprobacionNum
	Si comprobacionNum < 1 Entonces
		Escribir "Error, no puedes introducir ese numero "
	FinSi
Fin Funcion

//Preguntar porque me lo pide introducirlo 2 veces