package ca.ualberta.cs.lonelytwitter;

/**
 * A subclass of Tweet. ImportantTweets will be marked as such.
 * @see Tweet
 */
public class ImportantTweet extends Tweet{
    /**
     * This constructor adds no further functionality than what is described in the parent class, Tweet
     * @param message the user defined string
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Will always return True for an ImportantTweet.
     * @return Boolean True
     */
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    /**
     * Compares the given tweet to see if their contents(creation date and message) are the same as
     * the current instance.
     * @param x
     * @return integer of 1 means yes the given tweet was a copy or 0 for no.
     */
    public int compareTo(Tweet x){

        if(this.getDate().before(x.getDate())){
            return 1;
        }
        else{
            return 0;
        }
    }

}//end of ImportantTweet class
