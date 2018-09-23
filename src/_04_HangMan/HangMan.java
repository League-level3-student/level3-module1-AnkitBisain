package _04_HangMan;

import java.util.Stack;

import javax.swing.JOptionPane;

import _04_HangMan.Utilities;

public class HangMan{
	
	public HangMan() {
		int numbOfWords = Integer.parseInt(JOptionPane.showInputDialog("Welcome. How many rounds would you like to play (must be an integer between 1 and 256)?"));
		Stack<String> words = new Stack<String>();
		for(int i = 0; i < numbOfWords; i ++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			words.push(s);
		}
	
	}
	
	public static void main(String[] args) {
		
	}
	
}
