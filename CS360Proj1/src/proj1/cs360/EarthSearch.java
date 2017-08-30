package proj1.cs360;





import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

/*
 * Author: @Celethor (Benjamin Treesh)
 * 
 * THIs Class contains methods to lookup the address of an establishment given its name, 
 * It also contains a method to determine the distance between 2 establishments
 * 
 * !!NOTE!! YOU WILL NEED TO ACTIVATE BOTH THE GOOGLE GEOCODING API AND THE GOOGLE DISTANCE MATRIX APIS
 *  FOR YOUR PROJECT IN ORDER TO USE THIS CLASS!!! THANK YOU!! :D
 * 
 * credit to google-maps-services-java project on github for help in this method
 * https://github.com/googlemaps/google-maps-services-java
 *
 *                                          _____________               
                                       __/_|_|_|_|_|_|_\__               
                                      /                   \    .           
                 .       ____________/  ____               \   :            
                 :    __/_|_|_|_|_|_(  |    |               )  |           
                 |   /               \ | () |()  ()  ()  ()/   *          
                 *  /  ____           \|____|_____________/            
    .              (  |    |            \_______________/
    :               \ | () |()  ()  ()    \___________/
    |                \|____|____________ /   \______/     .
    *                  \_______________/       \  /       :
          3         .    \___________/         (__)       |    .
            3       :       \______/           /  \       *    :
             3      |         \  /            /    \           |
              3     *         (__)           /      \          *
        ,,     3              /  \          /        \
      w`\v',___n___          /    \        /          \
      v\`|Y/      /\        /      \      /            \
      `-Y/-'_____/  \      /        \    /              \
       `|-'      |  |     /          \  /                \
________|_|______|__|____/____________\/__________________\__

 **credit http://ascii.co.uk/art/ufo
 */



public class EarthSearch {
	
	//private static final String API_KEY = "AIzaSyD2MvqQVbfXo3M0mMu4JPGXbaN3y5z9SIg";
	private static final String API_KEY = "AIzaSyDOQ0NoT9r3RI0zYoO3q-p0h14Z4pggpQ0";

	// Lookups up and returns the address of an establishment given its name and possible some location attributes
	public static String lookupAddr(String establishment) throws ApiException, InterruptedException, IOException {
		
		//set up key
		GeoApiContext lookupDoodad = new GeoApiContext.Builder()
			    .apiKey(API_KEY)
			    .build();
			GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
			    establishment).await();
			
			//converts results into usable address
			
			String address = (results[0].formattedAddress);
		
		return address;
	}
	
	// Lookups up and returns the coordinates of an establishment given its name and possible some location attributes
	public static LatLng lookupCoord(String establishment) throws ApiException, InterruptedException, IOException {
			
		//set up key
		GeoApiContext lookupDoodad = new GeoApiContext.Builder()
			    .apiKey(API_KEY)
			    .build();
		GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
		  establishment).await();
				
			//converts results into usable Coordinates
		
			LatLng coords = (results[0].geometry.location);
				
		return coords;
	}
		
	
	//given two addresses, calculates the driving distance
	public static long getDriveDist(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException{
				
		//set up key
    	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey(API_KEY)
			    .build();
    	
    	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
        DistanceMatrix result = req.origins(addrOne)
                .destinations(addrTwo)
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .language("en-US")
                .await();
        
				long distApart = result.rows[0].elements[0].distance.inMeters;
		
		return distApart;
	}
	
	
	// Why was this added??
	public static void distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException{
		GeoApiContext context = new GeoApiContext.Builder()
			    .apiKey(API_KEY)
			    .build();
			
			DistanceMatrixApiRequest req=DistanceMatrixApi.newRequest(context);
			DistanceMatrix t=req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).await();
			//long[][] array=new long[origins.length][destinations.length];
			File file=new File("Matrix.txt");
			FileOutputStream out=new FileOutputStream(file);
			DataOutputStream outFile=new DataOutputStream(out);
			for(int i=0;i<origins.length;i++){
				for(int j=0;j<destinations.length;j++){
					//System.out.println(t.rows[i].elements[j].distance.inMeters);
					outFile.writeLong(t.rows[i].elements[j].distance.inMeters);
				}
			}
			outFile.close();
	}
}