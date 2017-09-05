package proj1.cs360;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Classify {
	public char className;
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
	int semiDivisor;
	int modSemi;
	ArrayList<School> otherSchools;
	public Classify(){
		this.schools=null;
		this.maxEnrollment=0;
		this.className=' ';
		this.sectNo=0;
		this.regNo=0;
		this.semiNo=0;
	}
	public Classify(char className, ArrayList<School> sch, int maxEnrollment, int sectNo, int regNo, int semiNo){
		this.className=className;
		
		this.maxEnrollment=maxEnrollment;
		int userSect=sectNo;
		int userReg=regNo;
		int userSemi=semiNo;
		this.schools=new ArrayList<School>();
		for(int i=0;i<sch.size();i++){
			if(sch.get(i).classified==false)
			if(sch.get(i).getEnrollment()<this.maxEnrollment){
				this.schools.add(sch.get(i));
				sch.get(i).classified=true;
			}
		}
		Scanner scan=new Scanner(System.in);
		int presentSect=0;
		for(int i=0;i<this.schools.size();i++){
			if(this.schools.get(i).isHostSect()==true){
				presentSect++;
			}
		}
		
		if(userSect==presentSect)
			this.sectNo=presentSect;
		else{
			if(userSect<presentSect){
				
				//System.out.println("There are more hosts than specified for Sectionals. Please go through"
					//	+ "the list of hosts and type in which ones to remove");
				//System.out.println("Present no. of hosts for sectionals: "+School.sectNo);
				JOptionPane.showMessageDialog(null, "There are more hosts than specified for Sectionals.\n Please go through"
						+ "the list of hosts and type in which ones to remove");
				ArrayList<School>tempSchools=new ArrayList<School>();
				for(int i=0;i<schools.size();i++)
					if(schools.get(i).isHostSect()==true){
						//System.out.println("Name: "+schools.get(i).getName());
						tempSchools.add(schools.get(i));
					}
				//SchoolDisplayGUI disp=new SchoolDisplayGUI(tempSchools);
				for(int j=0;j<presentSect-userSect;j++){
					DefaultComboBoxModel m=new DefaultComboBoxModel();
					for(int k=0;k<tempSchools.size();k++){
						m.addElement(tempSchools.get(k));
					}
					
					JComboBox cb=new JComboBox(m);
					int input=JOptionPane.showConfirmDialog(null,cb,"Enter school to remove",JOptionPane.OK_CANCEL_OPTION);
					String name="";
					if(input==JOptionPane.OK_OPTION){
						School x=(School)cb.getSelectedItem();
					    name=x.getName();
						//System.out.println(name);
					}
					
					/*System.out.println("Enter School "+(j+1)+" to remove: ");
					String name=scan.nextLine();
					System.out.println(name);*/
					
					int num=schools.size();
					for(int k=0;k<num;k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSect(false);
							//System.out.println("Done matching School");
							break;
						}
					}
					
				}
				this.sectNo=userSect;
			}
			//if the user wants more hosts but there are not many in the file already, add more
			else if(userSect>presentSect){
				//System.out.println("There are less hosts than specified for Sectionals. Please go through"
					//	+ "the list of schools and type in which ones to add");
				JOptionPane.showMessageDialog(null, "There are less hosts than specified for Sectionals.\n Please go through"
						+ "the list of schools and type in which ones to add");
				ArrayList<School>tempSchools=new ArrayList<School>();
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSect()==false){
						//System.out.println("Name: "+schools.get(i).getName());
						tempSchools.add(schools.get(i));
					}
				}
				for(int j=0;j<userSect-presentSect;j++){
					DefaultComboBoxModel m=new DefaultComboBoxModel();
					for(int k=0;k<tempSchools.size();k++){
						m.addElement(tempSchools.get(k));
					}
					
					JComboBox cb=new JComboBox(m);
					int input=JOptionPane.showConfirmDialog(null,cb,"Enter school to add",JOptionPane.OK_CANCEL_OPTION);
					String name="";
					if(input==JOptionPane.OK_OPTION){
						School x=(School)cb.getSelectedItem();
					    name=x.getName();
						//System.out.println(name);
					}
					//System.out.println("Enter School "+(j+1)+" to add as Host: ");
					//String name=scan.nextLine();
					for(int k=0;k<schools.size();k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSect(true);
							//System.out.println("Done");
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
		
		if(userReg==presentReg)
			this.regNo=presentReg;
		else{
			//For Regionals
			//if the user wants less regionals than already present, give user option to remove
			if(userReg<presentReg){
				//System.out.println("There are more hosts for regionals. Please select to remove");
				//System.out.println("Present no. of Regional hosts: "+School.getRegNo());
				JOptionPane.showMessageDialog(null, "There are more hosts than specified for Regionals.\n Please go through"
						+ "the list of schools and type in which ones to remove");
				ArrayList<School>tempSchools=new ArrayList<School>();
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostReg()==true){
						//System.out.println("Name: "+schools.get(i).getName());
						tempSchools.add(schools.get(i));
					}
				}
				for(int j=0;j<presentReg-userReg;j++){
					//System.out.println("Enter School "+(j+1)+" to remove as host: ");
					//String name=scan.nextLine();
					DefaultComboBoxModel m=new DefaultComboBoxModel();
					for(int k=0;k<tempSchools.size();k++){
						m.addElement(tempSchools.get(k));
					}
					
					JComboBox cb=new JComboBox(m);
					int input=JOptionPane.showConfirmDialog(null,cb,"Enter school to remove",JOptionPane.OK_CANCEL_OPTION);
					String name="";
					if(input==JOptionPane.OK_OPTION){
						School x=(School)cb.getSelectedItem();
					    name=x.getName();
					}
					int num=schools.size();
					for(int k=0;k<num;k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostReg(false);
							//System.out.println("Done Matching School");
							break;
						}
					}
				}
				this.regNo=userReg;
			}
			//if user wants more hosts than already in file, add more hosts by giving user the option
			else if(userReg>presentReg){
				//System.out.println("there are less hosts. Please add more");
				//System.out.println("Present no. of Regional hosts: "+School.getRegNo());
				JOptionPane.showMessageDialog(null, "There are less hosts than specified for Regionals.\n Please go through"
						+ "the list of schools and type in which ones to add");
				ArrayList<School>tempSchools=new ArrayList<School>();
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostReg()==false){
						//System.out.println("Name: "+schools.get(i).getName());
						tempSchools.add(schools.get(i));
					}
				}
				for(int j=0;j<userReg-presentReg;j++){
					//System.out.println("Enter School "+(j+1)+" to add");
					//String name=scan.nextLine();
					DefaultComboBoxModel m=new DefaultComboBoxModel();
					for(int k=0;k<tempSchools.size();k++){
						m.addElement(tempSchools.get(k));
					}
					
					JComboBox cb=new JComboBox(m);
					int input=JOptionPane.showConfirmDialog(null,cb,"Enter school to add",JOptionPane.OK_CANCEL_OPTION);
					String name="";
					if(input==JOptionPane.OK_OPTION){
						School x=(School)cb.getSelectedItem();
					    name=x.getName();
					}
					int num=schools.size();
					for(int k=0;k<schools.size();k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostReg(true);
							//System.out.println("Done matching");
							break;
						}
					}
				}
				this.regNo=userReg;
			}
		}
		int presentSemi=0;
		for(int i=0;i<schools.size();i++){
			if(schools.get(i).isHostSemi()==true)
				presentSemi++;
		}
		
		
		if(userSemi==presentSemi)
			this.semiNo=userSemi;
		else{
			//For Regionals
			//if the user wants less regionals than already present, give user option to remove
			if(userSemi<presentSemi){
				//System.out.println("There are more hosts for Semi-States. Please select to remove");
				//System.out.println("Present no. of Semistate hosts: "+presentSemi);
				JOptionPane.showMessageDialog(null, "There are more hosts than specified for Semi-State.\n Please go through"
						+ "the list of schools and type in which ones to remove");
				ArrayList<School>tempSchools=new ArrayList<School>();
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSemi()==true){
						//System.out.println("Name: "+schools.get(i).getName());
						tempSchools.add(schools.get(i));
					}
				}
				for(int j=0;j<presentSemi-userSemi;j++){
					DefaultComboBoxModel m=new DefaultComboBoxModel();
					for(int k=0;k<tempSchools.size();k++){
						m.addElement(tempSchools.get(k));
					}
					
					JComboBox cb=new JComboBox(m);
					int input=JOptionPane.showConfirmDialog(null,cb,"Enter school to remove",JOptionPane.OK_CANCEL_OPTION);
					String name="";
					if(input==JOptionPane.OK_OPTION){
						School x=(School)cb.getSelectedItem();
					    name=x.getName();
					}
					//System.out.println("Enter School "+(j+1)+" to remove as host: ");
					//String name=scan.nextLine();
					int num=schools.size();
					for(int k=0;k<num;k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSemi(false);
							//System.out.println("Done Matching School");
							break;
						}
					}
				}
				this.semiNo=userSemi;
			}
			//if user wants more hosts than already in file, add more hosts by giving user the option
			else if(userSemi>presentSemi){
				//System.out.println("there are less hosts. Please add more");
				//System.out.println("Present no. of Semistate hosts: "+presentSemi);
				JOptionPane.showMessageDialog(null, "There are less hosts than specified for Semi-State.\n Please go through"
						+ "the list of schools and type in which ones to add");
				ArrayList<School>tempSchools=new ArrayList<School>();
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSemi()==false){
						//System.out.println("Name: "+schools.get(i).getName());
						tempSchools.add(schools.get(i));
					}
				}
				
				for(int j=0;j<userSemi-presentSemi;j++){
					//System.out.println("Enter School "+(j+1)+" to add : ");
					//String name=scan.nextLine();
					DefaultComboBoxModel m=new DefaultComboBoxModel();
					for(int k=0;k<tempSchools.size();k++){
						m.addElement(tempSchools.get(k));
					
					}
					
					JComboBox cb=new JComboBox(m);
					int input=JOptionPane.showConfirmDialog(null,cb,"Enter school to add",JOptionPane.OK_CANCEL_OPTION);
					String name="";
					if(input==JOptionPane.OK_OPTION){
						School x=(School)cb.getSelectedItem();
					    name=x.getName();
					}
					//System.out.println("Name: "+name);
					int num=schools.size();
					for(int k=0;k<schools.size();k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSemi(true);
							//System.out.println("Done matching");
							break;
						}
					}
				}
				this.semiNo=userSemi;
			}
		}
		
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		this.modSect=schools.size()%sectNo;
		//System.out.println("Sectional Divisor : "+sectDivisor+"\nSectional Mod : "+modSect);
		sectionals=new ArrayList<Sectional>();
		
		sortSectionals();
		this.regDivisor=(int) Math.floor((double)this.sectNo/regNo);
		this.modReg=sectNo%regNo;
		//System.out.println("Regional Divisor : "+regDivisor+"\nRegional Mod : "+modReg);
		regionals=new ArrayList<Regional>();
		
		sortRegionals();
		this.semiDivisor=(int)Math.floor((double)this.regNo/semiNo);
		this.modSemi=regNo%semiNo;
		semistates=new ArrayList<Semistate>();
		//System.out.println("Semi Divisor: "+semiDivisor+"\nSemi mod: "+modSemi);
		sortSemi();
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
	public Classify( ArrayList<School> sch) throws ParseException{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("You are creating a new class. Please enter the name as single character : ");
		this.className=scan.nextLine().charAt(0);
		System.out.println("Enter the maximum enrollement : ");
		this.maxEnrollment=scan.nextInt();
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
		
		
		int presentSect=0;
		for(int i=0;i<this.schools.size();i++){
			if(this.schools.get(i).isHostSect()==true){
				presentSect++;
			}
		}
		System.out.println("Present Sectionals in class "+this.className+" : "+presentSect);
		System.out.println("Enter the no. of sectionals you want: ");
		int userSect=scan.nextInt();
		scan.nextLine();
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
				for(int j=0;j<presentSect-userSect;j++){
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
			else if(userSect>presentSect){
				System.out.println("There are less hosts than specified for Sectionals. Please go through"
						+ "the list of schools and type in which ones to add");
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSect()==false){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				for(int j=0;j<userSect-presentSect;j++){
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
				for(int j=0;j<presentReg-userReg;j++){
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
			else if(userReg>presentReg){
				System.out.println("there are less hosts. Please add more");
				System.out.println("Present no. of Regional hosts: "+School.getRegNo());
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostReg()==false){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				for(int j=0;j<userReg-presentReg;j++){
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
		int presentSemi=0;
		for(int i=0;i<schools.size();i++){
			if(schools.get(i).isHostSemi()==true)
				presentSemi++;
		}
		System.out.println("Present no. of semi-states : "+presentSemi);
		System.out.println("Enter the no. of semi-states you want : ");
		int userSemi=scan.nextInt();
		scan.nextLine();
		System.out.println("Okay");
		if(userSemi==presentSemi)
			semiNo=userSemi;
		else{
			//For Regionals
			//if the user wants less regionals than already present, give user option to remove
			if(userSemi<presentSemi){
				System.out.println("There are more hosts for Semi-States. Please select to remove");
				System.out.println("Present no. of Semistate hosts: "+presentSemi);
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSemi()==true){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				for(int j=0;j<presentSemi-userSemi;j++){
					System.out.println("Enter School "+(j+1)+" to remove as host: ");
					String name=scan.nextLine();
					int num=schools.size();
					for(int k=0;k<num;k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSemi(false);
							System.out.println("Done Matching School");
							break;
						}
					}
				}
				this.semiNo=userSemi;
			}
			//if user wants more hosts than already in file, add more hosts by giving user the option
			else if(userSemi>presentSemi){
				System.out.println("there are less hosts. Please add more");
				System.out.println("Present no. of Semistate hosts: "+presentSemi);
				for(int i=0;i<schools.size();i++){
					if(schools.get(i).isHostSemi()==false){
						System.out.println("Name: "+schools.get(i).getName());
					}
				}
				
				for(int j=0;j<userSemi-presentSemi;j++){
					System.out.println("Enter School "+(j+1)+" to add : ");
					
					String name=scan.nextLine();
					System.out.println("Name: "+name);
					int num=schools.size();
					for(int k=0;k<schools.size();k++){
						String x=schools.get(k).getName();
						if(x.equals(name)){
							schools.get(k).setHostSemi(true);
							System.out.println("Done matching");
							break;
						}
					}
				}
				this.semiNo=userSemi;
			}
		}
		
		this.sectDivisor=(int) Math.floor((double)this.schools.size()/sectNo);
		this.modSect=schools.size()%sectNo;
		System.out.println("Sectional Divisor : "+sectDivisor+"\nSectional Mod : "+modSect);
		sectionals=new ArrayList<Sectional>();
		
		sortSectionals();
		this.regDivisor=(int) Math.floor((double)this.sectNo/regNo);
		this.modReg=sectNo%regNo;
		System.out.println("Regional Divisor : "+regDivisor+"\nRegional Mod : "+modReg);
		regionals=new ArrayList<Regional>();
		
		sortRegionals();
		this.semiDivisor=(int)Math.floor((double)this.regNo/semiNo);
		this.modSemi=regNo%semiNo;
		semistates=new ArrayList<Semistate>();
		System.out.println("Semi Divisor: "+semiDivisor+"\nSemi mod: "+modSemi);
		sortSemi();
	}
	/**
	 * Methods finds the closest regional host to the particular sectional
	 * @param toAdd: sectional to find the closest regional for
	 * @return: the closest sectional
	 */
	public School findClosestRegHost(Sectional toAdd){
		School closest=null;
		long small=School.travelDist(toAdd.getHostSchool(), regionals.get(0).getHost());
		School smallSchool=regionals.get(0).getHost();
		for(int i=0;i<regionals.size();i++){
			if(School.travelDist(toAdd.getHostSchool(), regionals.get(i).getHost())<small){
				small=School.travelDist(toAdd.getHostSchool(), regionals.get(i).getHost());
				smallSchool=regionals.get(i).getHost();
			}
		}
		closest=smallSchool;
		return closest;
	}
	/**
	 * Method orders the regionals by closest distance to the regional given in parameter	 * 
	 * @param x: Regional to which closest other regionals are to be found
	 * @param reg: the list of regionals for ordering by distance
	 * @return: the array of regionals ordered by distance
	 */
	public Regional []orderedRegionals(Regional x, ArrayList<Regional> reg){
		Regional []arr=new Regional[reg.size()];
		for(int i=0;i<reg.size();i++){
			arr[i]=reg.get(i);
		}
		int index;
		for(int i=0;i<arr.length-1;i++){
			index=i;
			for(int j=i+1;j<arr.length;j++){
				if(School.travelDist(x.getHost(), arr[j].getHost())<School.travelDist(x.getHost(), arr[j].getHost())){
					index=j;
				}
			}
			Regional smaller=arr[index];
			arr[index]=arr[i];
			arr[i]=smaller;
		}
		return arr;
	}
	/**
	 * Method returns the semistates ordered by distance to particular semistate
	 * @param x: the semistate to which we need the others to be sorted
	 * @param semis: the list of semistates for ordering by distance
	 * @return: the array of semistates ordered by distance
	 */
	public Semistate[] orderedSemis(Semistate x,ArrayList<Semistate>semis){
		Semistate[] ret=new Semistate[semis.size()];
		for(int i=0;i<semis.size();i++){
			ret[i]=semis.get(i);
		}
		int index;
		for(int i=0;i<ret.length-1;i++){
			index=i;
			for(int j=i+1;j<ret.length;j++){
				if(School.travelDist(x.getHostSchool(), ret[j].getHostSchool())<School.travelDist(x.getHostSchool(), ret[index].getHostSchool())){
					index=j;
				}
			}
			Semistate smaller=ret[index];
			ret[index]=ret[i];
			ret[i]=smaller;
		}
		return ret;
	}
	/**
	 * Method used for sorting the regionals into semi-states. 
	 * Procedure: 
	 * First find the hosts and give each host a semi-state 
	 * Add each of the regionals to its closest host semi-state
	 * Re-position the regionals in semi-states if they are not equal/almost equal
	 */
	public void sortSemi(){
		int semiNumber=0;
		//find hosts for semistates and give each host a particular semistate
		for(int i=0;i<schools.size();i++){
			if(semiNumber>semiNo)
				break;
			if(schools.get(i).isHostSemi()){
				semistates.add(new Semistate(schools.get(i),semiDivisor));
				semiNumber++;
			}
		}
		//find closest semi-state for each regional and add
		for(int i=0;i<regionals.size();i++){
			School hostforSemi=findClosestSemiHost(regionals.get(i));
			Semistate s=findSemistateWithSchool(hostforSemi);
			
			s.addRegional(regionals.get(i));
			regionals.get(i).setAdded(true);
		}
		//reposition according to the size of the semi-states
		int minSize=semiDivisor;
		int maxSize;
		if(modSect==0)
			maxSize=semiDivisor;
		else
			maxSize=semiDivisor+1;
		for(int i=0;i<semistates.size();i++){
			//if size is less than the minimum required size
			while(semistates.get(i).getActualSize()<minSize){
				Regional cRegional=null;
				Semistate cHost=null;
				Semistate []ordered=orderedSemis(semistates.get(i),semistates);
				for(Semistate semi:ordered){
					if(semi.getActualSize()<minSize){
						continue;
					}
					Regional []reg=orderedRegionals(semistates.get(i).getHostSchool(),semi.getRegionals());
					Regional closest;
					if(reg[0].getHost().getName().equals(semi.getHost())){
						closest=reg[1];
					}
					else{
						closest=reg[0];
					}
					if(cHost==null||School.travelDist(semistates.get(i).getHostSchool(), closest.getHost())<
							School.travelDist(semistates.get(i).getHostSchool(), cHost.getHostSchool())){
						cHost=semi;
						cRegional=closest;
					}
				}
				boolean b=cHost.removeRegional(cRegional);
				semistates.get(i).addRegional(cRegional);
				if(b==false){
					System.out.println("Failed to remove regional for semis. Null pointer exception will appear");
					throw new NullPointerException();
				}
			}
		}
		
		//if size is greater than the maximum size as decided by the program
		for(int i=0;i<semistates.size();i++){
			if(semistates.get(i).getActualSize()>maxSize)
			while(semistates.get(i).getActualSize()>maxSize){
				Regional cRegional=null;
				Semistate cHost=null;
				Semistate []ordered=orderedSemis(semistates.get(i),semistates);
				Regional []ordReg=orderedRegionals(semistates.get(i).getHostSchool(),semistates.get(i).getRegionals());
				cRegional=ordReg[ordReg.length-1];
				for(Semistate semi:ordered){
					if(semi.getActualSize()>=maxSize){
						 continue;
					}
					semistates.get(i).removeRegional(cRegional);
					semi.addRegional(cRegional);
					break;
				}
				
			}
		}
		
	}
	/**
	 * Method orders the list of regionals based on closest distance 
	 * to a particular regional 
	 * @param x: The regional that serves as base 
	 * @param reg: the list of regionals for sorting by closest distance to the base
	 * @return: the array of regionals sorted by closest distance
	 */
	public Regional[] orderedRegionals(School x, ArrayList<Regional> reg){
		//copy the entire list to array
		Regional[] ret=new Regional[reg.size()];
		for(int i=0;i<reg.size();i++){
			ret[i]=reg.get(i);
		}
		//implement selection sort algorithm
		int index;
		for(int i=0;i<ret.length-1;i++){
			index=i;
			for(int j=i+1;j<ret.length;j++){
				if(School.travelDist(x, ret[j].getHost())<School.travelDist(x, ret[index].getHost())){
					index=j;
				}
			}
			Regional smaller=ret[index];
			ret[index]=ret[i];
			ret[i]=smaller;
		}
		return ret;
	}
	/**
	 * Method finds the semi-state based on host school 
	 * passed as parameter
	 * @param x: the host school 
	 * @return: the semi-state after matching host school. Returns null if not found
	 */
	public Semistate findSemistateWithSchool(School x){
		for(int i=0;i<semistates.size();i++){
			if(semistates.get(i).getHost().equals(x.getName())){
				return semistates.get(i);
			}
		}
		return null;
	}
	/**
	 * Method finds the closest semi-state host to a given regional
	 * @param toAdd: the base regional to find closest host
	 * @return: the closest semi-state host school to the given regional
	 */
	public School findClosestSemiHost(Regional toAdd){
		School closest;
		long small=School.travelDist(toAdd.getHost(), semistates.get(0).getHostSchool());
		School smallSchool=semistates.get(0).getHostSchool();
		for(int i=0;i<semistates.size();i++){
			if(School.travelDist(toAdd.getHost(), semistates.get(i).getHostSchool())<small){
				small=School.travelDist(toAdd.getHost(), semistates.get(i).getHostSchool());
				smallSchool=semistates.get(i).getHostSchool();
			}
		}
		closest=smallSchool;
		return closest;
	}
	/**
	 * Method sorts the sectionals into regionals. 
	 * Procedure: 
	 * First look for hosts and give each a regional.
	 * Go through all the sectionals and find closest regional host
	 * add regional to the closest host
	 * Reposition sectionals based on size(if greater or less in size)
	 */
	public void sortRegionals(){
		//find hosts and give each a regional
		int regionNumber=0;
		for(int i=0;i<schools.size();i++){
			if(regionNumber>regNo)
				break;
			if(schools.get(i).isHostReg()){
				regionals.add(new Regional(schools.get(i),regDivisor));
				regionNumber++;
			}
		}
		ArrayList<Sectional>hostSects=new ArrayList<Sectional>();
		//find closest regional for each sectional
		//add sectional to closest regional
		for(int i=0;i<sectionals.size();i++){
			School hostforReg=findClosestRegHost(sectionals.get(i));
			Regional r=findRegionalWithSchool(hostforReg);
			r.addSectional(sectionals.get(i));
			sectionals.get(i).setAdded(true);
		}
		//reposition the sectionals between regionals based on size
		int minSize=regDivisor;
		int maxSize=regDivisor+1;
		//now make all of them almost equal participation
		for(int i=0;i<regionals.size();i++){
			while(regionals.get(i).getActualSize()<minSize){
				Sectional cSectional=null;
				Regional cHost=null;
				Regional []ordered=orderedRegionals(regionals.get(i),regionals);
				for(Regional reg:ordered){
					if(reg.getActualSize()<minSize){
						continue;
					}
					Sectional sect[]=orderedSectionals(regionals.get(i).getHost(),reg.getSectionals());
					Sectional closest;
					closest=sect[0];
					if(cHost==null||School.travelDist(regionals.get(i).getHost(), closest.getHostSchool())<
							School.travelDist(regionals.get(i).getHost(), cHost.getHost())){
						cHost=reg;
						cSectional=closest;
					}
				}
				boolean b=cHost.removeSectional(cSectional);
				regionals.get(i).addSectional(cSectional);
				if(b==false){
					System.out.println("Could not remove sectional from original host. Null pointer will appear");
					throw new NullPointerException();
				}
			}
		}
		
		
	}
	/**
	 * Method orders the sectionals based on closest distance to given school
	 * @param x: school that serves as base
	 * @param hosts: the list of sectionals to be sorted by closest distance to base
	 * @return: the array of schools sorted by closest distance to base
	 */
	public Sectional[] orderedSectionals(School x,ArrayList<Sectional>hosts){
		Sectional[] ret=new Sectional[hosts.size()];
		//add list to array for sorting
		for(int i=0;i<hosts.size();i++){
			ret[i]=hosts.get(i);
			
		}
		//implement selection sort algorithm
		int index=0;
		for(int i=0;i<ret.length-1;i++){
			index=i;
			for(int j=i+1;j<ret.length;j++){
				if(School.travelDist(x, ret[j].getHostSchool())<School.travelDist(x, ret[index].getHostSchool())){
					index=j;
				}
			}
			Sectional smaller=ret[index];
			ret[index]=ret[i];
			ret[i]=smaller;
		}
		return ret;
	}
	/**
	 * Method gives the ordered sectionals based on closest distance to base sectional
	 * @param x: sectional to serve as base
	 * @param hosts: list of sectionals to be sorted by closest distance
	 * @return: the array of sectionals sorted by closest distance
	 */
	public Sectional[] orderedSectionals(Sectional x,ArrayList<Sectional>hosts){
		Sectional[] ret=new Sectional[hosts.size()];
		for(int i=0;i<hosts.size();i++){
			ret[i]=hosts.get(i);
			
		}
		//implement selection sort algorithm
		int index=0;
		for(int i=0;i<ret.length-1;i++){
			index=i;
			for(int j=i+1;j<ret.length;j++){
				if(School.travelDist(x.getHostSchool(), ret[j].getHostSchool())<School.travelDist(x.getHostSchool(), ret[index].getHostSchool())){
					index=j;
				}
			}
			Sectional smaller=ret[index];
			ret[index]=ret[i];
			ret[i]=smaller;
		}
		
		return ret;
	}
	/**
	 * Method finds the regional for particular sectional
	 * @param x: The sectional for which regional needs to be found
	 * @return: the regional which contains the particular sectional. Returns null if not found
	 */
	public Regional findRegional(Sectional x){
		for(int i=0;i<regionals.size();i++){
			if(regionals.get(i).getHostSect().getHost().equals(x.getHost()))
				return regionals.get(i);
		}
		return null;
	}
	/**
	 * Method finds the regional using school and compares for host
	 * @param x: School that might be host for a regional
	 * @return: Regional whose host school is passed as parameter. If not found, returns null
	 */
	public Regional findRegionalWithSchool(School x){
		for(int i=0;i<regionals.size();i++){
			if(regionals.get(i).getHost().getName().equals(x.getName()))
				return regionals.get(i);
		}
		return null;
	}
	/**
	 * Method finds the regional for the particular sectional
	 * @param obj: The class object whose data to be used. 
	 * @param x: The sectional whose regional needs to be found
	 * @return: The regional that contains particular sectional. If not found, returns null
	 */
	public static Regional findRegionalForSectional(Classify obj,Sectional x){
		for(int i=0;i<obj.regionals.size();i++){
			ArrayList<Sectional> temp=obj.regionals.get(i).getSectionals();
			for(int j=0;j<temp.size();j++){
				if(temp.get(j).getHost().equals(x.getHost())){
					return obj.regionals.get(i);
				}
			}
		}
		return null;
	}
	/**
	 * Method finds the semi state for particular regional
	 * @param obj: the class object whose data is to be used
	 * @param x: the regional whose semi-state needs to be found. 
	 * @return: the semi-state for particular regional. If not found, returns null
	 */
	public static Semistate findSemiStateForRegional(Classify obj,Regional x){
		for(int i=0;i<obj.semistates.size();i++){
			ArrayList<Regional>temp=obj.semistates.get(i).getRegionals();
			for(int j=0;j<temp.size();j++){
				if(temp.get(j).getHost().getName().equals(x.getHost().getName())){
					return obj.semistates.get(i);
				}
			}
		}
		return null;
	}
	/**
	 * Method returns the closest sectional to given sectional
	 * @param toAdd: Sectional to serve as base
	 * @param hosts: The list of sectionals to find closest sectional
	 * @return: The closest sectional to the given sectional
	 */
	public Sectional getClosestSectional(Sectional toAdd, ArrayList<Sectional>hosts){
		Sectional ret;
		long small=School.travelDist(toAdd.getHostSchool(), hosts.get(0).getHostSchool());
		int index=0;
		Sectional smallSect=null;
		for(int i=0;i<hosts.size();i++){
			if(School.travelDist(toAdd.getHostSchool(), hosts.get(i).getHostSchool())<small){
				smallSect=hosts.get(i);
				small=School.travelDist(toAdd.getHostSchool(), hosts.get(i).getHostSchool());
				index=i;
			}
		}
		ret=smallSect;
		return ret;
	}
	/**
	 * This method is NOT USED in the program now
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
	 * METHOD NOT USED in program now
	 * Method to sort sectionals into the regionals
	 * 
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
			/*
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
		}*/
			
			int counter=0;
			for(int i=0;i<regNo;i++){
					School temp=regionals.get(i).getHost();
					
					regionals.get(i).addArraySectionals(getClosestSect(sectionals,findSectional(temp),regDivisor));
				
			}
		System.out.println("Done sorting regionals");
		}
	}
	/**
	 * Method to sort the schools into sectionals
	 * Procedure: 
	 * Find hosts and give each a sectional
	 * Find closest sectional to each school
	 * Add them. Reposition if required based on size
	 */
	public void sortSectionals(){
		int sectionNumber=0;
		
		//System.out.println("School size: "+schools.size());
		//find the hosts and give each a sectional
		for(int i=0;i<schools.size();i++){
			if(sectionNumber>sectNo)
				break;
			if(schools.get(i).isHostSect()==true){
				sectionals.add(new Sectional(schools.get(i).getName(),schools.get(i),sectDivisor));
				
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
		//System.out.println("Done getting closest hosts");
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
		//if size>maxSize
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
		
	}
	/**
	 * Method returns the arraylist of schools for the array passed as parameter
	 * @param x: the array to convert to arrayList
	 * @return: the arraylist of the initial array passed
	 */
	public ArrayList<School> getArrayList(School[] x){
		ArrayList<School>ret=new ArrayList<School>();
		for(int i=0;i<x.length;i++){
			ret.add(x[i]);
		}
		return ret;
	}
	/**
	 * Method orders the schools based on closest distance to the given school
	 * @param present: the school to serve as base
	 * @param tempHosts: the list of schools to be sorted
	 * @return: the sorted array of schools based on closest distance to base.
	 */
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
	/**
	 * Method to find the hosts other than present host for sectionals
	 * @param hosts: the list of all hosts
	 * @param x: the sectional at present
	 * @return: list of all hosts other than the present
	 */
	public ArrayList<School> findOtherHosts(ArrayList<School>hosts,Sectional x){
		for(int i=0;i<hosts.size();i++){
			if(x.getHost().equals(hosts.get(i).getName())){
				hosts.remove(i);
				return hosts;
			}
		}
		return hosts;
	}
	/**
	 * Method adds a school to a particular sectional
	 * @param x: Sectional for adding school
	 * @param toAdd: School to be added
	 * @return: true/false based on added/not added
	 */
	public boolean addInSectional(Sectional x, School toAdd){
		for(int i=0;i<sectionals.size();i++){
			if(sectionals.get(i).getHost().equals(x.getHost())){
				sectionals.get(i).addSchools(toAdd);
				return true;
			}
		}
		return false;
	}
	/**
	 * Method gives the closest school to a list of hosts
	 * @param toAdd: the school to find host
	 * @param hosts: the list of hosts
	 * @return: the host which is closest to the given school
	 */
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
	/**
	 * Method finds the sectional based on host school
	 * @param host: The host school for finding sectional
	 * @return: the sectional found. Returns null if sectional not found
	 */
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
	 * Method checks if the given school is present in a sectional
	 * @param x: the school to find
	 * @return: the sectional that has the given school. If not found, returns null
	 */
	public Sectional findSchoolInSectional(School x){
		ArrayList<School>temp;
		for(int i=0;i<sectNo;i++){
			temp=sectionals.get(i).getSchools();
			for(int j=0;j<temp.size();j++){
				if(temp.get(j).getName().equals(x.getName())){
					return sectionals.get(i);
				}
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
		ArrayList<Sectional> closest=new ArrayList<Sectional>();
		Sectional []arr;
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
				closest.add(smallSect);
				sect.get(index).setAdded(true);
			}
		}
		arr=new Sectional[closest.size()];
		for(int i=0;i<arr.length;i++){
			arr[i]=closest.get(i);
		}
		return arr;
	}
	/**
	 * The toString method of the entire class. 
	 * Returns the string containing the sectionals, regionals and semi-states after sorting
	 */
	public String toString(){
		String ret="**********************Sectionals******************************\n";
		for(int i=0;i<sectionals.size();i++){
			ret+=sectionals.get(i).toString()+"\n";
		}
		ret=ret+"**********************Regionals******************************"+"\n";
		for(int i=0;i<regionals.size();i++){
			ret+=regionals.get(i).toString()+"\n";
		}
		ret=ret+"**********************Semi-States******************************"+"\n";
		for(int i=0;i<semistates.size();i++){
			ret=ret+semistates.get(i).toString()+"\n";
		}
		return ret;
		
	}
	public char getClassName() {
		return className;
	}
	public void setClassName(char className) {
		this.className = className;
	}
	public int getSemiNo() {
		return semiNo;
	}
	public void setSemiNo(int semiNo) {
		this.semiNo = semiNo;
	}
	public ArrayList<Sectional> getSectionals() {
		return sectionals;
	}
	public void setSectionals(ArrayList<Sectional> sectionals) {
		this.sectionals = sectionals;
	}
	public ArrayList<Regional> getRegionals() {
		return regionals;
	}
	public void setRegionals(ArrayList<Regional> regionals) {
		this.regionals = regionals;
	}
	public ArrayList<Semistate> getSemistates() {
		return semistates;
	}
	public void setSemistates(ArrayList<Semistate> semistates) {
		this.semistates = semistates;
	}
	
	
}
