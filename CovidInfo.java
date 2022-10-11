
public class CovidInfo {
	private int region_id;
	private int cases;
	private int deaths;
	private String region;
	private int currYear;
	
	

	public String getSafetyLevel() {
		return region;
	}
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
