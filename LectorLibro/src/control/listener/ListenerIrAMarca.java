package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import control.accion.LectorBridge;

public class ListenerIrAMarca implements ActionListener {
	LectorBridge puente;
	JTextArea textArea;
	JLabel lblNumeroPagina;

	public ListenerIrAMarca(LectorBridge puente, JTextArea textArea, JLabel lblNumeroPagina) {
		this.puente = puente;
		this.textArea = textArea;
		this.lblNumeroPagina = lblNumeroPagina;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		puente.getLibro().irAMarca();
		textArea.setText(puente.getLibro().getCadena());
		lblNumeroPagina.setText(String.valueOf(puente.getLibro().getActual()));
	}

}
