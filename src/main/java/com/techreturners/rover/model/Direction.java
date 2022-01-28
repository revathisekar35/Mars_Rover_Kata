package com.techreturners.rover.model;

public enum Direction {
	E('E'), W('W'), N('N'), S('S');

	public char direction;

	Direction(char direction) {
		this.direction = direction;
	}

}
