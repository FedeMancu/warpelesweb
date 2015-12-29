package com.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.client.PanelAltaPartido.StringRenderer;
import com.client.baseEnMemoria.EstadisticasEnMemoria;
import com.client.baseEnMemoria.JugadoresEnMemoria;
import com.client.service.JugadorService;
import com.client.service.JugadorServiceAsync;
import com.client.service.PrincipalService;
import com.client.service.PrincipalServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ValueListBox;
import com.shared.modelo.EstadisticaBean;
import com.shared.modelo.GoleadoresRecord;
import com.shared.modelo.Jugador;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

//TODO popup
public class PanelEstadisticasGenerales extends DialogBox {

	/*private PrincipalServiceAsync servicePrincipal = GWT.create(PrincipalService.class);*/
	
	/*private JugadorServiceAsync serviceJugador = GWT.create(JugadorService.class);*/
	
	private ValueListBox<String> temporada = new ValueListBox<String>(new StringRenderer());

	private ValueListBox<String> nombreCampeonato = new ValueListBox<String>(new StringRenderer());
	
	private final FlexTable contenidoGoleadores = new FlexTable();
	
	private final FlexTable contenidoStats = new FlexTable();
	
	private final FlexTable contenido = new FlexTable();
	
	private ListGrid countryGrid = new ListGrid();  




	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	

	public PanelEstadisticasGenerales() {
		
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Estadisticas generales");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		setAutoHideEnabled(true);
		
		


		Collection<String> anios= new ArrayList<String>();
		for(int i=2007;i<2016;i++){
			anios.add(String.valueOf(i));
	
		}
		
		nombreCampeonato.setValue("");
		
		temporada.setAcceptableValues(anios);
		
		temporada.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				
				
			/*	servicePrincipal.obtenerCampeonatosDeUnaTemporada(temporada.getValue(), 
						new AsyncCallback<ArrayList<String>>() {

							@Override
							public void onFailure(Throwable caught) {
								
							}

							@Override
							public void onSuccess(ArrayList<String> campeonatos) {
								nombreCampeonato.setAcceptableValues(campeonatos);
								
							}
									
				
			
				});*/
				
				ArrayList<String> campeonatos = EstadisticasEnMemoria.obtenerCampeonatosDeUnaTemporada(temporada.getValue());

				nombreCampeonato.setAcceptableValues(campeonatos);

				nombreCampeonato.setValue("");
				
				cargarEstadisticas();
				
				FlexTable tabla=cargarGoles();
				tabla=cargarGoles();
							
		        contenidoGoleadores.setWidget(1, 1, tabla);
		        contenido.setWidget(1, 2, contenidoGoleadores);

			}
		});
		
		nombreCampeonato.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				
				cargarEstadisticas();
				FlexTable tabla=cargarGoles();
				tabla=cargarGoles();
							
		        contenidoGoleadores.setWidget(1, 1, tabla);
		        contenido.setWidget(1, 2, contenidoGoleadores);

					}

				});
       
       
         
        
        contenido.setHeight("450px");
        contenido.setWidth("650px");
		
		temporada.setSize("180px", "25px");
		nombreCampeonato.setSize("180px", "25px");
		
        cargarEstadisticas();
        	
		contenidoStats.setText(1, 1, "Temporada: ");
		contenidoStats.setText(2, 1, "Campeonato: ");
        contenidoStats.setWidget(1, 2, temporada);
        contenidoStats.setWidget(2, 2, nombreCampeonato);
            
        contenidoStats.setText(4, 1, "Jugados:");
        contenidoStats.setText(5, 1, "Ganados:");
        contenidoStats.setText(6, 1, "Empatados:");
        contenidoStats.setText(7, 1, "Perdidos:");
        
        contenidoStats.setText(9, 1, "Goles a favor:");
        contenidoStats.setText(10, 1, "Goles en contra:");
        contenidoStats.setText(11, 1, "% de puntos:");
        
        contenidoStats.setText(13, 1, "Mejor triunfo:");
        contenidoStats.setText(14, 1, "Peor derrota:");
        contenidoStats.setText(15, 1, "Mas goles a favor:");
        contenidoStats.setText(16, 1, "Mas goles e/c:");

		 
        contenido.setWidget(1, 1, contenidoStats);
             
//        contenido.setWidget(5, 2, btnCerrar);
        
		setWidget(contenido);
		
		FlexTable tabla=cargarGoles();
			
//		PanelTablaGoleadores panel=new PanelTablaGoleadores();
//		FlexTable tabla = panel.obtenerTabla(jugadores);
		
        contenidoGoleadores.setWidget(1, 1, tabla);
        contenido.setWidget(1, 2, contenidoGoleadores);

    }

	private FlexTable cargarGoles() {
		/*
		final PopUpCarga popu=new PopUpCarga();
        popu.setGlassEnabled(true);
        countryGrid.setVisible(false);

        
        popu.center();
        popu.show();

        
        serviceJugador.obtenerJugadoresConSusGoles(temporada.getValue(),nombreCampeonato.getValue(),new AsyncCallback<ArrayList<Jugador>>() {

			
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			public void onSuccess(ArrayList<Jugador> jugadores) {


				Iterator iterador= jugadores.iterator();
				
				while(iterador.hasNext()) {

				    Jugador jugador = (Jugador) iterador.next(); 
					if(jugador.getCantidadGoles()==0){
						
						iterador.remove();
						
					}
				}
				
				
				countryGrid.setVisible(true);

				popu.hide();*/
		
//		ArrayList<Jugador> jugadores = JugadoresEnMemoria.obtenerJugadoresConSusGoles(temporada.getValue(),nombreCampeonato.getValue());
//		Iterator iterador = jugadores.iterator();
//
//		while (iterador.hasNext()) {
//
//			Jugador jugador = (Jugador) iterador.next();
//			if (jugador.getCantidadGoles() == 0) {
//
//				iterador.remove();
//
//			}
//		}
//
//		GoleadoresRecord[] records = new GoleadoresRecord[jugadores.size()];
//
//		for (int i = 0; i < jugadores.size(); i++) {
//
//			if ((!((jugadores.get(i).getCantidadGoles()) == 0))) {
//				GoleadoresRecord recordGoleadores = new GoleadoresRecord(
//						jugadores.get(i).getNombre(), String.valueOf(jugadores.get(i).getCantidadGoles()));
//				records[i] = recordGoleadores;
//			}
//		}
//
//		countryGrid.setRecords(records);
		
		PanelTablaGoleadores panel=new PanelTablaGoleadores();
		
		ArrayList<Jugador> jugadores = JugadoresEnMemoria.obtenerJugadoresConSusGoles(temporada.getValue(),nombreCampeonato.getValue());
		Iterator iterador = jugadores.iterator();

		while (iterador.hasNext()) {

			Jugador jugador = (Jugador) iterador.next();
			if (jugador.getCantidadGoles() == 0) {

				iterador.remove();

			}
		}
		FlexTable tabla = panel.obtenerTabla(jugadores);

		return tabla;
		
	}

	private void cargarEstadisticas() {
		/*
		servicePrincipal.obtenerEstadisticas(temporada.getValue(),nombreCampeonato.getValue(), new AsyncCallback<EstadisticaBean>() {
		
		@Override
		public void onSuccess(EstadisticaBean beanEstadistica) {

			contenidoStats.setText(4, 2, String.valueOf(beanEstadistica.getPartidosJugados()));
			contenidoStats.setText(5, 2, String.valueOf(beanEstadistica.getPartidosGanados()));
			contenidoStats.setText(6, 2, String.valueOf(beanEstadistica.getPartidosEmpatados()));
			contenidoStats.setText(7, 2, String.valueOf(beanEstadistica.getPartidosPerdidos()));
			contenidoStats.setText(8, 2, String.valueOf(beanEstadistica.getGolesAFavor()));
			contenidoStats.setText(9, 2, String.valueOf(beanEstadistica.getGolesEnContra()));
			contenidoStats.setText(10, 2, String.valueOf(beanEstadistica.getPorcentajeDePuntos() + " %"));


			
			
		}
		
		@Override
		public void onFailure(Throwable caught) {

			
			}
		
		}); */
		
		EstadisticaBean beanEstadistica = EstadisticasEnMemoria.obtenerEstadisticas(temporada.getValue(),nombreCampeonato.getValue());
		
		contenidoStats.setText(4, 2, String.valueOf(beanEstadistica.getPartidosJugados()));
		contenidoStats.setText(5, 2, String.valueOf(beanEstadistica.getPartidosGanados()));
		contenidoStats.setText(6, 2, String.valueOf(beanEstadistica.getPartidosEmpatados()));
		contenidoStats.setText(7, 2, String.valueOf(beanEstadistica.getPartidosPerdidos()));
		contenidoStats.setText(9, 2, String.valueOf(beanEstadistica.getGolesAFavor()));
		contenidoStats.setText(10, 2, String.valueOf(beanEstadistica.getGolesEnContra()));
		contenidoStats.setText(11, 2, String.valueOf(beanEstadistica.getPorcentajeDePuntos() + " %"));
		
		TextArea triunfo = new TextArea();
		triunfo.setText(beanEstadistica.getMayorTriunfo());
		triunfo.setHeight("25px");
		triunfo.setEnabled(false);
		
		TextArea derrota = new TextArea();
		derrota.setText(beanEstadistica.getMayorDerrota());
		derrota.setHeight("25px");
		derrota.setEnabled(false);
	
		TextArea goles = new TextArea();
		goles.setText(beanEstadistica.getMasGolesAFavor());
		goles.setHeight("25px");
		goles.setEnabled(false);
		
		TextArea golesEc = new TextArea();
		golesEc.setText(beanEstadistica.getMasGolesEnContra());
		golesEc.setHeight("25px");
		golesEc.setEnabled(false);
		
		contenidoStats.setWidget(13, 2, triunfo);
		contenidoStats.setWidget(14, 2, derrota);
		contenidoStats.setWidget(15, 2, goles);
		contenidoStats.setWidget(16, 2, golesEc );

		
	}  
		
		
}