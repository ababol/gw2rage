package android.gw2.rage;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import java.util.ArrayList;
import java.util.Stack;
public class Gw2rageActivity extends SherlockActivity implements
		ActionBar.TabListener {
    private Stack<Integer> previousTab ;
    
   public Gw2rageActivity(){
       super();
       this.previousTab = new Stack();
       this.previousTab.push(-1);
   }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("create","hello");
        setContentView(R.layout.main);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ArrayList<SubActivity> menuList = new ArrayList<SubActivity>();
        menuList.add(SubActivityFactory.getEventSubActivity(this));
        menuList.add(SubActivityFactory.getNewsSubActivity(this));
        for (int i = 0; i <menuList.size(); i++) {
                ActionBar.Tab tab = getSupportActionBar().newTab();
                tab.setText(menuList.get(i).getTitle());
                tab.setTabListener(menuList.get(i).getListener());
                
                getSupportActionBar().addTab(tab);
                if(savedInstanceState != null && savedInstanceState.containsKey("selected_tab")){
                    Log.d("create","selected_tab_here");
                    if(i==savedInstanceState.getInt("selected_tab")){
                        tab.select();
                    }
                }
        }
    }
      @Override
    public void onSaveInstanceState(Bundle instance){
        
        super.onSaveInstanceState(instance);
       Log.v("onsave_prepend", instance.toString());
        instance.putInt("selected_tab",this.getSupportActionBar()
                                                .getSelectedNavigationIndex());
        Log.v("onsave_apend", instance.toString());
    }
      @Override 
      public void onRestoreInstanceState(Bundle savedInstanceState){
          super.onRestoreInstanceState(savedInstanceState);
          
      }
      
      @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(this.previousTab.peek() == -1){
                moveTaskToBack(true);
            }
            else{
                
                getSupportActionBar().getTabAt(this.previousTab.pop()).select();
                this.previousTab.pop();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
      

    @Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction transaction) {
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction transaction) {
            
//		mSelected.setText("Selected: " + tab.getText());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction transaction) {
	}
        
        public void addTabToHistory(Integer tabIndex){
            Log.d("addToHistory", this.previousTab.toString());
            this.previousTab.push(tabIndex);
        }
}
