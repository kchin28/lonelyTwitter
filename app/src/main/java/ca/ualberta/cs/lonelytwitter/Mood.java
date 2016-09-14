package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Kelly on 2016-09-13.
 */
public abstract class Mood {
    private Date date;
    //private String mood;

    //constructor with default date
    public Mood(){
        this.date = new Date();
    }

    //constructor which takes in a user given date argument
    public Mood(Date date){
        this.date = date;
    }

    public abstract String returnCurrentMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}//end of Mood
