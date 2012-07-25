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
/**
 *
 * @author isen
 */
public class GetNetworkInfo  extends AsyncTask<String, Void, String>{
    private TextView textView;
    private TextView error;
    private JSONDatasHandler handler;
    /**
     * 
     * @param tv the text view where datas must be written, if an error rises
     * it will be written in this text view
     * @param handler will handle the response
     */
    GetNetworkInfo(TextView tv,JSONDatasHandler handler){
       this.textView = tv;
       this.error = tv;
       this.handler = handler;
    }
    /**
     * 
     * @param tv the text view where datas must be written
     * @param error if an error rises it will be written in this text view
     */
    GetNetworkInfo(TextView tv, TextView error,JSONDatasHandler handler){
       this.textView = tv;
       this.error = error;
       this.handler = handler;
    }
    @Override
    protected void onPreExecute(){
        this.textView.setText("Recherche en cours, veuillez patienter");
    }
    @Override
    protected String doInBackground(String... urls) {
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
                JSONArray parsedResponse = new JSONArray(response);
                response = this.handler.handleArray(parsedResponse);
                if(response.equalsIgnoreCase("")){
                    Log.v("JSON PARSING", "hum, what's happening?");
                    cancel(true);
                }
            }catch (Exception e){
                
                Log.v("JSON parsing", "le JSON envoyé est mal formé "+e.toString());
            }
            return response;
    }

    @Override
    protected void onPostExecute(String result) {
        this.textView.setText(result);
            
    }
    @Override
    protected void onCancelled(){
        this.error.setError("Impossible de se connecter");
        this.error.setText("Impossible de se connecter");
    }
}
