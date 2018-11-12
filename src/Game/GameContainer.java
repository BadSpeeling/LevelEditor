package Game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;

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

		addKeyListener(this);

	}

	public void run () {

		while (true) {

			moveActorBy(player);

			try {
				Thread.sleep(20/100);
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
			
		}

		else if (arg0.getKeyCode() == KeyEvent.VK_A) {

		}

		else if (arg0.getKeyCode() == KeyEvent.VK_S) {

		}

		else if (arg0.getKeyCode() == KeyEvent.VK_W) {

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {



	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public Actor getPlayer () {
		return this.player;
	}

}
