import java.util.Scanner;

public class CovidUser {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		CovidInfo info = new CovidInfo();
		
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
