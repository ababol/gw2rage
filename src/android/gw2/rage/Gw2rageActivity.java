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
import android.gw2.rage.GetNetworkInfo;
//import android.app.ActionBar;
//Decoment on debug
import android.util.Log;
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
		switch (item.getItemId()) {
		case R.id.menuitem1:
			Toast.makeText(this, R.string.status, Toast.LENGTH_SHORT)
					.show();
                        
                        try{
                            String lien = "http://www.guildwars2-rage.com/rage/appli/status.php";//check the name
                           
                            GetNetworkInfo task = new GetNetworkInfo((TextView) findViewById(R.id.TextView01));
                            task.execute(new String[] { lien });
                           
                        }catch(Exception e){
                            Log.v("net level",e.toString());
                             Toast.makeText(this, "we did not made it :"+e.getClass() +" levée à la ligne "
                                     +e.toString(), Toast.LENGTH_LONG)
					.show();
                            //@TODO voir les problèmes générés par URL
                        }
                        setContentView(R.layout.status);
                        
                        /**
                         * @TODO show here the score, number of members... of the guild
                         */
			break;
		/*case R.id.menuitem2:
			Toast.makeText(this, R.string.curr_event, Toast.LENGTH_SHORT)
					.show();
			break;
*/
		default:
			break;
		}

		return true;
	}
    
}
