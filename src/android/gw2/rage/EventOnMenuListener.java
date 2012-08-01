/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;

/**
 *
 * @author isen
 */
public class EventOnMenuListener  implements TabListener{
    private Activity ac;
    
    public EventOnMenuListener(Activity ac){
        this.ac = ac;
    }
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        this.onTabSelected(tab, ft);
    }

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ScrollView sv =new ScrollView(this.ac.getBaseContext());
        String lien = "http://www.guildwars2-rage.com/rage/site/api/event/";
        EventManager handler = new EventManager();
        ViewGroup v = (ViewGroup)new LinearLayout(this.ac.getLayoutInflater().getContext());
        sv.addView(v);
        //setContentView(sv);
        this.ac.setContentView(sv);
        GetNetworkInfo task = new GetNetworkInfo(v,this.ac.getLayoutInflater(), handler);
        task.execute(new String[] { lien });
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
