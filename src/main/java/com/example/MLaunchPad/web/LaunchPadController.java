package com.example.MLaunchPad.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.MLaunchPad.domain.TypeRepository;
import com.example.MLaunchPad.domain.toDo;
import com.example.MLaunchPad.domain.toDoRepository;

@Controller
public class LaunchPadController {
	@Autowired
	private toDoRepository toDoRepo;
	
	@Autowired
	private TypeRepository typeRepo;
	
	//Open login
	@RequestMapping(value="login")
		public String login() {
			return "login";
	} 
	
	//Logout redirects to login page
	@RequestMapping(value="logout")
	public String logout() {
		return "redirect:login";
	}
	
	//Homepage opens
	@RequestMapping(value="/Mhome", method = RequestMethod.GET)
		public String home(Model model) {
			model.addAttribute("toDos", toDoRepo.findAll());
			return "Mhome";
	}
	
	//Create new toDo
	@RequestMapping(value="/createnew")
	public String createNewTodo(Model model) {
		model.addAttribute("toDo" , new toDo());
		model.addAttribute("types" , typeRepo.findAll());
		return "save";
	}
	
	//Save a toDo from button and route to mhome
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveToDo(toDo todo) {
		toDoRepo.save(todo);
		return "redirect:Mhome";
	}
	
	
	//Delete selected toDo
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
		public String deleteToDo(@PathVariable("id") long id, Model model) {
			toDoRepo.deleteById(id);
			return "redirect:../Mhome";
	}
	
	//Edit selected toDo
	@RequestMapping(value="/edit/{id}" , method=RequestMethod.GET)
		public String editToDo(@PathVariable("id") long id, Model model) {
			model.addAttribute("toDo", toDoRepo.findById(id));
			model.addAttribute("types", typeRepo.findAll());
			return "edit";
	}
	

}
