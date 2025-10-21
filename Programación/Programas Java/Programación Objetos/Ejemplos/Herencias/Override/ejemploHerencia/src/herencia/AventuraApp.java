package herencia;

public class AventuraApp {

	public static void main(String[] args) {
		
		Personaje personaje1 = new Personaje("Barbarian", 125, 6, 3);
		Personaje personaje2 = new Personaje("Wizard", 70, 4, 6);
		
		Protagonista prota1 = new Protagonista("Lucas", 100, 10, 5, 2, 25);
		Enemigo enemy = new Enemigo("Troll de las cavernas", 35, 2, 2);
		
		personaje1.setAtaque(10);
		
		System.out.println("Vida del personaje 2: " + personaje2.getVida());
		personaje1.atacarPersonaje(personaje2);
		System.out.println("Ataque del personaje 1: " + personaje1.getAtaque());
		System.out.println("Vida del personaje 2 despues del ataque: " + personaje2.getVida());
		
		
		System.out.println("Vida del personaje 2: " + personaje2.getVida());
		prota1.atacarPersonaje(personaje2);
		System.out.println("Vida del personaje 2 despues del ataque: " + personaje2.getVida());
		
		
		

	}

}
