package practica14;

public class Comodin {

	private String nombreComodin;
	private boolean esUsado = false;
	
	public Comodin(String nombreComodin, boolean esUsado) {
		this.nombreComodin = nombreComodin;
		this.esUsado = esUsado;
	}

	public void usar() {
        this.esUsado = false;
    }
	
	
	public String getNombreComodin() {
		return nombreComodin;
	}

	public void setNombreComodin(String nombreComodin) {
		this.nombreComodin = nombreComodin;
	}

	public boolean isEsUsado() {
		return esUsado;
	}

	public void setEsUsado(boolean esUsado) {
		this.esUsado = esUsado;
	}
	
	

	
}
