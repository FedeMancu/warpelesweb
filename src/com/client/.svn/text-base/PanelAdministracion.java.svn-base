package com.client;

import com.client.handlers.MyHandlerCargaInicial;
import com.client.handlers.MyHandlerEquipoRival;
import com.client.handlers.MyHandlerJugador;
import com.client.handlers.MyHandlerPartido;
import com.client.service.PartidoService;
import com.client.service.PartidoServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class PanelAdministracion extends DialogBox {
	
	private final PartidoServiceAsync service = GWT
	.create(PartidoService.class);
	
	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});

	@SuppressWarnings("deprecation")
	public PanelAdministracion() {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Panel de Administracion");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		
		final Button botonCargarEquipoRival=new Button();
		botonCargarEquipoRival.setText("Cargar Equipo Rival");
		final Button botonCargarJugador=new Button();
		final Button botonCargarPartido=new Button();
		botonCargarPartido.setText("Cargar partido");
		botonCargarJugador.setText("Cargar Jugador");
		final Button botonCargaInicial=new Button();
		botonCargaInicial.setText("Carga Inicial");
		final Button botonBorrarBase=new Button();
		botonBorrarBase.setText("Borar base de datos");
		
		MyHandlerEquipoRival handlerEquipos = new MyHandlerEquipoRival();
		MyHandlerJugador handlerJugador = new MyHandlerJugador();
		MyHandlerPartido handlerPartido = new MyHandlerPartido();
		MyHandlerCargaInicial handlerCargaInicial=new MyHandlerCargaInicial();

		botonCargarEquipoRival.addClickHandler(handlerEquipos);		
		botonCargarJugador.addClickHandler(handlerJugador);
		botonCargarPartido.addClickHandler(handlerPartido);
		botonCargaInicial.addClickHandler(handlerCargaInicial);
		
		botonBorrarBase.addClickListener(new ClickListener() {
			
			@Override
			public void onClick(Widget sender) {
				service.borrarBase(new AsyncCallback<Boolean>() {

					public void onFailure(Throwable caught) {
						// FIXME
						Window.alert(caught.getMessage());				
					}

					public void onSuccess(Boolean resultadoCorrecto) {
						
						if(resultadoCorrecto){
							Window.alert("Se borro toda la base carajo!!");
						}else{
							Window.alert("No se borro nada");
						}
						
					}
				});				
			}
		});
		

		
		final FlexTable contenido = new FlexTable();
		
		contenido.setCellSpacing(5);
		contenido.setCellPadding(0);

		contenido.setWidget(1, 1, botonCargarJugador);
		contenido.setWidget(2, 1, botonCargarEquipoRival);
		contenido.setWidget(3, 1, botonCargarPartido);
		contenido.setWidget(4, 1, botonCargaInicial);
		contenido.setWidget(5, 1, botonBorrarBase);


		contenido.setWidget(7, 2, btnCerrar);
	
		// Asigna el contenido.
		setWidget(contenido);
	}
	
}
