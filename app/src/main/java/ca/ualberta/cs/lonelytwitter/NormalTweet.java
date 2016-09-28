package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Kelly on 2016-09-13.
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(String message){
        super(message);
    }

    public NormalTweet(String message,Date d){
        super(message,d);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }

    public int compareTo(Tweet x){

        if(this.getDate().before(x.getDate())){
            return 1;
        }
        else{
            return 0;
        }
    }


}//end of NormalTweet class
