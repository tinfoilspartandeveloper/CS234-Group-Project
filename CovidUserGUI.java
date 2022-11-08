import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CovidUserGUI extends JFrame implements ActionListener {
	private JLabel addRegion;
	private JComboBox regionlist;
	private JButton regionButton;
	private JTextArea txtReport;
	public ArrayList<CovidInfo> covid_areas = new ArrayList<CovidInfo>();
	
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
		
		if(e.getSource() == regionButton) {
			JTextField region_in = new JTextField(5);
			JTextField region_cases = new JTextField(5);
			JTextField region_deaths = new JTextField(5);
			
			JPanel panel = new JPanel();
			panel.add(new JLabel("Region Name: "));
			panel.add(region_in);
			panel.add(new JLabel("Region Cases: "));
			panel.add(region_cases);
			panel.add(new JLabel("Region Deaths: "));
			panel.add(region_deaths);
			
			int result = JOptionPane.showConfirmDialog(null, panel, "Enter region info", JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION) {
				CovidInfo inf = new CovidInfo(covid_areas.size(), Integer.parseInt(region_cases.getText()), Integer.parseInt(region_deaths.getText()), region_in.getText());
				covid_areas.add(inf);
			}
			
			regionlist.addItem(region_in.getText());
		}
	}

}
