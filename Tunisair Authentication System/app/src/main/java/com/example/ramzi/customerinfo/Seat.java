package com.example.ramzi.customerinfo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by iness on 17/10/16.
 */
public class Seat extends ImageView {

    Boolean state;

    public Seat(Context context, AttributeSet attrs) {
        super(context, attrs);

    TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Seat,0,0);
        try {
            state= a.getBoolean(R.styleable.Seat_statex, false);
        }finally {
            a.recycle();
        }
    }


    public Seat(Context context) {
        super(context);

    }

    public boolean isOccupied() {
        return state;
    }
    public void switchState(){
        state=!state;
        invalidate();
        requestLayout();
    }
    public void setState(boolean state) {
        this.state = state;

    }

}
