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
	int regDivisor;
	int semiDivisor;
	int modSect;
	int modReg;
	int modSemi;
	int userSect;
	int userReg;
	Regional regionals[];
	Semistate semistates[];
	ArrayList<School> schoolsSect;
	ArrayList<School> schoolsReg;
	ArrayList<School> schoolsSemi;
	ArrayList<School> otherSchools;
	/*public Tournament(ArrayList<School>schools,int section,int reg,int semi) throws ParseException{
		this.schools=schools;
		this.sectNo=section;
		this.regNo=reg-1;
		this.semiNo=semi;
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		this.regDivisor=(int)Math.floor((double)this.schools.size()/regNo);
		this.semiDivisor=(int)Math.floor((double)this.schools.size()/semiNo);
		System.out.println(this.sectNo);
		sectionals=new Sectional[sectNo];
		regionals=new Regional[regNo];
		semistates=new Semistate[semiNo];
		modSect=this.schools.size()%sectNo;
		modReg=this.schools.size()%regNo;
		modSemi=this.schools.size()%semiNo;
		sortIntoSectionals();
		
	}
	*/
	/**
	 * Constructor for initializing tournament
	 * This is the one that generates the tournament for the 5th semi-state option
	 * @param schools : arraylist of schools that are part of the tournament
	 * @param userSect: the number of sectionals that user wants
	 * @param userReg: the number of regionals that the user wants
	 * @throws ParseException
	 */
	public Tournament(ArrayList<School>schools,int userSect,int userReg) throws ParseException{
		this.schools=schools;
		 otherSchools=new ArrayList<School>();
		otherSchools.addAll(schools);
		this.semiNo=5;
		Scanner scan=new Scanner(System.in);
		ArrayList<School>remSchools=new ArrayList<School>();
		//For Sectionals
		//if there are more hosts than already existing, remove a host
		if(userSect<School.getSectNo()){
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
			School.sectNo=userSect;
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
				int num=schools.size();
				System.out.println("Name:" +name);
				System.out.println("Num: "+num);
				for(int k=0;k<schools.size();k++){
					String x=schools.get(k).getName();
					if(x.equals(name)){
						schools.get(k).setHostSect(true);
						System.out.println("Done");
						break;
					}
				}
			}
			School.sectNo=userSect;
		}
		this.sectNo=School.getSectNo();
		System.out.println("Sectionals: "+sectNo);
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		System.out.println("Div: "+sectDivisor);
		modSect=this.schools.size()%sectNo;
		sectionals=new Sectional[sectNo];
		sortIntoSectionals();
		
		//For Regionals
		//if the user wants less regionals than already present, give user option to remove
		if(userReg<School.getRegNo()){
			System.out.println("There are more hosts for regionals. Please select to remove");
			System.out.println("Present no. of Regional hosts: "+School.getRegNo());
			for(int i=0;i<otherSchools.size();i++){
				if(otherSchools.get(i).isHostReg()==true){
					System.out.println("Name: "+otherSchools.get(i).getName());
				}
			}
			for(int j=0;j<School.getRegNo()-userReg;j++){
				System.out.println("Enter School "+(j+1)+" to remove as host: ");
				String name=scan.nextLine();
				System.out.println("Confirm name: "+name);
				int num=otherSchools.size();
				for(int k=0;k<num;k++){
					String x=otherSchools.get(k).getName();
					if(x.equals(name)){
						otherSchools.get(k).setHostReg(false);
						System.out.println("Done Matching School");
						break;
					}
				}
			}
			School.regNo=userReg;
		}
		//if user wants more hosts than already in file, add more hosts by giving user the option
		else if(userReg>School.getRegNo()){
			System.out.println("there are less hosts. Please add more");
			System.out.println("Present no. of Regional hosts: "+School.getRegNo());
			for(int i=0;i<otherSchools.size();i++){
				if(otherSchools.get(i).isHostReg()==false){
					System.out.println("Name: "+otherSchools.get(i).getName());
				}
			}
			for(int j=0;j<userReg-School.getRegNo();j++){
				System.out.println("Enter School "+(j+1)+" to add");
				String name=scan.nextLine();
				int num=schools.size();
				for(int k=0;k<otherSchools.size();k++){
					String x=otherSchools.get(k).getName();
					if(x.equals(name)){
						otherSchools.get(k).setHostReg(false);
						System.out.println("Done matching");
						break;
					}
				}
			}
			School.regNo=userReg;
		}
		//Figure out data for getting the regionals sorted 
		this.regNo=School.getRegNo();
		System.out.println("Regionals: "+regNo);
		this.regDivisor=(int)Math.floor((double)sectionals.length/regNo);
		System.out.println("Div Reg:"+regDivisor);
		modReg=sectionals.length%regNo;
		System.out.println("Mod Reg: "+modReg);
		regionals=new Regional[regNo];
		sortIntoRegionals();
		//For semi-states
		//Since the fundamental purpose of this system is to implement the 
		//5th semi-state option, there is no user input required for this. 
		this.semiDivisor=(int)Math.floor((double)regionals.length/semiNo);
		System.out.println("Div Semi: "+semiDivisor);
		modSemi=regionals.length%5;
		System.out.println("Mod Semi: "+modSemi);
		semistates=new Semistate[semiNo];
		sortIntoSemiStates();
	}
	/**
	 * Method for sorting into sectionals. Not complete yet. 
	 * Will be figured out later. Implements different 
	 * sorting technique
	 */
	private void sortSectionals(){
		int sectionNumber=0;
		//find all the hosts
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>=sectNo)
				break;
			  if(schools.get(i).isHostSect()==true){
				School temp=schools.get(i);
				sectionals[sectionNumber]=new Sectional(temp.getName(),temp,sectDivisor);
				sectionNumber++;
				schools.remove(i);
				}
			}
		//for creating ArrayList of hosts
		ArrayList<School> hosts=new ArrayList<School>();
		ArrayList<School>tempHosts=new ArrayList<School>();
		for(int i=0;i<sectNo;i++){
			hosts.add(sectionals[i].getHostSchool());
		}
		
		//for finding nearest hosts for all schools
		System.out.println(schools.size()+"X");
		for(int i=0;i<schools.size();i++){
			School present=schools.get(i);
			School close=getClosestSchool(present,hosts);
			boolean schoolAdded=false;
			Sectional toAdd=findSectional(close);
			if(toAdd.isFull()==true){
				tempHosts.addAll(hosts);
				//tempHosts.remove(close);
				removeSchool(tempHosts,close);
				School close2=getClosestSchool(present,tempHosts);
				toAdd=findSectional(close);
				toAdd.addSchools(present);
				schoolAdded=true;
				continue;
			}
			else{
				toAdd.addSchools(present);
				schoolAdded=true;
				continue;
			}
		}
		
	}
	/**
	 * Removes school. Not used for now. DO NOT DELETE. 
	 * Might be used for the different sorting algorithm
	 * @param hosts: host list from which school has to be removed
	 * @param x: host school to be removed
	 */
	public void removeSchool(ArrayList<School>hosts,School x){
		for(int i=0;i<hosts.size();i++){
			if(hosts.get(i).getName().equals(x.getName())){
				hosts.remove(i);
				break;
			}
		}
	}
	/**
	 * Finds sectional which particular host school belongs to.
	 * DO NOT DELETE. might be required later for new algorithm
	 * @param host: host to find sectional
	 * @return: the sectional whose host was passed as parameter
	 */
	public Sectional findSectional(School host){
		Sectional ret;
		for(int j=0;j<sectNo;j++){
			if(sectionals[j].getHost().equals(host.getName())){
				return sectionals[j];
			}
		}
		return null;
	}
	/**
	 * Finds the closest host for a particular host and returns that 
	 * host school. Used for new algorithm
	 * DO NOT DELETE
	 * @param toAdd: School to be added
	 * @param hosts: List of hosts available
	 * @return: closest host to the school to be added from the list of hosts
	 */
	public School getClosestSchool(School toAdd, ArrayList<School> hosts){
		School close;
		School temp=hosts.get(0);
		long small=School.travelDist(toAdd, temp);
		School smallSchool=hosts.get(0);
		int index=0;
		for(int i=0;i<hosts.size();i++){
			if(School.travelDist(toAdd, hosts.get(i))<small){
				smallSchool=hosts.get(i);
				index=i;
			}
		}
		close=smallSchool;
		return close;
	}
	/**
	 * Method sorts the schools into respective sectionals. 
	 * Algorithm/method presently used
	 * First adds the host to the sectional and removes from list 
	 * of schools. 
	 * Then grabs the nearest x-number of schools to be added to the
	 * sectional
	 * @throws ParseException
	 */
	private void sortIntoSectionals() throws ParseException{
		int sectionNumber=0;
		//find hosts and add to respective sectional (give each host one sectional)
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>=sectNo)
				break;
			if(schools.get(i).isHostSect()==true){
				School temp=schools.get(i);
				sectionals[sectionNumber]=new Sectional(temp.getName(),temp,sectDivisor);
				sectionNumber++;
				schools.remove(i);
				}
			}
		//find schools nearest to the host and add them
		//counter and mod are used when the amount of schools is not divisible by the 
		//required number of sectionals that the user wants
			int counter=0;
		for(int j=0;j<sectNo;j++){
			if(counter<modSect){
				sectionals[j].addArraySchools(getClosest(schools,sectionals[j].getHostSchool(),sectionals[j].getSize()));
				counter++;
			}
			else{
				School temp=sectionals[j].getHostSchool();
				int tempSize=sectionals[j].getSize()-1;
				sectionals[j].addArraySchools(getClosest(schools,sectionals[j].getHostSchool(),sectionals[j].getSize()-1));
			}
		}
		System.out.println("Remaining Schools:"+schools.size());
		System.out.println("Done Sorting Sectionals");
	}
	/**
	 * Method for sorting the sectionals into regionals
	 * REMEMBER that here, we only bother about the host school
	 * The sectionals go into a regional and not a school
	 * PRESENTLY used 
	 * Uses similar idea like sorting into sectionals
	 */
	private void sortIntoRegionals(){
		int regionNumber=0;
		for(int i=0;i<otherSchools.size();i++){
			if(regionNumber>=regNo)
				break;
			if(otherSchools.get(i).isHostReg()==true){
				School temp=otherSchools.get(i);
				regionals[regionNumber]=new Regional(temp,regDivisor);
				regionNumber++;
			}
		}
		//for adding host sectional
		int counter=0;		
		for(counter=0;counter<regNo;counter++)
		for(int j=0;j<sectionals.length;j++){
			if(counter==regNo)
				break;
			School h=regionals[counter].getHost();
			if(sectionals[j].findSchool(h)){
				regionals[counter].addSectional(sectionals[j]);
				sectionals[j].setAdded(true);
				break;
			}
		}
		//for adding nearby sectional
		counter=0;
		for(int j=0;j<regNo;j++){
			if(counter<modReg){
				regionals[j].addArraySectionals(getClosestSect(sectionals,regionals[j].getHostSect(),regionals[j].getSize()));
				counter++;
			}
			else{
				Sectional temp=regionals[j].getHostSect();
				int tempS=regionals[j].getSize()-1;
				regionals[j].addArraySectionals(getClosestSect(sectionals,regionals[j].getHostSect(),regionals[j].getSize()-1));
			}
		}
	}
	/**
	 * Method to return the closest regionals
	 * @param reg: Array of regionals
	 * @param host: Host of that regional
	 * @param x: size of regional
	 * @return: Closest x regionals
	 */
	private Regional[] getClosestReg(Regional[] reg,School host, int x){
		Regional[] closest=new Regional[x];
		for(int counter=0;counter<x;counter++){
			if(reg.length==0)
				break;
			long small=School.travelDist(reg[0].getHost(),host);
			Regional smallReg=reg[0];
			int index=0;
			for(int i=0;i<reg.length;i++){
				if(reg[i].isAdded()==false)
					if(School.travelDist(host, reg[i].getHost())<small){
						smallReg=reg[i];
						index=i;
					}
			}
			closest[counter]=smallReg;
			reg[index].setAdded(true);
		}
		return closest;
	}
	/**
	 * Method to sort into semi states
	 * PRESENTLY USED
	 * Uses similar idea like sorting into regionals
	 */
	private void sortIntoSemiStates(){
		int semiNumber=0;
		for(int i=0;i<otherSchools.size();i++){
			if(semiNumber>=semiNo)
				break;
			if(otherSchools.get(i).isHostSemi()==true){
				School temp=otherSchools.get(i);
				semistates[semiNumber]=new Semistate(temp,semiDivisor);
				semiNumber++;
			}
		}
		//for adding host regional
		int counter=0;
		for(counter=0;counter<semiNo;counter++)
			for(int j=0;j<regionals.length;j++){
				if(counter==semiNo)
					break;
				School h=semistates[counter].getHostSchool();
				//if(regionals[j].getHost().getName().equals(h.getName())){
					if(regionals[j].findSchool(h)){
					semistates[counter].addRegional(regionals[j]);
					regionals[j].setAdded(true);
					break;
				}
			}
		//for adding nearby regional
		counter=0;
		for(int j=0;j<semiNo;j++){
			if(counter<modSemi){
				semistates[j].addArrayRegionals(getClosestReg(regionals,semistates[j].getHostSchool(),semistates[j].getSize()));
				counter++;
			}
			else{
				School temp=semistates[j].getHostSchool();
				int tempS=semistates[j].getSize()-1;
				semistates[j].addArrayRegionals(getClosestReg(regionals,temp,tempS));
			}
		}
	}
	/**
	 * Method returns the closest sectional to a host
	 * Used by sortIntoRegionals()
	 * PRESENTLY USED
	 * @param sect: array of sectionals
	 * @param host: host sectional
	 * @param x: size of host sectional
	 * @return: closest sectionals to a given host
	 */
	private Sectional[] getClosestSect(Sectional[] sect,Sectional host,int x){
		Sectional[] closest=new Sectional[x];
		
		for(int counter=0;counter<x;counter++){
			if(sect.length==0)
				break;
			long small=School.travelDist(sect[0].getHostSchool(), host.getHostSchool());
			Sectional smallSect=sect[0];
			int index=0;
			for(int i=0;i<sect.length;i++){
				if(sect[i].isAdded()==false)
					if(School.travelDist(host.getHostSchool(), sect[i].getHostSchool())<small){
						smallSect=sect[i];
						index=i;
					}
			}
			closest[counter]=smallSect;
			sect[index].setAdded(true);
		}
		
		return closest;
	}
	/**
	 * Method returns the closest schools to a host. 
	 * Used by sortIntoSectionals() method
	 * Presently used algorithm
	 */
	private School[] getClosest(ArrayList<School> schools, School host,int x) throws ParseException{
		
		School []closest=new School[x];
		for(int counter=0;counter<x;counter++){
			if(schools.size()==0)
				break;
			School temp=schools.get(0);
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
		return closest;
	}
	public String toString(){
		String x="";
		for(int i=0;i<this.sectNo;i++)
			x+=sectionals[i].toString();
		x=x+"\n"+"Regionals\n";
		//return x;*/
		for(int i=0;i<this.regNo;i++)
			x+=regionals[i].toString();
		x=x+"\n"+"Semi States\n";
		for(int i=0;i<this.semiNo;i++)
			x+=semistates[i].toString();
		return x;
	}
}
