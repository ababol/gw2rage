/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.view.LayoutInflater;

/**
 *
 * @author isen
 */
public class EventListViewFactory extends RecordViewFactory{

    @Override
    RecordView generateView(Record e,Activity ac) {
        return new EventListView((Event)e,ac);
    }

    @Override
    RecordView inflateView(LayoutInflater inflater) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
