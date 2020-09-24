/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * The CheckerboardKarel class draws
 * a checker board using beepers, as described in Assignment 1.  Works for 
 * all samples supplied in the folder. 
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	
	public void run() {
		int counter = 0; //created counter to add movements. 
		
		if(frontIsBlocked() == true) { //1xN or 1x1 
			placeBeeperException();
		} 
			drawCheckBoard(counter);
		
	}
	
	public void drawCheckBoard(int counter) {
		
		while (frontIsClear() == true ) {	
			counter = 	placeBeepers(counter);	
				switchStreetWest();
				if (counter%2 == 0) {            //checks for Odd movements.
					placeBeepersOdd();}
				if (facingNorth() == false) {
			counter =	placeBeepers(counter);	
				switchStreetEast();
				}
		}	
	}
	
	/*
	 * Places Beepers on the street, 
	 *  i is a counter that measures he street and 
	 *  determines if odds or even.  
	 */
	
	public int placeBeepers(int i){
		while(frontIsClear() == true) {
			putBeeper();
			move();	
			i++;
				if(frontIsClear() == true) {
					move();
					i++;
					if(frontIsBlocked() == true) {
						putBeeper();
					}	
				} 
		}
		return i;
	}
	
	/*
	 * Prerequisite placeBeepers class places beeper right before a wall. 
	 * Result skips first beeper and moves to second position moving 
	 * West
	 */
	
	public void placeBeepersOdd() {
		
		while (frontIsClear() == true) {
			move();
			putBeeper();
			if (frontIsClear() == true) {
				move();
			}	
		}
	}

	/*
	 * Changes street, moving North and facing West
	 */
	
	public void switchStreetWest() {
		
		turnLeft();
		if(frontIsClear() == true) {
			move();
			turnLeft();
		}
	}
	
	/*
	 * Changes street, moving North and facing East
	 */
	public void switchStreetEast() {
		turnRight();
			
		if(frontIsClear() == true) {
			move();
			turnRight();
		} 		
	}
	
	/*
	 * This is a resolution when there is only ONE avenue present or a 1x1 world.
	 * Solves 1xn - 1x1 world.
	 */
	
	public void placeBeeperException(){		
		int i =0;
		if(leftIsClear() == true) {
			turnLeft();
		} else {
			putBeeper();
			turnLeft();
		}
		
		if (frontIsClear() == true) {
			placeBeepers(i);
		}
			
	}
	
}
