package com.example.bodytrack;

import java.util.Date;

public class point_value {
    String kgValue;
    Date dateValue;
    String key;

    public point_value(){
    }

    public point_value(String kgValue, Date dateValue) {
        this.kgValue = kgValue;
        this.dateValue = dateValue;
    }

    public point_value(String kgValue, Date dateValue, String key){
        this.kgValue=kgValue;
        this.dateValue=dateValue;
        this.key = key;
    }
    public String getkgValue(){
        return kgValue;
    }
    public Date getdateValue(){
        return dateValue;
    }

    public String getKey() {
        return key;
    }
}
