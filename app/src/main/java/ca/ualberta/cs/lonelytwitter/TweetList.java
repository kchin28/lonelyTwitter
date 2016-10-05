package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TweetList uses the functionality of ArrayList's to contain Tweets.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Must determine if the list already contains an instance of the given tweet using equals().
     * Returns true if the given tweet has already been added to the list.
     * Returns false if the given tweet instance does not in the list.
     * To be used to test if a tweet has already been added.
     * @param a Of type Tweet
     * @return boolean
     */
    public boolean hasTweetLabAssignment(Tweet a){
        return tweets.equals(a);
    }

    /**
     * Adds the given tweet into the list.
     * @param tweet the tweet to be added to the list.
     * @throws IllegalArgumentException
     */
    public void add(Tweet tweet) throws IllegalArgumentException{

        for(int i=0; i<tweets.size();i++){
           if (   (tweet.getMessage().equals(tweets.get(i).getMessage())) && (tweet.getDate().equals(tweets.get(i).getDate())) )
           {
                throw new IllegalArgumentException();
           }
        }
        tweets.add(tweet);
    }

    /**
     * Determines if a tweet has the given tweet using contains().
     * @param tweet
     * @return boolean
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * Given an index, returns the Tweet at that position in the list.
     * @param i of type integer.
     * @return Tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     *
     * Deletes the given tweet from the list.
     * @param a the Tweet to be removed.
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Returns a reference to a copy of the contents of the tweet.
     * Original tweetList will not be modified.
     * @return ArrayList of tweets
     */
    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> tweetsClone = new ArrayList<Tweet>();
        tweetsClone.addAll(tweets);
        Collections.sort(tweetsClone);
        return tweetsClone;
    }

    /**
     * Removes the given tweet from the list.
     * @param t Tweet to be removed
     */
    public void removeTweet(Tweet t){
        tweets.remove(t);
    }

    /**
     * Describes the amount of tweets inside the list.
     * @return an integer representing the size
     */
    public int getCount(){
        return tweets.size();
    }


}
