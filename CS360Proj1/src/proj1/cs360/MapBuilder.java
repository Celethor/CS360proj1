package proj1.cs360;

/* This class is responsible for creating the URL that is deployed
 * to the Google Static Map API via HTTPS. */

public class MapBuilder {

    public String url = ""; // 8192 character limit
    public String host = "";
    public School []schools;

    // Following with be the blocks for building the URL
    public String beginURL = "https://maps.googleapis.com/maps/api/staticmap?"; // start of all URLs generated
    public String connect = "&"; // necessary for connecting parameters
    public String center = "center="; // need address or lat/long
    public String zoom = "zoom="; // displaying correct portion of map. Entered as an integer.
    public String size = "size="; //Coverage area of map. Represented as NUMBERxNUMBER
    public String maptype = "maptype=roadmap"; // four choices typically, but defaulting to a particular map style
    public String markers = "markers="; // Determines the style of marker to be used
    // Markers are based on groups, so a new marker tag will be necessary
    // EXAMPLE markers={markerStyles}%7c{markerLocation1}%7c{markerLocation2}%7c{etc}
    // %7c is code for | character; | is an illegal character in URLs

   // TODO: Implement toString function that would combine URL building blocks.
   // TODO: Getters and Setters*/
   // TODO: URL formatting requires spacing be replaced with “+”. Need method.

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
}


