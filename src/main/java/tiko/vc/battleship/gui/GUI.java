package tiko.vc.battleship.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Class that constructs the graphical user interface
 * for the battleship game.
 */
public class GUI extends JFrame {
	
	private final static String WINDOW_TITLE = "Battleship";
	
	private final static int WINDOW_WIDTH = 800;
	private final static int WINDOW_HEIGHT = 600;
	
	private BoardPanel playerBoard;
	private BoardPanel botBoard;
	
	/**
	 * TODO
	 */
	public GUI() {
		super(WINDOW_TITLE);
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		
		playerBoard = new BoardPanel();
		botBoard = new BoardPanel();
		
		add(playerBoard, BorderLayout.LINE_START);
		add(botBoard, BorderLayout.LINE_END);
		
		setVisible(true);
	}

}
