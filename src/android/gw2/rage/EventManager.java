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
public class EventManager implements JSONDatasHandler{

    public String handleArray(JSONArray ja) {
        String stringList ="";
        try{
            for(int index=0; index < ja.length();index++){
                stringList += ja.get(index).toString()+'\n';
            }
        }catch(Exception e){
            stringList = "";
        }finally{
            return stringList;
        }
    }

    public String handleObject(JSONObject jo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
