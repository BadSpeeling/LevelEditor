package Entities;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import General.Position;
import General.Vector;

public class Actor {

	private BufferedImage sprite;
	private Position coor;
	private Vector velo;
	
	public Actor (String spritePath, int x, int y) {
		
		try {
			this.sprite = ImageIO.read(new File (spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.coor = new Position (x, y);
		this.velo = new Vector (0, 0);
		
	}
	
	/**
	 * Update the Actor's position
	 * @param dx The amount to move in the x direction
	 * @param dy The amount to move in the y direction
	 */
	public void move (double dx, double dy) {
		coor.translate(dx, dy);
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public Position getCoor() {
		return coor;
	}
	
	public void setDX (double by) {
		this.velo.setX(by);
	}
	
	public void setDY (double by) {
		this.velo.setY(by);
	}
	
	public double getDX () {
		return velo.getX();
	}
	
	public double getDY () {
		return velo.getY();
	}
	
}
