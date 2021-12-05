import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class viewMenuBar {

	private View view;
	
	public viewMenuBar(View view) {
		this.view = view;
	}
	
	public JMenuBar initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		
		JMenuItem menuItem1 = new JMenuItem("New");
		JMenuItem menuItem2 = new JMenuItem("Open");
		JMenuItem menuItem3 = new JMenuItem("Save");
		JMenuItem menuItem4 = new JMenuItem("Save as");
		JMenuItem menuItem9 = new JMenuItem("Quit");
		
		menuItem1.addActionListener(view);
		menuItem2.addActionListener(view);
		menuItem3.addActionListener(view);
		menuItem4.addActionListener(view);
		menuItem9.addActionListener(view);
		
		menuItem1.setActionCommand("new");
		menuItem2.setActionCommand("open");
		menuItem3.setActionCommand("save");
		menuItem4.setActionCommand("saveas");
		menuItem9.setActionCommand("quit");
		
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);
		menu1.add(menuItem9);
		
		menuBar.add(menu1);
		
		return menuBar;
	}
}
