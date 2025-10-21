package usoFechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EjemploFechas {

	public static void main(String[] args) {
		
		//se pueden guardar tambien en un objeto de cada tipo de LOCAL ____ (date, time, dateTime)
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		
		LocalDate fecha = LocalDate.of(2005, Month.JULY, 14);
		System.out.println(fecha);
	
		System.out.println(fecha.getDayOfYear());
		System.out.println(LocalDate.of(2025, Month.JULY, 1).getDayOfYear());
		
		DateTimeFormatter formatoEnEspañol = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' HH:mm:ss").withLocale(new Locale("es", "ES"));
		System.out.println(LocalDateTime.now().format(formatoEnEspañol));
		
	}

}
