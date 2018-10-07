package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame frame;
	JPanel panel;
	JButton addEntry;
	JButton searchByID;
	JButton viewList;
	JButton removeEntry;
	HashMap<Integer, String> studentRoster;
	public _02_LogSearch(){
		studentRoster = new HashMap<Integer, String>();
		frame = new JFrame();
		panel = new JPanel();
		addEntry = new JButton("Add Entry");
		searchByID = new JButton("Search By ID");
		viewList = new JButton("View List");
		removeEntry = new JButton("Remove Entry");
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		panel.add(addEntry);
		panel.add(searchByID);
		panel.add(viewList);
		panel.add(removeEntry);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addEntry) {
			String stringID = JOptionPane.showInputDialog(null, "Enter a new ID number");
			int ID = Integer.parseInt(stringID);
			String name = JOptionPane.showInputDialog(null, "Enter a name");
			studentRoster.put(ID, name);
		}
		if(e.getSource() == searchByID) {
			String stringID = JOptionPane.showInputDialog(null, "Enter an ID number");
			int ID = Integer.parseInt(stringID);
			if(studentRoster.containsKey(ID) == true) {
				JOptionPane.showMessageDialog(null,  "ID: " + ID+ "   Name: " + studentRoster.get(ID));
			}else {
				JOptionPane.showMessageDialog(null, "This ID does not exist");
			}
		}
		if(e.getSource() == viewList) {
			String s = "";
			for(Integer i : studentRoster.keySet()){
				s += "ID: " + i + "   Name: " + studentRoster.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if(e.getSource() == removeEntry) {
			String stringID = JOptionPane.showInputDialog(null, "Enter the ID number that you want to remove");
			int ID = Integer.parseInt(stringID);
			if(studentRoster.containsKey(ID) == true) {
				studentRoster.remove(ID);
			}else {
				JOptionPane.showMessageDialog(null, "This ID does not exist");
			}
		}
		
	}
	public static void main(String[] args) {
		new _02_LogSearch();
	}
}
