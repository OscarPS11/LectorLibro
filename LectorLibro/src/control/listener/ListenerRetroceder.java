package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import control.accion.LectorBridge;
import modelo.Libro;

public class ListenerRetroceder implements ActionListener {
	private LectorBridge puente;
	private JTextArea textArea;
	private JLabel lblNumeroPagina;

	public ListenerRetroceder(LectorBridge puente, JTextArea textArea, JLabel lblNumeroPagina) {
		this.puente = puente;
		this.textArea = textArea;
		this.lblNumeroPagina = lblNumeroPagina;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (puente.getLibro().getTamaño()!=0) {
		puente.getLibro().retrocederPagina();
		textArea.setText(puente.getLibro().getCadena());
		lblNumeroPagina.setText(String.valueOf(puente.getLibro().getActual()));
		}
	}
}
