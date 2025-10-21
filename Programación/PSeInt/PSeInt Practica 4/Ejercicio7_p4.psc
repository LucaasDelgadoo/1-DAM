Algoritmo piramide_invertida
	Definir n Como Entero
	Definir piramideCreacion como entero
	
	Escribir "Introduce el número de pisos de la pirámide invertida: "
	Leer n
	piramideCreacion = piramideInvertida(n)
FinAlgoritmo

Funcion n <- piramideInvertida(j)
	Definir i Como Entero
	Definir n como entero

Para i = n Hasta 1 Con Paso -1 Hacer
    
	Para j = n Hasta i Con Paso -1 Hacer
		Escribir " "
    FinPara
    Para j = 1 Hasta (i * 2) -1 Hacer
		Escribir "*"
    FinPara
    
	Escribir ""
	
FinPara
FinFuncion

