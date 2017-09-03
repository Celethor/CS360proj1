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
		this.otherSchools=new ArrayList<School>();
		this.otherSchools.addAll(this.schools);
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
		//sortIntoSectionals();
		sortSectionals();
		this.regDivisor=(int) Math.floor((double)this.sectNo/regNo);
		this.modReg=sectNo/regNo;
		System.out.println("Regional Divisor : "+regDivisor+"\nRegional Mod : "+modReg);
		regionals=new ArrayList<Regional>();
		//sortIntoRegionals();
		//ArrayList<School>x=sectionals.get(2).getSchools();
		/*for(int i=0;i<x.size();i++){
			System.out.println(x.get(i).toString());
		}*/
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
		System.out.println("School size: "+schools.size());
		//find the hosts and give each a sectional
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>sectNo)
				break;
			if(schools.get(i).isHostSect()==true){
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
			
			for(int i=0;i<sectionals.size();i++){
				System.out.println("No. : "+i+"\n"+sectionals.get(i).toString());
			}
			int counter=0;
			for(counter=0;counter<regNo;counter++){
				for(int j=0;j<sectionals.size();j++){
					//if(counter==regNo)
						//break;
					School h=regionals.get(counter).getHost();
					Sectional t=sectionals.get(j);
					ArrayList<School> s=t.getSchools();
					if(t.findSchool(h)){
						regionals.get(counter).addSectional(sectionals.get(j));
						sectionals.get(j).setAdded(true);
						break;
					}
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
		System.out.println("Done sorting regionals");
	}
	
	public void sortSectionals(){
		int sectionNumber=0;
		int indexOfHosts[]=new int[sectNo];
		System.out.println("School size: "+schools.size());
		//find the hosts and give each a sectional
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>sectNo)
				break;
			if(schools.get(i).isHostSect()==true){
				sectionals.add(new Sectional(schools.get(i).getName(),schools.get(i),sectDivisor));
				indexOfHosts[sectionNumber]=i;
				sectionNumber++;
				//schools.remove(i);//do not remove schools as it is giving error
			}
		}
		//First make an arraylist of all hosts of school type
		ArrayList<School> hosts=new ArrayList<School>();
		for(int i=0;i<sectionals.size();i++){
			hosts.add(sectionals.get(i).getHostSchool());
		}
		//go through all schools and find nearest host 
		for(int i=0;i<schools.size();i++){
			School closeHost=getClosestSchool(schools.get(i),hosts);
			//to avoid adding iteself/duplication because host has already been added
			if(closeHost.getName().equals(schools.get(i).getName())){
				continue;
			}
			else{
				Sectional closestSect=findSectional(closeHost);
				boolean added=addInSectional(closestSect,schools.get(i));
				if(added==false){
				System.out.println("cannot add in sectional. You will now get null pointer exception");
				throw new NullPointerException();
				}
			}
		}
		System.out.println("Done getting closest hosts");
		//System.out.println(this.toString());
		int maxSize=sectDivisor+2;
		int minSize=sectDivisor;
		//Run a loop for each sectional
		for(int i=0;i<sectionals.size();i++){
			ArrayList<School>tempHosts=new ArrayList<School>();
			tempHosts.addAll(hosts);
			//tempHosts=findOtherHosts(tempHosts,sectionals.get(i));//so that it does not find itself later
			while(sectionals.get(i).getActualSize()<minSize){
				School cHost=null;
				School cSchool=null;
				School []hostsOrd=ordered(sectionals.get(i).getHostSchool(),tempHosts);
				for(School host:hostsOrd){
					Sectional sec=findSectional(host);
					ArrayList<School> list=sec.getSchools();
					//if underfilled don't consider
					if(list.size()<minSize){
						continue;
					}
					School []ordSchools=ordered(sectionals.get(i).getHostSchool(),list);
					School closest;
					if(ordSchools[0].getName().equals(sectionals.get(i).getHost())){
						closest=ordSchools[1];
					}
					else{
						closest=ordSchools[0];
					}
					if(cHost==null||School.travelDist(sectionals.get(i).getHostSchool(),closest)<School.travelDist(sectionals.get(i).getHostSchool(),cSchool)){
						cHost=host;
						cSchool=closest;
					}
				}
				Sectional x=findSectional(cHost);
				sectionals.get(i).addSchools(cSchool);
				for(int y=0;y<sectionals.size();y++){
					if(x.getHost().equals(sectionals.get(y).getHost())){
						Sectional t=sectionals.get(y);
						boolean b=t.removeSchool(cSchool);
						if(b==false){
							System.out.println("Could not remove School. Null pointer error will appear");
							throw new NullPointerException();
						}
					}
				}
			}
			
		}
		for(int i=0;i<sectionals.size();i++){
			ArrayList<School>tempHosts=new ArrayList<School>();
			tempHosts.addAll(hosts);
			if(sectionals.get(i).getActualSize()>maxSize){
				while(sectionals.get(i).getActualSize()>maxSize){
					School cHost=null;
					School cSchool;
					School []ordSchools=ordered(sectionals.get(i).getHostSchool(),sectionals.get(i).getSchools());
					cSchool=ordSchools[ordSchools.length-1];//because this is the farthest one
					School []hostsOrd=ordered(cSchool,tempHosts);
					for(School host:hostsOrd){
						Sectional sec=findSectional(host);
						if(sec.getActualSize()>=maxSize){
							continue;
						}
						Sectional s=findSectional(host);
						s.addSchools(cSchool);
						int x=sectionals.get(i).getActualSize();
						sectionals.get(i).removeSchool(cSchool);
						sectionals.get(i).setActualSize(x-1);
						break;
					}
				}
			}
		}
		System.out.println(this.toString());
	}
	public ArrayList<School> getArrayList(School[] x){
		ArrayList<School>ret=new ArrayList<School>();
		for(int i=0;i<x.length;i++){
			ret.add(x[i]);
		}
		return ret;
	}
	public School[] ordered(School present, ArrayList<School>tempHosts){
		School[] ret=new School[tempHosts.size()];
		for(int i=0;i<tempHosts.size();i++){
			ret[i]=tempHosts.get(i);
		}
		//long small=School.travelDist(present, tempHosts.get(0));
		//School smallSchool=tempHosts.get(0);
		int index=0;
		for(int i=0;i<ret.length-1;i++){
			index=i;
			for(int j=i+1;j<ret.length;j++){
				if(School.travelDist(present, ret[j])<School.travelDist(present, ret[index])){
					index=j;
				}
			}
			School smaller=ret[index];
			ret[index]=ret[i];
			ret[i]=smaller;
		}
		return ret;
	}
	public ArrayList<School> findOtherHosts(ArrayList<School>hosts,Sectional x){
		for(int i=0;i<hosts.size();i++){
			if(x.getHost().equals(hosts.get(i).getName())){
				hosts.remove(i);
				return hosts;
			}
		}
		return hosts;
	}
	public boolean addInSectional(Sectional x, School toAdd){
		for(int i=0;i<sectionals.size();i++){
			if(sectionals.get(i).getHost().equals(x.getHost())){
				sectionals.get(i).addSchools(toAdd);
				return true;
			}
		}
		return false;
	}
	public School getClosestSchool(School toAdd, ArrayList<School> hosts){
		School closestHost;
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
		closestHost=smallSchool;
		return closestHost;
	}
	public Sectional findSectional(School host){
		Sectional ret;
		for(int j=0;j<sectNo;j++){
			if(sectionals.get(j).getHost().equals(host.getName())){
				return sectionals.get(j);
			}
		}
		return null;
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
		//School []closest=new School[x];
		ArrayList<School>closest=new ArrayList<School>();
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
			//closest[counter]=smallSchool;
			closest.add(smallSchool);
			schools.remove(index);
		}
		}
		School ret[]=new School[closest.size()];
		for(int i=0;i<ret.length;i++){
			ret[i]=closest.get(i);
		}
		return ret;
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
		//return sectionals.get(4).toString();
	}
}
