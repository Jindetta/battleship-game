package tiko.vc.battleship.gui;

import java.awt.event.ActionEvent;

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
	 * Tells that to what board this button belongs. Used mostly
	 * for checking if the button is players or bots.
	 */
	private BoardPanel board;

	/**
	 * 
	 */
	public GameButton(BoardPanel board, String btnText, int xPosInBoard, int yPosInBoard) {
		super(btnText);
		setBoard(board);
		setxPosInBoard(xPosInBoard);
		setyPosInBoard(yPosInBoard);
		
		if(getBoard().getBoardType() == BoardPanel.BoardType.PLAYER &&
				(getxPosInBoard() > 0 && getyPosInBoard() > 0))
			addActionListener(this::buttonPressed);
	}
	
	/**
	 * Called when this button is pressed.
	 * 
	 * @param e
	 */
	private void buttonPressed(ActionEvent e) {
		System.out.println("Hey");
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
	public BoardPanel getBoard() {
		return board;
	}
	public void setBoard(BoardPanel board) {
		this.board = board;
	}

}
