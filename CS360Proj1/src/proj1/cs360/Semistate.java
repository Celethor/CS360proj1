package proj1.cs360;

import java.util.ArrayList;

public class Semistate {
    private String host;
    private ArrayList<Regional>regionals;
    private School hostSchool;
    private int size;
    public Semistate(String host, ArrayList<Regional>regionals,int size){
        this.host="";
        this.regionals = regionals;
        this.size=size;
    }// end constructor
    public Semistate(School host,int size){
    	//this.host=host;
    	this.hostSchool=host;
    	this.host=host.getName();
    	regionals=new ArrayList<Regional>();
    	this.size=size;
    	
    }
    
    public School getHostSchool() {
		return hostSchool;
	}
	public void setHostSchool(School hostSchool) {
		this.hostSchool = hostSchool;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString(){
        String str = "" + ("Host Name: " + this.getHost() + "\n");
        for(int i = 0; i< regionals.size(); i++)
            str = str + regionals.get(i).getHost().getName() + "\n";
        return str;
    }// end toString

    public String getHost() {
        return host;
    }// end getHost

    public void setHost(String host) {
        this.host = host;
    }// end setHost
    
    public void addRegional(Regional toBeAdded){
    	this.regionals.add(toBeAdded);
    }
    
    public void addArrayRegionals(Regional []x){
    	for(int i=0;i<x.length;i++){
    		this.regionals.add(x[i]);
    	}
    }
    public Regional getHostRegional(){
    	return this.regionals.get(0);
    }
    /*public boolean addRegional(Regional toBeAdded){
        Regional []temp = new Regional[this.regionals.length];
        for(int i = 0; i < this.regionals.length; i++){
            temp[i] = this.regionals[i];
        }
        this.regionals = new Regional[temp.length + 1];
        for(int i = 0; i < temp.length; i++)
            temp[i] = this.regionals[i];
        this.regionals[temp.length] = toBeAdded;
        this.count++;
        return true;
    }*/
}
