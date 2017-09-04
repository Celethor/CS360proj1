package proj1.cs360;




import java.io.File;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.maps.errors.ApiException;

public class Application {
	public static void main(String[]args) throws ParseException, ApiException, InterruptedException, IOException, ClassNotFoundException{
				File file=new File("All Schools Lists.txt");
				ArrayList<School>schools=new ArrayList<School>();
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
				int hR=0;
				int hS=0;
				int hSec=0;
				while(scan.hasNext()){
					name=scan.next();
					enrollment=scan.nextInt();
					boys=assignBoolean(scan.next());
					girls=assignBoolean(scan.next());
					HostSect=assignBoolean(scan.next());
					if(HostSect==true)
						hSec++;
					HostReg=assignBoolean(scan.next());
					if(HostReg==true)
						hR++;
					//do this for semi hosts since scan.next() also reads 
					//end of line character
					char q=scan.next().charAt(0);
					
					if(q=='T'||q=='t'){
						hS++;
						HostSemi=true;
					}
					else
						HostSemi=false;
					c++;
					x=new School(name+",IN",enrollment,boys,girls,HostSect,HostReg,HostSemi);
					schools.add(x);
				}
				int noOfSectionals=School.getSectNo();
				int noOfRegionals=School.getRegNo();
				int noOfSemi=School.getSemiNo();
				int userSect;
				int userReg;
				//System.out.println(hS);
				Scanner inputScan=new Scanner(System.in);
				System.out.print("Enter the no. of Sectionals in the Tournament: ");
				userSect=inputScan.nextInt();
				System.out.println("Enter the no. of Regionals in the Tournament: ");
				userReg=inputScan.nextInt();
				Tournament tourney=new Tournament(schools,userSect,userReg);
				System.out.println(tourney.toString());
				
				MapBuilder map = new MapBuilder(tourney.sectionals[0].getHostSchool().getName(), tourney.sectionals[0].getSchools());
				System.out.print(map.BuildURL());
				
			}
			public static boolean assignBoolean(String x){
				if(x.equals("T")||x.equals("t"))
				return true;
				else 
					return false;
			}
}
