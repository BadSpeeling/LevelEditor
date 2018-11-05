import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LevelEditor extends JLabel implements MouseListener {
	
	private BufferedImage board; 
	
	//stores where a click began.  to be used to
	private Point clickStart;
	
	public LevelEditor (Dimension dim) {
		
		this.board = new BufferedImage (dim.width, dim.height, BufferedImage.TYPE_3BYTE_BGR);
		addMouseListener(this);
		this.setIcon(new ImageIcon(board));
		this.setSize(dim);
		this.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
				
		//drawWhiteBox(Helpers.round(arg0.getX()), Helpers.round(arg0.getY()), 10, 10);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.clickStart = e.getPoint();
	}
	
	/**
	 * Draws an image to board
	 * @param img the image that is to be drawn
	 * @param x Starting x pos
	 * @param y Starting y pos
	 */
	public void drawImg (BufferedImage img, int x, int y) {
		
		for (int i = 0; i < img.getWidth(); i++) {
			
			for (int j = 0; j < img.getHeight(); j++) {
				board.setRGB(i+x, j+y, img.getRGB(i, j));
			}
			
		}
		
		repaint();
		revalidate();
		
	}
	
	/**
	 * Draws a white box to board
	 * @param x Start x
	 * @param y Start y
	 * @param width width of box
	 * @param height height of box
	 */
	public void drawWhiteBox (int x, int y, int width, int height) {
		
		Graphics2D curImage = this.board.createGraphics();
		curImage.setColor(Color.WHITE);
		curImage.fillRect(x,y,width,height);
		curImage.dispose();
		
		repaint();
		revalidate();
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		File objectToDraw = new File ("D:\\Java_Projects\\LevelEditor\\src\\redX.png");
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(objectToDraw);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
	
		int imgWidth = img.getWidth();
		int imgHeight = img.getHeight();
		
		Point clickRelease = e.getPoint();
	
		int startX = Helpers.round((int)this.clickStart.getX());
		int startY = Helpers.round((int)this.clickStart.getY());
		int endX = Helpers.round((int)clickRelease.getX());
		int endY = Helpers.round((int)clickRelease.getY());
				
		int incXBy = 0;
		int incYBy = 0;
		
		if (startX != endX) {
			incXBy = endX > startX ? imgWidth : -1*imgWidth;
		}
		
		if (startY != endY) {
			incYBy = endY > startY ? imgHeight : -1*imgHeight;
		}
		
		int curX = startX;
		int curY = startY;
		
		boolean somethingDrawnThisFrame = true;
		
		//continue drawing while there is a new block to draw
		while (somethingDrawnThisFrame) {
		
			//draw image, and then reset the drawing flag
			drawImg(img, curX, curY);
			somethingDrawnThisFrame = false;
			
			//check if there is even anything to update for x
			if (incXBy != 0) {
				
				//moving to the left
				if (incXBy < 0 && curX > endX) {
					somethingDrawnThisFrame = true;
					curX += incXBy;
				}
				
				//moving to the right
				else if (incXBy > 0 && curX < endX) {
					somethingDrawnThisFrame = true;
					curX += incXBy;
				}
				
			}

			//check if there is even anything to update for y
			if (incYBy != 0) {
				
				//moving down
				if (incYBy < 0 && curY > endY) {
					somethingDrawnThisFrame = true;
					curY += incYBy;
				}
				
				//moving up
				else if (incYBy > 0 && curY < endY) {
					somethingDrawnThisFrame = true;
					curY += incYBy;
				}
				
			}
			
		} 
		
		repaint();
		revalidate();
		
	}
	
}
