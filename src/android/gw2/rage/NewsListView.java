/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @author isen
 */
public class NewsListView extends NewsView{

    public NewsListView(News n, Activity ac) {
        super(n, ac);
    }


    @Override
    public ViewGroup drawView() {
        return new LinearLayout(this.activity);
    }

    @Override
    public ViewGroup drawView(ViewGroup parent) {
        String chaine="";
        this.activity.
                getLayoutInflater().inflate(R.layout.eventlistview, parent);
        LinearLayout contener = (LinearLayout)parent.getChildAt(parent.getChildCount()-1);
        chaine += this.news.getTitle();
        chaine +=" par "+this.news.getAuthor_name();
        chaine +=" le "+this.news.getStartdate().toString();
        TextView vue= new TextView(this.activity);
        vue.setText(chaine);
        contener.addView(vue);
        contener.setOnClickListener(new NewsView.ListOnClickListener(this.news, this.activity));
        return parent;
    }
    
}
