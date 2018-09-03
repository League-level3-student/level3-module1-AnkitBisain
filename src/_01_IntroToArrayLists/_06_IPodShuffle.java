package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JButton button;
	ArrayList<Song> songs;
	Random random = new Random();
	int size;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		size = 3;
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		button = new JButton("Surprise Me");
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		songs = new ArrayList<Song>();
		for(int i = 0; i < size; i++) {
			songs.add(new Song(Integer.toString(i) + ".mp3"));
		}
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			int r = random.nextInt(size);
			for(int i = 0; i < size; i++) {
				songs.get(i).stop();
			}
			songs.get(r).play();
		}
	}
}