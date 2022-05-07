package com.skilldistillery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.entities.Jojo;

public interface JojoRepository extends JpaRepository <Jojo, Integer>{
	
	List<Jojo> findByFirstnameLike(String keyword);

}
