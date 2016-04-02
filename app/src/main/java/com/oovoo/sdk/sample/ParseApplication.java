package com.oovoo.sdk.sample;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

//okay i got it wait
//here it will say parseapplication is never used
public class ParseApplication extends Application {
 
    @Override
    public void onCreate() {
        super.onCreate();
 
        // Add your initialization code here
        Parse.initialize(this,"mpveVhLuGQVkPq5WYULIlJkuQUU7LQLMYzycbUpJ", "m0gZVWK0SIGtz10YVLqZ55qwvGmUDttUgoCas3YJ");
 
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
 
        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);
 
        ParseACL.setDefaultACL(defaultACL, true);
    }
 
}