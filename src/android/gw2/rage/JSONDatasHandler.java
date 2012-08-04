/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author isen
 */
public interface JSONDatasHandler {
    public ArrayList<Record> handleArray(JSONArray ja);
    /**
     * 
     * @param jo
     * @return
     * @throws ParseException
     * @throws JSONException 
     */
    public Object handleObject(JSONObject jo)throws ParseException, JSONException;
}
