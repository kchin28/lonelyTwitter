package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kelly on 2016-09-13.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    //constructor
    public Tweet(String message){
        this.message=message;
    }

    //overloaded constructor
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void  addMood(Mood mood){
        moodList.add(mood);
    }

    public void displayMood(){
        for(int i=0; i<moodList.size();i++){
            //System.out.println(moodList[i].returnCurrentMood());
        }
    }
}
