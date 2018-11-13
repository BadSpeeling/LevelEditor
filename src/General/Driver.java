package General;
import java.awt.Dimension;

import javax.swing.JFrame;

import Editor.LevelEditorContainer;
import Entities.Actor;
import Game.GameContainer;

public class Driver {
	
	public static void main (String [] args) {
		
		final int editorWidth = 900;
		final int editorHeight = 500;
		
		Dimension mainViewDim = new Dimension (editorWidth, editorHeight);
		
		game(mainViewDim);
		
		
	}
	
	public static void editor (Dimension dim) {
		LevelEditorContainer game = new LevelEditorContainer (dim);
	}
	
	public static void game (Dimension dim) {
		
		GameContainer game = new GameContainer (dim);
		Actor player = game.getPlayer();
		
		game.run();
	}
	
}
