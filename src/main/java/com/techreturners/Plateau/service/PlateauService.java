package com.techreturners.Plateau.service;

import java.util.List;

import com.techreturners.Plateau.model.Plateau;
import com.techreturners.rover.model.Rover;

public interface PlateauService {
	Plateau setSurfaceOfPlateau(Plateau plateau, int xCoordinate, int yCoordinate, List<Rover> rovers);

}
