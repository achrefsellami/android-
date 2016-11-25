package com.example.ramzi.customerinfo;

/**
 * Created by ramzi on 11/22/16.
 */

public class Flight {
    private String name;
    private String id;
    private String from;
    private String to;
    private String date;

    public Flight(String name, /*String id,*/ String from, String to, String date) {
        this.name = name;
        //this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
