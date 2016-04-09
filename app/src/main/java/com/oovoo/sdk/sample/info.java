package com.oovoo.sdk.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.oovoo.sdk.oovoosdksampleshow.R;
import com.oovoo.sdk.sample.chating_files.MainActivity_chat;
import com.oovoo.sdk.sample.ui.SampleActivity;

public class info extends AppCompatActivity {
TextView tv,tv2;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        // Attaching the layout to the toolbar object
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        tv = ((TextView) findViewById(R.id.textView5));
        tv2 = ((TextView) findViewById(R.id.textView6));
        tv.setText(getIntent().getStringExtra("name"));
        name=tv.getText().toString();
        Log.i("name", name);
        tv2.setText(getIntent().getStringExtra("genre"));
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_msg);
        ImageButton call_activity= (ImageButton) findViewById(R.id.ib_call);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        call_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SampleActivity.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_chat.class);
                startActivity(intent);
            }
        });

    }


}
