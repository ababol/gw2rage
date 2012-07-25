/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author isen
 */
public interface JSONDatasHandler {
    public String handleArray(JSONArray ja);
    public String handleObject(JSONObject jo);
}
