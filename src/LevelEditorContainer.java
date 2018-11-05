import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelEditorContainer extends JFrame {
	
	private LevelEditor editor;
	
	public LevelEditorContainer (Dimension editorDim) {
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.getContentPane().setLayout(new FlowLayout());
		
		this.setSize(size.width-50,size.height-50);		
		this.editor = new LevelEditor (editorDim);
		
		this.getContentPane().add(editor);
		
		this.setVisible(true);
		
	}
	
}
