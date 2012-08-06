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
public class NewsFullViewFactory extends RecordViewFactory{

    @Override
    RecordView generateView(Record r, Activity ac) {
        return new NewsFullView((News)r,ac);
    }

    @Override
    RecordView inflateView(LayoutInflater inflater) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
