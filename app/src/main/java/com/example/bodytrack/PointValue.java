package com.example.bodytrack;

public class PointValue {
    long xValue;
    int yValue;

    public PointValue(){
    }
    public PointValue(long XValue, int yValue){
        this.xValue=xValue;
        this.yValue=yValue;
    }
    public long getxValue(){
        return  xValue;
    }
    public int getyValue(){
        return yValue;
    }
}
