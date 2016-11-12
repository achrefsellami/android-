package com.example.ramzi.customerinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bs = (Button) findViewById(R.id.bs);
        bs.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText iid = (EditText) findViewById(R.id.id);
                String id = iid.getText().toString();
                new FetchCustomerTask(MainActivity.this).execute(id);
            }
        });
    }
}
