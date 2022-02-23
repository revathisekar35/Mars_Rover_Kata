package com.techreturners.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.techreturners.rover.service.iml.RoverServiceImpl;

public class RoverServiceTest {
	RoverServiceImpl roverService;

	@Before
	public void init() {
		roverService = new RoverServiceImpl();
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void moveRoverSuccessTest() throws Exception {

		List<String> input = new ArrayList<String>();
		input.add("55");
		input.add("12N");
		input.add("LMLMLMLMM");
		input.add("33E");
		input.add("MMRMMRMRRM");
		List<String> output = new ArrayList<String>();
		output.add("13N");
		output.add("51E");
		Map<String, String> roverOutput = roverService.moveRover(input);
		assertEquals(output.get(0), roverOutput.get("Rover1 Position"));
		assertEquals(output.get(1), roverOutput.get("Rover2 Position"));

	}

	@Test
	public void moveRoverFailureTest() throws Exception {
		List<String> input = new ArrayList<String>();
		input.add("55");
		input.add("33E");
		input.add("MMMRMMRMRRM");
		Map<String, String> roverOutput = roverService.moveRover(input);
		assertEquals("Rover position doesn't available", roverOutput.get("Rover1 Message"));

	}

	@Test
	public void setRoverPositionNegativeTest() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage("X,Y coordinates values shouldn't be negative vaules");
		roverService.setRoverPosition(0, "-12", "MMMRMMRMRRM");
		roverService.setRoverPosition(0, "1-2", "MMMRMMRMRRM");
	}

}
