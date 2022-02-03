package com.techreturners.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.techreturners.rover.service.iml.RoverServiceImpl;

public class RoverServiceTest {

	@Test
	public void moveRoverSuccessTest() {
		RoverService roverService = new RoverServiceImpl();
		List<String> input = new ArrayList<String>();
		input.add("55");
		input.add("12N");
		input.add("LMLMLMLMM");
		input.add("33E");
		input.add("MMRMMRMRRM");
		input.add("33E");
		input.add("MMRMMRMRRM");
		List<String> output = new ArrayList<String>();
		output.add("13N");
		output.add("51E");
		Map<String, String> roverOutput = roverService.moveRover(input);
		assertEquals(output.get(0), roverOutput.get("Rover1 Position"));
		assertEquals(output.get(1), roverOutput.get("Rover2 Position"));
		assertEquals("Rover position doesn't available", roverOutput.get("Rover3 Message"));

	}

	@Test
	public void moveRoverFailureTest() {
		RoverService roverService = new RoverServiceImpl();
		List<String> input = new ArrayList<String>();
		input.add("55");
		input.add("33E");
		input.add("MMMRMMRMRRM");
		Map<String, String> roverOutput = roverService.moveRover(input);
		assertEquals("Rover position doesn't available", roverOutput.get("Rover1 Message"));

	}

}
