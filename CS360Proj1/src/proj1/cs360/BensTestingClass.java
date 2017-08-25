package proj1.cs360;

import java.io.IOException;

import com.google.maps.errors.ApiException;

public class BensTestingClass {

	public static void main(String[] args) throws ApiException, InterruptedException, IOException {
		
		String establishment = "Snider High School, Indiana";
		EarthSearch.lookupAddress(establishment);

	}

}
