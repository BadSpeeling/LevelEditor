package Game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

import javax.swing.JFrame;

import Entities.Actor;
import Entities.Player;

public class GameContainer extends JFrame implements KeyListener{

	private LevelDisplay level;
	private Player player;
	
	public GameContainer (Dimension viewSize) {
		
		//init player
		this.player = new Player ("src\\assets\\char1.png", 0, 0);
		
		//instantiat the level ui
		this.level = new LevelDisplay (viewSize);
		getContentPane().add(this.level);
		getContentPane().setLayout(new FlowLayout());
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width-50,size.height-50);
		setVisible(true);
		
	}
	
	public void drawActor (Actor toDraw) {
		level.drawActor(toDraw);
	}
	
	public void moveActorBy (Actor toMove, int dx, int dy) {
		
		level.clearActor(toMove);
		player.move(dx, dy);
		level.drawActor(toMove);
		
		repaint();
		revalidate();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Actor getPlayer () {
		return this.player;
	}

}
