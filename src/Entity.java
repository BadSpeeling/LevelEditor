import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity implements Comparable <Entity>  {
	
	private Point startPos;
	private Dimension entitySize;
	private Orientation dir;
	private int timesRepeat;
	private int entityID;
	
	public Entity (int startX, int startY, int endX, int endY, int imgWidth, int imgHeight, int entityID) {
		
		this.startPos = new Point (startX, startY);
		this.entitySize = new Dimension (imgWidth, imgHeight);
		
		int incXBy = 0;
		int incYBy = 0;
		
		if (Math.abs(endX-startX) > Math.abs(endY-startY)) {
			incXBy = endX > startX ? imgWidth : -1*imgWidth;
			this.dir = endX > startX ? Orientation.LR : Orientation.RL;
		}
		
		//only allow changes in one dimension
		else if (Math.abs(endX-startX) < Math.abs(endY-startY)) {
			incYBy = endY > startY ? imgHeight : -1*imgHeight;
			this.dir = endY > startY ? Orientation.DU : Orientation.UD;
		}
		
		else {
			this.dir = Orientation.NONE;
		}
		
		this.entityID = entityID;
		this.timesRepeat = 0;
		
		int curX = startX;
		int curY = startY;
		
		//increment the number of times to draw this object while within it's bounds
		while (!this.dir.equals(Orientation.NONE) && (this.dir.equals(Orientation.LR) && curX < endX) || 
				(this.dir.equals(Orientation.RL) && curX > endX) || 
				(this.dir.equals(Orientation.DU) && curY < endY) ||
				((this.dir.equals(Orientation.UD) && curY > endY))) {
			
			curX += incXBy;
			curY += incYBy;
			this.timesRepeat++;
			
		}
		
	}
	
	public static BufferedImage getImageData (int assetID) {

		String fileName = Helpers.getLevelEditorObject(assetID);

		//check if assetID is a valid entity
		if (fileName == "") {
			throw new IllegalStateException();
		}
		
		String path = "src\\assets\\";
		
		try {
			return ImageIO.read(new File(path + fileName));
		} catch (IOException e) {
			return null;
		}
		
	}

	/**
	 * Standard compare to method.  Compares by x coordinate and then y coordinate in case of tie
	 */
	public int compareTo(Entity arg0) {
		
		int xDif = startPos.x - arg0.startPos.x;
		
		if (xDif != 0) {
			return xDif;
		}
		
		else {
			return startPos.y - arg0.startPos.y;
		}
		
	}

	public Point getStartPos() {
		return startPos;
	}

	public Point getEndPos() {
		
		int x = startPos.x;
		int y = startPos.y;
		
		//update the appropriate coordinate based in orientation and repeats
		for (int i = 0; i < timesRepeat; i++) {
			
			if (dir.equals(Orientation.LR)) {
				x += entitySize.width;
			}
			
			else if (dir.equals(Orientation.RL)) {
				x -= entitySize.width;
			}
			
			else if (dir.equals(Orientation.DU)) {
				y += entitySize.height;
			}
			
			else {
				y -= entitySize.height;
			}
			
		}
		
		return new Point (x,y);
		
	}
	
	public int getEntityID () {
		return entityID;
	}
	
	/**
	 * 
	 * @return A string that is ready to be saved to a text file
	 */
	public String saveInfo () {
		return entityID + "," + startPos.x + "," + startPos.y + "," + (int)entitySize.getWidth() + "," + (int)entitySize.getHeight() + "," + timesRepeat + "," + dir.ordinal();
	}

}
