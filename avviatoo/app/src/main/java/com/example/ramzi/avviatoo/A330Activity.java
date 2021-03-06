package com.example.ramzi.avviatoo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class A330Activity extends AppCompatActivity {

    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a330);
    }
    public void onClick(View view){
        Seat seat = (Seat) view;
        if(seat.isOccupied()){
            seat.setImageResource(R.drawable.k);
            x--;
        }
        else{
            seat.setImageResource(R.drawable.kk);
            x++;
        }
        seat.switchState();
        Toast.makeText(this,x+" places are occupied.",Toast.LENGTH_SHORT).show();
    }
}
