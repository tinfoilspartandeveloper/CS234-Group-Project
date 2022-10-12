import java.util.ArrayList;
import java.util.Scanner;

public class CovidUser {
	private ArrayList<CovidInfo> covid_areas;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		CovidInfo info = new CovidInfo(0, 10, 5, "Winona");

		System.out.print("Enter in region: ");
		System.out.print("Enter in cases: ");
		System.out.print("Enter in deaths: ");

		System.out.println("-----------------------------------------");
		System.out.println("Current region:" + info.getSafetyLevel() );
		System.out.println("Current cases:" + info.getCases() );
		System.out.println("Current deaths:" + info.getDeaths() );
		System.out.println("-----------------------------------------");
	}

}
