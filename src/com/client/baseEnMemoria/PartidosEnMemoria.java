package com.client.baseEnMemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import com.shared.modelo.Partido;

/**
 * Es una basura creada por el problema con la base de datos en el servidor
 * partidos.append("author Federico
 *
 */

public class PartidosEnMemoria {

	public static ArrayList<Partido> obtenerPartidos(){
		
		ArrayList<Partido> resultado=new ArrayList<Partido>();
		
		StringBuilder partidos= new StringBuilder();
		
		partidos.append("2007/Fase clasificatoria/1/VLP/3/7/Cospel-Topo-Nico_");
		partidos.append("2007/Fase clasificatoria/2/Borbotones/3/13/Fede-Fede-Cristhian_");
		partidos.append("2007/Fase clasificatoria/3/Media Maquina/5/1/Cospel-Cospel-Fede-Fede-Nico_");
		partidos.append("2007/Fase clasificatoria/4/Joga Bonito/3/14/Juan-Cospel-Fede_");
		partidos.append("2007/Fase clasificatoria/5/Ferneteados/4/3/Cospel-Cospel-Juan-Juan_");
		partidos.append("2007/Fase clasificatoria/6/Hidalgo/5/11/Juan-Juan-Juan-Nico-Cospel_");
		partidos.append("2007/Fase clasificatoria/7/Somos Seis/4/3/Juan-Juan-Fede-Fede_");
		partidos.append("2007/Apertura/1/Mirinda/3/2/Topo-Cristhian-Cospel_");
		partidos.append("2007/Apertura/2/Somos Seis/3/4/Cospel-Cospel-Cristhian_");
		partidos.append("2007/Apertura/3/Scratch/2/4/Cristhian-Juan_");
		partidos.append("2007/Apertura/4/Futbol Champagne/4/4/Juan-Gustavo-Fede-Cristhian_");
		partidos.append("2007/Apertura/5/Ferreteros/1/9/Cospel_");
		partidos.append("2007/Apertura/6/Figurita Repetida/4/3/Juan-Cospel-Nico-Nico_");
		partidos.append("2007/Apertura/7/La Marina/1/6/Cospel_");
		partidos.append("2007/Reducido/1/Figurita Repetida/7/4/Topo-Nico-Cristhian-Cospel-Cospel-Juan-Juan_");
		partidos.append("2007/Reducido/2/Sandman/3/6/Cospel-Nico-Gustavo_");
		partidos.append("2007/Reducido/3/Los Huevos/5/7/Cospel-Cospel-Juan-Nico-Nico_");
		partidos.append("2007/Copa de invierno/1/Figurita Repetida/2/3/Cristhian-Cospel_");
		partidos.append("2007/Copa de invierno/2/Jugo De Uva/2/0/Cospel-Juan_");
		partidos.append("2007/Copa de invierno/3/Somos Seis/1/7/Nico_");
		partidos.append("2007/Clausura/1/Figurita Repetida/3/6/Cospel-Juan-Cristhian_");
		partidos.append("2007/Clausura/2/Cerini/5/7/Cospel-Cospel-Cospel-Topo-Nico_");
		partidos.append("2007/Clausura/3/Borbotones/3/7/Nico-Juan-Juan_");
		partidos.append("2007/Clausura/4/La Kuky/10/2/Cospel-Cospel-Juan-Juan-Nico-Nico-Nico-Cristhian-Cristhian-Gustavo_");
		partidos.append("2007/Clausura/5/Futbol Champagne/1/5/Cristhian_");
		partidos.append("2007/Clausura/6/Embrujo/8/2/Esteban-Esteban-Esteban-Juan-En Contra-Cospel-Nico-Nico_");
		partidos.append("2007/Clausura/7/Papagartes/8/2/Cospel-Cospel-Cospel-Nico-Nico-Esteban-Fede-En Contra_");
		partidos.append("2007/Clausura/8/Rica La Pulpa/2/3/Juan-Juan_");
		partidos.append("2007/Clausura/9/Ferneteados/3/3/Nico-Nico-Fede_");
		partidos.append("2007/Clausura/10/Chivo/3/11/Cospel-Cristhian-En Contra_");
		partidos.append("2007/Clausura/11/Charly Forever/3/8/Esteban-Cospel-Nico_");
		partidos.append("2007/Promocion Ascenso/1/Embrujo/0/5/_");
		partidos.append("2007/Promocion Ascenso/2/Rustikos/1/3/Juan_");
		partidos.append("2007/Promocion Ascenso/3/Ferneteados/1/2/Nico_");
		
		partidos.append("2008/Apertura/1/Florida/2/9/Juan-Nico_");
		partidos.append("2008/Apertura/2/Pueblito/2/8/Cristhian-Nico_");
		partidos.append("2008/Apertura/3/Figurita Repetida/4/8/Nico-Nico-Nico-Esteban_");
		partidos.append("2008/Apertura/4/Piratas/2/9/Juan-Cristhian_");
		partidos.append("2008/Apertura/5/Ben Hur/0/1/_");
		partidos.append("2008/Apertura/6/Salchichon/2/5/Nico-Fede_");
		partidos.append("2008/Apertura/7/Termidor/3/1/Cospel-Cospel-Juan_");
		partidos.append("2008/Apertura/8/La Marina/8/2/Cospel-Cospel-Esteban-Esteban-Nico-Nico-Juan-En Contra_");
		partidos.append("2008/Apertura/9/Papagartes/6/3/Nico-Nico-Esteban-Esteban-Cristhian-Cristhian_");
		partidos.append("2008/Apertura/10/Magia/1/5/Juan_");
		partidos.append("2008/Apertura/11/Aserrin/8/2/Nico-Nico-Nico-Esteban-Esteban-Esteban-Cristhian-Fede_");
		partidos.append("2008/Apertura/12/Scratch/5/6/Cospel-Cospel-Esteban-Esteban-Juan_");
		partidos.append("2008/Apertura/13/Gatoreit/2/5/Cospel-Esteban_");
		partidos.append("2008/Copa de invierno/1/Sandwiches Raul/3/8/Juan-Esteban-Cristhian_");
		partidos.append("2008/Promocion Descenso/1/La Maco�a/1/4/Nico_");
		partidos.append("2008/Promocion Descenso/2/La Marina/2/1/Esteban-Esteban_");
		partidos.append("2008/Promocion Descenso/3/El Dish/3/3/Cospel-Juan-Esteban_");
		partidos.append("2008/Copa de invierno/2/Venimos De Gira/1/1/Topo_");
		partidos.append("2008/Copa de invierno/3/Tolouse/10/3/Nico-Nico-Nico-Esteban-Esteban-Juan-Juan-Cospel-Cospel-Mati Navarro_");
		partidos.append("2008/Copa de invierno/4/Real Mandril/4/3/Juan-Juan-Nico-Esteban_");
		partidos.append("2008/Copa de invierno/5/Figurita Repetida/4/3/Esteban-Esteban-Cospel-Cospel_");
		partidos.append("2008/Copa de invierno/6/Belgrano/2/1/Juan-Nico_");
		partidos.append("2008/Copa de invierno/7/Los Huevos/0/2/_");
		partidos.append("2008/Copa de invierno/8/Salseros/1/5/Cospel_");
		partidos.append("2008/Clausura/1/Primates/2/3/Nico-Cristhian_");
		partidos.append("2008/Clausura/2/Pueblito/3/7/Esteban-Esteban-Juan_");
		partidos.append("2008/Clausura/3/Deportivo Gambeta/4/2/Cospel-Cospel-Esteban-Juan_");
		partidos.append("2008/Clausura/4/Por La Coca/3/7/Cospel-Esteban-Gustavo_");
		partidos.append("2008/Clausura/5/Taiwan/2/10/Cospel-Esteban_");
		partidos.append("2008/Clausura/6/El Ciclon/3/4/Esteban-Cospel-Nico_");
		partidos.append("2008/Clausura/7/Figurita Repetida/5/2/Cristhian-Cospel-Esteban-Nico-Juan_");
		partidos.append("2008/Clausura/8/La Nutria/2/3/Juan-Nico_");
		partidos.append("2008/Clausura/9/Salseros/6/9/Cospel-Cospel-Esteban-Esteban-Juan-Nico_");
		partidos.append("2008/Promocion Descenso/1/Figurita Repetida/2/5/Nico-Nico_");
		partidos.append("2008/Promocion Descenso/2/Taladro/2/7/Cospel-Nico_");
		partidos.append("2008/Promocion Descenso/3/Venimos De Gira/1/3/Nico_");
		partidos.append("2008/Promocion Descenso/4/El Rejunte/3/6/Esteban-Esteban-Juan_");
		partidos.append("2008/Promocion Descenso/5/Mu�equito/3/2/Juan-Juan-Esteban_");
		partidos.append("2008/Copa Libertadores/1/Joga Bonito/2/10/Juan-Juan_");
		partidos.append("2008/Copa Libertadores/2/Papagartes/1/3/Esteban_");
		partidos.append("2008/Copa Libertadores/3/Por La Coca/4/1/Cospel-Cospel-Cospel-Cristhian_");

		partidos.append("2009/Apertura/1/Paso A Paso/7/7/Esteban-Esteban-Esteban-Esteban-Juan-Nico-Cristhian_");
		partidos.append("2009/Apertura/2/Futbol Champagne/5/6/Esteban-Esteban-Esteban-Esteban-Nico_");
		partidos.append("2009/Apertura/3/Papagartes/10/2/Esteban-Esteban-Esteban-Esteban-Nico-Nico-Cristhian-Cristhian-Fede-Fede_");
		partidos.append("2009/Apertura/4/Hay Equipo/5/3/Esteban-Esteban-Juan-Juan-Cristhian_");
		partidos.append("2009/Apertura/5/Villa Adelina/5/7/Cospel-Cospel-Juan-Nico-En Contra_");
		partidos.append("2009/Apertura/6/C Men/1/7/Cristhian_");
		partidos.append("2009/Apertura/7/Franja De Oro/0/2/_");
		partidos.append("2009/Apertura/8/Los Mismos De Siempre/4/1/Cospel-Cospel-Esteban-Nico_");
		partidos.append("2009/Apertura/9/Real Coholicos/4/2/Juan-Juan-Cristhian-Nico_");
		partidos.append("2009/Apertura/10/Alkitran/0/10/_");
		partidos.append("2009/Apertura/11/Alacantula/8/2/Nico-Nico-Nico-Juan-Cristhian-Cospel-Gustavo-Esteban_");
		partidos.append("2009/Apertura/12/Halcones/5/2/Cospel-Cospel-Cospel-Cospel-Nico_");
		partidos.append("2009/Promocion Ascenso/1/Gatoreit/1/0/Nico_");
		partidos.append("2009/Promocion Ascenso/2/Los Mismos De Siempre/0/4/_");
		partidos.append("2009/Promocion Ascenso/3/Venimos De Gira/3/0/Esteban-Esteban-Gustavo_");
		partidos.append("2009/Clausura/1/Gatoreit/1/6/Fede_");
		partidos.append("2009/Clausura/2/Taiwan/0/1/_");
		partidos.append("2009/Clausura/3/Villa Adelina/4/5/Nico-Nico-Fede-Fede_");
		partidos.append("2009/Clausura/4/Rustikos/2/5/Nico-Fede_");
		partidos.append("2009/Clausura/5/Ferneteados/4/4/Juan-Juan-Esteban-Esteban_");
		partidos.append("2009/Clausura/6/Michagar/2/7/Esteban-Juan_");
		partidos.append("2009/Clausura/7/El Rejunte/3/7/Nico-Cospel-Cristhian_");
		partidos.append("2009/Clausura/8/Faca/2/3/Sin Anotar-Sin Anotar_");
		partidos.append("2009/Clausura/9/Ottoo/7/5/Esteban-Esteban-Esteban-Cospel-Cospel-Nico-Nico_");
		partidos.append("2009/Clausura/10/Olimpiakos/2/10/Sin Anotar-Sin Anotar_");
		partidos.append("2009/Clausura/11/Los Mismos De Siempre/2/4/Juan-Nico_");
		partidos.append("2009/Clausura/12/Resta/2/3/Nico-Cristhian_");
		partidos.append("2009/Promocion Descenso/1/El Dedo/0/6/_");
		partidos.append("2009/Promocion Descenso/2/Gatoreit/0/2/_");
		partidos.append("2009/Promocion Descenso/3/Ebrad/2/6/Nico-Cospel_");
		
		
		partidos.append("2010/Apertura/1/Gatoreit/8/10/Esteban-Esteban-Esteban-Topo-Topo-Juan-Fede-Cospel_");
		partidos.append("2010/Apertura/2/Internados/3/10/Nico-Nico-En Contra_");
		partidos.append("2010/Apertura/3/Pipiolos/2/5/Esteban-Cospel_");
		partidos.append("2010/Apertura/4/Sin Anestesia/2/7/Esteban-Esteban_");
		partidos.append("2010/Apertura/5/Ottoo/1/5/Cospel_");
		partidos.append("2010/Apertura/6/Franco Canadiense/10/3/Esteban-Esteban-Esteban-Esteban-Esteban-Esteban-Nico-Nico-Mati Herlein-Cristhian_");
		partidos.append("2010/Apertura/7/Oporto/4/2/Juan-Juan-Mati Herlein-Esteban_");
		partidos.append("2010/Apertura/8/Puchi/3/2/Mati Herlein-Nico-Esteban_");
		partidos.append("2010/Apertura/9/Paso A Paso/6/3/Juan-Juan-Nico-Nico-Esteban-Esteban_");
		partidos.append("2010/Apertura/10/Rica La Pulpa/3/6/Juan-Esteban-Mati Herlein_");
		partidos.append("2010/Apertura/11/Cosme Fulanito/3/7/Esteban-Esteban-Fede_");
		partidos.append("2010/Apertura/12/Cocodrilo/5/11/Nico-Nico-Juan-Topo-Mati Herlein_");
		partidos.append("2010/Clausura/1/Quien Ataja/4/5/Mati Herlein-Mati Herlein-Mati Herlein-Esteban_");
		partidos.append("2010/Clausura/2/Deportivo Empate/3/2/Cospel-Mati Herlein-Esteban_");
		partidos.append("2010/Clausura/3/Oporto/6/1/Mati Herlein-Mati Herlein-Mati Herlein-Mati Herlein-Nico-Cospel_");
		partidos.append("2010/Clausura/4/Franco Canadiense/3/4/Mati Herlein-Mati Herlein-Fede_");
		partidos.append("2010/Clausura/5/Rusticos Champagne/5/1/Mati Herlein-Mati Herlein-Mati Herlein-Nico-Esteban_");
		partidos.append("2010/Clausura/6/Apo/3/2/Cospel-Cospel-Mati Herlein_");
		partidos.append("2010/Clausura/7/Totenham/4/2/Mati Herlein-Mati Herlein-Esteban-Juan_");
		partidos.append("2010/Clausura/8/Toronja Mecanica/3/3/Cospel-Cospel-Nico_");
		partidos.append("2010/Clausura/9/Juguemos Los Sabados/2/4/Mati Herlein-Topo_");
		partidos.append("2010/Clausura/10/Sara Goza/2/10/Mati Herlein-Cospel_");
		partidos.append("2010/Reducido/1/Juguemos Los Sabados/5/2/Mati Herlein-Mati Herlein-Mati Herlein-Cospel-Cospel_");
		partidos.append("2010/Reducido/2/Sara Goza/2/6/Mati Herlein-Cospel_");
		partidos.append("2010/Promocion Ascenso/1/Sara Goza/2/2/Mati Herlein-Esteban_");
		partidos.append("2010/Promocion Ascenso/2/Toscana/4/1/Cospel-Cospel-Esteban-Esteban_");
		partidos.append("2010/Promocion Ascenso/3/Rica La Pulpa/7/2/Mati Herlein-Mati Herlein-Mati Herlein-Juan-Juan-Nico-Cospel_");

		partidos.append("2011/Apertura/1/Totenham/6/5/Mati Herlein-Mati Herlein-Esteban-Esteban-Juan-Cospel_");
		partidos.append("2011/Apertura/2/Toscana/2/5/Juan-Esteban_");
		partidos.append("2011/Apertura/3/Deportivo Empate/3/2/Mati Herlein-Mati Herlein-Esteban_");
		partidos.append("2011/Apertura/4/Trotsky/2/2/Cospel-Mati Herlein_");
		partidos.append("2011/Apertura/5/Imhotep/1/3/Esteban_");
		partidos.append("2011/Apertura/6/Veni Que Te Explico/3/6/Esteban-Cospel-Mati Herlein_");
		partidos.append("2011/Apertura/7/Los Bebus/2/5/Esteban-Nico_");
		partidos.append("2011/Apertura/8/Desde Abajo/5/3/Esteban-Esteban-Esteban-Mati Herlein-Mati Herlein_");
		partidos.append("2011/Apertura/9/El Tero/4/5/Nico-Mati Herlein-Cospel-En Contra_");
		partidos.append("2011/Apertura/10/Corona FC/0/5/_");
		partidos.append("2011/Apertura/11/Weylon/6/3/Esteban-Esteban-Esteban-Cospel-Mati Herlein-En Contra_");
		partidos.append("2011/Promocion Descenso/1/Toscana/2/1/Esteban-Mati Herlein_");
		partidos.append("2011/Promocion Descenso/2/Son Negocios/1/2/Mati Herlein_");
		partidos.append("2011/Promocion Descenso/3/Dumbin/1/7/Cospel_");
		partidos.append("2011/Clausura/1/Bison Lyon/1/7/Esteban_");
		partidos.append("2011/Clausura/2/Imhotep/3/4/Nico-Nico-Cospel_");
		partidos.append("2011/Clausura/3/Orson Blanco/1/7/Juan_");
		partidos.append("2011/Clausura/4/Son Negocios/1/3/Nico_");
		partidos.append("2011/Clausura/5/Malwi Futsal/2/5/Esteban-Nico_");
		partidos.append("2011/Clausura/6/La Calle/5/12/Pato-Pato-Pato-Esteban-Esteban_");
		partidos.append("2011/Clausura/7/Toscana/8/4/Esteban-Esteban-Esteban-Esteban-Esteban-Juan-Juan-Nico_");
		partidos.append("2011/Clausura/8/El Rejunte/7/10/Emi-Emi-Emi-Emi-Esteban-Esteban-Nico_");
		partidos.append("2011/Clausura/9/Weylon/4/12/Esteban-Esteban-Mati Herlein-Mati Herlein_");
		partidos.append("2011/Clausura/10/Vizcarra/5/10/Cospel-Cospel-Esteban-Esteban-Emi_");
		
		partidos.append("2012/Apertura/1/Deportivo Gambeta/4/3/Esteban-Esteban-Cospel-Nico_");
		partidos.append("2012/Apertura/2/Humildad Y Corazon/3/7/Cospel-Cospel-Juan_");
		partidos.append("2012/Apertura/3/Electrograma/3/10/Mati Herlein-Mati Herlein-Cospel_");
		partidos.append("2012/Apertura/4/Tu Hermanito/3/4/Cospel-Cospel-Esteban_");
		partidos.append("2012/Apertura/5/La Legua/7/12/Esteban-Esteban-Esteban-Esteban-Nico-Nico-Nico_");
		partidos.append("2012/Apertura/6/Los Vagos/2/0/Mati Herlein-Mati Herlein_");
		partidos.append("2012/Apertura/7/La Nutria/2/13/Topo-Cospel_");
		partidos.append("2012/Apertura/8/Los Del Balcon/3/4/Esteban-Esteban-Fede_");
		partidos.append("2012/Apertura/9/La Rebelion/1/11/Juan_");
		partidos.append("2012/Apertura/10/Alfileres Y Bidones/3/9/Mati Herlein-Cospel-Juan_");
		partidos.append("2012/Promocion Descenso/1/El Rejunte/2/5/Juan-Juan_");
		partidos.append("2012/Promocion Descenso/2/Los Gedientos/2/7/Juan-Esteban_");
		partidos.append("2012/Clausura/1/Doble X/2/6/Esteban-Nico_");
		partidos.append("2012/Clausura/2/Franco Canadiense/1/3/Martin Heit_");
		partidos.append("2012/Clausura/3/Creo Que La Amo/4/6/Fede-Juan-Juan-Esteban_");
		partidos.append("2012/Clausura/4/Quien Ataja/1/7/Juan_");
		partidos.append("2012/Clausura/5/Los Frustrados/2/8/Esteban-Esteban_");
		partidos.append("2012/Clausura/6/Joven Hamburguesa/2/5/Nico-Nico_");
		partidos.append("2012/Clausura/7/Las Torres/2/8/Aldo-Pato_");
		partidos.append("2012/Clausura/8/Los Gedientos/4/8/Nico-Nico-Lea Tense-Pato_");
		partidos.append("2012/Clausura/9/Caruchones/4/9/Nico-Martin Heit-Cospel-Lea Tense_");
		partidos.append("2013/Apertura/1/Ac Medos/1/6/Mati Herlein_");
		partidos.append("2013/Apertura/2/Ribo/4/1/Mati Herlein-Nico-Lea Aguerri-Lea Aguerri_");
		partidos.append("2013/Apertura/3/Constantinopla/4/2/Nico-Nico-Nico-Esteban_");
		partidos.append("2013/Apertura/4/Le Blue/2/5/Nico-Nico_");
		partidos.append("2013/Apertura/5/Cabi/0/2/_");
		partidos.append("2013/Apertura/6/Los Tiburones/1/1/Juan_");
		partidos.append("2013/Apertura/7/Molinete FC/2/4/Esteban-Juan_");
		partidos.append("2013/Apertura/8/La Revolucion/4/4/Martin Heit-Martin Heit-Nico-Nico_");
		partidos.append("2013/Apertura/9/Ludue�a Rustic Club/7/2/Esteban-Esteban-Esteban-Esteban-Nico-Nico-Nico_");
		partidos.append("2013/Apertura/10/La Masia/2/2/Lea Aguerri-Lea Aguerri_");
		partidos.append("2013/Apertura/11/Dementes/2/1/Juan-Lea Aguerri_");
		partidos.append("2013/Libertadores Inicial/1/Los Soprano/3/5/Cospel-Martin Heit-Esteban_");
		partidos.append("2013/Libertadores Inicial/2/La Cuadra/1/4/Esteban_");
		partidos.append("2013/Libertadores Inicial/3/Ebda/4/13/Esteban-Esteban-Nico-Eduardo_");
		partidos.append("2013/Clausura/1/Branca/1/11/Nico_");
		partidos.append("2013/Clausura/2/Galaxy FC/3/4/Esteban-Esteban-Nico_");
		partidos.append("2013/Clausura/3/LPA/2/8/Lea Aguerri-Ale Aguerri_");
		partidos.append("2013/Clausura/4/Babilonia/3/6/Juan-Nico-Nico_");
		partidos.append("2013/Clausura/5/FC Mova/4/1/Nico-Nico-Juan-Martin Heit_");
		partidos.append("2013/Clausura/6/Dep. Fondo De Olla/1/0/Esteban_");
		partidos.append("2013/Clausura/7/Dementes/1/3/Lea Aguerri_");
		partidos.append("2013/Clausura/8/Borbotones/4/1/Martin Heit-Martin Heit-Esteban-Nico_");
		partidos.append("2013/Libertadores Final/1/Cobra Falta FC/6/9/Juan-Juan-Cospel-Cospel-Nico-Martin Heit_");
		partidos.append("2013/Libertadores Final/2/Intergarchionale/2/8/Pato-Nico_");
		partidos.append("2013/Libertadores Final/3/Galaxy FC/3/9/Nico-Santi-Juan_");

		partidos.append("2014/Apertura/1/Cadims/2/1/Lea Aguerri-Lea Aguerri_");
		partidos.append("2014/Apertura/2/Progreso FC/5/4/Lea Aguerri-Lea Aguerri-Lea Aguerri-Juan-Martin Heit_");
		partidos.append("2014/Apertura/3/Euros/5/1/Esteban-Esteban-Lea Aguerri-Martin Heit-Cospel_");
		partidos.append("2014/Apertura/4/Hay Equipo/1/6/Juan_");
		partidos.append("2014/Apertura/5/Real Kolicos/0/6/_");
		partidos.append("2014/Apertura/6/Tu Hermana/2/2/Esteban-Esteban_");
		partidos.append("2014/Apertura/7/Carditt City/4/0/Esteban-Esteban-Fede-Martin Heit_");
		partidos.append("2014/Apertura/8/EPG/2/0/Martin Heit-Nico_");
		partidos.append("2014/Apertura/9/Frappe FC/3/6/Esteban-Esteban-Lea Aguerri_");
	    partidos.append("2014/Apertura/10/Pontepreta/2/5/Nico-Lea Aguerri_");
		partidos.append("2014/Apertura/11/Superamigos/10/2/Martin Heit-Martin Heit-Martin Heit-Fede-Fede-Nico-Cristhian-Esteban-Pato-Lea Aguerri_");
		
		partidos.append("2014/Clausura/1/Galanes del Balon/6/9/Esteban-Esteban-Esteban-Martin Heit-Lea Aguerri-Nico_");
		partidos.append("2014/Clausura/2/Parias/9/1/Martin Heit-Martin Heit-Martin Heit-Martin Heit-Esteban-Esteban-Esteban-Juan-Juan_");
		partidos.append("2014/Clausura/3/Los Killers/7/12/Esteban-Esteban-Esteban-Esteban-Nico-Nico-Juan_");
		partidos.append("2014/Clausura/4/Boliche Indio/8/4/Martin Heit-Martin Heit-Martin Heit-Martin Heit-Esteban-Esteban-Nico-Ale Aguerri_");
		partidos.append("2014/Clausura/5/Pase Largo/8/4/Esteban-Esteban-Esteban-Nico-Nico-Pato-Pato-Coti_");
		partidos.append("2014/Clausura/6/Mas Que Todos/4/8/Esteban-Esteban-Pato-Pato_");
		partidos.append("2014/Clausura/7/CAF/5/2/Pato-Pato-Pato-Esteban-Lea Aguerri_");
		partidos.append("2014/Clausura/8/Hay Equipo/5/3/Esteban-Esteban-Martin Heit-Juan-Nico_");
		partidos.append("2014/Clausura/9/Palo Bonito/2/7/Lea Aguerri-Martin Heit_");
		
		partidos.append("2015/Apertura/1/MR/5/3/Cospel-Cospel-Nico-Nico-Esteban_");
		partidos.append("2015/Apertura/2/Galanes del Balon/3/3/Juan-Juan-Esteban_");
		partidos.append("2015/Apertura/3/Le France/7/3/Esteban-Esteban-Esteban-Nico-Juan-Lea Aguerri-En Contra_");
		partidos.append("2015/Apertura/4/Real Infico/7/4/Esteban-Esteban-Lea Aguerri-Lea Aguerri-Juan-Ale Aguerri-Pato_");
		partidos.append("2015/Apertura/5/Parias/8/2/Nico-Nico-Lea Aguerri-Lea Aguerri-Pato-Pato-Fede-Ale Aguerri_");
		partidos.append("2015/Apertura/6/Hay Equipo/7/2/Pato-Pato-Pato-Lea Aguerri-Lea Aguerri-Lea Aguerri-Cospel_");
		partidos.append("2015/Apertura/7/Paquetetraje FC/3/3/Nico-Lea Aguerri-Esteban_");
		partidos.append("2015/Apertura/8/Jogo Feito/1/3/Esteban_");
		partidos.append("2015/Apertura/9/Doping Positivo/2/2/Juan-Esteban_");
		partidos.append("2015/Apertura/10/Trinidad Y Estos Vagos/3/8/Juan-Cospel-Esteban_");
		
		partidos.append("2015/Clausura/1/Animales Sueltos/2/7/Nico-Topo_");
		partidos.append("2015/Clausura/2/Alto Pasto/3/8/Juan-Topo-Cristhian_");
		partidos.append("2015/Clausura/3/Hay Equipo/2/5/Nico-Ale Aguerri_");
		partidos.append("2015/Clausura/4/Babilonia/2/2/Pato-Esteban_");
		partidos.append("2015/Clausura/5/Don Johnson/5/4/Esteban-Esteban-Nico-Nico-Ale Aguerri_");
		partidos.append("2015/Clausura/6/Paquetetraje FC/3/13/Esteban-Nico-Lea Aguerri_");
		partidos.append("2015/Clausura/7/Alfileres Y Bidones/3/10/Juan-Juan-Nico_");
		partidos.append("2015/Clausura/8/Jogo Feito/4/11/Juan-Nico-Nico-Nico_");






		String[] vectorPartidos = (partidos.toString()).split("_");
		int numeroDePartido=0;
		
		  for(int i=0;i<vectorPartidos.length;i++){
					  
			  String partidoActual = vectorPartidos[i];
			  
				  
				String[] elementoPartido = partidoActual.split("/");
				
				List<String> listaGoleadores = new ArrayList<String>();

					numeroDePartido++;
					String temporada = elementoPartido[0];
					String campeonato = elementoPartido[1];
					String numFecha = elementoPartido[2];
					String rival = elementoPartido[3];
					String goleasAfavor = elementoPartido[4];
					String golesEnContra = elementoPartido[5];
					
					if(elementoPartido.length==7){
						
						String goleadores=elementoPartido[6];
						
						String[] vectorGoleadores = goleadores.split("-");

						for(int j=0;j<vectorGoleadores.length;j++) {
							
							listaGoleadores.add(vectorGoleadores[j]);

						}

						if (listaGoleadores.size() != Integer.valueOf(goleasAfavor)) {
							return null;
						}
					}
					
					
					
				
				String resultadoPartido=goleasAfavor+" - "+ golesEnContra;

				Partido partido=new Partido();
				partido.setNumeroDePartido(numeroDePartido);
				partido.setAnio(Integer.valueOf(temporada));
				partido.setCampeonato(campeonato);
				partido.setNumeroDeFecha(Integer.valueOf(numFecha));
				partido.setNombreEquipoRival(rival);
				partido.setResultado(resultadoPartido);			
				partido.setAutoresDeGoles(listaGoleadores.toString());
				partido.setGolesEnContra(Integer.valueOf(golesEnContra));
				
				resultado.add(partido);
				
			}
		
		return resultado;
	}
	
	public static ArrayList<Partido> obtenerListadoDePartidosPaginado(int numeroDePagina){
		
		int inicio=0;
		int fin=0;
		
		if(numeroDePagina==1){
			inicio=0;
			fin=22;
		}else if(numeroDePagina==2){
			inicio=22;
			fin=44;
		}else if(numeroDePagina==3){
			inicio=44;
			fin=66;
		}else if(numeroDePagina==4){
			inicio=66;
			fin=88;
		}else if(numeroDePagina==5){
			inicio=88;
			fin=110;
		}else if(numeroDePagina==6){
			inicio=110;
			fin=132;
		}else if(numeroDePagina==7){
			inicio=132;
			fin=154;
		}else if(numeroDePagina==8){
			inicio=154;
			fin=176;
		}else if(numeroDePagina==9){
			inicio=176;
			fin=198;
		}else if(numeroDePagina==10){
			inicio=198;
			fin=220;
		}else if(numeroDePagina==11){
			inicio=220;
			fin=242;
		}
		
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		
		ArrayList<Partido> partidosPaginados = new ArrayList<Partido>();

		partidos=obtenerPartidos();
		
		Collections.reverse(partidos);
		
		
		for (int i=inicio;i<fin && i!=partidos.size();i++) {
			  partidosPaginados.add(partidos.get(i));
		}
		
		return partidosPaginados;
	}
}
