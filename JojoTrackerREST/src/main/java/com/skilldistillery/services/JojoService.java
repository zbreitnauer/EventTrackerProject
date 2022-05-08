package com.skilldistillery.services;

import java.util.List;

import com.skilldistillery.entities.Jojo;

public interface JojoService {
	
	List<Jojo> index();
	
	Jojo getJojoById(int id);
	
	Jojo createJojo(Jojo jojo);
	
	Jojo updateJojo(int id , Jojo jojo);
	
	boolean deleteJojo(int id);
	
	List<Jojo> findJojoByKeyword(String keyword);
	
	
}
