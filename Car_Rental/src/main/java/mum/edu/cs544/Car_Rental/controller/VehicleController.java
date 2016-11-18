package mum.edu.cs544.Car_Rental.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.cs544.Car_Rental.model.Category;
import mum.edu.cs544.Car_Rental.model.Vehicle;
import mum.edu.cs544.Car_Rental.service.CategoryService;
import mum.edu.cs544.Car_Rental.service.VehicleService;

@Controller

public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value={"","/vehicles"})
	public String listVehicles(Model model) {
 	
 		List<Vehicle> vehicleList= vehicleService.getAll();
 		model.addAttribute("vehicles", vehicleList);
 		
 		return "vehicles";
	}
	
  	@RequestMapping("/vehicle{id}")
	public String getVehicleById(@RequestParam("id") Long vehicleId, Model model) {

  		Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
  		
  		model.addAttribute("vehicle",vehicle);
		return "vehicle";
	}

  	
  	@RequestMapping("/vehicle/delete{id}")
	public String deleteProductById(@RequestParam("id") Long id, Model model) {
  		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
  	@RequestMapping(value="/vehicle/update{id}")
	public String updateVehicleById(@RequestParam("id") Long id,@ModelAttribute("updatedVehicle")Vehicle updatedVehicle, Model model) {

  		Vehicle vehicle = vehicleService.getVehicleById(id);
  		List<Category> category = categoryService.getAll();
  		model.addAttribute("vehicle", vehicle);
  		model.addAttribute("categories", category);
		return "updateVehicle";
	}
  	@RequestMapping(value="/vehicle/update{id}", method=RequestMethod.POST)
  	public String updateVehicle(@RequestParam("id") Long id,@ModelAttribute("updatedVehicle")Vehicle updatedVehicle, Model model){
  		updatedVehicle.setId(id);
  		vehicleService.addVehicle(updatedVehicle);
  		return "redirect:/vehicles";  	
  		}
	@RequestMapping(value = "/vehicle/add", method = RequestMethod.GET)
	public String addNewVehicle(@ModelAttribute("newVehicle") Vehicle newVehicle, Model model) {
	  List<Category> category = categoryService.getAll();
	  model.addAttribute("categories", category);
	   return "addVehicle";
	}
	   
	@RequestMapping(value = "/vehicle/add", method = RequestMethod.POST)
	public String processAddNewVehicle(@Valid @ModelAttribute("newVehicle")  Vehicle vehicleToBeAdded,BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()){
			return "addVehicle";
		}
		else
		{
			vehicleService.addVehicle(vehicleToBeAdded);
			redirect.addFlashAttribute("vehicle", vehicleToBeAdded);
			return "redirect:/vehicles";
		}
	}
	


}
