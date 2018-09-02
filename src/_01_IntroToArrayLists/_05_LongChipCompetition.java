package _01_IntroToArrayLists;

import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	
	
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();
		lcc.initializeBeatles();
		ArrayList<Integer> winners = new ArrayList<Integer>();
		double largest = 0;
		for(int i=0; i < lcc.theBeatles.size(); i++) {
			for(int j = 0; j < lcc.theBeatles.get(i).getChips().size(); j++) {
				if( lcc.theBeatles.get(i).getChips().get(j).getLength() > largest) {
					largest = lcc.theBeatles.get(i).getChips().get(j).getLength();
					winners.clear();
					winners.add(i);
				}else {
					if( lcc.theBeatles.get(i).getChips().get(j).getLength() == largest) {
						boolean isIn = false;
						for(int k = 0; k < winners.size(); k++) {
							if(winners.get(k) == i) {
								isIn = true;
							}
						}
						if(isIn == false) {
							winners.add(i);
						}
					}
				}
			}
		}
		for(int i = 0; i < winners.size(); i++) {
			if( i == winners.size() - 1) {
				if(winners.size() == 1) {
					System.out.print(lcc.theBeatles.get(winners.get(i)).getName() + " had the longest chip.");
				}else {
					System.out.print("and " + lcc.theBeatles.get(winners.get(i)).getName() + " had the longest chips.");
				}
			}else {
			System.out.print(lcc.theBeatles.get(winners.get(i)).getName() + ", ");
			}
		}
	}
	
	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}
	
	public ArrayList<Beatle> getTheBand(){
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
