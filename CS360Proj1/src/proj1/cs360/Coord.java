package proj1.cs360;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;

public class Coord implements Serializable {
	 //transient LatLng coords;
	 String nameSchool;
	 double lat;
	 double lng;
	public Coord(String name,LatLng x){
		this.nameSchool=name;
		this.lat=x.lat;
		this.lng=x.lng;
	}
	
	

	public  void setCoords(LatLng coords) {
		coords = coords;
	}

	public  String getNameSchool() {
		return nameSchool;
	}

	public  void setNameSchool(String nameSchool) {
		nameSchool = nameSchool;
	}
	
	public static void main(String[] args) throws ApiException, InterruptedException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file=new File("All Schools Lists.txt");
		Scanner scan =new Scanner(file).useDelimiter("\\*|\\n");
		
		FileOutputStream fileOut=new FileOutputStream("Coords.dat");
		ObjectOutputStream objOut=new ObjectOutputStream(fileOut);
		ObjectInputStream objIn=new ObjectInputStream(new FileInputStream("Coords.dat"));
		int c=0;
		ArrayList<String>names=new ArrayList<String>();
		while(scan.hasNext()){
			String name=scan.next();
			int enrollment=scan.nextInt();
			boolean boys=assignBoolean(scan.next());
			boolean girls=assignBoolean(scan.next());
			boolean HostSect=assignBoolean(scan.next());
			boolean HostReg=assignBoolean(scan.next());
			boolean HostSemi=assignBoolean(scan.next());
			names.add(name);
		}
		
		Coord []x=new Coord[names.size()];
		System.out.println(x.length);
		int j=0;
		for( j=0;j<x.length;j++){
			String tN=names.get(j);
			LatLng tL=EarthSearch.lookupCoord(tN+",IN");
			x[j]=new Coord(tN,tL);
			objOut.writeObject(x[j]);
		}
		System.out.println(j);
		//Coord []temp=new Coord[391-383];
		//System.out.println(EarthSearch.lookupCoord("Evansville Reitz Memorial High School"));
		/*
		for(int k=383;k<391;k++){
			System.out.println(names.get(k));
			LatLng l=EarthSearch.lookupCoord(names.get(k)+",IN");
			System.out.println(l.lat);
		}*/
		objOut.close();
		fileOut.close();
		System.out.println("Done writing");
		int flag=1;
		System.out.println("Read");
		/*Coord temp[]=new Coord[names.size()];
		for(int i=0;i<names.size();i++){
			temp[i]=(Coord)objIn.readObject();
			//System.out.println(temp.getNameSchool()+"\t"+temp.getCoords().lat);
		}*/
		try{
			while((Coord)objIn.readObject()!=null){
				Coord tempO=(Coord)objIn.readObject();
				if(tempO==null)
					break;
				System.out.println("Name: "+tempO.getNameSchool()+"\t"+tempO.lat);
				
			}
		}
		catch(EOFException e){
			System.out.println("Reached EOF");
		}
		/*while((Coord)objIn.readObject()!=null){
			Coord tempO=(Coord)objIn.readObject();
			if(tempO==null)
				break;
			System.out.println("Name: "+tempO.getNameSchool()+"\t"+tempO.lat);
			
		}*/
		objIn.close();
	}
	public static boolean assignBoolean(String x){
		if(x.equals("T")||x.equals("t"))
		return true;
		else 
			return false;
	}

}
