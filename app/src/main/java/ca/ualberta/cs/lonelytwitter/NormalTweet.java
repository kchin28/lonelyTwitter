package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * NormalTweet is a subclass of Tweet and also Implements Tweetable.
 * It should be used for regular activity and will not be marked as 'important.'
 * @see Tweet
 * @see Tweetable
 */
public class NormalTweet extends Tweet implements Tweetable {
    /**
     * This constructor makes a normalTweet with given string  parameter.
     *@param message this parameter is the String that the user provides in their tweet.
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * Constructor creates a NormalTweet and the date of creation can be chosen here.
     * @param message the user defined message contained inside the normalTweet
     * @param d Date describing when the NormalTweet was created
     */
    public NormalTweet(String message,Date d){
        super(message,d);
    }

    /**
     * Since normalTweets aren't important, this function will return false always.
     * @return Boolean that identifies this tweet as non important.
     */
    public Boolean isImportant(){
        return Boolean.FALSE;
    }

    /**
     * Given a tweet, a comparison will be made on the messages they contain and their creation date
     * to determine if they are copies of each other.
     * @param x tweet to be compared with
     * @return an integer describing whether the given tweet is a copy or not
     * @range 0,1
     */
    public int compareTo(Tweet x){

        if(this.getDate().before(x.getDate())){
            return 1;
        }
        else{
            return 0;
        }
    }


}//end of NormalTweet class
