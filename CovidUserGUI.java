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
	private JComboBox regionlist;
	private JButton displayButton;
	private JButton regionButton;
	private JTextArea txtReport;
	public ArrayList<CovidInfo> covid_areas = new ArrayList<CovidInfo>();
	
	CovidInfo findRegion(String in) {
		for(int i = 0; i < covid_areas.size(); i++) {
			if(covid_areas.get(i).getRegion().equals(in)) {
				return covid_areas.get(i);
			}
		}
		return null;
	}
	
	CovidUserGUI(){
		setTitle ("Covid Information");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 250);
		setLayout(new FlowLayout());
		
		//String[] region = {"World","US","WSU"};
		regionlist = new JComboBox();
		regionButton = new JButton();
	
		
		displayButton = new JButton("Display Region");
		regionButton = new JButton("New Region"); 
		txtReport = new JTextArea(7,25);
		
		
		
		add(regionlist);
		add(displayButton);
		add(regionButton);
		add(txtReport);
		
		setVisible(true);
		
		regionButton.addActionListener(this);
		displayButton.addActionListener(this);

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
		}else if(e.getSource() == displayButton) {
			//regionlist.getSelectedItem();
			if(regionlist.getItemCount() > 0) {
			String str = regionlist.getSelectedItem().toString();
			CovidInfo too = findRegion(str);
			txtReport.setText("");
			txtReport.append("Current region:" + too.getRegion() + "\n");
			txtReport.append("Current cases:" + too.getCases() + "\n");
			txtReport.append("Current deaths:" + too.getDeaths() + "\n");
			txtReport.append("Current safety level: " + too.getSafetyLevel() + "\n");
			}
		}
	}

}
