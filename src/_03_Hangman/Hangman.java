package _03_Hangman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener{
	String dict = "dictionary.txt";
	String lines;
//	String word;
	StringBuilder newDisplay = new StringBuilder("");
	
	Stack<String> words = new Stack<String>();
	ArrayList<String> guessedLetters;
	ArrayList<String> wordLetters = new ArrayList<String>();
	StringBuilder word; 
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel usedLetters;
	JTextField text;
	Font font;
	
	String guess = "";
	
	public static void main(String[] args) {
		new Hangman().setUp();
		
	}
	
	public void setUp() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hang Man");
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(800, 800));
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(800, 800));
		frame.add(panel);
		
		font = new Font("Courier", Font.BOLD,24);
		
		label = new JLabel();
		label.setSize(600, 300);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setText("Type a Letter in the textfield to guess");
		panel.add(label, BorderLayout.NORTH);
		
		usedLetters = new JLabel();
		usedLetters.setSize(600, 300);
		usedLetters.setFont(font);
		usedLetters.setHorizontalAlignment(JLabel.CENTER);
		usedLetters.setVerticalAlignment(JLabel.CENTER);
		usedLetters.setText("All of your guessed letters will go here");
		panel.add(usedLetters, BorderLayout.CENTER);
		
		text = new JTextField();
		text.setSize(25, 25);
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setFont(font);
		text.addKeyListener(this);		
		panel.add(text, BorderLayout.SOUTH);
		
		frame.pack();
		
		displayLines();
	}
	
	public String getWord() {
		if (words.isEmpty()) {
			for (int i = 0; i < 5; i++) {
				String wrd = Utilities.readRandomLineFromFile(dict);
				if (!words.contains(wrd)) {
					words.push(wrd);
				}
				System.out.println(wrd);
			}
		}
		return words.pop();

	}
	
	public String displayLines() {
		lines = "";
		word = new StringBuilder(getWord().toString());
		for (int i = 0; i < word.length(); i++) {
			
			if (i < word.length()) {
				lines += "_";
				newDisplay.append("_");

			}
		}
		label.setText(lines);
		return lines;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		String letter = String.valueOf(e.getKeyChar());
		
		for (int i = 0; i < word.length(); i++) {
			if (String.valueOf(word.charAt(i)).equals(letter)) {
				newDisplay.deleteCharAt(i);
				newDisplay.insert(i, letter);
			}
		}
		guess += letter + " ";
		usedLetters.setText(guess);
		label.setText(newDisplay.toString());
		String check = newDisplay.toString();
		String original = word.toString();
		
		if (check.equals(original)) {
			label.setText("Press ENTER to play again");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == 10) {
			new Hangman().setUp();
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
