package tiko.vc.battleship.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Class that constructs the graphical user interface
 * for the battleship game.
 */
public class GUI extends JFrame {
	
	/**
	 * Sets the title of the window.
	 */
	private final static String WINDOW_TITLE = "Battleship";
	
	/**
	 * Width of the window.
	 */
	public final static int FRAME_WIDTH = 1100;
	
	/**
	 * Height of the window.
	 */
	public final static int FRAME_HEIGHT = 600;
	
	/**
	 * Players board that is made from JPanel.
	 */
	private BoardPanel playerBoard;
	
	/**
	 * Bots board that is made from JPanel.
	 */
	private BoardPanel botBoard;
	
	/**
	 * JButton that starts the game.
	 */
	private JButton startGame;
	
	/**
	 * JButton that generates ships randomly for the player.
	 */
	private JButton generateShips;
	
	/**
	 * JButton that allows the player to manually place the ships.
	 */
	private JButton placeShips;
	
	/**
	 * Jbutton that exits the game.
	 */
	private JButton exitGame;
	
	/**
	 *
	 */
	public GUI() {
		super(WINDOW_TITLE);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		playerBoard = new BoardPanel(Color.BLACK, BoardPanel.BoardType.PLAYER);
		botBoard = new BoardPanel(Color.cyan, BoardPanel.BoardType.BOT);
		
		startGame = new JButton("Start game");
		startGame.addActionListener(this::startGamePressed);
		
		generateShips = new JButton("Generate ships");
		generateShips.addActionListener(this::generateShipsPressed);
		
		placeShips = new JButton("Place ships");
		placeShips.addActionListener(this::placeShipsPressed);
		
		exitGame = new JButton("Exit game");
		exitGame.addActionListener(this::exitGamePressed);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = 1;
		add(playerBoard, c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 2;
		add(botBoard, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		add(startGame, c);
		
		c.gridx = 1;
		add(generateShips, c);
		
		c.gridx = 2;
		add(placeShips, c);	
		
		c.gridx = 3;
		add(exitGame, c);	
		
		setVisible(true);
	}
	
	/**
	 * Called when start game button is pressed.
	 * @param e
	 */
	private void startGamePressed(ActionEvent e) {
		//TODO
	}
	
	/**
	 * Called when generate ships button is pressed.
	 * 
	 * @param e
	 */
	private void generateShipsPressed(ActionEvent e) {
		//TODO
	}
	
	/**
	 * Called when place ships button is pressed.
	 * 
	 * @param e
	 */
	private void placeShipsPressed(ActionEvent e) {
		//TODO
	}
	
	/**
	 * Called when exit button is pressed.
	 * Exits the program.
	 * 
	 * @param e
	 */
	private void exitGamePressed(ActionEvent e) {
		System.exit(0);	
	}

}
