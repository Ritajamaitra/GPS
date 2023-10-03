package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;

/** Wraps a google.maps.Polyline object.
 *
 * @author Geoff Capper
 */
public class PolyLine extends JavascriptObject {
    
    public PolyLine() {
        super(GMapObjectType.POLYLINE);
    }
    
    public PolyLine(PolylineOptions opts) {
        super(GMapObjectType.POLYLINE, opts);
    }
    
    /**
     * This method is called from the GoogleMap.addPolyLine() method, 
     * it should not be invoked directly.
     *
     * @param map The map to add this PolyLine to.
     */
    protected void setMap(GoogleMap map) {
        invokeJavascript("setMap", map);
    }
    
}
