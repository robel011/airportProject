package edu.mum.cs.cs425.bookingFlightApplication.controller;

import java.util.List;



//import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import ch.qos.logback.core.net.SyslogOutputStream;
import edu.mum.cs.cs425.bookingFlightApplication.model.Airport;
import edu.mum.cs.cs425.bookingFlightApplication.service.AirportService;
//import edu.mum.cs.cs425.bookingFlightApplication.service.impl.AirportServiceImpl;



@Controller
public class AirportController {
	@Autowired
	private AirportService airportService;

	
	
	// showing list of airports
	@GetMapping(value="/list")
	public ModelAndView listAirports() {
		ModelAndView mav=new ModelAndView();
		
		// get the airports from the db
		List<Airport> airports= airportService.getAll();
		mav.addObject("airports", airports);
		mav.setViewName("airport/listOfAirports");
	      return mav;
	}
	
	
	
	//2
	@GetMapping("/new")
	public String addNewAirport(Model model) {
		
		// create model attribute to bind form dat
		Airport airport=new Airport();
		model.addAttribute("airport", airport);
		return "airport/addNewAirport";
	}
	
	
	
	
	//3
	
	@PostMapping("/save")
	public String saveAirport(@Valid @ModelAttribute("airport") Airport airport,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors());
			return "airport/addNewAirport";
		}
	     
		//save the airport	
		airport=airportService.save(airport);		
		//use a redirect to prevent duplicate submissions		
		return "redirect:/list";		
	}
	
	
	
	@RequestMapping("/edit/{airportId}")
	public ModelAndView UpdateAirport(@PathVariable(name="airportId") int airportId) {
		//System.out.println("Robiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		Airport airport=airportService.getAirportById(airportId);
		ModelAndView mav= new ModelAndView("airport/updateAirport-form");
	    mav.addObject("airport",airport);
	    return mav;
		
//		//get the airport from the service
//		Airport airport = airportService.getAirportById(id);
//		//set airport as a model attribute to pre-populate the form
//		model.addAttribute("airport", airport);		
//		//send over to our form
//		return "redirect:/new";	
	}
	
	
	
	
	
	// deleting a airport
		@RequestMapping(value="/delete/{airportId}", method = RequestMethod.GET)
		public String deleteAirport(@PathVariable(name="airportId")  int airportId){		
			airportService.delete(airportId);			
			return "redirect:/list";
		}
		
		
		

	//4 for updating airport
//	@GetMapping("/showFormForUpdate")
//	public String showFormForUpdate(@RequestParam("airportId") int id,
//			Model model) {
//		
//		//get the airport from the service
//		Airport airports= airportService.getAirportById(id);
//		
//		//set airport as a model attribute to pre-populate the form
//		model.addAttribute("airports", airports);
//		
//		//send over to our form
//		return "addNewAirport";
//		
//	}
	
	
	
//	@GetMapping("/delete")
//	public String delete(@RequestParam("airportId") int id) {
//		
//		//delete the employee
//		airportService.delete(id);
//		
//		return "redirect: /list";
//		
//	}

	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private AirportServiceImpl airportServiceImpl;
//	
//	
//	@GetMapping(value="/list")
//	public ModelAndView listAirports() {
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("airport", airportServiceImpl.searchAll());
//		mav.setViewName("airport/list");
//		
//		return mav;
//	}
//	
//	//adding  new airport
//	
//	@RequestMapping(value="/b", method=RequestMethod.POST)
//	public String addNewAirport(Model model) {
//		model.addAttribute("airport", new Airport());
//		
//		return "airport/edit";
//	}
//
//	// saving edited book
//	
//	@RequestMapping(value="/bookingFlight/airport/edit", method=RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("airport") Airport airport,
//			BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("errors", result.getAllErrors());
//			return "airport/edit";
//		}
//		
//		airport=airportServiceImpl.save(airport);
//		return "redirect:/bookingFlight/airport/list";
//	}
//	
//	 //getting airport for editing
//		
////	@RequestMapping(value="/bookinFlight/airport/{id}", method = RequestMethod.GET)
////	public String updateAirport(@PathVariable int id, Model model){	
////			model.addAttribute("airport", airportServiceImpl.getAirportById(id));
////			
////			return "airport/edit";
////		}
////		
	
	
}
