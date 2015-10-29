package com.dius.guardian;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RetrieveEmergencyTask extends AsyncTask<String, Void, Emergency> {


    protected Emergency doInBackground(String... urls) {
        makeHttpRequest();
        return null;
    }

    protected void makeHttpRequest() {
        Log.i("Main", "calling1");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NodeService service = retrofit.create(NodeService.class);
        Call<Emergency> emergencyCall = service.emergency();
        try {
            Response<Emergency> execute = emergencyCall.execute();
            Emergency emergency = execute.body();
            Log.i("Main", "My emergency " + emergency);
        } catch (IOException e) {
            Log.e("Main", "error " + e.getLocalizedMessage(), e);
        }
        Log.i("Main", "Exiting " + emergencyCall);
    }

    protected void onPostExecute(Emergency emergency) {

    }
}
