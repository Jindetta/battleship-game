package tiko.vc.battleship.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;



public class BoardPanel extends JPanel {
	
	public static final int BOARD_SIZE = GUI.FRAME_WIDTH / 2 - 60;
	
	/**
	 * 
	 */
	public BoardPanel(Color color) {
		super(new GridLayout(10, 10));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setOpaque(true);
		
		setBackground(color);
		setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
	}
	
}
