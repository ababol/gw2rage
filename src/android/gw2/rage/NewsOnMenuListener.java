/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;

/**
 *
 * @author isen
 */
public class NewsOnMenuListener implements TabListener{
private Activity ac;
    public NewsOnMenuListener(Activity ac){
        this.ac = ac;
    }
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
