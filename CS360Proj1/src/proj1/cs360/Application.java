package proj1.cs360;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	public static void main(String[]args) throws FileNotFoundException, ParseException{
				File file=new File("Schools.txt");
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
					//System.out.println(x.getName()+"\t"+x.getLocation());
					schools.add(x);
					//scan.nextLine();
					
				}
				System.out.println(c);
				Tournament tourney=new Tournament(schools);
				tourney.toString();
			}
			public static boolean assignBoolean(String x){
				if(x.equals("T"))
				return true;
				else 
					return false;
			}
}
