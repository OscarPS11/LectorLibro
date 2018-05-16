package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import control.accion.LectorBridge;
import modelo.Libro;

public class ListenerAvanzar implements ActionListener {
	LectorBridge puente;
	JTextArea textArea;
	JLabel lblNumeroPagina;

	public ListenerAvanzar(LectorBridge puente, JTextArea textArea, JLabel lblNumeroPagina) {
		this.puente = puente;
		this.textArea = textArea;
		this.lblNumeroPagina= lblNumeroPagina;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getLibro().avanzarPagina();
		textArea.setText(puente.getLibro().getCadena());
		lblNumeroPagina.setText(String.valueOf(puente.getLibro().getActual()));
	}

}
