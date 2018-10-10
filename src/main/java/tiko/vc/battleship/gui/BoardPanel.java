package tiko.vc.battleship.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;



public class BoardPanel extends JPanel {
	
	public static final int BOARD_SIZE = GUI.FRAME_WIDTH / 2 - 10;

	public static enum BoardType {PLAYER, BOT};
	
	private static final String COLUMN_NAMES = "ABCDEFGHIJ";
	
	private GameButton[][] boardButtons;
	
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
