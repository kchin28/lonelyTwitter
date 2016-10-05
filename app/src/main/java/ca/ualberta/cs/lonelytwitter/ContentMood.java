package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Subclass of mood, describing a 'content' mood.
 * @see Mood
 *
 */
public class ContentMood extends Mood {

    /**
     * default constructor that sets date to default from parent class: Mood
     */
    public ContentMood(){
        super();
    }

    /**
     *constructor that sets date to a user given date argument taken from parent class: Mood
     */
    public ContentMood(Date date){
        super(date);
    }

    /**
     * Describes this class's mood.
     * @return String describing currentMood
     */
    public String returnCurrentMood(){
        return("Content");
    }
}
