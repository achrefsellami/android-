package com.example.ramzi.customerinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SeatCheckingActivity extends AppCompatActivity {
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(intent.getIntExtra("layout", R.layout.activity_seat_checking));
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
