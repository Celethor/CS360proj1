package proj1.cs360;

/*
 * This class contains all of the fields and methods necessary to
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
	public School(String name,String location, int enrollment, boolean willingHost){
		this.name=name;
		this.location=location;
		this.enrollment=enrollment;
		this.willingHost=willingHost;
		this.classification=classify(this.enrollment);
	}
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
	
	private String lookupAddr(){
	return "";
	}
}
