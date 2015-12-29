package com.client;

import com.client.service.EquipoRivalService;
import com.client.service.EquipoRivalServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;

public class PanelAltaEquipoRival extends DialogBox {

	private final TextBox txtNombre = new TextBox();
	
	private final EquipoRivalServiceAsync service = GWT
	.create(EquipoRivalService.class);
	
	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	
	private final Button btnAceptar = new Button("Aceptar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			
			guardarEquipoRival(txtNombre.getText());
			hide();
		}
	});
	


	public PanelAltaEquipoRival() {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Agregar Equipo rival");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		
		final FlexTable contenido = new FlexTable();
		
		contenido.setCellSpacing(12);
		contenido.setCellPadding(0);
		contenido.setText(0, 0, "Nombre:");
		contenido.setWidget(0, 1, txtNombre);
		contenido.setWidget(2, 1, btnAceptar);
		contenido.setWidget(2, 2, btnCerrar);
	
		// Asigna el contenido.
		setWidget(contenido);
	}
	
	void guardarEquipoRival(String nombreEquipo){
		
		service.guardar(nombreEquipo, new AsyncCallback<Boolean>() {

			public void onFailure(Throwable caught) {
				// FIXME
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Boolean resultadoCorrecto) {
				
				if(resultadoCorrecto){
					Window.alert("OK!");
				}else{
					Window.alert("El equipo rival ya existe!");
				}
				
			}
		});
	}
	
	
}