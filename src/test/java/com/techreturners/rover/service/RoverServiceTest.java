package com.techreturners.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
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

		List<String> input = csvFileReader("src/resources/Rover_input.csv");
		
		List<String> output = csvFileReader("src/resources/Rover_output.csv");
		Map<String, String> roverOutput = roverService.moveRover(input);
		assertEquals(output.get(0), roverOutput.get("Rover1 Position"));
		assertEquals(output.get(1), roverOutput.get("Rover2 Position"));

	}
	
	private List<String> csvFileReader(String filePath) throws CsvValidationException, IOException{
		List<String> input = new ArrayList<String>();
		CSVReader inputReader = null;
		try {
			inputReader = new CSVReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File not found Exception");
		}
		String[] nextLine;
		while ((nextLine = inputReader.readNext()) != null) {
			for(String data :nextLine)
				input.add(data);
		}
		return input;
	}

	@Test
	public void moveRoverFailureTest() throws Exception {
		List<String> input = csvFileReader("src/resources/Rover_input_Failure.csv");
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
