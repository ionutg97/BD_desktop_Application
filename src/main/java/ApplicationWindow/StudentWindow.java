package ApplicationWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class StudentWindow {

	JMenuItem mntmAdd;
	
	public StudentWindow() {
		 mntmAdd = new JMenuItem("Add");
		
	}

	public void addActionListener() {
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
	}
	

}
