package com.skilldistillery.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JojoTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Jojo jojo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    emf = Persistence.createEntityManagerFactory("JojoTrackerJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	    emf.close();
	}
	
	@BeforeEach
	void setUp() throws Exception {
	    em = emf.createEntityManager();
	   jojo = em.find(Jojo.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	   jojo = null;
	}

	@Test
	@DisplayName("Mapping Jojo entity")
	void test() {
		assertNotNull(jojo);
		assertEquals("Jonathan", jojo.getFirstname());
		assertEquals("Joestar", jojo.getLastname());
		assertEquals("Hamon",jojo.getStand());
	}

}
