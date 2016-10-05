package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Abstract class describing mood. Will be defined in each tweet.
 */
public abstract class Mood {
    private Date date;
    //private String mood;
/**
 * creation date of mood will be automatically filled.
 * */
    public Mood(){
        this.date = new Date();
    }

    /**
     * Constructs a mood object with a given date
     * @param date can give a date to replace the actual creation date
     */
    public Mood(Date date){
        this.date = date;
    }

    /**
     * Abstract method string that describes the mood of the tweet
     * @return String description of mood
     */
    public abstract String returnCurrentMood();

    /**
     * getter method for date
     * @return date of mood
     */
    public Date getDate() {
        return date;
    }

    /**
     * setter method for date
     * @param date to replace previously given date.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}//end of Mood
