package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;


    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void setUp() throws Exception{
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity",LonelyTwitterActivity.class); //check if we are in the correct activity
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body),"Test Tweet!"); //gets the edittext
        solo.clickOnButton("Save"); //hit the save button

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));

    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class); //check if we are in the correct activity
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!"); //gets the edittext
        solo.clickOnButton("Save"); //hit the save button

        solo.waitForText("Test Tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());


        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class); //check if we are in the correct activity
        TextView test = (TextView) solo.getView(R.id.EditTweetTextView);
        assertTrue(test.getText().toString().contains("Test Tweet!"));

        //  assertTrue(solo.waitForText("Test Tweet!"));

        // solo.goBack();
        //  solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        //tests are not guarenteed to run in the order that theyre written
    }
        public void tearDown() throws Exception {
            solo.finishOpenedActivities();
        }

}//end