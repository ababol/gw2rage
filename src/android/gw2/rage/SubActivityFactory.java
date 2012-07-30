/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;

/**
 *
 * @author isen
 */
public class SubActivityFactory {
    public static SubActivity getEventSubActivity(Activity ac){
        return new SubActivity("event",new EventOnMenuListener(ac));
    }
    public static SubActivity getNewsSubActivity(Activity ac){
        return new SubActivity("news",new NewsOnMenuListener(ac));
    }
}
