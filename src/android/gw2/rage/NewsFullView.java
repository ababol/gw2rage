/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 * @author isen
 */
public class NewsFullView extends NewsView{

    public NewsFullView(News n, Activity ac) {
        super(n, ac);
    }

    @Override
    public ViewGroup drawView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ViewGroup drawView(ViewGroup parent) {
        this.activity.getLayoutInflater().inflate(R.layout.full_news, parent);
        TextView title = (TextView)this.activity.findViewById(R.id.titre_news);
        title.setText(this.news.getTitle());
        TextView infos = (TextView)this.activity.findViewById(R.id.info_news);
        infos.setText("Par "+this.news.getAuthor_name()+" le "+this.news.getStartdate().toString());
        TextView corps = (TextView)this.activity.findViewById(R.id.contenu_news);
        corps.setText(this.news.getPost());
        
        return parent;
    }
    
}
