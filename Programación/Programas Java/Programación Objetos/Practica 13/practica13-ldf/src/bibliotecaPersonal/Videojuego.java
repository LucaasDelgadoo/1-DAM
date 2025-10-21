package bibliotecaPersonal;

public class Videojuego implements Coleccionable {
	
	private String tipoColeccionable;
	private String nombreVideojuego;
	private String plataformaVideojuego;
	
	
	
	public Videojuego(String nombreVideojuego, String plataformaVideojuego) {
		this.tipoColeccionable = VIDEOJUEGO;
		this.nombreVideojuego = nombreVideojuego;
		this.plataformaVideojuego = plataformaVideojuego;
	}

	@Override
	public String mostrar() {
		
		String informacionLibro = "Tipo de coleccionable: " + this.tipoColeccionable + "\n"
								+ "Titulo: " + getNombreVideojuego() + "\n"
								+ "Plataforma: " + getPlataformaVideojuego() + "\n";
								
		
		return informacionLibro;
	
	}
	
	
	public String getNombreVideojuego() {
		return nombreVideojuego;
	}

	public void setNombreVideojuego(String nombreVideojuego) {
		this.nombreVideojuego = nombreVideojuego;
	}

	public String getPlataformaVideojuego() {
		return plataformaVideojuego;
	}

	public void setPlataformaVideojuego(String plataformaVideojuego) {
		this.plataformaVideojuego = plataformaVideojuego;
	}
	
	
}
