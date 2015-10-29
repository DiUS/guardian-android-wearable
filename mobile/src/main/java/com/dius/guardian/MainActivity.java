package com.dius.guardian;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setDisplayShowTitleEnabled(false);
//        getActionBar().setIcon(R.drawable.banner);
//        getActionBar().setBackgroundDrawable(new BitmapDrawable(R.drawable.banner));

        ImageView imgView = (ImageView) findViewById(R.id.banner);
        imgView.setImageResource(R.drawable.banner);

//        ImageView alertView = (ImageView) findViewById(R.id.alertView);
//        alertView.setImageResource(R.drawable.alert);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void sendDataPressed(View view) {

        Log.i("Main", "sendDataPressed");
        new RetrieveEmergencyTask().execute("");
        Log.i("Main", "Have sendDataPressed");
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
