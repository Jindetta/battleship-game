package tiko.vc.battleship.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	public static final int BOARD_WIDTH = GUI.WIDTH / 2 - 60;
	public static final int BOARD_HEIGHT = GUI.HEIGHT / 2 - 40;
	
	/**
	 * 
	 */
	public BoardPanel() {
		super(new GridLayout());
		
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
	}
	
}
