package com.oovoo.sdk.sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.oovoo.sdk.oovoosdksampleshow.R;
import com.oovoo.sdk.sample.app.ooVooSdkSampleShowApp;
import com.oovoo.sdk.sample.frontend.Adapter;
import com.oovoo.sdk.sample.frontend.Item;
import com.oovoo.sdk.sample.ui.SampleActivity;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    Toolbar toolbar;
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private ProgressDialog dialog;
    private List<Item> array = new ArrayList<Item>();
    private ListView listView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attachment widgets
        toolbar = (Toolbar) findViewById(R.id.toolbar1); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_launcher);

        listView = (ListView) findViewById(R.id.list_item1);
        adapter=new Adapter(this,array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item item=array.get(position);
                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();
               String info = item.getTitle();
                Intent intent  = new Intent(MainActivity.this,info.class);
                intent.putExtra("name", info);
                intent.putExtra("genre", item.getYear());
                startActivity(intent);
            }
        });
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        //Creat volley request obj
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();
                //parsing json
                for(int i=0;i<response.length();i++){
                    try{
                        JSONObject obj=response.getJSONObject(i);
                        Item item=new Item();
                        item.setTitle(obj.getString("title"));
                        item.setImage(obj.getString("image"));
                        item.setRate(((Number) obj.get("rating")).doubleValue());
                        item.setYear(obj.getString("releaseYear"));

                        //genre is json array
                        JSONArray genreArray=obj.getJSONArray("genre");
                        ArrayList<String> genre=new ArrayList<String>();
                        for(int j=0;j<genreArray.length();j++){
                            genre.add((String) genreArray.get(j));
                        }
                        item.setGenre(genre);

                        //add to array
                        array.add(item);
                    }catch(JSONException ex){
                        ex.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        ooVooSdkSampleShowApp.getmInstance().addToRequesQueue(jsonArrayRequest);

               /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout=(DrawerLayout)

        findViewById(R.id.drawerLayout);

        mNavigationView=(NavigationView)

        findViewById(R.id.shitstuff);


        /**
         * Setup click events on the Navigation View Items.
         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected (MenuItem menuItem){
            mDrawerLayout.closeDrawers();


            if (menuItem.getItemId() == R.id.nav_item_inbox) {
                ParseUser.logOut();
                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
                finish();


            }

            if (menuItem.getItemId() == R.id.nav_item_sent)

            {
                Intent i = new Intent(MainActivity.this, SampleActivity.class);
                startActivity(i);

            }

            if (menuItem.getItemId() == R.id.nav_item_inbox)

            {

            }

            return false;
        }
                                                          }
        );
    }
    public void hideDialog(){
        if(dialog !=null){
            dialog.dismiss();
            dialog=null;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //no inspection SimplifiableIfStatement
        if (id == R.id.menu_settings) {
            Intent intent = new Intent(MainActivity.this, SampleActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_attach) {
            Log.d("onOptionsItemSelected", "action_attach");
        }

        if (id == R.id.action_capture) {
            Log.d("onOptionsItemSelected", "action_capture");
        }
        return super.onOptionsItemSelected(item);
    }



}