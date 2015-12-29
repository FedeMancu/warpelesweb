package com.client;

import com.client.service.PartidoService;
import com.client.service.PartidoServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;

public class PanelCargaInicial  extends DialogBox {

	
	private final PartidoServiceAsync service = GWT
	.create(PartidoService.class);
	
	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	
	private final Button btnCargaInicial = new Button("Carga inicial", new ClickHandler() {
		public void onClick(ClickEvent event) {
			
			realizarCargaInicial();
			hide();
		}
	});
	


	public PanelCargaInicial() {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Realizar carga inicial");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		
		final FlexTable contenido = new FlexTable();
		
		contenido.setCellSpacing(12);
		contenido.setCellPadding(0);
		contenido.setWidget(2, 1, btnCargaInicial);
		contenido.setWidget(2, 2, btnCerrar);
	
		// Asigna el contenido.
		setWidget(contenido);
	}
	
	void realizarCargaInicial(){
		
		service.realizarCarga(new AsyncCallback<Boolean>() {

			public void onFailure(Throwable caught) {
				// FIXME
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Boolean resultadoCorrecto) {
				
				if(resultadoCorrecto){
					Window.alert("OK!");
				}else{
					Window.alert("Error al realizar la carga inicial");
				}
				
			}
		});
	}
	

}
