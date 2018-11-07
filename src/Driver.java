import java.awt.Dimension;

import javax.swing.JFrame;

public class Driver {
	
	public static void main (String [] args) {
		
		final int editorWidth = 900;
		final int editorHeight = 500;
		
		Dimension mainViewDim = new Dimension (editorWidth, editorHeight);
		
		LevelEditorContainer game = new LevelEditorContainer (new Dimension(editorWidth,editorHeight));
		//GameContainer game = new GameContainer (mainViewDim);
		//game.drawPlayer(0, 0);
		
	}
	
}
