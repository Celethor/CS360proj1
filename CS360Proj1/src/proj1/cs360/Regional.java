package proj1.cs360;

import java.util.ArrayList;

public class Regional {
    /*TODO: Add to sectionals array up to its length in order of closest to furthest.
    * TODO: Sort sectionals.
    * Since a sectional contains School objects, something like sectionals.schools
    * School > Sectional (Array of Schools) > Regional (Array of Sectionals, each of which has an array oc Schools)*/
    private String host;
    private ArrayList<Sectional> sectionals;

    public Regional(String host, ArrayList<Sectional> sectionals){
        this.host="";
        this.sectionals = sectionals;
        
    }// end constructor

    public String toString(){
        String str = "" + ("Host Name: " + host + "\n");
        for(int i = 0; i< sectionals.size(); i++)
            str = str + sectionals.toString() + "\n";
        return str;
    }// end toString

    public String getHost() {
        return host;
    }// end getHost

    public void setHost(String host) {
        this.host = host;
    }// end setHost

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
