package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class sawsda {
	private static final String ruta = "libro/JuegoTronos.txt";
	private static final int tamano = 1000;

	public static void main(String[] args) {
		FileReader flujoR = null;
		char[] letras = new char[tamano];
		File rutaEnFile = new File(ruta);
		if (rutaEnFile.exists()) {
			try {
				flujoR = new FileReader(rutaEnFile);
				flujoR.read(letras);
				String dos=new String(letras);
				System.out.println(dos);
				flujoR.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("no existe el archivo");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error de acceso de lectura");
			}
		}

	}
	
	
}