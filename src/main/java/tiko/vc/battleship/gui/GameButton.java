package tiko.vc.battleship.gui;

import javax.swing.JButton;

/**
 * This class is used to create a single button to the
 * BoardPanel.
 * 
 * @author Teemu
 *
 */
public class GameButton extends JButton {
	
	/**
	 * X position of the button in the 2D array found in BoardPanel.
	 */
	private int xPosInBoard;
	
	/**
	 * Y position of the button in the 2D array found in BoardPanel.
	 */
	private int yPosInBoard;
	
	/**
	 * 
	 */
	public GameButton(String btnText, int xPosInBoard, int yPosInBoard) {
		super(btnText);
		setxPosInBoard(xPosInBoard);
		setyPosInBoard(yPosInBoard);
	}
	
	
	/* GETTERU & SETTERU */
	
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
