import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CovidUserGUI extends JFrame implements ActionListener {
	private JLabel addRegion;
	private JComboBox regionlist;
	private JButton regionButton;
	private JTextArea txtReport;
	
	CovidUserGUI(){
		setTitle ("Covid Information");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 250);
		setLayout(new FlowLayout());
		addRegion = new JLabel("Enter the Region: ");
		String[] region = {"World","US","WSU"};
		regionlist = new JComboBox(region);
		regionButton = new JButton();
		
	
		
		addRegion = new JLabel();
		regionButton = new JButton("Report"); 
		txtReport = new JTextArea("7,25");
		
		
		add(addRegion);
		add(regionlist);
		add(regionButton);
		add(txtReport);
		
		setVisible(true);
		
		regionButton.addActionListener(this);
		

	}
	
	public static void main(String[] args) {
		new CovidUserGUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
