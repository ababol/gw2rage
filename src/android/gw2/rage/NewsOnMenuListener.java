/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import java.util.ArrayList;

/**
 *
 * @author isen
 */
public class NewsOnMenuListener implements TabListener{
private Gw2rageActivity ac;
    public NewsOnMenuListener(Gw2rageActivity ac){
        this.ac = ac;
    }
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        this.onTabSelected(tab, ft);
    }

     public void onTabSelected(Tab tab, FragmentTransaction ft) {
        this.ac.addTabToHistory(tab.getPosition());
        ScrollView sv =new ScrollView(this.ac.getBaseContext());
        String lien = "http://www.guildwars2-rage.com/rage/site/api/news/";
        NewsManager handler = new NewsManager();
        ViewGroup v = (ViewGroup)this.ac.getLayoutInflater().inflate(R.layout.events, sv);
        v= (ViewGroup)sv.getChildAt(0);
        //setContentView(sv);
        this.ac.setContentView(sv);
        ArrayList<Record> res = new ArrayList<Record>();
        GetNetworkInfo task = new GetNetworkInfo(v,this.ac, handler,new NewsListViewFactory());
        task.execute(new String[] { lien });
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
