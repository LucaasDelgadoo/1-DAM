package bibliotecaPersonal;


public class SerieTv implements Coleccionable {

	private String tipoColeccionable;
	private String nombreSerie;
	int numeroTemporadas;
	int numeroCapitulos;
	
	

	public SerieTv(String nombreSerie, int numeroTemporadas, int numeroCapitulos) {
		this.tipoColeccionable = SERIE_TV;
		this.nombreSerie = nombreSerie;
		this.numeroTemporadas = numeroTemporadas;
		this.numeroCapitulos = numeroCapitulos;
	}

	@Override
	public String mostrar() {
		
		String informacionLibro = "Tipo de coleccionable: " + this.tipoColeccionable + "\n"
								+ "Titulo: " + getNombreSerie() + "\n"
								+ "Numero temporadas: " + getNumeroTemporadas() + "\n"
								+ "Numero de capitulos por temporada: " + getNumeroCapitulos() + "\n";
		
		return informacionLibro;
	
	}
	
	
	public String getNombreSerie() {
		return nombreSerie;
	}

	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public int getNumeroCapitulos() {
		return numeroCapitulos;
	}

	public void setNumeroCapitulos(int numeroCapitulos) {
		this.numeroCapitulos = numeroCapitulos;
	}
	

}
