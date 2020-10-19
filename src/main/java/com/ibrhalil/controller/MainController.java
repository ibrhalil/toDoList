package com.ibrhalil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibrhalil.service.NotService;

@Controller
@RequestMapping(path = "/")
public class MainController 
{
	@Autowired
	private NotService notService;
	
	@GetMapping
	public String toDoList(Model model)
	{
		model.addAttribute("notlar", notService.notlar());
		return "toDoList";
	}
}
