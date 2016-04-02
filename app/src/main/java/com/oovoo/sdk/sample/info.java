package com.oovoo.sdk.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.oovoo.sdk.oovoosdksampleshow.R;
import com.oovoo.sdk.sample.chating_files.MainActivity_chat;
import com.oovoo.sdk.sample.ui.SampleActivity;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
      Toolbar  toolbar = (Toolbar) findViewById(R.id.toolbar3); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        //getting data from main activty and showing it in textviews
        final TextView tv = ((TextView) findViewById(R.id.textView5));
        TextView tv2 = ((TextView) findViewById(R.id.textView6));
        tv.setText(getIntent().getStringExtra("name"));
        tv2.setText(getIntent().getStringExtra("genre"));

        //imgbutton call activty
        ImageButton imageButton_call= (ImageButton) findViewById(R.id.ib_call);
        imageButton_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(info.this,SampleActivity.class);
                intent.putExtra("name", tv.toString());
                startActivity(intent);
            }
        });
        ImageButton imageButton_msg= (ImageButton) findViewById(R.id.ib_msg);
        imageButton_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(info.this,MainActivity_chat.class);
                intent.putExtra("name", tv.toString());
                startActivity(intent);
            }
        });
    }

}
