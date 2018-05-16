package modelo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Libro implements Legible {

	private String lectura;
	private int actual = 0;
	private int marca = 0;
	private ArrayList<Pagina> paginas;
	private File ruta;
	public FileReader flujoR;
	private int numCaracteres = 1000;
	private char[] letras = new char[numCaracteres];
	private String cadena;
	private FileOutputStream flujoW = null;
	private DataOutputStream conversorW = null;
	private int tama�o = 0;
	private int temporal;
	private int paginaTemporal;

	public Libro() {
		super();
		lectura = "libro//JuegoTronos.txt";
		paginas = new ArrayList<>();
		ruta = new File(lectura);
	}

	@Override
	public void avanzarPagina() {
		if (!comprobarUltimaPagina()) {
			cargarSiguientePagina();
		}
	}

	private void cargarSiguientePagina() {
		this.actual++;
		this.paginas.add(new Pagina(actual, tama�o));
		try {
			flujoR = new FileReader(getRuta());
			aumentarTama�o();
			flujoR.skip(tama�o);
			flujoR.read(letras);
			cadena = new String(letras);
			flujoR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("no existe el archivo");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error de acceso de lectura");
		}
	}

	private boolean comprobarUltimaPagina() {
			return false;
	}

	@Override
	public void retrocederPagina() {
		if (!comprobarUltimaPagina()) {
			cargarAnteriorPagina();
		}
	}

	private void cargarAnteriorPagina() {
		this.actual--;
		try {
			flujoR = new FileReader(getRuta());
			disminuir();
			flujoR.skip(tama�o);
			flujoR.read(letras);
			cadena = new String(letras);
			flujoR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("no existe el archivo");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error de acceso de lectura");
		}

	}

	@Override
	public void marcarPagina() {
		temporal=getTama�o();
		paginaTemporal=getActual();
	}

	@Override
	public void irAMarca() {
		try {
			actual=getPaginaTemporal();
			tama�o=getTemporal();
			flujoR = new FileReader(getRuta());
			flujoR.skip(tama�o);
			flujoR.read(letras);
			cadena = new String(letras);
			flujoR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("no existe el archivo");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error de acceso de lectura");
		}
	}

	public int getTemporal() {
		return this.temporal;
	}

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getMarca() {
		return marca;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}

	public FileReader getFlujoR() {
		return flujoR;
	}

	public char[] getLetras() {
		return this.letras;
	}

	public String getCadena() {
		return this.cadena;
	}

	public FileOutputStream getFlujoW() {
		return flujoW;
	}

	public DataOutputStream getConversorW() {
		return conversorW;
	}

	public File getRuta() {
		return ruta;
	}

	private void aumentarTama�o() {
		this.tama�o = this.tama�o + 1000;
	}

	private void disminuir() {
		this.tama�o = this.tama�o - 1000;
	}

	public int getTama�o() {
		return this.tama�o;
	}
	
	public int getPaginaTemporal() {
		return paginaTemporal;
	}
}
