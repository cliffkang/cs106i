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

	public void run() {
		DiagonalBeeperRun();
		GetToOtherWall();
		turnAround();
		FindCenterBeeperAndGetToFirstRow();
		putBeeper();
		GoToOriginalPosition();
		ClearDiagonalBeepers();
		ReturnToMidpoint();
	}
	private void DiagonalBeeperRun() {
		putBeeper();
		moveDiagonal();
		putBeeper();
		while(rightIsClear()) {
			turnRight();
			moveDiagonal();
			putBeeper();
		}
	}
	private void moveDiagonal() {
		move();
		turnLeft();
		move();
	}
	private void GetToOtherWall() {
		turnLeft();
		moveToWall();
	}
	private void moveToWall() {
		while(frontIsClear()) {
			move();
		}
	}
	private void FindCenterBeeperAndGetToFirstRow() {
		while(frontIsClear()) {
			move();
			turnRight();
			if(beepersPresent()) {
				moveToWall();
			} 	else {
				move();
			}
			if(beepersPresent()) {
				moveToWall();
			} else if (frontIsClear()){
				turnLeft();
			}
		}
	}
	private void GoToOriginalPosition() {
		turnRight();
		moveToWall();
		turnAround();
	}
	private void ClearDiagonalBeepers() {
		while(frontIsClear()) {
			pickBeeper();
			moveDiagonal();
			turnRight();
		}
		pickBeeper();
	}
	private void ReturnToMidpoint() {
		turnRight();
		moveToWall();
		turnRight();
		while(noBeepersPresent()) {
			move();
		}
	}
}
