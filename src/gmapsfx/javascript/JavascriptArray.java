package gmapsfx.javascript;

import java.util.HashMap;
import java.util.Map;
import netscape.javascript.JSObject;

/** JavascriptObject implementation of an array.
 * <p>
 * Return values are supplied as their raw return value from Javascript, unless 
 * that value has previously been passed in to the array as a JavascriptObject. 
 * The caller is then responsible for wrapping any new JSObjects in the 
 * appropriate JavascriptObject, as they should know what is needed.
 * <p>

 */
public class JavascriptArray extends JavascriptObject {
    
    private final Map<JSObject, JavascriptObject> content = new HashMap<>();
    
    public JavascriptArray() {
        runtime.execute("var " + variableName + " = []");
        jsObject = runtime.execute(variableName);
    }
    
    public Object  get(int idx) {
        Object obj = getJSObject().getSlot(idx);
        if (obj instanceof JSObject && content.containsKey((JSObject) obj)) {
            return (JavascriptObject) content.get((JSObject) obj);
        }
        return obj;
    }
    
    //concat() 	Joins two or more arrays, and returns a copy of the joined arrays
    //indexOf() 	Search the array for an element and returns its position
    public int indexOf(Object obj) {
        if (obj instanceof JavascriptObject) {
            return checkInteger(invokeJavascript("indexOf", ((JavascriptObject) obj).getJSObject()), -1);
        }
        return checkInteger(invokeJavascript("indexOf", obj), -1);
    }
    
    //join() 	Joins all elements of an array into a string
    //lastIndexOf() 	Search the array for an element, starting at the end, and returns its position
    public int lastIndexOf(Object obj) {
        if (obj instanceof JavascriptObject) {
            return checkInteger(invokeJavascript("lastIndexOf", ((JavascriptObject) obj).getJSObject()), -1);
        }
        return checkInteger(invokeJavascript("lastIndexOf", obj), -1);
    }
    
    //pop() 	Removes the last element of an array, and returns that element
    public Object pop() {
        //Object obj = jsObject.getSlot(jsLen - 1);
        Object obj = invokeJavascript("pop");
        if (obj instanceof JSObject && content.containsKey((JSObject) obj)) {
            return (JavascriptObject) content.get((JSObject) obj);
        }
        return obj;
    }
    
    //push() 	Adds new elements to the end of an array, and returns the new length
    public int push(Object obj) {
        if (obj instanceof JavascriptObject) {
            //jsObject.setSlot(length(), ((JavascriptObject) obj).getJSObject());
            content.put(((JavascriptObject) obj).getJSObject(), (JavascriptObject) obj);
        }
        return checkInteger(invokeJavascript("push", obj), 0);
    }
    
    //reverse() 	Reverses the order of the elements in an array
    public void reverse() {
        invokeJavascript("reverse");
    }
    
    //shift() 	Removes the first element of an array, and returns that element
    public Object shift() {
        Object obj = invokeJavascript("shift");
        if (obj instanceof JSObject && content.containsKey((JSObject) obj)) {
            return (JavascriptObject) content.get((JSObject) obj);
        }
        return obj;
    }
    
    //slice() 	Selects a part of an array, and returns the new array
    
    //sort() 	Sorts the elements of an array
    public void sort(String func) {
        if (func == null || func.isEmpty()) {
            Object ary = invokeJavascript("sort");
        } else {
            Object ary = invokeJavascript("sort", func);
        }
    }
    
    //splice() 	Adds/Removes elements from an array
    //toString() 	Converts an array to a string, and returns the result
    @Override
    public String toString() {
        return invokeJavascriptReturnValue("toString", String.class);
    }
    
    //unshift() 	Adds new elements to the beginning of an array, and returns the new length
    public int unshift(Object obj) {
        if (obj instanceof JavascriptObject) {
            //jsObject.setSlot(length(), ((JavascriptObject) obj).getJSObject());
            content.put(((JavascriptObject) obj).getJSObject(), (JavascriptObject) obj);
        }
        return checkInteger(invokeJavascript("unshift", obj), 0);
    }
    
    //valueOf()
    
    /** Get the length of the array. This returns the value from the underlying 
     * Javascrpt object.
     * 
     * @return 
     */
    public int length() {
        return checkInteger(getProperty("length"), 0);
    }
    
}
