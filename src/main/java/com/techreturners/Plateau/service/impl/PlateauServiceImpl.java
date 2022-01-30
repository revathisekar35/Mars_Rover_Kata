package com.techreturners.Plateau.service.impl;

import java.util.List;

import com.techreturners.Plateau.model.Plateau;
import com.techreturners.Plateau.service.PlateauService;
import com.techreturners.rover.model.Rover;

public class PlateauServiceImpl implements PlateauService {

	public Plateau setSurfaceOfPlateau(Plateau plateau, int xCoordinate, int yCoordinate, List<Rover> rovers) {
		plateau.setxCoordinate(xCoordinate);
		plateau.setyCoordinate(yCoordinate);
		plateau.setRovers(rovers);
		return plateau;
	}

}
