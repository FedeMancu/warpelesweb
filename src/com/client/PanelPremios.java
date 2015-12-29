package com.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;
	

public class PanelPremios extends DialogBox {	



	private final Button btnCerrar = new Button("Cerrar", new ClickHandler() {
		public void onClick(ClickEvent event) {
			// Cierra el cuadro de diálogo.
			hide();
		}
	});

	public PanelPremios() {
		/*
		 * El primer parámetro en false indica que el diálogo no es autohide. El
		 * segundo parámetro es true para indicar que es modal, o sea que
		 * bloquea el resto de la página si no se cierra.
		 */
		super(false, true);
		// Asigna el texto de la barra de título.
		setText("Titulos ganados");
		// Realiza una animación al abrir o cerrar el diálogo.
		setAnimationEnabled(true);
		setGlassEnabled(true);
		setAutoHideEnabled(true);

			
	    Image balonEstebanUno = new Image("estebanbalon1.png");
	    balonEstebanUno.setSize("150px", "120px");
	    
	    Image balonEstebanDos = new Image("estebanbalon2.png");	    
	    balonEstebanDos.setSize("150px", "120px");
	    
	    Image fairplayCris = new Image("crisfairplay.png");	 
	    fairplayCris.setSize("150px", "120px");
	   
	    Image fairplayCos = new Image("cospelarbitro2.png");
	    fairplayCos.setSize("150px", "120px");
	    
	    Image balonMati = new Image("matibalon.png");	 
	    balonMati.setSize("150px", "120px");
	    
	    Image capitanUno = new Image("capitanUno.png");
	    capitanUno.setSize("150px", "120px");
	    
	    Image capitanDos = new Image("capitanDos.png");	
	    capitanDos.setSize("150px", "120px");
		
	    VLayout descFairPlayCris = new VLayout();
		VLayout descFairPlayCos = new VLayout();
		VLayout descBalonEsteban1 = new VLayout();
		VLayout descBalonEsteban2 = new VLayout();
		VLayout descBalonMati = new VLayout();
		VLayout descCapitan1 = new VLayout();
		VLayout descCapitan2 = new VLayout();
	    
		agregarDescripcion(fairplayCris,descFairPlayCris, "Fair Play - Apertura 2008");
		agregarDescripcion(fairplayCos,descFairPlayCos, "Fair Play - Apertura 2009");
		agregarDescripcion(balonEstebanUno, descBalonEsteban1, "Mejor jugador - Esteban - Apertura 2009");
		agregarDescripcion(balonMati, descBalonMati, "Mejor jugador - Mati - Clausura 2010");
		agregarDescripcion(balonEstebanDos, descBalonEsteban2, "Mejor jugador - Esteban - Apertura 2010");
		agregarDescripcion(capitanUno, descCapitan1, "Mejor capitan - Cristhian - Apertura 2009");
		agregarDescripcion(capitanDos, descCapitan2, "Mejor capitan - Cristhian - Apertura 2010");
		
		final FlexTable contenido = new FlexTable();

		contenido.setCellSpacing(0);
		contenido.setCellPadding(0);
		
		contenido.setWidget(1, 1, fairplayCris);
		contenido.setWidget(1, 3, fairplayCos);
		contenido.setWidget(2, 1, descFairPlayCris);
		contenido.setWidget(2, 3, descFairPlayCos);
		contenido.setWidget(3, 1, balonEstebanUno);
		contenido.setWidget(3, 2, balonMati);
		contenido.setWidget(3, 3, balonEstebanDos);
		contenido.setWidget(4, 1, descBalonEsteban1);
		contenido.setWidget(4, 2, descBalonMati);
		contenido.setWidget(4, 3, descBalonEsteban2);
		contenido.setWidget(5, 1, capitanUno);
		contenido.setWidget(5, 3, capitanDos);
		contenido.setWidget(6, 1, descCapitan1);
		contenido.setWidget(6, 3, descCapitan2);


//		contenido.setWidget(9, 3, btnCerrar);

		
	    descFairPlayCris.setHeight(50);
	    descFairPlayCos.setHeight(50);
	    descBalonEsteban1.setHeight(50);
	    descBalonMati.setHeight(50);
	    descBalonEsteban2.setHeight(50);
	    descCapitan1.setHeight(50);
	    descCapitan2.setHeight(50);
	     
		contenido.getFlexCellFormatter().setHeight(2, 1, "50px");
		contenido.getFlexCellFormatter().setHeight(2, 2, "50px");
		contenido.getFlexCellFormatter().setHeight(2, 3, "50px");
		contenido.getFlexCellFormatter().setHeight(4, 1, "50px");
		contenido.getFlexCellFormatter().setHeight(4, 2, "50px");
		contenido.getFlexCellFormatter().setHeight(4, 3, "50px");
		contenido.getFlexCellFormatter().setHeight(6, 1, "50px");
		contenido.getFlexCellFormatter().setHeight(6, 2, "50px");
		contenido.getFlexCellFormatter().setHeight(6, 3, "50px");

//		final ScrollPanel scroll = new ScrollPanel();
//
//		scroll.add(contenido);

		// Asigna el contenido.
		setWidget(contenido);

	}
	
	void agregarDescripcion(final Image imagen, VLayout desc, final String mensaje) {
		
		final Label label=new Label();
		label.setShowEdges(true);
		label.setPadding(10);
		label.setWidth(150);
		label.setBackgroundColor("#ffffd0");
		label.setVisibility(Visibility.HIDDEN);
		label.setValign(VerticalAlignment.CENTER);
		label.setAlign(Alignment.CENTER);
		label.setAnimateTime(1200); // milliseconds
		label.setParentElement(desc);
		label.setHeight("100%");

		
		imagen.addMouseOverHandler(new MouseOverHandler() {
			
			public void onMouseOver(MouseOverEvent event) {
				 Element element = imagen.getElement();
				    DOM.setStyleAttribute((com.google.gwt.user.client.Element) element,"cursor","pointer");
				
			}
		});
		
		imagen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!label.isVisible()) {

					label.setContents(mensaje);
					label.animateShow(AnimationEffect.SLIDE);

				} else {

					label.animateHide(AnimationEffect.SLIDE);

				}

			}
		});

	}

}
