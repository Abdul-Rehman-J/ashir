package com.oovoo.sdk.sample.Model;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by TOSHIBA on 13.2.2016. Şubat
 * Dont worry !
 */
public class TouchEffect implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Drawable background=v.getBackground();
            background.mutate();
            background.setAlpha(150);
            v.setBackground(background);
        }else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL){
            Drawable background = v.getBackground();
            background.setAlpha(255);
            v.setBackground(background);
        }
        return false;
    }
}
