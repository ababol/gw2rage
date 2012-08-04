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
abstract public class RecordViewFactory {
    abstract RecordView generateView(Record r,Activity ac);
    abstract RecordView inflateView(LayoutInflater inflater);
    
}
