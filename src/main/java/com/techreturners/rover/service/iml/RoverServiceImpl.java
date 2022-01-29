package com.techreturners.rover.service.iml;

import java.util.ArrayList;
import java.util.List;

import com.techreturners.Plateau.model.Plateau;
import com.techreturners.Plateau.service.PlateauService;
import com.techreturners.Plateau.service.impl.PlateauServiceImpl;
import com.techreturners.rover.model.Direction;
import com.techreturners.rover.model.Rover;
import com.techreturners.rover.model.RoverMovementDirection;
import com.techreturners.rover.service.RoverService;

public class RoverServiceImpl implements RoverService {
	List<Rover> rovers = new ArrayList<Rover>();
	Plateau plateau;
	PlateauService plateauService = new PlateauServiceImpl();
	private final char M = 'M';
	private final char R = 'R';
	private final char L = 'L';

	public RoverServiceImpl() {
		plateau = new Plateau(1, rovers);

	}

	public List<String> moveRover(List<String> input) {
		// As per document 1st input as Plateau coordiantes and others are rover
		// position and movement.
		List<String> finalRoverPosition = new ArrayList<String>();
		setPlateauValues(input.get(0));

		int roverId = 1;
		for (int i = 1; i < input.size();) {
			Rover rover = setRoverPosition(roverId, input.get(i), input.get(i++));
			if (isRoverAllowedToMove(rover, rovers)) {
				String roverInstruction = input.get(i++);
				char[] movementInstruction = roverInstruction.toCharArray();
				for (char nextMove : movementInstruction) {
					getFinalRoverPosition(nextMove, rovers, plateau, rover);
				}
				StringBuffer sb = new StringBuffer();
				sb.append(rover.getxCoordinate());
				sb.append(rover.getyCoordinate());
				sb.append(rover.getCurrentDirection());
				finalRoverPosition.add(sb.toString());
			}
			roverId++;

		}
		return finalRoverPosition;

	}

	/**
	 * Get the input of Plateau co-ordinates and set Plateau x,y coordinates
	 * 
	 * @param plateauCoordinates
	 * @return Plateau
	 */
	private Plateau setPlateauValues(String plateauCoordinates) {
		int coOrdinates = Integer.valueOf(plateauCoordinates);
		return plateauService.setSurfaceOfPlateau(plateau, coOrdinates / 10, coOrdinates % 10, rovers);
	}

	/**
	 * This method used to set x,y coordinates and direction of current rover
	 * position
	 * 
	 * @param roverId
	 * @param roverCurrentPosition
	 * @param roverMoveInstruction
	 * @return Rover
	 */
	private Rover setRoverPosition(int roverId, String roverCurrentPosition, String roverMoveInstruction) {
		Rover rover = new Rover(roverId, plateau);
		rover.setxCoordinate(Character.getNumericValue(roverCurrentPosition.charAt(0)));
		rover.setyCoordinate(Character.getNumericValue(roverCurrentPosition.charAt(1)));
		rover.setCurrentDirection(roverCurrentPosition.charAt(2));
		rovers.add(rover);
		return rover;
	}

	/**
	 * This method used to check previous rover movement
	 * 
	 * @param currentRover
	 * @param rovers
	 * @return boolean
	 */
	private boolean isRoverAllowedToMove(Rover currentRover, List<Rover> rovers) {
		int currentRoverIndex = rovers.indexOf(currentRover);
		Rover previousRover = null;
		if (currentRoverIndex != 0)
			previousRover = rovers.get(currentRoverIndex - 1);

		if (previousRover == null || (previousRover != null && !previousRover.isMotion())) {
			return true;
		}
		return false;
	}

	/**
	 * This method used to calculate the final rover position based on given
	 * instruction
	 * 
	 * @param moveInstruction
	 * @param rovers
	 * @param plateau
	 * @param currentRover
	 * @return String
	 */
	private void getFinalRoverPosition(char moveInstruction, List<Rover> rovers, Plateau plateau, Rover currentRover) {

		char currentRoverDirection = currentRover.getCurrentDirection();
		int currentRoverXcoordinate = currentRover.getxCoordinate();
		int currentRoverYcoordinate = currentRover.getyCoordinate();

		if (M == moveInstruction) {
			// based on rover position and direction calculating x,y values of rover
			if (currentRoverDirection == Direction.N.direction && plateau.getyCoordinate() > currentRoverYcoordinate) {
				currentRover.setyCoordinate(currentRoverYcoordinate + 1);
			} else if (currentRoverDirection == Direction.S.direction && plateau.getyCoordinate() < 0) {
				currentRover.setyCoordinate(currentRoverYcoordinate - 1);
			} else if (currentRoverDirection == Direction.E.direction
					&& plateau.getxCoordinate() > currentRoverXcoordinate) {
				currentRover.setxCoordinate(currentRoverXcoordinate + 1);
			} else if (currentRoverDirection == Direction.W.direction && plateau.getxCoordinate() < 0) {
				currentRover.setxCoordinate(currentRoverXcoordinate - 1);
			}
			// based on current rover direction calculating final diretion of rover
		} else if ((L == moveInstruction && currentRoverDirection == Direction.N.direction)
				|| (R == moveInstruction && currentRoverDirection == Direction.S.direction)) {
			currentRover.setCurrentDirection(RoverMovementDirection.NL.direction);
		} else if ((R == moveInstruction && currentRoverDirection == Direction.N.direction)
				|| (L == moveInstruction && currentRoverDirection == Direction.S.direction)) {
			currentRover.setCurrentDirection(RoverMovementDirection.NR.direction);
		} else if ((R == moveInstruction && currentRoverDirection == Direction.E.direction)
				|| (L == moveInstruction && currentRoverDirection == Direction.W.direction)) {
			currentRover.setCurrentDirection(RoverMovementDirection.ER.direction);
		} else {
			currentRover.setCurrentDirection(RoverMovementDirection.EL.direction);
		}
	}

}
