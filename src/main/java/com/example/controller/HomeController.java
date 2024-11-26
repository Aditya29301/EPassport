package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Appointment;
import com.example.model.UsrDtl;
import com.example.repository.AppointmentRepository;
import com.example.repository.Loginrepository;
import com.example.service.AppointmentService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	int loginid = 199;

	@Autowired
	private UserService userService;

	@Autowired
	AppointmentRepository appointmentRepo;

	@Autowired
	private Loginrepository repo;
	
	@Autowired
	private AppointmentService appService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/Register")
	public String Register() {
		return "Register";
	}

	@RequestMapping(value = "/appoint", method = RequestMethod.POST)
	public ModelAndView modelapt(@ModelAttribute Appointment ap) {

		ModelAndView modeler = new ModelAndView();

		appointmentRepo.save(ap);
		System.out.println(ap);
		System.out.println(ap.getId());
		System.out.println(ap.getEmail());
		modeler.setViewName("user/userindex");
		modeler.addObject("user", ap.getEmail());
		return modeler;
	}

//	public void removeVerificationMessageFromSession() {
//		try {
//			 HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//			 HttpSession session = request.getSession();
//			// session.setAttribute("message","");
//			 session.removeAttribute("verification message");
//			 }catch(RuntimeException ex) {
//				 ex.printStackTrace();
//			 }
//		
//	}
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UsrDtl user, HttpSession session) {

		boolean f = userService.checkEmail(user.getEmail());
		if (f) {
			session.setAttribute("msg", "Email Id Already Exists");

			System.out.println("Email Id Already Exists");

		} else {
			user.setRole("user");
			UsrDtl usrDtl = userService.createUser(user);

			if (usrDtl != null) {
				session.setAttribute("msg", "Register Successfully");

				System.out.println("Register Successfully");

			} else {
				session.setAttribute("msg", "Something Went Wrong");

				System.out.println("Something Went Wrong");

			}

		}

		return "login";

	}

	@RequestMapping(value = "/doLogin")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute UsrDtl user) {
		ModelAndView model = new ModelAndView();

		try {
			UsrDtl userDetails = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
			model.addObject("user", userDetails);
			loginid = userDetails.getId();
			if (userDetails != null) {
				if (userDetails.getRole().equals("admin")) {
					model.setViewName("adminHome");
					return model;
				} else {
					model.setViewName("user/userindex");
					return model;
				}

			}

			else {
				model.setViewName("login");
				return model;
			}
		}

		catch (Exception e) {

		}
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	@PostMapping("/applyapt")
	public String applyapt(Model m) {
		UsrDtl users = userService.findUserById(loginid);
		m.addAttribute("uservar", users);
		return "userhome";
	}

	@PostMapping("/checkStatus")
	public String getAppointments(Model m) {
	//	System.out.print(loginid);
		Appointment appointment = appService.findAppointmentById(loginid);
		System.out.print(appointment);
		m.addAttribute("uservar", appointment);
		return "checkuserstatus";
	}

}
