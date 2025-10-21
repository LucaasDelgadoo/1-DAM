Algoritmo 	Ejercicio3
	Definir prestamo como real
	Definir numMesesIndicados como entero
	Definir TAECliente Como Real
	Definir CuotaFinal como real
	Escribir "Selecciona la cantidad (en euros) de préstamo que quieres obtener "
	Leer prestamo
	Escribir " Introduzaca el número de meses para pagar el préstamo "
	Leer numMesesIndicados
	Escribir  "Introduzca el TAE a pagar "
	Leer TAECliente
	CuotaFinal = interesMensualaPagar (prestamo, numMesesIndicados, TAECliente)
FinAlgoritmo

Funcion CuotaPagarMensual <- interesMensualaPagar (prestamoPedido, numMeses, TAE)
	Definir CuotaPagarMensual Como Real
	CuotaPagarMensual = (prestamoPedido / numMeses) + TAE
	Escribir "La cifra total a pagar cada mes es de: " CuotaPagarMensual
Fin Funcion