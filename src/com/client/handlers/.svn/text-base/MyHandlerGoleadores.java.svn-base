package com.client.handlers;

import com.client.PanelTablaGoleadores;
import com.client.PopUpCarga;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class MyHandlerGoleadores implements ClickHandler, KeyUpHandler {
	/**
	 * Fired when the user clicks on the sendButton.
	 */
	public void onClick(ClickEvent event) {
		mostrarTablaHistorica();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			mostrarTablaHistorica();
		}
	}

	/**
	 * Muestra la tabla historica.
	 */
	private void mostrarTablaHistorica() {
	    
		final PanelTablaGoleadores dialogo = new PanelTablaGoleadores();      
		dialogo.center();
		
		         
	}

}
