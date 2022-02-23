package com.techreturners.rover.model;

import com.techreturners.Plateau.model.Plateau;

public class Rover {
	private int id;
	private int xCoordinate;
	private int yCoordinate;
	private char currentDirection;
	private boolean isMotion;
	private String name;
	public Rover(int id,String name){
		this.id = id;
		this.name = name;
	}
	
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
	public boolean isMotion() {
		return isMotion;
	}
	public void setMotion(boolean isMotion) {
		this.isMotion = isMotion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
