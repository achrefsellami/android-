package com.example.ramzi.customerinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Intent i = getIntent();
        TextView tv = (TextView) findViewById(R.id.hello);
        String [] info = i.getStringArrayExtra("infos");
        tv.setText("Hello " + info[1] + " " + info[2]);
    }
}
