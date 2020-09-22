import stanford.karel.*;


public class VotingBox extends SuperKarel {
	
	
	public void run() {
		
		checkMiddleChad();
		}
	public void checkMiddleChad() {
		
		if(beepersPresent() == true) {
			
				if(beepersPresent() == true) {
					turnHalf();
				}else {
					putBeeper();
					turnHalf();
				}
					if (beepersPresent() == true) {
						turnHalf();
					} else {
						putBeeper();
						turnLeft();
					}
				
		} else {
			move(); //"commit"
		}
		
	}
	
	public void turnHalf() { //turns Karel in 180 degrees
		turnLeft();
		turnLeft();
		}
	

}
