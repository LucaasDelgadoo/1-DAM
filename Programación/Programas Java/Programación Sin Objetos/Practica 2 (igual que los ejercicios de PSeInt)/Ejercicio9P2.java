import java.util.Scanner;
//Lucas Delgado Práctica 2
public class Ejercicio9P2{
	public static void main(String[] args){
	
	int dia;
	int mes;
	int ano;
	String mesUsuario = "";
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduzca el dia ");
	dia = sc.nextInt();
	System.out.println("Introduzca el mes ");
	mes = sc.nextInt();
	System.out.println("Introduzca el ano, (anos menores de 0 no se pueden introducir) ");
	ano = sc.nextInt();
	
	if (dia < 1 || dia > 31){
		System.out.println("La fecha establecida no existe ");
	}else if (mes < 1 || mes > 12){
		System.out.println("La fecha establecida no existe ");
	}else if (ano < 0 ){
		System.out.println("La fecha establecida no existe ");
	}
	
	
	if (mes == 1){
		mesUsuario = "enero";
	}else if (mes == 2){
		mesUsuario = "febrero";
	}else if (mes == 3){
		mesUsuario = "marzo";
	}else if (mes == 4){
		mesUsuario = "abril";
	}else if (mes == 5){
		mesUsuario = "mayo";
	}else if (mes == 6){
		mesUsuario = "junio";
	}else if (mes == 7){
		mesUsuario = "julio";
	}else if (mes == 8){
		mesUsuario = "agosto";
	}else if (mes == 9){
		mesUsuario = "septiembre";
	}else if (mes == 10){
		mesUsuario = "octubre";
	}else if (mes == 11){
		mesUsuario = "noviembre";
	}else if (mes == 12){
		mesUsuario = "diciembre";
	}
	
	System.out.println("Su fecha introducida es " + dia + " / " + mesUsuario + " / " + ano );
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}	

