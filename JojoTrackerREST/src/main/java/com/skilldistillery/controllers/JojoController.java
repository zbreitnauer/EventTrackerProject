package com.skilldistillery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.entities.Jojo;
import com.skilldistillery.services.JojoService;

@RestController
@RequestMapping("api")
public class JojoController {
	
	@Autowired
	JojoService ser;
	
	@GetMapping("index")
	public List<Jojo> listJojo(){
		return ser.index();
	}

}
