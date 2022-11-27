
public class CovidInfo {
	private int region_id;
	private int cases;
	private int deaths;
	private String region;
	private java.time.LocalDate time;
	public CovidInfo() {
		
	}
	
	public CovidInfo(int r, int c, int d, String reg){
		region_id = r;
		cases = c;
		deaths = d;
		region = reg;
		time = java.time.LocalDate.now();
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
	public void setTime(java.time.LocalDate t) {
		time = t;
	}
	public void updateTime() {
		time = java.time.LocalDate.now();
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
	public java.time.LocalDate getTime() {
		return time;
	}
}
