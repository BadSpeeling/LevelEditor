import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class LevelEditorContainer extends JFrame {
	
	private LevelEditor editor;
	
	public LevelEditorContainer (Dimension editorDim) {
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().setLayout(new FlowLayout());
		
		setSize(size.width-50,size.height-50);		
		
		this.editor = new LevelEditor (editorDim);
		
		//creating the menu bar
		JMenuBar menuBar = new JMenuBar ();
		
		JMenu fileSection = new JMenu ("File");
		
		JMenuItem save = new JMenuItem ("Save", KeyEvent.VK_TAB);
		fileSection.add(save);
		
		menuBar.add(fileSection);

		
		//JMenuItem save = new JMenuItem ("Save");
		
		
		setJMenuBar(menuBar);
		getContentPane().add(editor);
		
		this.setVisible(true);
		
	}
	
}
