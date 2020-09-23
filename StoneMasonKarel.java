/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here solves the "repair the quad"
 * problem from Assignment 1.  
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

public void run() {
	
	while (frontIsClear() == true) {
	
		fixColumn();
		moveToNextColumn();
		fixLastColumn();
		
	}
	
	System.out.println("Karel is tired and wants a beer and tacos. ");	
		
}

/*
 * Fixes an individual Column, starts at the bottom and 
 * ends at the starting position facing
 * East
 */

public void fixColumn() {
	
	placeMissingBlocks();
	turnAround();
	startingPosition();
	
}

/*
 * Prerequisite - Be positioned in a column 
 * Result - Moves upward placing missing beepers. Ends facing 
 * North
 */

public void placeMissingBlocks() {
	
	turnLeft();

	while (frontIsClear() == true) {
		if (beepersPresent() == false) {
			putBeeper();
		} else {
			move();
		}
	}

	if (beepersPresent() == false) {      //Places a beeper on the top of the column if missing.
		putBeeper();
	}
	
}

/*
 * Moves down and ends at 1st street facing 
 * East
 */

public void startingPosition() {
	
	while (frontIsClear() == true) {
		move();
	}
	turnLeft();
	
}

/*
 * Moves 4 Avenues to the next Column.
 */

public void moveToNextColumn() {
	
	for(int i = 0; i < 4 ; i++) {
		move();
	}
}

/*
 * Fixes the last Column when it detects a wall. 
 */

public void fixLastColumn() {
	
	if (frontIsBlocked() == true ) {
		
		fixColumn();
	}
}


}
