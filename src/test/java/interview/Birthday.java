package interview;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {

    public static void main(String[] args) {

        String birDay = "2015-04-03";
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date birDate = format1.parse(birDay);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(currentTime);
            System.out.println(dateString);
            System.out.println(dateString.substring(0,4));
        } catch (ParseException e) {
            e.printStackTrace();
        }








    }

}
