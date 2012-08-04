/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.view.ViewGroup;

/**
 *
 * @author isen
 */
public abstract class Record {
    protected ViewGroup view;
     public ViewGroup getView(){
         return this.view;
     }
    
     public void setView(ViewGroup v){
         this.view = v;
     }
}
