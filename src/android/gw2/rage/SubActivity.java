/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;
import com.actionbarsherlock.app.ActionBar.TabListener;
/**
 *
 * @author isen
 */
public class SubActivity {
    private String title;
    private TabListener listener;
    public SubActivity(String title,TabListener listener){
        this.title    = title;
        this.listener = listener;
    }

    public TabListener getListener() {
        return listener;
    }

    public void setListener(TabListener listener) {
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
