package com.skilldistillery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.entities.Jojo;
import com.skilldistillery.repositories.JojoRepository;
@Service
public class JojoServiceImpl implements JojoService {

	@Autowired
	JojoRepository repo;
	
	@Override
	public List<Jojo> index() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Jojo getJojoById(int id) {
		Optional<Jojo> jo = repo.findById(id);
		Jojo jojo = null;
		if(jo.isPresent()) {
			jojo = jo.get();
		}
		return jojo;
	}

	

	
	
	

}
