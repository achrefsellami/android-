package com.example.ramzi.avviatoo;

/**
 * Created by iness on 24/10/16.
 */
public class SeatInfo {
    int seatId;
    String seatClass;

    public SeatInfo() { }

    public SeatInfo(int seatId, String seatClass) {
        this.seatId = seatId;
        this.seatClass = seatClass;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
}
