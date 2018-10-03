package tiko.vc.battleship.gui;

import java.awt.BorderLayout;

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
		setLayout(new BorderLayout());
		
		playerBoard = new BoardPanel();
		botBoard = new BoardPanel();
		
		setVisible(true);
	}

}
