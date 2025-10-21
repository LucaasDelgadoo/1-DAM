package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FicherosApp {

	public static void main(String[] args) {
		
		File fichero = new File("C:\\Users\\lucas.delfer\\Desktop\\fichero.txt");
		try {
			FileWriter fw = new FileWriter(fichero);
			fw.write("Estoy haciendo una prueba");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
				

	}

}
