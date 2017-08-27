package proj1.cs360;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Scanner;

public class Tournament {
	ArrayList<School> schools;
	Sectional sectionals[];
	
	public Tournament(ArrayList<School>schools) throws ParseException{
		this.schools=schools;
		sortIntoSectionals();
	}
	private void sortIntoSectionals() throws ParseException{
		sectionals=new Sectional[8];
		int sectionNumber=0;
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>=8){
				break;
			}
			if(schools.get(i).isHostSect()==true){
					sectionals[sectionNumber].setSchools(getClosest(schools,schools.get(i)));
					sectionNumber++;
			}
		}
	}
	private School[] getClosest(ArrayList<School> schools, School host) throws ParseException{
		School []closest=new School[13];
		for(int counter=0;counter<13;counter++){
			
			long small=School.travelDist(schools.get(0), host);
			School smallSchool=schools.get(0);
			int index=0;
			for(int i=0;i<schools.size();i++){
				if(School.travelDist(host, schools.get(i))<small){
					smallSchool=schools.get(i);
					index=i;
				}
			}
			if(schools.get(index).isHostSect()==true&&!(schools.get(index).getName().equals(host.getName())))
				continue;
			closest[counter]=smallSchool;
			schools.remove(index);
		}
		return closest;
	}
	public String toString(){
		return sectionals[0].toString();
	}
}
