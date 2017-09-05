package proj1.cs360;

import java.util.ArrayList;

/* This class is responsible for creating the URL that is deployed
 * to the Google Static Map API via HTTPS. 
 * 
 * To use this class, create a MapBuidler object with a School object
 * and an ArrayList of type School. Call the BuildURL method, 
 * and then call the getFinalURL method to get the final String.
 * */

public class MapBuilder {

    public String url = ""; // 8192 character limit
    public String hostName = "";
    public School hostSchool;
    public School []schools;
    public ArrayList<School> schoolList;
    public String []schoolNames;
    public String finalURL = "";
    public String []schoolCoords;

    // Following will be the blocks for building the URL
    private String beginURL = "https://maps.googleapis.com/maps/api/staticmap?"; // start of all URLs generated
    private String connect = "&"; // necessary for connecting blocks
    private String center = "center="; // need address or lat/long
	private String centerLocale = "Indianapolis,IN"; // may not be needed, but good form.
    private String zoom = "zoom="; // displaying correct portion of map. 
    private String zoomLevel = "10"; // Entered as an integer.
    private String size = "size=500x500"; //Coverage area of map. Represented as NUMBERxNUMBER
    private String mapType = "maptype=roadmap"; // four choices typically, but defaulting to a particular map style
    private String markers = "markers="; // Determines the style of marker to be used
    // Markers are based on groups, so a new marker tag will be necessary
    // EXAMPLE markers={markerStyles}%7c{markerLocation1}%7c{markerLocation2}%7c{etc}
    // %7c is code for | character; | is an illegal character in URLs according to Google API
    String markerLabel = "label:S";
    private String []markerColor = {"color:green", "color:blue"};
    private String markerSize = "size:mid";
    private String pipeChar = "%7c";

    public MapBuilder(School hostSchool, ArrayList<School> schools) {
    	this.hostSchool = hostSchool;
    	this.hostName = hostSchool.getName().replace(" ", "+");
        this.schools = schools.toArray(new School[schools.size()]);
        schoolNames = new String[schools.size()];
        schoolCoords = new String[schools.size()];
        AddSchoolCoords();
	}

	public void AddSchoolCoords(){
        /* Get the latitude and longitude coordinates from each School object
         * and store individually in to an array as a String
         * for easy referencing. */
        for(int i = 0; i < schools.length; i++){
            schoolCoords[i] = Double.toString(schools[i].coords.lat) + "," + Double.toString(schools[i].coords.lng);
        }
    }

	public void AddSchoolNames(){
        /* Get the school name from each School object
         * and store individually in to an array as a String
         * for easy referencing. */
        for(int i = 0; i < schools.length; i++){
            schoolNames[i] = schools[i].getName();
        }
    }

    public void ReplaceSpacesInSchoolNames(){
        // Web addresses cannot have spaces. Replace with "+" to keep school names compliant.
        // Huntington North High School => Huntington+North+High+School
        for (int i = 0; i < schoolNames.length; i++){
            schoolNames[i] = schoolNames[i].replace(" ", "+");
        }
    }

    public void BuildURL(){
        /* This method will take class data fields and produce final URL string. */
        finalURL = finalURL + beginURL + connect + size + connect + 
        		markers + markerSize + pipeChar + markerColor[0] + pipeChar + hostName + connect +
        		markers + markerSize + pipeChar + markerColor[1] + pipeChar + markerLabel + pipeChar;
        for (int i = 0; i < schools.length; i++) {
        	finalURL = finalURL + schoolCoords[i] + pipeChar;
        }
        finalURL = finalURL + connect + mapType;
    }

    /* Setter Methods*/
    // Honestly these may not even get called.
    public void setCenter(String center) {
        /* Sets where the center of the map will be.
         * This is required if no markers are used. */
        this.center = center;
    }

    public void setSize(String size) {
        /* Sets the size of the map.
         * Must be entered as NUMBERxNUMBER. */
        this.size = size;
    }
	
    public void setZoomLevel(String zoomLevel) {
    	// Sets zoom level of map.
		this.zoomLevel = zoomLevel;
	}

    /* Getter Methods */
    public String getCenter() {
        return center;
    }

    public String getZoom() {
        return zoom;
    }

    public String getSize() {
        return size;
    }

    public String getFinalURL() {
        return finalURL;
    }

	public String getZoomLevel() {
		return zoomLevel;
	}

} // end class 