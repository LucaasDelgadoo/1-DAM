package practica11;

public class Furgoneta extends Vehiculo {

	public static final double CAPACIDAD_POR_DEFECTO = 6.5; //metros cubicos
	public static final boolean ELECTRICO_POR_DEFECTO = false;
	public final double VALOR_CAPACIDAD_SUPERIOR = (getPrecioBase() * (3/10)); //metros cubicos
	public static final int VALOR_POR_SER_ELECTRICA = 2850;

	private double capacidadCarga; //metros cubicos
	private boolean electrico;
	
	public Furgoneta () {
		super();
		this.capacidadCarga = CAPACIDAD_POR_DEFECTO;
		this.electrico = ELECTRICO_POR_DEFECTO;
	}
	
	public Furgoneta (int peso, int precio) {
		super(peso, precio);
		this.capacidadCarga = CAPACIDAD_POR_DEFECTO;
		this.electrico = ELECTRICO_POR_DEFECTO;
	}
	
	public Furgoneta (int precioBase, String color, String gama, int peso, double capacidadCarga, int electrico) {
		super(precioBase, color, gama, peso);
		this.capacidadCarga = capacidadCarga;
		this.electrico = comprobarElectrica(electrico);
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public boolean isElectrico() {
		return electrico;
	}

	@Override
	public int precioFinal () {
		
		int precioFinalTotal = 0;
		int precioFinalGama = 0;
		int precioFinalPeso = 0;
		int precioFinalCarga = 0;
		int precioFinalElectrico = 0;
		int suplementoGama = 0;
		int suplementoPeso = 0;
		double suplementoCarga = 0;
		int suplementoElectrica = 0;
		
		if (this.getGama().equalsIgnoreCase("Alta")) {
			
			suplementoGama = VALOR_GAMA_ALTA;
			
		} else if (this.getGama().equalsIgnoreCase("Media")) {
			
			suplementoGama = VALOR_GAMA_MEDIA;
			
		} else if (this.getGama().equalsIgnoreCase("Baja")) {
			
			
			suplementoGama = VALOR_GAMA_BAJA;
		}
		
		precioFinalGama = this.getPrecioBase() + suplementoGama;
		
		
		if (this.getPeso() < 1200) {
			
			suplementoPeso = VALOR_PESO_MENOR_DE_1200;
			
		} else if (this.getPeso() >= 1200 && this.getPeso() < 1400) {
			
			suplementoPeso = VALOR_PESO_ENTRE_1200_Y_1400;
			
		} else if (this.getPeso() >= 1400 && this.getPeso() < 1800) {
			
			suplementoPeso = VALOR_PESO_ENTRE_1400_Y_1800;
			
		} else if (this.getPeso() >= 1800) {
			
			suplementoPeso = VALOR_PESO_SUPERIOR_A_1800;
			
		}
		
		precioFinalPeso = this.getPrecioBase() + suplementoPeso;
		
		
		if (this.getCapacidadCarga() > 7.5 ) {
			
			suplementoCarga = VALOR_CAPACIDAD_SUPERIOR;
			
		} else if (this.getCapacidadCarga() <= 7.5) {
			
			suplementoCarga = 0;;
			
		}
		
		precioFinalCarga = (int) (this.getPrecioBase() + suplementoCarga);
		
		
		if (this.isElectrico() == true) {
			
			suplementoElectrica = VALOR_POR_SER_ELECTRICA;
			
		} else if (this.isElectrico() == false) {
			
			suplementoElectrica = 0;
			
		}
		
		precioFinalElectrico = this.getPrecioBase() + suplementoElectrica;
		
		precioFinalTotal = precioFinalGama + precioFinalPeso + precioFinalCarga + precioFinalElectrico;

		return precioFinalTotal;
	}
	
	@Override
	public String getInfo() {
		String info = "Precio " + getPrecioBase() + " € \n"
				+ "Color " + getColor() + "\n"
				+ "Gama " + getGama() + "\n"
				+ "Peso " + getPeso() + " Kg \n"
				+ "Capacidad Carga " + getCapacidadCarga() + " m3 \n"
				+ "Electrica " + isElectrico();
				
		return info;
	}
	
	public boolean comprobarElectrica (int seleccion) {
		boolean electricidad = false;
		
		if (seleccion == 0) {
			electricidad = true;
		} else if (seleccion == 1) {
			electricidad = false;
		}
		
		return electricidad;
		
	}
	
	@Override
	public String toString() {
		String mensajePrecioFinal = "La furgoneta se ha dado de alta con un precio final de: " + this.precioFinal() + " €";
		return mensajePrecioFinal;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
