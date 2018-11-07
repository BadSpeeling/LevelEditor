import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.EventListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class LevelEditorContainer extends JFrame implements ActionListener, EventListener {
	
	private LevelEditor editor;
	
	public LevelEditorContainer (Dimension editorDim) {
		
		this.editor = new LevelEditor (editorDim);
		
		getContentPane().add(editor);
		getContentPane().setLayout(new FlowLayout());
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width-50,size.height-50);		
				
		//creating the menu bar
		JMenuBar menuBar = new JMenuBar ();
		
		JMenu fileSection = new JMenu ("File");
		
		JMenuItem save = new JMenuItem ("Save", KeyEvent.VK_TAB);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		
		fileSection.add(save);
		
		menuBar.add(fileSection);
		
		setJMenuBar(menuBar);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("Save")) {
			
			String fileName = JOptionPane.showInputDialog(this,"Enter file name...");
			
			editor.saveEntities(new File("src\\savedData\\" + fileName + ".txt"));
			
		}
		
	}
	
}
