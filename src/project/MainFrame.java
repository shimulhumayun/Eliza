package project;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame implements WindowListener {
	private JTabbedPane tab;
	private Panel panel;
	ReaderPanel reader;
	public MainFrame() {
		// set title
		super("ELIZA");
		addWindowListener(this);
		tab = new JTabbedPane();
		panel = new Panel();
		reader = new ReaderPanel();
		tab.add("Main Panel", panel);
		tab.addTab("File Reader", reader);
		this.add(tab);
		// this.add(panel);
		this.setSize(560, 600);
		this.setResizable(false);
		// center the windows
		this.setLocationRelativeTo(null);
		// set visible
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		 panel.printAllWords();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
