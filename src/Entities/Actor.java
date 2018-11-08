package Entities;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import General.Coordinate;

public class Actor {

	private BufferedImage sprite;
	private Coordinate coor;
	
	public Actor (String spritePath, int x, int y) {
		
		try {
			this.sprite = ImageIO.read(new File (spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.coor = new Coordinate (x, y);
		
	}
	
	/**
	 * Update the Actor's position
	 * @param dx The amount to move in the x direction
	 * @param dy The amount to move in the y direction
	 */
	public void move (int dx, int dy) {
		coor.translate(dx, dy);
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public Coordinate getCoor() {
		return coor;
	}
	
}
