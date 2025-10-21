import java.util.Scanner;
//Lucas Delgado Práctica 2 
public class Ejercicio4P2{
	public static void main(String[] args){
	
	double peso;
	double altura;
	double imc;
	Scanner sc =new Scanner(System.in);
	
	System.out.println("Introduce tu peso en KG ");	
	peso = sc.nextDouble();
	System.out.println("Introduce tu altura en metros (usa la , para separar los decimales) ");	
	altura = sc.nextDouble();	

	imc = peso / (altura * altura);
	
	System.out.println("El índice de masa corporal es: " + imc);	
	
	if (imc < 20){
		System.out.println("Peso Insuficiente ");		
	}else if (imc >= 20 && imc < 25){
			System.out.println("Peso Normal ");	
		}else if (imc >= 25 && imc <30){
				System.out.println("Sobrepeso ");	
			}else if (imc > 30){
					System.out.println("Obesidad ");	
				}
	






	
 }
	
}	
