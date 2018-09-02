package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> strings = new ArrayList<String>();
		//   Don't forget to import the ArrayList class

		//2. Add five Strings to your list
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("e");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		System.out.println();
		
		//4. Print all the Strings using a for-each loop
		for(String s : strings) {
			System.out.println(s);
		}
		System.out.println();
		//5. Print only the even numbered elements in the list.
		for(int i = 0; 2*i < strings.size(); i++) {
			System.out.println(strings.get(2*i));
		}
		System.out.println();
		//6. Print all the Strings in reverse order.
		for(int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(strings.size()-1-i));
		}
		System.out.println();
		//7. Print only the Strings that have the letter 'e' in them.
		for(String s : strings) {
			if(s.contains("e")) {
				System.out.println(s);
			}
		}
	}
}
