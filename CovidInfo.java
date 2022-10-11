
public class CovidInfo {
	private int region_id;
	private int cases;
	private int deaths;
	private String region;
	private int currYear;
	
	public CovidInfo(){
		
	}
	
	String getSafetyLevel() {
		if(cases < 10) {
			return "Green";
		}else if(cases < 50) {
			return "Yellow";
		}else if(cases < 100) {
			return "Orange";
		}else if(cases < 200) {
			return "Deep Orange";
		}else {
			return "Red";
		}
	}
	
	//getters and setters
	public void setID(int i) {
		region_id = i;
	}
	public void setRegion(String n){
		region = n;
	}
	public void setCases(int n) {
		cases = n;
	}
	public void setDeaths(int n) {
		deaths = n;
	}
	public int getCases() {
		return cases;
	}
	public int getRegionID() {
		return region_id;	
	}
	public int getDeaths() {
		return deaths;
	}
	public String getRegion() {
		return region;
	}
}
