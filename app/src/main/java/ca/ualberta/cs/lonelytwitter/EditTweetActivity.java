package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);


        Bundle extras = getIntent().getExtras();
        String TweetString = extras.getString("Selected Tweet");

        TextView SelectedTweet = (TextView) findViewById(R.id.EditTweetTextView);
        SelectedTweet.setText(TweetString);
    }
}//end
