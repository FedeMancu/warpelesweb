package com.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;



public class PopUpCarga extends PopupPanel {

	public PopUpCarga() {
		
		super(false, true);
		// Asigna el contenido.
		setWidget(new Image("loading29.gif"));
		// Realiza una animaci�n al abrir o cerrar el di�logo.
		setAnimationEnabled(true);
	}
}