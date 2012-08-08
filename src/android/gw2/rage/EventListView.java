/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @author artragis
 */
public class EventListView extends EventView {
    public EventListView(Event e, Activity ac){
        super(e,ac);
    }
    
    @Override
    public ViewGroup drawView() {
        Log.d("affichage_no_arg",this.event.toString());
        LinearLayout contener = new LinearLayout(this.activity.getBaseContext());
        contener.setOnClickListener(new EventView.ListOnClickListener(this.event, this.activity));
        
        this.addView(contener);
        this.activity.setContentView(this);
        
        
        return contener;
    }
    @Override
    public ViewGroup drawView(ViewGroup parent) {
        Log.d("affichage",this.event.toString());
        this.activity.
                getLayoutInflater().inflate(R.layout.eventlistview, parent);
        LinearLayout contener = (LinearLayout)parent.getChildAt(parent.getChildCount()-1);
        contener.setOnClickListener(new EventView.ListOnClickListener(this.event, this.activity));
//        this.addView(contener);
        TextView desc = new TextView(this.activity);
        desc.setText(this.event.toString());
//        desc.setTextSize(2, 50);
        
        contener.addView(desc);
//        parent.addView(contener);
        
        return contener;
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
