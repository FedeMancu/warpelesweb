package com.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import com.client.baseEnMemoria.PartidosEnMemoria;
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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HasVerticalAlignment.VerticalAlignmentConstant;
import com.shared.modelo.Partido;
import com.shared.modelo.PartidosRecord;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

//TODO popup
public class PanelListadoPartidos extends DialogBox {

    int numPagina=1;
    int totalPaginas=-1;
	ListGrid countryGrid = new ListGrid();  
	
	/*USANDO BASE DE DATOS*/
//	 private PartidoServiceAsync servicePartido = GWT.create(PartidoService.class);


	
    Button siguiente = new Button("Siguiente", new ClickHandler() {
		public void onClick(ClickEvent event) {
        
			numPagina++;
			if(numPagina==totalPaginas){
				siguiente.setEnabled(false);		
			}
			anterior.setEnabled(true);
			cargarPartidos(numPagina, countryGrid);
			
		}
	});
    
    Button anterior = new Button("Anterior", new ClickHandler() {
		public void onClick(ClickEvent event) {
			
			numPagina--;
			if(numPagina==1){
				anterior.setEnabled(false);
			}
			siguiente.setEnabled(true);
			cargarPartidos(numPagina, countryGrid);
			
		}
	});
	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	
	
	private void cargarPartidos(int numPagina, final ListGrid countryGrid){
		
		
		final PopUpCarga popu=new PopUpCarga();

        /*USANDO BASE DE DATOS */
        
//		countryGrid.setVisible(false);
//        popu.setGlassEnabled(true);
//        popu.center();
//        popu.show();
//       
//		
//		servicePartido.obtenerListadoDePartidos( numPagina,new AsyncCallback<ArrayList<Partido>>() {
//				
//			public void onFailure(Throwable caught) {
//				Window.alert(caught.getMessage());
//			}
//
//			public void onSuccess(ArrayList<Partido> partidos) {
//				
//				
//				PartidosRecord[] records= new PartidosRecord[partidos.size()];
//				
//				for(int i=0;i<partidos.size();i++){
//					
//					Partido partidoActual=partidos.get(i);
//					PartidosRecord recordPartidos = new PartidosRecord(String.valueOf(partidoActual.getNumeroDePartido()), String.valueOf(partidoActual.getAnio()), partidoActual.getCampeonato(), String.valueOf(partidoActual.getNumeroDeFecha()),partidoActual.getNombreEquipoRival(),partidoActual.getResultado(),partidoActual.getAutoresDeGoles());
//					records[i]=recordPartidos;
//				}
//				
//				 countryGrid.setRecords(records);
//			     countryGrid.setVisible(true);
//
//				 popu.hide();
//
//				
//			}
//			
//		});
		
		/*USANDO MEMORIA*/
		
		ArrayList<Partido> partidos = PartidosEnMemoria.obtenerListadoDePartidosPaginado(numPagina);
		
		PartidosRecord[] records= new PartidosRecord[partidos.size()];
		
		for(int i=0;i<partidos.size();i++){
			
			Partido partidoActual=partidos.get(i);
			PartidosRecord recordPartidos = new PartidosRecord(String.valueOf(partidoActual.getNumeroDePartido()), String.valueOf(partidoActual.getAnio()), partidoActual.getCampeonato(), String.valueOf(partidoActual.getNumeroDeFecha()),partidoActual.getNombreEquipoRival(),partidoActual.getResultado(),partidoActual.getAutoresDeGoles());
			records[i]=recordPartidos;
		}
		
		 countryGrid.setRecords(records);
	     countryGrid.setVisible(true);
		
	}


	public PanelListadoPartidos() {
		
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Listado de partidos");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		setAutoHideEnabled(true);

		
		/*USANDO BASE DE DATOS*/

//		servicePartido.obtenerCantidadDePartidos( new AsyncCallback<Integer>() {
//			
//			public void onFailure(Throwable caught) {
//				Window.alert(caught.getMessage());
//			}
//
//			public void onSuccess(Integer cantidad) {
//				
//				//Porque muestra 22 partidos por pagina
//				
//				BigDecimal positiveDecimal = new BigDecimal(String.valueOf(cantidad/22.0));  
//				BigDecimal positiveRedondeado = positiveDecimal.setScale(0, RoundingMode.UP);
//				totalPaginas=positiveRedondeado.intValue();
//			}
//				
//		});
		
		/*USANDO MEMORIA*/
		ArrayList<Partido> partidos = PartidosEnMemoria.obtenerPartidos();
				
		BigDecimal positiveDecimal = new BigDecimal(String.valueOf(partidos.size()/22.0));  
		BigDecimal positiveRedondeado = positiveDecimal.setScale(0, RoundingMode.UP);
		totalPaginas=positiveRedondeado.intValue();
		
		final FlexTable contenido = new FlexTable();

        countryGrid.setWidth(940);  
        countryGrid.setHeight(550);  
        countryGrid.setHeaderHeight(30);  
  
        ListGridField numeroPartido= new ListGridField("numeroPartido", " ", 30);  
        numeroPartido.setAlign(Alignment.CENTER);  
        numeroPartido.setType(ListGridFieldType.TEXT);   
        numeroPartido.setCanSort(false);  
        numeroPartido.setCanReorder(false);
        numeroPartido.setCanFreeze(false);
        numeroPartido.setAutoFitWidth(false);
        numeroPartido.setCanEdit(false);
        numeroPartido.setCanGroupBy(false);
        numeroPartido.setCanHide(false);
        numeroPartido.setCanEdit(false);
        
        ListGridField temporada= new ListGridField("temporada", "TEMPORADA", 80);  
        temporada.setAlign(Alignment.CENTER);  
        temporada.setType(ListGridFieldType.TEXT);   
        temporada.setCanSort(false);  
        temporada.setCanReorder(false);
        temporada.setCanFreeze(false);
        temporada.setAutoFitWidth(false);
        temporada.setCanEdit(false);
        temporada.setCanGroupBy(false);
        temporada.setCanHide(false);
        temporada.setCanEdit(false);
  
        ListGridField campeonato = new ListGridField("campeonato", "CAMPEONATO",120);  
        
        campeonato.setAlign(Alignment.CENTER);  
        campeonato.setType(ListGridFieldType.TEXT);   
        campeonato.setCanSort(false);  
        campeonato.setCanReorder(false);
        campeonato.setCanFreeze(false);
        campeonato.setAutoFitWidth(false);
        campeonato.setCanEdit(false);
        campeonato.setCanGroupBy(false); 
        campeonato.setCanHide(false);
        campeonato.setCanEdit(false);
        
        ListGridField fecha = new ListGridField("fecha", "FECHA",45);  
        
        fecha.setAlign(Alignment.CENTER);  
        fecha.setType(ListGridFieldType.TEXT);   
        fecha.setCanSort(false);  
        fecha.setCanReorder(false);
        fecha.setCanFreeze(false);
        fecha.setAutoFitWidth(false);
        fecha.setCanEdit(false);
        fecha.setCanGroupBy(false); 
        fecha.setCanHide(false);
        fecha.setCanEdit(false);
        
        ListGridField rival = new ListGridField("rival", "RIVAL",120);  
        
        rival.setAlign(Alignment.CENTER);  
        rival.setType(ListGridFieldType.TEXT);   
        rival.setCanSort(false);  
        rival.setCanReorder(false);
        rival.setCanFreeze(false);
        rival.setAutoFitWidth(false);
        rival.setCanEdit(false);
        rival.setCanGroupBy(false); 
        rival.setCanHide(false);
        rival.setCanEdit(false);
        
        ListGridField resultado = new ListGridField("resultado", "RESULTADO",100);  
        
        resultado.setAlign(Alignment.CENTER);  
        resultado.setType(ListGridFieldType.TEXT);   
        resultado.setCanSort(false);  
        resultado.setCanReorder(false);
        resultado.setCanFreeze(false);
        resultado.setAutoFitWidth(false);
        resultado.setCanEdit(false);
        resultado.setCanGroupBy(false); 
        resultado.setCanHide(false);
        resultado.setCanEdit(false);
        
        ListGridField goles = new ListGridField("goles", "GOLES",440);  
        
        goles.setAlign(Alignment.CENTER);  
        goles.setType(ListGridFieldType.TEXT);   
        goles.setCanSort(false);  
        goles.setCanReorder(false);
        goles.setCanFreeze(false);
        goles.setAutoFitWidth(false);
        goles.setCanEdit(false);
        goles.setCanGroupBy(false); 
        goles.setCanHide(false);
        goles.setCanEdit(false);


        countryGrid.setFields(numeroPartido, temporada, campeonato, fecha, rival, resultado, goles);  

        cargarPartidos(numPagina, countryGrid);
          
        contenido.setWidget(1, 1, countryGrid);
       
		FlexTable botones = new FlexTable();
		
		anterior.setEnabled(false);
        botones.setWidget(1, 1, anterior);
        botones.setWidget(1, 2, siguiente);
        
        contenido.setWidget(2, 1, botones);
        
//        contenido.setWidget(3, 1, btnCerrar);
        
        contenido.getFlexCellFormatter().setAlignment(2, 1, HasHorizontalAlignment.ALIGN_CENTER , HasVerticalAlignment.ALIGN_MIDDLE );
//        contenido.getFlexCellFormatter().setAlignment(3, 1, HasHorizontalAlignment.ALIGN_RIGHT , HasVerticalAlignment.ALIGN_MIDDLE );

		setWidget(contenido);
	
    }  
		
		
}
