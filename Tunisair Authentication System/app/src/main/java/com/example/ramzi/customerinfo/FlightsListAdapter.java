package com.example.ramzi.customerinfo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ramzi on 11/22/16.
 */

public class FlightsListAdapter extends ArrayAdapter <Flight>{
    private static final int HEADER=0,WHITE_ITEM=1,RED_ITEM=2;
    private Context context;
    Flight f;
    public static final String FLIGHT_TYPE_A320 = "A320";
    public static final String FLIGHT_TYPE_A330 = "A330";
    @Override
    public int getItemViewType(int position) {
        if(position%2==0) return RED_ITEM;
        else return WHITE_ITEM;
    }
    //constructor, call on creation
    public FlightsListAdapter(Context context) {
        super(context, 0);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        f = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.flight_list_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.flightInfo)).setText(f.getName());
        ImageView iv = (ImageView) convertView.findViewById(R.id.image);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SeatCheckingActivity.class);
                switch (f.getName()) {
                    case "A322":
                        intent.putExtra("layout", R.layout.activity_a320);
                        break;
                    case FLIGHT_TYPE_A330:
                        intent.putExtra("layout", R.layout.activity_a330);
                        break;
                }

                context.startActivity(intent);
            }
        });
        if(getItemViewType(position)==WHITE_ITEM)
            convertView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        else if (getItemViewType(position)==RED_ITEM)
            convertView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        else
        {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        return convertView;
    }
}
