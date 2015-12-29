package com.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;

public class PanelImagenAmpliada extends DialogBox {

	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	

	public PanelImagenAmpliada() {

	}
	
	public PanelImagenAmpliada(String nombreImagen) {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		//setText("Titulo");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		
		Image imagen = new Image(nombreImagen);	    
	    imagen.setSize("500px", "430px");
		
		final FlexTable contenido = new FlexTable();
		
		contenido.setWidget(1, 1, imagen);
		contenido.setWidget(2, 1, btnCerrar);
		
        contenido.getFlexCellFormatter().setAlignment(2, 1, HasHorizontalAlignment.ALIGN_RIGHT , HasVerticalAlignment.ALIGN_MIDDLE );

		
	
		// Asigna el contenido.
		setWidget(contenido);
	}		
	
}