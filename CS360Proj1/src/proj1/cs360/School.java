package proj1.cs360;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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
	private boolean boys;
	private boolean girls;
	private boolean HostSect;
	private boolean HostReg;
	private boolean HostSemi;
	private char classification;
	
	public School(){
		name=new String("");
		location=new String("");
		enrollment=0;
		HostSect=false;
		HostReg=false;
		HostSemi=false;
		classification='N';
	}
	public School(String name, int enrollment, boolean boys,boolean girls,boolean HostSect,boolean HostReg,boolean HostSemi){
		this.name=name;
		//this.location= lookupAddr();		
		this.enrollment=enrollment;
		this.boys=boys;
		this.girls=girls;
		this.HostSect=HostSect;
		this.HostReg=HostReg;
		this.HostSemi=HostSemi;
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
	
	public boolean isBoys() {
		return boys;
	}
	public void setBoys(boolean boys) {
		this.boys = boys;
	}
	public boolean isGirls() {
		return girls;
	}
	public void setGirls(boolean girls) {
		this.girls = girls;
	}
	public boolean isHostSect() {
		return HostSect;
	}
	public void setHostSect(boolean hostSect) {
		HostSect = hostSect;
	}
	public boolean isHostReg() {
		return HostReg;
	}
	public void setHostReg(boolean hostReg) {
		HostReg = hostReg;
	}
	public boolean isHostSemi() {
		return HostSemi;
	}
	public void setHostSemi(boolean hostSemi) {
		HostSemi = hostSemi;
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
			return EarthSearch.lookupAddr(this.name + ", Indiana");
		} catch (Exception e) {
			return "Error locating School";
		}
	}
	
	//returns travel distance between schools
	public static long travelDist(School a, School b) throws ParseException {
		
	  long temp =0;
		try {
			temp = EarthSearch.getDriveDist(a.name+", IN", b.name+" ,IN");
			
		} catch(Exception e) {
			return -1;
		}
		NumberFormat format = NumberFormat.getInstance(Locale.US);

       // Number number = format.parse(temp.substring(0, temp.indexOf(" ")));
        //System.out.println(number);
		//return Long.parseLong(temp.substring(0, temp.indexOf(" ")));
		return temp;
	}
	
}
