package ficheros;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FicherosApp {

    public static void main(String[] args) {
    	
        try {
        	
            File directorioActual;
            
            if (args.length > 0) {
            	
                directorioActual = new File(args[0]);
                
            } else {
            	
                directorioActual = new File(".");
                
            }
            
            if (!directorioActual.exists()) {
            	
                System.out.println("El directorio o fichero especificado no existe.");
                
                return;
                
            }

            if (directorioActual.isFile()) {
            	
                manejarComoArchivo(directorioActual);
                
            } else {
            	
                boolean incluirSubdirectorios = false;
                
                if (args.length > 1) {
                	
                    if (args[1].equals("-all")) {
                    	
                        incluirSubdirectorios = true;
                        
                    }
                    
                }
                
                listarDirectorio(directorioActual, incluirSubdirectorios);
                
            }
            
        } catch (Exception e) {
        	
            System.err.println("Se produjo un error inesperado: " + e.getMessage());
            
        }
        
    }

    private static void manejarComoArchivo(File archivo) {
    	
        if (archivo.exists()) {
        	
            if (archivo.isFile()) {
            	
            	double tamanioArchivo = archivo.length();
            	
                double tamanioEnKB = tamanioArchivo / 1024;
                
                System.out.println("Es un fichero.");
                
                
                System.out.println("Tamaño en bytes: " + tamanioArchivo);
                
                System.out.println("Tamaño aproximado en kB: " + tamanioEnKB + " kB.");
                
            } else {
            	
                System.out.println("El archivo especificado no es un fichero regular.");
                
            }
            
        } else {
        	
            System.out.println("El archivo no existe.");
            
        }
        
    }

    private static void listarDirectorio(File directorio, boolean incluirSubdirectorios) throws IOException {
    	
        System.out.println("Procesando el directorio...");
        
        System.out.println("Directorio: " + directorio.getAbsolutePath());

        File[] listaArchivos = directorio.listFiles();
        
        if (listaArchivos != null) {
        	
            long espacioTotal = 0;

            for (File archivo : listaArchivos) {
            	
                if (archivo.isDirectory()) {
                	
                    String infoDirectorio = formatearInformacionArchivo(archivo);
                    
                    System.out.println(infoDirectorio + "/");
                    
                    if (incluirSubdirectorios) {
                    	
                        listarDirectorio(archivo, false);
                        
                    }
                    
                } else {
                	
                    String infoArchivo = formatearInformacionArchivo(archivo);
                    
                    double tamanioArchivo = archivo.length();
                    
                    double tamanioKB = tamanioArchivo / 1024;
                    
                    espacioTotal += tamanioArchivo;
                    
                    System.out.println(infoArchivo + " " + tamanioKB + " kB");
                    
                }
                
            }

            long espacioTotalMB = espacioTotal / (1024 * 1024);
            
            System.out.println("Espacio total ocupado por los archivos en el directorio: " + espacioTotalMB + " MB");
            

            crearArchivoResumen(directorio, listaArchivos);
            
        } else {
        	
            System.out.println("El directorio está vacío o no se pudo acceder a él.");
            
        }
        
    }

    private static String formatearInformacionArchivo(File archivo) {
    	
        String permisos = obtenerPermisosArchivo(archivo);
        
        String nombreArchivo = archivo.getName();
        
        Date fechaUltimaModificacion = new Date(archivo.lastModified());
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        String fechaFormateada = formatoFecha.format(fechaUltimaModificacion);
        
        return "[" + permisos + "] " + nombreArchivo + " (" + fechaFormateada + ")";
        
    }

    private static String obtenerPermisosArchivo(File archivo) {
    	
        String permisosLectura = archivo.canRead() ? "r" : "-";
        
        String permisosEscritura = archivo.canWrite() ? "w" : "-";
        
        String permisosEjecucion = archivo.canExecute() ? "x" : "-";
        
        return permisosLectura + permisosEscritura + permisosEjecucion;
        
    }

    private static void crearArchivoResumen(File directorio, File[] listaArchivos) {
        try {
            String nombreArchivo = "Resumen_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".txt";
            
            File archivoResumen = new File(directorio, nombreArchivo);
            
            try (PrintWriter escritor = new PrintWriter(archivoResumen)) {
            	
                escritor.println("Directorio: " + directorio.getAbsolutePath());
                
                escritor.println("Lista de contenidos:");
                
                for (File archivo : listaArchivos) {
                	
                    String tipo = archivo.isDirectory() ? "DIRECTORIO" : "FICHERO";
                    
                    escritor.println(tipo + ": " + archivo.getName());
                    
                }
                
            }
            
            System.out.println("Archivo resumen creado: " + archivoResumen.getAbsolutePath());
            
        } catch (IOException e) {
        	
            System.err.println("Error al crear el archivo resumen: " + e.getMessage());
            
        }
        
    }
    
}
