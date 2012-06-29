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
//Decoment on debug
import android.util.Log;
/**
 *
 * @author isen
 */
public class GetNetworkInfo  extends AsyncTask<String, Void, String>{
    private TextView textView;
    GetNetworkInfo(TextView tv){
       this.textView = tv;
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
            return response;
    }

    @Override
    protected void onPostExecute(String result) {
        this.textView.setText(result);
            
    }
    @Override
    protected void onCancelled(){
        this.textView.setError("Impossible de se connecter");
        this.textView.setText("Impossible de se connecter");
    }
}
