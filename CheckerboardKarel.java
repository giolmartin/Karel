/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		
		
		
		if(frontIsBlocked() == true) {
			placeBeeperException();
		}
			
		while (frontIsClear() == true ) {
				
				placeBeepers();
				switchStreetWest();
				
				if (facingNorth() == false) {
				placeBeepers();	
				switchStreetEast();
				}
		}
		
	}
	
	/*
	 * Places Beepers on one street moving East
	 */
	
	public void placeBeepers(){
		
		
		putBeeper();
		
		while(frontIsClear() == true) {
			
			move();
			
			if(frontIsClear() == true) {
				
				move();
				putBeeper();
			
			}
		}
		
	}
	
	/*
	 * Places beeper moving West
	 */
	
	public void placeBeepersOdd() {
		

		while(frontIsClear() == true) {
		
		move();
		putBeeper();
		
			
			if(frontIsClear() == true) {
			
			move();
			
			}
		
		}
	}

	/*
	 * Changes street, moving North and facing West
	 */
	
	public void switchStreetWest() {
		
		if (facingNorth() == false) {
		turnLeft();
		}
		
		if(frontIsClear() == true) {
			move();
			turnLeft();
		}
	}
	
	/*
	 * Changes street, moving North and facing East
	 */
	public void switchStreetEast() {
		
		if (facingNorth() == false) {
			turnRight();
			}
		if(frontIsClear() == true) {
			move();
			turnRight();
		} 
			
		
		
	}
	
	/*
	 * This is a resolution when there is only ONE avenue present. 
	 */
	
	public void placeBeeperException(){
		
		if(leftIsClear() == true) {
		
			turnLeft();
		}
		
		if (frontIsClear() == true) {
			placeBeepers();
		}
			
	}
	public void placeBeeperAvenueException() {
			turnLeft();
			putBeeper();
		
	}
	
	public void switchStreetsException() {
		
		if (frontIsClear() == true) {
			move();
		}
	}
	
}
