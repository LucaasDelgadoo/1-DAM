package practica11;

public class Coche extends Vehiculo {

	public static final int POTENCIA_POR_DEFECTO = 110;
	public static final int VALOR_POTENCIA_SUPERIOR = 110;
	
	private int potencia;

	public Coche () {
		super();
		this.potencia = POTENCIA_POR_DEFECTO;
	}
	
	public Coche (int peso, int precio) {
		super(peso, precio);
		this.potencia = POTENCIA_POR_DEFECTO;
	}
	
	public Coche (int precioBase, String color, String gama, int peso, int potencia) {
		super(precioBase, color, gama, peso);
		this.potencia = potencia;
	}

	public int getPotencia() {
		return potencia;
	}

	@Override
	public int precioFinal () {
		
		int precioFinalTotal = 0;
		int precioFinalGama = 0;
		int precioFinalPeso = 0;
		int precioFinalPotencia = 0;
		int suplementoGama = 0;
		int suplementoPeso = 0;
		int suplementoPotencia = 0;
		
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
		
		if (getPotencia() > POTENCIA_POR_DEFECTO) {
			
			suplementoPotencia = VALOR_POTENCIA_SUPERIOR;
			
		} else if (getPotencia() <= POTENCIA_POR_DEFECTO) {
			
			suplementoPotencia = 0;
		}
		
		precioFinalPotencia = this.getPrecioBase() + suplementoPotencia;
		
		precioFinalTotal = precioFinalGama + precioFinalPeso + precioFinalPotencia;

		return precioFinalTotal;
	}
	
	@Override
	public String getInfo() {
		String info = "Precio " + this.getPrecioBase() + " € \n"
				+ "Color " + getColor() + "\n"
				+ "Gama " + getGama() + "\n"
				+ "Peso " + getPeso() +  " Kg \n"
				+ "Potencia " + getPotencia() + " CV \n";
				
		return info;
	}

	@Override
	public String toString() {
		String mensajePrecioFinal = "El coche se ha dado de alta con un precio final de: " + this.precioFinal() + " €";
		return mensajePrecioFinal;
	}
	
	
}
