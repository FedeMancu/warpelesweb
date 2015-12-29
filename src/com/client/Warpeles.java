package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.client.handlers.MyHandlerAdminitracion;
import com.client.handlers.MyHandlerEstadisticasGenerales;
import com.client.handlers.MyHandlerGoleadores;
import com.client.handlers.MyHandlerImagenes;
import com.client.handlers.MyHandlerListadoPartidos;
import com.client.handlers.MyHandlerPremios;
import com.client.service.PrincipalService;
import com.client.service.PrincipalServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * Paginas:
 * http://www.smartclient.com/smartgwt/showcase/#featured_complete_app
 * http://localhost:8888/_ah/admin/backends
 */
public class Warpeles implements EntryPoint {
	
	private PrincipalServiceAsync servicePrincipal = GWT.create(PrincipalService.class);

	final Label label=new Label();

	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
			
		/*
		servicePrincipal.iniciarServicios(new AsyncCallback<Boolean>() {
			
			public void onFailure(Throwable caught) {
				// FIXME
				Window.alert(caught.getMessage());
			}

			public void onSuccess(Boolean resultadoCorrecto) {

				if (resultadoCorrecto) {
					Window.alert("OK!");
				} else {
					Window.alert("Error al iniciar servicios");
				}

			}
		});*/

		final Button botonTablaGoleadores = new Button();
		botonTablaGoleadores.setText("Tabla historica de goleadores");
		MyHandlerGoleadores handlerTabla = new MyHandlerGoleadores();
		botonTablaGoleadores.addClickHandler(handlerTabla);
		botonTablaGoleadores.setSize("320px", "30px");
		esconderFraseAlSeleccionar(botonTablaGoleadores);

		/*
		final Button botonAdministracion = new Button();
		botonAdministracion.setText("Administracion");
		MyHandlerAdminitracion handlerAdministracion = new MyHandlerAdminitracion();
		botonAdministracion.addClickHandler(handlerAdministracion);
		botonAdministracion.setSize("320px", "30px");
		esconderFraseAlSeleccionar(botonAdministracion);*/

		final Button botonPartidos = new Button();
		botonPartidos.setText("Listado de partidos");
		MyHandlerListadoPartidos handlerPartidos = new MyHandlerListadoPartidos();
		botonPartidos.addClickHandler(handlerPartidos);
		botonPartidos.setSize("320px", "30px");
		esconderFraseAlSeleccionar(botonPartidos);

		final Button botonImagenes = new Button();
		botonImagenes.setText("Asi salimos a la cancha");
		MyHandlerImagenes handlerImagenes = new MyHandlerImagenes();
		botonImagenes.addClickHandler(handlerImagenes);
		botonImagenes.setSize("320px", "30px");
		esconderFraseAlSeleccionar(botonImagenes);

		final Button botonEstadisticas = new Button();
		botonEstadisticas.setText("Estadisticas generales");
		MyHandlerEstadisticasGenerales handlerEstadisticas = new MyHandlerEstadisticasGenerales();
		botonEstadisticas.addClickHandler(handlerEstadisticas);
		botonEstadisticas.setSize("320px", "30px");
		esconderFraseAlSeleccionar(botonEstadisticas);
		
		final Button botonPremios = new Button();
		botonPremios.setText("Titulos ganados");
		MyHandlerPremios handlerPremios = new MyHandlerPremios();
		botonPremios.addClickHandler(handlerPremios);
		botonPremios.setSize("320px", "30px");
		esconderFraseAlSeleccionar(botonPremios);	
		
		Image imagenMenu = new Image("warpelesMenuUltimo.jpg");
		imagenMenu.setSize("700px", "500px");
		
		final Image imagenFrases = new Image("frasesCospel.gif");
		imagenFrases.setSize("320px", "150px");
		
		final Image imagenGoogle = new Image("appengine.gif");
		//imagenFrases.setSize("320px", "150px");
		
		VLayout panelFrase = new VLayout();

		label.setShowEdges(true);
		label.setPadding(10);
		label.setBackgroundColor("#ffffd0");
		label.setVisibility(Visibility.HIDDEN);
		label.setValign(VerticalAlignment.CENTER);
		label.setAlign(Alignment.CENTER);
		label.setAnimateTime(1200); // milliseconds
		label.setParentElement(panelFrase);
		label.setHeight("50px");
		label.setWidth("320px");
		
		final ArrayList<String> listaDeFrases=new ArrayList<String>();
		
		cargarFrases(listaDeFrases);
		
		imagenFrases.addMouseOverHandler(new MouseOverHandler() {
			
			public void onMouseOver(MouseOverEvent event) {
				 Element element = imagenFrases.getElement();
				    DOM.setStyleAttribute((com.google.gwt.user.client.Element) element,"cursor","pointer");
				
			}
		});
		
		imagenFrases.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (!label.isVisible()) {
		            
					Random rnd = new Random();
					int pos=rnd.nextInt(listaDeFrases.size());
					
					label.setContents(listaDeFrases.get(pos));
					label.animateShow(AnimationEffect.SLIDE);

				} else {

					label.animateHide(AnimationEffect.SLIDE);

				}

			}
		});
		

		final FlexTable contenido = new FlexTable();

		contenido.setCellSpacing(10);
		contenido.setCellPadding(0);

		/*contenido.setWidget(1, 1, botonAdministracion);*/
		contenido.setWidget(2, 1, botonPartidos);
		contenido.setWidget(3, 1, botonTablaGoleadores);
		contenido.setWidget(4, 1, botonImagenes);
		contenido.setWidget(1, 1, botonEstadisticas);
		contenido.setWidget(5, 1, botonPremios);
//		contenido.setWidget(6, 1, imagenFrases);
//		contenido.setWidget(7, 1, panelFrase);
//		contenido.setWidget(8, 1, imagenGoogle);
		
        contenido.getFlexCellFormatter().setAlignment(8, 1, HasHorizontalAlignment.ALIGN_CENTER , HasVerticalAlignment.ALIGN_MIDDLE );



		RootPanel.get("menu").add(contenido);
//		RootPanel.get("imagenMenu").add(imagenMenu);

	}
	
	void cargarFrases(ArrayList<String> listaDeFrases){
		
		listaDeFrases.add("No puede dirigir mi abuelo");	

		listaDeFrases.add("Juez lo suyo fue un desastre (bueno, usted esta expulsado)");

		listaDeFrases.add("Aca va a correr sangre y va a ser culpa de usted	");

		listaDeFrases.add("Masomenos!");	

		listaDeFrases.add("Que dale?? Boludo!");	

		listaDeFrases.add("Tenes razon!	");

		listaDeFrases.add("Que buena?? Sacame Mati!!!");	

		listaDeFrases.add("GRR Sacame Fede!! (amarilla)	");

		listaDeFrases.add("Este silencio es todo culpa de usted !!");	

		listaDeFrases.add("Cuando estes sobrio hablamos	");

		listaDeFrases.add("COME ON!!");	

		listaDeFrases.add("Usted es un incompetente	");

		listaDeFrases.add("En que parte del reglamento dice que el equipo nuevo tiene que ganar?");	
		
		listaDeFrases.add("Saqueme azul o sino lo voy a insultar");

		listaDeFrases.add("YES!");

		listaDeFrases.add("Quien te enseño a dirigir? Un cocinero?");
	}
	
	void esconderFraseAlSeleccionar(Button boton){
		
		boton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				label.animateHide(AnimationEffect.SLIDE);

				
			}
		});
		
	}
	
}
