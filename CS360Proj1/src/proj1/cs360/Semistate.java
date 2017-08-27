package proj1.cs360;

import java.util.ArrayList;

public class Semistate {
    private String host;
    private ArrayList<Regional>regionals;

    public Semistate(String host, ArrayList<Regional>regionals){
        this.host="";
        this.regionals = regionals;
        
    }// end constructor

    public String toString(){
        String str = "" + ("Host Name: " + host + "\n");
        for(int i = 0; i< regionals.size(); i++)
            str = str + regionals.get(i).toString() + "\n";
        return str;
    }// end toString

    public String getHost() {
        return host;
    }// end getHost

    public void setHost(String host) {
        this.host = host;
    }// end setHost

   
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
