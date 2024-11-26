package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.exception.UserNotFoundException;
import com.example.model.Appointment;
import com.example.service.AppointmentService;

@Controller
@RequestMapping("/appointment")
public class AdminController {
	
	@Autowired
	private AppointmentService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "adminHome";
	}
	
	@GetMapping("/register")
	public String showRegistration() {
		return "registerUser";
	}
	
	@PostMapping("/save")
	public String saveAppointment(@ModelAttribute Appointment appointment, Model model){
		service.saveAppointment(appointment);
		int id = service.saveAppointment(appointment).getId();
		String message = "Record with id : '"+id+"'is saved successfully !";
		model.addAttribute("message", message);
		return "registerUser";
		
	}
	
	@GetMapping("/getAllAppointment")
	public String getAllAppointment(@RequestParam(value ="message", required = false )String message,Model model) {
		List<Appointment>appointment = service.getAllAppointments();
		model.addAttribute("list", appointment);
		model.addAttribute("message", message);
		return "allAppointment";
		
	}
	
	@GetMapping("/edit")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam int id) {
		String page = null;
		try {
			Appointment appointment = service.getAppointmentById(id);
			model.addAttribute("appointment", appointment);
			page="editAdmin";
		}
		catch(UserNotFoundException e){
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:getAllAppointment";
			
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateAppointment(
			@ModelAttribute Appointment appointment,
			RedirectAttributes attributes
			) {
		service.updateAppointment(appointment);
		int id = appointment.getId();
		attributes.addAttribute("message", "Appointment with id : '"+id+"' is updated successfully !" );
		return "redirect:getAllAppointment";
	}
	
	
	@GetMapping("/delete")
	public String deleteAppointment( @RequestParam int id, RedirectAttributes attributes) {
		try {
			service.deleteAppointmentById(id);
			attributes.addAttribute("message", "Appointment with Id :'"+id+"' is removed successfully!");
			} catch(UserNotFoundException e) {
				e.printStackTrace();
				attributes.addAttribute("message",e.getMessage());
				
			}
		return "redirect:getAllAppointment";
	}
	
	

}
