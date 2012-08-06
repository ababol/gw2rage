/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

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
    public static class ListOnClickListener implements OnClickListener{
        protected News news;
        protected Activity activity;
        public ListOnClickListener(News n,Activity ac){
            this.news=n;
            this.activity = ac;
        }
        public void onClick(View v) {
            ScrollView sv =new ScrollView(this.activity.getBaseContext());
            String lien = "http://www.guildwars2-rage.com/rage/site/api/news/"+this.news.getTopic_id();
            NewsManager handler = new NewsManager();

            //setContentView(sv);
            this.activity.setContentView(sv);
            GetNetworkInfo task = new GetNetworkInfo(sv,this.activity, handler,new NewsFullViewFactory());
            task.execute(new String[] { lien });
        }
    }
}
