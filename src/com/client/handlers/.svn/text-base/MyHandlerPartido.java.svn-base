package com.client.handlers;

import com.client.PanelAltaPartido;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class MyHandlerPartido implements ClickHandler, KeyUpHandler {
	/**
	 * Fired when the user clicks on the sendButton.
	 */
	public void onClick(ClickEvent event) {
		mostrarAltaPartido();
	}

	private void mostrarAltaPartido() {
		final PanelAltaPartido dialogo = new PanelAltaPartido(); 
		dialogo.center();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			mostrarAltaPartido();
		}
	}

}