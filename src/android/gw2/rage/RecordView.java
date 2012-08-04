/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.view.ViewGroup;

/**
 *
 * @author isen
 */
abstract public class RecordView extends ViewGroup{
    public RecordView(Activity ac){
        super(ac);
    }
    abstract public ViewGroup drawView();
    abstract public ViewGroup drawView(ViewGroup parent);
}
