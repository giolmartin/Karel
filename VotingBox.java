import stanford.karel.*;


public class VotingBox extends SuperKarel {
	
	
	public void run() {
		
		move(); // Moves Karel into the first voting rectangle. 
		
		while (frontIsClear()) {
		
			
			checkForVotes();
			
		}
		
		System.out.println("Ballot Finished \n" + "Karel is feeling democratic");
		
		}
	
	
	/*
	 * This class checks for middle punch.
	 * Prerequisite - Be in voting rectangle 
	 * Results - moves between voting rectangles and implements the correction.
	 */
	
	
	public void checkForVotes() {
		
		checkMiddlePunch();
		moveToVote();
		
	}
	
	/*
	 * Checks middle punch and corrects the vote.
	 * Result - A corrected YES or NO count vote punch. 
	 */
	
	public void checkMiddlePunch(){
		
		if(beepersPresent() == true) {
			fillNoVote();
			
		} else {
			fillVote();
			
		}
	}
	
	/*
	 * This class detects a middle punch not present and checks for completion of a no vote
	 * Prerequisite - Not detecting a middle punch.
	 * Result - All three punches are corrected for a correct NO vote count.
	 * 	
	 */
	public void fillNoVote() {
		
		
		moveToUpperPunch();
		checkUpperPunchNoVote();
		moveToBottomPunch();
		checkBottomPunchNoVote();
		startingPosition();
		
		
		
	}
	
	/*
	 * Prerequisite - No middle punch found 
	 * Result - All three punches are corrected for a correct YES vote count.
	 */
	
	public void fillVote() {
		
		
		moveToUpperPunch();
		checkUpperPunchVote();
		moveToBottomPunch();
		checkBottomPunchVote();
		startingPosition();
		
	}
	
	/*
	 * Checks the Upper Punch.
	 * Prerequisite - Middle punch was not used.
	 * Result - Fills the Upper Punch if necessary.
	 * 
	 */
	
	public void checkUpperPunchNoVote(){
		
		if(beepersPresent() == false) {
			putBeeper();
		}
	}
	
	
	/*
	 * Checks and fills the bottom punch if necessary. 
	 */
	
	public void checkBottomPunchNoVote() {
		
		if (beepersPresent() == false) {
			putBeeper();
		}
		
	}
	
	
	public void checkUpperPunchVote() {
		
		while (beepersPresent()) {
		
			pickBeeper();
		}
	}

	
	public void checkBottomPunchVote() {
		
		while(beepersPresent()) {
			pickBeeper();
		}
	}
	
	/*
	 * Move two spaces from vote to vote.
	 */
	public void moveToVote() {
		
		move();
		if(frontIsClear() == true) {
		move();
		} 
	}
	/*
	 *  Moves form the bottom punch to the middle punch and ends facing
	 *  
	 *  East
	 */
	
	public void startingPosition() {
		turnAround();
		move();
		turnRight();
		
	}
	
	/*
	 * Turns left and moves to the Upper Punch
	 */
	
	public void moveToUpperPunch() {
		turnLeft();
		move();
	}
	
	/*
	 * Turns Around and moves from the upper to the bottom punch.
	 */
	public void moveToBottomPunch() {
		turnAround();
		move();
		move();
	}
	
	/*
	 * Turns 180 degrees 
	 */
	
	public void turnAround() { 
		turnLeft();
		turnLeft();
		}
	

}
