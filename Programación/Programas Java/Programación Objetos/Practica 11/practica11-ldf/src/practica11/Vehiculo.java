package practica11;

public class Vehiculo {

	public static final int PRECIO_POR_DEFECTO = 12000;
	public static final String COLOR_POR_DEFECTO = "Blanco";
	public static final String GAMA_POR_DEFECTO = "Media";
	public static final int PESO_POR_DEFECTO = 1500;
	public static final String[] COLORES_DISPONIBLES = { "blanco", "negro", "rojo", "azul", "verde", "gris" };
	public static final String[] GAMAS_DISPONIBLES = { "baja", "media", "alta" };
	public static final int VALOR_GAMA_ALTA = 2000;
	public static final int VALOR_GAMA_MEDIA = 1200;
	public static final int VALOR_GAMA_BAJA = 600;
	public static final int VALOR_PESO_MENOR_DE_1200 = 0;
	public static final int VALOR_PESO_ENTRE_1200_Y_1400 = 350;
	public static final int VALOR_PESO_ENTRE_1400_Y_1800 = 1000;
	public static final int VALOR_PESO_SUPERIOR_A_1800 = 1500;
	
	
	private int precioBase;
	private String color;
	private String gama;
	private int peso;
	
	public Vehiculo () {
		this.precioBase = PRECIO_POR_DEFECTO;
		this.color = COLOR_POR_DEFECTO;
		this.gama = GAMA_POR_DEFECTO;
		this.peso = PESO_POR_DEFECTO;
	}
	
	public Vehiculo (int precio, int peso) {
		this.precioBase = precio;
		this.peso = peso;
		this.color = COLOR_POR_DEFECTO;
		this.gama = GAMA_POR_DEFECTO;
		
	}
	
	public Vehiculo (int precioBase, String color, String gama, int peso) {
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.gama = comprobarGama(gama);
		this.peso = peso;
	}

	public String getInfo() {
		String info = "Precio " + this.precioBase + " € \n"
				+ "Color " + this.color + "\n"
				+ "Gama " + this.gama + "\n"
				+ "Peso " + this.peso + " Kg";
		return info;
	}
	
	private String comprobarGama (String gama) {
		for (String g : GAMAS_DISPONIBLES) {
			if (gama.equalsIgnoreCase(g)) {
				return g;
			}
		}
		
		return GAMA_POR_DEFECTO;
	}	
	
	private String comprobarColor (String color) {
		for (String c : COLORES_DISPONIBLES) {
			if (color.equalsIgnoreCase(c)) {
				return c;
			}
		}
		
		return COLOR_POR_DEFECTO;
	}	
	
	public int precioFinal () {
		
		int precioFinalTotal = 0;
		int precioFinalGama = 0;
		int precioFinalPeso = 0;
		int suplementoGama = 0;
		int suplementoPeso = 0;
		
		if (this.gama.equalsIgnoreCase("Alta")) {
			
			suplementoGama = VALOR_GAMA_ALTA;
			
		} else if (this.gama.equalsIgnoreCase("Media")) {
			
			suplementoGama = VALOR_GAMA_MEDIA;
			
		} else if (this.gama.equalsIgnoreCase("Baja")) {
			
			
			suplementoGama = VALOR_GAMA_BAJA;
		}
		
		precioFinalGama = this.precioBase + suplementoGama;
		
		
		if (this.peso < 1200) {
			
			suplementoPeso =  VALOR_PESO_MENOR_DE_1200;
			
		} else if (this.peso >= 1200 && this.peso < 1400) {
			
			suplementoPeso =  VALOR_PESO_ENTRE_1200_Y_1400;
			
		} else if (this.peso >= 1400 && this.peso < 1800) {
			
			suplementoPeso = VALOR_PESO_ENTRE_1400_Y_1800;
			
		} else if (this.peso >= 1800) {
			
			suplementoPeso =  VALOR_PESO_SUPERIOR_A_1800;
			
		}
		
		precioFinalPeso = this.precioBase + suplementoPeso;
		
		precioFinalTotal = precioFinalGama + precioFinalPeso;

		return precioFinalTotal;
	}
	
	public String toString() {
		String mensajePrecioFinal = "El vehiculo se ha dado de alta con un precio final de: " + this.precioFinal() + " €";
		return mensajePrecioFinal;
	}

	public int getPrecioBase() {
		return precioBase;
	}

	public String getColor() {
		return color;
	}

	public String getGama() {
		return gama;
	}

	public int getPeso() {
		return peso;
	}

	
	
	
	
	
	
	
	
	
}
