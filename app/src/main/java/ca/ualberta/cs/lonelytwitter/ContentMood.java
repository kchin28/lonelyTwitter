package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Kelly on 2016-09-13.
 */
public class ContentMood extends Mood {

    //default constructor that sets date to default from parent class: Mood
    public ContentMood(){
        super();
    }

    //constructor that sets date to a user given date argument taken from parent class: Mood
    public ContentMood(Date date){
        super(date);
    }

    public String returnCurrentMood(){
        return("Content");
    }
}
