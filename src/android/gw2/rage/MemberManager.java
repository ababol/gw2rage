package android.gw2.rage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author artragis
 */
public class MemberManager implements JSONDatasHandler{
    public ArrayList<Record> handleArray(JSONArray ja){
        return new ArrayList<Record>();
    }
    public Object handleObject(JSONObject jo){
        return "";
    }
}
