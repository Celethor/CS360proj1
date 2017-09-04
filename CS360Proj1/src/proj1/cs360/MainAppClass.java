package proj1.cs360;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.maps.errors.ApiException;

public class MainAppClass {
	public static void main(String[] args) throws ClassNotFoundException, ApiException, InterruptedException, IOException, ParseException{
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
		Scanner inputScan=new Scanner(System.in);
		int noOfClasses;
		System.out.println("Enter the number of classes : ");
		noOfClasses=inputScan.nextInt();
		Classify classObj[]=new Classify[noOfClasses];
		int userSect;
		int userReg;
		int userSemi;
		int maxEnrollment;
		
		for(int i=0;i<noOfClasses;i++){
			System.out.println("Enter details for class no. "+(i+1)+" : ");
			//System.out.println("Enter the maximum enrollment for this class: ");
			//maxEnrollment=inputScan.nextInt();
			classObj[i]=new Classify(schools);
		}
		System.out.println("Done creating classes");
		//System.out.println(classObj[1].toString());
	}
	public static boolean assignBoolean(String x){
		if(x.equals("T")||x.equals("t"))
		return true;
		else 
			return false;
	}
}

