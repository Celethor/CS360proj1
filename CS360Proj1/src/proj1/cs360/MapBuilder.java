package proj1.cs360;

/* This class is responsible for creating the URL that is deployed
 * to the Google Static Map API via HTTPS. */

/*https://maps.googleapis.com/maps/api/staticmap?center={insert address}&zoom=6&size=400x400
        &markers=color:blue%7Clabel:S%7C{insert address}&markers=size:tiny%7Ccolor:green%7C{insert address}
        &markers=size:mid%7Ccolor:0xFFFF00%7Clabel:C%7C{insert address}"&key=*/

/*https://maps.googleapis.com/maps/api/staticmap?center=Indianapolis,IN&zoom=7&size=500x500
&markers=color:blue|label:H|Huntington+North+High+School|Avon+High+School*/

public class MapBuilder {

    public String url = ""; // 8192 character limit
    public String host = "";
    public School []schools;
    public String []schoolNames;
    public String finalURL = "";

    // Following with be the blocks for building the URL
    private String beginURL = "https://maps.googleapis.com/maps/api/staticmap?"; // start of all URLs generated
    private String connect = "&"; // necessary for connecting parameters
    private String center = "center="; // need address or lat/long
    private String zoom = "zoom="; // displaying correct portion of map. Entered as an integer.
    private String zoomLevel = "7";
    private String size = "size=500x500"; //Coverage area of map. Represented as NUMBERxNUMBER
    private String mapType = "maptype=roadmap"; // four choices typically, but defaulting to a particular map style
    private String markers = "markers="; // Determines the style of marker to be used
    // Markers are based on groups, so a new marker tag will be necessary
    // EXAMPLE markers={markerStyles}%7c{markerLocation1}%7c{markerLocation2}%7c{etc}
    // %7c is code for | character; | is an illegal character in URLs
    private String []markerLabels = {"label:A","label:B","label:C","label:D","label:E","label:F","label:G","label:H","label:I","label:J","label:K","label:L","label:M",
            "label:N","label:O","label:P","label:Q","label:R","label:S","label:T","label:U","label:V","label:W","label:X","label:Y","label:Z"};
    private String markerSize = "size:small";
    private String pipeChar = "%7c";

   // TODO: Implement toString function that would combine URL building blocks.

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

    public void ReplaceSpaces(){
        // Web addresses cannot have spaces. Replace with "+" to keep school names compliant.
        // Huntington North High School => Huntington+North+High+School
        for (int index = 0; index < schoolNames.length; index++){
            schoolNames[index] = schoolNames[index].replace(" ", "+");
        }
    }

    public void BuildURL(){
        /* This method will take class data fields and produce final URL string. */
        finalURL = finalURL + beginURL + connect + center + host + connect + zoom + zoomLevel + size + connect + markers + markerSize + pipeChar + schoolNames[0];

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

}


