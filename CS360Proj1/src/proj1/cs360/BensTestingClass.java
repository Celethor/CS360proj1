package proj1.cs360;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.maps.errors.ApiException;

public class BensTestingClass {

	public static void main(String[] args) throws ApiException, InterruptedException, IOException {
		
		//String establishment = "Snider High School, Indiana";
		//EarthSearch.lookupAddress(establishment);

	//	System.out.println(EarthSearch.computeDriveDistance("5901 Heywood Cove, Fort Wayne, IN 46815",
	//			"4600 Fairlawn Pass, Fort Wayne, IN 46815"));
		
	//	String establishment = "Snider High School, Indiana";
	//	System.out.println(EarthSearch.lookupAddr(establishment));
	
		
///////		
		//CREATES GUI!! I did it!

		Display display = new Display();
		
        Shell shell = new Shell(display);
        
        new GUITest(shell, SWT.NONE);

        // the layout manager handle the layout
        // of the widgets in the container
        shell.setLayout(new FillLayout());

        //add some widgets to the Shell
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
///////        
	}

}
