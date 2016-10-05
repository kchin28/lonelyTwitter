package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A subclass of Mood.
 * @see Mood
 * marks itself as Annoyed.
 */
public class AnnoyedMood extends Mood {

    /**
     * default constructor that sets date to default from parent class: Mood
     */
    public AnnoyedMood(){
        super();
    }

    /**
    *constructor that sets date to a user given date argument taken from parent class: Mood
    */
    public AnnoyedMood(Date date){
        super(date);
    }

    /**
     * Describes this class's mood.
     * @return String describing currentMood
     */
    public String returnCurrentMood(){
        return("Annoyed");
    }
}
