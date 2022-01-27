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

	public String moveRover(int plateauCoorinates, String roverCurrentPosition, String instruction) {
		setPlateauValues(plateauCoorinates, rovers);
		return null;
	}

	private Plateau setPlateauValues(int coOrdinates, List<Rover> rovers) {
		return plateauService.setSquareSurfacePlateau(plateau, coOrdinates % 10, coOrdinates / 10, rovers);
	}

}
