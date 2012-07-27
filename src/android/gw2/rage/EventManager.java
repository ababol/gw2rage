/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONException;
/**
 *
 * @author isen
 */
public class EventManager implements JSONDatasHandler{

    public ArrayList<Object> handleArray(JSONArray ja) {
        ArrayList<Object> stringList =new ArrayList<Object>();
        try{
            for(int index=0; index < ja.length();index++){
                JSONObject JSONevent = ja.getJSONObject(index);
                Object ev = this.handleObject(JSONevent);
                stringList.add(ev);
            }
        }catch(Exception e){
            Log.v("Event Manager",e.toString());
        }finally{
            return stringList;
        }
    }

    public Object handleObject(JSONObject jo) throws ParseException, JSONException{
        return new Event((int)jo.getInt("id"),(String)jo.get("dateEvent"),
                        (String)jo.get("nomEvent"),(int)jo.getInt("placeTotal"),
                        (int)jo.getInt("coutInscription"));
       
    }
    
}
