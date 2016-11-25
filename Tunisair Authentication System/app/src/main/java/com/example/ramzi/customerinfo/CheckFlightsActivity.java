package com.example.ramzi.customerinfo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckFlightsActivity extends AppCompatActivity {
    ArrayList<Flight> flightArrayList;
    FlightsListAdapter flightsListAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_flights);
        flightsListAdapter = new FlightsListAdapter(this);
        new FetchFlights().execute("2222");
        ((ListView) findViewById(R.id.flightsList)).setAdapter(flightsListAdapter);

    }


    class FetchFlights extends AsyncTask<String, Void, List<Flight>>{
        String LOGTAG = FetchFlights.class.getSimpleName();
        @Override
        protected List<Flight> doInBackground(String... params) {
            String pncId = params[0];
            try {

                URL url = new URL("http://tunisai.azurewebsites.net/api/pncs/2812");
                HttpURLConnection cnx = (HttpURLConnection)url.openConnection();
                cnx.setReadTimeout(10000);
                cnx.setConnectTimeout(15000);
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
                flightArrayList = new ArrayList<>();
                JSONObject jsonObject = new JSONObject(output.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("Vols");
                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject fi = jsonArray.getJSONObject(i);
                    Flight f = new Flight(fi.getString("Reference"),fi.getString("AeroprtDepart"),
                            fi.getString("AeroportArriver"), fi.getString("Date"));
                    flightArrayList.add(f);
                }
                flightArrayList.add(new Flight("A320","Tunis","Atlanta","2016-12-1"));
                flightArrayList.add(new Flight("A320","Tunis","Atlanta","2016-12-1"));
                flightArrayList.add(new Flight("A330","Tunis","Washington","2017-1-1"));
                //JSONObject json = new JSONObject(output.toString());
                return flightArrayList;

            } catch (Exception e) {
                Log.d(LOGTAG, Log.getStackTraceString(e));
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Flight> flights) {
            super.onPostExecute(flights);
            Log.e("flightArrayList",Arrays.toString(flightArrayList.toArray()));
            for (Flight f : flights) {
               flightsListAdapter.add(f);
            }
            flightsListAdapter.notifyDataSetChanged();
        }
    }
}
