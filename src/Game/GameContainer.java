package Game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import Entities.Actor;
import Entities.Block;
import Entities.Orientation;
import Entities.Player;

public class GameContainer extends JFrame implements KeyListener{

	private LevelDisplay level;
	private Player player;
	
	private List <Block> blocks;
	
	private double movementMod = .1;
	
	public GameContainer (Dimension viewSize) {		
		
		//init player
		this.player = new Player ("src\\assets\\char1.png", 0, 0);
		//init blocks
		this.blocks = new ArrayList <Block> ();
		
		//instantiat the level ui
		this.level = new LevelDisplay (viewSize);
		getContentPane().add(this.level);
		getContentPane().setLayout(new FlowLayout());

		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width-50,size.height-50);
		setVisible(true);

		addKeyListener(this);

	}
	
	public void loadBlockAssets (String file) {
		
		Scanner input = null;
		
		try {
			input = new Scanner (new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (input.hasNextLine()) {
			
			Block curBlock = new Block (input.nextLine());
			blocks.add(curBlock);
			
		}
		
	}
	
	public void drawBlocks () {
		
		for (Block curBlock: blocks) {
			
			Point start = curBlock.getStartPos();
			Dimension size = curBlock.getEntitySize();
			int timesRepeat = curBlock.getTimesRepeat(); 
			
			int dx = curBlock.getOrientation().equals(Orientation.HORI) ? size.width : 0;
			int dy = curBlock.getOrientation().equals(Orientation.VERT) ? size.height : 0;
			int curX = start.x;
			int curY = start.y;
			
			for (int i = 0; i <= timesRepeat; i++) {
				
				level.drawBlock(curBlock, curX, curY);
				curX += dx;
				curY += dy;
				
			}
			
		}
		
		repaint();
		revalidate();
		
	}

	public void run () {
		
		player.move(50, 0);
		drawActor(player);
		loadBlockAssets("src\\savedData\\boxLevel.txt");
		drawBlocks();
		
		while (true) {

			moveActorBy(player);

			try {
				Thread.sleep(20/1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void drawActor (Actor toDraw) {
		level.drawActor(toDraw);
	}

	public void moveActorBy (Actor toMove) {

		double dx = toMove.getDX();
		double dy = toMove.getDY();

		level.clearActor(toMove);
		player.move(dx, dy);
		level.drawActor(toMove);

		repaint();
		revalidate();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_D) {
			player.setDX(movementMod);
		}

		else if (arg0.getKeyCode() == KeyEvent.VK_A) {
			player.setDX(movementMod * -1);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.setDX(0);
		}

		else if (e.getKeyCode() == KeyEvent.VK_A) {
			player.setDX(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public Actor getPlayer () {
		return this.player;
	}
	

}
