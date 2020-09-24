/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

		public void run() 
		{
			int count = 1;
			count = findMiddle(count);
			moveToMiddle(count);
			placeBeeperTurn();
		}
		
		/*
		 * Moves to the next wall and counts the steps it takes.
		 */
		public int findMiddle(int count) 
		{
			while(frontIsClear() == true) 
			{
				move();
				count++;
			}
			return count;
		}
		
		/*
		 * Divides the amount of steps it takes in half and walks back 
		 * the resulting amount.
		 */
		public void moveToMiddle(int count)
		{
			count = count / 2;
			turnAround();
			for(int i=0; i<count; i++) 
			{
				move();
			}
			
		}
		
		/*
		 * Places the beeper at the middle and turns around. 
		 */
		public void placeBeeperTurn() 
		{
			putBeeper();
			turnAround();
		}
}
