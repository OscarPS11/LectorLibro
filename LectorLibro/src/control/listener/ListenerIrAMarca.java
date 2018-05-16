package control.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import control.accion.LectorBridge;

public class ListenerIrAMarca implements ActionListener {
	LectorBridge puente;
	JTextArea textArea;

	public ListenerIrAMarca(LectorBridge puente, JTextArea textArea) {
		this.puente = puente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText(puente.getLibro().getTemporal());
	}

}
