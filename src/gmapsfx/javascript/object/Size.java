package gmapsfx.javascript.object;

import gmapsfx.javascript.JavascriptObject;

/**
 * Size object corresponding to <a href="https://developers.google.com/maps/documentation/javascript/reference#Size">google.maps.Size</a>
* 
* Two-dimensonal size, where width is the distance on the x-axis, and height is the distance on the y-axis.
*  */
public class Size extends JavascriptObject {

    protected int width;
    protected int height;
    protected String widthUnit;
    protected String heightUnit;
    
    
    
    /**
     * 
     * @param width distance on x-axis
     * @param height distance on y-axis
     */
    public Size(int width, int height) {
        super(GMapObjectType.SIZE, width, height);
    }
    
    /**
     * 
     * @param width distance on x-axis
     * @param height distance on y-axis
     * @param widthUnit
     * @param heightUnit 
     */
    public Size( int width, int height, String widthUnit, String heightUnit ) {
        super( GMapObjectType.SIZE, width, height, widthUnit, heightUnit );
    }

    public int getWidth() {
        return getProperty("width", Integer.class);
    }

    public int getHeight() {
        return getProperty("height", Integer.class);
    }

    public String getWidthUnit() {
        return widthUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }
    
    public boolean equals( Size other ) {
        return invokeJavascriptReturnValue("equals", Boolean.class, other);
    }
    
    
    @Override
    public String toString() {
        return invokeJavascriptReturnValue("toString", String.class, (Object)null);
    }
    
}