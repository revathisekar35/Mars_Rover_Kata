package com.techreturners.rover.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	private int id;
	private int xAxis;
	private int yAxis;
	private List<Rover> rovers = new ArrayList<Rover>();
	
	public Plateau(int id, List<Rover> rovers){
		this.id = id;
		this.rovers =rovers;
	}
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
	public List<Rover> getRovers() {
		return rovers;
	}
	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}

}
