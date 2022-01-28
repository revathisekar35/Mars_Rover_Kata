package com.techreturners.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.techreturners.rover.service.iml.RoverServiceImpl;

public class RoverServiceTest {
	
	@Test
	public void moveRoverTest() {
		RoverService roverService = new RoverServiceImpl();
		List<String> input = new ArrayList<String>();
		input.add("55");
		input.add("12N");
		input.add("LMLMLMLMM");
		input.add("33E");
		input.add("MMRMMRMRRM");
		
		assertEquals("13N", roverService.moveRover(input));
		
	}

}
