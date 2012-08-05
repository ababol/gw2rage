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
 * @author isen
 */
public class EventFullView extends EventView{

    public EventFullView(Event e, Activity ac) {
        super(e, ac);
    }
    
    @Override
    public ViewGroup drawView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ViewGroup drawView(ViewGroup parent) {
        
        ViewGroup v;
        
        v = (ViewGroup)this.activity.getLayoutInflater().inflate(R.layout.full_event, parent);
        TextView titre =(TextView)this.activity.findViewById(R.id.titre_event);
        TextView informations =(TextView) this.activity.findViewById(R.id.info_event);
        titre.setText(this.event.getNomEvent());
        informations.setText("Le "+this.event.getDateEvent().toString()+" "+this.event.getPlaceTotal()+
                "places au total. \n"
                + "coup de l'inscription : "+this.event.getCoutInscription()+"po");
        return v;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
