package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Kelly on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(String message){
        super(message);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}//end of NormalTweet class
