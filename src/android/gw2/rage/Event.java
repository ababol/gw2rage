/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import android.util.Log;
/**
 *
 * @author artragis
 */
public class Event extends Record{
    private Date dateEvent;
    private int placeTotal;
    private String nomEvent;
    private int coutInscription;
    private int id;
    
    public Event(int id,Date dateEvent, String nomEvent, int placeTotal, int coutInscription){
        this.id = id;
        this.dateEvent = dateEvent;
        this.nomEvent = nomEvent;
        this.placeTotal = placeTotal;
        this.coutInscription = coutInscription;
    }
    /**
     * 
     * @param id
     * @param dateEvent
     * @param nomEvent
     * @param placeTotal
     * @param coutInscription 
     * @throws ParseException when string date is unparsable
     */
    public Event(int id,String dateEvent, String nomEvent, int placeTotal, int coutInscription)
    throws ParseException{
        this.id = id;
        SimpleDateFormat parsingFormat = new SimpleDateFormat("y-M-d k:m:s");
        this.dateEvent = parsingFormat.parse(dateEvent);
        this.nomEvent = nomEvent;
        this.placeTotal = placeTotal;
        this.coutInscription = coutInscription;
    }
    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("d/M/y k:m");
        String stringified = this.nomEvent+" : " +"le "+format.format(this.dateEvent);
        stringified += " "+this.placeTotal + " "+this.coutInscription+"po";
        return stringified;
    }

    public int getCoutInscription() {
        return coutInscription;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public int getId() {
        return id;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public int getPlaceTotal() {
        return placeTotal;
    }
    
}
