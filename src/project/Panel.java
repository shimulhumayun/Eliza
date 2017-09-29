package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Panel extends JPanel implements ActionListener {
	// string
	private String name;
	private String intro = "Tell me what is on your mind today in 1 sentence";
	// Label and Buttons
	private JLabel title;
	private JTextArea responseArea;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JTextField inputField;
	private JButton talk;
	private SentenceProcessor processor;
	private String format = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
	private TextIO saveText;
	private String fileName = "hello.txt";

	public Panel() {
		// set layout
		this.setLayout(new BorderLayout());
		this.add(tPanel(), BorderLayout.PAGE_START);
		this.add(mainPanel(), BorderLayout.CENTER);
		this.add(eastPanel(), BorderLayout.EAST);
		this.add(bottomPanel(), BorderLayout.PAGE_END);
		// this.add(JlPanel(),BorderLayout.PAGE_END);
		// processor
		processor = new SentenceProcessor();
		saveText = new TextIO(fileName);
		saveText.createNewFile();
		saveText.appendToFile(intro);

	}

	private JPanel tPanel() {
		JPanel panel = new JPanel();
		title = new JLabel("ELIZA");
		panel.add(title);
		return panel;
	}

	private JPanel mainPanel() {
		JPanel panel = new JPanel();
		name = "Eliza: ";
		responseArea = new JTextArea(name + intro, 30, 30);
		responseArea.setLineWrap(true);
		responseArea.setWrapStyleWord(true);
		responseArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(responseArea);
		// tab.add("Main Panel", scroll);
		// tab.addTab("Read from File", reader);
		// panel.add(tab);
		panel.add(scroll);

		return panel;
	}

	public JPanel eastPanel() {
		JPanel panel = new JPanel();
		// JLabel longestWord=new JLabel("Longest Words");
		list = new JList<String>();
		// list.setFixedCellWidth(30);
		JScrollPane scrollPane = new JScrollPane(list);
		TitledBorder titled = new TitledBorder("Longest Words");
		// scrollPane.setPreferredSize(new Dimension(60, 0));
		scrollPane.setBorder(titled);
		list.setBorder(titled);
		listModel = new DefaultListModel<String>();
		listModel.addElement(format);
		list.setModel(listModel);
		// panel.add(scrollPane);
		panel.add(list);
		return panel;
	}

	public JPanel bottomPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		inputField = new JTextField(30);
		inputField.setAlignmentX(RIGHT_ALIGNMENT);
		talk = new JButton("Talk");
		JButton reset = new JButton("Reset");
		talk.setToolTipText("Talk");
		reset.setToolTipText("Reset");
		// Action Listener
		talk.addActionListener(this);
		reset.addActionListener(this);
		panel.add(inputField);
		panel.add(talk);
		panel.add(reset);
		return panel;
	}
	public void printAllWords(){
		System.out.println(processor.getWordList());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equalsIgnoreCase("Talk") && !(inputField.getText().isEmpty())) {
			responseArea.append("\n" + "You: " + inputField.getText());
			processor.setLongestWord(inputField.getText());
			responseArea.append("\n" + this.name + ":" + processor.replyToUser());
			listModel.addElement(processor.getLongestWord());
			processor.addWordToList(processor.getLongestWord());
			// save input to a file
			saveText.appendToFile(inputField.getText() + "\n");
			saveText.appendToFile(name + processor.replyToUser() + "\n");

		} else if (action.equalsIgnoreCase("reset")) {
			responseArea.setText(name + intro);
			listModel.clear();
			listModel.addElement(format);
		} else {
			JOptionPane.showMessageDialog(this, "Invalid input");
		}

	}
}
