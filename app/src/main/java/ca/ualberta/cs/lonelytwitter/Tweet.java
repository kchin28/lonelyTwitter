package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;


/**
 * An Abstract class that defines Tweet. Tweets contain a message, a creation date and a list of Moods.
 */
public abstract class Tweet implements Comparable<Tweet>{
    private String message;
    private Date date;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    //overloaded constructor
    /**
     * A tweet requires a user defined string. The date will be automatically filled.
     * @param message Type String that is user defined
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Can give a different date for the time of creation.
     *
     * @param message user defined string
     * @param date the time of creation can be specified
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    //start methods

    /**
     * Abstract method to determine if this tweet is important.
     * @return
     */
    public abstract Boolean isImportant();

    /**
     * Changes the message from the one given at creation.
     * The given message cannot be longer than 140 characters.
     * @param message the message that will replace the one given previously
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     *  A getter method for message.
     * @return String message
     */
    public String getMessage() {
        return message;
    }

    /**
     *  A setter method for date. The given date will replace the one given previously.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter method for date.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     *  A getter method for message.
     * @return String message
     */
    public void  addMood(Mood mood){
        moodList.add(mood);
    }

    /**
     * Not currently functional. Goes through the list of moods and displays each one contained in the list.
     */
    public void displayMood(){
        for(int i=0; i<moodList.size();i++){
            //System.out.println(moodList[i].returnCurrentMood());
        }
    }

    /**
     * Provides the message and the date of the tweet.
     * @return String represention of the tweet
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message ;
    }



}//end of tweet class
