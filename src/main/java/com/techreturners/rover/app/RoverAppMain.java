package com.techreturners.rover.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techreturners.rover.service.RoverService;
import com.techreturners.rover.service.iml.RoverServiceImpl;

public class RoverAppMain {
	public static void main(String[] args) throws Exception {
		RoverService roverService = new RoverServiceImpl();
		List<String> input = new ArrayList<String>();
		input.add("55");
		input.add("12N");
		input.add("LMLMLMLMM");
		input.add("33E");
		input.add("MMMRMMRMRRM");
		Map<String, String> finalRoverPosition = roverService.moveRover(input);
		System.out.println("Output of Rovers:\n");
		finalRoverPosition.forEach((k, v) -> System.out.println(k + ": " + v + "\n"));
	}
}
