/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		
		moveToNewspaper();
		pickNewspaper();
		returnToStartingPosition();
		
	}

	/*
	 * Moves to the newspaper's position
	 */
	
	public void moveToNewspaper() {
		
		turnRight();
		move();
		turnLeft();
		
		while (beepersPresent() == false) {
			move();	
		}
	}
	
	/*
	 * Picks Newspaper.
	 */
	
	public void pickNewspaper() {
		
		while (beepersPresent() == true) {
			pickBeeper();
		}
	}
	
	/*
	 * Turns around and moves back to the original position. 
	 * Finishes looking 
	 * East.
	 */
	
	public void returnToStartingPosition() {
		
		turnAround();
		
		while (frontIsClear() == true) {
			move();
		}
		
		turnRight();
		move();
		turnRight();
		
	}
	
	/*
	 * Turns 180 degrees.
	 */
	
	public void turnAround() {
		turnLeft();
		turnLeft();
	}
}
