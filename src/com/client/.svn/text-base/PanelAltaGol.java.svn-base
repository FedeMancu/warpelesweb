package com.client;

import java.util.ArrayList;

import com.client.service.EquipoRivalService;
import com.client.service.EquipoRivalServiceAsync;
import com.client.service.GolService;
import com.client.service.GolServiceAsync;
import com.client.service.JugadorService;
import com.client.service.JugadorServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.shared.modelo.EquipoRival;
import com.shared.modelo.Jugador;

public class PanelAltaGol extends DialogBox {

	
	private final TextBox txtNombre = new TextBox();
		  
			 		
	private  GolServiceAsync serviceGol = GWT
	.create(GolService.class);
	
	private  EquipoRivalServiceAsync serviceEquipoRival = GWT
	.create(EquipoRivalService.class);
	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	
	private final Button btnAceptar = new Button("Aceptar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			
			guardarGol(txtNombre.getText());
			hide();
		}
	});
	
	private ValueListBox<Jugador> jugadores = new ValueListBox<Jugador>(new JugadorRenderer());
	
	private ValueListBox<EquipoRival> equiposRivales = new ValueListBox<EquipoRival>(new EquipoRenderer());


	public PanelAltaGol() {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Agregar Gol");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		
		final FlexTable contenido = new FlexTable();
		
		cargarJugadores();
		cargarEquiposRivales();
			
		contenido.setCellSpacing(12);
		contenido.setCellPadding(0);
		contenido.setText(0, 0, "Jugador:");
		contenido.setWidget(0, 1, jugadores);
		contenido.setText(1, 0, "Equipo:");
		contenido.setWidget(1, 1, equiposRivales);
		contenido.setWidget(3, 1, btnAceptar);
		contenido.setWidget(3, 2, btnCerrar);
		
		// Asigna el contenido.
		setWidget(contenido);
	}
	

	private void cargarJugadores() {
		
		JugadorServiceAsync serviceJugador = GWT.create(JugadorService.class);
		
		serviceJugador.obtenerJugadores(new AsyncCallback<ArrayList<Jugador>>() {

			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			public void onSuccess(ArrayList<Jugador> result) {
				jugadores.setAcceptableValues(result);
			}
		});
	}


	void guardarGol(String nombreJugador) {

		serviceGol.guardar(nombreJugador, new AsyncCallback<Boolean>() {

			public void onFailure(Throwable caught) {
				// FIXME
				Window.alert(caught.getMessage());
			}

			public void onSuccess(Boolean result) {
				// FIXME
				Window.alert("OK!");

			}
		});
	}

	static final class JugadorRenderer extends AbstractRenderer<Jugador> {
        public String render(Jugador jugador) {
          if (jugador == null) {
            return "";
          } else {
            return jugador.getNombre();
          }	   
        }
 		}
	
	static final class EquipoRenderer extends AbstractRenderer<EquipoRival> {
        public String render(EquipoRival equipo) {
          if (equipo == null) {
            return "";
          } else {
            return equipo.getNombre();
          }	   
        }
 		}
	

	private void cargarEquiposRivales() {

	//	EquipoRivalServiceAsync serviceEquipoRival = GWT.create(EquipoRivalService.class);

		serviceEquipoRival.obtenerEquiposRivales(new AsyncCallback<ArrayList<EquipoRival>>() {

					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					public void onSuccess(ArrayList<EquipoRival> result) {
						equiposRivales.setAcceptableValues(result);
					}
				});
	}
	
}
