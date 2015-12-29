package com.client.handlers;

import com.client.PanelImagenes;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class MyHandlerImagenes implements ClickHandler, KeyUpHandler {
	/**
	 * Fired when the user clicks on the sendButton.
	 */
	public void onClick(ClickEvent event) {
		mostrarPanelImagenes();
	}

	private void mostrarPanelImagenes() {
		final PanelImagenes dialogo = new PanelImagenes();      
		dialogo.center();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			mostrarPanelImagenes();
		}
	}

}

