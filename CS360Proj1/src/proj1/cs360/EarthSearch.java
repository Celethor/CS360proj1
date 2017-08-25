package proj1.cs360;

/*
 * THIs Class contains methods to lookup the address of an establishment given its name, 
 * It also contains a method to determin the distance betweeen 2 establishments
 * 
 */

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
public class EarthSearch {

	// Lookups up and returns the address of an establishemnt given its name and possible some locatioin attributes
	public static void lookupAddress(String establishment) throws ApiException, InterruptedException, IOException {
		GeoApiContext lookupDoodad = new GeoApiContext.Builder()
			    .apiKey("AIzaSyD2MvqQVbfXo3M0mMu4JPGXbaN3y5z9SIg")
			    .build();
			GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
			    establishment).await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
		
			System.out.println(results[0].formattedAddress);
		
		
		return;
	}
}
