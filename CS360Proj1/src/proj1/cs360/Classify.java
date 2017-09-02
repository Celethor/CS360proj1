package proj1.cs360;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Classify {
	private char className;
	private int maxEnrollment;
	private int sectNo;
	private int regNo;
	private int semiNo;
	ArrayList<School> schools;
	ArrayList<Sectional> sectionals;
	ArrayList<Regional> regionals;
	ArrayList<Semistate> semistates;
	int sectDivisor;
	int modSect;
	int regDivisor;
	int modReg;
	ArrayList<School> otherSchools;
	/**
	 * Method/Constructor for class structure
	 * @param sect: inputs the number of sectionals based on user input
	 * @param reg: inputs the number of regionals based on user input
	 * @param semi: inputs the number of semi-states based on user input
	 * @param sch: inputs the list of schools after reading from file
	 * @throws ParseException 
	 */
	public Classify(int sect,int reg,int semi,int maxEnroll, ArrayList<School> sch) throws ParseException{
		Scanner scan=new Scanner(System.in);
		System.out.println("You are creating a new class. Please provide a name (single character): ");
		this.className=scan.nextLine().charAt(0);
		this.sectNo=sect;
		this.regNo=reg;
		this.semiNo=semi;
		this.maxEnrollment=maxEnroll;
		this.schools=new ArrayList<School>();
		this.otherSchools=new ArrayList<School>();
		for(int i=0;i<sch.size();i++){
			if(sch.get(i).classified==false)
			if(sch.get(i).getEnrollment()<=this.maxEnrollment){
				this.schools.add(sch.get(i));
				sch.get(i).classified=true;
			}
		}
		this.otherSchools.addAll(schools);
		//for finding the number of sectionals already present
		int presentSect=0;
		for(int i=0;i<this.schools.size();i++){
			if(this.schools.get(i).isHostSect()==true){
				presentSect++;
			}
		}
		System.out.println("Present Sectionals in class "+this.className+" : "+presentSect);
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		this.modSect=schools.size()%sectNo;
		//sortIntoSectionals();
	}
	/**
	 * Better constructor for classes. Used at present
	 * @param maxEnrollment: maximum enrollment for this class
	 * @param sch: list of all schools as read from file
	 * The method will take in all the schools and grab the schools which satisfy its maxEnrollment
	 * If the school gets classified, it sets thatSchool.classified=true so that it cannot be classified
	 * into another class. 
	 * @throws ParseException 
	 */
	public Classify(int maxEnrollment, ArrayList<School> sch) throws ParseException{
		this.maxEnrollment=maxEnrollment;
		Scanner scan=new Scanner(System.in);
		this.schools=new ArrayList<School>();
		for(int i=0;i<sch.size();i++){
			if(sch.get(i).classified==false)
			if(sch.get(i).getEnrollment()<this.maxEnrollment){
				this.schools.add(sch.get(i));
				sch.get(i).classified=true;
			}
		}
		System.out.println("You are creating a new class. Please enter the name as single character : ");
		this.className=scan.nextLine().charAt(0);
		int presentSect=0;
		for(int i=0;i<this.schools.size();i++){
			if(this.schools.get(i).isHostSect()==true){
				presentSect++;
			}
		}
		System.out.println("Present Sectionals in class "+this.className+" : "+presentSect);
		System.out.println("Enter the no. of sectionals you want: ");
		int userSect=scan.nextInt();
		if(userSect==presentSect)
			this.sectNo=presentSect;
		else{
			if(userSect<presentSect){
				System.out.println("There are more hosts than specified for Sectionals. Please go through"
						+ "the list of hosts and type in which ones to remove");
				System.out.println("Present no. of hosts for sectionals: "+School.sectNo);
				for(int i=0;i<schools.size();i++)
					if(schools.get(i).isHostSect()==true){
						System.out.println("Name: "+schools.get(i).getName());
					}
				for(int j=0;j<School.getSectNo()-userSect;j++){
					System.out.println("Enter School "+(j+1)+" to remove: ");
					String name=scan.nextLine();
					System.out.println(name);
					int num=schools.size();
					for(int k=0;k<num;k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSect(false);
							System.out.println("Done matching School");
							break;
						}
					}
				}
				this.sectNo=userSect;
			}
			//if the user wants more hosts but there are not many in the file already, add more
			else if(userSect>School.getSectNo()){
				System.out.println("There are less hosts than specified for Sectionals. Please go through"
						+ "the list of schools and type in which ones to add");
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSect()==false){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				for(int j=0;j<userSect-School.getSectNo();j++){
					System.out.println("Enter School "+(j+1)+" to add as Host: ");
					String name=scan.nextLine();
					for(int k=0;k<schools.size();k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSect(true);
							System.out.println("Done");
							break;
						}
					}
				}
				this.sectNo=userSect;
			}
		}
		int presentReg=0;
		for(int i=0;i<this.schools.size();i++){
			if(this.schools.get(i).isHostReg()==true){
				presentReg++;
			}
		}
		System.out.println("Present Regionals in class "+this.className+" : "+presentReg);
		System.out.println("Enter the no. of Regionals you want: ");
		int userReg=scan.nextInt();
		if(userReg==presentReg)
			this.regNo=presentReg;
		else{
			//For Regionals
			//if the user wants less regionals than already present, give user option to remove
			if(userReg<presentReg){
				System.out.println("There are more hosts for regionals. Please select to remove");
				System.out.println("Present no. of Regional hosts: "+School.getRegNo());
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostReg()==true){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				for(int j=0;j<School.getRegNo()-userReg;j++){
					System.out.println("Enter School "+(j+1)+" to remove as host: ");
					String name=scan.nextLine();
					int num=schools.size();
					for(int k=0;k<num;k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostReg(false);
							System.out.println("Done Matching School");
							break;
						}
					}
				}
				this.regNo=userReg;
			}
			//if user wants more hosts than already in file, add more hosts by giving user the option
			else if(userReg>School.getRegNo()){
				System.out.println("there are less hosts. Please add more");
				System.out.println("Present no. of Regional hosts: "+School.getRegNo());
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostReg()==false){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				for(int j=0;j<userReg-School.getRegNo();j++){
					System.out.println("Enter School "+(j+1)+" to add");
					String name=scan.nextLine();
					int num=schools.size();
					for(int k=0;k<schools.size();k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostReg(false);
							System.out.println("Done matching");
							break;
						}
					}
				}
				this.regNo=userReg;
			}
		}
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		this.modSect=schools.size()%sectNo;
		System.out.println("Sectional Divisor : "+sectDivisor+"\nSectional Mod : "+modSect);
		sectionals=new ArrayList<Sectional>();
		sortIntoSectionals();
	}
	/**
	 * Method to sort the schools into respective 
	 * sectionals. This ensures that the 
	 * no. of sectionals in a particular class 
	 * cannot be equal to zero!
	 * @throws ParseException
	 */
	public void sortIntoSectionals() throws ParseException{
		int sectionNumber=0;
		int indexOfHosts[]=new int[sectNo];
		//find the hosts and give each a sectional
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>sectNo)
				break;
			if(schools.get(i).isHostSect()==true){
				//System.out.println("School: "+schools.get(i).getName());
				sectionals.add(new Sectional(schools.get(i).getName(),schools.get(i),sectDivisor));
				indexOfHosts[sectionNumber]=i;
				sectionNumber++;
				//schools.remove(i);//do not remove schools as it is giving error
			}
			
		}
		//find schools nearest to host and add them 
		//counter and mod are used when the amount of schools is not divisible
		//by the number of sectionals that is required by the user
		int counter=0;
		System.out.println("SecNo: "+sectNo+" sec .size = "+sectionals.size());
		for(int j=0;j<sectNo;j++){
			if(counter<modSect){
				sectionals.get(j).addArraySchools(getClosest(schools,sectionals.get(j).getHostSchool(),sectionals.get(j).getSize()+1));
				counter++;
			}
			else{
				School temp=sectionals.get(j).getHostSchool();
				int tempSize=sectionals.get(j).getSize();
				sectionals.get(j).addArraySchools(getClosest(schools,temp,tempSize));
			}
		}
		System.out.println("Done sorting schools into classes");
	}
	/**
	 * Method to sort sectionals into the regionals
	 * Will also work(expected to) even if the 
	 * no. of regionals as required by the user
	 * is set = 0; 
	 */
	private void sortIntoRegionals(){
		//first case : regNo not equal to zero 
		//(i.e. when user has specified for input)
		if(regNo!=0){
			int regionNumber=0;
			for(int i=0;i<otherSchools.size();i++){
				if(regionNumber>regNo)
					break;
				if(otherSchools.get(i).isHostReg()==true){
					School temp=otherSchools.get(i);
					regionals.add(new Regional(temp,regDivisor));
					regionNumber++;
				}
			}
			//for adding host sectional
			int counter=0;
			for(counter=0;counter<regNo;counter++)
				for(int j=0;j<sectionals.size();j++){
					if(counter==regNo)
						break;
					School h=regionals.get(counter).getHost();
					if(sectionals.get(j).findSchool(h)){
						regionals.get(counter).addSectional(sectionals.get(j));
						sectionals.get(j).setAdded(true);
						break;
					}
				}
			//for adding nearby sectional
			counter=0;
			for(int j=0;j<regNo;j++){
				if(counter<modReg){
					regionals.get(j).addArraySectionals(getClosestSect(sectionals,regionals.get(j).getHostSect(),regionals.get(j).getSize()));
					counter++;
				}
				else{
					Sectional temp=regionals.get(j).getHostSect();
					int tempS=regionals.get(j).getSize()-1;
					regionals.get(j).addArraySectionals(getClosestSect(sectionals,temp,tempS));
				}
			}
		}
	}
	/**
	 * Methods returns the closest schools to a given hosts
	 * Used for sorting into sectionals
	 * @param schools: list of all the schools 
	 * @param host: host school
	 * @param x: size of particular sectional
	 * @return: closest x schools to a particular host
	 * @throws ParseException
	 */
	private School[] getClosest(ArrayList<School> schools, School host,int x) throws ParseException{
		School []closest=new School[x];
		for(int counter=0;counter<x;counter++){
			if(schools.size()==0)
				break;
			School temp=schools.get(0);
			if(temp.getName().equals(host.getName())==false){
			long small=School.travelDist(temp, host);
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
		}
		return closest;
	}
	/**
	 * Method returns the closest sectionals to a particular
	 * regional 
	 * @param sect: list of sectionals that can be added
	 * @param host: host sectional
	 * @param x: size of host sectional
	 * @return: closest x sectionals to a given host regional
	 */
	public Sectional[] getClosestSect(ArrayList<Sectional> sect, Sectional host, int x){
		Sectional[] closest=new Sectional[x];
		for(int counter=0;counter<x;counter++){
			if(sect.size()==0)
				break;
			long small=School.travelDist(sect.get(0).getHostSchool(), host.getHostSchool());
			Sectional smallSect=sect.get(0);
			int index=0;
			for(int i=0;i<sect.size();i++){
				if(sect.get(i).isAdded()==false){
					if(School.travelDist(host.getHostSchool(), sect.get(i).getHostSchool())<small){
						smallSect=sect.get(i);
						index=i;
					}
				}
				closest[counter]=smallSect;
				sect.get(index).setAdded(true);
			}
		}
		return closest;
	}
	public String toString(){
		String ret="Sectionals";
		for(int i=0;i<sectionals.size();i++){
			ret+=sectionals.get(i).toString()+"\n";
		}
		return ret;
	}
}
