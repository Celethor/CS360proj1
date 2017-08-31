package proj1.cs360;

/* This class is responsible for creating the URL that is deployed
 * to the Google Static Map API via HTTPS. */

public class MapBuilder {

    public String url = ""; // 8192 character limit
    public String host = "";
    public School []schools;
    public String []schoolNames;

    // Following with be the blocks for building the URL
    private String beginURL = "https://maps.googleapis.com/maps/api/staticmap?"; // start of all URLs generated
    private String connect = "&"; // necessary for connecting parameters
    private String center = "center="; // need address or lat/long
    private String zoom = "zoom="; // displaying correct portion of map. Entered as an integer.
    private String size = "size="; //Coverage area of map. Represented as NUMBERxNUMBER
    private String mapType = "maptype=roadmap"; // four choices typically, but defaulting to a particular map style
    private String markers = "markers="; // Determines the style of marker to be used
    // Markers are based on groups, so a new marker tag will be necessary
    // EXAMPLE markers={markerStyles}%7c{markerLocation1}%7c{markerLocation2}%7c{etc}
    // %7c is code for | character; | is an illegal character in URLs

   // TODO: Implement toString function that would combine URL building blocks.
   // TODO: URL formatting requires spacing be replaced with “+”. Need method.

    public MapBuilder(String host, School []schools){
        this.host = host;
        this.schools = schools;
        schoolNames = new String[schools.length];
    }

    public void AddSchoolNames(){
        // Get school names, store in array for URL building.
        for(int i = 0; i < schools.length; i++){
            schoolNames[i] = schools[i].getName();
        }
    }

    public void BuildURL(){
        /* This method will take class data fields and produce final URL string. */
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
    public String setCenter() {
        return center;
    }

    public String setZoom() {
        return zoom;
    }

    public String setSize() {
        return size;
    }

}


