package com.his.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.constant.AppConstant;
import com.his.model.User;
import com.his.service.RoleService;
import com.his.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("msg", "Welcome Back !!");
		System.out.println("UserController.home()");
		return "/index";
	}

	@GetMapping(value = "/user")
	public String loadForm(Model model) {
		model.addAttribute("user", new User());
		Map<Integer, String> roles = roleService.getAllRole();
		System.out.println("UserController.roles() " + roles);
		model.addAttribute("roles", roles);
		return "userRegistration";
	}

	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		userService.saveUser(user);
		model.addAttribute("msg", user.getFirstName() + " " + user.getLastName()
				+ "User Registration Successfully Submited Please verify ur mail");
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
		User updateUser = userService.getUserByEmail(user.getEmail());
		updateUser.setPassword(user.getPassword());
		updateUser.setAccStatus(AppConstant.UNLOCKED);
		userService.updateUser(updateUser);
		model.addAttribute("msg",
				updateUser.getFirstName() + " " + updateUser.getLastName() + "User Updated Successfully");
		return "/index";
	}

	@GetMapping(value = "/getAllUser")
	public String getAllUser(Model model) {
		List<User> users = userService.getAllUser();
		log.info("All user" + users);
		model.addAttribute("user", users);
		return "/viewAllUser";
	}

	@GetMapping(value = "/unlockUser")
	public String unlockUser(@RequestParam("uId") Integer uId, Model model) {
		System.out.println("UserController.unlockUser()" + uId);
		User user = userService.getUserById(uId);
		user.setAccStatus(AppConstant.UNLOCKED);
		userService.updateUser(user);
		model.addAttribute("user", user);
		return "redirect:/getAllUser";
	}

	@GetMapping(value = "/deleteUser")
	public String deleteUser(@RequestParam("uId") Integer uId, Model model) {
		System.out.println("UserController.deleteUser()" + uId);
		User user = userService.getUserById(uId);
		user.setAccStatus(AppConstant.LOCKED);
		userService.updateUser(user);
		model.addAttribute("user", user);
		return "redirect:/getAllUser";
	}}
