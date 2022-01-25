package com.techreturners.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RoverServiceTest {
	
	@Test
	public void moveRoverTest() {
		RoverService roverService = new RoverServiceImpl();
		
		assertEquals("13N", roverService.moveRover(55,"12N","LMLMLMLMM"));
		
	}

}
