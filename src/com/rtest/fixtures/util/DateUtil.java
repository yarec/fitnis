package com.rtest.fixtures.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
    int day = 0;
    String format= "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public DateUtil(){ }
    public DateUtil(int day){
        this.day = day;
    }

    public String formatdate(String f){
        return formatdate(f, 0, 0);
    }

    public String formatdate(String f, int type, int add){
        GregorianCalendar gc=new GregorianCalendar();
        gc.add(type, add);
        SimpleDateFormat format = new SimpleDateFormat(f);
        return format.format(gc.getTime());
    }

    public String addday(){
        return  formatdate(format, Calendar.DAY_OF_MONTH, day);
    }

    public String addhour(){
        return  formatdate(format, Calendar.HOUR_OF_DAY, day);
    }

    public String today(){
        return  formatdate(format);
    }

    public long time() {
        return System.currentTimeMillis();
    }


    public String test(){
        return "2012-12-12";
    }

}
