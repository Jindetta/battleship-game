package tiko.vc.battleship.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;



public class BoardPanel extends JPanel {
	
	public static final int BOARD_SIZE = GUI.FRAME_WIDTH / 2 - 30;
	
	private GameButton[][] boardButtons;
	
	/**
	 * 
	 */
	public BoardPanel(Color color) {
		super(new GridLayout(11, 11));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setOpaque(true);
		
		setBackground(color);
		setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
		
		boardButtons = new GameButton[11][11];
		
		for(int rows = 0; rows < boardButtons.length; rows++) {
			for(int cols = 0; cols < boardButtons[rows].length; cols++) {
				boardButtons[rows][cols] = new GameButton('X');
				add(boardButtons[rows][cols]);
			}
		}
	}
	
}
