package com.example.ramzi.customerinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nussa on 28/09/16.
 */
public class FetchCustomerTask extends AsyncTask<String, Void, String[]> {
    WeakReference<Activity> mWeakActivity;
    String lastname,firstname,street,city;
    public FetchCustomerTask(Activity activity) {
        mWeakActivity = new WeakReference<Activity>(activity);
    }


    protected String[] doInBackground(String... param){
        try{
            String id = param[0];
            URL url = new URL("http://tunisair.azurewebsites.net/api/users/"+id);
            HttpURLConnection cnx = (HttpURLConnection)url.openConnection();
            cnx.setReadTimeout(10000 /* milliseconds */);
            cnx.setConnectTimeout(15000 /* milliseconds */);
            cnx.setRequestMethod("GET");
            cnx.setDoInput(true);
            cnx.connect();
            InputStream stream = cnx.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
            String s = "";
            StringBuffer output = new StringBuffer("");
            while ((s = buffer.readLine()) != null){
                output.append(s);
                Log.e("s",s);
            }
            Log.e("output",output.toString());

            JSONObject json = new JSONObject(output.toString());
            String [] person = new String[4];
            person[0] = json.getString("Email");
            person[1] = json.getString("FirstName");
            person[2] = json.getString("LastName");
            person[3] = json.getString("PassWord");

            return person;

        }
        catch (Exception e) {
            Log.e("hihi",e.getLocalizedMessage());
            return  null;
        }
    }
    protected void onPostExecute(String[] result) {
        Activity activity = mWeakActivity.get();
        Intent i = new Intent(activity, HelloActivity.class);
        i.putExtra("infos", result);
        activity.startActivity(i);


    }


}
