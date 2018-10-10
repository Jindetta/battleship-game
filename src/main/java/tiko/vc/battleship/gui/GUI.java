package tiko.vc.battleship.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Class that constructs the graphical user interface
 * for the battleship game.
 */
public class GUI extends JFrame {
	
	private final static String WINDOW_TITLE = "Battleship";
	
	public final static int FRAME_WIDTH = 1000;
	public final static int FRAME_HEIGHT = 600;
	
	private BoardPanel playerBoard;
	private BoardPanel botBoard;
	
	private JButton startGame;
	private JButton generateShips;
	
	/**
	 * TODO
	 */
	public GUI() {
		super(WINDOW_TITLE);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		playerBoard = new BoardPanel(Color.BLACK);
		botBoard = new BoardPanel(Color.cyan);	

		c.gridx = 0;
		c.gridy = 0;
		add(playerBoard, c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(botBoard);
		
		setVisible(true);
	}

}
