package com.distribuidas.tpo;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import controlador.Controlador;
import exceptions.EdificioException;
import exceptions.PersonaException;
import exceptions.ReclamoException;
import exceptions.UnidadException;
import views.EdificioView;
import views.PersonaView;
import views.ReclamoView;
import views.UnidadView;


/**
 * Handles requests for the application home page.
 */
// @CrossOrigin(origins="*")
@Controller
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/verEdificios", method = RequestMethod.GET)
	public @ResponseBody String ListarEdificios() throws JsonProcessingException, EdificioException, UnidadException {
		ObjectMapper mapper = new ObjectMapper();
		List<EdificioView> edificios = Controlador.getInstancia().getEdificios();
		return mapper.writeValueAsString(edificios);
	}

	  /* getUnidadesPorEdificio(int codigo) */
	
	 @RequestMapping(value = "/verUnidades={id}", method = RequestMethod.GET)
	 public @ResponseBody String ListarUnidades(@PathVariable("id")int codigo) throws JsonProcessingException,EdificioException, UnidadException {
		  ObjectMapper mapper = new ObjectMapper();
		  List<UnidadView> resultado = Controlador.getInstancia().getUnidadesPorEdificio(codigo);
		  return mapper.writeValueAsString(resultado);
	 }
	  
	  /* parsear : https://stackoverflow.com/questions/3653996/how-to-parse-a-json-string-into-jsonnode-in-jackson*/
	  /* Habilitados por edificio */
	
	  @RequestMapping(value = "/verHabilitadoXEdificio={id}", method = RequestMethod.GET)
	  public @ResponseBody String ListarHabilitados(@PathVariable("id")int codigo) throws JsonProcessingException, EdificioException, UnidadException, PersonaException{ 
		  ObjectMapper mapper = new ObjectMapper();
	  	  List<PersonaView> resultado = Controlador.getInstancia().habilitadosPorEdificio(codigo);
	  	  return mapper.writeValueAsString(resultado);
	  }
	  
	  
	  /* duenios por edificio */
	  
		
	  @RequestMapping(value = "/verDueniosXEdificios={id}", method = RequestMethod.GET)
	  public @ResponseBody String ListarDuenios(@PathVariable("id")int codigo) throws JsonProcessingException, EdificioException, UnidadException, PersonaException{
	  	ObjectMapper mapper = new ObjectMapper();
		List<PersonaView> resultado = Controlador.getInstancia().dueniosPorEdificio(codigo);
		return mapper.writeValueAsString(resultado);
	  }
	  
	 /* InquilinosPorEdificio */
	 
	
	  @RequestMapping(value = "/verInquilinosXEdificio={id}", method = RequestMethod.GET)
	  public @ResponseBody String ListarInquilinosPorEdificios(@PathVariable("id")int codigo) throws JsonProcessingException, EdificioException, UnidadException, PersonaException{
	 	ObjectMapper mapper = new ObjectMapper();
		List<PersonaView> resultado = Controlador.getInstancia().inquilinosPorEdificio(codigo);
		return mapper.writeValueAsString(resultado);
	  }
	  
	 /*  Habitantes por edificios */
	  
	  @RequestMapping(value = "/verHabitantesXEdificio={id}", method = RequestMethod.GET)
	  public @ResponseBody String ListarHabitantesPorEdificio(@PathVariable("id")int codigo) throws JsonProcessingException, EdificioException, UnidadException, PersonaException{ 
		ObjectMapper mapper = new ObjectMapper(); 
		List<PersonaView> resultado = Controlador.getInstancia().inquilinosPorEdificio(codigo); 
		return mapper.writeValueAsString(resultado); 
	  }
	  
	 /* Duenios por unidad  */
	 
	  @RequestMapping(value = "/verDueniosXUnidad/{p1}/{p2}/{p3}", method = RequestMethod.GET)
	  public @ResponseBody String ListarDueniosPorUnidad(@PathVariable("p1")int codigo, @PathVariable("p2")String piso, @PathVariable("p3")String numero) throws JsonProcessingException, UnidadException, EdificioException, PersonaException{ 
		ObjectMapper mapper = new ObjectMapper(); 
		List<PersonaView> resultado = Controlador.getInstancia().dueniosPorUnidad(codigo, piso, numero); 
		return mapper.writeValueAsString(resultado); 
	  }
	  
	 /* inquilinos por unidad  */
	  
	  @RequestMapping(value ="/verInquilinosXUnidad/{p1}/{p2}/{p3}", method = RequestMethod.GET)
	  public @ResponseBody String ListarInquilinosPorUnidad(@PathVariable("p1")int codigo, @PathVariable("p2")String piso, @PathVariable("p3")String numero) throws UnidadException, EdificioException, PersonaException, JsonProcessingException{ 
		ObjectMapper mapper = new ObjectMapper(); 
		List<PersonaView> resultado = Controlador.getInstancia().inquilinosPorUnidad(codigo, piso, numero); 
		return mapper.writeValueAsString(resultado); 
	  }
	  
	  /* consultar reclamo */
	  
	  @RequestMapping(value ="/verReclamo={id}", method = RequestMethod.GET)
	  public @ResponseBody String ListarReclamoPorId(@PathVariable("id")int codigo) throws JsonProcessingException, ReclamoException{
		  ObjectMapper mapper = new ObjectMapper();
		  ReclamoView resultado = Controlador.getInstancia().getReclamo(codigo);
		  return mapper.writeValueAsString(resultado);
		  
	  }
	  
	  /* consultar todos los reclamos */
	  @RequestMapping(value ="/verTodosLosReclamos", method = RequestMethod.GET, produces="application/json")
	  public @ResponseBody String ListarReclamosAll() throws JsonProcessingException{
		  ObjectMapper mapper = new ObjectMapper();
		  List<ReclamoView> resultado = Controlador.getInstancia().getReclamosAll();
		  return mapper.writeValueAsString(resultado);
	  }
	  
	  /* grabar reclamo*/
	  @RequestMapping(value="/GrabaReclamo", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	  public @ResponseBody String GrabarReclamo(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException {
				  
		  int resultado;
		  
		  ReclamoView rec = new ReclamoView();
		  
		  ObjectMapper mapper = new ObjectMapper();
		 
		  rec = mapper.readValue(json, ReclamoView.class);
		  
		  resultado = Controlador.getInstancia().GrabarReclamo(rec.getDocumento(),rec.getCodigo(),rec.getUbicacion(),rec.getDescripcion(),rec.getIdentificador());
		  
		  return mapper.writeValueAsString(String.valueOf("su numero de reclamo es:" + resultado));
		 
	  }
	  
	  
	  	  
}
