package test;

import java.util.List;

import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.PersonaException;
import exceptions.ReclamoException;
import exceptions.UnidadException;
import views.EdificioView;
import views.PersonaView;
import views.ReclamoView;
import views.UnidadView;

public class Test {

	public static void main(String[] args) throws EdificioException, UnidadException, PersonaException, ReclamoException {
		
		List<EdificioView> edificios = Controlador.getInstancia().getEdificios();
		System.out.println("Edificios " + edificios.size());
		
		List<UnidadView> unidades = Controlador.getInstancia().getUnidadesPorEdificio(1);
		System.out.println("\nUnidades por edificio " + unidades.size());
		
		/*List<PersonaView> p1 = Controlador.getInstancia().habitantesPorEdificio(1);
		System.out.println("\nHabitantes por Edificio " +  p1.size());
		
		List<PersonaView> p2 = Controlador.getInstancia().dueniosPorEdificio(1);
		System.out.println("\nDuenios por Edificio " +  p2.size());
				
		List<PersonaView> p3 = Controlador.getInstancia().inquilinosPorEdificio(1);		
		System.out.println("\nInquilinos por Edificio " +  p3.size());

		List<PersonaView> p4 = Controlador.getInstancia().habilitadosPorEdificio(1);		
		System.out.println("\nHabilitados por Edificio " +  p4.size());
		
		List<PersonaView> pu = Controlador.getInstancia().dueniosPorUnidad(1, "1", "1");
		System.out.println("\nDuenios por unidad " + pu.size());

		List<PersonaView> iu = Controlador.getInstancia().inquilinosPorUnidad(1, "1", "1");
		System.out.println("\nInquilinos por unidad " + iu.size());		
		*/		
		
		/*
		 * int rec = Controlador.getInstancia().GrabarReclamo("DNI30734099",
		 * 1,"salta 54", "piso roto", 1);
		 * System.out.println("su numero de reclamo es : " + rec);
		 * 
		 * ReclamoView rv = Controlador.getInstancia().getReclamo(rec);
		 * System.out.println("su reclamo es: " + rv.toString());
		 * 
		 * 
		 * List<ReclamoView> reclamos = Controlador.getInstancia().getReclamosAll();
		 * System.out.println("reclamos: " + reclamos.size());
		 */
		 
		 /* numero, foto, tipo, idReclamo */
		 
	}

}
