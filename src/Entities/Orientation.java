package Entities;

import java.util.Vector;

/**
 * Represents the 4 ways that a block can be oriented.
 * LR - left to right i.e. the ending is to the right of the start
 * RL - right to left i.e. the ending is to the left of the start
 * UD - up down i.e. the ending is under the start
 * DU - down up i.e. the ending is above the start
 * @author Eric
 *
 */
public enum Orientation {
	HORI,VERT,NONE;
	
	public static Orientation convert (int num) {
		
		switch(num) {
		
			case 0: return HORI;
			case 1: return VERT;
			case 2: return NONE;
			default: return null;
			
		}
		
	}
	
}
