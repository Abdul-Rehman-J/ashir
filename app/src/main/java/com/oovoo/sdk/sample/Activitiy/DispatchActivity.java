package com.oovoo.sdk.sample.Activitiy;

import android.app.Activity;
import android.os.Bundle;

import com.parse.ParseUser;

/**
 * Created by TOSHIBA on 13.2.2016. Şubat
 * Dont worry !
 */
public class DispatchActivity extends Activity {
    public DispatchActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ParseUser.getCurrentUser() != null){
            // go to login activity
        }else if (ParseUser.getCurrentUser() == null){
            // already logged in user, let the go main
        }
    }
}
