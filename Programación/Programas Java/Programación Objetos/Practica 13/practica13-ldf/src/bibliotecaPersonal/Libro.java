package bibliotecaPersonal;


public class Libro implements Coleccionable{

	private String tipoColeccionable;
	private String tituloLibro;
	private String autorLibro;
	private String editorialLibro;
	private int numeroPaginasLibro;
	
	
	
	public Libro(String tituloLibro, String autorLibro, String editorialLibro, int numeroPaginasLibro) {
		this.tipoColeccionable = LIBRO;
		this.tituloLibro = tituloLibro;
		this.autorLibro = autorLibro;
		this.editorialLibro = editorialLibro;
		this.numeroPaginasLibro = numeroPaginasLibro;
	}
	
	@Override
	public String mostrar() {
		
		String informacionLibro = "Tipo de coleccionable: " + this.tipoColeccionable + "\n"
								+ "Titulo: " + getTituloLibro() + "\n"
								+ "Autor: " + getAutorLibro() + "\n"
								+ "Editorial: " + getEditorialLibro() + "\n"
								+ "Numero Paginas: " + getNumeroPaginasLibro();
		
		return informacionLibro;
	
	}
	
	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public String getEditorialLibro() {
		return editorialLibro;
	}

	public void setEditorialLibro(String editoralLibro) {
		this.editorialLibro = editoralLibro;
	}

	public int getNumeroPaginasLibro() {
		return numeroPaginasLibro;
	}

	public void setNumeroPaginasLibro(int numeroPaginasLibro) {
		this.numeroPaginasLibro = numeroPaginasLibro;
	}
	
}
