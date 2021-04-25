package com.varvarigou.accepted.assignment.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    public static LocalTime convertToLocalTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static Date convertToDate(LocalTime localTime){
        Instant instant = localTime.atDate(LocalDate.of(1990, 1, 1)).
                atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
