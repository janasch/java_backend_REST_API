package io.falcon.assignment.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public final class DateTimeHelper {
    // Ex: "2018-10-09 00:12:12+0100"
    private static DateTimeFormatter MsgDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

    public static LocalDateTime fromMsgFormattedString(String datetimestring){
        System.out.println(datetimestring);
        try{
            return LocalDateTime.parse(datetimestring, MsgDateTimeFormat);
        }catch(Exception e){
            return null;
        }
    }

    public static String toMsgFormattedString(LocalDateTime datetime){
        return datetime.format(MsgDateTimeFormat);
    }
}
