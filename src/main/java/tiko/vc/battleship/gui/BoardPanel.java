package tiko.vc.battleship.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;



public class BoardPanel extends JPanel {
	
	/**
	 * Size of the JPanel. Used both in width and height.
	 */
	public static final int BOARD_SIZE = GUI.FRAME_WIDTH / 2 - 10;

	/**
	 * Enum that is used to define if the Board is
	 * players or bots.
	 */
	public static enum BoardType {PLAYER, BOT};
	
	/**
	 * Used for buttons texts that prints the coordinates.
	 */
	private static final String COLUMN_NAMES = "ABCDEFGHIJ";
	
	/**
	 * Buttons that are used in the JPanel. These buttons constructs
	 * the whole game and its played by clicking these.
	 */
	private GameButton[][] boardButtons;
	
	/**
	 * Sets the type of the board, either PLAYER or BOT.
	 */
	private BoardType boardType;
	
	/**
	 * 
	 */
	public BoardPanel(Color color, BoardType boardType) {
		super(new GridLayout(11, 11));
		
		this.boardType = boardType;
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setOpaque(true);
		
		setBackground(color);
		setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
		
		boardButtons = new GameButton[11][11];
		
		for(int rows = 0; rows < boardButtons.length; rows++) {
			for(int cols = 0; cols < boardButtons[rows].length; cols++) {
				String btnText = "";
				if(rows == 0 && cols > 0)
					btnText = String.valueOf(COLUMN_NAMES.charAt(cols-1));
				else if(cols == 0 && rows > 0)
					btnText = Integer.toString(rows);
				
				boardButtons[rows][cols] = new GameButton(btnText, rows, cols);
				add(boardButtons[rows][cols]);
			}
		}
	}
	
	/* GETTERU & SETTERU: */
	
	public GameButton[][] getBoardButtons() {
		return boardButtons;
	}

	public void setBoardButtons(GameButton[][] boardButtons) {
		this.boardButtons = boardButtons;
	}

	public BoardType getBoardType() {
		return boardType;
	}

	public void setBoardType(BoardType boardType) {
		this.boardType = boardType;
	}
	
}
