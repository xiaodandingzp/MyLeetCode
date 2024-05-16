package com.example.myleetcode.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timer {

    public String getTime() {
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        dff.setTimeZone(TimeZone.getTimeZone("GMT+08"));

        String ee = dff.format(new Date());
        return ee;
    }
}
