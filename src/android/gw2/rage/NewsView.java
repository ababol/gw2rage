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
abstract public class NewsView extends RecordView{
    protected News news;
    protected Activity activity;
    public NewsView(News n,Activity ac) {
        super(ac);
        this.activity=ac;
        this.news=n;
    }
    
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
