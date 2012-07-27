/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
//Decoment on debug
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 *
 * @author isen
 */
public class GetNetworkInfo  extends AsyncTask<String, Void, ArrayList<Event>>{
    private ViewGroup layout;
    private JSONDatasHandler handler;
    private LayoutInflater inflater;
    /**
     * 
     * @param tv the text view where datas must be written, if an error rises
     * it will be written in this text view
     * @param handler will handle the response
     */
    GetNetworkInfo(ViewGroup layout,LayoutInflater li,JSONDatasHandler handler){
       this.layout = layout;
       this.inflater = li;
       this.handler = handler;
    }
  
    @Override
    protected void onPreExecute(){
        this.layout.removeAllViews();
        Log.d("preExecute",this.layout.toString());
        try{
            TextView search = (TextView)new TextView(this.inflater.getContext());
            this.layout.addView(search);
            search.setText(R.string.recherche);
        }catch(Exception e){
            
        }
    }
    @Override
    protected ArrayList<Event> doInBackground(String... urls) {
            String response = "";
            for (String url : urls) {
                    DefaultHttpClient client = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet(url);
                    try {
                            HttpResponse execute = client.execute(httpGet);
                            InputStream content = execute.getEntity().getContent();

                            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                            String s = "";
                            while ((s = buffer.readLine()) != null) {
                                    response += s;
                            }

                    } catch (Exception e) {
                        Log.v("Network", e.toString());
                        cancel(true);
                    }
            }
            try{
                Log.d("network response", response);
                JSONArray parsedResponse = new JSONArray(response);
                
                ArrayList<Object>objects = this.handler.handleArray(parsedResponse);
                ArrayList<Event> eventCollection = new ArrayList<Event>();
                for(int i=0 ; i< objects.size(); i++ ){
                    eventCollection.add((Event) objects.get(i));
                }
                return eventCollection;
            }catch (Exception e){
                
                Log.v("JSON parsing", "le JSON envoyé est mal formé "+e.toString());
            }
            return new ArrayList<Event>();
    }

    @Override
    protected void onPostExecute(ArrayList<Event> result) {
        this.layout.removeAllViews();
        ListIterator<Event> it = result.listIterator();
        try{
            while(it.hasNext()){
                
//                Log.d("affichage",this.inflater.toString());
//                View temp = this.inflater.inflate(R.id.TextView01, null);
//                Log.d("affichage",temp.toString());
                TextView text =new TextView(this.inflater.getContext());
                Log.d("affichage",text.toString());
                text.setText(it.next().toString());
                text.setFocusableInTouchMode(true);
                
                this.layout.addView(text);
            }
        }catch(Exception e){
            Log.d("affichage", this.layout.toString());
            Log.v("affichage", e.toString());
        }
    }
    @Override
    protected void onCancelled(){
    }
}
