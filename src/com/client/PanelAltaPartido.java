package com.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.client.service.EquipoRivalService;
import com.client.service.EquipoRivalServiceAsync;
import com.client.service.JugadorService;
import com.client.service.JugadorServiceAsync;
import com.client.service.PartidoService;
import com.client.service.PartidoServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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

public class PanelAltaPartido extends DialogBox{

	
	private  PartidoServiceAsync servicePartido = GWT
	.create(PartidoService.class);
	
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
			
			if(campoVacio(golesEnContra.getValue()) || campoVacio(numeroDeFecha.getValue()) 
					|| campoVacio(anio.getValue()) || campoVacio(nombreCampeonato.getValue())
					|| (equiposRivales.getValue()==null)){
				
				Window.alert("Hay que completar todos los campos");
			} else{
				guardarPartido();
				hide();
			}
		}
	});
	
	private final Button botonAgregarGol = new Button("OK", new ClickHandler() {
		public void onClick(ClickEvent event) {
			
			agregaGol();
		}

		private void agregaGol() {
			autoresDeGoles.add(jugadores.getValue().getNombre());
			lineaDeGoles.setValue(autoresDeGoles.toString());
			cantidadDeGoles++;
			aFavor.setValue(String.valueOf(cantidadDeGoles));
			
			
		}
	});
	
	private final Button botonReset = new Button("Reset", new ClickHandler() {
		public void onClick(ClickEvent event) {
			
			borraGoles();
		}

		private void borraGoles() {
			autoresDeGoles.clear();
			lineaDeGoles.setValue(autoresDeGoles.toString());
			cantidadDeGoles=0;
			aFavor.setValue(String.valueOf(cantidadDeGoles));
		}
	});
	
	private ValueListBox<Jugador> jugadores = new ValueListBox<Jugador>(new JugadorRenderer());
	
	private ValueListBox<EquipoRival> equiposRivales = new ValueListBox<EquipoRival>(new EquipoRenderer());

	private ValueListBox<String> anio = new ValueListBox<String>(new StringRenderer());

	private ValueListBox<String> nombreCampeonato = new ValueListBox<String>(new StringRenderer());

	private ValueListBox<String> golesEnContra = new ValueListBox<String>(new StringRenderer());

	private ValueListBox<String> numeroDeFecha = new ValueListBox<String>(new StringRenderer());

	private TextBox aFavor = new TextBox();
	
	private TextBox enContra = new TextBox();
	
	private TextBox lineaDeGoles = new TextBox();
	
	private int cantidadDeGoles=0;
	
	private List<String> autoresDeGoles=new ArrayList<String>();
	
	public PanelAltaPartido() {
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
		cargarListas();	
		
		golesEnContra.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				enContra.setValue(golesEnContra.getValue());
			}
		     });
		
		enContra.setEnabled(false);
		aFavor.setEnabled(false);
		aFavor.setValue("0");
		enContra.setValue("0");
		aFavor.setSize("75px", "15px");
		enContra.setSize("75px", "15px");
		lineaDeGoles.setSize("75px", "15px");
		
		contenido.setCellSpacing(5);
		contenido.setCellPadding(0);
		contenido.setText(0, 0, "Temporada:");
		contenido.setWidget(0, 1, anio);
		
		contenido.setText(1, 0, "Campeonato:");
		contenido.setWidget(1, 1, nombreCampeonato);
		
		contenido.setText(2, 0, "Numero de fecha:");
		contenido.setWidget(2, 1, numeroDeFecha);
		
		contenido.setText(3, 0, "Rival:");
		contenido.setWidget(3, 1, equiposRivales);
		
		contenido.setText(4, 0, "Goles en contra:");
		contenido.setWidget(4, 1, golesEnContra);
		
		contenido.setText(5, 0, "CARGA DE GOLES");

		contenido.setText(6, 0, "Jugador:");
		contenido.setWidget(6, 1, jugadores);
		contenido.setWidget(6, 2, botonAgregarGol);
		contenido.setWidget(6, 3, botonReset);
		
		contenido.setText(7, 0, "Autores :");
		contenido.setWidget(7, 1, lineaDeGoles);
		
		contenido.setText(8, 0, "RESULTADO FINAL:");
		contenido.setWidget(8, 1, aFavor);
		contenido.setWidget(8, 2, enContra);
		
		contenido.setWidget(10, 1, btnAceptar);
		contenido.setWidget(10, 2, btnCerrar);
		
		// Asigna el contenido.
		setWidget(contenido);
	}
	

	private void cargarListas() {
		
		Collection<String> anios= new ArrayList<String>();
		for(int i=2007;i<2018;i++){
			anios.add(String.valueOf(i));
	
		}
		
		Collection<String> golesYFechas= new ArrayList<String>();
		for(int i=0;i<=20;i++){
			golesYFechas.add(String.valueOf(i));
		}
		
		ArrayList<String> campeonato= new ArrayList<String>();
		campeonato.add("Apertura");
		campeonato.add("Clausura");
		campeonato.add("Promocion ascenso");
		campeonato.add("Promocion descenso");
		campeonato.add("Reducido");
		campeonato.add("Copa de invierno");
		campeonato.add("Copa libertadores");
		campeonato.add("Fase clasificatoria");
		

		anio.setAcceptableValues(anios);
		golesEnContra.setAcceptableValues(golesYFechas);
		numeroDeFecha.setAcceptableValues(golesYFechas);
		nombreCampeonato.setAcceptableValues(campeonato);
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


	void guardarPartido() {
		
		EquipoRival rival=equiposRivales.getValue();
		
		servicePartido.guardar(golesEnContra.getValue(),numeroDeFecha.getValue(),
				anio.getValue(), nombreCampeonato.getValue(),
				autoresDeGoles, rival,new AsyncCallback<Boolean>() {

			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			public void onSuccess(Boolean result) {
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
	
	static final class StringRenderer extends AbstractRenderer<String> {
        public String render(String cadena) {
          if (cadena == null) {
            return "";
          } else {
            return cadena;
          }	   
        }
 		}
	

	private void cargarEquiposRivales() {

		serviceEquipoRival.obtenerEquiposRivales(new AsyncCallback<ArrayList<EquipoRival>>() {

					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					public void onSuccess(ArrayList<EquipoRival> result) {
						equiposRivales.setAcceptableValues(result);
					}
				});
	}
	
	boolean campoVacio(String string){
		
		if (string==null || string.equals("")){
			return true;
		}else return false;
	}
}
