package org.springboot.users.controller;

import java.util.List;
import java.util.Optional;

import org.springboot.users.entity.userEntity;
import org.springboot.users.service.positionService;
import org.springboot.users.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class userController {
	@Autowired
	userService userService;
	@Autowired
	positionService positionService;
//	
//	@RequestMapping("api/getAll")
//	public ResponseEntity<List<userEntity>> findAll() {
//		List<userEntity> user = userService.findAll();
//		return ResponseEntity.ok().body(user);
//	}
	

	@RequestMapping(value = "/")
	public String listUser(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("positions", positionService.getAll());
		return "list_user";
	}

	@RequestMapping(value = "/user/{id}/edit", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") Integer id, Model model) {
		Optional<userEntity> userEdit = userService.findById(id);
		userEdit.ifPresent(user -> model.addAttribute("user", user));
		return "edit_user";
	}

	@RequestMapping(value = "/user/{id}/save", method = RequestMethod.POST)
	public String save(userEntity userEntity) {
		userService.saveUser(userEntity);
		return "redirect:/";
	}

	@RequestMapping(value = "/user/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/add")
	public String addUser(Model model) {
		model.addAttribute("user", new userEntity());
		model.addAttribute("positions", positionService.getAll());
		return "add_user";
	}

	@RequestMapping(value = "/user/saveNew", method = RequestMethod.POST)
	public String saveNew(userEntity user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/user/search")
	public String search(@RequestParam("term") String term, Model model) {
		model.addAttribute("users", userService.search(term));
		return "list_user";
	}
}
