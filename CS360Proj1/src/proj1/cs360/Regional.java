package proj1.cs360;

import java.util.ArrayList;

public class Regional {
    /*TODO: Add to sectionals array up to its length in order of closest to furthest.
    * TODO: Sort sectionals.
    * Since a sectional contains School objects, something like sectionals.schools
    * School > Sectional (Array of Schools) > Regional (Array of Sectionals, each of which has an array oc Schools)*/
    private School host;
    private ArrayList<Sectional> sectionals;
    boolean added;
    private int size;
    private int actualSize;
    
    public Regional(School host, ArrayList<Sectional> sectionals,int size){
        //this.host="";
        this.sectionals = sectionals;
        this.size=size;
    }// end constructor
    public Regional(School host,int size){
    	this.sectionals=new ArrayList<Sectional>();
    	this.host=host;
    	this.size=size;
    	this.added=false;
    	this.actualSize=this.sectionals.size();
    	//this.sectionals.add(sectional);
    }
    
    public int getSize() {
		return size;
	}
    public boolean removeSectional(Sectional x){
    	for(int i=0;i<sectionals.size();i++){
    		if(x.getHost().equals(sectionals.get(i).getHost())){
    			sectionals.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
	public ArrayList<Sectional> getSectionals() {
		return sectionals;
	}
	public void setSectionals(ArrayList<Sectional> sectionals) {
		this.sectionals = sectionals;
	}
	public int getActualSize() {
		return this.sectionals.size();
	}
	public void setActualSize(int actualSize) {
		this.actualSize = actualSize;
	}
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Sectional getHostSect(){
		return sectionals.get(0);
	}
	public boolean findSchool(School x){
		//finds if the school is part of the regional by checking each sectional for the school
		boolean ret=false;
		for(int i=0;i<sectionals.size();i++){
			ret=sectionals.get(i).findSchool(x);
			if(ret==true)
				break;
		}
		return ret;
	}

   	public String toString(){
		String ret="";
		ret+="\nHost Name: "+this.getHost().getName()+"\n";
		for(int i=0;i<sectionals.size();i++){
			ret+="\tSectional "+(i+1)+" : "+sectionals.get(i).getHost();
		}
		return ret;
	}
    public void addSectional(Sectional x){
    	this.sectionals.add(x);
    }
    public School getHost() {
		return host;
	}
	public void setHost(School host) {
		this.host = host;
	}
	public void addArraySectionals(Sectional[] toAdd){
    	for(int i=0;i<toAdd.length;i++){
    		this.sectionals.add(toAdd[i]);
    	}
    }
   /*
    public boolean addSectional(Sectional toBeAdded){
        Sectional []temp = new Sectional[this.sectionals.length];
        for(int i = 0; i < this.sectionals.length; i++){
            temp[i] = this.sectionals[i];
        }
        this.sectionals = new Sectional[temp.length + 1];
        for(int i = 0; i < temp.length; i++)
            temp[i] = this.sectionals[i];
        this.sectionals[temp.length] = toBeAdded;
        this.count++;
        return true;
    }*/
}// end class
