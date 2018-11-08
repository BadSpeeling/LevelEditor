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
		
		//LevelEditorContainer game = new LevelEditorContainer (mainViewDim);
		GameContainer game = new GameContainer (mainViewDim);
	
		Actor player = game.getPlayer();
		
		game.drawActor(player);
		game.moveActorBy(player, 1, 1);
		
	}
	
}
