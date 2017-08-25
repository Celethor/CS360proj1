package proj1.cs360;

public class Meet {
	private String host;
	private School []schools;
	//private final int size=13;
	
	private int count=0;
	private String type;
	
	public Meet(String host, School []schools){
		this.host="";
		//this.count=0;
		this.schools=new School[schools.length];
		for(int i=0;i<schools.length;i++){
			this.schools[i]=schools[i];
			this.count++;
		}
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