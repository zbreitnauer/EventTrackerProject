package com.skilldistillery.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.entities.Jojo;
import com.skilldistillery.services.JojoService;

@RestController
@RequestMapping("api")
public class JojoController {
	
	@Autowired
	JojoService ser;
	
	@GetMapping("jojo")
	public List<Jojo> listJojo(){
		return ser.index();
	}

	@GetMapping("jojo/{id}")
	public Jojo showJojo(@PathVariable int id, HttpServletResponse res) {
		Jojo jojo = ser.getJojoById(id);
		if (jojo == null) {
			res.setStatus(404);
		}

		return jojo;
	}
}
