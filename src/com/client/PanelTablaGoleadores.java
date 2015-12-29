package com.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.client.baseEnMemoria.JugadoresEnMemoria;
import com.client.service.JugadorService;
import com.client.service.JugadorServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.shared.modelo.GoleadoresRecord;
import com.shared.modelo.GolesDetalleBean;
import com.shared.modelo.Jugador;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.CellHoverEvent;
import com.smartgwt.client.widgets.grid.events.CellHoverHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.RowContextClickEvent;
import com.smartgwt.client.widgets.grid.events.RowContextClickHandler;

//TODO popup
public class PanelTablaGoleadores extends DialogBox {
	
    final PopUpCarga popu=new PopUpCarga();


	
	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});
	
	/*private JugadorServiceAsync serviceJugador = GWT.create(JugadorService.class);*/


	public PanelTablaGoleadores() {
		
		
		
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		
		// Asigna el texto de la barra de título.
		setText("Tabla historica de goleadores");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		setAutoHideEnabled(true);

		
		final FlexTable contenido = new FlexTable();

		 
        
        /*
        popu.setGlassEnabled(true);
        popu.center();
        popu.show();
        
		serviceJugador.obtenerJugadoresConSusGoles("","",new AsyncCallback<ArrayList<Jugador>>() {
					
			
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					public void onSuccess(ArrayList<Jugador> jugadores) {
						
						
						
						Iterator iterador= jugadores.iterator();
							
						while(iterador.hasNext()) {

						    Jugador jugador = (Jugador) iterador.next(); 
							if(((jugador.getNombre()).equals("Sin Anotar"))
								    || ((jugador.getNombre()).equals("En Contra"))
									|| ((jugador.getCantidadGoles())==0)){
								
								iterador.remove();
								
							}
						}
						
						countryGrid.setVisible(true);
						popu.hide();
						
						GoleadoresRecord[] records= new GoleadoresRecord[jugadores.size()];
						
						for(int i=0;i<jugadores.size();i++){
											
								GoleadoresRecord recordGoleadores = new GoleadoresRecord(jugadores.get(i).getNombre(), String.valueOf(jugadores.get(i).getCantidadGoles()));
								records[i]=recordGoleadores;				
							
						}
						
						 countryGrid.setRecords(records);
						
					}
					
				});*/
		ArrayList<Jugador> jugadores = JugadoresEnMemoria.obtenerJugadoresConSusGoles("","");
    
		Iterator iterador= jugadores.iterator();
		
		while(iterador.hasNext()) {

		    Jugador jugador = (Jugador) iterador.next(); 
			if(((jugador.getNombre()).equals("Sin Anotar"))
				    || ((jugador.getNombre()).equals("En Contra"))
					|| ((jugador.getCantidadGoles())==0)){
				
				iterador.remove();
				
			}
		}
		
		 
		popu.hide();
		
		FlexTable tabla = obtenerTabla(jugadores);
		
		
		 
        contenido.setWidget(1, 1, tabla);
//        contenido.setWidget(2, 1, btnCerrar);
        
     // Asigna el contenido.
		setWidget(contenido);
	
		
    }  
	
	public FlexTable obtenerTabla(ArrayList<Jugador> jugadores){
		
		FlexTable resultado= new FlexTable();
		
		final ListGrid tabla = new ListGrid(); 
		tabla.setVisible(false);
        tabla.setWidth(300);  
        tabla.setHeight(500);  
        tabla.setHeaderHeight(40);  
  
        ListGridField warpel = new ListGridField("warpel", "WARPEL", 185);  
        warpel.setAlign(Alignment.CENTER);  
        warpel.setType(ListGridFieldType.TEXT);   
        warpel.setCanSort(false);  
        warpel.setCanReorder(false);
        warpel.setCanFreeze(false);
        warpel.setAutoFitWidth(false);
        warpel.setCanEdit(false);
        warpel.setCanGroupBy(false);
        warpel.setCanHide(false);
        warpel.setCanEdit(false);
        
  
        ListGridField total = new ListGridField("total", "TOTAL",100);  
        
        total.setAlign(Alignment.CENTER);  
        total.setType(ListGridFieldType.TEXT);   
        total.setCanSort(false);  
        total.setCanReorder(false);
        total.setCanFreeze(false);
        total.setAutoFitWidth(false);
        total.setCanEdit(false);
        total.setCanGroupBy(false); 
        total.setCanHide(false);
        total.setCanEdit(false);

        tabla.setFields(warpel, total);     
        tabla.setVisible(true);
        
        final ListGrid tablaDetalle = new ListGrid(); 
        tablaDetalle.setVisible(false);
        tablaDetalle.setWidth(300);  
        tablaDetalle.setHeight(500);  
        tablaDetalle.setHeaderHeight(40);  
  
        ListGridField warpelDetalle = new ListGridField("equipo", "EQUIPO", 185);  
        warpelDetalle.setAlign(Alignment.CENTER);  
        warpelDetalle.setType(ListGridFieldType.TEXT);   
        warpelDetalle.setCanSort(false);  
        warpelDetalle.setCanReorder(false);
        warpelDetalle.setCanFreeze(false);
        warpelDetalle.setAutoFitWidth(false);
        warpelDetalle.setCanEdit(false);
        warpelDetalle.setCanGroupBy(false);
        warpelDetalle.setCanHide(false);
        warpelDetalle.setCanEdit(false);
  
        ListGridField totalDetalle = new ListGridField("totalDetalle", "TOTAL",100);  
        
        totalDetalle.setAlign(Alignment.CENTER);  
        totalDetalle.setType(ListGridFieldType.TEXT);   
        totalDetalle.setCanSort(false);  
        totalDetalle.setCanReorder(false);
        totalDetalle.setCanFreeze(false);
        totalDetalle.setAutoFitWidth(false);
        totalDetalle.setCanEdit(false);
        totalDetalle.setCanGroupBy(false); 
        totalDetalle.setCanHide(false);
        totalDetalle.setCanEdit(false);

        tablaDetalle.setFields(warpelDetalle, totalDetalle);     
        tablaDetalle.setVisible(true);
        
        GoleadoresRecord[] records= new GoleadoresRecord[jugadores.size()];
		
		for(int i=0;i<jugadores.size();i++){

			    GoleadoresRecord recordGoleadores = new GoleadoresRecord(jugadores.get(i).getNombre(), String.valueOf(jugadores.get(i).getCantidadGoles()),jugadores.get(i).getCantidadGolesAUnEquipo());
				records[i]=recordGoleadores;				
			
		}
				
		tabla.setRecords(records);
		
//		tabla.addCellHoverHandler(new CellHoverHandler() {
//			
//			public void onCellHover(CellHoverEvent event) {
//				
//				com.smartgwt.client.types.Cursor.HAND
//				
//				tabla.setCursor(cursor.HAND );
//				
//				
//			}
//		});
		

		
		tabla.addRecordClickHandler(new RecordClickHandler() {  
            public void onRecordClick(RecordClickEvent event) {  
            	
				GoleadoresRecord record = (GoleadoresRecord)event.getRecord();
            	
            	ArrayList<GolesDetalleBean> lista = record.getDetalleBean();
            	
                GoleadoresRecord[] recordsDetalle= new GoleadoresRecord[lista.size()];
            	
            	for(int i=0;i<lista.size();i++){

    			    GoleadoresRecord recordGoleadores = new GoleadoresRecord(lista.get(i).getEquipoRival(), String.valueOf(lista.get(i).getCantidadGoles()));
    			    recordsDetalle[i]=recordGoleadores;				
    			
            	}
            	tablaDetalle.setRecords(recordsDetalle);
            }  
        }); 
		
		resultado.setWidget(0, 1, tabla);
		resultado.setWidget(0, 2, tablaDetalle);

       
        
        return resultado;
	}
	
		
		
}
