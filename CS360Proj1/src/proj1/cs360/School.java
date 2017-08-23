package proj1.cs360;

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
	public School(String name,String location, int enrollment, boolean willingHost, char classification){
		this.name=name;
		this.location=location;
		this.enrollment=enrollment;
		this.willingHost=willingHost;
		this.classification=classification;
	}
}
