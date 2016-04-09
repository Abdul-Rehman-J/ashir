package com.oovoo.sdk.sample.chating_files;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.oovoo.sdk.oovoosdksampleshow.R;
import com.oovoo.sdk.sample.MainActivity;
import com.oovoo.sdk.sample.MongoHQ.SaveAsyncTask;
import com.oovoo.sdk.sample.MyContact;

public class MainActivity_chat extends AppCompatActivity {
Toolbar toolbar;
    String imgDecodableString;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_chat);
        toolbar = (Toolbar) findViewById(R.id.toolbar2); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        editText = (EditText) findViewById(R.id.message_input);
        Log.i("edittext", editText.toString());

        ImageButton imageButton = (ImageButton) findViewById(R.id.send_button);
imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        MyContact contact = new MyContact();
        contact.first_name = editText.getText().toString();

        SaveAsyncTask tsk = new SaveAsyncTask();
        tsk.execute(contact);

    }
});

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.d("onCreateOptionsMenu", "create menu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.socket_activity_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.action_attach:
                Log.d("onOptionsItemSelected", "action_attach");
                openGallery();
                return true;
            case R.id.action_capture:
                Log.d("onOptionsItemSelected", "action_capture");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void openGallery() {
        Intent galleryintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryintent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK
                && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);

            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();

            ChatFragment fragment = (ChatFragment) getFragmentManager().findFragmentById(R.id.chat);
            fragment.sendImage(imgDecodableString);
        }
    }
}