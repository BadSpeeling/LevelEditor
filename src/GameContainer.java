import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JFrame;

public class GameContainer extends JFrame implements ActionListener, EventListener{

	private LevelDisplay level;
	
	public GameContainer (Dimension viewSize) {
		
		this.level = new LevelDisplay (viewSize);
		getContentPane().add(this.level);
		getContentPane().setLayout(new FlowLayout());
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width-50,size.height-50);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void drawPlayer (int x, int y) {
		this.level.drawPlayerCharacter(x, y);
	}

}
