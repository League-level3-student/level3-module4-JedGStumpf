package _00_IntroToStacks;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_TextUndoRedo implements KeyListener{
	
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	Stack<String> letters = new Stack<String>();
	Stack<String> deleted = new Stack<String>();
	
	String dispLetts = "";
	String delString = "";
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel deletedLabel;
	JTextField text;
	JLabel delText;
	public static void main(String[] args) {
		new _02_TextUndoRedo();


	}
	
	public _02_TextUndoRedo() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel("Press backSpace to delete your last letter \nPress Enter to show your deleted letters.");
		text = new JTextField();	
		delText = new JLabel("DELETED LETTERS: Press Enter to View");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		panel.setPreferredSize(new Dimension(500, 300));;
		frame.add(panel);
		panel.add(label,BorderLayout.CENTER);
		frame.setVisible(true);
		panel.addKeyListener(this);
		

		panel.add(text, BorderLayout.NORTH);
		text.setPreferredSize(new Dimension(300, 25));
		text.addKeyListener(this);
		

		panel.add(delText, BorderLayout.SOUTH);
		delText.setPreferredSize(new Dimension(300, 25));
		delText.addKeyListener(this);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 8 && !letters.isEmpty()) {
			deleted.push(letters.pop());
			for (int i = 0; i < letters.size(); i++) {
				dispLetts += letters.get(i);
			}
			
		} else if (e.getKeyCode() == 10 && !deleted.isEmpty()) {
			for (int i = 0; i < deleted.size(); i++) {
				delString += deleted.get(i) + " ";
			}
			delText.setText(delString);
			
		} else {
			char let = e.getKeyChar();
			
			letters.push(Character.toString(let));
			label.setText("");
			for (int i = 0; i < letters.size(); i++) {
				dispLetts += letters.get(i) + " ";
			}
			label.setText(dispLetts);
		}

		
		
		dispLetts = "";
		delString = "";
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("C");
	}



	
	


}
