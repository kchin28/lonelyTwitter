package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * An interface that allows tweets to display its own message and its creation date.
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();

}
