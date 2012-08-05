/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.util.Log;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author isen
 */
class NewsManager implements JSONDatasHandler {


    public NewsManager() {
    }
     

    public ArrayList<Record> handleArray(JSONArray ja) {
        ArrayList<Record> stringList =new ArrayList<Record>();
        try{
            for(int index=0; index < ja.length();index++){
                JSONObject JSONNews = ja.getJSONObject(index);
                Record ev = this.handleObject(JSONNews);
                stringList.add(ev);
            }
        }catch(Exception e){
            Log.v("News Manager",e.toString());
        }finally{
            return stringList;
        }
    }

    public Record handleObject(JSONObject jo) throws ParseException, JSONException{
        return new News(jo.getString("title"),jo.getInt("topic_id"),jo.getString("startdate"),
                jo.getString("edit_time"),jo.getString("author_name"),jo.getString("ip_address"),
                jo.getString("post_date"),jo.getString("post"),jo.getInt("queued"),
                jo.getString("edit_name"),jo.getString("post_key"),jo.getString("post_htmlstate"),
                jo.getString("post_edit_reason"),jo.getString("post_bwoptions"),
                jo.getString("pdelete_time"),jo.getInt("post_field_int"),jo.getString("post_field_t1"),
                jo.getString("post_field_t2"));
       
    }
    
}

