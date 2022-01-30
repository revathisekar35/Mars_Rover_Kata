# Mars_Rover_Kata

This project helps Rover to move around the surface.

Here the surface is Mars Plateau and based on input surface co-ordinates will be calculated.

This program will get input as rover position and instuction.
         i) Rover Position(Eg: 2 3 N) will give x,y co-ordinates of rover and direction of rover.
         ii) Instruction(Eg: LMLMLMLMM) have the information of rover next movement.
         
Instuction Clarification:
 
       i) L - Spins the Rover 90 degrees Left without moving from the current coordinate point.
      ii) R - Spins the Rover 90 degrees Right without moving from the current coordinate point.
     iii) M - Moves the Rover forward by one grid point, maintaining the same heading (i.e. from where the Rover is facing (its orientation)).
     
Plateau surface have n number of Rovers, so Rovers move sequentially, this means that the first Rover needs to finish moving first before the next one can move.

This program also checks whether the next position is available to the rover or not and Is rover exceeding Plateau surface based on movement instruction.
If the position available will check the move sequentially and return the final rover position as output else Failure message will return

This success ouput will send to Rover and rovers move around surface of Mars.
    
