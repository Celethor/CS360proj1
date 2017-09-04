package proj1.cs360;

import java.util.ArrayList;

/* This class is responsible for creating the URL that is deployed
 * to the Google Static Map API via HTTPS. */

/*https://maps.googleapis.com/maps/api/staticmap?center={insert address}&zoom=6&size=400x400
        &markers=color:blue%7Clabel:S%7C{insert address}&markers=size:tiny%7Ccolor:green%7C{insert address}
        &markers=size:mid%7Ccolor:0xFFFF00%7Clabel:C%7C{insert address}"&key=*/

/*https://maps.googleapis.com/maps/api/staticmap?center=Indianapolis,IN&zoom=7&size=500x500&markers=color:green|Huntington+North+High+School*/

// TODO: Implement String builder function that would combine URL building blocks.
// TODO: Modify String builder function 

public class MapBuilder {

    public String url = ""; // 8192 character limit
    public String host = "";
    public School []schools;
    public ArrayList<School> schoolList;
    public String []schoolNames;
    public String finalURL = "";
    public String defaultCenterLocale = "Indianapolis,IN";
    public String []schoolCoords;

    // Following with be the blocks for building the URL
    private String beginURL = "https://maps.googleapis.com/maps/api/staticmap?"; // start of all URLs generated
    private String connect = "&"; // necessary for connecting parameters
    private String center = "center="; // need address or lat/long
    private String zoom = "zoom="; // displaying correct portion of map. Entered as an integer.
    private String zoomLevel = "10";
    private String size = "size=500x500"; //Coverage area of map. Represented as NUMBERxNUMBER
    private String mapType = "maptype=roadmap"; // four choices typically, but defaulting to a particular map style
    private String markers = "markers="; // Determines the style of marker to be used
    // Markers are based on groups, so a new marker tag will be necessary
    // EXAMPLE markers={markerStyles}%7c{markerLocation1}%7c{markerLocation2}%7c{etc}
    // %7c is code for | character; | is an illegal character in URLs
    private String []markerLabels = {"label:A","label:B","label:C","label:D","label:E","label:F","label:G","label:H","label:I","label:J","label:K","label:L","label:M",
            "label:N","label:O","label:P","label:Q","label:R","label:S","label:T","label:U","label:V","label:W","label:X","label:Y","label:Z"};
    private String markerLabel = "label:S";
    private String []markerColor = {"color:green", "color:blue"};
    private String markerSize = "size:small";
    private String pipeChar = "%7c";

    public MapBuilder(String host, School []schools){
        this.host = host.replace(" ", "+");
        this.schools = schools;
        schoolNames = new String[schools.length];
        AddSchoolNames();
        ReplaceSpacesInSchoolNames();
    }

    public MapBuilder(String host, ArrayList<School> schools) {
    	this.host = host.replace(" ", "+");
        this.schools = schools.toArray(new School[schools.size()]);
        schoolNames = new String[schools.size()];
        schoolCoords = new String[schools.size()];
        AddSchoolNames();
        ReplaceSpacesInSchoolNames();
	}

	public void AddSchoolCoords(){
        // Get school names, store in array for URL building.
        for(int i = 0; i < schools.length; i++){
            schoolCoords[i] = Double.toString(schools[i].coords.lat) + "," + Double.toString(schools[i].coords.lng);
        }
    }

	public void AddSchoolNames(){
        // Get school names, store in array for URL building.
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

    public String BuildURL(){
        /* This method will take class data fields and produce final URL string. */
        finalURL = finalURL + beginURL /*+ connect + center + defaultCenterLocale*/ + connect + /*zoom + zoomLevel + connect +*/ size + connect + 
        		markers + markerSize + pipeChar + markerColor[0] + pipeChar + host + connect +
        		markers + markerSize + pipeChar + markerColor[1] + pipeChar + markerLabel + pipeChar;
        for (int i = 0; i < schoolNames.length; i++) {
        	finalURL = finalURL + schoolCoords[i] + pipeChar;
        }
        finalURL = finalURL + connect + mapType;
        
        //System.out.print(finalURL);
        return finalURL;
    }

    /* Setter Methods*/
    public void setCenter(String center) {
        /* Sets where the center of the map will be.
         * This is required if no markers are used. */
        this.center = center;
    }

    public void setZoom(String zoom) {
        /* Sets the zoom level of the map. */
        this.zoom = zoom;
    }

    public void setSize(String size) {
        /* Sets the size of the map.
         * Must be entered as NUMBERxNUMBER. */
        this.size = size;
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

} // end class 


