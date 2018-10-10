package tiko.vc.battleship.gui;

import javax.swing.JButton;

public class GameButton extends JButton {
	
	private int xPosInBoard;
	private int yPosInBoard;
	
	public int getxPosInBoard() {
		return xPosInBoard;
	}
	public void setxPosInBoard(int xPosInBoard) {
		this.xPosInBoard = xPosInBoard;
	}
	public int getyPosInBoard() {
		return yPosInBoard;
	}
	public void setyPosInBoard(int yPosInBoard) {
		this.yPosInBoard = yPosInBoard;
	}	

}
