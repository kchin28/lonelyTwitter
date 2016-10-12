/*
Copyright (c) 2016 Team 20, CMPUT 301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all or poarts of this code under terms and conditions of
University of Alberta and the Code of Student Behavior.
You can find a opy of the license at github.com/Team20
For Further Information, contact ...
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 *This is the main view class of LonelyTwitter project. It handles all user interactions
 * as well as file manipulations.
 * <pre> All the files are stored in the form of "json" files stored in Emulator, accessible
 * from Android Device Monitor.</pre>
 *
 */

public class LonelyTwitterActivity extends Activity {
    private Activity activity = this;
    /**
     * This is the file name that is being saved/loaded and contains all the tweets.
     * @see #loadFromFile()
     * @see #saveInFile()
     */

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;

    public ListView getOldTweetsList(){
        return oldTweetsList;
    }
    /**
     * Called when the activity is first created.
     * @param savedInstanceState This is an Android provided variable that provides extra
     *                            information to the current activity.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener()            {

                                          public void onClick(View v) {
                                              setResult(RESULT_OK);

                                              String text = bodyText.getText().toString();

                                              Tweet newTweet = new NormalTweet(text);

                                              tweetList.add(newTweet);
                                              adapter.notifyDataSetChanged();

                                              saveInFile();
                                              //              finish();
                                          }
                                      }
        );

        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener()            {

                                          public void onClick(View v) {
                                              setResult(RESULT_OK);
                                              tweetList.clear();
                                              adapter.notifyDataSetChanged();

                                              saveInFile();

                                          }
                                      }
        );

        oldTweetsList.setOnItemClickListener(new
                AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent,View view, int position, long id){
                        Intent intent = new Intent(activity,EditTweetActivity.class);
                        intent.putExtra("Selected Tweet",tweetList.get(position).toString());
                        startActivity(intent);
                    }

                });

    }

    /**
     * Called when the activity is being started up after being stopped. Such as when another activity
     * needs to take up the entire screen.
     */
    @Override
    protected void onStart() {

        super.onStart();

        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);

    }

    /**
     * This method loads the tweets from FILE_NAME and populates tweetList using Gson/json to implement
     * persistent data .
     * @throws FileNotFoundException
     * @exception RuntimeException
     */
    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {
            }.getType();

            tweetList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    /**
     * This method takes the tweetList and writes them to file to be saved locally on the emulator's
     * disk using gson/json.
     * @throws RuntimeException
     * @exception  FileNotFoundException
     */

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos)); // for efficiency

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }


    /**
     * onStop is called if another activity needs to take up the screen. No additional
     * functionality is added to the inherited method.
     */
    @Override
    public void onStop() {
        super.onStop();

    }
}//end of class