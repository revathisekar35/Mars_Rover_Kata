package com.techreturners.rover.service.iml;

import java.util.ArrayList;
import java.util.List;

import com.techreturners.rover.model.Plateau;
import com.techreturners.rover.model.Rover;
import com.techreturners.rover.service.RoverService;

public class RoverServiceImpl implements RoverService {
	List<Rover> rovers = new ArrayList<Rover>();
	Plateau plateau;

	public RoverServiceImpl() {
		rovers.add(new Rover(1));
		rovers.add(new Rover(2));
		plateau = new Plateau(1, rovers);

	}

	public String moveRover(int plateauCoorinates, String roverCurrentPosition, String instruction) {
		setPlateauValues(plateauCoorinates);
		return null;
	}

	private Plateau setPlateauValues(int coOrdinates) {
		plateau.setxAxis(coOrdinates % 10);
		plateau.setyAxis(coOrdinates / 10);
		return plateau;
	}

}
