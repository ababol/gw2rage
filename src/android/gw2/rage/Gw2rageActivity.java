package android.gw2.rage;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.TextView;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
//import android.app.ActionBar;
//Decoment on debug
import android.util.Log;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.ScrollView;
public class Gw2rageActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.mainmenu, menu);
            
            return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String lien;
        JSONDatasHandler handler;
        int layout;
        LayoutInflater li = (LayoutInflater) this.getLayoutInflater();
        try{
            ScrollView sv =new ScrollView(this);
            
            switch (item.getItemId()) {
            case R.id.menuitem1:
                layout = R.layout.status;

                lien = "http://www.guildwars2-rage.com/rage/appli/status.php";//check the name
                handler = new StatusManager();



                /**
                    * @TODO show here the score, number of members... of the guild
                    */
                break;
            case R.id.menuitem2:
                lien = "http://www.guildwars2-rage.com/rage/site/api/event/";
                handler = new EventManager();
                layout = R.layout.events;
                break;

            default:
                lien = "http://www.guildwars2-rage.com/rage/appli/status.php";//check the name
                handler = new StatusManager();
                layout = R.layout.status;
                break;
            }


                setContentView(sv);
                sv.removeAllViews();
                
                ViewGroup v = (ViewGroup)new LinearLayout(this);
                
                //sv.addView(v);
                    sv.addView(v);

                GetNetworkInfo task = new GetNetworkInfo(v,li, handler);
                task.execute(new String[] { lien });
                            
        }catch(Exception e){

            Log.v("Menu", e.toString() +" "+e.getMessage());
        }
		return true;
    }
    
}
