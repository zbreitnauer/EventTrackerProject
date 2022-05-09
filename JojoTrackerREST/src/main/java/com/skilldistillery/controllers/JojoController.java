package com.skilldistillery.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("jojo")
	public Jojo createJojo(@RequestBody Jojo jojo, HttpServletResponse res) {
		Jojo joestar = ser.createJojo(jojo);

		if (joestar == null) {
			res.setStatus(404);
		} else {
			res.setStatus(201);
		}
		return joestar;

	}
	
	@PutMapping("jojo/{id}")
	public Jojo updatejojo(@PathVariable int id, @RequestBody Jojo jojo, HttpServletResponse res) {
		try {
			jojo = ser.updateJojo(id, jojo);
			if (jojo == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			jojo = null;
		}
		return jojo;

	}
	
	@DeleteMapping("jojo/{id}")
	public void deleteJojo(@PathVariable int id, HttpServletResponse res) {
		try {
			if (ser.deleteJojo(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	@GetMapping("jojo/search/{keyword}")
	public List<Jojo> searchJojoBykeyword(@PathVariable String keyword, HttpServletResponse res ){	
		return ser.findJojoByKeyword(keyword);
	}
}
