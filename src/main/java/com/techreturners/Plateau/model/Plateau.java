package com.techreturners.Plateau.model;

import java.util.ArrayList;
import java.util.List;

import com.techreturners.rover.model.Rover;

public class Plateau {
	private int id;
	private int xCoordinate;
	private int yCoordinate;
	private List<Rover> rovers = new ArrayList<Rover>();

	public Plateau(int id, List<Rover> rovers) {
		this.id = id;
		this.rovers = rovers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
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

}
