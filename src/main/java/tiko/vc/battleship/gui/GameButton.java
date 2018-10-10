package tiko.vc.battleship.gui;

import javax.swing.JButton;

public class GameButton extends JButton {
	
	private char btnChar;
	
	private int xPosInBoard;
	private int yPosInBoard;
	
	public GameButton(char btnChar) {
		super(String.valueOf(btnChar));
		this.setBtnChar(btnChar);
	}
	
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

	public char getBtnChar() {
		return btnChar;
	}

	public void setBtnChar(char btnChar) {
		this.btnChar = btnChar;
	}	

}
