package proj1.cs360;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tournament {
	ArrayList<School> schools;
	Sectional sectionals[];
	
	public Tournament(ArrayList<School>schools){
		this.schools=schools;
		sortIntoSectionals();
	}
	private void sortIntoSectionals(){
		sectionals=new Sectional[8];
		int sectionNumber=0;
		for(int i=0;i<98;i++){
			if(sectionNumber>=8){
				break;
			}
			if(schools.get(i).isHostSect()==true){
					sectionals[sectionNumber].setSchools(getClosest(schools,schools.get(i)));
					sectionNumber++;
			}
		}
	}
	private School[] getClosest(ArrayList<School> schools, School host){
		School []closest=new School[13];
		for(int counter=0;counter<13;counter++){
			
			int small=School.travelDist(schools.get(0), host);
			School smallSchool=schools.get(0);
			int index=0;
			for(int i=0;i<schools.size();i++){
				if(School.travelDist(host, schools.get(i))<small){
					smallSchool=schools.get(i);
					index=i;
				}
			}
			closest[counter]=smallSchool;
			schools.remove(index);
		}
		return closest;
	}
	public static void main(String[]args) throws FileNotFoundException{
File file=new File("Schools.txt");
		
		School x=new School();
		String name;
		String location;
		int enrollment;
		boolean boys;
		boolean girls;
		boolean HostSect;
		boolean HostReg;
		boolean HostSemi;
		
		Scanner scan =new Scanner(file).useDelimiter("\\*|\\n");
		int c=0;
		while(scan.hasNext()){
			name=scan.next();
			//location=scan.next();
			enrollment=scan.nextInt();
			//System.out.println(scan.next());
			boys=assignBoolean(scan.next());
			girls=assignBoolean(scan.next());
			HostSect=assignBoolean(scan.next());
			HostReg=assignBoolean(scan.next());
			HostSemi=assignBoolean(scan.next());
			c++;
			x=new School(name,enrollment,boys,girls,HostSect,HostReg,HostSemi);
			System.out.println(x.toString());
			//scan.nextLine();
		}
		System.out.println(c);
	}
	public static boolean assignBoolean(String x){
		if(x.equals("T"))
		return true;
		else 
			return false;
	}
}
