package com.techreturners.rover.model;
/**
 * 
 *  L - Spins the Rover 90 degrees Left without moving from the current coordinate point.
 *  R - Spins the Rover 90 degrees Right without moving from the current coordinate point.
 *  
 *   Based on above instruction, the final rover facing direction is calculated 
 *
 */

public enum RoverMovementDirection {
	NL('W'),NR('E'),SL('E'),SR('W'),EL('N'),ER('S'),WL('S'),WR('N');
	char direction;
	RoverMovementDirection(char direction){
		this.direction = direction;
	}

}
