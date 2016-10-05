package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * TweetListTest tests the functionality of TweetList.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>{

    /**
     * This constructor takes an instance of the LonelyTwitterActivity class and passes it to
     * the parent's constructor.
     * @see ActivityInstrumentationTestCase2
     */
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    /**
     * Tests Adding a tweet to the list.
     */
    public void testAddTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));

    }

    /**
     * Tests if TweetList can properly decide if it contains a particular tweet.
     */
    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello!");
        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.add(a);
        list.add(b);

        assertEquals(a,list.getTweet(0));
        assertEquals(b,list.getTweet(1));

    }

    public void  testDeleteTweet(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        list.add(a);
        assertTrue(list.hasTweet(a));
        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

// lab assignment starts here
    public void testAddDuplicateTweet(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hello!");
        list.add(a);

        //http://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
        Throwable e = null;
        try {
            list.add(b);
        }
        catch(Throwable E){
            e=E;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    public void testChronologicalOrder(){
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("a",new Date(1));
        Tweet b = new NormalTweet("b",new Date(2));

        list.add(a);
        list.add(b);
        list.getTweets();

        assertTrue(list.getTweet(0).getDate().before(list.getTweet(1).getDate()));

    }

    public void testEquals(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("a");
        list.add(a);
        assertTrue(list.getTweet(0).equals(a));
    }

    public void testRemove(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("a");

        list.removeTweet(a);

        assertFalse(list.hasTweetLabAssignment(a));
    }

    public void testCount(){
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("a");
        Tweet b = new NormalTweet("b");

        list.add(a);
        list.add(b);
        assertEquals(2,list.getCount());
    }




}//end of class
