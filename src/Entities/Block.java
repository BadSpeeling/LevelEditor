package Entities;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import General.Helpers;

public class Block implements Comparable <Block>  {
	
	private Point startPos;
	private Dimension entitySize;
	private Orientation dir;
	private int timesRepeat;
	private int entityID;
	
	public Block (Point start, Point end, Dimension entitySize, Orientation dir, int entityID) {
		
		Point tempEnd = null;
		
		if ((dir.equals(Orientation.HORI) && end.x > start.x) || (dir.equals(Orientation.VERT) && end.y > start.y)) {
			this.startPos = start;
			tempEnd = end;
		}
		
		else {
			this.startPos = end;
			tempEnd = start;
		}
		
		this.entitySize = entitySize;
		this.dir = dir;
		this.entityID = entityID;
		this.timesRepeat = 0;
		
		int incXBy = dir.equals(Orientation.HORI) ? entitySize.width : 0;
		int incYBy = incXBy == 0 ? entitySize.height : 0;
		int curX = this.startPos.x;
		int curY = this.startPos.y;
		
		while ((dir.equals(Orientation.HORI) && tempEnd.x > curX) || (dir.equals(Orientation.VERT) && tempEnd.y > curY)) {
			
			curX += incXBy;
			curY += incYBy;
			this.timesRepeat++;
			
		}
		
		
	}
	
	public Block (String input) {
		
		final int expectedInputSize = 7;
		String [] spl = input.split(",");
		
		if (spl.length != expectedInputSize) {
			throw new IllegalArgumentException("input should have " + expectedInputSize + "comma seperated values, but it instead has " + spl.length);
		}
		
		this.startPos = new Point (Integer.parseInt(spl[1]), Integer.parseInt(spl[2]));
		this.entitySize = new Dimension (Integer.parseInt(spl[3]), Integer.parseInt(spl[4]));
		this.dir = Orientation.convert(Integer.parseInt(spl[6]));
		this.timesRepeat = Integer.parseInt(spl[5]);
		this.entityID = Integer.parseInt(spl[0]);
		
	}
	
	public Orientation getOrientation () {
		return dir;
	}
	
	public int getTimesRepeat () {
		return timesRepeat;
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
	public int compareTo(Block arg0) {
		
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
			
			if (dir.equals(Orientation.HORI)) {
				x += entitySize.width;
			}
			
			else if (dir.equals(Orientation.VERT)) {
				y += entitySize.height;
			}
			
		}
		
		return new Point (x,y);
		
	}
	
	public Dimension getEntitySize ( ) {
		return entitySize;
	}
	
	public int getEntityID () {
		return entityID;
	}
	
	public Point getBlockPosition (int numInOrder) {
		
		Vector <Integer> valModifiers = new Vector <Integer> (2);
		int xMod = 0;
		int yMod = 0;
		
		return null;
		
	}
	
	/**
	 * 
	 * @return A string that is ready to be saved to a text file
	 */
	public String saveInfo () {
		return entityID + "," + startPos.x + "," + startPos.y + "," + (int)entitySize.getWidth() + "," + (int)entitySize.getHeight() + "," + timesRepeat + "," + dir.ordinal();
	}

}
