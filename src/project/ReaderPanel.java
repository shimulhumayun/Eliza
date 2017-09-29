package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReaderPanel extends JPanel implements ActionListener {
	private TextIO text;
	private JTextArea textArea;
	private String fileName;
	private JTextField filePath;
	private JButton openFile;
	private JFileChooser fileChooser;
	//Change the value to true to turn off JFIleChooser and specify a file name in constructor instead
	private boolean turnOff =false;

	public ReaderPanel() {
		this.setLayout(new BorderLayout());
		fileName="hello.txt";
		text = new TextIO(fileName);
		fileChooser = new JFileChooser();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		// textArea.setEditable(false);
		filePath = new JTextField();
		filePath.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		this.add(scroll, BorderLayout.CENTER);
		this.add(gridPanel(), BorderLayout.SOUTH);
		turnOffFileChooser();
	}
	private void turnOffFileChooser(){
		if(turnOff){
			openFile.setEnabled(false);
			filePath.setEnabled(false);
			//read the file
			textArea.setText(text.readFile(fileName));
		}
	}

	public JPanel gridPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		filePath = new JTextField();
		openFile = new JButton("Browse");
		openFile.addActionListener(this);
		filePath.setEditable(false);
		panel.add(filePath);
		panel.add(openFile);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Browse")) {
			int i = fileChooser.showOpenDialog(this);
			if (i == JFileChooser.APPROVE_OPTION) {
				filePath.setText(fileChooser.getSelectedFile().getAbsolutePath());
				fileName = fileChooser.getSelectedFile().getAbsolutePath();
				textArea.append(text.readFile(fileName));
			}
		}

	}

}
