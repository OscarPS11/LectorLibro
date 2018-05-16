package control.accion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import control.listener.ListenerAvanzar;
import control.listener.ListenerIrAMarca;
import control.listener.ListenerMarca;
import control.listener.ListenerRetroceder;
import modelo.Libro;
import vista.LectorUI;

public class LectorBridge extends LectorUI {
	private Libro libro;
	private ListenerAvanzar listenerAvanzar;
	private ListenerRetroceder listenerRetroceder;
	private ListenerMarca listenerMarcar;
	private ListenerIrAMarca listenerIrAMarca;

	
	
	public LectorBridge() {
		super();
		this.libro = new Libro();
		iniciar();
		this.listenerAvanzar = new ListenerAvanzar(this, this.textArea, this.lblNumeroPagina);
		this.btnAlante.addActionListener(listenerAvanzar);
		this.listenerRetroceder = new ListenerRetroceder(this, this.textArea,this.lblNumeroPagina);
		this.btnAtras.addActionListener(listenerRetroceder);
		this.listenerMarcar= new ListenerMarca(this, this.textArea);
		this.btnMarcar.addActionListener(listenerMarcar);
		this.listenerIrAMarca= new ListenerIrAMarca(this, this.textArea,this.lblNumeroPagina);
		this.btnIrAMarca.addActionListener(listenerIrAMarca);
	}

	private void iniciar() {
		if (libro.getRuta().exists()) {
			try {
				libro.flujoR = new FileReader(libro.getRuta());
				libro.getFlujoR().read(libro.getLetras());
				String dos = new String(libro.getLetras());
				this.textArea.setText(dos);
				libro.getFlujoR().close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("no existe el archivo");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error de acceso de lectura");
			}
		}
	}

	public Libro getLibro() {
		return libro;
	}

}
