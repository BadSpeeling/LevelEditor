import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

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
				
		Graphics2D curImage = this.board.createGraphics();
		curImage.setColor(Color.WHITE);
		curImage.fillRect(arg0.getX(), arg0.getY(), 10, 10);
		curImage.dispose();
		
		repaint();
		revalidate();
		
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

	@Override
	public void mouseReleased(MouseEvent e) {
		
		int imgWidth = 10;
		int imgHeight = 10;
		
		Point clickRelease = e.getPoint();
		
		int startX = (int)this.clickStart.getX();
		int startY = (int)this.clickStart.getY();
		int endX = (int)clickRelease.getX();
		int endY = (int)clickRelease.getY();
		
		int diffX = (int)(clickRelease.getX() - this.clickStart.getX());
		int diffY = (int)(clickRelease.getY() - this.clickStart.getY());
		
		boolean isXLocked = diffX < diffY;
		boolean isYLocked = !isXLocked;
		
		boolean stillDrawing = true;
		
		int curX = startX;
		int curY = startY;
		
		while (stillDrawing) {
			
			Graphics2D curImage = this.board.createGraphics();
			curImage.setColor(Color.WHITE);
			curImage.fillRect(curX, curY, imgWidth, imgHeight);
			curImage.dispose();
			
			stillDrawing = false;
			
			if (!isXLocked && curX + imgWidth > endX) {
				curX += imgWidth;
				stillDrawing = true;
			}
			
			if (!isYLocked && curY + imgHeight > endY) {
				curY += imgHeight;
				stillDrawing = true;
			}
				
		}
		
		repaint();
		revalidate();
		
	}
	
}
