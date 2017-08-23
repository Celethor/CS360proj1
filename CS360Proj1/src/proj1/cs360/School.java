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
	public School(String name,String location, int enrollment, boolean willingHost){
		this.name=name;
		this.location=location;
		this.enrollment=enrollment;
		this.willingHost=willingHost;
		this.classification=classify(this.enrollment);
	}
	private char classify(int enrollment){
		char classification;
		if(enrollment>1800)
			classification='A';
		else if(enrollment>1000)
			classification='B';
		else if(enrollment>500)
			classification='C';
		else 
			classification='D';
		return classification;
	}
	
}
