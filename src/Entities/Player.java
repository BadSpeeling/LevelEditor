package Entities;

import java.awt.Point;

public class Player extends Actor {
	
	private boolean onGround = false;
	
	public Player (String spritePath, int x, int y) {
		super(spritePath, x, y);
	}
	
	public void setOnGround (boolean onGround) {
		this.onGround = onGround;
	}
	
	public boolean isOnGround () {
		return this.onGround;
	}
	
}
