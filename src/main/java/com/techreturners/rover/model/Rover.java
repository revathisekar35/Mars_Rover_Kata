package com.techreturners.rover.model;

public class Rover {
	private int id;
	private int xAxis;
	private int yAxis;
	private char currentDirection;
	private String status;
	private Plateau plateau;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public char getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(char currentDirection) {
		this.currentDirection = currentDirection;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

}
