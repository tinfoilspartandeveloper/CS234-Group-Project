import java.util.ArrayList;
import java.util.Scanner;

public class CovidUser {
	public ArrayList<CovidInfo> covid_areas = new ArrayList<CovidInfo>();
	
	CovidInfo findRegion(String in) {
		for(int i = 0; i < covid_areas.size(); i++) {
			if(covid_areas.get(i).getRegion().equals(in)) {
				return covid_areas.get(i);
			}
		}
		return null;
	}
	void printRegion(String in) {
		CovidInfo too = findRegion(in);
		System.out.println("-----------------------------------------");
		System.out.println("Current region:" + too.getRegion());
		System.out.println("Current cases:" + too.getCases());
		System.out.println("Current deaths:" + too.getDeaths());
		System.out.println("Current safety level: " + too.getSafetyLevel());
		System.out.println("-----------------------------------------");
	}
	void printRegion(int index) {
		CovidInfo too = covid_areas.get(index);
		System.out.println("-----------------------------------------");
		System.out.println("Current region:" + too.getRegion());
		System.out.println("Current cases:" + too.getCases());
		System.out.println("Current deaths:" + too.getDeaths());
		System.out.println("Current safety level: " + too.getSafetyLevel());
		System.out.println("-----------------------------------------");
	}
	void printAllRegions() {
		for(int i = 0; i < covid_areas.size(); i++) {
			printRegion(i);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		CovidUser user = new CovidUser();
		//Updated upstream
		boolean end = false;
		while(!end) {
			System.out.println("Input choices: 0, new region; 1, edit region cases; 2, edit region deaths; 3, output region info; 4, output all regions info; -1, exit program");
			System.out.print("Input your next choice for input: ");
			switch(in.nextInt()) {
			case 0:
				CovidInfo info = new CovidInfo();
				System.out.print("Input region name: ");
				info.setRegion(in.next());
				System.out.print("Input region cases: ");
				info.setCases(in.nextInt());
				System.out.print("Input region deaths: ");
				info.setDeaths(in.nextInt());
				user.covid_areas.add(info);
				break;
			case 1:
				System.out.print("Input region name: ");
				CovidInfo t = user.findRegion(in.next());
				if(t != null) {
					System.out.print("Input the number of cases: ");
					t.setCases(in.nextInt());
				}
				break;
			case 2:
				System.out.print("Input region name: ");
				CovidInfo to = user.findRegion(in.next());
				if(to != null) {
					System.out.print("Input the number of deaths: ");
					to.setDeaths(in.nextInt());
				}
				break;
			case 3:
				System.out.print("Input region name: ");
				user.printRegion(in.next());
				break;
			case 4:
				System.out.println("Printing all regions");
				user.printAllRegions();
				break;
			case -1:
				end = true;
				break;
			}
		}
	}

}
