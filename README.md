# Mars_Rover_Kata
         This project demonstrate how the rovers move on a mars surface based on Plateau surface and instructions.
         
## Pre -Requiremets
- Java SE Development Kit 11
- Maven

### How to Get Started
- Fork this repo to your Github and then clone the forked version of this repo

### Running the Unit Tests
- You can run the unit tests in IntelliJ, or you can go to your terminal and inside the root of this directory, run:

`mvn test`

## Task
This project helps Rover to move around the surface.

Here the surface is Mars Plateau and based on input surface co-ordinates will be calculated.

This program will get input as rover position and instuction.
         i) Rover Position(Eg: 2 3 N) will give x,y co-ordinates of rover and direction of rover.
         ii) Instruction(Eg: LMLMLMLMM) have the information of rover next movement.
         
Instuction Clarification:
 
       i) L - Spins the Rover 90 degrees Left without moving from the current coordinate point.
      ii) R - Spins the Rover 90 degrees Right without moving from the current coordinate point.
     iii) M - Moves the Rover forward by one grid point, maintaining the same heading (i.e. from where the Rover is facing (its orientation)).

Here Plateau is square surface. In feature we can change the shape of the plateau.

Plateau surface have n number of Rovers, so Rovers move sequentially, this means that the first Rover needs to finish moving first before the next one can move.

This program also checks whether the next position is available to the rover or not and Is rover exceeding Plateau surface based on movement instruction.
If the position available will check the move sequentially and return the final rover position as output else Failure message will return

This success ouput will send to Rover and rovers move around surface of Mars.
    
