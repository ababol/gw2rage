/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
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
public class GetNetworkInfo  extends AsyncTask<String, Void, ArrayList<Record>>{
    private ViewGroup layout;
    private JSONDatasHandler handler;
    private LayoutInflater inflater;
    private RecordViewFactory factory;
    private ArrayList<Record> result;
    private Activity activity;
    /**
     * 
     * @param tv the text view where datas must be written, if an error rises
     * it will be written in this text view
     * @param handler will handle the response
     */
    GetNetworkInfo(ViewGroup layout, Activity ac, JSONDatasHandler handler, android.gw2.rage.RecordViewFactory factory){
       this.layout = layout;
       this.inflater = ac.getLayoutInflater();
       this.activity = ac;
       this.handler = handler;
       this.result = new ArrayList<Record>();
       this.factory=factory;
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
    protected ArrayList<Record> doInBackground(String... urls) {
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
                
                this.result.addAll(this.handler.handleArray(parsedResponse));
                Log.d("JSON parsing ","number of events " + this.result.size());
                return this.result;
            }catch (Exception e){
                
                Log.d("JSON parsing", "le JSON envoyé est mal formé "+e.toString());
            }
            return new ArrayList<Record>();
    }

    @Override
    protected void onPostExecute(ArrayList<Record> result) {
        this.layout.removeAllViews();
         ListIterator<Record> it = result.listIterator();
         Log.d("after parsing","number of events "+result.size());
        try{
            while(it.hasNext()){
                Record current = it.next();
                RecordView rv = this.factory.generateView(current, this.activity);
                rv.drawView(this.layout);
            }
        }catch(Exception e){
//            Log.d("affichage", this.layout.toString());
            Log.v("affichage", e.toString());
        }
    }
    @Override
    protected void onCancelled(){
    }
}
