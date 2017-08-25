package proj1.cs360;

public class Sectional {
	private String host;
	private School []schools;
	//private final int size=13;
	
	private int count=0;
	private String type;
	
	public Sectional(String host, School []schools){
		this.host="";
		//this.count=0;
		this.schools=new School[schools.length];
		for(int i=0;i<schools.length;i++){
			this.schools[i]=schools[i];
			this.count++;
		}
	}
	
	public String toString(){
		String x="";
		x+="Host Name: "+host+"\n";
		for(int i=0;i<schools.length;i++)
			x=x+schools.toString()+"\n";
		return x;
	}
	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public School[] getSchools() {
		return schools;
	}


	public void setSchools(School[] schools) {
		this.schools = schools;
	}


	public int getCount() {
		return count;
	}


	public String getType() {
		return type;
	}


	public boolean addSchool(School toBeAdded){
		/*if(this.count>=this.size)
			return false;*/
			School []temp=new School[this.schools.length];
			for(int i=0;i<this.schools.length;i++){
				temp[i]=this.schools[i];
			}
			this.schools=new School[temp.length+1];
			for(int i=0;i<temp.length;i++)
				temp[i]=this.schools[i];
			this.schools[temp.length]=toBeAdded;
			this.count++;
			return true;
		
		}
}