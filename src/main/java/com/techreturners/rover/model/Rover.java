package com.techreturners.rover.model;

import com.techreturners.Plateau.model.Plateau;

public class Rover {
	private int id;
	private int xCoordinate;
	private int yCoordinate;
	private char currentDirection;
	private boolean isMotion;
	private Plateau plateau;
	public Rover(int id,Plateau plateau){
		this.id = id;
		this.plateau = plateau;
	}
	
	public Rover() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public char getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(char currentDirection) {
		this.currentDirection = currentDirection;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	public boolean isMotion() {
		return isMotion;
	}
	public void setMotion(boolean isMotion) {
		this.isMotion = isMotion;
	}
	public Rover clone() throws CloneNotSupportedException { return (Rover) super.clone(); }

}
