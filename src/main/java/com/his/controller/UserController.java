package com.his.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.his.model.User;
import com.his.service.CityService;
import com.his.service.CountryService;
import com.his.service.StateService;
import com.his.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Welcome Back !!");
		System.out.println("UserController.home()");
		return "/index";
	}

	@GetMapping(value = "/user")
	public String loadForm(Model model) {
		model.addAttribute("user", new User());
		Map<Integer, String> countries = countryService.getAllCountry();
		System.out.println("UserController.loadForm()" + countries);
		model.addAttribute("countriesMap", countries);
		return "userRegistration";
	}

	@GetMapping(value = "/getStates")
	@ResponseBody
	public Map<Integer, String> getStates(@RequestParam("cid") Integer countryId) {
		System.out.println("UserController.getState()" + stateService.getState(countryId));
		return stateService.getState(countryId);
	}

	@GetMapping(value = "/getCities")
	@ResponseBody
	public Map<Integer, String> getCities(@RequestParam("sid") Integer stateId) {
		System.out.println("UserController.getCities()" + cityService.getCities(stateId));
		return cityService.getCities(stateId);
	}

	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		userService.saveUser(user);
		model.addAttribute("msg", "User Registration Successfully Submited Please verify ur mail");
		return "/index";
	}

	@GetMapping(value = "/unlockAcc")
	public String unlockAcc(@RequestParam("email") String email, Model model) {
		System.out.println("UserController.saveUser()" + email);
		User user = userService.getUserByEmail(email);
		model.addAttribute("user", user);
		return "/userPasswordReset";
	}

	@PostMapping(value = "/updateUser")
	public String updateUser(@ModelAttribute("user") User user, Model model) {
		userService.updateUser(user);
		model.addAttribute("msg", "User Updated Successfully");
		return "/index";
	}

	@GetMapping(value = "/getAllUser")
	public String getAllUser(Model model) {
		List<User> user = userService.getAllUser();
		log.info("All user" + user);
		model.addAttribute("user", user);
		return "/viewAllUser";
	}
}
