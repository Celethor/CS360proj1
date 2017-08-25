package proj1.cs360;


/*
 * This class contains all of the fields and methods necessary to
 * create a wonderful school object
 * 
 * 
 * 
 */

public class School {

	private String name;
	private String location;
	private int enrollment;
	private boolean willingHost;
	private char classification;
	
	public School(){
		name=new String("");
		location=new String("");
		enrollment=0;
		willingHost=false;
		classification='N';
	}
	public School(String name, int enrollment, boolean willingHost){
		this.name=name;
		this.location= lookupAddr();		
		this.enrollment=enrollment;
		this.willingHost=willingHost;
		this.classification=classify(this.enrollment);
	}
	
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public int getEnrollment() {
		return enrollment;
	}
	public boolean isWillingHost() {
		return willingHost;
	}
	public char getClassification() {
		return classification;
	}
	
	//
	private char classify(int enrollment){
		char classification;
		if(enrollment>1600)
			classification='A';
		else if(enrollment>800)
			classification='B';
		else 
			classification='C';
		return classification;
	}
	
	//used in contructor, gets address by looking up name via google maps
	private String lookupAddr(){
		try {
			return EarthSearch.lookupAddress(this.name + ", Indiana");
		} catch (Exception e) {
			return "Error locating School";
		}
	}
	
}
