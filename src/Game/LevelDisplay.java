package Game;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entities.Actor;
import Entities.Block;
import General.Position;
import General.Helpers;

/**
 * Contains a BufferedImage to be displayed to the user
 * @author Eric
 *
 */
public class LevelDisplay extends JLabel {

	private BufferedImage board;

	public LevelDisplay (Dimension levelView) {

		this.board = new BufferedImage (levelView.width, levelView.height, BufferedImage.TYPE_3BYTE_BGR);
		this.setIcon(new ImageIcon (board));
		this.setSize(levelView);
		this.setVisible(true);

	}

	public void clearActor (Actor toClear) {

		Position loc = toClear.getCoor();
		BufferedImage sprite = toClear.getSprite();
		int x = loc.getX();
		int y = loc.getY();

		for (int i = 0; i < sprite.getWidth(); i++) {
			
			for (int j = 0; j < sprite.getHeight(); j++) {
				board.setRGB(x+i, y+j, 0);
			}
	
		}

	}

	/**
	 * Draw an actor to the display
	 * @param toDraw The actor to be drawn
	 */
	public void drawActor (Actor toDraw) {

		Position loc = toDraw.getCoor();
		BufferedImage img = toDraw.getSprite();

		int X = loc.getX();
		int Y = loc.getY();

		for (int i = 0; i < img.getWidth(); i++) {

			for (int j = 0; j < img.getHeight(); j++) {
				this.board.setRGB(i+X, j+Y, img.getRGB(i, j));
			}

		}

	}
	
	public void drawImg (BufferedImage img, int X, int Y) {

		for (int i = 0; i < img.getWidth(); i++) {

			for (int j = 0; j < img.getHeight(); j++) {
				this.board.setRGB(i+X, j+Y, img.getRGB(i, j));
			}

		}
		
	}
	
	public void drawBlock (Block toDraw, int x, int y) {
		
		BufferedImage img = Block.getImageData(toDraw.getEntityID());
		drawImg(img, x, y);
		
	}

}
