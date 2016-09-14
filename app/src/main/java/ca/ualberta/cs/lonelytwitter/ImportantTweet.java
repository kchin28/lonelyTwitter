package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Kelly on 2016-09-13.
 */
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message){
        super(message);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}//end of ImportantTweet class
