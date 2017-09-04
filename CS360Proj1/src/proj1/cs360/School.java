package proj1.cs360;

import java.io.IOException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;

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
	 boolean classified=false;//lets system know if already classified
	 static int sectNo=0;
	 static int regNo=0;
	 static int semiNo=0;
	LatLng coords;
	public School(){
		name=new String("");
		location=new String("");
		enrollment=0;
		HostSect=false;
		HostReg=false;
		HostSemi=false;
		classification='N';
	}
	public School(String name, int enrollment, boolean boys,boolean girls,boolean HostSect,boolean HostReg,boolean HostSemi) throws ApiException, InterruptedException, IOException, ClassNotFoundException{
		this.name=name;
		//this.location= lookupAddr();	
		this.coords=EarthSearch.lookupCoordFromFile(name);
		this.enrollment=enrollment;
		this.boys=boys;
		this.girls=girls;
		this.HostSect=HostSect;
		this.HostReg=HostReg;
		this.HostSemi=HostSemi;
		this.classification=classify(this.enrollment);
		if(this.isHostSect()==true)
			sectNo++;
		if(this.isHostReg()==true)
			regNo++;
		if(this.isHostSemi()==true)
			semiNo++;
	}
	
	
	//SETTERS AND GETTERS
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
	
	public static int getRegNo() {
		return regNo;
	}
	public static void setRegNo(int regNo) {
		regNo = regNo;
	}
	public static int getSemiNo() {
		return semiNo;
	}
	public static void setSemiNo(int semiNo) {
		semiNo = semiNo;
	}
	
	public static int getSectNo() {
		return sectNo;
	}
	public static void setSectNo(int sectNo) {
		sectNo = sectNo;
	}
	//END SETTERS AND GETTERS
	
	//
	//SHOUDL PROBABLY BE MOVED TO AN INDEPENEDENT CLASS??
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
	/*public static long travelDist(School a, School b) throws ParseException {
		
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
	}*/
	public static long travelDist(School a,School b){
		double orgLat=a.coords.lat;
		double orgLng=a.coords.lng;
		double dstLat=b.coords.lat;
		double dstLng=b.coords.lng;
		
		//System.out.println("Lat1: "+orgLng+"\tLat2: "+dstLng);
		
		double latDistance=Math.toRadians( dstLat-orgLat );
		double lngDistance=Math.toRadians(dstLng-orgLng);
		
		double x=Math.sin(latDistance/2)*Math.sin(latDistance/2) 
				+ Math.cos(Math.toRadians(orgLat))*Math.cos(Math.toRadians(dstLat))
				*Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
		double c=2*Math.atan2(Math.sqrt(x),Math.sqrt(1-x));
		
		return (long)(6371000*c);
	}
	
	public String toString(){
		return "Name: "+this.getName()+"Enrollment: "+this.getEnrollment()+"\n";
	}
	
}
