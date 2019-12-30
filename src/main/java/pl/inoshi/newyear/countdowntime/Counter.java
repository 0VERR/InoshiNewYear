package pl.inoshi.newyear.countdowntime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Counter {
    Date date;

    public Counter(){
        String newYear = "2020/01/01 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


        {
            try {
                date = sdf.parse(newYear);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public long calculate() {

        long millis = date.getTime();
        long actualTime = System.currentTimeMillis();
        long timeCounter = millis - actualTime;

        return TimeUnit.MILLISECONDS.toSeconds(timeCounter);
    }
}
