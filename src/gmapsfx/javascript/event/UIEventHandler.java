package gmapsfx.javascript.event;
import netscape.javascript.JSObject;

/** Handles Google Maps UI events.
 
 */
public interface UIEventHandler extends GFXEventHandler {
    /**
     * @param obj This object may be either a MouseEvent or one of it's subclasses.
     */
	public void handle(JSObject obj);
}
