package herencia;

public class Persona {

	private String nombreCompleto;
	private int edad;
	private String numTelefono;
	private String direccion;
	private char sexo;
	
	public boolean esMenorDeEdad () {
		
		if (this.edad <= 18) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void metodoPersona () {
		System.out.println("metodoPersona desde la clase Persona");
	}
	
	public void metodoSobrescrito1 () {
		System.out.println("metodoSobrescrito1 desde la clase Persona");
	}
	
	public void metodoSobrescrito2 () {
		System.out.println("metodoSobrescrito2 desde la clase Persona");
	}
	

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	
	
}
