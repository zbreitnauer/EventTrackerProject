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
		if (jo.isPresent()) {
			jojo = jo.get();
		}
		return jojo;
	}

	@Override
	public Jojo createJojo(Jojo jojo) {
		return repo.save(jojo);
	}

	@Override
	public Jojo updateJojo(int id, Jojo jojo) {
		Optional<Jojo> jo = repo.findById(id);
		Jojo jostar = null;
		if (jo.isPresent()) {
			jostar = jo.get();
			jostar.setFirstname(jojo.getFirstname());
			jostar.setLastname(jojo.getLastname());
			jostar.setAge(jojo.getAge());
			jostar.setHeight(jojo.getHeight());
			jostar.setWeight(jojo.getWeight());
			jostar.setStand(jojo.getStand());
			jostar.setImage(jojo.getImage());
			repo.saveAndFlush(jostar);
		}
		return jostar;
	}

	@Override
	public boolean deleteJojo(int id) {
		boolean deleted = false;
		if(repo.existsById(id)) {
			repo.deleteById(id);
			deleted = true;
		}
		return deleted;	}

	@Override
	public List<Jojo> findJojoByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return repo.findByFirstnameLike(keyword);
	}

}
