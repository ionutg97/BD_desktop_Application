package ApplicationWindow;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Usefull {

	/**
	 * Create my useful method
	 */
	 public void swichPanels(JPanel panel, JLayeredPane layeredPane_1) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.validate();
	}
}
