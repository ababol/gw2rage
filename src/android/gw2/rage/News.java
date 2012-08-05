
package android.gw2.rage;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import android.util.Log;
/**
 *
 * @author artragis
 */
public class News extends Record{
    protected String title;
    protected int topic_id ;
    protected Date startdate;
    protected Date edit_time;
    protected String author_name ;
    protected String ip_address   ;
    protected Date post_date  ;
    protected String post;
    protected int queued ;
    protected String edit_name ;
    protected String post_key ;
    protected String post_htmlstate ;
    protected String post_edit_reason ;
    protected String post_bwoptions ;
    protected Date pdelete_time ;
    protected int post_field_int ;
    protected String post_field_t1 ;
    protected String post_field_t2 ;

    public News(String title, int topic_id, Date startdate, Date edit_time, String author_name, String ip_address, Date post_date, String post, int queued, String edit_name, String post_key, String post_htmlstate, String post_edit_reason, String post_bwoptions, Date pdelete_time, int post_field_int, String post_field_t1, String post_field_t2) {
        this.title = title;
        this.topic_id = topic_id;
        this.startdate = startdate;
        this.edit_time = edit_time;
        this.author_name = author_name;
        this.ip_address = ip_address;
        this.post_date = post_date;
        this.post = post;
        this.queued = queued;
        this.edit_name = edit_name;
        this.post_key = post_key;
        this.post_htmlstate = post_htmlstate;
        this.post_edit_reason = post_edit_reason;
        this.post_bwoptions = post_bwoptions;
        this.pdelete_time = pdelete_time;
        this.post_field_int = post_field_int;
        this.post_field_t1 = post_field_t1;
        this.post_field_t2 = post_field_t2;
    }
    public News(String title, int topic_id, String startdate, String edit_time,
            String author_name, String ip_address, String post_date, String post, int queued,
            String edit_name, String post_key, String post_htmlstate, String post_edit_reason, 
            String post_bwoptions, String pdelete_time, int post_field_int, String post_field_t1, 
            String post_field_t2) throws ParseException{
        SimpleDateFormat parsingFormat = new SimpleDateFormat("y-M-d k:m:s");
        this.title = title;
        this.topic_id = topic_id;
        this.startdate = parsingFormat.parse(startdate);
        this.edit_time = parsingFormat.parse(edit_time);
        this.author_name = author_name;
        this.ip_address = ip_address;
        this.post_date = parsingFormat.parse(post_date);
        this.post = post;
        this.queued = queued;
        this.edit_name = edit_name;
        this.post_key = post_key;
        this.post_htmlstate = post_htmlstate;
        this.post_edit_reason = post_edit_reason;
        this.post_bwoptions = post_bwoptions;
        this.pdelete_time = parsingFormat.parse(pdelete_time);
        this.post_field_int = post_field_int;
        this.post_field_t1 = post_field_t1;
        this.post_field_t2 = post_field_t2;
    }
    
    public News() {
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getEdit_name() {
        return edit_name;
    }

    public Date getEdit_time() {
        return edit_time;
    }

    public String getIp_address() {
        return ip_address;
    }

    public Date getPdelete_time() {
        return pdelete_time;
    }

    public String getPost() {
        return post;
    }

    public String getPost_bwoptions() {
        return post_bwoptions;
    }

    public Date getPost_date() {
        return post_date;
    }

    public String getPost_edit_reason() {
        return post_edit_reason;
    }

    public int getPost_field_int() {
        return post_field_int;
    }

    public String getPost_field_t1() {
        return post_field_t1;
    }

    public String getPost_field_t2() {
        return post_field_t2;
    }

    public String getPost_htmlstate() {
        return post_htmlstate;
    }

    public String getPost_key() {
        return post_key;
    }

    public int getQueued() {
        return queued;
    }

    public Date getStartdate() {
        return startdate;
    }

    public String getTitle() {
        return title;
    }

    public int getTopic_id() {
        return topic_id;
    }
    
}
