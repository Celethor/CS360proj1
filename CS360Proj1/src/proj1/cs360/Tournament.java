package proj1.cs360;

import java.io.File;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Scanner;

public class Tournament {
	ArrayList<School> schools;
	Sectional sectionals[];
	int sectNo;
	int regNo;
	int semiNo;
	int sectDivisor;
	int mod;
	public Tournament(ArrayList<School>schools,int section) throws ParseException{
		this.schools=schools;
		this.sectNo=section;
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		System.out.println(this.sectNo);
		sectionals=new Sectional[sectNo];
		mod=this.schools.size()%sectNo;
		sortIntoSectionals();
		
	}
	private void sortIntoSectionals() throws ParseException{
		
		int sectionNumber=0;
		//this is what was giving the error
		/*for(int i=0;i<schools.size();i++){
			if(sectionNumber>=8){
				break;
			}
			if(schools.get(i).isHostSect()==true){
					sectionals[sectionNumber].setSchools(getClosest(schools,schools.get(i)));
					sectionNumber++;
			}
		}*/
		
			for(int i=0;i<schools.size();i++){
			if(sectionNumber>=sectNo)
				break;
			  if(schools.get(i).isHostSect()==true){
				School temp=schools.get(i);
				sectionals[sectionNumber]=new Sectional(temp.getName(),temp,sectDivisor);
				sectionNumber++;
				//sectionals[sectionNumber].setSize(sectDivisor);
				schools.remove(i);
				}
			}
			int counter=0;
		for(int j=0;j<sectNo;j++){
			if(counter<mod){
				sectionals[j].addArraySchools(getClosest(schools,sectionals[j].getHostSchool(),sectionals[j].getSize()));
				counter++;
			}
			else{
			sectionals[j].addArraySchools(getClosest(schools,sectionals[j].getHostSchool(),sectionals[j].getSize()-1));
			}
		}
		System.out.println(schools.size());
		System.out.println("Done Sorting");
		
	}
	private School[] getClosest(ArrayList<School> schools, School host,int x) throws ParseException{
		
		School []closest=new School[x];
		for(int counter=0;counter<x;counter++){
			if(schools.size()==0)
				break;
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
		String x="";
		for(int i=0;i<this.sectNo;i++)
			x+=sectionals[i].toString();
		return x;
		//return sectionals[7].toString();
		/*String out="";
		for(int i=0;i<this.sectNo;i++){
			out+=sectionals[i].getHostSchool().toString();
		}
		return out;*/
	}
}
