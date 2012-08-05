/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.ArrayList;
/**
 *
 * @author artragis
 */
abstract public class EventView extends RecordView{
    protected Event event;
    protected Activity activity;
    public EventView(Event e,Activity ac){
        super(ac);
        this.event=e;
        this.activity = ac;
    }
    
    public static class ListOnClickListener implements OnClickListener{
        protected Event event;
        protected Activity activity;
        public ListOnClickListener(Event e,Activity ac){
            this.event=e;
            this.activity = ac;
        }


        public void onClick(View v) {
            ScrollView sv =new ScrollView(this.activity.getBaseContext());
        String lien = "http://www.guildwars2-rage.com/rage/site/api/event/";
        EventManager handler = new EventManager();

        //setContentView(sv);
        this.activity.setContentView(sv);
        GetNetworkInfo task = new GetNetworkInfo(sv,this.activity, handler,new EventFullViewFactory());
        task.execute(new String[] { lien });
        }
        
    }
}
