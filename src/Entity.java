import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity implements Comparable <Entity>  {
	
	private Point startPos;
	private Point endPos;
	private int entityID;
	
	public Entity (Point startPos, Point endPos, int entityID) {
		this.startPos = startPos;
		this.endPos = endPos;
		this.entityID = entityID;
	}
	
	public static BufferedImage getImageData (int assetID) {

		String fileName = Helpers.getLevelEditorObject(assetID);

		//check if assetID is a valid entity
		if (fileName == "") {
			throw new IllegalStateException();
		}
		
		String path = "src\\";
		
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
		return endPos;
	}
	
	public int getEntityID () {
		return entityID;
	}
	
	/**
	 * 
	 * @return A string that is ready to be saved to a text file
	 */
	public String saveInfo () {
		return entityID + "," + startPos.toString() + "," + endPos.toString();
	}

}
