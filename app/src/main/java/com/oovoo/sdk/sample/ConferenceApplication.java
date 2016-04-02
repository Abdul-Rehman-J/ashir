package com.oovoo.sdk.sample;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by TOSHIBA on 13.2.2016. Şubat
 * Dont worry !
 */
public class ConferenceApplication extends Application {

    private String PARSE_APP_ID = "";   // TODO: you will sign up parse, create e new app, add the app id and client id here
    private String PARSE_CLI_ID = "";   // TODO:
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, PARSE_APP_ID, PARSE_CLI_ID);
    }
}
