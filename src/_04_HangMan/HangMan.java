package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _04_HangMan.Utilities;

public class HangMan implements KeyListener{
	
	JLabel label;
	JPanel panel;
	JFrame frame;
	int lives;
	String word;
	String s;
	Stack<String> words;
	
	public HangMan() {
		int numbOfWords = Integer.parseInt(JOptionPane.showInputDialog("Welcome. How many rounds would you like to play (must be an integer between 1 and 256)?"));
		words = new Stack<String>();
		for(int i = 0; i < numbOfWords; i ++) {
			String q = "yeet";
			words.push(q);
		}
		lives = 10;
		word = words.pop();
		label = new JLabel();
		panel = new JPanel();
		frame = new JFrame();
		s = "";
		for(int i = 0; i < word.length(); i++) {
			s = s + "_";
		}
		label.setText(s + "    Lives Remaining: " + lives);
		panel.add(label);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
	
	}
	
	public static void main(String[] args) {
		new HangMan();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		String t = s;
		Character c = e.getKeyChar();
		for(int i = 0; i < word.length(); i++){
				if(word.charAt(i) == c) {
					s = s.substring(0, i) + c + s.substring(i+1,s.length());
				}
			}
		if(s == t) {
			lives --;
		}
		label.setText(s + "    Lives Remaining: " + lives);
		if(lives == 0) {
			JOptionPane.showMessageDialog(null, "how are you so bad");
		}
		System.out.println(word + "----" + s );
		if(word.equals(s)) {
			JOptionPane.showMessageDialog(null, "how are you so good");
		}	
		if(lives == 0 || word.equals(s)) {
			lives = 10;
			word = words.pop();
			s = "";
			for(int i = 0; i < word.length(); i++) {
				s = s + "_";
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
