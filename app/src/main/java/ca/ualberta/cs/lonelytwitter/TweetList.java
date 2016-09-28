package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kelly on 2016-09-27.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();

    public boolean hasTweetLabAssignment(Tweet a){
        return tweets.equals(a);
    }
    public void add(Tweet tweet) throws IllegalArgumentException{

        for(int i=0; i<tweets.size();i++){
           if (   (tweet.getMessage().equals(tweets.get(i).getMessage())) && (tweet.getDate().equals(tweets.get(i).getDate())) )
           {
                throw new IllegalArgumentException();
           }
        }
        tweets.add(tweet);

    }
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet a) {
        tweets.remove(a);
    }

    public ArrayList<Tweet> getTweets(){

        ArrayList<Tweet> tweetsClone = new ArrayList<Tweet>();
        tweetsClone.addAll(tweets);
        Collections.sort(tweetsClone);
        return tweetsClone;
    }

    public void removeTweet(Tweet t){
        tweets.remove(t);
    }

    public int getCount(){
        return tweets.size();
    }


}
