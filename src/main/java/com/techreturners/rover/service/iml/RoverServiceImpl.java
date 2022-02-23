package com.techreturners.rover.service.iml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	/**
	 * As we don't have database and based on input assume only 2 rovers going to
	 * land on Plateau and created object to the same, if we want we can add extra
	 * rover here
	 */
	public RoverServiceImpl() {
		plateau = new Plateau(1, rovers);
		rovers.add(new Rover(1, "Rover1"));
		rovers.add(new Rover(2, "Rover2"));
	}

	/**
	 * This method used to calculate the final movement of rover based on input. If
	 * rover movement doen't available will give error message
	 */
	public Map<String, String> moveRover(List<String> input) {
		Map<String, String> finalRoverPosition = new HashMap<String, String>();
		try {
			// As per document 1st input as Plateau coordinates and others are rover
			// position and movement.
			setPlateauValues(input.get(0));
			int roverId = 1;
			for (int i = 1; i < input.size();) {
				Rover rover = setRoverPosition(roverId, input.get(i), input.get(i++));
				// set rover motion true to stop the next rover movement once moved successfully
				// rover motion will set to false
				rover.setMotion(true);
				if (isRoverAllowedToMove(rover, rovers)) {
					String roverInstruction = input.get(i++);
					char[] movementInstruction = roverInstruction.toCharArray();
					boolean isSuccess = true;
					for (char nextMove : movementInstruction) {
						// If rover next move position available success will be true else false
						if (isSuccess)
							isSuccess = checkAndSetFinalRoverPosition(nextMove, rovers, plateau, rover);
						else
							break;
					}
					StringBuffer sb = new StringBuffer();
					sb.append(rover.getxCoordinate());
					sb.append(rover.getyCoordinate());
					sb.append(rover.getCurrentDirection());

					if (isSuccess) {
						finalRoverPosition.put(rover.getName() + " Message",
								"Rover successfully moved to the position");
						finalRoverPosition.put(rover.getName() + " Position", sb.toString());
					} else {
						finalRoverPosition.put(rover.getName() + " Message", "Rover position doesn't available");

					}
				}
				roverId++;
				rover.setMotion(false);
			}
		} catch (ArrayIndexOutOfBoundsException ai) {
			System.out.println("Array Indeoutofbound Exception occured in moveRover method" + ai.getMessage());
		} catch (Exception e) {
			System.out.println("Exception ocuured in moveRover method " + e.getMessage());
			e.printStackTrace();
		}
		return finalRoverPosition;

	}

	/**
	 * Get the input of Plateau coordinates and set Plateau x,y coordinates
	 * 
	 * @param plateauCoordinates
	 * @return Plateau
	 */
	public Plateau setPlateauValues(String plateauCoordinates) {
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
	 * @throws Exception 
	 */
	public Rover setRoverPosition(int roverId, String roverCurrentPosition, String roverMoveInstruction) throws Exception {
		Rover rover = getRoverById(roverId);
		// If rover doesn't exit on rover list, it will create new rover
		if (rover == null) {
			rover = new Rover(roverId, "Rover" + roverId);
			rovers.add(rover);

		}
		int x = Character.getNumericValue(roverCurrentPosition.charAt(0));
		int y = Character.getNumericValue(roverCurrentPosition.charAt(1));
		if (x > 0 && y > 0) {
			rover.setxCoordinate(Character.getNumericValue(roverCurrentPosition.charAt(0)));
			rover.setyCoordinate(Character.getNumericValue(roverCurrentPosition.charAt(1)));
			rover.setCurrentDirection(roverCurrentPosition.charAt(2));
		}else {
			throw new Exception("X,Y coordinates values shouldn't be negative vaules");
		}
		return rover;
	}

	/**
	 * Get rover based on rover id
	 * 
	 * @param roverId
	 * @return Rover
	 */
	private Rover getRoverById(int roverId) {
		List<Rover> roverList = rovers.stream().filter(p -> p.getId() == roverId).collect(Collectors.toList());
		if (roverList == null || roverList.isEmpty())
			return null;
		else
			return roverList.get(0);
	}

	/**
	 * This method used to check previous rover motion
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
	 * instruction, Plateau and other rovers.
	 * 
	 * @param moveInstruction
	 * @param rovers
	 * @param plateau
	 * @param currentRover
	 * @return boolean
	 * @throws Exception
	 */
	private boolean checkAndSetFinalRoverPosition(char moveInstruction, List<Rover> rovers, Plateau plateau,
			Rover currentRover) {
		try {
			char currentRoverDirection = currentRover.getCurrentDirection();
			int currentRoverXcoordinate = currentRover.getxCoordinate();
			int currentRoverYcoordinate = currentRover.getyCoordinate();

			if (M == moveInstruction) {
				/*
				 * Based on rover position and direction calculating x,y values of rover. Added
				 * condition for rover not to exceed Plateau. Check whether other rovers already
				 * present in the current move
				 */
				if (currentRoverDirection == Direction.N.direction && plateau.getyCoordinate() > currentRoverYcoordinate
						&& !rovers.stream().anyMatch(p -> (p.getyCoordinate() == (currentRoverYcoordinate + 1)
								&& p.getxCoordinate() == currentRover.getxCoordinate()))) {
					currentRover.setyCoordinate(currentRoverYcoordinate + 1);
				} else if (currentRoverDirection == Direction.S.direction && currentRoverYcoordinate >= 0
						&& !rovers.stream().anyMatch(p -> (p.getyCoordinate() == (currentRoverYcoordinate - 1)
								&& p.getxCoordinate() == currentRover.getxCoordinate()))) {
					currentRover.setyCoordinate(currentRoverYcoordinate - 1);
				} else if (currentRoverDirection == Direction.E.direction
						&& plateau.getxCoordinate() > currentRoverXcoordinate
						&& plateau.getxCoordinate() > currentRoverXcoordinate
						&& !rovers.stream().anyMatch(p -> (p.getxCoordinate() == (currentRoverXcoordinate + 1)
								&& p.getyCoordinate() == currentRover.getyCoordinate()))) {
					currentRover.setxCoordinate(currentRoverXcoordinate + 1);
				} else if (currentRoverDirection == Direction.W.direction && currentRoverXcoordinate >= 0
						&& !rovers.stream().anyMatch(p -> (p.getxCoordinate() == (currentRoverXcoordinate + 1)
								&& p.getyCoordinate() == currentRover.getyCoordinate()))) {
					currentRover.setxCoordinate(currentRoverXcoordinate - 1);
				} else {
					return false;
				}
				// based on current rover direction calculating final direction of rover
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
		} catch (NullPointerException ne) {
			System.out.println("Null pointer exception occured in checkAndSetFinalRoverPosition " + ne.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occured in checkAndSetFinalRoverPosition " + e.getMessage());
		}
		return true;
	}

}
