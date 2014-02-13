/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run () {
		turnLeft();
		repairColumn();
		turnAround();
		moveToWall();
		repairColumns();
		turnLeft();
	}
	/* pre-condition: facing either up or down the column
	 * post-condition: facing wall
	 */
	private void repairColumn() {
		while (frontIsClear()) {
			if (beepersPresent()){
				move();
			} else {
				putBeeper();
				move();
			}
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	private void repairColumns() {
		while(leftIsClear()) {
			turnLeft();
			moveToNextColumn();
			turnLeft();
			repairColumn();
			turnAround();
			moveToWall();
		}
	}
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	private void moveToNextColumn() {
		for(int i=0; i<4; i++) {
			move();
		}
	}
/*	private void repairNextColumn() {
		if (leftIsBlocked()) {
			turnRight();
			repairColumn();
			if (leftIsClear()){
				turnLeft();
				moveToNextColumn();
			}
		} else {
			turnLeft();
			repairColumn();			
			if (rightIsClear()) {
				turnRight();
				moveToNextColumn();
			}
		}
	}*/
}
