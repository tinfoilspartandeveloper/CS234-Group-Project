import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	private JButton editButton;
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
	void saveData() throws IOException {
		FileWriter write = new FileWriter("src/save", false);
		write.close();
		write = new FileWriter("src/save");
		for(int i = 0; i < covid_areas.size(); i++) {
			write.write(covid_areas.get(i).getRegion() + " " + covid_areas.get(i).getCases() + " " + covid_areas.get(i).getDeaths() + " " + covid_areas.get(i).getTime().toString() + "\n");
		}
		write.close();
	}
	void loadData() throws IOException{
		FileReader obj =  new FileReader("src/save");
		BufferedReader instream = new BufferedReader(obj);
		boolean exitf = false;
		while(!exitf) {
			String out = instream.readLine();
			CovidInfo in = new CovidInfo();
			if(out == null) {
				exitf = true;
			}else {
				String t = "";
				int i;
				for(i = 0; out.charAt(i) != ' ' && i < out.length(); i++) {
					t = t + out.charAt(i);
				}
				in.setRegion(t);
				t = "";
				for(i = i+1; out.charAt(i) != ' ' && i < out.length(); i++) {
					t = t + out.charAt(i);
				}
				in.setCases(Integer.parseInt(t));
				t = "";
				for(i = i+1; out.charAt(i) != ' ' && i < out.length(); i++) {
					t = t + out.charAt(i);
				}
				in.setDeaths(Integer.parseInt(t));
				t = "";
				for(i = i+1; i < out.length(); i++) {
					t = t + out.charAt(i);
				}
				in.setTime(java.time.LocalDate.parse(t));
				covid_areas.add(in);
				regionlist.addItem(in.getRegion());
			}
		}
		
	}
	CovidUserGUI(){
		setTitle ("Covid Information");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 250);
		setLayout(new FlowLayout());
		
		//String[] region = {"World","US","WSU"};
		regionlist = new JComboBox();
		regionButton = new JButton();
		editButton = new JButton("Edit Region");
		
		displayButton = new JButton("Display Region");
		regionButton = new JButton("New Region"); 
		txtReport = new JTextArea(7,25);
		
		
		
		add(regionlist);
		add(displayButton);
		add(editButton);
		add(regionButton);
		add(txtReport);
		
		setVisible(true);
		
		txtReport.setEditable(false);
		regionButton.addActionListener(this);
		displayButton.addActionListener(this);
		editButton.addActionListener(this);
		try {
			this.loadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				regionlist.addItem(region_in.getText());
				try {
					this.saveData();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource() == displayButton) {
			//regionlist.getSelectedItem();
			if(regionlist.getItemCount() > 0) {
			String str = regionlist.getSelectedItem().toString();
			CovidInfo too = findRegion(str);
			txtReport.setText("");
			txtReport.append("Time of data: " + too.getTime().toString() + "\n");
			txtReport.append("Current region:" + too.getRegion() + "\n");
			txtReport.append("Current cases:" + too.getCases() + "\n");
			txtReport.append("Current deaths:" + too.getDeaths() + "\n");
			if(str.equals("WSU")) {
				txtReport.append("Current safety level: " + too.getSafetyLevel() + "\n");
				}
			}
		}else if(e.getSource() == editButton) {
			if(regionlist.getItemCount() > 0) {
				String str = regionlist.getSelectedItem().toString();
				CovidInfo too = findRegion(str);
				JTextField region_cases = new JTextField(5);
				JTextField region_deaths = new JTextField(5);
				JPanel panel = new JPanel();
				panel.add(new JLabel("Region Cases: "));
				panel.add(region_cases);
				panel.add(new JLabel("Region Deaths: "));
				panel.add(region_deaths);
				
				int result = JOptionPane.showConfirmDialog(null, panel, "Enter region info for " + str, JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
					too.setCases(Integer.parseInt(region_cases.getText()));
					too.setDeaths(Integer.parseInt(region_deaths.getText()));
					too.updateTime();
					try {
						this.saveData();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

}
