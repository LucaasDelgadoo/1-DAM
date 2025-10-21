package herencia;

import javax.swing.JOptionPane;

public class herenciaApp {

	public static void main(String[] args) {
		
		Persona persona = new Persona();
		Alumno alumno = new Alumno();
		Profesor profesor = new Profesor();

		persona.setNombreCompleto("Lucas Delgado Fernández");
		alumno.setNombreCompleto("Hugo Delgado Fernández");
		alumno.setEdad(16);
		if (alumno.esMenorDeEdad()) {
			System.out.println("Es menor de edad");
		}
		
		profesor.setNombreCompleto("Héctor Moran");
		profesor.setEdad(42);
		
		mostrarNombre(profesor);

		
		
	}
	
	public static void mostrarNombre (Persona persona) {
		
		System.out.println(persona.getNombreCompleto());
		System.out.println("¿Es menor de edad? --> " + persona.esMenorDeEdad());

	}

}
