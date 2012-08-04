/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
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
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
}
