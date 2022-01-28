package com.techreturners.rover.service.iml;

import java.util.ArrayList;
import java.util.List;

import com.techreturners.Plateau.model.Plateau;
import com.techreturners.Plateau.service.PlateauService;
import com.techreturners.Plateau.service.impl.PlateauServiceImpl;
import com.techreturners.rover.model.Rover;
import com.techreturners.rover.service.RoverService;

public class RoverServiceImpl implements RoverService {
	List<Rover> rovers = new ArrayList<Rover>();
	Plateau plateau;
	PlateauService plateauService = new PlateauServiceImpl();

	public RoverServiceImpl() {
		rovers.add(new Rover(1, plateau));
		rovers.add(new Rover(2, plateau));
		plateau = new Plateau(1, rovers);

	}

	public String moveRover(List<String> input) {
		// As per document 1st input as Plateau coordiantes and others are rover
		// position and movement.

		// int totalRovers = ((input.size()-1)/2);
		setPlateauValues(input.get(0));
		int roverId = 1;
		for (int i = 1; i < input.size();) {
			Rover rover = setRoverPosition(roverId, input.get(i), input.get(i++));
			if(isRoverAllowedToMove(rover, rovers)) {
				input.get(i++);
				
			}
			roverId++;

		}
		return null;

	}

	private Plateau setPlateauValues(String plateauCoordinates) {
		int coOrdinates = Integer.valueOf(plateauCoordinates);
		return plateauService.setSquareSurfacePlateau(plateau, coOrdinates / 10, coOrdinates % 10, rovers);
	}

	private Rover setRoverPosition(int roverId, String roverCurrentPosition, String roverMoveInstruction) {
		Rover rover = new Rover(roverId, plateau);
		rover.setxCoordinate(roverCurrentPosition.charAt(0));
		rover.setyCoordinate(roverCurrentPosition.charAt(1));
		rover.setCurrentDirection(roverCurrentPosition.charAt(2));
		rovers.add(rover);
		return rover;
	}

	private boolean isRoverAllowedToMove(Rover currentRover, List<Rover> rovers) {
		int currentRoverIndex = rovers.indexOf(currentRover);
		Rover previousRover = rovers.get(currentRoverIndex-1);
		if(previousRover!= null && !previousRover.isMotion()) {
			return true;
		}
		return false;
	}

	
}
