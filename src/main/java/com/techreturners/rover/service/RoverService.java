package com.techreturners.rover.service;

import java.util.List;
import java.util.Map;

public interface RoverService {
	Map<String, String> moveRover(List<String> input) throws Exception;
}
