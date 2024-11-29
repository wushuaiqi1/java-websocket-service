package com.ws.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");


    public static String CurrentTime(){
        return df.format(new Date());
    }
}
