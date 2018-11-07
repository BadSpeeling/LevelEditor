import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LevelDisplay extends JLabel {
	
	private BufferedImage board;
	private BufferedImage player;
	
	public LevelDisplay (Dimension levelView) {
		
		this.board = new BufferedImage (levelView.width, levelView.height, BufferedImage.TYPE_3BYTE_BGR);
		this.setIcon(new ImageIcon (board));
		this.setSize(levelView);
		this.setVisible(true);
		
		try {
			this.player = ImageIO.read(new File("src\\assets\\char1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Draws the player character at the rounded down x y coordinate on board.  player is defined in constructor
	 * @param x
	 * @param y
	 */
	public void drawPlayerCharacter (int x, int y) {
		
		int rX = Helpers.round(x);
		int rY = Helpers.round(y);
		
		for (int i = 0; i < player.getWidth(); i++) {
			
			for (int j = 0; j < player.getHeight(); j++) {
				this.board.setRGB(i+rX, j+rY, this.player.getRGB(i, j));
			}
			
		}
		
	}
	
}
