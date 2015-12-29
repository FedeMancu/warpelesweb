package com.client.handlers;

import com.client.PanelImagenAmpliada;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class MyHandlerAmpliarImagen implements ClickHandler, KeyUpHandler {
	
	private String nombreImagen="";
	
	/**
	 * Fired when the user clicks on the sendButton.
	 */
	public void onClick(ClickEvent event) {
		mostrarImagenAmpliada(nombreImagen);
	}
	

	private void mostrarImagenAmpliada(String nombreImagen) {
		final PanelImagenAmpliada dialogo = new PanelImagenAmpliada(nombreImagen); 
		dialogo.center();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			mostrarImagenAmpliada(nombreImagen);
		}
	}
	
	

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}


}