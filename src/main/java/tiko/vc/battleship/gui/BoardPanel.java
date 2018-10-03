package tiko.vc.battleship.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	public static final int BOARD_WIDTH = GUI.WIDTH / 2 - 50;
	
	/**
	 * 
	 */
	public BoardPanel() {
		super(new GridLayout());
		
		setSize(5,5);
	}
	
}
