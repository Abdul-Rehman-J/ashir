package com.oovoo.sdk.sample.Activitiy;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.oovoo.sdk.oovoosdksampleshow.R;
import com.oovoo.sdk.sample.Model.TouchEffect;


/**
 * Created by TOSHIBA on 13.2.2016. Şubat
 * Dont worry !
 */
public class CustomActivity extends FragmentActivity implements View.OnClickListener {

    public static TouchEffect TOUCH = new TouchEffect();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setupActionBar();
    }

    private void setupActionBar() {
        final ActionBar actionBar = getActionBar();
        if (actionBar == null)
            return;

        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
actionBar.setLogo(R.drawable.c_logo);
        // TODO : addded here more customize, setLogo, setBackground vs vs..
    }

    public View setTouchNClick(int id) {
        View v = setClick(id);
        if (v != null) {
            v.setOnTouchListener(TOUCH);
        }
        return v;
    }

    private View setClick(int id) {
        View v = findViewById(id);
        if (v != null) {
            v.setOnClickListener(this);
        }
        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
